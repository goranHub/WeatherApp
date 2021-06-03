package com.example.repository


import com.example.local.database.DatabaseSource
import com.example.remote.NetworkDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author lllhr
 * @date 6/1/2021
 */
@Module
@InstallIn(SingletonComponent::class)
object ProvideRepository {

    @Provides
    @Singleton
    fun provideRep(
        databdatabaseSource: DatabaseSource,
        weatherApi: NetworkDataSource
    ): Repository {

        return Repository(databdatabaseSource, weatherApi)
    }
}