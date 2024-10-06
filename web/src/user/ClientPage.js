import React from "react";
import ClientCard from "./ClientCard";
import { Divider, Carousel, Row, Col } from 'antd';

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

    return (
        <div className="client-list">
          {clientRows.map((row, rowIndex) => (
            <Row gutter={16}>
              {row.map( (client) => (
                <Col span={8}>
                  <ClientCard key={client.id} client={client} />
                </Col>
                ))}
          </Row>
          ))}
        </div>
    );
};

export default ClientPage;
