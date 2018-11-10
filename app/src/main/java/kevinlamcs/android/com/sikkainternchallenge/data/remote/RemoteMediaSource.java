package kevinlamcs.android.com.sikkainternchallenge.data.remote;

import io.reactivex.Single;
import kevinlamcs.android.com.sikkainternchallenge.data.model.api.instagram.InstagramTagResponse;

public interface RemoteMediaSource {
    Single<InstagramTagResponse> getTaggedMedia(String tag);
}
