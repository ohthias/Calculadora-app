package com.learnwithjahangirjadi.calculatorjetpackcompose.db

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "calculations")
class Calculation(var expression: String, var result: String) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}

