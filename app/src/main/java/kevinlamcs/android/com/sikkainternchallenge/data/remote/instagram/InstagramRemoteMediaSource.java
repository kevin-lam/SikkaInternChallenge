package kevinlamcs.android.com.sikkainternchallenge.data.remote.instagram;

import javax.inject.Inject;

import io.reactivex.Single;
import kevinlamcs.android.com.sikkainternchallenge.data.model.api.instagram.InstagramTagResponse;
import kevinlamcs.android.com.sikkainternchallenge.data.remote.RemoteMediaSource;

public class InstagramRemoteMediaSource implements RemoteMediaSource {

    private final InstagramApiHelper instagramApiHelper;

    @Inject
    public InstagramRemoteMediaSource(InstagramApiHelper instagramApiHelper) {
        this.instagramApiHelper = instagramApiHelper;
    }

    @Override
    public Single<InstagramTagResponse> getTaggedMedia(String tag) {
        return instagramApiHelper.getTaggedMedia(tag);
    }
}
