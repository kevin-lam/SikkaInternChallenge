package kevinlamcs.android.com.sikkainternchallenge.data;

import javax.inject.Inject;

import io.reactivex.Single;
import kevinlamcs.android.com.sikkainternchallenge.data.model.api.youtube.YoutubePlaylistResponse;
import kevinlamcs.android.com.sikkainternchallenge.data.remote.RemoteVideoSource;
import kevinlamcs.android.com.sikkainternchallenge.di.scope.Youtube;

public class VideoRepository {

    private final RemoteVideoSource remoteVideoSource;

    @Inject
    public VideoRepository(RemoteVideoSource remoteVideoSource) {
        this.remoteVideoSource = remoteVideoSource;
    }

    public Single<YoutubePlaylistResponse> getPlaylist() {
        return remoteVideoSource.getPlaylist();
    }
}
