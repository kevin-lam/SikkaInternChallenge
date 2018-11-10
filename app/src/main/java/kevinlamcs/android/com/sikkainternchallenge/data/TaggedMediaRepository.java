package kevinlamcs.android.com.sikkainternchallenge.data;

import javax.inject.Inject;

import io.reactivex.Single;
import kevinlamcs.android.com.sikkainternchallenge.data.model.api.instagram.InstagramTagResponse;
import kevinlamcs.android.com.sikkainternchallenge.data.remote.RemoteMediaSource;

public class TaggedMediaRepository {

    private final RemoteMediaSource remoteMediaSource;

    @Inject
    public TaggedMediaRepository(RemoteMediaSource remoteMediaSource) {
        this.remoteMediaSource = remoteMediaSource;
    }

    public Single<InstagramTagResponse> getTaggedMedia(String tag) {
        return remoteMediaSource.getTaggedMedia(tag);
    }
}
