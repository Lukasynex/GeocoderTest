package pl.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lukasz Marczak on 2015-06-06.
 */
@Parcel
public class GeoBlob {

    @SerializedName("results")
    private List<Result> results = new ArrayList<>();
    @SerializedName("status")
    private String status;

    /**
     *
     * @return
     * The results
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The results
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }

    public GeoBlob withResults(List<Result> results) {
        this.results = results;
        return this;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public GeoBlob withStatus(String status) {
        this.status = status;
        return this;
    }

}
