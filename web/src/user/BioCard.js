import React from "react";

import { ArrowDownOutlined, ArrowUpOutlined } from '@ant-design/icons';
import { Card, Col, Row, Statistic } from 'antd';

const BioCard = ({ client, hideBioInfo }) => {

    // Return true if val1(current metric) is higher than val2(avg metric)
    const compareValues = (val1, val2) => {
        return val1 > val2;
    };

    return (
      <div>
        <h2>{client.name}&apos;s Biometric Data </h2>

        <div className="body-temp">
          <h3 style={{textAlign:"left"}}>Body Temperature</h3>
          <Row gutter={16}>
            <Col span={12}>
              <Card bordered={true} hoverable={true}>
                <Statistic
                  title= "Current"
                  value={client.currTemp}
                  precision={1}
                  valueStyle={{ color: '#3f8600' }}
                  suffix="°F"
                />
              </Card>
            </Col>
            <Col span={12}>
              <Card bordered={true} hoverable={true}>
              {compareValues(client.avgTemp, client.prevAvgTemp) ? (
                <Statistic
                  title="Monthly Average"
                  value={client.avgTemp}
                  precision={1}
                  valueStyle={{ color: '#cf1322' }}
                  prefix={<ArrowUpOutlined />}
                  suffix="°F"
                />
              ) : (
                <Statistic
                  title="Monthly Average"
                  value={client.avgTemp}
                  precision={1}
                  valueStyle={{ color: '#3f8600' }}
                  prefix={<ArrowDownOutlined />}
                  suffix="°F"
                />
              )}
              </Card>
            </Col>
          </Row>
        </div>
        <div className="heart-rate">
          <h3 style={{textAlign:"left"}}>Heart Rate</h3>
          <Row gutter={16}>
            <Col span={12}>
              <Card bordered={true} hoverable={true}>
                <Statistic
                  title= "Current"
                  value={client.currHeartRate}
                  precision={1}
                  valueStyle={{ color: '#3f8600' }}
                  suffix="bpm"
                />
              </Card>
            </Col>
            <Col span={12}>
              <Card bordered={true} hoverable={true}>
              {compareValues(client.avgHeartRate, client.prevAvgHeartRate) ? (
                <Statistic
                  title="Monthly Average"
                  value={client.avgHeartRate}
                  precision={1}
                  valueStyle={{ color: '#cf1322' }}
                  prefix={<ArrowUpOutlined />}
                  suffix="bpm"
                />
              ) : (
                <Statistic
                  title="Monthly Average"
                  value={client.avgHeartRate}
                  precision={1}
                  valueStyle={{ color: '#3f8600' }}
                  prefix={<ArrowDownOutlined />}
                  suffix="bpm"
                />
              )}
              </Card>
            </Col>
          </Row>
        </div>
        <div className="perspiration">
          <h3 style={{textAlign:"left"}}>Perspiration</h3>
          <Row gutter={16}>
            <Col span={12}>
              <Card bordered={true} hoverable={true}>
                <Statistic
                  title= "Current"
                  value={client.currPerspiration}
                  precision={1}
                  valueStyle={{ color: '#3f8600' }}
                />
              </Card>
            </Col>
            <Col span={12}>
              <Card bordered={true} hoverable={true}>
              {compareValues(client.avgPerspiration, client.prevAvgPerspiration) ? (
                <Statistic
                  title="Monthly Average"
                  value={client.avgPerspiration}
                  precision={1}
                  valueStyle={{ color: '#cf1322' }}
                  prefix={<ArrowUpOutlined />}
                />
              ) : (
                <Statistic
                  title="Monthly Average"
                  value={client.avgPerspiration}
                  precision={1}
                  valueStyle={{ color: '#3f8600' }}
                  prefix={<ArrowDownOutlined />}
                />
              )}
              </Card>
            </Col>
          </Row>
        </div>
        <button onClick={hideBioInfo} style={{marginTop:'20px'}}>Close</button>
      </div>
    );

};

export default BioCard;