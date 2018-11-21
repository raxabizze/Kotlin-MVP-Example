package com.example.raxabizze.kotlinmvpexample.di.module.base

import android.content.Context
import com.example.raxabizze.kotlinmvpexample.App
import com.example.raxabizze.kotlinmvpexample.network.PostApi
import com.example.raxabizze.kotlinmvpexample.utils.BASE_URL
import com.example.raxabizze.kotlinmvpexample.utils.rxjava.scheduler.SchedulerProvider
import com.example.raxabizze.kotlinmvpexample.utils.rxjava.scheduler.SchedulerProviderImp
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule()
{
    @Provides
    @Singleton
    fun provideApplication(app : App) : Context = app

    @Provides
    fun providePostApi(retrofit: Retrofit) = retrofit.create(PostApi::class.java)

    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider {
        return SchedulerProviderImp()
    }

    @Provides
    @Singleton
    internal fun provideMachanApiRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor, interceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addNetworkInterceptor(interceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    internal fun provideMachanApiHeader(): Interceptor {
        return Interceptor { chain ->
            chain.proceed(chain.request().newBuilder()
                    .header("Content-Type", "application/json")
                    .build())
        }
    }
}