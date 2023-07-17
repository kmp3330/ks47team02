package ks47team02.user.announcement.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks47team02.user.announcement.dto.Announcement;
import ks47team02.user.announcement.mapper.AnnouncementMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class AnnouncementService {
	
	private final AnnouncementMapper announcementMapper;
	
	// 채용공고 등록
	public void announcementInsert(Announcement announcement) {
		announcementMapper.announcementInsert(announcement);
	}
		
	// 채용공고 목록 조회
	public List<Announcement> getAnnouncementList() {
		Map<String, Object> paramMap = null;
		
		List<Announcement> announcementList = announcementMapper.getAnnouncementList(paramMap);
		
		return announcementList;
	}

}
