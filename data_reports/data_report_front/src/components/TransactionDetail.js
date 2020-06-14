import React,{Component} from 'react';
import {Table, Input, Button} from 'antd';
import axios from 'axios';

const {  } = Input;
const columns = [
    {
        title: '交易id',
        dataIndex: 'transId',
        key: 'name',
        align: 'center',
    },
    {
        title: '客户id',
        dataIndex: 'custId',
        align: 'center',
    },
    {
        title: '账户号',
        dataIndex: 'account',
        align: 'center',
    },
    {
        title: '卡号',
        dataIndex: 'cardNbr',
        align: 'center',
    },
    {
        title: '交易流水号',
        dataIndex: 'tranno',
        align: 'center',
    },
    {
        title: '账单月',
        dataIndex: 'monthNbr',
        align: 'center',
    },
    {
        title: '交易金额',
        dataIndex: 'bill',
        align: 'center',
    },
    {
        title: '交易类型',
        dataIndex: 'transType',
        align: 'center',
    },
    {
        title: '交易时间',
        dataIndex: 'txnDatetime',
        align: 'center',
    },
];

class TransactionDetail extends Component {
    constructor(props){
        super(props);
        this.state={
            dataSource: [],
        };
    }
    onSearchHandler = (value) => {
        const that = this;
        console.log(that);
        axios.get('http://localhost:8082/transaction-detail/sort/'+value).then((response)=>{
          let result = response.data.data;
          that.setState ({
            dataSource: result
          })
        }).catch(error => console.log(error));
    }

    onSortNameHandler = () => {
        const that = this;
        console.log(that);
        axios.get('http://localhost:8082/transaction-detail/sort/surname').then((response)=>{
          let result = response.data.data;
          that.setState ({
            dataSource: result
          })
        }).catch(error => console.log(error));
    }



    onSortBillHandler = () => {
        const that = this;
        console.log(that);
        axios.get('http://localhost:8082/transaction-detail/sort-bill').then((response)=>{
          let result = response.data.data;
          that.setState ({
            dataSource: result
          })
        }).catch(error => console.log(error));
    }


    componentDidMount(){
        const _this = this;
        axios.get('http://localhost:8082/TransacTiondetails/getAll').then(function(response){
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
                {/*<Search */}
{/*                placeholder="请输入客户id"*/}
                {/*enterButton="搜索"*/}
{/*                style={{ width: 300, marginBottom: "10px", marginRight: "30px" }}*/}
                {/*size="large"*/}
{/*                onSearch={this.onSearchHandler}*/}
{/*              />*/}

               <Button
                type="primary "
                onClick={this.onSortBillHandler}
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

export default TransactionDetail;