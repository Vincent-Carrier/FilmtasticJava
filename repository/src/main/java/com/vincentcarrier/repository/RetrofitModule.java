package com.vincentcarrier.repository;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Singleton;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

import static com.vincentcarrier.repository.ApiKey.API_KEY;

@Module public class RetrofitModule {
  @Provides @Singleton TheMovieDbApi theMovieDbApi(Retrofit retrofit) {
    return retrofit.create(TheMovieDbApi.class);
  }

  @Provides @Singleton Retrofit retrofit(OkHttpClient client) {
    return new Retrofit.Builder().baseUrl("http://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
        .client(client)
        .build();
  }

  @Provides @Singleton OkHttpClient client() {
    return new OkHttpClient.Builder().addInterceptor(chain -> {
      Request original = chain.request();
      HttpUrl url = original.url().newBuilder().addQueryParameter("api_key", API_KEY).build();
      Request request = original.newBuilder().url(url).build();
      return chain.proceed(request);
    }).build();
  }
}
