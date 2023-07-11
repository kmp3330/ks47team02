package ks47team02.user.banner.dto;

import lombok.Data;

@Data
public class BannerRequestCompany {
    private String bannerRequestCompanyCode;
    private String bannerRequestCompanyName;
    private String bannerUnitPriceCode;
    private String bannerLocation;
    private int bannerPeriod;
    private String bannerPrice;
}
