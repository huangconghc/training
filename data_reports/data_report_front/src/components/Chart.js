import React,{Component} from 'react';
import ReactEcharts from 'echarts-for-react';
import axios from 'axios';

class Chart extends Component {
    constructor(props){
        super(props);
        this.state= { // 折线图
            option: {},
            // 柱状图
            option1: {},
            // 饼图
            option2: {},

        };
    };

    componentDidMount() {
        const _this = this;
        axios.get('http://localhost:8082/daily-census').then(function(response){
            // console.log(response)
            let result = response.data.data;
            let xresult = [];
            let yresult = [];
            console.log(result);
            for(let i = 0; i < result.length; i++) {
                xresult[i] = result[i].day;
                yresult[i] = result[i].amount
            }
            _this.setState({
                option:{
                    title: { text: '一个月每天的交易总金额' },
                    xAxis: {
                        type: 'category',
                        data: xresult,
                    },
                    yAxis: {
                        type: 'value'
                    },
                    series: [{
                        data: yresult,
                        type: 'line'
                    }],
                    tooltip : {
                        trigger: 'axis',
                        axisPointer: {
                          type: 'cross',
                          label: {
                            backgroundColor: '#6a7985'
                          }
                        }
                      },
                }        
            })
        }).catch(function(error){
            console.log(error);
        });

        axios.get('http://localhost:8082/tran-num').then(function(response){
            let result = response.data.data;
            let xresult = [];
            let yresult = [];
            console.log(result);
            for(let i = 0; i < result.length; i++) {
                xresult[i] = result[i].cusName;
                yresult[i] = result[i].tranNum
            }
            _this.setState({
                option1:{

                    title: { text: '三个月消费笔数' },
                    tooltip: {},
                    xAxis: {
                        axisLabel: {
                            interval:0,//显示所有x轴标签显示
                            rotate:45, //逆时针旋转45度
                        },
                        data: xresult
                    },
                    yAxis: {},
                    series: [{
                        name: '消费笔数',
                        type: 'bar',
                        data: yresult
                    }]
                },       
            })
        }).catch(function(error){
            console.log(error);
        });

        axios.get('http://localhost:8082/pay-tran').then(function(response){
            // console.log(response)
            let result = response.data.data;
            console.log(result);
            let tran_amt = result.tran;
            let pay_amt = result.pay;
            _this.setState({
                option2:{
                    title: {
                        text: '一个月的消费总金额和还款总金额占比',
                        left: 'left'
                    },
                    tooltip: {
                        trigger: 'item',
                        formatter: '{a} <br/>{b} : {c} ({d}%)'
                    },                    
                    legend: {
                        orient: 'vertical',
                        left: 'right',
                    },
                    series: [
                        {
                            name: '交易金额',
                            type: 'pie',
                            radius: '55%',
                            data: [
                                {value: tran_amt, name: '消费总金额'},
                                {value: pay_amt, name: '还款总金额'},
                            ]
                        }
                    ]
                },       
            })
        }).catch(function(error){
            console.log(error);
        });   
    }

    render (){
        return(
            <div>
                {/* <div id= "main1" style={{ width: 1000, height: 400 }}></div> */}
                <ReactEcharts
                    style = {{ width: 1000, height: 400}}
                    notMerge = { true }
                    lazyUpdate = { true }
                    option = { this.state.option }
                />
                <ReactEcharts
                    style = {{ width: 1000, height: 400}}
                    notMerge = { true }
                    lazyUpdate = { true }
                    option = { this.state.option1 }
                />
                <ReactEcharts
                    style = {{ width: 1000, height: 400}}
                    notMerge = { true }
                    lazyUpdate = { true }
                    option = { this.state.option2 }
                />
                
            </div>
            
        )
    }
}

export default Chart;