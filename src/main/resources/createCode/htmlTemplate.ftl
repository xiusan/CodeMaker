<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <title>${objectRemark}</title>

    <link href="static/css/bootstrap/bootstrap.min.css" rel="stylesheet"/>
    <link href="static/css/bootstrap/bootstrap-table.min.css" rel="stylesheet"/>
    <link href="static/css/bootstrap/bootstrap-select.min.css" rel="stylesheet"/>
    <link href="static/css/other/font-awesome.min.css" rel="stylesheet"/>
    <link href="static/css/other/animate.min.css" rel="stylesheet"/>
    <link href="static/css/other/style.min.css?v=4.1.0" rel="stylesheet"/>
    <link href="static/css/plugins/iCheck/custom.css" rel="stylesheet"/>
    <link href="static/css/plugins/sweetalert/sweetalert.css" rel="stylesheet"/>
    <link href="static/css/select.css" rel="stylesheet"/>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>${objectRemark}</h5>
                </div>
                <div class="ibox-content">
                    <!-- 查询工具栏 -->
                    <div class="form-inline">
                        <div  class="form-group" >
                        <#list mysqlList as var>
                            <#assign foo="${var[0]}">
                            <#if var[6] == "是">
                                <#if var[2]=='DATE' >
                                    <#assign straddac=1>
                                    <label for="id">开始${var[1]}:</label>
                                    <input id="<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddac=straddac+1><#if straddac==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>str" name="<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddac=straddac+1><#if straddac==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>str" class="selectpicker" data-live-search="true"  >
                                    </input>
                                    <#assign straddacend=1>
                                    <label for="id">结束${var[1]}:</label>
                                    <input id="<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddacend=straddacend+1><#if straddacend==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>end" name="<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddacend=straddacend+1><#if straddacend==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>end" class="selectpicker" data-live-search="true"  >
                                    </input>
                                <#else>
                                    <#assign straddac=1>
                                    <label for="id">${var[1]}:</label>
                                    <input id="<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddac=straddac+1><#if straddac==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>" name="<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddac=straddac+1><#if straddac==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>" class="selectpicker" data-live-search="true"  >
                                    </input>
                                </#if>

                            </#if>

                        </#list>

                        </div>
                        <button type="button" class="btn btn-primary btn-sm" onclick="search()" >
                            <img src="static/images/search_btn.png" height="16" width="16"/> 查询
                        </button>
                        <button type="button" class="btn btn-sm" onclick="searchReset()" >
                            <img src="static/images/reset_btn.png" height="16" width="16"/> 重置
                        </button>
                    </div>
                    <hr/>
                    <button type="button" class="btn btn-primary btn-sm" onclick="showSave()">
                        <img src="static/images/add_btn.png" height="16" width="16"/> 添加
                    </button>
                    <!--<button type="button" class="btn btn-primary btn-sm" onclick="showSave(1)">
                        <img src="static/images/edit_btn.png" height="16" width="16"/> 修改
                    </button>-->
                    <button type="button" class="btn btn-primary btn-sm" onclick="delConfirm()">
                        <img src="static/images/delete_btn.png" height="16" width="16"/> 删除
                    </button>
                    <table id="operator${tabletop}"></table>
                    <!--  添加框 -->

                    <div class="modal inmodal" id="save" tabindex="-1" data-backdrop="static" role="dialog" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content animated bounceInRight">
                                <div class="modal-header">
                                    <button type="button" class="close" onclick="closeSave()">
                                        <span aria-hidden="true">&times;</span>
                                        <span class="sr-only">关闭</span>
                                    </button>
                                    <h4 class="modal-title">添加</h4>
                                </div>
                                <div class="modal-footer" style="text-align: left">
                                    <form id="saveForm">

                                    <#list mysqlList as var>
                                        <div class="col-sm-6">
                                            <div class="form-group">
                                                <div class="fg-line">
                                                    <#assign foo="${var[0]}">
                                                    <#assign stradd=1>
                                                    <#assign straddad=1>
                                                    <#assign straddac=1>
                                                    <label for="save<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign stradd=stradd+1><#if stradd==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>">${var[1]}</label>
                                                    <input  id="save<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddac=straddac+1><#if straddac==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>" name="save<#if foo?index_of("_")!=-1 ><#list foo?split("_") as s><#assign straddad=straddad+1><#if straddad==2 >${s?lower_case}<#else><#assign strzhuanhu=s?lower_case>${strzhuanhu?cap_first}</#if></#list><#else>${foo?lower_case}</#if>" type="text" required="" class="form-control" minlength="1" maxlength="100" placeholder="${var[2]}" title="${var[2]}"/>
                                                </div>
                                            </div>
                                        </div>
                                    </#list>

                                        <div class="col-sm-12" style="text-align: right">
                                            <button type="button" class="btn" onclick="closeSave()">
                                                <img src="static/images/close_btn.png" height="16" width="16"/> 关闭
                                            </button>
                                            <button type="button" class="btn btn-primary" onclick="save()">
                                                <img src="static/images/save_btn.png" height="16" width="16"/> 保存
                                            </button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>



                </div>
            </div>
        </div>
    </div>
</div>

<script src="static/js/cron/jquery.min.js"></script>

<script src="static/js/cron/bootstrap.min.js"></script>
<script src="static/js/bootstrap/bootstrap-table.js"></script>
<script src="static/js/bootstrap/bootstrap-table-zh-CN.min.js"></script>
<script src="static/js/bootstrap/bootstrap-select.min.js"></script>

<script src="static/js/plugins/iCheck/icheck.min.js"></script>
<script src="static/js/plugins/layer/laydate/laydate.js"></script>
<script src="static/js/plugins/layer/layer.min.js"></script>
<script src="static/js/plugins/sweetalert/sweetalert.min.js"></script>
<script src="static/js/plugins/sweetalert/sweetalert-dev.js"></script>

<script src="static/js/other/content.min.js?v=1.0.0"></script>
<script src="static/js/other/contabs.min.js"></script>

<script src="static/js/common.js"></script>
<script src="static/js/messageContent.js"></script>

<script src="static/js/${tabletop}/${tabletop}.js"></script>
<script src="static/js/${tabletop}/${tabletop}Operate.js"></script>


</body>

</html>