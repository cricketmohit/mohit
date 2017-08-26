package anaaya.anaayalearningapp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by examsh on 2016-08-08.
 */
public class AnaayaApplication extends android.app.Application {


    private static SharedPreferences settings;
    private static SharedPreferences.Editor editor;
    private static Context context;
    private static Activity mCurrentActivity;
    public static final String PREFS_NAME = "ICA-VIB";
    private final static String LC_TYPES = "lc_type.json";
    static Map<String, Integer> lcTypeMap;
    static Map<String, String> lcTypeMapDecription;
    static Map<Long, String> lcTypeBarcode;
    public static ArrayList<String> lcTypeImageUrl;
    public static List<String> mLClist;
    public static String AUTH_TOKEN_VALUE = "";
    public static List<LCAlphabet> mLCListMain;
    public static List<LCNumber> mLCListNumber;
    private static long customerNumber;
    private static String userName;
    private static long nightReceivingCode;
    public static HashMap<String, String> webErrCodes;
    private static final String VIB_PACKAGE_NAME = "se.ica.vib.ica_vib";
    //Scanner release
    public static boolean APP_LOGOUT = false;
    public static Activity getCurrentActivity() {
        return mCurrentActivity;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mLCListMain = new ArrayList<LCAlphabet>();
        mLCListNumber = new ArrayList<LCNumber>();
    }



    public static void setLcListAndMap(List<LCAlphabet> lcList,List<LCNumber> lcListNumber) {
        //Clear lists

        if (lcList != null) {
            mLCListMain = lcList;
            mLCListNumber = lcListNumber;

        }
    }




}
