var saveFlag = undefined;
function showSave(index) {
   // getChargingStationName("#saveChargingStationID");
    $("#saveChargingStationID").addClass('pop-select').selectpicker('setStyle');
    $("#saveChargingStationID").selectpicker('setStyle', 'pop-select', 'add');
    if (index != undefined) {
        saveFlag = "UPDATE";
        $(".modal-title").text("${objectRemark}修改");
    <#list fieldList as var>
        <#assign foo="${var[0]}">
        <#if var[1]=='Integer' >
            <#assign stradd=1>
            <#assign straddfg=1>
        $("#<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradd=stradd+1><#if stradd==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>").val(operatorInfoData[index].<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddfg=straddfg+1><#if straddfg==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>);
        <#else>
            <#assign stradd=1>
            <#assign straddfg=1>
        $("#<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradd=stradd+1><#if stradd==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>").val(operatorInfoData[index].<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddfg=straddfg+1><#if straddfg==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>);
        </#if>
    </#list>

    } else {
        saveFlag = "INSERT";
        $(".modal-title").text("${objectRemark}添加");
        formReset('saveForm');
    }
    $("#save").modal('show');
}
//关闭（添加或更新）${objectRemark}
function closeSave() {
    $("#save").modal('hide');
    formReset('saveForm');
}

// 添加或更新
function save() {
//    if(!saveChargingStationID){
//        showInfo("请选择充电站！")
//        return;
//    }
    if (checkForm("#saveForm")) {
        if (saveFlag == "INSERT") {
            //获取到i
            $ajax('save${objectName}', saveEquipmentCallback, ($("#saveForm").serialize() || "").replace(/save/g, ""));
        } else if (saveFlag == "UPDATE") {
            $ajax('update${objectName}', saveEquipmentCallback, ($("#saveForm").serialize() || "").replace(/save/g, ""));
        }
    }
}

//回调函数
function saveEquipmentCallback(data) {
    var result = data && data.result;
    var message = "";
    if (saveFlag == "INSERT") {
        message += "Insert.";
    } else if (saveFlag == "UPDATE") {
        message += "Update.";
    }
    if (result == "Success"){
        $('#operator${objectName}').bootstrapTable('refresh');
        closeSave();
        showSuccess(messageContent[message + "Success"]);
    } else if (result == "ChargingStationIDEmpty") {
        showError(messageContent[message + "Failed"] + result);
    } else if (result == "OperatorIdEmpty") {
        showError(messageContent[message + "Failed"] + result);
    } else if (result == "EquipmentIDExist") {
        showError(messageContent["Equipment.EquipmentExist"]);
    } else if (result == "EquipmentNameExist") {
        showError(messageContent["Equipment.EquipmentNameExist"]);
    } else if (result == "DuplicateError") {
        showError(messageContent[message + "Duplicate"]);
    } else if (result == "NotFound") {
        showError(messageContent[message + "NotFound"]);
    } else {
        showError(messageContent[message + "Error"]);
    }
}

function delConfirm(index) {
    if (index != undefined) {
        showWarn(messageContent["Delete.Confirm"], delone, operatorInfoData[index]);
    }
    else {
        var selectData = $('#operator${objectName}').bootstrapTable('getSelections');
        if (selectData.length == 0) {
            showInfo(messageContent["Delete.Select"]);
        } else {
            showWarn(messageContent["Delete.Confirm"], del, selectData);
        }



    }

}
//删除${objectRemark}
function del(data) {
    var operatorInfoList = [];
    for (var i in data) {
        operatorInfoList.push(data[i].operatorId);
    }
    $ajax('del${objectName}', delEquipmentCallback, {id: operatorInfoList.join(',')});
}

function delone(data) {
    var operatorInfoList = [];
        operatorInfoList.push(data.operatorId);

    $ajax('del${objectName}', delEquipmentCallback, {id: operatorInfoList.join(',')});
}

function delEquipmentCallback(data) {
    var result = data && data.result;
    if (result == "Success"){
        $('#operator${objectName}').bootstrapTable('refresh');
        showSuccess(messageContent["Delete.Success"]);
    } else if (result == "EquipmentIDEmpty") {
        showError(messageContent["Delete.Failed"] + result);
    } else if (result == "NotFound") {
        showError(messageContent["Delete.NotFound"]);
    } else {
        showError(messageContent["Delete.Error"]);
    }
}
