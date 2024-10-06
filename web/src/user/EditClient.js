import React from "react";

import { Button, Modal, Form, Input, Select } from 'antd';

const EditClient = ({ client, isEditOpen, setIsEditOpen}) => {
    const handleOk = () => {
      setIsEditOpen(false);
    };

    const handleCancel = () => {
      setIsEditOpen(false);
    };

  return (
    <Modal
        open={isEditOpen}
        title="Edit Client Information"
        onOk={handleOk}
        onCancel={handleCancel}
        footer={(_, { OkBtn, CancelBtn }) => (
          <>
            <CancelBtn />
            <OkBtn />
          </>
        )}
      >
      <Form
        labelCol={{ span: 4 }}
        wrapperCol={{ span: 14 }}
        layout="horizontal"
        style={{ maxWidth: 600 }}
      >
          <Form.Item label="Name">
            <Input />
          </Form.Item>
          <Form.Item label="Gender">
            <Select>
              <Select.Option value="Male">Male</Select.Option>
              <Select.Option value="Female">Female</Select.Option>
              <Select.Option value="Other">Other</Select.Option>
              <Select.Option value="NA">Prefer not to say</Select.Option>
            </Select>
          </Form.Item>
      </Form>
    </Modal>

  );
};

export default EditClient;