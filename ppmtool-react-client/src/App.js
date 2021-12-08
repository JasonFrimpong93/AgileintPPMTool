import Dashboard from "./components/Dashboard";

import "./App.css";

import React, { Component } from "react";
import Header from "./components/Layout/Header";

class App extends Component {
  render() {
    return (
      <div className="App">
        <Header />
        <Dashboard />
      </div>
    );
  }
}

export default App;
