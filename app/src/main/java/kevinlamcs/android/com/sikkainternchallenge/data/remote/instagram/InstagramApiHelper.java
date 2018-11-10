package kevinlamcs.android.com.sikkainternchallenge.data.remote.instagram;

import io.reactivex.Single;
import kevinlamcs.android.com.sikkainternchallenge.data.model.api.instagram.InstagramTagResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface InstagramApiHelper {
    @GET("tags/{tagName}/media/recent")
    Single<InstagramTagResponse> getTaggedMedia(@Path("tagName") String tag);
}
