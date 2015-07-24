package com.gslab.sample.dac.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.gslab.sample.dac.MeetingServiceDAC;
import com.gslab.sample.entity.Meeting;

@Transactional
public class MeetingServiceDACImpl implements MeetingServiceDAC {
	private static Logger LOGGER = Logger.getLogger(MeetingServiceDACImpl.class);
	
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
	
	@Override
	public List<Meeting> findAllMeetings() {
		Session session = getSessionFactory().getCurrentSession();
		Criteria criteria = session.createCriteria(Meeting.class);
		List<Meeting> meeetings = criteria.list();
		
		LOGGER.info("Fetched all meetings.");
		return meeetings;
	}

	@Override
	public Meeting findMeeting(long meetingId) {
		Session session = getSessionFactory().getCurrentSession();
		Meeting meeting = (Meeting) session.get(Meeting.class, meetingId);  
		LOGGER.info("Fetched meeting with id: " + meetingId + " found meeting : " + meeting);
		return meeting;
	}

	@Override
	public Meeting addMeeting(Meeting newMeeting) {
		Session session = getSessionFactory().getCurrentSession();
		session.save(newMeeting);
		LOGGER.info("Saved new meeting: " + newMeeting + " meeting Id : " + newMeeting.getMeetingId());
		return newMeeting;
	}

	@Override
	public Meeting updateMeeting(Meeting meeting) {
		Session session = getSessionFactory().getCurrentSession();
		session.saveOrUpdate(meeting);
		LOGGER.info("Updated meeting: " + meeting + " meeting Id : " + meeting.getMeetingId());
		return meeting;
	}

	@Override
	public void deleteMeeting(long meetingId) {
		Session session = getSessionFactory().getCurrentSession();
		Meeting meeting = (Meeting) session.get(Meeting.class, meetingId);
		session.delete(meeting);
		LOGGER.info("Deleted meeting: " + meeting + " with meeting Id : " + meeting.getMeetingId());
	}

}
