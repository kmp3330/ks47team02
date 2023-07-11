package ks47team02.user.announcement.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks47team02.user.announcement.dto.Announcement;
import ks47team02.user.announcement.mapper.AnnouncementMapper;


@Service
@Transactional
public class AnnouncementService {
	
	private final AnnouncementMapper announcementMapper;
	
	// 생성자 메소드 의존성 주입방식
		public AnnouncementService(AnnouncementMapper announcementMapper) {
			this.announcementMapper = announcementMapper;
		}

	public List<Announcement> getAnnouncementList() {
		Map<String, Object> paramMap = null;
		
		List<Announcement> announcementList = announcementMapper.getAnnouncementList(paramMap);
		
		return announcementList;
	}

}
