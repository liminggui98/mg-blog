function initTable(dataOption) {
    let cols = [{type: 'checkbox'}];
    cols.push.apply(cols, dataOption.cols);
    cols.push({
        'title': '操作',
        'toolbar': '#bar',
    });

    layui.use(['table'], function () {
        let table = layui.table;
        let option = {
            id: '#table',
            elem: '#table',
            url: window.location.href + "/list",
            method: 'post',
            data: [],
            toolbar: '#toolbar',
            defaultToolbar: ['filter', 'exports'],
            page: dataOption.enablePage || true,
            request: {
                pageName: 'current', //页码的参数名称，默认：page
                limitName: 'size' //每页数据量的参数名，默认：limit
            },
            loading: true,
            limits: [10, 20, 30, 40, 50, 60, 70, 80, 90],
            cols: [cols],
            parseData: function (res) {
                return {
                    "code": 0, //解析接口状态
                    "msg": '', //解析提示文本
                    "count": res.total, //解析数据长度
                    "data": res.records //解析数据列表
                }
            }
        }

        let tableIns = table.render(option);

        table.exportFile = function (e, t, i) {

        }

        table.on('toolbar(data)', function (obj) {
            let checkStatus = table.checkStatus(obj.config.id);
            let data = checkStatus.data;
            switch (obj.event) {
                case 'add':
                    add();
                    break;
                case 'update':
                    batchEdit(data);
                    break;
                case 'delete':
                    batchDel(data);
                    break;
                case 'search':
                    search();
                    break;
            }
        });

        table.on('tool(data)', function (obj) {
            switch (obj.event) {
                case 'detail':
                    show(obj);
                    break;
                case 'edit':
                    edit(obj);
                    break;
                case 'del':
                    del(obj);
                    break;
            }
        });

        function show(obj) {
            layer.open({
                type: 2,
                title: '查看详情',
                area: ['1000px', '80%'],
                btn: ['确认', '取消'],
                content: [window.location.href + '/' + obj.data.id, 'no']
            });
        }

        function search() {
            layer.msg('search')
        }

        function add() {
            layer.open({
                type: 2,
                title: '添加',
                area: ['1000px', '80%'],
                btn: ['确认', '取消'],
                content: [window.location.href + '/add'],
                yes: function (index, layerNo) {
                    $("#data").submit();
                    layer.close(index);
                },
                cancel: function (index, layerNo) {
                    layer.close(index);
                    console.log('cancel')
                }
            });
        }

        function edit(obj) {
            layer.open({
                type: 2,
                title: '编辑',
                area: ['1000px', '80%'],
                btn: ['确认', '取消'],
                content: [window.location.href + '/' + obj.data.id]
            });
        }

        function del(obj) {
            $.ajax({
                url: window.location.href + "/" + obj.data.id,
                method: 'delete',
                success: function (res) {
                    layer.msg('删除成功', {
                        icon: 1,
                    }, function () {
                        tableIns.reload(option);
                    });
                },
                error: function (res) {
                    layer.msg('删除失败', {
                        icon: 2,
                    }, function () {
                        tableIns.reload(option);
                    });
                }
            });
        }

        function batchEdit(data) {
            if (data.length === 0) {
                layer.msg('请选择一行');
            } else if (data.length > 1) {
                layer.msg('只能同时编辑一个');
            } else {
                layer.open({
                    type: 2,
                    content: [window.location.href + '/' + obj.data.id, 'no']
                });
            }
        }

        function batchDel(dataArray) {
            if (dataArray.length === 0) {
                layer.msg('请选择一行');
            } else {
                let ids = [];
                for (let i in dataArray) {
                    ids.push(dataArray[i].id)
                }
                $.ajax({
                    url: window.location.href + "/batchDel",
                    data: {
                        'ids': $.makeArray(ids)
                    },
                    method: 'delete',
                    success: function (res) {
                        layer.msg('删除成功', {
                            icon: 1,
                        }, function () {
                            tableIns.reload(option);
                        });
                    },
                    error: function (res) {
                        layer.msg('删除失败', {
                            icon: 2,
                        }, function () {
                            tableIns.reload(option);
                        });
                    }
                })
            }
        }
    });
}

let blogTable = {};
blogTable.init = initTable;
window.blogTable = blogTable;

