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
    $("#save").modal('hide');
}

// 添加或更新
function save() {
    console.log("操作数据");
        if (saveFlag == "INSERT") {
             $("#saveId").val("");
             $("#saveOrNot").val();
             $("#saveModelType").val("");
             $("#saveModelAddr").val("");
             $("#saveModelSuffix").val("");
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
                 modelSuffix:$("#saveModelSuffix").val()});
            $("#table_gai_yao_fields").bootstrapTable("load",equipmentData)
            console.log(equipmentData.length)
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
            $("#save").modal('hide');
        }

}
function delConfirm(index) {
        if(confirm("确认删除吗")){
           equipmentData.splice(index,1);
            $("#table_gai_yao_fields").bootstrapTable("load",equipmentData)
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
    console.log("操作数据");
    if (mysqSaveFlag == "INSERT") {
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
        console.log(entityData.length)

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
    console.log("操作数据");
    if (entitySaveFlag == "INSERT") {
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
        $("#entitySave").modal('hide');
    }

}
function entityDelConfirm(index) {
    if(confirm("确认删除吗")){
        console.log(index);
        entityData.splice(index,1);
        $("#table_entity_fields").bootstrapTable("load",entityData)
    }


}

/*----------------------------------entity结束-----------------------------------*/