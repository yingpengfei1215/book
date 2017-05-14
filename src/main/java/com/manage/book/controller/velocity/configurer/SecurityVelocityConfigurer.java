/**
 *
 */
package com.manage.book.controller.velocity.configurer;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;

/**
 * @author wb-yingpf
 */
public class SecurityVelocityConfigurer extends VelocityConfigurer {

    @Override
    protected void postProcessVelocityEngine(VelocityEngine velocityEngine) {

        // 进行xss过滤,应该写点配置中，但写在文件中可以扩展
        velocityEngine.addProperty(VelocityEngine.VM_LIBRARY,
                "/headquarters/security/securitymacro.vm");
        velocityEngine
                .addProperty(
                        VelocityEngine.EVENTHANDLER_REFERENCEINSERTION,
                        "com.ying.dcs.controller.velocity.configurer.DcsSecurityReferenceInsertionEventHandler");

        super.postProcessVelocityEngine(velocityEngine);

    }

}
