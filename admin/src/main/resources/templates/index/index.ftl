<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">

    <title>${config.siteName}</title>
    <link href="/assets/images/favicon.ico" rel="icon">
    <link href="/assets/css/common/common.css" rel="stylesheet" type="text/css"/>
    <link href="/assets/plugins/layui/css/layui.css" rel="stylesheet" type="text/css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <#include "/common/header.ftl"/>

    <#include "/common/left-menu.ftl"/>

    <div class="layui-body" style="padding: 20px; background-color: #F2F2F2;">
        <div class="layui-row layui-col-space15">
            <div class="layui-col-md3">
                <div class="layui-card">
                    <div class="layui-card-header">文章</div>
                    <div class="layui-card-body">
                        15
                    </div>
                </div>
            </div>
            <div class="layui-col-md3">
                <div class="layui-card">
                    <div class="layui-card-header">标签</div>
                    <div class="layui-card-body">
                        15
                    </div>
                </div>
            </div>
            <div class="layui-col-md3">
                <div class="layui-card">
                    <div class="layui-card-header">分类</div>
                    <div class="layui-card-body">
                        15
                    </div>
                </div>
            </div>
            <div class="layui-col-md3">
                <div class="layui-card">
                    <div class="layui-card-header">留言数</div>
                    <div class="layui-card-body">
                        15
                    </div>
                </div>
            </div>
        </div>

        <div class="layui-row layui-col-space15">
            <div class="layui-col-md4">
                <div class="layui-card">
                    <div class="layui-card-header">分类文章数统计</div>
                    <div class="layui-card-body">
                        <div id="echart_type" style="height: 250px;"></div>
                    </div>
                </div>
            </div>
            <div class="layui-col-md4">
                <div class="layui-card">
                    <div class="layui-card-header">文章访问TOP.10</div>
                    <div class="layui-card-body">
                    </div>
                </div>
            </div>
            <div class="layui-col-md4">
                <div class="layui-card">
                    <div class="layui-card-header">爬虫访问统计TOP.10</div>
                    <div class="layui-card-body">
                        <div id="echart_spider" style="height: 250px;"></div>
                    </div>
                </div>
            </div>
        </div>

        <div class="layui-row layui-col-space15">
            <div class="layui-col-md6">
                <div class="layui-card">
                    <div class="layui-card-header">近期文章</div>
                    <div class="layui-card-body">
                        <table class="layui-hide" id="rencentArticle"></table>
                    </div>
                </div>
            </div>
            <div class="layui-col-md6">
                <div class="layui-card">
                    <div class="layui-card-header">近期评论</div>
                    <div class="layui-card-body">
                        <table class="layui-hide" id="rencentRemark"></table>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <#include "/common/footer.ftl"/>
</div>
<script src="/assets/plugins/layui/layui.js"></script>
<script src="/assets/plugins/jquery/jquery.min.js"></script>
<script src="/assets/plugins/echarts/echarts.js"></script>
<script src="/assets/js/common/table.js"></script>
<script>
    layui.use('table', function(){
        var table = layui.table;
        table.render({
            elem: '#rencentArticle',
            cellMinWidth: 80,
            cols: [[
                {field:'id', width:80, title: 'ID', sort: true}
                ,{field:'username', width:80, title: '用户名'}
                ,{field:'sex', width:80, title: '性别', sort: true}
                ,{field:'city', width:80, title: '城市'}
                ,{field:'sign', title: '签名', width: '30%', minWidth: 100}
                ,{field:'experience', title: '积分', sort: true}
                ,{field:'score', title: '评分', sort: true}
                ,{field:'classify', title: '职业'}
                ,{field:'wealth', width:137, title: '财富', sort: true}
            ]]
        });

        table.render({
            elem: '#rencentRemark',
            cellMinWidth: 80, //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            cols: [[
                {field:'id', width:80, title: 'ID', sort: true}
                ,{field:'username', width:80, title: '用户名'}
                ,{field:'sex', width:80, title: '性别', sort: true}
                ,{field:'city', width:80, title: '城市'}
                ,{field:'sign', title: '签名', width: '30%', minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                ,{field:'experience', title: '积分', sort: true}
                ,{field:'score', title: '评分', sort: true}
                ,{field:'classify', title: '职业'}
                ,{field:'wealth', width:137, title: '财富', sort: true}
            ]]
        });
    });

    let option = {
        title: {
            text: '某站点用户访问来源',
            subtext: '纯属虚构',
            left: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['直接访问', '邮件营销', '联盟广告', '视频广告', '搜索引擎']
        },
        series: [
            {
                name: '访问来源',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: [
                    {value: 335, name: '直接访问'},
                    {value: 310, name: '邮件营销'},
                    {value: 234, name: '联盟广告'},
                    {value: 135, name: '视频广告'},
                    {value: 1548, name: '搜索引擎'}
                ],
                emphasis: {
                    itemStyle: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    }
    let theme = {
        color: ["#26B99A", "#34495E", "#BDC3C7", "#3498DB", "#9B59B6", "#8abb6f", "#759c6a", "#bfd3b7"],
        title: {
            itemGap: 8,
            textStyle: {
                fontWeight: "normal",
                color: "#408829"
            }
        },
        dataRange: {
            color: ["#1f610a", "#97b58d"]
        },
        toolbox: {
            color: ["#408829", "#408829", "#408829", "#408829"]
        },
        tooltip: {
            backgroundColor: "rgba(0,0,0,0.5)",
            axisPointer: {
                type: "line",
                lineStyle: {
                    color: "#408829",
                    type: "dashed"
                },
                crossStyle: {
                    color: "#408829"
                },
                shadowStyle: {
                    color: "rgba(200,200,200,0.3)"
                }
            }
        },
        dataZoom: {
            dataBackgroundColor: "#eee",
            fillerColor: "rgba(64,136,41,0.2)",
            handleColor: "#408829"
        },
        grid: {
            borderWidth: 0
        },
        categoryAxis: {
            axisLine: {
                lineStyle: {
                    color: "#408829"
                }
            },
            splitLine: {
                lineStyle: {
                    color: ["#eee"]
                }
            }
        },
        valueAxis: {
            axisLine: {
                lineStyle: {
                    color: "#408829"
                }
            },
            splitArea: {
                show: !0,
                areaStyle: {
                    color: ["rgba(250,250,250,0.1)", "rgba(200,200,200,0.1)"]
                }
            },
            splitLine: {
                lineStyle: {
                    color: ["#eee"]
                }
            }
        },
        timeline: {
            lineStyle: {
                color: "#408829"
            },
            controlStyle: {
                normal: {
                    color: "#408829"
                },
                emphasis: {
                    color: "#408829"
                }
            }
        },
        k: {
            itemStyle: {
                normal: {
                    color: "#68a54a",
                    color0: "#a9cba2",
                    lineStyle: {
                        width: 1,
                        color: "#408829",
                        color0: "#86b379"
                    }
                }
            }
        },
        map: {
            itemStyle: {
                normal: {
                    areaStyle: {
                        color: "#ddd"
                    },
                    label: {
                        textStyle: {
                            color: "#c12e34"
                        }
                    }
                },
                emphasis: {
                    areaStyle: {
                        color: "#99d2dd"
                    },
                    label: {
                        textStyle: {
                            color: "#c12e34"
                        }
                    }
                }
            }
        },
        force: {
            itemStyle: {
                normal: {
                    linkStyle: {
                        strokeColor: "#408829"
                    }
                }
            }
        },
        chord: {
            padding: 4,
            itemStyle: {
                normal: {
                    lineStyle: {
                        width: 1,
                        color: "rgba(128, 128, 128, 0.5)"
                    },
                    chordStyle: {
                        lineStyle: {
                            width: 1,
                            color: "rgba(128, 128, 128, 0.5)"
                        }
                    }
                },
                emphasis: {
                    lineStyle: {
                        width: 1,
                        color: "rgba(128, 128, 128, 0.5)"
                    },
                    chordStyle: {
                        lineStyle: {
                            width: 1,
                            color: "rgba(128, 128, 128, 0.5)"
                        }
                    }
                }
            }
        },
        gauge: {
            startAngle: 225,
            endAngle: -45,
            axisLine: {
                show: !0,
                lineStyle: {
                    color: [[.2, "#86b379"], [.8, "#68a54a"], [1, "#408829"]],
                    width: 8
                }
            },
            axisTick: {
                splitNumber: 10,
                length: 12,
                lineStyle: {
                    color: "auto"
                }
            },
            axisLabel: {
                textStyle: {
                    color: "auto"
                }
            },
            splitLine: {
                length: 18,
                lineStyle: {
                    color: "auto"
                }
            },
            pointer: {
                length: "90%",
                color: "auto"
            },
            title: {
                textStyle: {
                    color: "#333"
                }
            },
            detail: {
                textStyle: {
                    color: "auto"
                }
            }
        },
        textStyle: {
            fontFamily: "Arial, Verdana, sans-serif"
        }
    }
    echarts.init(document.getElementById('echart_type')).setOption(option);
    echarts.init(document.getElementById('echart_spider')).setOption(option);
</script>
</body>
</html>
