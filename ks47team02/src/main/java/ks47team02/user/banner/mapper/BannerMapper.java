package ks47team02.user.banner.mapper;

import ks47team02.user.banner.dto.BannerRequestCompany;
import ks47team02.user.profile.dto.ProfileAward;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BannerMapper {
    public List<BannerRequestCompany> bannerRequestCompanyList();
}