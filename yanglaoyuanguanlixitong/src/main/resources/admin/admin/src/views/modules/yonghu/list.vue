<template>
    <div class="main-content">

        <!-- 条件查询 -->
        <div v-if="showFlag">
            <el-form :inline="true" :model="searchForm" class="form-content">
                <el-row :gutter="20" class="slt" :style="{justifyContent:contents.searchBoxPosition=='1'?'flex-start':contents.searchBoxPosition=='2'?'center':'flex-end'}">
                                 
                     <el-form-item :label="contents.inputTitle == 1 ? '用户姓名' : ''">
                         <el-input prefix-icon="el-icon-search" v-model="searchForm.yonghuName" placeholder="用户姓名" clearable></el-input>
                     </el-form-item>
                                                        


                    <el-form-item>
                        <el-button type="success" @click="search()">查询<i class="el-icon-search el-icon--right"/></el-button>
                    </el-form-item>
                </el-row>
                <el-row class="ad" :style="{justifyContent:contents.btnAdAllBoxPosition=='1'?'flex-start':contents.btnAdAllBoxPosition=='2'?'center':'flex-end'}">
                    <el-form-item>
                        <el-button
                                v-if="isAuth('yonghu','新增')"
                                type="success"
                                icon="el-icon-plus"
                                @click="addOrUpdateHandler()"
                        >新增</el-button>
                        &nbsp;
                        <el-button
                                v-if="isAuth('yonghu','删除')"
                                :disabled="dataListSelections.length <= 0"
                                type="danger"
                                icon="el-icon-delete"
                                @click="deleteHandler()"
                        >删除</el-button>
                        &nbsp;
                        <el-button
                                v-if="isAuth('yonghu','报表')"
                                type="success"
                                icon="el-icon-pie-chart"
                                @click="chartDialog()"
                        >报表</el-button>
                        &nbsp;
                        <a style="text-decoration:none" class="el-button el-button--success"
                           v-if="isAuth('yonghu','导入导出')"
                           icon="el-icon-download"
                           href="http://localhost:8080/yanglaoyuanguanlixitong/upload/yonghuMuBan.xls"
                        >批量导入用户数据模板</a>
                        &nbsp;
                        <el-upload
                                v-if="isAuth('yonghu','导入导出')"
                                style="display: inline-block"
                                :action="getActionUrl"
                                :on-success="yonghuUploadSuccess"
                                :on-error="yonghuUploadError"
                                :show-file-list = false>
                            <el-button
                                    v-if="isAuth('yonghu','导入导出')"
                                    type="success"
                                    icon="el-icon-upload2"
                            >批量导入用户数据</el-button>
                        </el-upload>
                        &nbsp;
                        <!-- 导出excel -->
                        <download-excel v-if="isAuth('yonghu','导入导出')" style="display: inline-block" class = "export-excel-wrapper" :data = "dataList" :fields = "json_fields" name = "yonghu.xls">
                            <!-- 导出excel -->
                            <el-button
                                    type="success"
                                    icon="el-icon-download"
                            >导出</el-button>
                        </download-excel>
                        &nbsp;
                    </el-form-item>
                </el-row>
            </el-form>
            <div class="table-content">
                <el-table class="tables" :size="contents.tableSize" :show-header="contents.tableShowHeader"
                          :header-row-style="headerRowStyle" :header-cell-style="headerCellStyle"
                          :border="contents.tableBorder"
                          :fit="contents.tableFit"
                          :stripe="contents.tableStripe"
                          :row-style="rowStyle"
                          :cell-style="cellStyle"
                          :style="{width: '100%',fontSize:contents.tableContentFontSize,color:contents.tableContentFontColor}"
                          v-if="isAuth('yonghu','查看')"
                          :data="dataList"
                          v-loading="dataListLoading"
                          @selection-change="selectionChangeHandler">
                    <el-table-column  v-if="contents.tableSelection"
                                      type="selection"
                                      header-align="center"
                                      align="center"
                                      width="50">
                    </el-table-column>
                    <el-table-column label="索引" v-if="contents.tableIndex" type="index" width="50" />

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="username"
                                   header-align="center"
                                   label="账户">
                        <template slot-scope="scope">
                            {{scope.row.username}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="yonghuName"
                                   header-align="center"
                                   label="用户姓名">
                        <template slot-scope="scope">
                            {{scope.row.yonghuName}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="yonghuPhone"
                                   header-align="center"
                                   label="用户手机号">
                        <template slot-scope="scope">
                            {{scope.row.yonghuPhone}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="yonghuIdNumber"
                                   header-align="center"
                                   label="用户身份证号">
                        <template slot-scope="scope">
                            {{scope.row.yonghuIdNumber}}
                        </template>
                    </el-table-column>
                    <el-table-column :sortable="contents.tableSortable" :align="contents.tableAlign" prop="yonghuPhoto"
                                     header-align="center"
                                     width="200"
                                     label="用户头像">
                        <template slot-scope="scope">
                            <div v-if="scope.row.yonghuPhoto">
                                <img :src="scope.row.yonghuPhoto" width="100" height="100">
                            </div>
                            <div v-else>无图片</div>
                        </template>
                    </el-table-column>
                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                      prop="sexTypes"
                                      header-align="center"
                                      label="性别">
                        <template slot-scope="scope">
                            {{scope.row.sexValue}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="yonghuEmail"
                                   header-align="center"
                                   label="电子邮箱">
                        <template slot-scope="scope">
                            {{scope.row.yonghuEmail}}
                        </template>
                    </el-table-column>

                    <el-table-column  :sortable="contents.tableSortable" :align="contents.tableAlign"
                                   prop="newMoney"
                                   header-align="center"
                                   label="余额">
                        <template slot-scope="scope">
                            {{scope.row.newMoney}}
                        </template>
                    </el-table-column>

                    <el-table-column width="300" :align="contents.tableAlign"
                                     header-align="center"
                                     label="操作">
                        <template slot-scope="scope">
                            <el-button v-if="isAuth('yonghu','查看')" type="success" icon="el-icon-tickets" size="mini" @click="addOrUpdateHandler(scope.row.id,'info')">详情</el-button>
                            <el-button v-if="isAuth('yonghu','修改')" type="primary" icon="el-icon-edit" size="mini" @click="addOrUpdateHandler(scope.row.id)">修改</el-button>

                            <el-button v-if="isAuth('yonghu','删除')" type="danger" icon="el-icon-delete" size="mini" @click="deleteHandler(scope.row.id)">删除</el-button>

                            <el-button v-if="isAuth('yonghu','修改')" type="success" icon="el-icon-tickets" size="mini" @click="resetPassword(scope.row.id)">重置密码</el-button>
                        </template>
                    </el-table-column>
                </el-table>
                <el-pagination
                        clsss="pages"
                        :layout="layouts"
                        @size-change="sizeChangeHandle"
                        @current-change="currentChangeHandle"
                        :current-page="pageIndex"
                        :page-sizes="[10, 20, 50, 100]"
                        :page-size="Number(contents.pageEachNum)"
                        :total="totalPage"
                        :small="contents.pageStyle"
                        class="pagination-content"
                        :background="contents.pageBtnBG"
                        :style="{textAlign:contents.pagePosition==1?'left':contents.pagePosition==2?'center':'right'}"
                ></el-pagination>
            </div>
        </div>
        <!-- 添加/修改页面  将父组件的search方法传递给子组件-->
        <add-or-update v-if="addOrUpdateFlag" :parent="this" ref="addOrUpdate"></add-or-update>



        <el-dialog title="统计报表" :visible.sync="chartVisiable" width="80%">
            <el-date-picker
                    v-model="echartsDate"
                    type="year"
                    placeholder="选择年">
            </el-date-picker>
            <el-button @click="chartDialog()">查询</el-button>
            <div id="statistic" style="width:100%;height:600px;"></div>
            <span slot="footer" class="dialog-footer">
				<el-button @click="chartVisiable = false">关闭</el-button>
			</span>
        </el-dialog>

    </div>
</template>
<script>
    import AddOrUpdate from "./add-or-update";
    import styleJs from "../../../utils/style.js";
    import utilsJs from "../../../utils/utils.js";

    export default {
        data() {
        return {
            searchForm: {
                key: ""
            },
            sessionTable : "",//登录账户所在表名
            role : "",//权限
            userId:"",//当前登录人的id
    //级联表下拉框搜索条件
    //当前表下拉框搜索条件
            form:{
                id : null,
                username : null,
                password : null,
                yonghuName : null,
                yonghuPhone : null,
                yonghuIdNumber : null,
                yonghuPhoto : null,
                sexTypes : null,
                yonghuEmail : null,
                newMoney : null,
                createTime : null,
            },
            dataList: [],
            pageIndex: 1,
            pageSize: 10,
            totalPage: 0,
            dataListLoading: false,
            dataListSelections: [],
            showFlag: true,
            sfshVisiable: false,
            shForm: {},
            chartVisiable: false,
            echartsDate: new Date(),//echarts的时间查询字段
            addOrUpdateFlag:false,
            contents:null,
            layouts: '',

            //导出excel
            json_fields: {
                //级联表字段
                //本表字段
                     '账户': "username",
                     '用户姓名': "yonghuName",
                     '用户手机号': "yonghuPhone",
                     '用户身份证号': "yonghuIdNumber",
                     '用户头像': "yonghuPhoto",
                     '性别': "sexTypes",
                     '电子邮箱': "yonghuEmail",
                     '余额': "newMoney",
            },

            };
        },
        created() {
            this.contents = styleJs.listStyle();
            this.init();
            this.getDataList();
            this.contentStyleChange()
        },
        mounted() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");

        },
        filters: {
            htmlfilter: function (val) {
                return val.replace(/<[^>]*>/g).replace(/undefined/g,'');
            }
        },
        components: {
            AddOrUpdate,
        },
        computed: {
            getActionUrl: function() {
                return `/`+this.$base.name+`/file/upload`;
            }
        },
        methods: {
            chartDialog() {
                let _this = this;
                let params = {
                    dateFormat :"%Y", //%Y-%m
                    riqi :_this.echartsDate.getFullYear(),
                    // riqi :_this.echartsDate.getFullYear()+"-"+(_this.echartsDate.getMonth() + 1 < 10 ? '0' + (_this.echartsDate.getMonth() + 1) : _this.echartsDate.getMonth() + 1),
                    thisTable : {//当前表
                        tableName :'yonghu',//当前表表名,
                        sumColum : 'yonghu_number', //求和字段
                        date : 'insert_time',//分组日期字段
                        // string : 'yonghu_name',//分组字符串字段
                        // types : 'yonghu_types',//分组下拉框字段
                    },
                    // joinTable : {//级联表（可以不存在）
                    //     tableName :'yonghu',//级联表表名
                    //     // date : 'insert_time',//分组日期字段
                    //     string : 'yonghu_name',//分组字符串字段
                    //     // types : 'yonghu_types',//分组下拉框字段
                    // }
                }
                _this.chartVisiable = true;
                _this.$nextTick(() => {
                    var statistic = this.$echarts.init(document.getElementById("statistic"), 'macarons');
                    this.$http({
                        url: "barSum",
                        method: "get",
                        params: params
                    }).then(({data}) => {
                        if(data && data.code === 0){

                            //柱状图 求和 已成功使用
                            //start
                            let yAxisName = "数值";//根据查询数据具体改(单列要改,多列不改)
                            let xAxisName = "月份";
                            let series = [];//具体数据值
                            data.data.yAxis.forEach(function (item,index) {
                                let tempMap = {};
                                // tempMap.name= ["数值"];//根据查询数据具体改(单列要改,多列不改)
                                tempMap.name=data.data.legend[index];
                                tempMap.type='bar';
                                tempMap.data=item;
                                series.push(tempMap);

                            })

                            var option = {
                                tooltip: {
                                    trigger: 'axis',
                                    axisPointer: {
                                        type: 'cross',
                                        crossStyle: {
                                            color: '#999'
                                        }
                                    }
                                },
                                toolbox: {
                                    feature: {
                                        // dataView: { show: true, readOnly: false },  // 数据查看
                                        magicType: { show: true, type: ['line', 'bar'] },//切换图形展示方式
                                        // restore: { show: true }, // 刷新
                                        saveAsImage: { show: true }//保存
                                    }
                                },
                                legend: {
                                    data: data.data.legend//标题  可以点击导致某一列数据消失
                                },
                                xAxis: [
                                    {
                                        type: 'category',
                                        axisLabel:{interval: 0},
                                        name: xAxisName,
                                        data: data.data.xAxis,
                                        axisPointer: {
                                            type: 'shadow'
                                        }
                                    }
                                ],
                                yAxis: [
                                    {
                                        type: 'value',//不能改
                                        name: yAxisName,//y轴单位
                                        axisLabel: {
                                            formatter: '{value}' // 后缀
                                        }
                                    }
                                ],
                                series:series//具体数据
                            };
                            // 使用刚指定的配置项和数据显示图表。
                            statistic.setOption(option,true);
                            //根据窗口的大小变动图表
                            window.onresize = function () {
                                statistic.resize();
                            };
                            //end
                        }else {
                            this.$message({
                                message: "报表未查询到数据",
                                type: "success",
                                duration: 1500,
                                onClose: () => {
                                    this.search();
                                }
                            });
                        }
                    });
                });
                ////饼状图
                //_this.chartVisiable = true;
                // this.$nextTick(()=>{
                //     var statistic = this.$echarts.init(document.getElementById("statistic"),'macarons');
                //     let params = {
                //         tableName: "yonghu",
                //         groupColumn: "yonghu_types",
                //     }
                //     this.$http({
                //         url: "newSelectGroupCount",
                //         method: "get",
                //         params: params
                //     }).then(({data}) => {
                //         if (data && data.code === 0) {
                //             let res = data.data;
                //             let xAxis = [];
                //             let yAxis = [];
                //             let pArray = []
                //             var option = {};
                //             for(let i=0;i<res.length;i++){
                //                 xAxis.push(res[i].name);
                //                 yAxis.push(res[i].value);
                //                 pArray.push({
                //                     value: res[i].value,
                //                     name: res[i].name
                //                 })
                //                 option = {
                //                     title: {
                //                         text: '保险合同类型统计',
                //                         left: 'center'
                //                     },
                //                     tooltip: {
                //                         trigger: 'item',
                //                         formatter: '{b} : {c} ({d}%)'
                //                     },
                //                     series: [
                //                         {
                //                             type: 'pie',
                //                             radius: '55%',
                //                             center: ['50%', '60%'],
                //                             data: pArray,
                //                             emphasis: {
                //                                 itemStyle: {
                //                                     shadowBlur: 10,
                //                                     shadowOffsetX: 0,
                //                                     shadowColor: 'rgba(0, 0, 0, 0.5)'
                //                                 }
                //                             }
                //                         }
                //                     ]
                //                 };
                //             }
                //                 statistic.setOption(option);
                //                 window.onresize = function() {
                //                     statistic.resize();
                //                 };
                //         }
                //     });
                // })
            },
            contentStyleChange() {
                this.contentSearchStyleChange()
                this.contentBtnAdAllStyleChange()
                this.contentSearchBtnStyleChange()
                this.contentTableBtnStyleChange()
                this.contentPageStyleChange()
            },
            contentSearchStyleChange() {
                this.$nextTick(() => {
                    document.querySelectorAll('.form-content .slt .el-input__inner').forEach(el => {
                        let textAlign = 'left'
                        if(this.contents.inputFontPosition == 2)
                            textAlign = 'center'
                            if (this.contents.inputFontPosition == 3) textAlign = 'right'
                                el.style.textAlign = textAlign
                            el.style.height = this.contents.inputHeight
                            el.style.lineHeight = this.contents.inputHeight
                            el.style.color = this.contents.inputFontColor
                            el.style.fontSize = this.contents.inputFontSize
                            el.style.borderWidth = this.contents.inputBorderWidth
                            el.style.borderStyle = this.contents.inputBorderStyle
                            el.style.borderColor = this.contents.inputBorderColor
                            el.style.borderRadius = this.contents.inputBorderRadius
                            el.style.backgroundColor = this.contents.inputBgColor
                    })
                    if (this.contents.inputTitle) {
                        document.querySelectorAll('.form-content .slt .el-form-item__label').forEach(el => {
                            el.style.color = this.contents.inputTitleColor
                            el.style.fontSize = this.contents.inputTitleSize
                            el.style.lineHeight = this.contents.inputHeight
                        })
                    }
                    setTimeout(() => {
                        document.querySelectorAll('.form-content .slt .el-input__prefix').forEach(el => {
                            el.style.color = this.contents.inputIconColor
                            el.style.lineHeight = this.contents.inputHeight
                        })
                        document.querySelectorAll('.form-content .slt .el-input__suffix').forEach(el => {
                            el.style.color = this.contents.inputIconColor
                            el.style.lineHeight = this.contents.inputHeight
                        })
                        document.querySelectorAll('.form-content .slt .el-input__icon').forEach(el => {
                            el.style.lineHeight = this.contents.inputHeight
                        })
                    }, 10 )
                })
            },
            // 搜索按钮
            contentSearchBtnStyleChange() {
                this.$nextTick(() => {
                    document.querySelectorAll('.form-content .slt .el-button--success').forEach(el => {
                        el.style.height = this.contents.searchBtnHeight
                        el.style.color = this.contents.searchBtnFontColor
                        el.style.fontSize = this.contents.searchBtnFontSize
                        el.style.borderWidth = this.contents.searchBtnBorderWidth
                        el.style.borderStyle = this.contents.searchBtnBorderStyle
                        el.style.borderColor = this.contents.searchBtnBorderColor
                        el.style.borderRadius = this.contents.searchBtnBorderRadius
                        el.style.backgroundColor = this.contents.searchBtnBgColor
                    })
                })
            },
            // 新增、批量删除
            contentBtnAdAllStyleChange() {
                this.$nextTick(() => {
                    document.querySelectorAll('.form-content .ad .el-button--success').forEach(el => {
                        el.style.height = this.contents.btnAdAllHeight
                        el.style.color = this.contents.btnAdAllAddFontColor
                        el.style.fontSize = this.contents.btnAdAllFontSize
                        el.style.borderWidth = this.contents.btnAdAllBorderWidth
                        el.style.borderStyle = this.contents.btnAdAllBorderStyle
                        el.style.borderColor = this.contents.btnAdAllBorderColor
                        el.style.borderRadius = this.contents.btnAdAllBorderRadius
                        el.style.backgroundColor = this.contents.btnAdAllAddBgColor
                    })
                    document.querySelectorAll('.form-content .ad .el-button--danger').forEach(el => {
                        el.style.height = this.contents.btnAdAllHeight
                        el.style.color = this.contents.btnAdAllDelFontColor
                        el.style.fontSize = this.contents.btnAdAllFontSize
                        el.style.borderWidth = this.contents.btnAdAllBorderWidth
                        el.style.borderStyle = this.contents.btnAdAllBorderStyle
                        el.style.borderColor = this.contents.btnAdAllBorderColor
                        el.style.borderRadius = this.contents.btnAdAllBorderRadius
                        el.style.backgroundColor = this.contents.btnAdAllDelBgColor
                    })
                    document.querySelectorAll('.form-content .ad .el-button--warning').forEach(el => {
                        el.style.height = this.contents.btnAdAllHeight
                        el.style.color = this.contents.btnAdAllWarnFontColor
                        el.style.fontSize = this.contents.btnAdAllFontSize
                        el.style.borderWidth = this.contents.btnAdAllBorderWidth
                        el.style.borderStyle = this.contents.btnAdAllBorderStyle
                        el.style.borderColor = this.contents.btnAdAllBorderColor
                        el.style.borderRadius = this.contents.btnAdAllBorderRadius
                        el.style.backgroundColor = this.contents.btnAdAllWarnBgColor
                    })
                })
            },
            // 表格
            rowStyle({row, rowIndex}) {
                if (rowIndex % 2 == 1) {
                    if (this.contents.tableStripe) {
                        return {color: this.contents.tableStripeFontColor}
                    }
                } else {
                    return ''
                }
            },
            cellStyle({row, rowIndex}) {
                if (rowIndex % 2 == 1) {
                    if (this.contents.tableStripe) {
                        return {backgroundColor: this.contents.tableStripeBgColor}
                    }
                } else {
                    return ''
                }
            },
            headerRowStyle({row, rowIndex}) {
                return {color: this.contents.tableHeaderFontColor}
            },
            headerCellStyle({row, rowIndex}) {
                return {backgroundColor: this.contents.tableHeaderBgColor}
            },
            // 表格按钮
            contentTableBtnStyleChange() {
                // this.$nextTick(()=>{
                //   setTimeout(()=>{
                //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--success').forEach(el=>{
                //       el.style.height = this.contents.tableBtnHeight
                //       el.style.color = this.contents.tableBtnDetailFontColor
                //       el.style.fontSize = this.contents.tableBtnFontSize
                //       el.style.borderWidth = this.contents.tableBtnBorderWidth
                //       el.style.borderStyle = this.contents.tableBtnBorderStyle
                //       el.style.borderColor = this.contents.tableBtnBorderColor
                //       el.style.borderRadius = this.contents.tableBtnBorderRadius
                //       el.style.backgroundColor = this.contents.tableBtnDetailBgColor
                //     })
                //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--primary').forEach(el=>{
                //       el.style.height = this.contents.tableBtnHeight
                //       el.style.color = this.contents.tableBtnEditFontColor
                //       el.style.fontSize = this.contents.tableBtnFontSize
                //       el.style.borderWidth = this.contents.tableBtnBorderWidth
                //       el.style.borderStyle = this.contents.tableBtnBorderStyle
                //       el.style.borderColor = this.contents.tableBtnBorderColor
                //       el.style.borderRadius = this.contents.tableBtnBorderRadius
                //       el.style.backgroundColor = this.contents.tableBtnEditBgColor
                //     })
                //     document.querySelectorAll('.table-content .tables .el-table__body .el-button--danger').forEach(el=>{
                //       el.style.height = this.contents.tableBtnHeight
                //       el.style.color = this.contents.tableBtnDelFontColor
                //       el.style.fontSize = this.contents.tableBtnFontSize
                //       el.style.borderWidth = this.contents.tableBtnBorderWidth
                //       el.style.borderStyle = this.contents.tableBtnBorderStyle
                //       el.style.borderColor = this.contents.tableBtnBorderColor
                //       el.style.borderRadius = this.contents.tableBtnBorderRadius
                //       el.style.backgroundColor = this.contents.tableBtnDelBgColor
                //     })

                //   }, 50)
                // })
            },
            // 分页
            contentPageStyleChange() {
                let arr = []
                if (this.contents.pageTotal) arr.push('total')
                if (this.contents.pageSizes) arr.push('sizes')
                if (this.contents.pagePrevNext) {
                    arr.push('prev')
                    if (this.contents.pagePager) arr.push('pager')
                    arr.push('next')
                }
                if (this.contents.pageJumper) arr.push('jumper')
                this.layouts = arr.join()
                this.contents.pageEachNum = 10
            },

            init() {
            },
            search() {
                this.pageIndex = 1;
                this.getDataList();
            },
            // 获取数据列表
            getDataList() {
                this.dataListLoading = true;
                let params = {
                    page: this.pageIndex,
                    limit: this.pageSize,
                    sort: 'id',
                }

                                 
                if (this.searchForm.yonghuName!= '' && this.searchForm.yonghuName!= undefined) {
                    params['yonghuName'] = '%' + this.searchForm.yonghuName + '%'
                }
                                                        
                params['yonghuDelete'] = 1// 逻辑删除字段 1 未删除 2 删除


                this.$http({
                    url: "yonghu/page",
                    method: "get",
                    params: params
                }).then(({data}) => {
                    if(data && data.code === 0){
                        this.dataList = data.data.list;
                        this.totalPage = data.data.total;
                    }else{
                        this.dataList = [];
                        this.totalPage = 0;
                    }
                    this.dataListLoading = false;
                });

                //查询级联表搜索条件所有列表
                //查询当前表搜索条件所有列表
            },
            //每页数
            sizeChangeHandle(val) {
                this.pageSize = val;
                this.pageIndex = 1;
                this.getDataList();
            },
            // 当前页
            currentChangeHandle(val) {
                this.pageIndex = val;
                this.getDataList();
            },
            // 多选
            selectionChangeHandler(val) {
                this.dataListSelections = val;
            },
            // 添加/修改
            addOrUpdateHandler(id, type) {
                this.showFlag = false;
                this.addOrUpdateFlag = true;
                this.crossAddOrUpdateFlag = false;
                if (type != 'info') {
                    type = 'else';
                }
                this.$nextTick(() => {
                    this.$refs.addOrUpdate.init(id, type);
                });
            },
            // 下载
            download(file) {
                window.open(" ${file} ")
            },
            // 删除
            deleteHandler(id) {
                var ids = id ? [Number(id)] : this.dataListSelections.map(item => {
                    return Number(item.id);
                });

                this.$confirm(`确定进行[${id ? "删除" : "批量删除"}]操作?`, "提示", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                }).then(() => {
                    this.$http({
                        url: "yonghu/delete",
                        method: "post",
                        data: ids
                    }).then(({data}) => {
                        if(data && data.code === 0){
                            this.$message({
                                message: "操作成功",
                                type: "success",
                                duration: 1500,
                                onClose: () => {
                                    this.search();
                                }
                            });
                        }else{
                            this.$message.error(data.msg);
                        }
                    });
                });
            },
            resetPassword(id) {
                let _this = this;
                //重置密码
                this.$http({
                    url: "yonghu/resetPassword?id=" + id,
                    method: "get",
                    // id:id
                }).then(({data}) => {
                    if(data && data.code === 0){
                        _this.$message({
                            message: '重置成功,密码已重置为123456',
                            type: 'success'
                        });
                    }
                });
            },
            // 导入功能上传文件成功后调用导入方法
            yonghuUploadSuccess(data){
                let _this = this;
                _this.$http({
                    url: "yonghu/batchInsert?fileName=" + data.file,
                    method: "get"
                }).then(({data}) => {
                    if(data && data.code === 0){
                        _this.$message({
                            message: "导入用户数据成功",
                            type: "success",
                            duration: 1500,
                            onClose: () => {
                                _this.search();
                            }
                        });
                    }else{
                        _this.$message.error(data.msg);
                    }
                });

            },
            // 导入功能上传文件失败后调用导入方法
            yonghuUploadError(data){
                this.$message.error('上传失败');
            },
        }
    };
</script>
<style lang="scss" scoped>
.slt {
    margin: 0 !important;
    display: flex;
  }

  .ad {
    margin: 0 !important;
    display: flex;
  }

  .pages {
    & /deep/ el-pagination__sizes{
      & /deep/ el-input__inner {
        height: 22px;
        line-height: 22px;
      }
    }
  }


  .el-button+.el-button {
    margin:0;
  }

  .tables {
	& /deep/ .el-button--success {
		height: 40px;
		color: rgba(255, 255, 255, 1);
		font-size: 14px;
		border-width: 5px           ;
		border-style: double;
		border-color: rgba(255, 255, 255, 1);
		border-radius: 30px 0px 0px 0px;
		background-color: rgba(48, 208, 182, 1);
	}

	& /deep/ .el-button--primary {
		height: 40px;
		color: rgba(255, 255, 255, 1);
		font-size: 14px;
		border-width: 5px           ;
		border-style: double;
		border-color: rgba(255, 255, 255, 1);
		border-radius: 30px 0px 0px 0px;
		background-color: rgba(48, 208, 182, 1);
	}

	& /deep/ .el-button--danger {
		height: 40px;
		color: rgba(255, 255, 255, 1);
		font-size: 14px;
		border-width: 5px           ;
		border-style: double;
		border-color: rgba(255, 255, 255, 1);
		border-radius: 30px 0px 0px 0px;
		background-color: rgba(48, 208, 182, 1);
	}

    & /deep/ .el-button {
      margin: 4px;
    }
  }
	.form-content {
		background: transparent;
	}
	.table-content {
		background: transparent;
	}

	.tables /deep/ .el-table__body tr {
				background-color: rgba(252, 253, 253, 1) !important;
				color: #606266 !important;
	 }
	.tables /deep/ .el-table__body tr.el-table__row--striped td {
	    background: transparent;
	}
	.tables /deep/ .el-table__body tr.el-table__row--striped {
		background-color: rgba(252, 253, 253, 1) !important;
		color: #606266 !important;
	}

	 .tables /deep/ .el-table__body tr:hover>td {
	   	   background-color: rgba(245, 245, 245, 1) !important;
	   	   	   color: #333 !important;
	   	 }</style>


