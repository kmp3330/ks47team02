package ks47team02.user.announcement.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.announcement.dto.Announcement;

@Mapper
public interface AnnouncementMapper {
	
	// 채용공고 등록
	public int announcementInsert(Announcement announcement);

	// 채용공고 조회
	public List<Announcement> getAnnouncementList(Map<String, Object> paramMap);
}
