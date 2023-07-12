package ks47team02.user.banner.dto;

import lombok.Data;

import java.util.Date;

@Data
public class BannerPaymentComplete {
    private String bannerPaymentCompleteCode;
    private String bannerCode;
    private String purchaseCompany;
    private int paymentAmount;
    private String paymentMethod;
    private Date registrationDate;
    private String BannerUnitPriceCode;
}
