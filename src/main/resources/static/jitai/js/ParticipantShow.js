$(function () {
        $('#table_2').bootstrapTable({
            method: "get",
            striped: true,
            dataType: "json",
            data:getda(),
            pagination: true, //分页
            pageSize: 10,
            pageNumber: 1,
            search: false, //显示搜索框
            contentType: "application/x-www-form-urlencoded",
            queryParams: null,
            columns: [
                {
                    checkbox: "true",
                    field: 'ID',
                    align: 'center'
                },
                {
                    title: "编号",
                    field: 'participant_id',
                    align: 'center'
                },
                {
                    title: '名字',
                    field: 'participant_name',
                    align: 'center'
                },
                {
                    title: '作品',
                    field: 'game_production',
                    align: 'center'
                },
                {
                    title: '头像编号',
                    field: 'participant_picture',
                    align: 'center'
                },
                {
                    title: '票数',
                    field: 'poll',
                    align: 'center'
                },
                {
                    width:'150px',
                    title: '操作',
                    align: 'center',
                    events:operateEvents,//给按钮加注册事件
                    formatter:AddFunctionAlty,//表格中加按钮
                }
            ]
        });
});
var url="/findallp";
var param={};
function getda(){
    $.get(url,param,function (data) {
        for(var i=data.length-1;i>=0;i--) {
            $('#table_2').bootstrapTable("append",data[i]);
        }
        return data;
    });
}

function AddFunctionAlty(value,row,index) {
    return[
        '<button id="TableEditor" onclick="delByid(this)" class="btn btn-default">删除</button> &nbsp;&nbsp;'
    ].join("")
}

window.operateEvents = {
    "click #table_2": function (e, value, row, index) {

    },
    "click #table_2": function (e, value, row, index) {
        $(this).parent().parent().remote();
    }

}