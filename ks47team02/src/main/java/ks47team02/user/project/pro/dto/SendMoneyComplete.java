package ks47team02.user.project.pro.dto;

import lombok.Data;

@Data
public class SendMoneyComplete {

	private String sendMoneyCompleteCode;
	private String proProjectCode;
	private String adminId;
	private String proProjectApplicant;
	private String userId;
	private int projectPayment;
	private String sendDate;
	
}
