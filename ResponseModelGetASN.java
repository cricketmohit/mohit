package anaaya.anaayalearningapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by extmiy on 2015-11-23.
 */
public class ResponseModelGetASN {
    @SerializedName("result")
    private String result;

    @SerializedName("response")
    private String loaddetial;

    @SerializedName("errorCode")
    private String errorCode;

    @SerializedName("errorMsg")
    private String errorMsg;

    public String getResult() {
        return result;
    }

    public String getLoaddetial() {
        return loaddetial;
    }

    public void setLoaddetial(String loaddetial) {
        this.loaddetial = loaddetial;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
