package com.selincengiz.composepractice.domain.usecase.app_entry

import com.selincengiz.composepractice.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}