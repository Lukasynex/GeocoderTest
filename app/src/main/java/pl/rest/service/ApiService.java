package pl.rest.service;

import pl.rest.model.ApiResponse;
import pl.rest.model.Constants;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Lukasz Marczak on 2015-06-06.
 */
public interface ApiService {
    @GET("/json?" + Constants.LANGUAGE_SUFFIX + "&key" + Constants.API_KEY)
    public void getLatLngWithComponents(@Query("address") String address,
                                        @Query("components") String components, Callback<ApiResponse> callback);

    @GET("/json?" + Constants.LANGUAGE_SUFFIX + "&key" + Constants.API_KEY)
    public void getLatLng(@Query("address") String address, Callback<ApiResponse> callback);

}