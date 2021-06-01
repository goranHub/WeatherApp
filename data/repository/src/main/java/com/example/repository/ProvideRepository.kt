package com.example.repository

import com.example.local.database.DatabaseSource
import com.example.remote.NetworkDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * @author lllhr
 * @date 6/1/2021
 */
@Module
@InstallIn(ApplicationComponent::class)
object ProvideRepository {

    @Provides
    @Singleton
    fun provideRep(
        databdatabaseSource: com.example.local.database.DatabaseSource,
        weatherApi: com.example.remote.NetworkDataSource
    ): com.example.repository.Repository {

        return com.example.repository.Repository(databdatabaseSource, weatherApi)
    }
}