package com.example.list

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Contacts::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase(){
    abstract fun contactsDao(): ContactsDao

    companion object{
        private var instance: AppDataBase? = null

        @Synchronized
        fun getInstance(context: Context):AppDataBase?{
            if(instance == null){
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "database-contacts"
                )
                    .allowMainThreadQueries()
                    .build()
            }
            return instance
        }
    }
}