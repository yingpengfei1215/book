$(document).ready(function(){

  $("#search-book").click(function(){
  		var key= $("#search-key").val();
  		 $.get("/bookSearch.json?key="+key,function(data,status){
			   var lis ="";
			   	var list = data.booklist;
		  		for (var i = 0; i < list.length; i++) {
		  				lis+='<li class="books-li">'
		                       +'<div class="img-wrap">'
		                         +'<div class="img-container">'
		                           +'<img src="'+list[i].pic+'">'
		                         +'</div>'
		                         +'<div class="book-text"><nobr>'+list[i].bookTitile+'</nobr></div>'
		                      +' </div>'
		                    +' </li>';

		  		};
		  		$("#books-ul").append(lis);
		  });

  });
});

