package app;

import pl.rest.service.RestClient;

/**
 * Created by Lukasz Marczak on 2015-06-07.
 */
public class App extends android.app.Application {
    private static RestClient restClient;

    @Override
    public void onCreate() {
        super.onCreate();
        restClient = new RestClient();
    }

    public static RestClient getRestClient() {
        return restClient;
    }
}
