import React, { useState, useEffect } from "react";
import ClientCard from "./ClientCard";
import { Divider, Carousel, Row, Col, Input, Button } from 'antd';
import { PlusOutlined } from '@ant-design/icons';
import AddClient from './AddClient';

import '../style/ClientCard.css';

const { Search } = Input;

const clients = [
    { id: 1, name: 'John Doe', age: 32, nextSession: '2024-08-10',
        avgTemp: 97.9, avgHeartRate: 80, avgPerspiration: 5.0,
        currTemp: 97.9, currHeartRate: 80, currPerspiration: 5.0,
        prevAvgTemp: 96, prevAvgHeartHeart: 85, prevAvgPerspiration: 4.3},
    { id: 2, name: 'Jane Smith', age: 29, nextSession: '2024-08-20',
        avgTemp: 97.9, avgHeartRate: 80, avgPerspiration: 5.0,
        currTemp: 97.9, currHeartRate: 80, currPerspiration: 5.0,
        prevAvgTemp: 99, prevAvgHeartHeart: 85, prevAvgPerspiration: 4.3},
    { id: 3, name: 'Robert Johnson', age: 45, nextSession: '2024-08-25',
        avgTemp: 97.9, avgHeartRate: 80, avgPerspiration: 5.0,
        currTemp: 97.9, currHeartRate: 80, currPerspiration: 5.0,
        prevAvgTemp: 99, prevAvgHeartHeart: 85, prevAvgPerspiration: 4.3},
    { id: 4, name: 'Emily Davis', age: 38, nextSession: '2024-09-02',
        avgTemp: 97.9, avgHeartRate: 80, avgPerspiration: 5.0,
        currTemp: 97.9, currHeartRate: 80, currPerspiration: 5.0,
        prevAvgTemp: 99, prevAvgHeartHeart: 85, prevAvgPerspiration: 4.3},
    { id: 5, name: 'Michael Brown', age: 41, nextSession: '2024-09-05',
        avgTemp: 97.9, avgHeartRate: 80, avgPerspiration: 5.0,
        currTemp: 97.9, currHeartRate: 80, currPerspiration: 5.0,
        prevAvgTemp: 99, prevAvgHeartHeart: 85, prevAvgPerspiration: 4.3},
    { id: 6, name: 'Sarah Wilson', age: 27, nextSession: '2024-09-10',
        avgTemp: 97.9, avgHeartRate: 80, avgPerspiration: 5.0,
        currTemp: 97.9, currHeartRate: 80, currPerspiration: 5.0,
        prevAvgTemp: 99, prevAvgHeartHeart: 85, prevAvgPerspiration: 4.3},
    { id: 7, name: 'Chris Lee', age: 34, nextSession: '2024-09-11',
        avgTemp: 97.9, avgHeartRate: 80, avgPerspiration: 5.0,
        currTemp: 97.9, currHeartRate: 80, currPerspiration: 5.0,
        prevAvgTemp: 99, prevAvgHeartHeart: 85, prevAvgPerspiration: 4.3},
];

// Function to group clients into rows of 3
const chunkArray = (arr, size) => {
    const chunks = [];
    for (let i = 0; i < arr.length; i += size) {
        chunks.push(arr.slice(i, i + size));
    }
    return chunks;
};

const ClientPage = () => {
    const clientRows = chunkArray(clients, 3);
    const [searchQuery, setSearchQuery] = useState('');
    const [isCreateClientOpen, setIsCreateClientOpen] = useState(false);

    const showCreateNewClient = () => {
        setIsCreateClientOpen(true);
    };

    const hideCreateNewClient = () => {
        setIsCreateClientOpen(false);
    };

    const onSearch = (event) => {
        setSearchQuery(event.target.value);
    };

    const filteredClients = clients.filter( (client) =>
        client.name.toLowerCase().includes(searchQuery.toLowerCase())
    );

    useEffect(() => {

    }, [searchQuery]);

    return (
        <div className="client-list" style={{paddingLeft:30}}>
          <div style={{display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: 10}}>
            <Search
              placeholder="Enter name"
              onChange={onSearch}
              allowClear
              enterButton="Search"
              size="large"
              style={{
                width: 400,
              }}
            />
             <Button type="primary" shape="round" icon={<PlusOutlined />}
                size="large" style={{marginRight:60}} onClick={showCreateNewClient}>
                Add Client
             </Button>
          </div>
          {isCreateClientOpen &&
            <div className="modal-overlay">
                <div className="modal-card">
                    <AddClient isCreateClientOpen={isCreateClientOpen} setIsCreateClientOpen={setIsCreateClientOpen} />
                </div>
            </div>
          }
          {!isCreateClientOpen && filteredClients.length > 0 ? (
            chunkArray(filteredClients, 3).map((row, rowIndex) => (
              <Row gutter={16}>
                {row.map( (client) => (
                  <Col span={8}>
                    <ClientCard key={client.id} client={client} />
                  </Col>
                  ))}
              </Row>
            ))) : (
              <div> no matches  </div>
            )}
        </div>
    );
};

export default ClientPage;