/**
 * @xiaojinlu1990@163.com
 */	

	var arField = new Array();
	var index = 0;
	//追加属性列表
	function appendC(value){
		
		var fieldarray = value.split(',fh,');
		
		$("#fields").append(
			'<tr>'+
			'<td class="center">'+fieldarray[0]+'<input type="hidden" name="field0'+index+'" value="'+fieldarray[0]+'"></td>'+
			'<td class="center">'+fieldarray[1]+'<input type="hidden" name="field1'+index+'" value="'+fieldarray[1]+'"></td>'+
			'<td class="center">'+fieldarray[2]+'<input type="hidden" name="field2'+index+'" value="'+fieldarray[2]+'"></td>'+
			'<td class="center">'+fieldarray[3]+'<input type="hidden" name="field3'+index+'" value="'+fieldarray[3]+'"></td>'+
			'<td class="center">'+fieldarray[4]+'<input type="hidden" name="field4'+index+'" value="'+fieldarray[4]+'"></td>'+
			'<td class="center">'+
				'<input type="hidden" name="field'+index+'" value="'+value+'">'+
				'<a class="btn btn-mini btn-info" title="编辑" onclick="editField(\''+value+'\',\''+index+'\')"><i class="icon-edit"></i></a>&nbsp;'+
				'<a class="btn btn-mini btn-danger" title="删除" onclick="removeField(\''+index+'\')"><i class="icon-trash"></i></a>'+
			'</td>'+
			'</tr>'
		);
		index++;
		$("#zindex").val(index);
	}
	
	//保存属性后往数组添加元素
	function arrayField(value){
		arField[index] = value;
		appendC(value);
	}
	
	//修改属性
	function editArrayField(value,msgIndex){
		arField[msgIndex] = value;
		$("#fields").html('');
		for(var i=0;i<arField.length;i++){
			appendC(arField[i]);
		}
	}
	
	//删除数组添加元素并重组列表
	function removeField(value){
		$("#fields").html('');
		arField.splice(value,1);
		for(var i=0;i<arField.length;i++){
			appendC(arField[i]);
		}
	}
	
	//判断属性名是否重复
	function isSame(value){
		for(var i=0;i<arField.length;i++){
			var array0 = arField[i].split(',fh,')[0];
			if(array0 == value){
				return false;
			}
		}
		return true;
	}

/*第二版js*/
//概要
//存储所有概要信息
var arFieldMysql = new Array();
//添加mysql默认值
function arrayFieldMysql(value){
    $("#msgIndex").val(''); //判断是新增还是
    arFieldMysql[index] = value;
    appendCMysql(value);
}
//追加属性列表

function appendCMysql(value){
    var fieldarray = value.split(',fh,');
    $("#table_gai_yao_fields").append(
        '<tr>'+
        '<td class="center" style="width: 200px">'+fieldarray[0]+'<input type="hidden" name="field0'+index+'" value="'+fieldarray[0]+'"></td>'+
        '<td class="center">'+fieldarray[1]+'<input type="hidden" name="field1'+index+'" value="'+fieldarray[1]+'"></td>'+
        '<td class="center">'+fieldarray[2]+'<input type="hidden" name="field2'+index+'" value="'+fieldarray[2]+'"></td>'+
        '<td class="center">'+
        '<input type="hidden" name="field'+index+'" value="'+value+'">'+
        '<a class="btn btn-mini btn-info" title="编辑" onclick="editFieldMysql(\''+value+'\',\''+index+'\')"><i class="icon-edit"></i></a>&nbsp;'+
        '<a class="btn btn-mini btn-danger" title="删除" onclick="removeField(\''+index+'\')"><i class="icon-trash"></i></a>'+
        '</td>'+
        '</tr>'
    );

    index++;
    $("#mysqlIndex").val(index);
}

//打开编辑属性(修改)
function editFieldMysql(value,msgIndex){
    $("#mysql_dialog-add").css("display","block");
	$("#mysqlIndex").val(msgIndex);//添加mysql隐藏的id
    var efieldarray = value.split(',fh,');
    $("#mysql_dbz").val(efieldarray[1]);
    $("#mysql_ddefault").val(efieldarray[2]);
    if(efieldarray[0] == '是'){
        $("#mysql_form-field-radio1").attr("checked",true);

        $("#mysql_form-field-radio2").removeAttr("checked");
    }else{
        $("#mysql_form-field-radio2").attr("checked",true);
        $("#mysql_form-field-radio1").removeAttr("checked");
    }
}


//保存编辑属性
function saveDMysql(){

    var mysqlFormFieldRadiot	  = $("input[name='mysql_form-field-radiot']:checked").val();;   	 		 //是否生成
    var mysql_dbz	  = $("#mysql_dbz").val();   	 		 //模板类型
    var mysql_ddefault = $("#mysql_ddefault").val(); 	 //模板路径

    var fields = mysqlFormFieldRadiot+',fh,' + mysql_dbz + ',fh,' + mysql_ddefault ;
    //獲取编辑的Id
    var mysqlIndex = $("#mysqlIndex").val();

	editArrayFieldMysql(fields,mysqlIndex);  //修改初始化内容

    $("#mysql_dialog-add").css("display","none");

}




//修改属性
function editArrayFieldMysql(value,msgIndex){

    arFieldMysql[0] = value;
    index = 0;
    $("#table_gai_yao_fields").html('');
    for(var i=0;i<arFieldMysql.length;i++){
        appendCMysql(arFieldMysql[i]);
    }
}


/*--------------------------------生成mysql代码-----------------------------------*/

var arFieldMysqlTap = new Array();
var indexMysql = 0;
function arrayFieldMysqlTap(value){
    $("#mysqlIndexTap").val(''); //判断是新增还是
    arFieldMysqlTap[indexMysql] = value;
    console.log(arFieldMysqlTap.length+"mysql開始")
    appendCMysqlTap(value);
}


//追加属性列表
function appendCMysqlTap(value){
    var fieldarray = value.split(',fh,');
    $("#table_mysql_fields").append(
        '<tr>'+
        '<td class="center" style="width: 200px">'+fieldarray[0]+'<input type="hidden" name="mysql0'+index+'" value="'+fieldarray[0]+'"></td>'+
        '<td class="center">'+fieldarray[1]+'<input type="hidden" name="mysql1'+indexMysql+'" value="'+fieldarray[1]+'"></td>'+
        '<td class="center">'+fieldarray[2]+'<input type="hidden" name="mysql2'+indexMysql+'" value="'+fieldarray[2]+'"></td>'+
        '<td class="center">'+fieldarray[3]+'<input type="hidden" name="mysql3'+indexMysql+'" value="'+fieldarray[3]+'"></td>'+
        '<td class="center">'+fieldarray[4]+'<input type="hidden" name="mysql4'+indexMysql+'" value="'+fieldarray[4]+'"></td>'+
        '<td class="center">'+fieldarray[5]+'<input type="hidden" name="mysql5'+indexMysql+'" value="'+fieldarray[5]+'"></td>'+
        '<td class="center">'+
        '<input type="hidden" name="mysql'+indexMysql+'" value="'+value+'">'+
        '<a class="btn btn-mini btn-info" title="编辑" onclick="editFieldMysqlTap(\''+value+'\',\''+indexMysql+'\')"><i class="icon-edit"></i></a>&nbsp;'+
        '<a class="btn btn-mini btn-danger" title="删除" onclick="removeFieldTap(\''+indexMysql+'\')"><i class="icon-trash"></i></a>'+
        '</td>'+
        '</tr>'
    );

    indexMysql++;
    $("#mysqlIndexTap").val(indexMysql);
}

//打开编辑属性(修改)
function editFieldMysqlTap(value,msgIndex){
    $("#mysql_dialog-add_tap").css("display","block");
    $("#mysqlIndexTap").val(msgIndex);//添加mysql隐藏的id
    var efieldarray = value.split(',fh,');

    $("#mysql_attribute_tap").val(efieldarray[0]);   	 		 //属性名
    $("#mysql_chine_tap").val(efieldarray[1]); 	 //属性中文
    $("#mysql_type_tap").val(efieldarray[2]);   	 		 //类型
    $("#mysql_default_tap").val(efieldarray[3]); 	 //默认值
    $("input[name='mysql_form-tap-radiot']:checked").val();  	 		 //是否允许为空
    $("input[name='mysql_form-key-radiot']:checked").val();  	 		 //是否为主键


    if(efieldarray[4] == '是'){
        $("#mysql_form-tap-radio1").attr("checked",true);

        $("#mysql_form-tap-radio2").removeAttr("checked");
    }else{
        $("#mysql_form-tap-radio2").attr("checked",true);
        $("#mysql_form-tap-radio1").removeAttr("checked");
    }
    if(efieldarray[5] == '是'){
        $("#mysql_form-key-radio1").attr("checked",true);

        $("#mysql_form-key-radio2").removeAttr("checked");
    }else{
        $("#mysql_form-key-radio2").attr("checked",true);
        $("#mysql_form-key-radio1").removeAttr("checked");
    }
}
//删除数组添加元素并重组列表
function removeFieldTap(value){
    $("#table_mysql_fields").html('');
    arFieldMysqlTap.splice(value,1);
    for(var i=0;i<arFieldMysqlTap.length;i++){
        appendC(arFieldMysqlTap[i]);
    }
}

//保存编辑属性
function saveDMysqltap(){
    var mysqlAttributeTap	  = $("#mysql_attribute_tap").val();   	 		 //属性名
    var mysqlChineTap = $("#mysql_chine_tap").val(); 	 //属性中文
	var mysqlTypeTap	  = $("#mysql_type_tap").val();   	 		 //类型
    var mysqlDefaultTap = $("#mysql_default_tap").val(); 	 //默认值
    var mysqlFormTapRadiot	  = $("input[name='mysql_form-tap-radiot']:checked").val();;   	 		 //是否允许为空
    var mysqlFormKeyRadiot	  = $("input[name='mysql_form-key-radiot']:checked").val();;   	 		 //是否为主键


    var fields = mysqlAttributeTap+',fh,' + mysqlChineTap + ',fh,' + mysqlTypeTap+ ',fh,' + mysqlDefaultTap+ ',fh,' + mysqlFormTapRadiot+ ',fh,' + mysqlFormKeyRadiot ;
    //獲取编辑的Id
    var mysqlIndexTap = $("#mysqlIndexTap").val();
    if(mysqlIndexTap == ''){
        console.log("添加");
        arrayFieldMysqlTap(fields);
    }else{
        console.log("修改");
       editArrayFieldMysqlTap(fields,mysqlIndexTap);  //修改初始化内容
    }


    $("#mysql_dialog-add_tap").css("display","none");

}

//修改属性
function editArrayFieldMysqlTap(value,mysqlIndexTap){
    arFieldMysqlTap[mysqlIndexTap] = value;
    $("#table_mysql_fields").html('');
    for(var i=0;i<arFieldMysqlTap.length;i++){
        appendCMysqlTap(arFieldMysqlTap[i]);
    }
}

//打开mysql编辑属性(新增)
function mysql_dialog_open(){
    $("#mysql_attribute_tap").val('');   	 		 //属性名
    $("#mysql_chine_tap").val(''); 	 //属性中文
    $("#mysql_type_tap").val('');   	 		 //类型
    $("#mysql_default_tap").val(''); 	 //默认值
    $("input[name='mysql_form-tap-radiot']:checked").val();  	 		 //是否允许为空
    $("input[name='mysql_form-key-radiot']:checked").val();  	 		 //是否为主键

    $("#mysqlIndexTap").val('');//置为空标识新增

    $("#mysql_form-key-radio2").attr("checked",true);
    $("#mysql_form-tap-radio2").attr("checked",true);
    $("#mysql_dialog-add_tap").css("display","block");
}


/*生成代码*/

//生成
function saveAll(){

	/*if($("#packageName").val()==""){
	 $("#packageName").tips({
	 side:3,
	 msg:'输入包名',
	 bg:'#AE81FF',
	 time:2
	 });
	 $("#packageName").focus();
	 return false;
	 }else{
	 var pat = new RegExp("^[A-Za-z]+$");
	 if(!pat.test($("#packageName").val())){
	 $("#packageName").tips({
	 side:3,
	 msg:'只能输入字母',
	 bg:'#AE81FF',
	 time:2
	 });
	 $("#packageName").focus();
	 return false;
	 }
	 }*/

    /*if($("#objectName").val()==""){
        $("#objectName").tips({
            side:3,
            msg:'输入类名',
            bg:'#AE81FF',
            time:2
        });
        $("#objectName").focus();
        return false;
    }else{
        var headstr = $("#objectName").val().substring(0,1);
        var pat = new RegExp("^[a-z0-9]+$");
        if(pat.test(headstr)){
            $("#objectName").tips({
                side:3,
                msg:'类名首字母必须为大写字母或下划线',
                bg:'#AE81FF',
                time:2
            });
            $("#objectName").focus();
            return false;
        }
    }

    if($("#fields").html() == ''){
        $("#table_report").tips({
            side:3,
            msg:'请添加属性',
            bg:'#AE81FF',
            time:2
        });
        return false;
    }*/

    if(!confirm("确定要生成吗?")){
        return false;
    }

    $("#FormAll").submit();

/*    $("#productcAll").tips({
        side:3,
        msg:'提交成功,等待下载',
        bg:'#AE81FF',
        time:9
    });*/
   // window.parent.jzts();
    //setTimeout("top.Dialog.close()",10000);

}
