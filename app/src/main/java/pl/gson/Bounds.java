package pl.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Lukasz Marczak on 2015-06-06.
 */
public class Bounds {

    @SerializedName("northeast")
    @Expose
    private Northeast northeast;

    @SerializedName("southwest")
    @Expose
    private Southwest southwest;

    /**
     *
     * @return
     * The northeast
     */
    public Northeast getNortheast() {
        return northeast;
    }

    /**
     *
     * @param northeast
     * The northeast
     */
    public void setNortheast(Northeast northeast) {
        this.northeast = northeast;
    }

    public Bounds withNortheast(Northeast northeast) {
        this.northeast = northeast;
        return this;
    }

    /**
     *
     * @return
     * The southwest
     */
    public Southwest getSouthwest() {
        return southwest;
    }

    /**
     *
     * @param southwest
     * The southwest
     */
    public void setSouthwest(Southwest southwest) {
        this.southwest = southwest;
    }

    public Bounds withSouthwest(Southwest southwest) {
        this.southwest = southwest;
        return this;
    }

}
