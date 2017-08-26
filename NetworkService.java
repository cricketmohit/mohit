package anaaya.anaayalearningapp;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;


public interface NetworkService {

    @POST(UrlHelper.GET_LC)
    void getLCType(@Body RequestModelGetASN request, Callback<ResponseModelGetASN> callBack);

}