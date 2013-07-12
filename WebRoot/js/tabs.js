//切换js
$(document).ready(function(){
	$("#tabs-panel > div:not(:first)").hide();
	var myLi = $("#tabs-nav > ul > li");
	var myDiv =$("#tabs-panel > div");
	myLi.each(function(i){
		$(this).mouseover(function(){
			myLi.removeClass("hover");
			$(this).addClass("hover");
			myDiv.hide();
			myDiv.eq(i).show();
		});
	});
	$("#tabs-panel2 > div:not(:first)").hide();
	var myLi2 = $("#tabs-nav2 > ul > li");
	var myDiv2 =$("#tabs-panel2 > div");
	myLi2.each(function(i){
		$(this).click(function(){
			myLi2.removeClass("hover");
			$(this).addClass("hover");
			myDiv2.hide();
			myDiv2.eq(i).show();
		});
	});
	$("#tabs-panel3");
	var myLi3 = $("#tabs-nav2 > ul > li");
	myLi3.each(function(i){
		$(this).click(function(){
			myLi3.removeClass("hover");
			$(this).addClass("hover");
		});
	});
});
