package pl.gsonjson;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Lukasz Marczak on 2015-06-05.
 */
public class GsonResult {
    @SerializedName("address_components")
    private ArrayList<GsonAddressComponents> address_components;
    @SerializedName("formatted_address")
    private String formatted_address;
    @SerializedName("geometry")
    private ArrayList<GsonGeometry> geometry;
    @SerializedName("place_id")
    private String place_id;
    @SerializedName("types")
    private ArrayList<String> types;

    public GsonResult(ArrayList<GsonAddressComponents> address_components,
                      String formatted_address,
                      ArrayList<GsonGeometry> geometry,
                      String place_id, ArrayList<String> types) {
        this.address_components = address_components;
        this.formatted_address = formatted_address;
        this.geometry = geometry;
        this.place_id = place_id;
        this.types = types;
    }

    public ArrayList<GsonAddressComponents> getAddress_components() {
        return address_components;
    }

    public void setAddress_components(ArrayList<GsonAddressComponents> address_components) {
        this.address_components = address_components;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public ArrayList<GsonGeometry> getGeometry() {
        return geometry;
    }

    public void setGeometry(ArrayList<GsonGeometry> geometry) {
        this.geometry = geometry;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }
}
