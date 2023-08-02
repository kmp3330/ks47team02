package ks47team02.admin.announcement.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks47team02.admin.announcement.mapper.AdminAnnouncementMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class AdminAnnouncementService {
	
	private final AdminAnnouncementMapper adminAnnouncementMapper;
	
	/**
	 * 구인구직공고 삭제
	 * @param announcement
	 */
	public void adminAnnouncementRemove(String announcement) {
		adminAnnouncementMapper.adminAnnouncementRemove(announcement);
	}
	
	/**
	 * 구인구직 공고목록 페이징
	 * @return
	 */
	public Map<String, Object> getAdminAnnouncementList(int currentPage){
		
		// 보여질 행의 갯수
		int rowPerPage = 5;
		
		// 페이지 계산(시작될행의 인덱스)
		int startIndex = (currentPage - 1) * rowPerPage;
		
		// 마지막 페이지 계산
		// 1. 보여질 테이블의 전체 행의 갯수
		double rowsCnt = adminAnnouncementMapper.getAdminAnnouncementCnt();
		// 2. 마지막 페이지
		int lastPage = (int) Math.ceil(rowsCnt / rowPerPage);
		
		int startPageNum = 1;
		int endPageNum = (lastPage < 10) ? lastPage : 10;
		
		// 동적페이지 구성 (7page 부터)
		if(lastPage > 10 && currentPage > 6) {
		   startPageNum = currentPage -5;
		   endPageNum = currentPage + 4;
		   if(endPageNum >= lastPage) {
			  startPageNum = lastPage - 9;
			  endPageNum = lastPage;
		   }
		}
		
		//HashMap<String, object> 여러 데이터타입을 담을 수 있는 Map<> 이라는 객체를 생성한다.
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startIndex", startIndex);
		paramMap.put("rowPerPage", rowPerPage);
		
		// 화면에 보여질 로그인 이력 데이터
		List<Map<String, Object>> announcementList = adminAnnouncementMapper.getAdminAnnouncementList(paramMap);
		log.info("구인구직 공고 전체목록: {}", announcementList);
		
		// controller에 전달될 data
		paramMap.clear(); // map 객체안의 data 초기화
		paramMap.put("lastPage", lastPage);
		paramMap.put("announcementList", announcementList);
		paramMap.put("startPageNum", startPageNum);
		paramMap.put("endPageNum", endPageNum);
		
		return paramMap;
		
	}
	
}
