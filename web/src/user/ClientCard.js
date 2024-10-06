import React, { useState } from "react";
import { Link } from "react-router-dom";
import { EditOutlined, EllipsisOutlined, LineChartOutlined } from '@ant-design/icons';
import { Avatar, Card, theme } from 'antd';

import BioCard from './BioCard';

import '../style/ClientCard.css';

const { Meta } = Card;

const ClientCard = ({ client }) => {
    const [isBioInfoVisible, setIsBioInfoVisible] = useState(false);

    const showBioInfo = () => {
        setIsBioInfoVisible(true);
    };

    const hideBioInfo = () => {
        setIsBioInfoVisible(false);
    };

    const {
      token: { colorBgContainer, borderRadiusLG },
    } = theme.useToken();

    return (
    <>
    {isBioInfoVisible &&
        <div className="modal-overlay">
            <div className="modal-card">
                <BioCard client={client} hideBioInfo={hideBioInfo} />
            </div>
        </div>
     }
     {!isBioInfoVisible &&
         <Card
            style={{ width: 300 , marginTop: '25px', backgroundColor: 'rgb(192, 203, 204)'}}
            hoverable={true}
            actions={[
              <LineChartOutlined key="metrics" onClick = {showBioInfo} style = {{fontSize: '20px'}} />,
              <EditOutlined key="edit" style = {{fontSize: '20px'}} />,
              <EllipsisOutlined key="ellipsis" style = {{fontSize: '20px'}} />,
            ]}
          >
            <Meta
              title={client.name}
              description = {"Next Session: " + client.nextSession}
            />
          </Card>
      }
    </>
    );
};

export default ClientCard;
