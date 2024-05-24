import React, { Component } from 'react';
import Header from '../header/Header';
import Sidebar from '../sidebar/Sidebar';
import Post from '../post/Post';
import User from '../user/User';
import Group from '../group/Group';
import ussrPfp from '../../images/ussr.jpg';
import ussrBanner from '../../images/ussrBanner.jpg';
import img from '../../images/unnamed.jpg';
import './styles.css';

class Container extends Component {
  render() {
    return(
      <div>
        <Header></Header>
        <div className='main-container'>
          <Sidebar></Sidebar>
          <div className='content-container'>
            <User 
            id={1}
            name='avale1648'
            cakeday='20.05.2024'
            rating={0}
            pfp={ussrPfp}
            banner={ussrBanner}
            description='Вся власть рабочим!'>

            </User>
            <Group 
            id={1} 
            name='USSR' 
            cakeday='20.05.2024' 
            rating = {0}
            pfp={ussrPfp} 
            banner={ussrBanner} 
            description='Союз советских социалистических республик'>
            </Group>
            <Post id={1} user='avale1648' group='USSR' text='Пролетарии всех стран, соединяйтесь!' rating = {0} image = {img} commentsCount = {0} ></Post>
          </div>
        </div>
      </div>
    );
  }
}

export default Container;
