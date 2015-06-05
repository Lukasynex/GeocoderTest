package pl.gsonjson;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Lukasz Marczak on 2015-06-05.
 */
public class GsonBounds {
    @SerializedName("northeast")
    private ArrayList<GsonLocation> northeast;
    @SerializedName("southwest")
    private ArrayList<GsonLocation> southwest;

    public GsonBounds(ArrayList<GsonLocation> northeast, ArrayList<GsonLocation> southwest) {
        this.northeast = northeast;
        this.southwest = southwest;
    }

    public ArrayList<GsonLocation> getNortheast() {
        return northeast;
    }

    public void setNortheast(ArrayList<GsonLocation> northeast) {
        this.northeast = northeast;
    }

    public ArrayList<GsonLocation> getSouthwest() {
        return southwest;
    }

    public void setSouthwest(ArrayList<GsonLocation> southwest) {
        this.southwest = southwest;
    }
}
