var ${tabletop}List = [];
var operatorInfoData = {};
var bootstrapTableOption = {
    url: 'get${tabletop?cap_first}List',
    queryParams: function(params) {
        return {
            pageNum: params.pageNumber,// 每页要显示的数据条数
            pageSize: params.pageSize,// 每页显示数据的开始行号
            <#list mysqlList as var>
                <#assign foo="${var[0]}">
                <#if var[6] == "是">
                    <#if var[2]=='DATE' >
                        <#assign straddac=1>
                        <#assign straddacstr=1>
                        <#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddac=straddac+1><#if straddac==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>str:$('#<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradd=stradd+1><#if stradd==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>str').val(),  //${var[0]}str,
                        <#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddacstr=straddacstr+1><#if straddacstr==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>end:$('#<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddacstr=straddacstr+1><#if straddacstr==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>end').val(),  //${var[0]}end,
                    <#else>
                        <#assign straddac=1>
                        <#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddac=straddac+1><#if straddac==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>:$('#<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradd=stradd+1><#if stradd==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>').val(),  //${var[0]},
                    </#if>
                </#if>
            </#list>
        }
    },

    columns: [
        {checkbox: true}, // 显示一个勾选框
        {title: '序号', align: 'center', formatter: 'increases'},
        <#list mysqlList as var>
            <#assign foo="${var[0]}">
            <#if var[2]=='Integer' >
                <#assign stradd=1>
            { field: '<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradd=stradd+1><#if stradd==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>', title: '${var[1]}'},
            <#else>
                <#assign stradd=1>
            { field: '<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradd=stradd+1><#if stradd==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>', title: '${var[1]}'},
            </#if>
        </#list>
        {title: '操作', formatter:function (value, row, index) {
        return ["<a><i class='' onclick='showSave(" + index + ")'>修改</i></a>","  &nbsp;<a><i class='' onclick='delConfirm(" + index + ")'>删除</i></a>"].join('');}

        }
    ],
    responseHandler: function (data) {
        operatorInfoData = data.list;
        return data;
    }
};
//初始化
$(document).ready(function() {
	//$('title', parent.document).html($('title').text());
    //$("#DiagnosisHistoryIDDiv").hide();
    //getChargingStationName("#chargingStationID");  初始化查询条件
    setBootstrapTable('#operator${tabletop}', bootstrapTableOption);  //初始化页面table
});

function getChargingStationName(id) {
    changeSelectpicker(id, 'destroy');
    $(id).empty();
    if (${tabletop}List && ${tabletop}List.length > 0) {
        setChargingStationName(id, ${tabletop}List);
    } else {
        $ajax("getChargingStationName", setChargingStationName, '', id, "get");
    }
};
function setChargingStationName(id, data) {
    var length = data.length;
    ${tabletop}List = data;
    for (var i = 0; i < length; i++) {
        $(id).append("<option value ='" + data[i].chargingStationID + "'>" + data[i].chargingStationName + "</option>");
    }
    changeSelectpicker(id, 'refresh');
    $(id).selectpicker('setStyle', 'select', 'add');
    if (length > 5) {
        setSelectpicker(id);
    }

    fromDiagnosisReport1()
};
//获取输入框详情
function getDiagnosisHistoryName(value, id) {
    $ajax("getChargingPileName?chargingstationid=" + value, setEquipmentName, '', id, "get");
};

function setEquipmentName(id, data) {
    var length = data.length;
    $(id).append("<option value='ALL'>全部桩</option>");
    for (var i = 0; i < length; i++) {
        $(id).append("<option value ='" + data[i].equipmentid + "'>" + data[i].equipmentName + "</option>");
    }
    changeSelectpicker(id, 'refresh');
    $(id).selectpicker('setStyle', 'select', 'add');
    if (length > 5) {
        setSelectpicker(id);
    }
    fromDiagnosisReport2()
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

//重置
function searchReset() {
    $("#DiagnosisHistoryID").empty();
    $("#DiagnosisHistoryIDDiv").hide();
    changeSelectpicker('#DiagnosisHistoryID', 'destroy');
    $('#chargingStationID')[0].selectedIndex = 0;
    changeSelectpicker('#chargingStationID', 'refresh');
};
//查询
function search() {
    operateBootstrapTable('#operator${tabletop}', 'selectPage', 1);
}

/*table内部操作*/

// 格式化操作按钮

function detailAction(id, time,name) {
    if(name=='null'){
        name='';
    }
    window.parent.test("goDiagnosisDetail?id=" + id+"&time="+time, 10, name + "充电桩详情");
}

//从故障诊断的诊断历史按钮跳转到此页面时会调用的方法，功能是在充电站搜索框中，回显故障诊断数据的充电站字段。
function fromDiagnosisReport1() {
    var baseURI = document.getElementById("DiagnosisHistoryID").baseURI;
    var part;
    var key;

    if (baseURI && baseURI.split("?")[1]) {
        part = baseURI.split("?")[1].split("&")[0];
    } else {
        return;
    }

    if (!part) {
        return;
    } else {
        key = part.split("=")[0];
    }


    if (!key || key != "ChargingStationID") {
        return;
    }

    var chargingStationIDVal = part.split("=")[1];

    $("#chargingStationID").val(chargingStationIDVal);
    changeSelectpicker("#chargingStationID", 'refresh');
    $("#chargingStationID").change();
}

//从故障诊断的诊断历史按钮跳转到此页面时会调用的方法，功能是在充电桩搜索框中，回显故障诊断数据的充电桩字段。
function fromDiagnosisReport2() {
    var baseURI = document.getElementById("DiagnosisHistoryID").baseURI;
    var part;
    var key;

    if (baseURI && baseURI.split("?")[1]) {
        part = baseURI.split("?")[1].split("&")[0];
    } else {
        return;
    }

    if (!part) {
        return;
    } else {
        key = part.split("=")[0];
    }

    if (!key || key != "EquipmentID") {
        return;
    }

    var DiagnosisHistoryIDVal = part.split("=")[1];
    $("#DiagnosisHistoryID").val(DiagnosisHistoryIDVal);
    changeSelectpicker("#DiagnosisHistoryID", 'refresh');
    console.log($("#DiagnosisHistoryID").selectpicker('size'));
    //search();
}