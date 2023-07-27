package ks47team02.user.project.normal.dto;

import lombok.Data;

@Data
public class normalProjectApplyApplicant {
    private String normal_project_apply_code;
    private String normal_project_code;
    private String user_id;
    private String normal_project_application_date;
    private String normal_applyer_run_code;
    private String project_progress;
    private String approve_user_id;
    private String reject_approval_code;
    private String reject_approval_name;
    private String reject_approval_message;
    private String reject_date;

}
