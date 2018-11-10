
package kevinlamcs.android.com.sikkainternchallenge.data.model.api.instagram;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Videos {

    @SerializedName("standard_resolution")
    @Expose
    private StandardResolution_ standardResolution;
    @SerializedName("low_bandwidth")
    @Expose
    private LowBandwidth lowBandwidth;
    @SerializedName("low_resolution")
    @Expose
    private LowResolution_ lowResolution;

    public StandardResolution_ getStandardResolution() {
        return standardResolution;
    }

    public void setStandardResolution(StandardResolution_ standardResolution) {
        this.standardResolution = standardResolution;
    }

    public LowBandwidth getLowBandwidth() {
        return lowBandwidth;
    }

    public void setLowBandwidth(LowBandwidth lowBandwidth) {
        this.lowBandwidth = lowBandwidth;
    }

    public LowResolution_ getLowResolution() {
        return lowResolution;
    }

    public void setLowResolution(LowResolution_ lowResolution) {
        this.lowResolution = lowResolution;
    }

}
