package com.selincengiz.composepractice.domain.usecase.app_entry

import com.selincengiz.composepractice.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManager: LocalUserManager,
) {
    operator fun invoke(): Flow<Boolean> = localUserManager.readAppEntry()
}
