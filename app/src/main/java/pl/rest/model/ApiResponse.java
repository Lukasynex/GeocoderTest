package pl.rest.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import pl.gson.AddressComponent;
import pl.gson.Bounds;
import pl.gson.Geometry;
import pl.gson.Result;
import pl.gson.Viewport;

/**
 * Created by Lukasz Marczak on 2015-06-06.
 */
public class ApiResponse {

    @SerializedName("results")
    ArrayList<Result> results;

    @SerializedName("address_components")
    AddressComponent addressComponent;

    @SerializedName("bounds")
    Bounds bounds;

    @SerializedName("geometry")
    Geometry geometry;

    @SerializedName("viewport")
    Viewport viewport;

    public ArrayList<Result> getResults() {
        return results;
    }

    public ApiResponse WithResults(ArrayList<Result> results) {
        this.results = results;
        return this;
    }

    public AddressComponent getAddressComponent() {
        return addressComponent;
    }

    public void setAddressComponent(AddressComponent addressComponent) {
        this.addressComponent = addressComponent;
    }

    public Bounds getBounds() {
        return bounds;
    }

    public void setBounds(Bounds bounds) {
        this.bounds = bounds;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setViewport(Viewport viewport) {
        this.viewport = viewport;
    }
}