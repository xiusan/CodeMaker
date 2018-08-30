/*------------------------------------公用开始----------------------------------------------*/
//判断是否为空
function  str(id) {
    var fal = false;
    if($("#"+id).val() == null ||''==$("#"+id).val()){
        fal = true;
    }
    return fal;
}
//提示不能为空
function almag(msg) {
    swal("错误", msg+"不能为空!!!", "error");
}
//提示不能重复
function alRepeat(msg) {
    swal("错误", msg+"不能重复!!!", "error");
}
//提示不能重复
function alerrorms(msg) {
    swal("错误", msg, "error");
}

//获取后缀
function CheckInput(id)
{
    var  extension ="";
    var file = encodeURI(document.getElementById(id).value);
    if(file == "") {
        alerrorms("文件不能为空!");
    } else {
         extension = file.substring(file.lastIndexOf('.'), file.length).toLowerCase();

    }
    return extension;
}
/*------------------------------------公用结束----------------------------------------------*/
/*----------------------------------概要开始-----------------------------------*/
var saveFlag = undefined;
function showSave(index) {
    if (index != undefined) {
        saveFlag = "UPDATE";
        $("#gaiyao-modal-title").text("概要修改");
        $("#saveId").val(equipmentData[index].id);

        $("#saveModelType").val(equipmentData[index].modelType);
        $("#saveModelAddr").val(equipmentData[index].modelAddr);
        $("#saveModelSuffix").val(equipmentData[index].modelSuffix);

        $("#saveOrNot").val(equipmentData[index].orNot);

        if(equipmentData[index].orNot == '是'){
            console.log(equipmentData[index].orNot);
            //取消勾选
            document.getElementById('radio-2').checked=false;
            //勾选
            document.getElementById("radio-1").checked = true;
        }else{
            console.log(equipmentData[index].orNot);
            //取消勾选
            document.getElementById('radio-2').checked = true;
            //勾选
            document.getElementById("radio-1").checked = false;

        }
        $("#gaiyaoIndex").val(index);

    } else {
        console.log("INSERT");
        saveFlag = "INSERT";
        $("#gaiyao-modal-title").text("概要添加");
    }
    $("#save").modal('show');
}
//关闭（添加或更新）功能备注
function closeSave() {
    $("#saveId").val("");
    $("#saveOrNot").val("");
    $("#saveModelType").val("");
    $("#saveModelAddr").val("");
    $("#saveModelSuffix").val("");
    $("#save").modal('hide');
}
//下载模板
function downloadsh(index) {
    console.log(index);

    var url = "/codeMaker/downLode";
    var fileName = "oracle_SQL_Template.ftl";
    var form = $("<form></form>").attr("action", url).attr("method", "post");
    form.append($("<input></input>").attr("type", "hidden").attr("name", "myfile").attr("value",  equipmentData[index].modelAddr));
    form.appendTo('body').submit().remove();
}


// 添加或更新
function save() {



    if(str("saveModelType")){
        almag("模板类型");
        return;
    }
    //判断模板路径必须包含ftl
    if($("#saveModelAddr").val().indexOf("ftl") == -1){
        alerrorms("模板路后缀必须为.ftl");
        return;
    }
    //判断文件后缀必须为ftl
    if(CheckInput("savefilegei") != ".ftl"){
        alerrorms("文件名称后缀必须为.ftl");
        return;
    }
    console.log("操作数据");
        if (saveFlag == "INSERT") {
            //判断不能重复
            for(var i = 0;i<equipmentData.length;i++){
                if($("#saveModelAddr").val().trim() == equipmentData[i].modelAddr){
                    alRepeat(" 模板路径");
                    return;
                }

            }
            //上传文件
             var formData = new FormData();
             formData.append("myfile", document.getElementById("savefilegei").files[0]);
             $.ajax({
             url: "/codeMakerw/insertFile",
             type: "POST",
             data: formData,
             /**
             *必须false才会自动加上正确的Content-Type
             */
             contentType: false,
             /**
             * 必须false才会避开jQuery对 formdata 的默认处理
             * XMLHttpRequest会对 formdata 进行正确的处理
             */
             processData: false,
             success: function (data) {
             if (data.status == "true") {
             alert("上传成功！");
             }
             if (data.status == "error") {
             alert(data.msg);
             }
             $("#imgWait").hide();
             },
             error: function () {
             alert("上传失败！");
             $("#imgWait").hide();
             }
             });



             var orNot = "";
            if(document.getElementById("radio-1").checked == true){
                orNot = "是";
            }else{
                orNot = "否";
            }


             equipmentData.push({saveId: $("#saveId").val(),
                 orNot:orNot,
                 modelType:$("#saveModelType").val(),
                 modelAddr:$("#saveModelAddr").val(),
                 xin:'xin',
                 modelSuffix:$("#saveModelSuffix").val()});
            $("#table_gai_yao_fields").bootstrapTable("load",equipmentData);
            $("#mysqlIndex").val(equipmentData.length);
            console.log(equipmentData.length)
            //情空


            $("#save").modal('hide');
         } else if (saveFlag == "UPDATE") {
            console.log("更新");
            var orNot = "";
            if(document.getElementById("radio-1").checked == true){
                orNot = "是";
            }else{
                orNot = "否";
            }
            //$ajax('updateTest', saveEquipmentCallback, ($("#saveForm").serialize() || "").replace(/save/g, ""));

            index =  $("#gaiyaoIndex").val();
            console.log(index);
            equipmentData[index].id = $("#saveId").val();
            equipmentData[index].orNot = orNot;
            equipmentData[index].modelType   = $("#saveModelType").val();
            equipmentData[index].modelAddr   = $("#saveModelAddr").val();
            equipmentData[index].modelSuffix  = $("#saveModelSuffix").val();
            $("#table_gai_yao_fields").bootstrapTable("load",equipmentData)
            $("#mysqlIndex").val(equipmentData.length);
            $("#save").modal('hide');
        }

}
function delConfirm(index) {
        if(confirm("确认删除吗")){
           equipmentData.splice(index,1);
            $("#table_gai_yao_fields").bootstrapTable("load",equipmentData)
            $("#mysqlIndex").val(equipmentData.length);
        }


}
/*----------------------------------概要结束-----------------------------------*/
/*----------------------------------mysql开始-----------------------------------*/
var mysqSaveFlag = undefined;
function mysqlShowSave(index) {
    if (index != undefined) {
        mysqSaveFlag = "UPDATE";
        console.log("mysql修改");
        $("#mysql-modal-title").text("mysql修改");

        if(mysqlData[index].beEmpty == '是'){
            document.getElementById('radio-BeEmpty-2').checked=false;//取消勾选
            document.getElementById("radio-BeEmpty-1").checked = true;//勾选
        }else{
            document.getElementById('radio-BeEmpty-2').checked = true;//勾选
            document.getElementById("radio-BeEmpty-1").checked = false;//取消勾选
        }
        if(mysqlData[index].primaryKey == '是'){
            document.getElementById('radio-PrimaryKey-2').checked=false;//取消勾选
            document.getElementById("radio-PrimaryKey-1").checked = true;//勾选
        }else{
            document.getElementById('radio-PrimaryKey-2').checked = true;//勾选
            document.getElementById("radio-PrimaryKey-1").checked = false;//取消勾选
        }
        if(mysqlData[index].isQuery == '是'){
            document.getElementById('radio-IsQuery-2').checked=false;//取消勾选
            document.getElementById("radio-IsQuery-1").checked = true;//勾选
        }else{
            document.getElementById('radio-IsQuery-2').checked = true;//勾选
            document.getElementById("radio-IsQuery-1").checked = false;//取消勾选
        }
        $("#mysqlIndexflag").val(index);

        $("#saveentityId").val(mysqlData[index].id);
        $("#saveAttributeName").val(mysqlData[index].attributeName);
        $("#saveAttributeChinese").val(mysqlData[index].attributeChinese);
        $("#saveMysqlType").val(mysqlData[index].mysqlType);
        $("#saveDefaultValue").val(mysqlData[index].defaultValue);
        $("#saveQueryType").val(mysqlData[index].queryType.trim());
    } else {
        console.log("mysqlINSERT");
        $("#savemysqlId").val("");
        $("#saveAttributeName").val("");
        $("#saveAttributeChinese").val("");
        $("#saveMysqlType").val("");
        $("#saveDefaultValue").val("");
        $("#saveBeEmpty").val("");
        $("#savePrimaryKey").val("");
        $("#saveIsQuery").val("");
        $("#saveQueryType").val("");
        mysqSaveFlag = "INSERT";
        $("#mysql-modal-title").text("mysql添加");
    }
    $("#mysqlSave").modal('show');
}
//关闭（添加或更新）mysql
function mysqlCloseSave() {
    $("#mysqlSave").modal('hide');
}

// 添加或更新
function mysqlSave() {



    if(str("saveAttributeName")){ ;
        almag("属性名");
        return;
    }
    if(str("saveAttributeChinese")){
        almag("属性中文");
        return;
    }

    console.log("操作数据");
    if (mysqSaveFlag == "INSERT") {
        for(var i = 0;i<mysqlData.length;i++){
            if($("#saveAttributeName").val() ==mysqlData[i].attributeName ){
                alRepeat("mysql属性名");
                return;
            }

        }
        var beEmpty = "";
        var primaryKey = "";
        var isQuery = "";
        if(document.getElementById("radio-BeEmpty-1").checked == true){
            beEmpty = "是";
        }else{
            beEmpty = "否";
        }
        if(document.getElementById("radio-PrimaryKey-1").checked == true){
            primaryKey = "是";
        }else{
            primaryKey = "否";
        }
        if(document.getElementById("radio-IsQuery-1").checked == true){
            isQuery = "是";
        }else{
            isQuery = "否";
        }
        mysqlData.push({id:$("#savemysqlId").val(),
            attributeName:$("#saveAttributeName").val(),
            attributeChinese:$("#saveAttributeChinese").val(),
            mysqlType:$("#saveMysqlType").val(),
            defaultValue:$("#saveDefaultValue").val(),
            beEmpty:beEmpty,
            primaryKey:primaryKey,
            isQuery:isQuery,
            queryType:$("#saveQueryType").val()});
        $("#table_mysql_fields").bootstrapTable("load",mysqlData)
        //添加mysql增删要提交的值
        $("#mysqlIndexTap").val(mysqlData.length);
        console.log(mysqlData.length)
        entityData.push({id:$("#savemysqlId").val(),
            attributeName:$("#saveAttributeName").val(),
            attributeChinese:$("#saveAttributeChinese").val(),
            mysqlType:$("#saveMysqlType").val(),
            defaultValue:$("#saveDefaultValue").val(),
            beEmpty:beEmpty,
            primaryKey:primaryKey,
            isQuery:isQuery,
            queryType:$("#saveQueryType").val()});
        $("#table_entity_fields").bootstrapTable("load",entityData)

        $("#entityIndexTap").val(entityData.length);
        $("#mysqlSave").modal('hide');
    } else if (mysqSaveFlag == "UPDATE") {
        console.log("更新");
        var beEmpty = "";
        var primaryKey = "";
        var isQuery = "";
        if(document.getElementById("radio-BeEmpty-1").checked == true){
            beEmpty = "是";
        }else{
            beEmpty = "否";
        }
        if(document.getElementById("radio-PrimaryKey-1").checked == true){
            primaryKey = "是";
        }else{
            primaryKey = "否";
        }
        if(document.getElementById("radio-IsQuery-1").checked == true){
            isQuery = "是";
        }else{
            isQuery = "否";
        }

        var index = $("#mysqlIndexflag").val();
        //$ajax('updateTest', saveEquipmentCallback, ($("#saveForm").serialize() || "").replace(/save/g, ""));
        mysqlData[index].id = $("#savemysqlId").val();
        mysqlData[index].attributeName = $("#saveAttributeName").val();
        mysqlData[index].attributeChinese = $("#saveAttributeChinese").val();
        mysqlData[index].mysqlType = $("#saveMysqlType").val();
        mysqlData[index].defaultValue = $("#saveDefaultValue").val();
        mysqlData[index].beEmpty = beEmpty;
        mysqlData[index].primaryKey = primaryKey;
        mysqlData[index].isQuery =isQuery ;
        mysqlData[index].queryType = $("#saveQueryType").val();
        $("#table_mysql_fields").bootstrapTable("load",mysqlData)
        $("#mysqlSave").modal('hide');
    }

}
function mysqlDelConfirm(index) {
    if(confirm("确认删除吗")){
        mysqlData.splice(index,1);
        $("#table_mysql_fields").bootstrapTable("load",mysqlData)
        $("#mysqlIndexTap").val(mysqlData.length);
    }


}
/*----------------------------------mysql结束-----------------------------------*/

/*----------------------------------entity开始-----------------------------------*/
var entitySaveFlag = undefined;
function entityShowSave(index) {
    if (index != undefined) {
        entitySaveFlag = "UPDATE";
        console.log("entity修改");
        $("#entity-modal-title").text("entity修改");

        if(entityData[index].beEmpty == '是'){
            document.getElementById('entityradio-BeEmpty-2').checked=false;//取消勾选
            document.getElementById("entityradio-BeEmpty-1").checked = true;//勾选
        }else{
            document.getElementById('entityradio-BeEmpty-2').checked = true;//勾选
            document.getElementById("entityradio-BeEmpty-1").checked = false;//取消勾选
        }
        if(entityData[index].primaryKey == '是'){
            document.getElementById('entityradio-PrimaryKey-2').checked=false;//取消勾选
            document.getElementById("entityradio-PrimaryKey-1").checked = true;//勾选
        }else{
            document.getElementById('entityradio-PrimaryKey-2').checked = true;//勾选
            document.getElementById("entityradio-PrimaryKey-1").checked = false;//取消勾选
        }
        if(entityData[index].isQuery == '是'){
            document.getElementById('entityradio-IsQuery-2').checked=false;//取消勾选
            document.getElementById("entityradio-IsQuery-1").checked = true;//勾选
        }else{
            document.getElementById('entityradio-IsQuery-2').checked = true;//勾选
            document.getElementById("entityradio-IsQuery-1").checked = false;//取消勾选
        }
        $("#entityIndexflag").val(index);

        $("#saveentitymysqlId").val(entityData[index].id);
        $("#saveentityAttributeName").val(entityData[index].attributeName);
        $("#saveentityAttributeChinese").val(entityData[index].attributeChinese);
        $("#saveentityMysqlType").val(entityData[index].mysqlType);
        $("#saveentityDefaultValue").val(entityData[index].defaultValue);
        $("#saveentityQueryType").val(entityData[index].queryType.trim());
    } else {
        console.log("mysqlINSERT");
        $("#saveentitymysqlId").val("");
        $("#saveentityAttributeName").val("");
        $("#saveentityAttributeChinese").val("");
        $("#saveentityMysqlType").val("");
        $("#saveentityDefaultValue").val("");
        $("#saveentityBeEmpty").val("");
        $("#saveentityPrimaryKey").val("");
        $("#saveentityIsQuery").val("");
        $("#saveentityQueryType").val("");
        entitySaveFlag = "INSERT";
        $("#entity-modal-title").text("entity添加");
    }
    $("#entitySave").modal('show');
}
//关闭（添加或更新）mysql
function entityCloseSave() {
    $("#entitySave").modal('hide');
}

// 添加或更新
function entitySave() {

    if(str("saveentityAttributeName")){ ;
        almag("属性名");
        return;
    }
    if(str("saveentityAttributeChinese")){
        almag("属性中文 ");
        return;
    }


    console.log("操作数据");
    if (entitySaveFlag == "INSERT") {
        for(var i = 0;i<entityData.length;i++){
            if($("#saveentityAttributeName").val() == entityData[i].attributeName){
                alRepeat("entity属性名");
                return;
            }

        }
        var beEmpty = "";
        var primaryKey = "";
        var isQuery = "";
        if(document.getElementById("entityradio-BeEmpty-1").checked == true){
            beEmpty = "是";
        }else{
            beEmpty = "否";
        }
        if(document.getElementById("entityradio-PrimaryKey-1").checked == true){
            primaryKey = "是";
        }else{
            primaryKey = "否";
        }
        if(document.getElementById("entityradio-IsQuery-1").checked == true){
            isQuery = "是";
        }else{
            isQuery = "否";
        }
        entityData.push({id:$("#saveentitymysqlId").val(),
            attributeName:$("#saveentityAttributeName").val(),
            attributeChinese:$("#saveentityAttributeChinese").val(),
            mysqlType:$("#saveentityMysqlType").val(),
            defaultValue:$("#saveentityDefaultValue").val(),
            beEmpty:beEmpty,
            primaryKey:primaryKey,
            isQuery:isQuery,
            queryType:$("#saveentityQueryType").val()});
        $("#table_entity_fields").bootstrapTable("load",entityData)
        $("#entityIndexTap").val(entityData.length);
        console.log(entityData.length)
        $("#entitySave").modal('hide');
    } else if (entitySaveFlag == "UPDATE") {
        console.log("更新");
        var beEmpty = "";
        var primaryKey = "";
        var isQuery = "";
        if(document.getElementById("entityradio-BeEmpty-1").checked == true){
            beEmpty = "是";
        }else{
            beEmpty = "否";
        }
        if(document.getElementById("entityradio-PrimaryKey-1").checked == true){
            primaryKey = "是";
        }else{
            primaryKey = "否";
        }
        if(document.getElementById("entityradio-IsQuery-1").checked == true){
            isQuery = "是";
        }else{
            isQuery = "否";
        }

        var index = $("#entityIndexflag").val();
        entityData[index].id = $("#saveentitymysqlId").val();
        entityData[index].attributeName = $("#saveentityAttributeName").val();
        entityData[index].attributeChinese = $("#saveentityAttributeChinese").val();
        entityData[index].mysqlType = $("#saveentityMysqlType").val();
        entityData[index].defaultValue = $("#saveentityDefaultValue").val();
        entityData[index].beEmpty = beEmpty;
        entityData[index].primaryKey = primaryKey;
        entityData[index].isQuery =isQuery ;
        entityData[index].queryType = $("#saveentityQueryType").val();
        $("#table_entity_fields").bootstrapTable("load",entityData)
        $("#entityIndexTap").val(entityData.length);
        $("#entitySave").modal('hide');
    }

}
function entityDelConfirm(index) {
    if(confirm("确认删除吗")){
        console.log(index);
        entityData.splice(index,1);
        $("#table_entity_fields").bootstrapTable("load",entityData)
        $("#entityIndexTap").val(entityData.length);
    }


}

/*----------------------------------entity结束-----------------------------------*/