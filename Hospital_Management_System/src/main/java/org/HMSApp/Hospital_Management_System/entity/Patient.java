package org.HMSApp.Hospital_Management_System.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="patients")

public class Patient {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private long id;
	@Column(name="first_name")
	private String name;
	
	@Column(name="age")
	private String age;
	
	@Column(name="blood")
	private String blood;
	
	@Column(name="prescription")
	private String prescription;
	
	@Column(name="dose")
	private String dose;
	
	@Column(name="fees")
	private String fees;
	
	@Column(name="urgency")
	private String urgency;

}
