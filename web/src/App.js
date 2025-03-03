import React, {Component} from 'react';
import './App.css';
import HomePage from './HomePage.js';

import { Button } from "antd";

class App extends Component {

    state = {};

  render() {
    return (
        <div className="App">
            <HomePage />
        </div>
    );
  }
}

export default App;
