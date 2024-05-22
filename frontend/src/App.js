import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import { Component } from 'react';
import Header from './components/header';
import Sidebar from './components/sidebar/Sidebar';

class App extends Component {
  render() {
    return (
      <div>
        <Header></Header>
        <Sidebar></Sidebar>
      </div>
    );
  }
}
export default App;
