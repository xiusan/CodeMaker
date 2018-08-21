var saveFlag = undefined;
function showSave(index) {
    if (index != undefined) {
        saveFlag = "UPDATE";
        $(".modal-title").text("功能备注修改");
        $("#saveId").val(equipmentData[index].id);
        $("#saveOrNot").val(equipmentData[index].orNot);
        $("#saveModelType").val(equipmentData[index].modelType);
        $("#saveModelAddr").val(equipmentData[index].modelAddr);
        $("#saveModelSuffix").val(equipmentData[index].modelSuffix);
        //equipmentData[index].id=$("#saveid").val();
    } else {
        console.log("INSERT");
        saveFlag = "INSERT";
        $(".modal-title").text("功能备注添加");
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