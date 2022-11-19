package com.example.criminalintent

import androidx.lifecycle.ViewModel
import java.util.*


class CrimeListViewModel: ViewModel() {


    private val crimes = mutableListOf<Crime>()
    var crime: Crime = Crime()

    init{
        val dateNow = Date()
        for(i in 1..100){
            val crime = Crime()
            crime.title = "Crime #$i"
            crime.isSolved = (i % 2 == 0)
            crime._requiresPolice = (i % 5 == 0)
            crime.date =dateNow
            crimes+=crime
        }
    }

    private val crimeRepository =CrimeRepository.get()
    val crimeListLiveData = crimeRepository.getCrimes()

    fun addCrime(crime:Crime){
        crimeRepository.addCrime(crime)
    }
}