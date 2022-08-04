package com.gyanishi.businesscard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gyanishi.businesscard.data.BusinessCardRepository
import com.gyanishi.businesscard.data.BussinessCard

class MainViewModel(private val businessCardRepository: BusinessCardRepository): ViewModel() {
    fun insert(businessCard: BussinessCard) {
        businessCardRepository.insert(businessCard)
    }
    fun getAll(): LiveData<List<BussinessCard>> {
        return businessCardRepository.getAll()
    }
}

class MainViewModelFactory(private val repository: BusinessCardRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}