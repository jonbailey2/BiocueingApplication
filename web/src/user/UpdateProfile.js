import React, {Component, useState, useContext} from 'react';
import { Button, ConfigProvider, Space } from 'antd';
import { AntDesignOutlined } from '@ant-design/icons';
import { css } from '@emotion/css';

const UpdateProfile = ({user, onSave}) => {
    const { getPrefixCls } = useContext(ConfigProvider.ConfigContext);
    const rootPrefixCls = getPrefixCls();
    const linearGradientButton = css`
    &.${rootPrefixCls}-btn-primary:not([disabled]):not(.${rootPrefixCls}-btn-dangerous) {
      border-width: 0;

      > span {
        position: relative;
      }

      &::before {
        content: '';
        background: linear-gradient(135deg, #6253e1, #04befe);
        position: absolute;
        inset: 0;
        opacity: 1;
        transition: all 0.3s;
        border-radius: inherit;
      }

      &:hover::before {
        opacity: 0;
      }
    }`;

    const [username, setUsername] = useState(user.username);
    const [name, setName] = useState(user.name);
    const [dateOfBirth, setDateOfBirth] = useState(user.dateOfBirth);
    const [companies, setCompanies] = useState(user.companies);

    const handleUsernameChange = (e) => {
        setUsername(e.target.value);
    }

    const handleNameChange = (e) => {
        setName(e.target.value);
    }

    const handleDateOfBirthChange = (e) => {
        setDateOfBirth(e.target.value);
    }

    const handleCompaniesChange = (index, value) => {
        const newCompanies = [...companies];
        newCompanies[index] = value;
        setCompanies(newCompanies);
    }

     const handleAddCompany = () => {
        setCompanies([...companies, '']);
     };

     const handleRemoveCompany = (index) => {
        setCompanies(companies.filter((_, i) => i !== index));
     };

     const handleSubmit = (e) => {
        e.preventDefault();
        onSave({ name, dateOfBirth, companies });
     };

     return (
        <ConfigProvider
          button={{
            className: linearGradientButton,
          }}
        >
          <h1>Edit User Profile</h1>
          <form onSubmit={handleSubmit}>
            <div style={{marginLeft: '-4vw'}}>
              <label>
                Name:
                <input type="text" value={name} onChange={handleNameChange} style={{marginLeft: '1vw'}}/>
              </label>
            </div>
            <div style={{marginLeft: '-2vw'}}>
              <label>
                Date of Birth:
                <input type="date" value={dateOfBirth} onChange={handleDateOfBirthChange} />
              </label>
            </div>
            <div>
              <label>Companies:</label>
              {companies.map((company, index) => (
                <div key={index}>
                  <input
                    type="text"
                    value={company}
                    onChange={(e) => handleCompaniesChange(index, e.target.value)}
                  />
                  <Button type="primary" size="small" onClick={() => handleRemoveCompany(index)}>
                    Remove
                  </Button>
                </div>
              ))}
              <Button type="primary" onClick={handleAddCompany}>
                Add Company
              </Button>
            </div>
            <Button type="primary">Save</Button>
          </form>
        </ConfigProvider>
     );
};

export default UpdateProfile;
