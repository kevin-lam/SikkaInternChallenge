package kevinlamcs.android.com.sikkainternchallenge.di.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import kevinlamcs.android.com.sikkainternchallenge.SikkaInternChallengeApp;
import kevinlamcs.android.com.sikkainternchallenge.di.builder.ActivityBuilder;
import kevinlamcs.android.com.sikkainternchallenge.di.module.AppModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, ActivityBuilder.class, AppModule.class})
public interface AppComponent {

    void inject(SikkaInternChallengeApp app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
      }
}
