/**
 * @xiaojinlu1990@163.com
 */

/*------------------------------------公用开始----------------------------------------------*/
//关闭弹出框
function cancel_pl(idVame){
    $("#"+idVame).css("display","none");
}
//是否包含某个字符串
function  strisN(str) {
    var bo = false;
    if(str == 'String' || str == 'DATE' || str == 'Integer'){
        bo = true;
    }
    return bo;

}
//查询是否
function  selectIs(str) {
    var bo = false;
    if(str == '=' || str == 'like' || str == 'DATE'){
        bo = true;
    }
    return bo;

}
/*------------------------------------公用结束----------------------------------------------*/
/*------------------------------------概要开始----------------------------------------------*/
	var arField = new Array();
	var index = 0;


	
	//删除数组添加元素并重组列表
	function removeField(value){
	    console.log("概要"+value);
		$("#table_gai_yao_fields").html('');
        arField.splice(value,1);
        index = 0 ;
		for(var i=0;i<arField.length;i++){
            appendCMysql(arField[i]);
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

//存储所有概要信息
var arFieldMysql = new Array();
//添加mysql默认值
function arrayFieldMysql(value){
    $("#msgIndex").val(''); //判断是新增还是
    arField[index] = value;
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

    arField[msgIndex] = value;
    index = 0;
    $("#table_gai_yao_fields").html('');
    for(var i=0;i<arField.length;i++){
        appendCMysql(arField[i]);
    }
}

/*------------------------------------概要结束----------------------------------------------*/
/*------------------------------------生成mysql代码开始-------------------------------------*/

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
        '<td class="center">'+fieldarray[6]+'<input type="hidden" name="mysql5'+indexMysql+'" value="'+fieldarray[6]+'"></td>'+
        '<td class="center">'+fieldarray[7]+'<input type="hidden" name="mysql5'+indexMysql+'" value="'+fieldarray[7]+'"></td>'+
        '<td class="center">'+
        '<input type="hidden" name="mysql'+indexMysql+'" value="'+value+'">'+
        '<a class="btn btn-mini btn-info" title="编辑" onclick="editFieldMysqlTap(\''+value+'\',\''+indexMysql+'\')"><i class="icon-edit"></i></a>&nbsp;'+
        '<a class="btn btn-mini btn-danger" title="删除" onclick="removeFieldTap(\''+indexMysql+'\')"><i class="icon-trash"></i></a>'+
        '</td>'+
        '</tr>'
    );

    indexMysql++;
    console.log('mysql编码='+indexMysql);
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
    if(efieldarray[6] == '是'){
        $("#mysql_form-sel-radio1").attr("checked",true);

        $("#mysql_form-sel-radio2").removeAttr("checked");
    }else{
        $("#mysql_form-sel-radio2").attr("checked",true);
        $("#mysql_form-sel-radio1").removeAttr("checked");
    }
    $("#mysql_default_sel").val(efieldarray[7]); 	 //查询类型
}
//删除数组添加元素并重组列表
function removeFieldTap(value){
    $("#table_mysql_fields").html('');
    arFieldMysqlTap.splice(value,1);
    indexMysql = 0;  //初始化为0
    for(var i=0;i<arFieldMysqlTap.length;i++){
        appendCMysqlTap(arFieldMysqlTap[i]);
    }
}

//保存编辑属性
function saveDMysqltap(){
    var mysqlAttributeTap	  = $("#mysql_attribute_tap").val();   	 		 //属性名
    var mysqlChineTap = $("#mysql_chine_tap").val(); 	 //属性中文
	var mysqlTypeTap	  = $("#mysql_type_tap").val();   	 		 //类型
    var mysqlDefaultTap = $("#mysql_default_tap").val(); 	 //默认值
    var mysqlFormTapRadiot	  = $("input[name='mysql_form-tap-radiot']:checked").val();  	 		 //是否允许为空
    var mysqlFormKeyRadiot	  = $("input[name='mysql_form-key-radiot']:checked").val();  	 		 //是否为主键
    var mysqlFormSelRadiot	  = $("input[name='mysql_form-sel-radiot']:checked").val(); 	 		 //是否为查询
    var mysqlDefaultSel = $("#mysql_default_sel").val();  	 		 //查询类型
   if(!strisN(mysqlTypeTap)){
       alert("类型只能为String,DATE,Integer");
       return;
   }

    if(!selectIs(mysqlDefaultSel)){
        alert("类型只能为=,DATE,like");
        return;
    }
    var fields = mysqlAttributeTap+',fh,' + mysqlChineTap + ',fh,' + mysqlTypeTap+ ',fh,' + mysqlDefaultTap+ ',fh,' + mysqlFormTapRadiot+ ',fh,' + mysqlFormKeyRadiot+',fh,'+mysqlFormSelRadiot+',fh,'+mysqlDefaultSel;
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
    indexMysql = 0;
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
/*------------------------------------生成mysql代码结束-------------------------------------*/

/*------------------------------------生成Entity代码开始-------------------------------------*/

var arFieldEntityTap = new Array();
var indexEntity = 0;


//打开entity编辑属性(新增)
function entity_dialog_open(){
    $("#entity_attribute_tap").val('');   	 		 //属性名
    $("#entity_chine_tap").val(''); 	 //属性中文
    $("#entity_type_tap").val('');   	 		 //类型
    $("#entity_default_tap").val(''); 	 //默认值
    $("input[name='entity_form-tap-radiot']:checked").val();  	 		 //是否允许为空
    $("input[name='entity_form-key-radiot']:checked").val();  	 		 //是否为主键

    $("#entityIndexTap").val('');//置为空标识新增

    $("#entity_form-key-radio2").attr("checked",true);
    $("#entity_form-tap-radio2").attr("checked",true);
    $("#entity_dialog-add_tap").css("display","block");
}

//保存编辑属性
function saveDentitytap(){
    var entityAttributeTap	  = $("#entity_attribute_tap").val();   	 		 //属性名
    var entityChineTap = $("#entity_chine_tap").val(); 	 //属性中文
    var entityTypeTap	  = $("#entity_type_tap").val();   	 		 //类型
    var entityDefaultTap = $("#entity_default_tap").val(); 	 //默认值
    var entityFormTapRadiot	  = $("input[name='entity_form-tap-radiot']:checked").val();;   	 		 //是否允许为空
    var entityFormKeyRadiot	  = $("input[name='entity_form-key-radiot']:checked").val();;   	 		 //是否为主键


    var fields = entityAttributeTap+',fh,' + entityChineTap + ',fh,' + entityTypeTap+ ',fh,' + entityDefaultTap+ ',fh,' + entityFormTapRadiot+ ',fh,' + entityFormKeyRadiot ;
    //獲取编辑的Id
    var entityIndexTap = $("#entityIndexTap").val();
    if(entityIndexTap == ''){
        console.log("添加");
        arrayFieldEntityTap(fields);
    }else{
        console.log("修改");
        editArrayFieldentityTap(fields,entityIndexTap);  //修改初始化内容
    }


    $("#entity_dialog-add_tap").css("display","none");

}


function arrayFieldEntityTap(value){
    $("#entityIndexTap").val(''); //判断是新增还是
    arFieldEntityTap[indexEntity] = value;
    console.log(arFieldEntityTap.length+"entity開始")
    appendCEntityTap(value);
}



//追加属性列表
function appendCEntityTap(value){
    var fieldarray = value.split(',fh,');
    $("#table_entity_fields").append(
        '<tr>'+
        '<td class="center" style="width: 200px">'+fieldarray[0]+'<input type="hidden" name="entity0'+index+'" value="'+fieldarray[0]+'"></td>'+
        '<td class="center">'+fieldarray[1]+'<input type="hidden" name="entity1'+indexEntity+'" value="'+fieldarray[1]+'"></td>'+
        '<td class="center">'+fieldarray[2]+'<input type="hidden" name="entity2'+indexEntity+'" value="'+fieldarray[2]+'"></td>'+
        '<td class="center">'+fieldarray[3]+'<input type="hidden" name="entity3'+indexEntity+'" value="'+fieldarray[3]+'"></td>'+
        '<td class="center">'+fieldarray[4]+'<input type="hidden" name="entity4'+indexEntity+'" value="'+fieldarray[4]+'"></td>'+
        '<td class="center">'+fieldarray[5]+'<input type="hidden" name="entity5'+indexEntity+'" value="'+fieldarray[5]+'"></td>'+
        '<td class="center">'+
        '<input type="hidden" name="entity'+indexEntity+'" value="'+value+'">'+
        '<a class="btn btn-mini btn-info" title="编辑" onclick="editFieldEntityTap(\''+value+'\',\''+indexEntity+'\')"><i class="icon-edit"></i></a>&nbsp;'+
        '<a class="btn btn-mini btn-danger" title="删除" onclick="removeFieldEntityTap(\''+indexEntity+'\')"><i class="icon-trash"></i></a>'+
        '</td>'+
        '</tr>'
    );

    indexEntity++;
    console.log('实体编码='+indexEntity);
    $("#entityIndexTap").val(indexEntity);
}


//删除数组添加元素并重组列表
function removeFieldEntityTap(value){
    $("#table_entity_fields").html('');
    arFieldEntityTap.splice(value,1);
    indexEntity = 0;  //初始化为0
    for(var i=0;i<arFieldEntityTap.length;i++){
        appendCMysqlTap(arFieldEntityTap[i]);
    }
}

function editFieldEntityTap(value,msgIndex){
    $("#entity_dialog-add").css("display","block");
    $("#entityIndexTap").val(msgIndex);//添加mysql隐藏的id
    var efieldarray = value.split(',fh,');
    $("#mysql_dbz").val(efieldarray[1]);
    $("#mysql_ddefault").val(efieldarray[2]);
    if(efieldarray[0] == '是'){
        $("#entity_form-field-radio1").attr("checked",true);

        $("#entity_form-field-radio2").removeAttr("checked");
    }else{
        $("#entity_form-field-radio2").attr("checked",true);
        $("#entity_form-field-radio1").removeAttr("checked");
    }
}


/*------------------------------------生成Entity代码结束-------------------------------------*/



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

    //项目名
    var objectName = $("#objectName").val();
    var tabletop = $("#tabletop").val();  //类名
    var objectRemark = $("#objectRemark").val();//备注
    if (objectName == ''){
        alert("项目名不能为空");
        $("#objectName").focus();
        return;
    }
    if (tabletop == ''){
        alert("类名不能为空");
        $("#tabletop").focus();
        return;
    }
    if (objectRemark == ''){
        alert("备注不能为空");
        $("#objectRemark").focus();
        return;
    }




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
