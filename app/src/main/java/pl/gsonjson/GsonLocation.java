package pl.gsonjson;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Lukasz Marczak on 2015-06-05.
 */
public class GsonLocation {
    @SerializedName("lat")
    private Double lat;
    @SerializedName("lng")
    private Double lng;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public GsonLocation(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
    }
}
