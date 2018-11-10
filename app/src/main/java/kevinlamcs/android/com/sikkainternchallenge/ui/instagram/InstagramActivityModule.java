package kevinlamcs.android.com.sikkainternchallenge.ui.instagram;

import android.support.v7.widget.GridLayoutManager;

import dagger.Module;
import dagger.Provides;

@Module
public class InstagramActivityModule {

    @Provides
    GridLayoutManager provideGridLayoutManager(InstagramActivity instagramActivity) {
        return new GridLayoutManager(instagramActivity, 3);
    }

    @Provides
    InstagramAdapter provideInstagramAdapter(InstagramActivity instagramActivity) {
        return new InstagramAdapter(instagramActivity);
    }

    @Provides
    InstagramView provideInstagramView(InstagramActivity instagramActivity) {
        return instagramActivity;
    }

}
