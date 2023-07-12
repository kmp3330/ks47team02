package ks47team02.user.banner.dto;

import lombok.Data;

import java.util.Date;
@Data
public class BannerStatus {
    private String bannerCode;
    private String bannerRequestCompany;
    private String bannerLocation;
    private String bannerDetails;
    private Date bannerStartDate;
    private Date bannerEndDate;
    private int bannerWeeks;
    private int bannerPrice;
    private int bannerReservation;
    private int bannerBalance;
    private Date reservationDepositeDate;
    private Date balanceDepositeDate;
    private String depositeStatus;
    private String bannerStatus;

}
