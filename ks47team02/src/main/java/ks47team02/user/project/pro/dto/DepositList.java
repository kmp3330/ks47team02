package ks47team02.user.project.pro.dto;

import lombok.Data;

@Data
public class DepositList {
		private String depositListCode;
		private String proProjectCode;
		private String adminId;
		private String cpId;
		private String sender;
		private String bank;
		private String bankAccount;
		private int projectPayment;
		private int totalCommission;
		private int totalPayment;
		private String senderDate;
}
