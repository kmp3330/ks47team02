package ks47team02.user.banner.service;

import ks47team02.user.banner.dto.BannerRequestCompany;
import ks47team02.user.banner.mapper.BannerMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Transactional
@Service
public class BannerService {

    private final BannerMapper bannerMapper;

    /**
     * 배너광고 신청 기업 목록 조회
     * @return
     */
    public List<BannerRequestCompany> bannerRequestCompanyList(){
        List<BannerRequestCompany> bannerRequestCompanyList = bannerMapper.bannerRequestCompanyList();
        log.info("신청 이력 조회: {}", bannerRequestCompanyList);

        return bannerRequestCompanyList;
    }

    public void request(BannerRequestCompany bannerRequestCompany){
        bannerMapper.request(bannerRequestCompany);
    }
}