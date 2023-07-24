package ks47team02.user.member.service;

import java.util.HashMap;
import java.util.Map;

import ks47team02.admin.dto.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks47team02.user.member.dto.User;
import ks47team02.user.member.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class MemberService {
	
	private final UserMapper userMapper;
	
	/**
	 * 로그인 체크
	 * @param userId
	 * @param userPw
	 * @return
	 */
	public Map<String, Object> loginCheck(String userId, String userPw) {

		Map<String, Object> resultMap = new HashMap<String, Object>();

		boolean isValid = false;
		User userInfo = userMapper.loginCheck(userId);
		log.info("userInfo : {}", userInfo);

		if(userInfo != null) {
			String checkPw = userInfo.getUserPw();
			if(checkPw.equals(userPw)) {
				isValid = true;
				resultMap.put("userInfo", userInfo);
			}
		}
		resultMap.put("isValid", isValid);

		log.info("resultMap : {}", resultMap);

		return resultMap;
	}

	public void addUser(User user){
		userMapper.addUser(user);
	}

	public boolean checkId(String userId) {
		return userMapper.checkId(userId);
	}
}
