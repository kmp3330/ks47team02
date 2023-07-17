package ks47team02.user.profile.dto;

import lombok.Data;

@Data
public class ProfileAward {
	
	private String profileAwardCode;
	private String userId;
	private String userAwardName;
	private String userAwardPublication;
	private String userAwardDate;
	private String AwardDetails;
	private boolean profileHidden;
	private boolean profileApplicationHidden;
	
}
