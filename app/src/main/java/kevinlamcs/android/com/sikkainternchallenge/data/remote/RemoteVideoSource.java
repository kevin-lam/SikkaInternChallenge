package kevinlamcs.android.com.sikkainternchallenge.data.remote;

import io.reactivex.Single;
import kevinlamcs.android.com.sikkainternchallenge.data.model.api.youtube.YoutubePlaylistResponse;

public interface RemoteVideoSource {
    Single<YoutubePlaylistResponse> getPlaylist();
}
