<!DOCTYPE html>
<html>
<#include "include/macros.ftl">
<@header></@header>
<body>
<@indexHeader></@indexHeader>
<div class="d-flex align-items-stretch">
    <@indexSiderBar></@indexSiderBar>
    <div class="page-content">
        <div class="page-header">
            <div class="container-fluid">
                <h2 class="h5 no-margin-bottom">概览</h2>
            </div>
        </div>
        <section class="no-padding-top no-padding-bottom">
            <div class="container-fluid">
                <div class="row clearfix">
                    <div class="col-md-3 col-sm-12">
                        <div class="statistic-block block">
                            <div class="progress-details d-flex align-items-end justify-content-between">
                                <div class="title">
                                    <div class="icon"><i class="icon-user-1"></i></div>
                                    <strong>访问量</strong>
                                </div>
                                <div class="number dashtext-1">27</div>
                            </div>
                            <div class="progress progress-template">
                                <div role="progressbar" style="width: 30%" aria-valuenow="30" aria-valuemin="0"
                                     aria-valuemax="100" class="progress-bar progress-bar-template dashbg-1"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-12">
                        <div class="statistic-block block">
                            <div class="progress-details d-flex align-items-end justify-content-between">
                                <div class="title">
                                    <div class="icon"><i class="icon-contract"></i></div>
                                    <strong>文章数</strong>
                                </div>
                                <div class="number dashtext-2">375</div>
                            </div>
                            <div class="progress progress-template">
                                <div role="progressbar" style="width: 70%" aria-valuenow="70" aria-valuemin="0"
                                     aria-valuemax="100" class="progress-bar progress-bar-template dashbg-2"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-12">
                        <div class="statistic-block block">
                            <div class="progress-details d-flex align-items-end justify-content-between">
                                <div class="title">
                                    <div class="icon"><i class="icon-paper-and-pencil"></i></div>
                                    <strong>类别数</strong>
                                </div>
                                <div class="number dashtext-3">140</div>
                            </div>
                            <div class="progress progress-template">
                                <div role="progressbar" style="width: 55%" aria-valuenow="55" aria-valuemin="0"
                                     aria-valuemax="100" class="progress-bar progress-bar-template dashbg-3"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3 col-sm-12">
                        <div class="statistic-block block">
                            <div class="progress-details d-flex align-items-end justify-content-between">
                                <div class="title">
                                    <div class="icon"><i class="icon-paper-and-pencil"></i></div>
                                    <strong>评论数</strong>
                                </div>
                                <div class="number dashtext-3">140</div>
                            </div>
                            <div class="progress progress-template">
                                <div role="progressbar" style="width: 55%" aria-valuenow="55" aria-valuemin="0"
                                     aria-valuemax="100" class="progress-bar progress-bar-template dashbg-3"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="no-padding-bottom">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="bar-chart block no-margin-bottom">
                            <canvas id="barChartExample1"></canvas>
                        </div>
                        <div class="bar-chart block">
                            <canvas id="barChartExample2"></canvas>
                        </div>
                    </div>
                    <div class="col-lg-8">
                        <div class="line-cahrt block">
                            <canvas id="lineCahrt"></canvas>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="no-padding-bottom">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="stats-2-block block d-flex">
                            <div class="stats-2 d-flex">
                                <div class="stats-2-arrow low"><i class="fa fa-caret-down"></i></div>
                                <div class="stats-2-content"><strong class="d-block">5.657</strong><span
                                            class="d-block">Standard Scans</span>
                                    <div class="progress progress-template progress-small">
                                        <div role="progressbar" style="width: 60%;" aria-valuenow="30" aria-valuemin="0"
                                             aria-valuemax="100"
                                             class="progress-bar progress-bar-template progress-bar-small dashbg-2"></div>
                                    </div>
                                </div>
                            </div>
                            <div class="stats-2 d-flex">
                                <div class="stats-2-arrow height"><i class="fa fa-caret-up"></i></div>
                                <div class="stats-2-content"><strong class="d-block">3.1459</strong><span
                                            class="d-block">Team Scans</span>
                                    <div class="progress progress-template progress-small">
                                        <div role="progressbar" style="width: 35%;" aria-valuenow="30" aria-valuemin="0"
                                             aria-valuemax="100"
                                             class="progress-bar progress-bar-template progress-bar-small dashbg-3"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="stats-3-block block d-flex">
                            <div class="stats-3"><strong class="d-block">745</strong><span class="d-block">Total requests</span>
                                <div class="progress progress-template progress-small">
                                    <div role="progressbar" style="width: 35%;" aria-valuenow="30" aria-valuemin="0"
                                         aria-valuemax="100"
                                         class="progress-bar progress-bar-template progress-bar-small dashbg-1"></div>
                                </div>
                            </div>
                            <div class="stats-3 d-flex justify-content-between text-center">
                                <div class="item"><strong class="d-block strong-sm">4.124</strong><span
                                            class="d-block span-sm">Threats</span>
                                    <div class="line"></div>
                                    <small>+246</small>
                                </div>
                                <div class="item"><strong class="d-block strong-sm">2.147</strong><span
                                            class="d-block span-sm">Neutral</span>
                                    <div class="line"></div>
                                    <small>+416</small>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="drills-chart block">
                            <canvas id="lineChart1"></canvas>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <@indexFooter></@indexFooter>
    </div>
</div>
<@footer></@footer>
<script type="text/javascript" src="/js/charts-home.js"></script>
<script type="text/javascript" src="/js/charts-custom.js"></script>
</body>
</html>