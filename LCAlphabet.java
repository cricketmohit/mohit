package anaaya.anaayalearningapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by examsh on 2016-08-12.
 */
public class LCAlphabet {

    @SerializedName("id")
    private int id;
    @SerializedName("lcType")
    private String lcType;
    @SerializedName("quantity")
    private int remaining;
    @SerializedName("lcTypeDescription")
    private String lcDescription;
    @SerializedName("imageURLMobile")
    private String lcImageURLMobile;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLcDescription() {
        return lcDescription;
    }

    public void setLcDescription(String lcDescription) {
        this.lcDescription = lcDescription;
    }

    public String getLcImageURLMobile() {
        return lcImageURLMobile;
    }

    public void setLcImageURLMobile(String lcImageURLMobile) {
        this.lcImageURLMobile = lcImageURLMobile;
    }

    public String getLcType() {
        return lcType;
    }

    public void setLcType(String lcType) {
        this.lcType = lcType;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }
}
