package pl.rest.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pl.rest.model.ApiResponse;
import pl.rest.model.Constants;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by Lukasz Marczak on 2015-06-06.
 */
public class RestClient
{
    private static final String BASE_URL = Constants.BASE;
    private ApiService apiService;

    public RestClient()
    {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new ItemTypeAdapterFactory())
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(BASE_URL)
                .setConverter(new GsonConverter(gson))
                .build();

        apiService = restAdapter.create(ApiService.class);
    }

    public ApiService getGeoService()
    {
        return apiService;
    }
}