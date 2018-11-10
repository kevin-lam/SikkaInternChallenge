
package kevinlamcs.android.com.sikkainternchallenge.data.model.api.instagram;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pagination {

    @SerializedName("next_min_id")
    @Expose
    private String nextMinId;
    @SerializedName("min_tag_id")
    @Expose
    private String minTagId;
    @SerializedName("deprecation_warning")
    @Expose
    private String deprecationWarning;

    public String getNextMinId() {
        return nextMinId;
    }

    public void setNextMinId(String nextMinId) {
        this.nextMinId = nextMinId;
    }

    public String getMinTagId() {
        return minTagId;
    }

    public void setMinTagId(String minTagId) {
        this.minTagId = minTagId;
    }

    public String getDeprecationWarning() {
        return deprecationWarning;
    }

    public void setDeprecationWarning(String deprecationWarning) {
        this.deprecationWarning = deprecationWarning;
    }

}
