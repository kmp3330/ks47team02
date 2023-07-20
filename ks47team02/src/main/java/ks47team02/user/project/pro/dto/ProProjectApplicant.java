package ks47team02.user.project.pro.dto;

import lombok.Data;

@Data
public class ProProjectApplicant {

	private String proProjectApplicantCode;
	private String proProjectCode;
	private String applicantUserId;
	private String applicantAccountCode;
	private String bank;
	private String bankAccount;
	private int wishPrice;
	private String applicantDate;
	private String normalApplyerRunCode;
	private String runName;
	private String rejectApprvalCode;
	private String rejectApprvalName;
	private String rejectApprvalMsg;
	private String rejectApprvalDate;
	private String cpId;
	
}
