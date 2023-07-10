package ks47team02.user.dto;

import java.util.Date;

public class Banner {
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Banner{");
        sb.append("bannerPriceCode='").append(bannerPriceCode).append('\'');
        sb.append(", bannerSize='").append(bannerSize).append('\'');
        sb.append(", bannerSale='").append(bannerSale).append('\'');
        sb.append(", bannerUnitPrice='").append(bannerUnitPrice).append('\'');
        sb.append(", bannerCode='").append(bannerCode).append('\'');
        sb.append(", bannerRequestCompanyCode='").append(bannerRequestCompanyCode).append('\'');
        sb.append(", bannerRequestCompanyName='").append(bannerRequestCompanyName).append('\'');
        sb.append(", bannerLocation='").append(bannerLocation).append('\'');
        sb.append(", bannerDetails='").append(bannerDetails).append('\'');
        sb.append(", bannerPeriod=").append(bannerPeriod);
        sb.append(", bannerStart=").append(bannerStart);
        sb.append(", bannerEnd=").append(bannerEnd);
        sb.append(", bannerWeeks=").append(bannerWeeks);
        sb.append(", bannerPrice=").append(bannerPrice);
        sb.append(", bannerReservation=").append(bannerReservation);
        sb.append(", bannerBalance=").append(bannerBalance);
        sb.append(", reservationDepositeDate=").append(reservationDepositeDate);
        sb.append(", balanceDepositeDate=").append(balanceDepositeDate);
        sb.append(", depositeStatus='").append(depositeStatus).append('\'');
        sb.append(", bannerStatus='").append(bannerStatus).append('\'');
        sb.append(", bannerPaymentCompleteCode='").append(bannerPaymentCompleteCode).append('\'');
        sb.append(", purchaseCompany='").append(purchaseCompany).append('\'');
        sb.append(", paymentAmount=").append(paymentAmount);
        sb.append(", paymentMethod='").append(paymentMethod).append('\'');
        sb.append(", paymentFinal=").append(paymentFinal);
        sb.append(", registrationDate=").append(registrationDate);
        sb.append('}');
        return sb.toString();
    }

    public String getBannerPriceCode() {
        return bannerPriceCode;
    }

    public void setBannerPriceCode(String bannerPriceCode) {
        this.bannerPriceCode = bannerPriceCode;
    }

    public String getBannerSize() {
        return bannerSize;
    }

    public void setBannerSize(String bannerSize) {
        this.bannerSize = bannerSize;
    }

    public String getBannerSale() {
        return bannerSale;
    }

    public void setBannerSale(String bannerSale) {
        this.bannerSale = bannerSale;
    }

    public String getBannerUnitPrice() {
        return bannerUnitPrice;
    }

    public void setBannerUnitPrice(String bannerUnitPrice) {
        this.bannerUnitPrice = bannerUnitPrice;
    }

    public String getBannerCode() {
        return bannerCode;
    }

    public void setBannerCode(String bannerCode) {
        this.bannerCode = bannerCode;
    }

    public String getBannerRequestCompanyCode() {
        return bannerRequestCompanyCode;
    }

    public void setBannerRequestCompanyCode(String bannerRequestCompanyCode) {
        this.bannerRequestCompanyCode = bannerRequestCompanyCode;
    }

    public String getBannerRequestCompanyName() {
        return bannerRequestCompanyName;
    }

    public void setBannerRequestCompanyName(String bannerRequestCompanyName) {
        this.bannerRequestCompanyName = bannerRequestCompanyName;
    }

    public String getBannerLocation() {
        return bannerLocation;
    }

    public void setBannerLocation(String bannerLocation) {
        this.bannerLocation = bannerLocation;
    }

    public String getBannerDetails() {
        return bannerDetails;
    }

    public void setBannerDetails(String bannerDetails) {
        this.bannerDetails = bannerDetails;
    }

    public int getBannerPeriod() {
        return bannerPeriod;
    }

    public void setBannerPeriod(int bannerPeriod) {
        this.bannerPeriod = bannerPeriod;
    }

    public Date getBannerStart() {
        return bannerStart;
    }

    public void setBannerStart(Date bannerStart) {
        this.bannerStart = bannerStart;
    }

    public Date getBannerEnd() {
        return bannerEnd;
    }

    public void setBannerEnd(Date bannerEnd) {
        this.bannerEnd = bannerEnd;
    }

    public int getBannerWeeks() {
        return bannerWeeks;
    }

    public void setBannerWeeks(int bannerWeeks) {
        this.bannerWeeks = bannerWeeks;
    }

    public int getBannerPrice() {
        return bannerPrice;
    }

    public void setBannerPrice(int bannerPrice) {
        this.bannerPrice = bannerPrice;
    }

    public int getBannerReservation() {
        return bannerReservation;
    }

    public void setBannerReservation(int bannerReservation) {
        this.bannerReservation = bannerReservation;
    }

    public int getBannerBalance() {
        return bannerBalance;
    }

    public void setBannerBalance(int bannerBalance) {
        this.bannerBalance = bannerBalance;
    }

    public Date getReservationDepositeDate() {
        return reservationDepositeDate;
    }

    public void setReservationDepositeDate(Date reservationDepositeDate) {
        this.reservationDepositeDate = reservationDepositeDate;
    }

    public Date getBalanceDepositeDate() {
        return balanceDepositeDate;
    }

    public void setBalanceDepositeDate(Date balanceDepositeDate) {
        this.balanceDepositeDate = balanceDepositeDate;
    }

    public String getDepositeStatus() {
        return depositeStatus;
    }

    public void setDepositeStatus(String depositeStatus) {
        this.depositeStatus = depositeStatus;
    }

    public String getBannerStatus() {
        return bannerStatus;
    }

    public void setBannerStatus(String bannerStatus) {
        this.bannerStatus = bannerStatus;
    }

    public String getBannerPaymentCompleteCode() {
        return bannerPaymentCompleteCode;
    }

    public void setBannerPaymentCompleteCode(String bannerPaymentCompleteCode) {
        this.bannerPaymentCompleteCode = bannerPaymentCompleteCode;
    }

    public String getPurchaseCompany() {
        return purchaseCompany;
    }

    public void setPurchaseCompany(String purchaseCompany) {
        this.purchaseCompany = purchaseCompany;
    }

    public int getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public int getPaymentFinal() {
        return paymentFinal;
    }

    public void setPaymentFinal(int paymentFinal) {
        this.paymentFinal = paymentFinal;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    private String bannerPriceCode;
    private String bannerSize;
    private String bannerSale;
    private String bannerUnitPrice;
    private String bannerCode;
    private String bannerRequestCompanyCode;
    private String bannerRequestCompanyName;
    private String bannerLocation;
    private String bannerDetails;
    private int bannerPeriod;
    private Date bannerStart;
    private Date bannerEnd;
    private int bannerWeeks;
    private int bannerPrice;
    private int bannerReservation;
    private int bannerBalance;
    private Date reservationDepositeDate;
    private Date balanceDepositeDate;
    private String depositeStatus;
    private String bannerStatus;
    private String bannerPaymentCompleteCode;
    private String purchaseCompany;
    private int paymentAmount;
    private String paymentMethod;
    private int paymentFinal;
    private Date registrationDate;

}
