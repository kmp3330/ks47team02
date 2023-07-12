package ks47team02.user.announcement.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks47team02.user.announcement.dto.Announcement;
import ks47team02.user.announcement.mapper.AnnouncementMapper;
import ks47team02.user.announcement.service.AnnouncementService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/announcement")
@AllArgsConstructor
public class AnnouncementController {
	
	private final AnnouncementMapper announcementMapper;
	private final AnnouncementService announcementService;

	@PostMapping("/announcementInsert")
	public String announcementInsert(Announcement announcement) {
		
		log.info("공고등록시 입력정보: {}", announcement);
		
		announcementService.announcementInsert(announcement);
		
		return "redirect:/user/announcement/announcement_insert";
	}
	
	@GetMapping("/announcementInsert")
	public String getAnnouncementInsert(Model model) {
		
		
		model.addAttribute("title", "채용공고등록화면");
		model.addAttribute("titleText", "채용공고등록");
		model.addAttribute("contents", "채용공고등록 페이지입니다.");
		
		
		return "user/announcement/announcement_insert";
	}
	
	@GetMapping("/announcementList")
	public String getAnnouncementList(Model model) {
		
		List<Announcement> announcementList = announcementService.getAnnouncementList();
		model.addAttribute("title", "구인구직");
		model.addAttribute("titleText", "채용공고");
		model.addAttribute("contents", "채용공고목록 페이지입니다.");
		model.addAttribute("announcementList", announcementList);
		
		
		return "user/announcement/announcement_list";
	}
}
