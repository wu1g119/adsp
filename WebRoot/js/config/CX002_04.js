
var st00104Validator = null;

/**
 * 初始化校验
 * 
 * @author wuxiaogang
 */
function initValidateSt00104() {
	st00104Validator = $("#table_configInfo_form").validate({
		debug : false,
		errorElement : "label",
		errorContainer : $("#warning"),
		event : "blur",
		errorClass : "invalid",
		focusInvalid : false,
		rules : {
			"bean.name" : {//服务名称
				required : true,
				minlength : 3,
				maxlength : 50
			},
			"bean.note" : {//服务中文注释
				required : true,
				minlength : 3,
				maxlength : 50
			}
		},
		messages : {
			"bean.name" : {//服务名称
				required :"请输入服务名称",
				minlength :"服务名称最少3个字符",
				maxlength :"服务名称最多50个字符"
			},
			"bean.note" : {//服务中文注释
				required :"请输入服务中文注释",
				minlength :"服务中文注释最少3个字符",
				maxlength :"服务中文注释最多50个字符"
			}
		},
		ignore : ".btn",
		errorPlacement : function(error, element) {
			if (element.is(':radio') || element.is(':checkbox')) {
		          error.appendTo(element.parent().parent());
		          element.parent().parent().find("label").each(function(){
		        	  if($(this).attr("generated")=='true'){
		        		  $(this).hide();
		        	  }
		          });
		     }else{
		    	 error.appendTo(element.parent());
				element.parent().find("label").hide();
		     }
		},
		success : function(label) {
			label.addClass("valid");
		}
	});
}
