package com.gyanishi.businesscard.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BusinessCardRepository (private val dao: BusinessCardDao){
    fun insert(bussinessCard: BussinessCard) = runBlocking {
        launch (Dispatchers.IO) {
            dao.insert(bussinessCard)
        }
    }

    fun getAll() = dao.getAll()

}