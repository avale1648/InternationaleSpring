import React, { Component } from 'react';
import matureIcon from '../../images/mature.svg';
import nonMatureIcon from '../../images/non-mature.png'
import cakeIcon from '../../images/cake.svg';
import ratingIcon from '../../images/rating.svg';
import './styles.css';

class Group extends Component {
  id;
  name;
  cakeday;
  mature;
  rating;
  pfp;
  banner;
  description;

  posts;

  render() {
    let mature;
    if(this.props.mature === true) {
      mature = <img src={matureIcon} alt={matureIcon}></img>;
    } else {
      mature = <img src={nonMatureIcon} alt={nonMatureIcon}></img>;;
    }
    return(
      <div className='group'>
        <img className='group-banner' src={this.props.banner} alt={this.props.banner}></img>
        <div className='group-header'>
          <img src={this.props.pfp} alt={this.props.pfp}></img>
          <h2>{'s/' + this.props.name}</h2>
        </div>
        <div className='group-info'>
          <div className='group-info-sub' data-title='Рейтинг'>
            <img src={ratingIcon} alt={ratingIcon}></img>
            {this.props.rating}
          </div>
          <div className='group-info-sub' data-title='Возрастное ограничение'>{mature}</div>
          <div className='group-info-sub' data-title='Дата создания'>
            <img src={cakeIcon} alt={cakeIcon}></img>
            {' '+ this.props.cakeday}
          </div>
        </div>
        <div className='group-description'>{this.props.description}</div>
      </div>
    );
  }
}

export default Group;
