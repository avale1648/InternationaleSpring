import React, { Component } from 'react';
import './styles.css'

class Post extends Component {
  user;
  group;
  text;
  image;
  rating;
  replyTo;

  constructor(user, group, text, image, rating, replyTo) {
    super();

    this.user = user;
    this.group = group;
    this.text = text;
    this.image = image;
    this.rating = rating;
    this.replyTo = replyTo;
  }

  render() {
    return (
      <div>

      </div>
    );
  }
}

export default Post;
