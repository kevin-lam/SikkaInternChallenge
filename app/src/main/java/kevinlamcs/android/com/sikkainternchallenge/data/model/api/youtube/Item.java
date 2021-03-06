
package kevinlamcs.android.com.sikkainternchallenge.data.model.api.youtube;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("etag")
    @Expose
    private String etag;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("snippet")
    @Expose
    private Snippet snippet;
    @SerializedName("contentDetails")
    @Expose
    private ContentDetails contentDetails;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Snippet getSnippet() {
        return snippet;
    }

    public void setSnippet(Snippet snippet) {
        this.snippet = snippet;
    }

    public ContentDetails getContentDetails() {
        return contentDetails;
    }

    public void setContentDetails(ContentDetails contentDetails) {
        this.contentDetails = contentDetails;
    }

    public boolean hasSnippet() {
        return snippet != null;
    }

    public boolean hasImageUrl() {
        return snippet.getThumbnails() != null && snippet.getThumbnails().getHigh() != null && snippet.getThumbnails().getDefault() != null;
    }

    public boolean hasVideoUrl() {
        return snippet != null && snippet.getResourceId() != null && snippet.getResourceId().getVideoId() != null;
    }

    public String getImageUrl() {
        return snippet.getThumbnails().getHigh().getUrl();
    }

    public String getThumbnailUrl() {
        return snippet.getThumbnails().getDefault().getUrl();
    }

    public String getVideoUrl() {
        return snippet.getResourceId().getVideoId();
    }
}
