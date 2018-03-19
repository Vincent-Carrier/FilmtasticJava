package com.vincentcarrier.repository;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;

import java.util.List;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module public class RetrofitModule {
    @Provides @Singleton TheMovieDbApi theMovieDbApi(Retrofit retrofit) {
        return retrofit.create(TheMovieDbApi.class);
    }

    @Provides @Singleton Retrofit retrofit(OkHttpClient client) {
        Moshi moshi = new Moshi.Builder()
                .add(MyAdapterFactory.create())
                .build();

        return new Retrofit.Builder().baseUrl("http://api.themoviedb.org/3/")
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(
                        RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
                )
                .client(client)
                .build();
    }

    @Provides @Singleton OkHttpClient client(Interceptor interceptor) {
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    @Provides @Singleton Interceptor apiKeyInterceptor() {
        return chain -> {
            Request original = chain.request();
            HttpUrl url = original.url().newBuilder()
                    .addQueryParameter("api_key", BuildConfig.THEMOVIEDB_API_KEY)
                    .build();
            Request request = original.newBuilder().url(url).build();
            return chain.proceed(request);
        };
    }
}
