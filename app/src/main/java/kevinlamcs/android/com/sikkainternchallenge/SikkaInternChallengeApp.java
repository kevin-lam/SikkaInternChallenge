package kevinlamcs.android.com.sikkainternchallenge;

import android.app.Activity;
import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import kevinlamcs.android.com.sikkainternchallenge.di.component.DaggerAppComponent;

public class SikkaInternChallengeApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setupDagger();
    }

    private void setupDagger() {
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }
}
