/**
 * 
 */
package com.gslab.sample.dac;

import java.util.List;

import com.gslab.sample.entity.Message;

/**
 * @author gs-1014
 *
 */
public interface MessageServiceDAC {
	
	List<Message> findAllMessages();	
	
	Message findMessage(int messageId);

	Message addMessage(Message newMessage);
	
	Message updateMessage(Message message);
	
	void deleteMessage(int messageId);
	
}
