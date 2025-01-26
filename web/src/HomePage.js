import React, { useState } from 'react';

import { CalendarOutlined, MailOutlined, UserOutlined, HomeOutlined } from '@ant-design/icons';
import { BrowserRouter as Router, Route, Routes, Link } from 'react-router-dom';
import { Button } from 'antd';
import { Typography } from 'antd';

import WelcomePage from './components/WelcomePage';
import ClientPage from './user/ClientPage';
import CalendarPage from './components/CalendarPage';
import NotificationsPage from './components/NotificationsPage';

import { createMedicalInfo } from './api/Client.js'
import { Breadcrumb, Layout, Menu, theme } from 'antd';
const { Header, Content, Sider, Footer } = Layout;

const siderItems = [
    { key: '0', icon: <HomeOutlined />, label: 'Home' },
    { key: '1', icon: <UserOutlined />, label: 'Clients' },
    { key: '2', icon: <CalendarOutlined />, label: 'Calendar' },
    { key: '3', icon: <MailOutlined />, label: 'Notifications' },
];

const HomePage = () => {
  const [selectedPage, setSelectedPage] = useState('0');

  const {
    token: { colorBgContainer, borderRadiusLG },
  } = theme.useToken();

  const handleMenuClick = (e) => {
    setSelectedPage(e.key);
  };

  return (
  <Layout>
    <Sider width={200} >
      <Menu
        theme="dark"
        mode="inline"
        items={siderItems}
        onClick={handleMenuClick}
        style={{ borderRight: 0, height: '100vh', marginTop: '4vh', position: 'sticky'}}
      />
    </Sider>
    <Layout>
      <Content
        style={{
          padding: '0 48px',
        }}
      >
        <div
          style={{
            padding: 24,
            minHeight: '90vh',
            marginTop: 30,
            background: colorBgContainer,
            borderRadius: borderRadiusLG,
          }}
        >
          {selectedPage === '0' && <WelcomePage />}
          {selectedPage === '1' && <ClientPage />}
          {selectedPage === '2' && <CalendarPage />}
          {selectedPage === '3' && <NotificationsPage />}
        </div>
      </Content>
      <Footer
        style={{
          textAlign: 'center',
        }}
      >
        <div style={{ textAlign: 'center' }}>
            BioCue ©2025 | Empowering Psychiatry with Biometric Insights
        </div>
       {new Date().getFullYear()} Created by Jon Bailey
      </Footer>
      </Layout>
    </Layout>
  );
};

export default HomePage;