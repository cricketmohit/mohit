package anaaya.anaayalearningapp;

/**
 * Created by exkdmr on 2015-11-20.
 */
public class UrlHelper

{
   // public static final String BASE_URL = "http://se.ica.se/rest/Store_Receiving_RS";

    public static final String UPDATE_RETURNS = "/updateReturns";
    public static final String UPDATE_INVENTORY_RETURNS = "/updateUserReturns";
    public static final String GET_INVENTORY_RETURNS = "/getReturnDetail";
    public static final String LOGIN = "/loginService";
    public static final String GETASN_DETAILS = "/getASNDetails";
    public static final String GETSUMMARY_DETAILS = "/getSummary";
    public static final String UPATE_RECEIVING = "/updateReceiving";
    public static final String SEARCH_BY_DATE = "/searchByDate";
    public static final String INSERT_DELIVERY_STATUS = "/insertDeliveryStatus";
    public static final String GETSPOTCHECK_DETAILS = "/getLoadDetails";
    public static final String UPDATE_SPOTCHECK_DEVIATION = "/updateSpotDeviation";
    public static final String GET_LC = "/getLCType";
    public static final String GET_KFPDFP = "/getSOI";
    public static final String INSERT_WRONGSCANNEDLOAD= "/insertMissingLoad";
    public static final String INSERT_APPCRASHLOG= "/insertExceptionLog";

    public static final String BASE_URL = "http://se-t2.ica.ia-hc.net/rest/Store_Receiving_RS"; // Test Env
    //public static final String BASE_URL = "http://ver.se.ica.se/rest/Store_Receiving_RS";  // Verification

    //Sand box Dev
    //public static final String BASE_URL = "http://ux308tas001.ux.icacorp.net:8801/rest/Store_Receiving_RS";
    //public static final String BASE_URL = "https://ux308tas001.ux.icacorp.net:8804/rest/Store_Receiving_RS";

}
