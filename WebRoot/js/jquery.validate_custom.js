jQuery.validator.addMethod("checkUserId",
	    function(value, element) {
	        var exp = new RegExp("^[a-zA-Z\\d\u4e00-\u9fa5][a-zA-Z\\d\u4e00-\u9fa5_]{0,10}[a-zA-Z\\d\u4e00-\u9fa5]$");
	        return exp.test(value);
	    },
	    "用户名输入不正确");

jQuery.validator.addMethod("checkPass",
	    function(value, element) {
	        var exp = new RegExp("^[a-zA-Z\\d_]{6,16}$");
	        return exp.test(value);
	    },
	    "密码输入不正确");

jQuery.validator.addMethod("checkMemberId",
	    function(value, element) {
		var exp = new RegExp("^[a-zA-Z\\d]{8,10}$");
	        return exp.test(value);
	    },
	    "会员卡号输入不正确");

jQuery.validator.addMethod("checkMobile",
	    function(value, element) {
	        var exp = new RegExp("^[1][3-8]+\\d{9}$");
	        return exp.test(value);
	    },
	    "手机号码输入不正确");

jQuery.validator.addMethod("checkMobileCode",
	    function(value, element) {
	        var exp = new RegExp("^[a-z\\d]{6}$");
	        return exp.test(value);
	    },
	    "手机认证码输入不正确");

jQuery.validator.addMethod("checkMail",
	    function(value, element) {
	        var exp = new RegExp("^([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
	        return exp.test(value);
	    },
	    "E-mail输入不正确");
   
jQuery.validator.addMethod("byteRangeLength", 
		function(value, element, param) {       
		   	var length = value.length;       
		    for(var i = 0; i < value.length; i++){       
		        if(value.charCodeAt(i) > 127) {       
		        	length++;       
		        }       
		    }       
		    return this.optional(element) || ( length >= param[0] && length <= param[1] );
	   }, 
	   "输入值的长度不正确"); 


