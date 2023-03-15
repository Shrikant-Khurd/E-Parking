package com.epark.model;

import java.sql.Date;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
public class SystemFeedback {
	
	private int systemFeedbackId;
	private String feedbackMessage;
	private Date postDate;
	private int userId;
	private String userName;
	private String email;
}
 