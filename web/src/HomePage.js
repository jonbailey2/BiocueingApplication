import React, { useState } from 'react';

import { LaptopOutlined, NotificationOutlined, UserOutlined, HomeOutlined } from '@ant-design/icons';
import { Button } from 'antd';
import { Typography } from 'antd';

import ClientPage from './user/ClientPage'

import { createMedicalInfo } from './api/Client.js'
import { Breadcrumb, Layout, Menu, theme } from 'antd';
const { Header, Content, Footer } = Layout;

const siderNavItem = ['Home', 'Client'];

const items = [HomeOutlined, UserOutlined].map(
  (icon, index) => ({
    key: String(index + 1),
    icon: React.createElement(icon),
    label: siderNavItem[index],
  }),
);

const HomePage = () => {
  const {
    token: { colorBgContainer, borderRadiusLG },
  } = theme.useToken();

  return (
    <Layout>
      <Header
        style={{
          position: 'sticky',
          top: 0,
          zIndex: 1,
          width: '100%',
          display: 'flex',
          alignItems: 'center',
        }}
      >
      <Menu
        theme="dark"
        mode="horizontal"
        defaultSelectedKeys={['1']}
        items={items}
        style={{ flex: 1, minWidth: 0 }}
      />
      </Header>
    <Layout>
      <Content
        style={{
          padding: '0 48px',
        }}
      >
        <div
          style={{
            padding: 24,
            minHeight: 600,
            marginTop: 30,
            background: colorBgContainer,
            borderRadius: borderRadiusLG,
          }}
        >
          <ClientPage />
        </div>
      </Content>
      <Footer
        style={{
          textAlign: 'center',
        }}
      >
         {new Date().getFullYear()} Created by Jon Bailey
      </Footer>
      </Layout>
    </Layout>
  );
};

export default HomePage;
