package anaaya.anaayalearningapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by exkdmr on 2015-11-24.
 */
public class RequestModelDelivery {

    @SerializedName("fromDate")
    private String fromDate;

    @SerializedName("toDate")
    private String toDate;
    @SerializedName("ean")
    private long ean;
    @SerializedName("searchType")
    private String searchType;

    public long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(long customerNumber) {
        this.customerNumber = customerNumber;
    }

    @SerializedName("customerNumber")
    private long customerNumber;


    public RequestModelDelivery(String fromDate, String toDate, long eanNo, String searchType, long customerNumber){
        this.fromDate=fromDate;
        this.toDate=toDate;
        this.ean=eanNo;
        this.searchType=searchType;
        this.customerNumber =customerNumber;
    }

    public RequestModelDelivery() {
    }

    public RequestModelDelivery(String fromDate, String toDate, long customerNumber){
        this.fromDate=fromDate;
        this.toDate=toDate;
        this.customerNumber =customerNumber;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public long getEan() {
        return ean;
    }

    public void setEan(long ean) {
        this.ean = ean;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }


}
