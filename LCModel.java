package anaaya.anaayalearningapp;

import com.google.gson.annotations.SerializedName;

/**
 * Created by exkdmr on 2015-12-14.
 */
public class LCModel {
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

    public String getLcType() {
        return lcType;
    }

    public void setLcType(String lcType) {
        this.lcType = lcType;
    }

    public String getLcDescription() {
        return lcDescription;
    }

    public void setLcDescription(String lcDescription) {
        this.lcDescription = lcDescription;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }


    public String getLcImageURLMobile() {
        return lcImageURLMobile;
    }

    public void setLcImageURLMobile(String lcImageURLMobile) {
        this.lcImageURLMobile = lcImageURLMobile;
    }


    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    @SerializedName("barcodes")
    private long barcode;

}
