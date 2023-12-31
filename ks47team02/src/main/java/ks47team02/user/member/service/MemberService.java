package ks47team02.user.member.service;

import java.util.HashMap;
import java.util.Map;

import ks47team02.user.member.dto.Company;
import ks47team02.user.member.mapper.CompanyMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks47team02.user.member.dto.User;
import ks47team02.user.member.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class MemberService {
	
	private final UserMapper userMapper;
	private final CompanyMapper companyMapper;

	/**
	 * 로그인 체크
	 * @param userId
	 * @param userPw
	 * @return
	 */
	public Map<String, Object> loginCheck(String userId, String userPw) {
		//Map쓰는 이유: 여러 데이터 타입을 담을 수 있어서 쓴다
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

	public Map<String, Object> cpLoginCheck(String cpId, String cpPw){
		Map<String, Object> resultMap = new HashMap<String, Object>();

		boolean isValid = false;
		Company companyInfo = companyMapper.cpLoginCheck(cpId);
		log.info("companyInfo : {}", companyInfo);

		if(companyInfo != null){
			String checkCpPw = companyInfo.getCpPw();
			if(checkCpPw.equals(cpPw)){
				isValid = true;
				resultMap.put("companyInfo", companyInfo);
			}
		}
		resultMap.put("isValid", isValid);

		log.info("resultMap : {}", resultMap);

		return resultMap;
	}

	public void addUser(User user){
		userMapper.addUser(user);
	}

	public void addCompany(Company company){
		companyMapper.addCompany(company);
	}

	public boolean checkId(String userId) {
		return userMapper.checkId(userId);
	}

	public boolean checkCpId(String cpId) {
		return companyMapper.checkCpId(cpId);
	}

	public boolean checkRegNum(String cpRegNumber) {
		return companyMapper.checkRegNum(cpRegNumber);
	}
}
