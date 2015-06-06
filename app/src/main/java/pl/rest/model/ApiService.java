package pl.rest.model;

import pl.gson.GeoBlob;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Lukasz Marczak on 2015-06-06.
 */
public interface ApiService {
    @GET("{address}&components={components}" + Constants.LANGUAGE_SUFFIX + "&key" + Constants.API_KEY)
    public GeoBlob getLatLngWithComponents(@Query("address") String address, @Query("components") String components);

    @GET("{address}" + Constants.LANGUAGE_SUFFIX + "&key" + Constants.API_KEY)
    public GeoBlob getLatLng(@Query("address") String address);

}