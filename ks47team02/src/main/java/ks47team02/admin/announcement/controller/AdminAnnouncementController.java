package ks47team02.admin.announcement.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks47team02.admin.announcement.service.AdminAnnouncementService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/admin/announcement")
@AllArgsConstructor
public class AdminAnnouncementController {
	
	// 생성자 메소드 의존성 주입
	private final AdminAnnouncementService adminAnnouncementService;
	
	@GetMapping("/adminAnnouncementRemove")
	public String adminAnnouncementRemove(@RequestParam(value="announcementCode") String announcementCode) {
		
		adminAnnouncementService.adminAnnouncementRemove(announcementCode);
		
		return "redirect:/admin/announcement/adminAnnouncementList";
		
	}
	
	@GetMapping("/adminAnnouncementList")
	@SuppressWarnings("unchecked") //데이터타입을 체크하지않는다
	public String announcementList(Model model,
								   @RequestParam(value="currentPage", required = false, defaultValue = "1") int currentPage) {
		
		Map<String, Object> resultMap = adminAnnouncementService.getAdminAnnouncementList(currentPage);
		int lastPage = (int) resultMap.get("lastPage");
		List<Map<String, Object>> announcementList = (List<Map<String, Object>>) resultMap.get("announcementList");
		int startPageNum = (int) resultMap.get("startPageNum");
		int endPageNum = (int) resultMap.get("endPageNum");
		
		model.addAttribute("title", "구인구직 공고");
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("lastPage", lastPage);
		model.addAttribute("announcementList", announcementList);
		model.addAttribute("startPageNum", startPageNum);
		model.addAttribute("endPageNum", endPageNum);
		
		return "admin/announcement/adminAnnouncementList";
	}
	
}
