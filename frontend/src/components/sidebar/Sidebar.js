import React, { Component } from 'react';
import './styles.css';
class Sidebar extends Component {
  render() {
    return(
      <div className='sidebar'>
        <div class="form_radio_group">
          
	        <div class="form_radio_group_item">
		        <input id="radio-1" type="radio" name="radio" value="1"/>
		        <label for="radio-1">Profile</label>
	        </div>
	        <div class="form_radio_group_item">
		        <input id="radio-2" type="radio" name="radio" value="2"/>
		        <label for="radio-2">Home</label>
	        </div>
	        <div class="form_radio_group_item">
		        <input id="radio-3" type="radio" name="radio" value="3"/>
		        <label for="radio-3">Popular</label>
	        </div>
          <div class="form_radio_group_item">
		        <input id="radio-4" type="radio" name="radio" value="4"/>
		        <label for="radio-4">New</label>
	        </div>
          <div class="form_radio_group_item">
		        <input id="radio-5" type="radio" name="radio" value="5"/>
		        <label for="radio-5">Comrades</label>
	        </div>
          <div class="form_radio_group_item">
		        <input id="radio-6" type="radio" name="radio" value="6"/>
		        <label for="radio-6">Soviets</label>
	        </div>
          <div class="form_radio_group_item">
		        <input id="radio-7" type="radio" name="radio" value="7"/>
		        <label for="radio-7">About L'Internationale</label>
	        </div>
        </div>
      </div>
    );
  }
}

export default Sidebar;
