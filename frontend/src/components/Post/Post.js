import React, { Component } from 'react';
import './styles.css';
import ussr from '../../images/ussr.jpg';

class Post extends Component {
  id;
  user;
  group;
  text;
  image;
  rating;
  replyTo;
  commentsCount;

  render() {
    return (
      <div className='post'>
        <div className='post-header'>
          <img src={ussr} alt={ussr}></img>
          <h4>s/{this.props.group}</h4>
        </div>
        <p>c/{this.props.user}</p>
        <h3>{this.props.text}</h3>
        <div className='post-img'>
          <img src={this.props.image} alt={this.props.image} className='post-img'></img>
        </div>
        <div className='post-footer'>
          <div className='post-rating'>
            <div className='post-rating-div'>{this.props.rating}</div>
            <div>
		          <input id={'post-rating-' + this.props.id + 1} type="radio" name={'post-rating-' + this.props.id} value='1'/>
		          <label for={'post-rating-' + this.props.id + 1}>+</label>
	          </div>
            <div>
		          <input id={'post-rating-' + this.props.id + 2} type="radio" name={'post-rating-' + this.props.id} value={this.props.id}/>
		          <label for={'post-rating-' + this.props.id + 2}>-</label>
	          </div>
          </div>
          <button className='post-comments'>Обсуждение {this.props.commentsCount}</button>
        </div>
      </div>
    );
  }
}

export default Post;
