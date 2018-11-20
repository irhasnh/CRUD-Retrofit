package com.ghozay19.praditaapps.model.event;

import com.google.gson.annotations.SerializedName;


public class Event {

	@SerializedName("event_desc")
	private String eventDesc;

	@SerializedName("event_id")
	private String eventId;

	@SerializedName("event_location")
	private String eventLocation;

	@SerializedName("event_image")
	private String eventImage;

	@SerializedName("event_time")
	private String eventTime;

	public void setEventDesc(String eventDesc){
		this.eventDesc = eventDesc;
	}

	public String getEventDesc(){
		return eventDesc;
	}

	public void setEventId(String eventId){
		this.eventId = eventId;
	}

	public String getEventId(){
		return eventId;
	}

	public void setEventLocation(String eventLocation){
		this.eventLocation = eventLocation;
	}

	public String getEventLocation(){
		return eventLocation;
	}

	public void setEventImage(String eventImage){
		this.eventImage = eventImage;
	}

	public String getEventImage(){
		return eventImage;
	}

	public void setEventTime(String eventTime){
		this.eventTime = eventTime;
	}

	public String getEventTime(){
		return eventTime;
	}

	@Override
 	public String toString(){
		return 
			"Event{" +
			"event_desc = '" + eventDesc + '\'' + 
			",event_id = '" + eventId + '\'' + 
			",event_location = '" + eventLocation + '\'' + 
			",event_image = '" + eventImage + '\'' + 
			",event_time = '" + eventTime + '\'' + 
			"}";
		}
}