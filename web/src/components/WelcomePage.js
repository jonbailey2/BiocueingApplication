import React from "react";

import { Layout, Menu, Typography, Button, Row, Col, Card, theme } from 'antd';
import { HeartOutlined, BarChartOutlined, EyeOutlined } from '@ant-design/icons';

const { Header, Content, Footer } = Layout;
const { Title, Paragraph } = Typography;

const WelcomePage = () => {

  const {
    token: { colorBgContainer, borderRadiusLG },
  } = theme.useToken();

  return (
  <Layout>
        {/* Hero Section */}
        <Content
          style={{
            padding: '0 50px',
            marginTop: 64,
            background: "#585858",
            backgroundSize: 'cover',
            backgroundPosition: 'center',
            color: 'white',
            textAlign: 'center',
          }}
        >
          <div style={{ padding: '100px 0' }}>
            <Title style={{ color: 'white' }}>Monitor Emotions in Real Time</Title>
            <Paragraph style={{ color: 'white', fontSize: '1.2rem' }}>
              Leverage biometric data to detect emotional spikes and gain valuable insights into patient well-being.
            </Paragraph>
            <Button type="primary" size="large" style={{ marginTop: '20px' }}>
              Get Started
            </Button>
          </div>
        </Content>

        {/* Features Section */}
        <Content style={{ padding: '50px' }}>
          <Title level={2} style={{ textAlign: 'center', marginBottom: '40px' }}>
            Why Choose Mood Sync?
          </Title>
          <Row gutter={[16, 16]} justify="center">
            <Col xs={24} sm={12} md={8}>
              <Card
                hoverable
                cover={<HeartOutlined style={{ fontSize: '48px', color: '#4caf50', padding: '20px' }} />}
              >
                <Title level={4}>Real-Time Monitoring</Title>
                <Paragraph>
                  Track biometric data such as heart rate and skin conductance to detect emotional spikes instantly.
                </Paragraph>
              </Card>
            </Col>
            <Col xs={24} sm={12} md={8}>
              <Card
                hoverable
                cover={<BarChartOutlined style={{ fontSize: '48px', color: '#4caf50', padding: '20px' }} />}
              >
                <Title level={4}>Actionable Insights</Title>
                <Paragraph>
                  Use detailed reports and trends to better understand patient emotions and tailor care strategies.
                </Paragraph>
              </Card>
            </Col>
            <Col xs={24} sm={12} md={8}>
              <Card
                hoverable
                cover={<EyeOutlined style={{ fontSize: '48px', color: '#4caf50', padding: '20px' }} />}
              >
                <Title level={4}>Enhanced Visibility</Title>
                <Paragraph>
                  Access real-time visualizations to track biometric data trends and emotional states.
                </Paragraph>
              </Card>
            </Col>
          </Row>
        </Content>

        {/* Call-to-Action Section */}
        <Content style={{ backgroundColor: '#4caf50', color: 'white', textAlign: 'center', padding: '50px 20px' }}>
          <Title level={2} style={{ color: 'white' }}>
            Ready to Transform Your Practice?
          </Title>
          <Paragraph style={{ color: 'white', fontSize: '1.2rem' }}>
            Sign up today and start leveraging Mood Sync to deliver better patient care with real-time emotional insights.
          </Paragraph>
          <Button size="large" style={{ backgroundColor: 'white', color: '#4caf50', border: 'none', marginTop: '20px' }}>
            Sign Up Now
          </Button>
        </Content>
      </Layout>
    );
}

export default WelcomePage;