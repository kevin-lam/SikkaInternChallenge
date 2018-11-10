package kevinlamcs.android.com.sikkainternchallenge.data.remote.youtube;

import javax.inject.Inject;

import io.reactivex.Single;
import kevinlamcs.android.com.sikkainternchallenge.data.model.api.youtube.YoutubePlaylistResponse;
import kevinlamcs.android.com.sikkainternchallenge.data.remote.RemoteVideoSource;
import kevinlamcs.android.com.sikkainternchallenge.di.scope.Youtube;

public class YoutubeRemoteVideoSource implements RemoteVideoSource{

    private final YoutubeApiHelper youtubeApiHelper;

    @Inject
    public YoutubeRemoteVideoSource(YoutubeApiHelper youtubeApiHelper) {
        this.youtubeApiHelper = youtubeApiHelper;
    }

    @Override
    public Single<YoutubePlaylistResponse> getPlaylist() {
        return youtubeApiHelper.getPlaylist();
    }
}
