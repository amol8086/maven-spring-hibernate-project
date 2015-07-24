package com.gslab.sample.dac.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.gslab.sample.dac.MessageServiceDAC;
import com.gslab.sample.entity.Message;

@Transactional
public class MessageServiceDACImpl implements MessageServiceDAC {
	private static Logger LOGGER = Logger.getLogger(MessageServiceDACImpl.class);
	
	private SessionFactory sessionFactory;
	
	/**
	 * @return the sessionFactory
	 */
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public List<Message> findAllMessages() {
		
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Message.class);
		List<Message> messages = criteria.list();
		
		LOGGER.info("Fetched all messages.");
		return messages;
	}

	@Override
	public Message findMessage(int messageId) {
		Session session = getSessionFactory().getCurrentSession();
		Message message = (Message) session.get(Message.class, messageId);  
		LOGGER.info("Fetched message with id: " + messageId + " found message : " + message);
		return message;
	}

	@Override
	public Message addMessage(Message newMessage) {
		Session session = getSessionFactory().getCurrentSession();
		session.save(newMessage);
		LOGGER.info("Added message with id: " + newMessage.getId() + " message : " + newMessage);
		return newMessage;
	}

	@Override
	public Message updateMessage(Message message) {
		Session session = getSessionFactory().getCurrentSession();
		session.saveOrUpdate(message);
		LOGGER.info("Updated message with id: " + message.getId() + " message : " + message);
		return message;
	}

	@Override
	public void deleteMessage(int messageId) {
		Session session = getSessionFactory().getCurrentSession();
		Message message = (Message) session.get(Message.class, messageId);
		session.delete(message);
		LOGGER.info("Deleted message with id: " + message.getId() + " message : " + message);
	}
}
