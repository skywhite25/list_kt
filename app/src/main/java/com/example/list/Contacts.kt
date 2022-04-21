package com.example.list

import androidx.room.*

@Entity(tableName = "tb_contacts")
data class Contacts (
    @PrimaryKey(autoGenerate = true) // add -> id auto increment
    val id : Long,
    var name : String,
    var tel : String
    )