package ks47team02.user.project.pro.dto;

import java.util.List;

import lombok.Data;

@Data
public class ProProjectPersonalFunction {

	private String proProjectPersonalFunctionCode;
	private String proProjectCode;
	private String userId;
	private String skill;
	private int projectDay;
	private int dayScore;
	private int projectCompleteScore;
	private int individualWorkDay;
	private int individualCompletePossibleScore;
	private int individualCompleteScore;
	private int workDayPrice;
	private int gradeCommision;
	private int userCommision;
	private int projectPrice;
	private int progressRate;
	private String runName;
	private String startDate;
	private String completeDate;
	private String registerationDate;
	private String period;
	
	// 1:N 관계
	private List<ProProject> proProjectInfo;
}
