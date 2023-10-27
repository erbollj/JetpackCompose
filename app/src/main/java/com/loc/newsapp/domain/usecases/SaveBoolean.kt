package com.loc.newsapp.domain.usecases

import com.loc.newsapp.domain.manager.LocalUserManager

class SaveBoolean(
    private val local: LocalUserManager
) {

    suspend operator fun invoke() {
        local.saveBoolean()
    }

}