package anaaya.anaayalearningapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by exkdmr on 2015-11-20.
 */
public class RequestModelGetASN {

    public RequestModelGetASN() {
    }

    public RequestModelGetASN(long id, String reqType) {
        this.id = id;
        this.reqType = reqType;
    }
    public RequestModelGetASN(long id, String reqType, long eanNumber) {
        this.id = id;
        this.reqType = reqType;
        this.eanNumber=eanNumber;
    }
    @SerializedName("id")
    private long id;
    @SerializedName("requestType")
    private String reqType;

    @SerializedName("eanNumber")
    private long eanNumber;

    public long getEanNumber() {
        return eanNumber;
    }

    public void setEanNumber(long eanNumber) {
        this.eanNumber = eanNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReqType() {
        return reqType;
    }

    public void setReqType(String reqType) {
        this.reqType = reqType;
    }
}
