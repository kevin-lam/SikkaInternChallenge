package kevinlamcs.android.com.sikkainternchallenge.di.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import kevinlamcs.android.com.sikkainternchallenge.ui.main.MainActivity;
import kevinlamcs.android.com.sikkainternchallenge.ui.youtube.YoutubeActivity;
import kevinlamcs.android.com.sikkainternchallenge.ui.youtube.YoutubeActivityModule;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector(modules = {YoutubeActivityModule.class})
    abstract YoutubeActivity bindYoutubeActivity();
}
