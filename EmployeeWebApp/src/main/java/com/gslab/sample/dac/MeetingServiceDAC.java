package com.gslab.sample.dac;

import java.util.List;

import com.gslab.sample.entity.Meeting;

public interface MeetingServiceDAC {
	
	List<Meeting> findAllMeetings();

	Meeting findMeeting(long meetingId);

	Meeting addMeeting(Meeting newMeeting);

	Meeting updateMeeting(Meeting meeting);

	void deleteMeeting(long meetingId);

}
