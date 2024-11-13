package com.selincengiz.composepractice.di

import android.content.Context
import androidx.room.Room
import com.selincengiz.composepractice.data.local.NewsDao
import com.selincengiz.composepractice.data.local.NewsDatabase
import com.selincengiz.composepractice.data.local.NewsTypeConvertor
import com.selincengiz.composepractice.data.manager.LocalUserManagerImpl
import com.selincengiz.composepractice.data.remote.NewsApi
import com.selincengiz.composepractice.data.repository.NewsRepositoryImpl
import com.selincengiz.composepractice.domain.manager.LocalUserManager
import com.selincengiz.composepractice.domain.repository.NewsRepository
import com.selincengiz.composepractice.domain.usecase.app_entry.AppEntryUseCase
import com.selincengiz.composepractice.domain.usecase.app_entry.ReadAppEntry
import com.selincengiz.composepractice.domain.usecase.app_entry.SaveAppEntry
import com.selincengiz.composepractice.domain.usecase.news.DeleteArticle
import com.selincengiz.composepractice.domain.usecase.news.GetNews
import com.selincengiz.composepractice.domain.usecase.news.NewsUseCase
import com.selincengiz.composepractice.domain.usecase.news.SearchNews
import com.selincengiz.composepractice.domain.usecase.news.SelectArticle
import com.selincengiz.composepractice.domain.usecase.news.SelectArticles
import com.selincengiz.composepractice.domain.usecase.news.UpsertArticle
import com.selincengiz.composepractice.util.Constants.BASE_URL
import com.selincengiz.composepractice.util.Constants.NEWS_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideLocalUserManager(
        @ApplicationContext context: Context,
    ): LocalUserManager = LocalUserManagerImpl(context)








    @Provides
    @Singleton
    fun provideApiInstance(): NewsApi =
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi,
        newsDao: NewsDao,
    ): NewsRepository = NewsRepositoryImpl(newsApi, newsDao)

    @Provides
    @Singleton
    fun provideAppEntryUseCase(localUserManager: LocalUserManager) =
        AppEntryUseCase(
            readAppEntry = ReadAppEntry(localUserManager),
            saveAppEntry = SaveAppEntry(localUserManager),
        )

    @Provides
    @Singleton
    fun provideNewsUseCase(newsRepository: NewsRepository) =
        NewsUseCase(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository),
            deleteArticle = DeleteArticle(newsRepository),
            upsertArticle = UpsertArticle(newsRepository),
            selectArticles = SelectArticles(newsRepository),
            selectArticle = SelectArticle(newsRepository),
        )

    @Provides
    @Singleton
    fun provideNewsDatabase(
        @ApplicationContext context: Context,
    ): NewsDatabase =
        Room
            .databaseBuilder(
                context = context,
                klass = NewsDatabase::class.java,
                name = NEWS_DATABASE,
            ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideNewsDao(newsDatabase: NewsDatabase): NewsDao = newsDatabase.newsDao
}
