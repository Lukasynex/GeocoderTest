package pl.gsonjson;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Lukasz Marczak on 2015-06-05.
 */
public class GsonAddressComponents {

    @SerializedName("long_name")
    private String long_name;
    @SerializedName("short_name")
    private String short_name;
    @SerializedName("types")
    private ArrayList<String> types;

}
