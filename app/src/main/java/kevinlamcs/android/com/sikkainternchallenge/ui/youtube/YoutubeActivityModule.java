package kevinlamcs.android.com.sikkainternchallenge.ui.youtube;

import android.support.v7.widget.LinearLayoutManager;

import dagger.Module;
import dagger.Provides;
import kevinlamcs.android.com.sikkainternchallenge.di.scope.Youtube;

@Module
public class YoutubeActivityModule {

    @Provides
    LinearLayoutManager provideLinearLayoutManager(YoutubeActivity youtubeActivity) {
        return new LinearLayoutManager(youtubeActivity);
    }

    @Provides
    YoutubeAdapter provideYoutubeAdapter(YoutubeActivity youtubeActivity) {
        return new YoutubeAdapter(youtubeActivity);
    }

    @Provides
    YoutubeView youtubeView(YoutubeActivity youtubeActivity) {
        return youtubeActivity;
    }

}
