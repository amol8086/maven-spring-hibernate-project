package com.gslab.sample.web.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gslab.sample.dac.MeetingServiceDAC;
import com.gslab.sample.entity.Meeting;
import com.gslab.sample.exception.SystemException;

@RestController
@RequestMapping(value={"api/meetings", "api/meeting"})
public class MeetingController {

    @Resource
	private MeetingServiceDAC meetingServiceDAC;

	/**
	 * @return the meetingServiceDAC
	 */
	public MeetingServiceDAC getMeetingServiceDAC() {
		return meetingServiceDAC;
	}

	/**
	 * @param meetingServiceDAC the meetingServiceDAC to set
	 */
	public void setMeetingServiceDAC(MeetingServiceDAC meetingServiceDAC) {
		this.meetingServiceDAC = meetingServiceDAC;
	}

	@RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> findAllMeetings(HttpServletResponse response) {
    	List<Meeting> meetings = getMeetingServiceDAC().findAllMeetings();
    	Map<String, Object> jsonMap = new HashMap<String, Object>();
    	jsonMap.put("meetings", meetings);
    	response.setHeader("Vary", "Accept-Encoding");
    	response.setHeader("Connection", "keep-alive");
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	//response.setHeader("Content-Length", Integer.toString(jsonMap.toString().length()));
    	
		return jsonMap;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> findMeeting(@PathVariable("id") long id) {
    	Meeting employee = getMeetingServiceDAC().findMeeting(id);
        Map<String, Object> jsonMap = new HashMap<String, Object>();
    	jsonMap.put("meeting", employee);
		return jsonMap;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody Map<String, Object> updateMeeting(@PathVariable("id") long id, 
    		@RequestBody Meeting meeting) {
    	meeting.setMeetingId(id);
    	
    	Meeting updatedMeeting = getMeetingServiceDAC().updateMeeting(meeting);
    	Map<String, Object> jsonMap = new HashMap<String, Object>();
     	jsonMap.put("meeting", updatedMeeting);
		return jsonMap;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> addMeeting(@RequestBody Meeting meeting) {
    	Meeting addedEmployee = getMeetingServiceDAC().addMeeting(meeting);
        Map<String, Object> jsonMap = new HashMap<String, Object>();
     	jsonMap.put("meeting", addedEmployee);
     	
		return jsonMap;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Map<String, Object> deleteMeeting(@PathVariable("id") long id) {
    	throw new SystemException("Yet To be implemented.");
    	/*getMeetingServiceDAC().deleteMeeting(id);
        Map<String, Object> jsonMap = new HashMap<String, Object>();
     	jsonMap.put("status", "Deleted Meeting.");
		return jsonMap;*/
    }
    
}
