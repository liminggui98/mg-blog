let blogCharts = {}

function initCharts(option) {
    if (!option || !option.id) {
        return;
    }
    echarts.init(document.getElementById(option.id)).setOption(option);
}

blogCharts.init = initCharts()

window.blogTable = blogCharts
