// guid
function guid() {
	var S4 = function() {
		return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
	};
	return 'uuid'+(S4() + S4() +  S4() +  S4() +  S4() +  S4()
			+ S4() + S4());
}
//是否被选中验证有选中的return true,否return false 
function checkInfo(name,type){ 
	var falg = 0; 
	$("input[name="+name+"]:"+type).each(function(){ 
		if($(this).attr("checked")){
			falg +=1;
			return false;
		} 
	}); 
	if(falg>0){
		return true; 
	} 
	return false; 
}
// 复制到剪切板
function copy_clip(s) {
	 //alert(s);
    if(window.clipboardData){
       window.clipboardData.setData("Text",s);
       alert("已经复制到剪切板！"+s);
    }else if(navigator.userAgent.indexOf("Opera") != -1) {  
       window.location = s;  
    }else if(window.netscape) {  
        try {  
            netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");  
        } catch (e) {  
            alert("被浏览器拒绝！\n请在浏览器地址栏输入'about:config'并回车\n然后将'signed.applets.codebase_principal_support'设置为'true'");  
        }  
        var clip = Components.classes['@mozilla.org/widget/clipboard;1'].createInstance(Components.interfaces.nsIClipboard);  
        if (!clip)  
            return;  
        var trans = Components.classes['@mozilla.org/widget/transferable;1'].createInstance(Components.interfaces.nsITransferable);  
        if (!trans)  
            return;  
        trans.addDataFlavor('text/unicode');  
        var str = new Object();  
        var len = new Object();  
        var str = Components.classes["@mozilla.org/supports-string;1"].createInstance(Components.interfaces.nsISupportsString);  
        var copytext = s;  
        str.data = copytext;  
        trans.setTransferData("text/unicode",str,copytext.length*2);  
        var clipid = Components.interfaces.nsIClipboard;  
        if (!clip)  
            return false;  
        clip.setData(trans,null,clipid.kGlobalClipboard);  
        alert("已经复制到剪切板！"+"\n"+s)  
    }
}
