import React,{Component} from 'react';
import {Table, Button} from 'antd';
import axios from 'axios';

const columns = [
    {
        title: '索引项',
        dataIndex: 'sIndex',
        key: 'name',
        align: 'center',
    },
    {
        title: '客户号',
        dataIndex: 'custId',
        align: 'center',
    },
    {
        title: '更新时间',
        dataIndex: 'updateTime',
        align: 'center',
    },
    {
        title: '日期',
        dataIndex: 'transDate',
        align: 'center',
    },
    {
        title: '客户姓名',
        dataIndex: 'surname',
        align: 'center',
    },
    {
        title: '最大交易额',
        dataIndex: 'tranMaxAmt',
        align: 'center',
    },

    {
        title: '当天消费笔数',
        dataIndex: 'tranCnt',
        align: 'center',
    },
    {
        title: '当天还款笔数',
        dataIndex: 'payCnt',
        align: 'center',
    },
    {
        title: '当天消费金额',
        dataIndex: 'tranAmt',
        align: 'center',
    },
    {
        title: '当天还款金额',
        dataIndex: 'payAmt',
        align: 'center',
    },

];

class DailySummary extends Component {
    constructor(props){
        super(props);
        this.state={
            dataSource: [],
        };
    }

    onUpdate = () => {
        const that = this;
        console.log(that);
        axios.get('http://localhost:8082/update-daily-summary').then((response)=>{
            let result = response.data.data;
            that.setState ({
                dataSource: result
            })
        }).catch(error => console.log(error));
    }


    componentDidMount(){
        const _this = this;
        axios.get('http://localhost:8082/all').then(function(response){
            console.log(response)
            let result = response.data.data;
            _this.setState({
                dataSource: result
            })
            console.log(result);
        }).catch(function(error){
            console.log(error);
        })
    }

    render (){
        return(
            <div>
                <Button
                    type="primary "
                    onClick={this.onUpdate}
                    size="large"
                ></Button>

                <Table
                    bordered
                    dataSource={this.state.dataSource}
                    columns={columns}
                />
            </div>
        )
    }
}

export default DailySummary;