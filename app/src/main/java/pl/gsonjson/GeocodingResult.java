package pl.gsonjson;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Lukasz Marczak on 2015-06-05.
 */
public class GeocodingResult {
    @SerializedName("results")
    private ArrayList<GsonResult> results;
    @SerializedName("status")
    private String status;

    public GeocodingResult(ArrayList<GsonResult> results, String status) {
        this.results = results;
        this.status = status;
    }

    public ArrayList<GsonResult> getResults() {
        return results;
    }

    public void setResults(ArrayList<GsonResult> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
