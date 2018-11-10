package kevinlamcs.android.com.sikkainternchallenge.di.module;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;
import kevinlamcs.android.com.sikkainternchallenge.data.remote.NetworkModule;

@Module(includes = {NetworkModule.class})
public class AppModule {

    @Provides
    Context provideApplicationContext(Application app) {
        return app;
    }
}
