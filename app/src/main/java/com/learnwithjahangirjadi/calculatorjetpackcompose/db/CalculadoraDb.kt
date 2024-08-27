package com.learnwithjahangirjadi.calculatorjetpackcompose.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.learnwithjahangirjadi.calculatorjetpackcompose.DAO.CalculationDao

@Database(entities = [Calculation::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun calculationDao(): CalculationDao?

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java, "calculation_database"
                        )
                            .build()
                    }
                }
            }
            return INSTANCE
        }
    }
}

