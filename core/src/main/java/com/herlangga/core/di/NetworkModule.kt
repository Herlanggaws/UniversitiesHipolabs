package com.herlangga.core.di

import android.content.Context
import android.net.ConnectivityManager
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.chuckerteam.chucker.api.RetentionManager
import com.herlangga.core.BuildConfig
import com.skydoves.sandwich.retrofit.adapters.ApiResponseCallAdapterFactory
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * Designed and developed by Herlangga Wicaksono on 05/01/25.
 * @LinkedIn (https://www.linkedin.com/in/herlangga-wicaksono-4072a5a2/)
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
	@Provides
	@Singleton
	fun provideConnectivityManager(@ApplicationContext context: Context): ConnectivityManager {
		return context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
	}

	@Provides
	@Singleton
	fun provideChuckerInterceptor(@ApplicationContext context: Context): ChuckerInterceptor {
		return ChuckerInterceptor.Builder(context)
			.apply {
				collector(
					ChuckerCollector(
						context = context,
						showNotification = BuildConfig.DEBUG,
						retentionPeriod = RetentionManager.Period.ONE_DAY
					)
				)
				maxContentLength(250_000L)
				alwaysReadResponseBody(false)
				if (!BuildConfig.DEBUG) {
					redactHeaders("Authorization", "Bearer")
					redactHeaders("Authorization", "Basic")
				}
			}
			.build()
	}

	@Provides
	@Singleton
	fun provideOkHttpClient(
		chuckerInterceptor: ChuckerInterceptor,
	): OkHttpClient {
		return if (BuildConfig.DEBUG) {
			OkHttpClient.Builder()
				.addInterceptor(chuckerInterceptor)
				.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
				.connectTimeout(120, TimeUnit.SECONDS)
				.readTimeout(120, TimeUnit.SECONDS)
				.build()
		} else {
			OkHttpClient.Builder()
				.connectTimeout(120, TimeUnit.SECONDS)
				.readTimeout(120, TimeUnit.SECONDS)
				.build()
		}
	}

	@Provides
	@Singleton
	fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
		Retrofit.Builder()
			.addConverterFactory(GsonConverterFactory.create())
			.baseUrl(BuildConfig.BASE_URL)
			.client(okHttpClient)
			.addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
			.build()
}