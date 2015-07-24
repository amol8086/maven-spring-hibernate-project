package com.gslab.sample.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="messages")
public class Message implements Serializable{

	private static final long serialVersionUID = -3336350143239946469L;

	private int id;
	private String preDefinedMessageText;
	private String gender;
	private int age;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MessageID" /*, unique = true, nullable = false*/)
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name = "MessageText")
	public String getPreDefinedMessageText() {
		return preDefinedMessageText;
	}
	
	public void setPreDefinedMessageText(String preDefinedMessageText) {
		this.preDefinedMessageText = preDefinedMessageText;
	}
	
	@Column(name = "Gender")
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(name = "Age")
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Message [id=" + id + ", preDefinedMessageText=" + preDefinedMessageText + ", gender=" + gender
				+ ", age=" + age + "]";
	}
	
}
