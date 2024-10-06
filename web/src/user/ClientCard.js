import React, { useState } from "react";
import { Link } from "react-router-dom";
import { EditOutlined, EllipsisOutlined, LineChartOutlined } from '@ant-design/icons';
import { Avatar, Card, theme } from 'antd';

import BioCard from './BioInfo.js';
import EditClient from './EditClient.js';

import '../style/ClientCard.css';

const { Meta } = Card;

const ClientCard = ({ client }) => {
    const [isBioInfoVisible, setIsBioInfoVisible] = useState(false);
    const [isEditOpen, setIsEditOpen] = useState(false);

    const showBioInfo = () => {
        setIsBioInfoVisible(true);
    };

    const hideBioInfo = () => {
        setIsBioInfoVisible(false);
    };

    const showEditWindow = () => {
        setIsEditOpen(true);
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
    {isEditOpen &&
        <div className="modal-overlay">
            <div className="modal-card">
                <EditClient client={client} isEditOpen={isEditOpen} setIsEditOpen={setIsEditOpen} />
            </div>
        </div>
    }
     {!isBioInfoVisible && !isEditOpen &&
         <Card
            style={{ width: 300 , marginTop: '25px', backgroundColor: 'rgb(192, 203, 204)'}}
            hoverable={true}
            actions={[
              <LineChartOutlined key="metrics" onClick = {showBioInfo} style = {{fontSize: '20px'}} />,
              <EditOutlined key="edit" onClick = {showEditWindow} style = {{fontSize: '20px'}} />,
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
