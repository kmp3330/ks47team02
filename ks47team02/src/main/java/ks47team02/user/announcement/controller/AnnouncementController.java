package ks47team02.user.announcement.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ks47team02.user.announcement.dto.Announcement;
import ks47team02.user.announcement.service.AnnouncementService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/announcement")
@AllArgsConstructor
public class AnnouncementController {
	
	// 생성자 메소드 의존성 주입
	private final AnnouncementService announcementService;
	
	@GetMapping("/announcementRemove")
	public String announcementRemove(@RequestParam(value="announcementCode") String announcementCode) {
		
		announcementService.announcementRemove(announcementCode);
		
		return "redirect:/announcement/announcementList";
	}
	
	@PostMapping("/announcementModify")
	public String announcementModify(Announcement announcement) {
		
		announcementService.announcementModify(announcement);
		
		return "redirect:/announcement/announcementList";
	}
	
	@GetMapping("/announcementModify")
	public String announcementModify(@RequestParam(value="announcementCode") String announcementCode, Model model) {
		
		// 구인구직공고 목록 상세조회
		Announcement announcementInfo = announcementService.getAnnouncementInfoById(announcementCode);
		
		model.addAttribute("title", "구인구직공고수정화면");
		model.addAttribute("titleText", "구인구직공고수정");
		model.addAttribute("contents", "구인구직공고수정 페이지입니다.");
		model.addAttribute("announcementInfo", announcementInfo);
		
		return "user/announcement/announcement_modify";
	}

	@PostMapping("/announcementInsert")
	public String announcementInsert(Announcement announcement) {
		
		announcementService.announcementInsert(announcement);
		
		log.info("공고등록시 입력정보: {}", announcement);
		
		return "redirect:/announcement/announcementList";
	}
	
	@GetMapping("/announcementInsert")
	public String announcementInsert(Model model) {
		
		model.addAttribute("title", "구인구직공고등록화면");
		model.addAttribute("titleText", "구인구직공고등록");
		model.addAttribute("contents", "구인구직공고등록 페이지입니다.");
		
		return "user/announcement/announcement_insert";
	}
	
	@GetMapping("/announcementList")
	public String getAnnouncementList(Model model,
									  @RequestParam(value="searchKey", required = false, defaultValue = "") String searchKey,
									  @RequestParam(value="searchValue", required = false) String searchValue) {
		
		log.info("searchKey : {}", searchKey);
		log.info("searchValue : {}", searchValue);
		List<Announcement> announcementList = announcementService.getAnnouncementList(searchKey,searchValue);
		model.addAttribute("title", "구인구직");
		model.addAttribute("titleText", "구인구직공고");
		model.addAttribute("contents", "구인구직공고목록 페이지입니다.");
		model.addAttribute("announcementList", announcementList);
		
		return "user/announcement/announcement_list";
	}
}
