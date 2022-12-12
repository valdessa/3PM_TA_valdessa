package com.esat.apitest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var heroList: MutableList<HeroEntity>
    private var interactor: MainInteractor

    init {
        heroList = mutableListOf()
        interactor = MainInteractor()
    }

    private val heroes: MutableLiveData<MutableList<HeroEntity>> by lazy {
        MutableLiveData<MutableList<HeroEntity>>().also {
            loadHeroes()
        }
    }

    fun getHeroes(): LiveData<MutableList<HeroEntity>> {
        return heroes
    }

    private fun loadHeroes(){
        interactor.getHeroes {
            heroes.value = it
            heroList = it
        }
    }

}