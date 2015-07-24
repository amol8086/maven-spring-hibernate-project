package com.gslab.sample.standalone;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gslab.sample.dac.MessageServiceDAC;
import com.gslab.sample.entity.Message;

public class SpringStandalone {
	private static ClassPathXmlApplicationContext applicationContext;
	
	public static void main(String[] args) {
		// open/read the application context file
	    applicationContext = new ClassPathXmlApplicationContext("spring-standalone.xml");
	    /*Message message = new Message();
	    message.setId(7);
	    message.setAge(40);
	    message.setGender("Male");
	    message.setPreDefinedMessageText("Updating message. discharge him.");*/
	    
		fetchAllMessages();
	    //fetchMessageById(2);
	    //addNewMessage(message);
	    //updateMessage(message);
	    //deleteMessage(message);
	    
	    System.out.println(">>>>>>>>>>>fetched all...!");
	    
	}
	
	private static void deleteMessage(Message message) {
		// instantiate our spring dao object from the application context
	    MessageServiceDAC messageServiceDAC = (MessageServiceDAC) applicationContext.getBean("messageServiceDAC");
	    messageServiceDAC.deleteMessage(message.getId());
	}
	
	private static Message updateMessage(Message message) {
		// instantiate our spring dao object from the application context
	    MessageServiceDAC messageServiceDAC = (MessageServiceDAC) applicationContext.getBean("messageServiceDAC");
	    Message addedMessage = messageServiceDAC.updateMessage(message);
	    return addedMessage;
	}
	
	private static Message addNewMessage(Message message) {
		// instantiate our spring dao object from the application context
	    MessageServiceDAC messageServiceDAC = (MessageServiceDAC) applicationContext.getBean("messageServiceDAC");
	    Message addedMessage = messageServiceDAC.addMessage(message);
	    return addedMessage;
	}
	
	private static void fetchMessageById(int messageId) {
		// instantiate our spring dao object from the application context
	    MessageServiceDAC messageServiceDAC = (MessageServiceDAC) applicationContext.getBean("messageServiceDAC");
	    Message message = messageServiceDAC.findMessage(messageId);
	    
	    System.out.println("\n>>>>>>>>>> Messages Text : " + message);
	    
	}
	
	private static void fetchAllMessages() {
		// instantiate our spring dao object from the application context
	    MessageServiceDAC messageServiceDAC = (MessageServiceDAC) applicationContext.getBean("messageServiceDAC");
	    List<Message> messages = messageServiceDAC.findAllMessages();
	    System.out.println("\nMessages Size : " + messages.size());
	    for (Message message : messages) {
			System.out.println("\nMessage Text: " + message.getPreDefinedMessageText());
			System.out.println("Gender: " + message.getGender());
			System.out.println("Age: " + message.getAge());
			System.out.println("\n");
		}
	    
	    MessageServiceDAC messageServiceDACMock = (MessageServiceDAC) applicationContext.getBean("messageServiceDACMock");
	    List<Message> messagesMock = messageServiceDACMock.findAllMessages();
	    System.out.println("\n Mock Messages Size : " + messagesMock.size());
	    for (Message message : messagesMock) {
			System.out.println("\nMock Message Text: " + message.getPreDefinedMessageText());
			System.out.println("Gender: " + message.getGender());
			System.out.println("Age: " + message.getAge());
			System.out.println("\n");
		}
	    
	    applicationContext.close();
	}

}
