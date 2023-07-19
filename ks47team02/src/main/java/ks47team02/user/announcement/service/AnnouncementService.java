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
	
	/**
	 * 구인구직공고 수정상세조회
	 * @param announcementCode(공고코드)
	 * @return Announcement (공고정보)
	 */
	public Announcement getAnnouncementInfoById(String announcementCode) {
		Announcement announcementInfo = announcementMapper.getAnnouncementInfoById(announcementCode);
		return announcementInfo;
	}
	
	/**
	 * 구인구직공고 수정
	 * @param announcement
	 * @return
	 */
	public int announcementModify(Announcement announcement) {
		int result = announcementMapper.announcementModify(announcement);
		return result; 
	}
	
	/**
	 * 구인구직공고 등록
	 * @param announcement
	 */
	public void announcementInsert(Announcement announcement) {
		announcementMapper.announcementInsert(announcement);
	}
		
	/**
	 * 구인구직공고 목록조회
	 * @return
	 */
	public List<Announcement> getAnnouncementList() {
		Map<String, Object> paramMap = null;
		
		List<Announcement> announcementList = announcementMapper.getAnnouncementList(paramMap);
		
		return announcementList;
	}


}
