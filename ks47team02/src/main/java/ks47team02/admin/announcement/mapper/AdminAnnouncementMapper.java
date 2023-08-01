package ks47team02.admin.announcement.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminAnnouncementMapper {
	
	// 구인구직공고 삭제 
	public int adminAnnouncementRemove(String announcementCode);
	
	// 구인구직공고 조회
	public List<Map<String, Object>> getAdminAnnouncementList(Map<String, Object> paramMap);

	// 구인구직 행 갯수
	public int getAdminAnnouncementCnt();
}
