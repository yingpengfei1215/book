package com.manage.book.controller.page;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.manage.book.controller.form.UserInfoForm;
import com.manage.book.core.book.UserInfoService;
import com.manage.book.core.result.BaseResult;
import com.manage.book.util.BeanCovertUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.manage.book.controller.base.BaseController;
import com.manage.book.dal.daointerface.AddressInfoDOMapper;
import com.manage.book.dal.daointerface.AppAreaDOMapper;
import com.manage.book.dal.daointerface.BookTypeDOMapper;
import com.manage.book.dal.daointerface.UserInfoDOMapper;
import com.manage.book.dal.dataobject.AddressInfoDO;
import com.manage.book.dal.dataobject.AppAreaDO;
import com.manage.book.dal.dataobject.BookTypeDO;
import com.manage.book.dal.dataobject.UserInfoDO;
import com.manage.book.util.string.StringUtil;

/**
 * @author pengfei.ypf
 * @version \$Id: UserInfoController.java, v 0.1 2017-05-28 16:26 pengfei.ypf Exp $$
 */
@Controller
@RequestMapping("/")
public class UserInfoController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoDOMapper userInfoDoMapper;
    @Autowired
    private AddressInfoDOMapper addressInfoDOMapper;
    @Autowired
    private AppAreaDOMapper appAreaDOMapper;
    @Autowired
    private BookTypeDOMapper bookTypeDOMapper;

    @Autowired
    private UserInfoService userInfoService;


    /**
     * @param modelMap
     * @param id
     * @return
     */
    @RequestMapping(value = "/userInfo.htm", method = RequestMethod.GET)
    public ModelAndView index(ModelMap modelMap, String id, String type) {

        String provinceCode = "110000";
        String cityCode = "110100";
        List<String> preferencesList = new ArrayList<String>();
        if (StringUtil.isNotBlank(id)) {
            modelMap.put("name", id);
            UserInfoDO userinfo = userInfoDoMapper.selectByPrimaryKey(Integer.parseInt(id));
            AddressInfoDO add = new AddressInfoDO();
            add.setId(userinfo.getUserAddress());
            AddressInfoDO address = addressInfoDOMapper.getAddressInfo(add);
            modelMap.put("userinfo", userinfo);
            modelMap.put("address", address);

            provinceCode = address.getProvinceCode();
            cityCode = address.getCityCode();
            String[] preferences = userinfo.getPreferenceType().split(",");
            preferencesList = Arrays.asList(preferences);
        }

        //地址
        List<AppAreaDO> provinces = new ArrayList<AppAreaDO>();
        List<AppAreaDO> cities = new ArrayList<AppAreaDO>();
        List<AppAreaDO> areas = new ArrayList<AppAreaDO>();
        List<AppAreaDO> areasAll = appAreaDOMapper.getAppArea(new AppAreaDO());
        for (AppAreaDO appAreaDO : areasAll) {
            if (appAreaDO.getnLevel() == 1) {
                provinces.add(appAreaDO);
            }
            if (appAreaDO.getnLevel() == 2 && appAreaDO.getvUpcode().equals(provinceCode)) {
                cities.add(appAreaDO);
            }
            if (appAreaDO.getnLevel() == 3 && appAreaDO.getvUpcode().equals(cityCode)) {
                areas.add(appAreaDO);
            }
        }
        modelMap.put("provinces", provinces);
        modelMap.put("cities", cities);
        modelMap.put("areas", areas);

        // type
        BookTypeDO booktype = new BookTypeDO();
        booktype.setnLevel(1);
        List<BookTypeDO> bookTypes = bookTypeDOMapper.getBookType(booktype);

        List<BookTypeDO> bookTypesModified = new ArrayList<BookTypeDO>();
        for (BookTypeDO typeinfo : bookTypes) {
            if (preferencesList.contains(typeinfo.getvCode())) {
                typeinfo.setSelected(true);
            }

            bookTypesModified.add(typeinfo);
        }
        modelMap.put("preferenceType", bookTypesModified);
        if (StringUtil.isBlank(type)) {
            type = "add";
        }
        modelMap.put("type", type);

        return new ModelAndView("templates/home/project/page/userinfo.vm");
    }

    /**
     * 获取地理位置  市
     *
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/area_findCity.htm", method = RequestMethod.GET)
    public ModelAndView area_findCity(HttpServletResponse response, ModelMap modelMap, String province_code) {
        AppAreaDO city = new AppAreaDO();
        city.setvUpcode(province_code);
        List<AppAreaDO> cities = appAreaDOMapper.getAppArea(city);
        AppAreaDO area = new AppAreaDO();
        area.setvUpcode(cities.get(0).getvCode());
        List<AppAreaDO> areas = appAreaDOMapper.getAppArea(area);
        modelMap.put("cities", cities);
        modelMap.put("areas", areas);

        StringBuffer sb = new StringBuffer();
        for (AppAreaDO appAreaDO : cities) {
            sb.append("<option value=" + appAreaDO.getvCode() + " #if($address.cityCode==$item.vCode) select  #end>" + appAreaDO.getvName() + "</option>");
        }
        writeJsonStr(response, sb.toString());
        return new ModelAndView("templates/home/project/page/userinfo.vm");
    }

    /**
     * 区
     *
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/area_findDistrict.htm", method = RequestMethod.GET)
    public ModelAndView area_findDistrict(HttpServletResponse response, ModelMap modelMap, String type, String city_code, String province_code) {
        List<AppAreaDO> areas = new ArrayList<AppAreaDO>();
        AppAreaDO area = new AppAreaDO();
        if (StringUtil.isNotEmpty(province_code)) {
            area.setvUpcode(province_code);
            areas = appAreaDOMapper.getAppArea(area);
            AppAreaDO ar = areas.get(0);
            area.setvUpcode(ar.getvCode());
            areas = appAreaDOMapper.getAppArea(area);
        } else {
            area.setvUpcode(city_code);
            areas = appAreaDOMapper.getAppArea(area);
        }

        modelMap.put("areas", areas);
        StringBuffer sb = new StringBuffer();

        for (AppAreaDO appAreaDO : areas) {
            sb.append("<option value=" + appAreaDO.getvCode() + " #if($address.cityCode==$item.vCode) select  #end>" + appAreaDO.getvName() + "</option>");
        }
        writeJsonStr(response, sb.toString());
        return new ModelAndView("templates/home/project/page/userinfo.vm");
    }


    @RequestMapping(value = "/save_userinfo.htm", method = RequestMethod.GET)
    public ModelAndView save_userinfo(HttpServletResponse response, ModelMap modelMap, Integer id, String userName, String phoneNo, String userEmail, String sex, String province_code, String city_code, String area_code, String address, String preferences) {
        UserInfoDO userinfo = new UserInfoDO();
        userinfo.setId(id);
        userinfo.setUserName(userName);
        userInfoDoMapper.updateByPrimaryKey(userinfo);
        return new ModelAndView("templates/home/project/page/userinfo.vm");
    }

    @RequestMapping(value = "/save_userinfo2.json", method = RequestMethod.POST)
    public void update_userinfo(HttpServletResponse response, ModelMap modelMap, UserInfoForm form) {
        System.out.println(form.toString());
        BaseResult result = userInfoService.saveUserInfo(form);
        writeJson(response, result);
    }

//    @RequestMapping(value = "/save_userinfo_add.json", method = RequestMethod.POST)
//    public void save_userinfo(HttpServletResponse response, ModelMap modelMap, UserInfoForm form) {
//
//        System.out.println(form.toString());
//        UserInfoDO userinfo = BeanCovertUtil.beanCovert(from, UserInfoDO.class);
//        userInfoDoMapper.insert(userinfo);
//        modelMap.put("result", "S");
//        writeJson(response, modelMap);
//    }

}
