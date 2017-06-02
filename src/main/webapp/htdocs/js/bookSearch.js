$(document).ready(function(){


  	var initCss=function(){
  		$("#new-books").addClass("select-tab");
  		$("#type-books").removeClass("select-tab");
  	}

  	var typeTabCss=function(){
  		$("#type-books").addClass("select-tab");
  		$("#new-books").removeClass("select-tab");
  	}
  	var bindInfo =function(){
  		$(".J-books-li").on("click",function(data){
	  			that = this;
				location.href = "/bookInfo.htm?id="+$(that).attr("data-value")
			});  
  	}

	var showBooks = function(key){
  		$.get("/bookSearch.json?key="+key,function(data,status){
		   	var list = data.booklist;
	  		var lis = getBookList(list);
	  		$("#books-ul").html(lis);
	  		bindInfo();
		  });
  	}

  	var showTypes = function(){
		$.get("/bookTypes.json",function(data,status){
		    var lis ="";
		   	var list = data.typelist;
	  		for (var i = 0; i < list.length; i++) {
	  				lis+='<li class="book-type-li" >'
	                       +'<div class="img-wrap">'
	                         +'<div class="book-text type-li" data-value="1"><nobr>'+list[i]+'</nobr></div>'
	                      +' </div>'
	                    +' </li>';
 
	  		};
	  		$("#books-ul").html(lis);
	  		$(".type-li").on("click",function(data){
			  		typeTabCss();
			  		searchBookByTypes($(this).attr("data-value"));
			  	});   
		  }); 
  	}

  	var searchBookByTypes = function(type){
		$.get("/bookSearchByType.json?type="+type,function(data,status){
			$("#search-key").html("");
		   	var list = data.booklist;
	  		var lis = getBookList(list);
	  		$("#books-ul").html(lis);
	  		bindInfo();
		  });
  	}

  	var getBookList =function(list){
		var lis ="";
	   	if(!list){
	   		return;
	   	}
  		for (var i = 0; i < list.length; i++) {
  				lis+='<li class="books-li J-books-li" data-value="'+ list[i].id +'"">'
                       +'<div class="img-wrap">'
                         +'<div class="img-container">'
                           +'<img src="'+list[i].pic+'">'
                         +'</div>'
                         +'<div class="book-text"><nobr>'+list[i].bookTitile+'</nobr></div>'
                      +' </div>'
                    +' </li>';

  		};
  		
  		return lis;
  	}


  	////////////////////////////////////////////////////////////////////

	// 初始化列表
	showBooks("")

	// 点击搜索
  	$("#search-book").click(function(data){
  		initCss();
  		showBooks($("#search-key").val());
  	});

  	// 点击新书
  	$("#new-books").click(function(data){
  		initCss();
  		showBooks("")
  	});

  	// 点击分类
  	$("#type-books").click(function(data){
  		typeTabCss();
  		showTypes();
  	});

  	$(".book-type-li").click(function(data){
  		typeTabCss();
  		showBooks("");
  	});



});

