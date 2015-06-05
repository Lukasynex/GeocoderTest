package pl.gsonjson;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Lukasz Marczak on 2015-06-05.
 */
public class GsonGeometry {
    @SerializedName("bounds")
    private ArrayList<GsonBounds> bounds;
    @SerializedName("location")
    private ArrayList<GsonLocation> location;
    @SerializedName("location_type")
    private String location_type;
    @SerializedName("viewport")
    private ArrayList<GsonBounds> viewport;

    public GsonGeometry(ArrayList<GsonBounds> bounds,
                        ArrayList<GsonLocation> location,
                        String location_type, ArrayList<GsonBounds> viewport) {
        this.bounds = bounds;
        this.location = location;
        this.location_type = location_type;
        this.viewport = viewport;
    }

    public ArrayList<GsonBounds> getBounds() {
        return bounds;
    }

    public void setBounds(ArrayList<GsonBounds> bounds) {
        this.bounds = bounds;
    }

    public ArrayList<GsonLocation> getLocation() {
        return location;
    }

    public void setLocation(ArrayList<GsonLocation> location) {
        this.location = location;
    }

    public String getLocation_type() {
        return location_type;
    }

    public void setLocation_type(String location_type) {
        this.location_type = location_type;
    }

    public ArrayList<GsonBounds> getViewport() {
        return viewport;
    }

    public void setViewport(ArrayList<GsonBounds> viewport) {
        this.viewport = viewport;
    }
}
