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

import com.gslab.sample.dac.MessageServiceDAC;
import com.gslab.sample.entity.Message;

@RestController
@RequestMapping(value={"api/mock/messages", "api/mock/message"})
public class MessagesMockController {

    @Resource
	private MessageServiceDAC messageServiceDACMock;

	/**
	 * @return the messageServiceDACMock
	 */
	public MessageServiceDAC getMessageServiceDACMock() {
		return messageServiceDACMock;
	}

	/**
	 * @param messageServiceDACMock the messageServiceDACMock to set
	 */
	public void setMessageServiceDACMock(MessageServiceDAC messageServiceDACMock) {
		this.messageServiceDACMock = messageServiceDACMock;
	}

	@RequestMapping(method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> findAllMessages(HttpServletResponse response) {
    	List<Message> messages = getMessageServiceDACMock().findAllMessages();
    	Map<String, Object> jsonMap = new HashMap<String, Object>();
    	jsonMap.put("messages", messages);
    	response.setHeader("Vary", "Accept-Encoding");
    	response.setHeader("Connection", "keep-alive");
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	//response.setHeader("Content-Length", Integer.toString(jsonMap.toString().length()));
    	
		return jsonMap;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Map<String, Object> findMessage(@PathVariable("id") int id) {
        Message message = getMessageServiceDACMock().findMessage(id);
        Map<String, Object> jsonMap = new HashMap<String, Object>();
    	jsonMap.put("message", message);
		return jsonMap;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody Map<String, Object> updateMessage(@PathVariable("id") int id, @RequestBody Message message) {
    	message.setId(id);
    	
    	Message updatedMessage = getMessageServiceDACMock().updateMessage(message);
    	Map<String, Object> jsonMap = new HashMap<String, Object>();
     	jsonMap.put("message", updatedMessage);
		return jsonMap;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> addMessage(@RequestBody Message message) {
        Message addedMessage = getMessageServiceDACMock().addMessage(message);
        Map<String, Object> jsonMap = new HashMap<String, Object>();
     	jsonMap.put("message", addedMessage);
     	
		return jsonMap;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Map<String, Object> deleteMessage(@PathVariable("id") int id) {
        getMessageServiceDACMock().deleteMessage(id);
        Map<String, Object> jsonMap = new HashMap<String, Object>();
     	jsonMap.put("status", "Deleted Message.");
		return jsonMap;
    }
    
}
