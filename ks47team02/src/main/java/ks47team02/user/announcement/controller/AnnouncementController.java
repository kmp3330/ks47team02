package ks47team02.user.announcement.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ks47team02.user.announcement.dto.Announcement;
import ks47team02.user.announcement.mapper.AnnouncementMapper;
import ks47team02.user.announcement.service.AnnouncementService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/announcement")
@AllArgsConstructor
public class AnnouncementController {
	
	private final AnnouncementMapper announcementMapper;
	private final AnnouncementService announcementService;

	
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
