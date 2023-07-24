package ks47team02.user.member.mapper;

import ks47team02.user.member.dto.Company;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CompanyMapper {

    public int addCompany(Company company);
	
	

}
