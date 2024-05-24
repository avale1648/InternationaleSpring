import React, { Component } from 'react';
import logo from '../../logo.png';
import './styles.css';

class Header extends Component {
  render() {
    return <div className='header'>
    <img className='header-img' src={logo} alt="logo.png" />
    <input type='text' className='searchbar' placeholder='Поиск...'></input>
    <button className='header-button'>Войти</button>
  </div>;
  }
}

export default Header;