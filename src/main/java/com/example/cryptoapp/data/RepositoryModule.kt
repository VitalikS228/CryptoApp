package com.example.cryptoapp.data

import com.example.cryptoapp.domain.Repository
import com.example.cryptoapp.data.RepositoryDatabase
import com.example.cryptoapp.data.api.StockService
import com.example.cryptoapp.domain.usecases.LoadItemUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(): Repository {
        return RepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideLoadItemUseCase(repository: Repository): LoadItemUseCase {
        return LoadItemUseCase(repository)
    }
}