import { Layout, Menu } from 'antd';
import { Icon } from '@ant-design/compatible';
import React, { Component } from 'react';
import 'antd/dist/antd.css';
import logo from '../logo.svg';
import {BrowserRouter as Router,Route,Link} from 'react-router-dom'
import './Surface.css'

import CustomerInfo from '../components/Customer';
import Detail from '../components/TransactionDetail';
import Chart from '../components/Chart';
import DailySummary from "../components/DailySummary";

const { Header, Content, Footer, Sider } = Layout;

class SurfaceDemo extends Component {
    state = {
        collapsed: false,
        mode: 'inline',
    };

    toggle = () => {
        this.setState({
            collapsed: !this.state.collapsed,
        });
    }

    render() {
        return (
            <Layout>
                <Router>
                <Sider
                    trigger={null}
                    collapsible
                    collapsed={this.state.collapsed}
                >
                    <div className="logo" />
                    <Menu theme="dark" mode="inline" defaultSelectedKeys={['1']}>
                        <Menu.Item key="1">
                            <Icon type="user" />
                            <span className="nav-text">
                                <Link to="/customer-info">客户列表</Link>
                            </span>
                        </Menu.Item>

                        <Menu.Item key="2">
                            <Icon type="smile" />
                            <span className="nav-text">
                                <Link to="/transaction-detail">交易列表</Link>
                            </span>
                        </Menu.Item>
                        <Menu.Item key="3">
                            <Icon type="table" />
                            <span className="nav-text">
                                <Link to="/daily-summary">日汇总列表</Link>
                            </span>
                        </Menu.Item>
                        <Menu.Item key="4">
                            <Icon type="picture" />
                            <span className="nav-text">
                                <Link to="/charts">图表展示</Link>
                            </span>
                        </Menu.Item>
                    </Menu>
                    
                </Sider>
                <Layout>
                    <Header style={{ background: '#000', padding: 0 }}>
                        <span style={{color:'#fff', paddingLeft:'2%', fontSize:'1.4em'}}>
                            <Icon
                                className="trigger"
                                type={this.state.collapsed ? 'menu-unfold' : 'menu-fold'}
                                onClick={this.toggle}
                                style={{cursor: 'pointer'}}
                            />
                        </span>
                        <span style={{color:'#fff', paddingLeft:'2%', fontSize:'1.4em'}}>数据报表</span>
                        <span style={{color:'#fff', float:'right', paddingRight:'1%'}}>
                            <img src={logo} className="App-logo" alt="logo" />
                        </span>
                    </Header>
                    <Content style={{ margin: '0 16px' }}>
                        <div style={{ padding: 24, background: '#fff', minHeight: 780 }}>
                            <Route exact path="/customer-info" component={CustomerInfo}></Route>
                            <Route path="/daily-summary" component={DailySummary}></Route>
                            <Route path="/transaction-detail" component={Detail}></Route>
                            <Route path="/charts" component={Chart}></Route>

                        </div>
                    </Content>
                    <Footer style={{ textAlign: 'center' }}>
                        Ant Design ©2016 Created by Ant UED
                    </Footer>
                </Layout>
                </Router>
            </Layout>
        );
    }
}

export default SurfaceDemo;