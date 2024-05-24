import React, { Component } from 'react';
import cakeIcon from '../../images/cake.svg';
import ratingIcon from '../../images/rating.svg';
import './styles.css';

class User extends Component {
  id;
  name;
  email;
  password;
  birthday;
  cakeday;
  rating;
  pfp;
  banner;
  description;

  render() {
    return (
    <div className='user'>
      <img className='user-banner' src={this.props.banner} alt={this.props.banner}></img>
      <div className='user-header'>
          <img src={this.props.pfp} alt={this.props.png}></img>
          <h2>{'c/' + this.props.name}</h2>
        </div>
        <div className='user-info'>
          <div className='user-info-sub' data-title='Рейтинг'>
            <img src={ratingIcon} alt={ratingIcon}></img>
            {this.props.rating}
          </div>
          <div className='user-info-sub' data-title='Дата'>
            <img src={cakeIcon} alt={cakeIcon}></img>
            {' '+ this.props.cakeday}
          </div>
        </div>
        <div className='user-description'>{this.props.description}</div>
    </div>);
  }
}

export default User;
