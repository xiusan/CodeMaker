/*----------------------------------概要开始-----------------------------------*/
var saveFlag = undefined;
function showSave(index) {
    if (index != undefined) {
        saveFlag = "UPDATE";
        $("#gaiyao-modal-title").text("概要修改");
        $("#saveId").val(equipmentData[index].id);
        $("#saveOrNot").val(equipmentData[index].orNot);
        $("#saveModelType").val(equipmentData[index].modelType);
        $("#saveModelAddr").val(equipmentData[index].modelAddr);
        $("#saveModelSuffix").val(equipmentData[index].modelSuffix);
        //equipmentData[index].id=$("#saveid").val();
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

             equipmentData.push({saveId: $("#saveId").val(),
                 orNot:$("#saveOrNot").val(),
                 modelType:$("#saveModelType").val(),
                 modelAddr:$("#saveModelAddr").val(),
                 modelSuffix:$("#saveModelSuffix").val()});
            $("#table_gai_yao_fields").bootstrapTable("load",equipmentData)
            console.log(equipmentData.length)
            $("#save").modal('hide');
         } else if (saveFlag == "UPDATE") {
            console.log("更新");
            //$ajax('updateTest', saveEquipmentCallback, ($("#saveForm").serialize() || "").replace(/save/g, ""));
            equipmentData[index].id = $("#saveId").val();
            equipmentData[index].orNot = $("#saveOrNot").val();
            equipmentData[index].modelType   = $("#saveModelType").val();
            equipmentData[index].modelAddr   = $("#saveModelAddr").val();
            equipmentData[index].modelSuffix  = $("#saveModelSuffix").val();
            $("#table_gai_yao_fields").bootstrapTable("load",equipmentData)
            $("#save").modal('hide');
        }

}
function delConfirm(index) {
        if(confirm("确认删除吗")){
           equipmentData.splice(equipmentData[index],1);
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
        $("#savemysqlId").val(mysqlData[index].id);
        $("#saveAttributeName").val(mysqlData[index].attributeName);
        $("#saveAttributeChinese").val(mysqlData[index].attributeChinese);
        $("#saveMysqlType").val(mysqlData[index].mysqlType);
        $("#saveDefaultValue").val(mysqlData[index].defaultValue);
        $("#saveBeEmpty").val(mysqlData[index].beEmpty);
        $("#savePrimaryKey").val(mysqlData[index].primaryKey);
        $("#saveIsQuery").val(mysqlData[index].isQuery);
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

        mysqlData.push({id:$("#savemysqlId").val(),
            attributeName:$("#saveAttributeName").val(),
            attributeChinese:$("#saveAttributeChinese").val(),
            mysqlType:$("#saveMysqlType").val(),
            defaultValue:$("#saveDefaultValue").val(),
            beEmpty:$("#saveBeEmpty").val(),
            primaryKey:$("#savePrimaryKey").val(),
            isQuery:$("#saveIsQuery").val(),
            queryType:$("#saveQueryType").val()});
        $("#table_mysql_fields").bootstrapTable("load",mysqlData)
        console.log(mysqlData.length)
        $("#mysqlSave").modal('hide');
    } else if (mysqSaveFlag == "UPDATE") {
        console.log("更新");
        //$ajax('updateTest', saveEquipmentCallback, ($("#saveForm").serialize() || "").replace(/save/g, ""));
        mysqlData[index].id = $("#savemysqlId").val();
        mysqlData[index].attributeName = $("#saveAttributeName").val();
        mysqlData[index].attributeChinese = $("#saveAttributeChinese").val();
        mysqlData[index].mysqlType = $("#saveMysqlType").val();
        mysqlData[index].defaultValue = $("#saveDefaultValue").val();
        mysqlData[index].beEmpty = $("#saveBeEmpty").val();
        mysqlData[index].primaryKey = $("#savePrimaryKey").val();
        mysqlData[index].isQuery = $("#saveIsQuery").val();
        mysqlData[index].queryType = $("#saveQueryType").val();
        $("#table_mysql_fields").bootstrapTable("load",mysqlData)
        $("#mysqlSave").modal('hide');
    }

}
function mysqlDelConfirm(index) {
    if(confirm("确认删除吗")){
        mysqlData.splice(mysqlData[index],1);
        $("#table_mysql_fields").bootstrapTable("load",mysqlData)
    }


}



/*----------------------------------mysql结束-----------------------------------*/