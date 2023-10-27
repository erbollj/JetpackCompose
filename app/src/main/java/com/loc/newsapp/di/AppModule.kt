package com.loc.newsapp.di

import android.app.Application
import com.loc.newsapp.data.manager.LocalUserManagerImpl
import com.loc.newsapp.domain.manager.LocalUserManager
import com.loc.newsapp.domain.usecases.GetBoolean
import com.loc.newsapp.domain.usecases.LocalUseCases
import com.loc.newsapp.domain.usecases.SaveBoolean
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(application: Application): LocalUserManager =
        LocalUserManagerImpl(application)

    @Provides
    @Singleton
    fun provideLocalUseCases(localUserManager: LocalUserManager) = LocalUseCases(
        getBoolean = GetBoolean(localUserManager),
        saveBoolean = SaveBoolean(localUserManager)
    )

}