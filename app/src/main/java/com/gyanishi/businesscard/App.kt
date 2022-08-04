package com.gyanishi.businesscard

import android.app.Application
import com.gyanishi.businesscard.data.AppDatabase
import com.gyanishi.businesscard.data.BusinessCardRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao())}
}