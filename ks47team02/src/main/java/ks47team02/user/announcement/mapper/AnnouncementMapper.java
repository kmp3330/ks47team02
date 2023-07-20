package ks47team02.user.announcement.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import ks47team02.user.announcement.dto.Announcement;

@Mapper
public interface AnnouncementMapper {
	
	// 구인구직공고 삭제
	public int announcementRemove(String announcementCode);
	
	// 구인구직공고 수정상세조회
	public Announcement getAnnouncementInfoById(String announcementCode);
	
	// 구인구직공고 수정
	public int announcementModify(Announcement announcement);
	
	// 구인구직공고 등록
	public int announcementInsert(Announcement announcement);

	// 구인구직공고 조회
	public List<Announcement> getAnnouncementList(Map<String, Object> paramMap);

}
