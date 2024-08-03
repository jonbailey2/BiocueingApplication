import React, { useState } from 'react';

import { LaptopOutlined, NotificationOutlined, UserOutlined } from '@ant-design/icons';
import { Layout, Menu, theme } from 'antd';
import moneyMonster from '/Users/jonbailey/Repositories/Wage Monster/web/src/images/money_monster.png'
import skyline from '/Users/jonbailey/Repositories/Wage Monster/web/src/images/skyline.png'
import { Typography} from 'antd';
import UpdateProfile from './user/UpdateProfile.js'

const { Header, Content, Sider } = Layout;
const { Title } = Typography;
const items1 = ['1', '2', '3'].map((key) => ({
  key,
  label: `nav ${key}`,
}));
const categories = ['<User Name>', 'Companies', 'Announcements']
const options = ['Log Payment', 'History', 'Update Profile','Your Companies', 'Hiring Near You', 'Risers','Search', 'For You', 'Top of the Week']
const items2 = [UserOutlined, LaptopOutlined, NotificationOutlined].map((icon, index) => {
  const key = String(index);
  return {
    key: `sub${key}`,
    icon: React.createElement(icon),
    label: categories[key],
    children: new Array(3).fill(null).map((_, j) => {
      const subKey = index * 3 + j;
      return {
        key: subKey,
        label: options[subKey],
      };
    }),
  };
});

const HomePage = () => {
    const testUser = {
        username: 'testUsername',
        name: 'Maria Bailey',
        dateOfBirth: '2003-07-27',
        companies: ['Rock Bottom', 'Outback'],
    };

    const [user, setUser] = useState(testUser);

    const handleSave = (updatedUser) => {
        setUser(updatedUser);
        console.log('User saved:', updatedUser);
    };

    const {
        token: { colorBgContainer, borderRadiusLG },
    } = theme.useToken();
  return (
    <Layout>
      <Header
        style={{
          display: 'flex',
          alignItems: 'center',
          height: '80px',
        }}
      >
        <img src = {moneyMonster} alt = "NYC" style = {{height: '150%', width:'auto'}}/>
        <Title style = {{color: 'white', margin: 'auto'}}>Wage Monster</Title>
      </Header>

      <Layout>
        <Sider
          width={200}
          style={{
            background: colorBgContainer,
          }}
        >
          <Menu
            mode="inline"
            defaultSelectedKeys={['1']}
            defaultOpenKeys={['sub1']}
            theme='dark'
            triggerSubMenuAction='click'
            style={{
              height: '100vh',
              borderRight: 0,
            }}
            items={items2}
          />
        </Sider>

        <Layout
          style={{
            padding: '0 24px 24px',
          }}
        >
          <Content
            style={{
              padding: 24,
              margin: 0,
              minHeight: 280,
              background: colorBgContainer,
              borderRadius: borderRadiusLG,
            }}
          >
            <UpdateProfile user={testUser} onSave={handleSave}/>
          </Content>
        </Layout>
      </Layout>
    </Layout>
  );
};

export default HomePage;
