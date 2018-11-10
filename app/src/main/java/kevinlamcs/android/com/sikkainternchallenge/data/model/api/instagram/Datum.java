
package kevinlamcs.android.com.sikkainternchallenge.data.model.api.instagram;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Comparator;
import java.util.List;

public class Datum {

    public static Comparator<Datum> byLikesDesc = (datum1, datum2) -> {
        boolean bothHaveLikes = datum1.hasLikes() && datum2.hasLikes();
        if (bothHaveLikes) {
            return datum2.getLikes().getCount() - datum1.getLikes().getCount();
        }
        return 0;
    };

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("images")
    @Expose
    private Images images;
    @SerializedName("created_time")
    @Expose
    private String createdTime;
    @SerializedName("caption")
    @Expose
    private Caption caption;
    @SerializedName("user_has_liked")
    @Expose
    private Boolean userHasLiked;
    @SerializedName("likes")
    @Expose
    private Likes likes;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("filter")
    @Expose
    private String filter;
    @SerializedName("comments")
    @Expose
    private Comments comments;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("location")
    @Expose
    private Object location;
    @SerializedName("attribution")
    @Expose
    private Object attribution;
    @SerializedName("users_in_photo")
    @Expose
    private List<UsersInPhoto> usersInPhoto = null;
    @SerializedName("videos")
    @Expose
    private Videos videos;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public Caption getCaption() {
        return caption;
    }

    public void setCaption(Caption caption) {
        this.caption = caption;
    }

    public Boolean getUserHasLiked() {
        return userHasLiked;
    }

    public void setUserHasLiked(Boolean userHasLiked) {
        this.userHasLiked = userHasLiked;
    }

    public Likes getLikes() {
        return likes;
    }

    public void setLikes(Likes likes) {
        this.likes = likes;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Object getLocation() {
        return location;
    }

    public void setLocation(Object location) {
        this.location = location;
    }

    public Object getAttribution() {
        return attribution;
    }

    public void setAttribution(Object attribution) {
        this.attribution = attribution;
    }

    public List<UsersInPhoto> getUsersInPhoto() {
        return usersInPhoto;
    }

    public void setUsersInPhoto(List<UsersInPhoto> usersInPhoto) {
        this.usersInPhoto = usersInPhoto;
    }

    public Videos getVideos() {
        return videos;
    }

    public void setVideos(Videos videos) {
        this.videos = videos;
    }

    public boolean hasImageUrl() {
        return images != null && images.getStandardResolution() != null && images.getThumbnail() != null;
    }

    public String getImageUrl() {
        return images.getStandardResolution().getUrl();
    }

    public String getThumbnailUrl() {
        return images.getThumbnail().getUrl();
    }

    public boolean hasLink() {
        return link != null;
    }

    public boolean hasLikes() {
        return likes != null;
    }
}
