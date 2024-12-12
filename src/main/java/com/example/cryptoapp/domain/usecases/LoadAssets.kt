package com.example.cryptoapp.domain.usecases

import com.example.cryptoapp.domain.Repository
import javax.inject.Inject

class LoadItemUseCase @Inject constructor(
    private val repository: Repository,
) {
    suspend operator fun invoke()  {
        return repository.initializeRecords()
    }
}