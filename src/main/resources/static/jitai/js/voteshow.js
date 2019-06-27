$(function () {
    $('#table_1').bootstrapTable({
        method: "get",
        striped: true,
        dataType: "json",
        data: getda(),
        pagination: true, //分页
        pageSize: 10,
        pageNumber: 1,
        search: false, //显示搜索框
        contentType: "application/x-www-form-urlencoded",
        queryParams: null,
        columns: [
            {
                checkbox:"true",
                field: 'ID',
                align: 'center',
            },
            {
                title: "votepk_id",
                field: 'pkid',
                align: 'center'
            },
            {
                title: '投票标题',
                field: 'pkname',
                align: 'center',
            },
            {
                title: '参与人员',
                field: 'pk_personnel',
                align: 'center'
            },
            {
                title: '发布时间',
                field: 'pk_beggintime',
                align: 'center'
            },
            {
                title: '结束时间',
                field: 'pk_overtime',
                align: 'center',
            },
            {
                title: '状态',
                field: 'pk_state',
                align: 'center'
            },
            {
                title: '胜出者',
                field: 'victory_name',
                align: 'center'
            },
            {
                title: '操作',
                field: 'id',
                align: 'center',
                events:operateEvents,//给按钮加注册事件
                formatter:AddFunctionAlty,//表格中加按钮
            }
        ]
    });
});
var url="/findallpk";
var param={};
function getda(){
    $.get(url,param,function (data) {
        for(var i=data.length-1;i>=0;i--) {
            $('#table_1').bootstrapTable("append",data[i]);
        }
        return data;
    });
}

function AddFunctionAlty(value,row,index) {
    return[
        '<button id="TableEditor" onclick="begin(this)" class="btn btn-default">开始</button> &nbsp;&nbsp;',
        '<button id="TableEditor" onclick="dele(this)" class="btn btn-default">删除</button> &nbsp;&nbsp;',
        '<button id="TableEditor" onclick="over(this)" class="btn btn-default">结束</button> &nbsp;&nbsp;'
    ].join("")
}

window.operateEvents = {
    "click #table_2": function (e, value, row, index) {

    },
    "click #table_2": function (e, value, row, index) {
        $(this).parent().parent().remote();
    }

}