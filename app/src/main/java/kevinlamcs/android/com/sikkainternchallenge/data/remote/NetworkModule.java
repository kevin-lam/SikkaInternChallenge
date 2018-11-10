package kevinlamcs.android.com.sikkainternchallenge.data.remote;

import android.content.Context;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import kevinlamcs.android.com.sikkainternchallenge.BuildConfig;
import kevinlamcs.android.com.sikkainternchallenge.data.remote.instagram.InstagramApiHelper;
import kevinlamcs.android.com.sikkainternchallenge.data.remote.instagram.InstagramRemoteMediaSource;
import kevinlamcs.android.com.sikkainternchallenge.data.remote.interceptor.CacheInterceptor;
import kevinlamcs.android.com.sikkainternchallenge.data.remote.interceptor.ParameterInterceptor;
import kevinlamcs.android.com.sikkainternchallenge.data.remote.youtube.YoutubeApiHelper;
import kevinlamcs.android.com.sikkainternchallenge.data.remote.youtube.YoutubeRemoteVideoSource;
import kevinlamcs.android.com.sikkainternchallenge.di.scope.Instagram;
import kevinlamcs.android.com.sikkainternchallenge.di.scope.Youtube;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    @Youtube
    Retrofit provideYoutubeRetrofit(Gson gson, @Youtube OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.YOUTUBE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    @Instagram
    Retrofit provideInstagramRetrofit(Gson gson, @Instagram OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.INSTAGRAM_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    @Provides
    @Singleton
    @Youtube
    OkHttpClient provideYoutubeOkHttpClient(CacheInterceptor cacheInterceptor, Cache cache,
                                     @Youtube ParameterInterceptor parameterInterceptor) {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        return builder
                .addInterceptor(cacheInterceptor)
                .addInterceptor(parameterInterceptor)
                .cache(cache)
                .build();
    }

    @Provides
    @Singleton
    @Instagram
    OkHttpClient provideInstagramOkHttpClient(CacheInterceptor cacheInterceptor, Cache cache,
                                     @Instagram ParameterInterceptor parameterInterceptor, HttpLoggingInterceptor loggingInterceptor) {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        return builder
                .addInterceptor(cacheInterceptor)
                .addInterceptor(parameterInterceptor)
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
    }

    @Provides
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return httpLoggingInterceptor;
    }

    @Provides
    CacheInterceptor provideCacheInterceptor() {
        return new CacheInterceptor();
    }

    @Provides
    @Youtube
    ParameterInterceptor provideYoutubeParameterInterceptor() {
        return new ParameterInterceptor.Builder()
                .addParameter("key", BuildConfig.YOUTUBE_API_KEY)
                .addParameter("playlistId", BuildConfig.CEO_PLAYLIST_ID)
                .addParameter("maxResults", "25")
                .addParameter("part", "snippet,contentDetails")
                .build();
    }

    @Provides
    @Instagram
    ParameterInterceptor provideInstagramParameterInterceptor() {
        return new ParameterInterceptor.Builder()
                .addParameter("access_token", BuildConfig.INSTAGRAM_TOKEN)
                .build();
    }

    @Provides
    Cache provideCache(Context context) {
        File httpCacheDirectory = new File(context.getCacheDir(), CacheInterceptor.CACHE_FILE_NAME);
        return new Cache(httpCacheDirectory, CacheInterceptor.CACHE_SIZE);
    }

    @Provides
    @Singleton
    YoutubeApiHelper provideYoutubeApiHelper(@Youtube Retrofit retrofit) {
        return retrofit.create(YoutubeApiHelper.class);
    }

    @Provides
    @Singleton
    RemoteVideoSource provideRemoteVideoSource(YoutubeRemoteVideoSource youtubeRemoteVideoSource) {
        return youtubeRemoteVideoSource;
    }

    @Provides
    @Singleton
    InstagramApiHelper provideInstagramApiHelper(@Instagram Retrofit retrofit) {
        return retrofit.create(InstagramApiHelper.class);
    }

    @Provides
    @Singleton
    RemoteMediaSource provideRemoteMediaSource(InstagramRemoteMediaSource instagramRemoteMediaSource) {
        return instagramRemoteMediaSource;
    }
}
