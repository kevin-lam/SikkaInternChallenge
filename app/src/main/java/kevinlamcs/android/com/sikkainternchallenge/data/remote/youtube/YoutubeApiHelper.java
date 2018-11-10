package kevinlamcs.android.com.sikkainternchallenge.data.remote.youtube;

import io.reactivex.Single;
import kevinlamcs.android.com.sikkainternchallenge.data.model.api.youtube.YoutubePlaylistResponse;
import retrofit2.http.GET;

public interface YoutubeApiHelper {
    @GET("playlistItems")
    Single<YoutubePlaylistResponse> getPlaylist();
}
