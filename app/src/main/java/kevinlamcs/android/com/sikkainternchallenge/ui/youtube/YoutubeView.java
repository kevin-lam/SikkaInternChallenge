package kevinlamcs.android.com.sikkainternchallenge.ui.youtube;

import java.util.List;

import kevinlamcs.android.com.sikkainternchallenge.data.model.api.youtube.Item;

public interface YoutubeView {
    void updateVideos(List<Item> videoEntries);
    void errorResponse(String error);
}
