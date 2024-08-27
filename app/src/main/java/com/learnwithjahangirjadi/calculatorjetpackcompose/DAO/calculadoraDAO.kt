package com.learnwithjahangirjadi.calculatorjetpackcompose.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.learnwithjahangirjadi.calculatorjetpackcompose.db.Calculation


@Dao
interface CalculationDao {
    @Insert
    fun insert(calculation: Calculation?)

    @get:Query("SELECT * FROM calculations")
    val allCalculations: List<Calculation?>?
}

