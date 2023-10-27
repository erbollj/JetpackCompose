package com.loc.newsapp.domain.usecases

import com.loc.newsapp.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class GetBoolean(
    private val local: LocalUserManager
) {

    operator fun invoke(): Flow<Boolean> {
        return local.getBoolean()
    }

}