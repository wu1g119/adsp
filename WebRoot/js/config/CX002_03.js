/**
 * 校验
 * 
 * @author wuxiaogang
 */
function checkSt0103(){
	/*
	try{
		//主表
		var man_table_name=$('#man_table_name').val();
		//主表主键
		var falg = 0;
		$('.'+man_table_name.replace(new RegExp('\\.', 'g'),'_')).each(function(){ 
			//主键选中
			if($(this).attr("checked")){
				falg=1;
			}else{
				falg=0;
				return false;
			}
		});
		if(falg==0){
			myAlert('主表主键必须[全部选中]!');
			return false;
		}
		falg=0;
		//别名
		$('input[name=columns_name]:checkbox').each(function(){ 
			//主键选中
			if($(this).attr("checked")){
				//字段
				var columns=($(this).attr("value"));
				//字段别名
				var columns_alias=$('#columns_alias_'+columns.replace(new RegExp('\\.', 'g'),'_')).attr("value");
//				myAlert("========================="+columns_alias);
//				myAlert("xxxxxxxxxxx========"+/^[^0-9]\w*$/.test(columns_alias));
				//判断别名是否符合规则
				if(/^[^0-9]\w*$/.test(columns_alias)==true){
					falg++;
				}else{
					falg=0;
					return false;
				}
			}
		});
		if(falg<1){
			myAlert('别名不能为空, 且不能以[数字]开头!');
			return false;
		}
		return true;
	}catch(e){
		myAlert(e);
	}
	*/
	return true;
}