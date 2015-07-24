package com.gslab.sample.standalone;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gslab.sample.dac.impl.MessageServiceDACMock;
import com.gslab.sample.entity.Message;

public class TestMain {

	public static void main(String[] args) {
		MessageServiceDACMock service = new MessageServiceDACMock();
		service.init();
		List<Message> messages = service.findAllMessages();
    	Map<String, Object> jsonMap = new HashMap<String, Object>();
    	jsonMap.put("messages", messages);
    	System.out.println(">>>: " + jsonMap.toString());
	}

}
