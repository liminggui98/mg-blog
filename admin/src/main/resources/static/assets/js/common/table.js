function initTable(option) {
    let cols = [{type: 'checkbox'}];
    cols.push.apply(cols, dataOption.cols);
    cols.push({
        'title': '操作',
        'toolbar': '#bar'
    });

    layui.use(['table'], function () {
        let table = layui.table;

        table.render({
            title: '列表',
            text: '无数据',
            elem: '#table',
            url: dataOption.url,
            method: 'post',
            data: [],
            toolbar: '#toolbar',
            defaultToolbar: ['filter', 'exports'],
            page: dataOption.enablePage || true,
            request: {
                pageName: 'current', //页码的参数名称，默认：page
                limitName: 'size' //每页数据量的参数名，默认：limit
            },
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
        });

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
            layer.msg('ID：' + obj.data.id + ' 的查看操作');
        }

        function search() {
            layer.msg('search')
        }

        function add() {
            layer.msg('添加');
        }

        function edit(obj) {
            layer.alert('编辑行：<br>' + JSON.stringify(obj.data))
        }

        function del(obj) {
            layer.alert('删除行：<br>' + JSON.stringify(obj.data))
        }

        function batchEdit(data) {
            if (data.length === 0) {
                layer.msg('请选择一行');
            } else if (data.length > 1) {
                layer.msg('只能同时编辑一个');
            } else {
                layer.alert('编辑 [id]：' + data[0].id);
            }
        }

        function batchDel(dataArray) {
            if (dataArray.length === 0) {
                layer.msg('请选择一行');
            } else {
                for (let i in dataArray) {
                    layer.alert('删除 [id]：' + dataArray[i].id);
                }
            }
        }
    });
}

let blogTable = {};
blogTable.init = initTable;
window.blogTable = blogTable;

