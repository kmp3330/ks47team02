package ks47team02.user.announcement.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks47team02.user.announcement.dto.Announcement;
import ks47team02.user.announcement.mapper.AnnouncementMapper;


@Service
@Transactional
public class AnnouncementService {
	
	private static final Logger log = LoggerFactory.getLogger(AnnouncementService.class);
	
	private final AnnouncementMapper announcementMapper;
	
	// 생성자 메소드 의존성 주입방식
		public AnnouncementService(AnnouncementMapper announcementMapper) {
			this.announcementMapper = announcementMapper;
		}

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
