var chargingStationNameList = [];
var equipmentData = {};
var bootstrapTableOption = {
    url: 'query_gai_yao',
    columns: [
        {checkbox: true}, // 显示一个勾选框
        {field: 'orNot', title: '是否生成'},
        {field: 'modelType', title: '模板类型'},
        {field: 'modelAddr', title: '模板路径'},
        {field: 'modelSuffix', title: '模板生成类型'},
        {title: '操作', formatter:function (value, row, index) {
            var fields = row.orNot+',fh,' + row.modelType + ',fh,' + row.modelAddr+ ',fh,' + row.modelSuffix ;
        return ["<a><i class='' onclick='showSave(" + index + ")'>修改</i></a>","&nbsp;<a><i class='' onclick='delConfirm(" + index + ")'>删除</i><input type='hidden'  name='field"+index+"' value='"+fields+"'   /></a>"].join('');
    }
        }
    ],
    responseHandler: function (data) {
        equipmentData = data.list;
         $("#mysqlIndex").val(equipmentData.length);
        return data;
    }
};

$(document).ready(function() {
    setBootstrapTable('#table_gai_yao_fields', bootstrapTableOption);
});

function getChargingStationName(id) {
    changeSelectpicker(id, 'destroy');
    $(id).empty();
    if (chargingStationNameList && chargingStationNameList.length > 0) {
        setChargingStationName(id, chargingStationNameList);
    } else {
        $ajax("getChargingStationName", setChargingStationName, '', id, "get");
    }
};

function setChargingStationName(id, data) {
    var length = data.length;
    chargingStationNameList = data;
    for (var i = 0; i < length; i++) {
        $(id).append("<option value ='" + data[i].chargingStationID + "'>" + data[i].chargingStationName + "</option>");
    }
    changeSelectpicker(id, 'refresh');
    $(id).selectpicker('setStyle', 'select', 'add');
    if (length > 5) {
        setSelectpicker(id);
    }
};

function change(changeID, linkID, callback) {
    if (changeID && linkID) {
        var changeValue = $(changeID).val();
        $(linkID).empty();
        changeSelectpicker(linkID, 'destroy');
        if (changeValue) {
            $(linkID + "Div").show();
            if (callback && typeof callback === 'function') {
                callback(changeValue, linkID);
            }
        } else {
            $(linkID + "Div").hide();
        }
    }
};

function getEquipmentName(value, id) {
    $ajax("getEquipmentName?chargingStationID=" + value, setEquipmentName, '', id, "get");
};

function setEquipmentName(id, data) {
    var length = data.length;
    $(id).append("<option value='ALL'>全部桩</option>");
    for (var i = 0; i < length; i++) {
        $(id).append("<option value ='" + data[i].equipmentID + "'>" + data[i].equipmentName + "</option>");
    }
    changeSelectpicker(id, 'refresh');
    $(id).selectpicker('setStyle', 'select', 'add');
    if (length > 5) {
        setSelectpicker(id);
    }
};

function searchReset() {
    $("#equipmentID").empty();
    $("#equipmentIDDiv").hide();
    changeSelectpicker('#equipmentID', 'destroy');
    $('#chargingStationID')[0].selectedIndex = 0;
    changeSelectpicker('#chargingStationID', 'refresh');
};

function search() {
    operateBootstrapTable('#equipmentTable', 'selectPage', 1);
}
