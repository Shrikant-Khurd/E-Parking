package com.epark.model;

import java.sql.Date;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name="userComplains")
public class UserComplains {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="complaint_id")
	private int complaintId;
	
	@Column(name="complaintMsg")
	private String complaintMsg;
	private Date postDate;
	private boolean complaintStatus;
	
	@ManyToOne (fetch = FetchType.LAZY )
	@JsonIgnoreProperties(value = {"userComplains", "hibernateLazyInitializer"})
    @JoinColumn(name = "userId")
	private Users userComplaint;
}
