package com.example.list

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : Activity(){

    val contactsList : List<Contacts> = listOf(
        Contacts("김김김", "111-1111-1111"),
        Contacts("이이이", "222-2222-2222"),
        Contacts("박박박", "333-3333-3333"),
        Contacts("최최최", "444-4444-4444"),
        Contacts("정정정", "555-5555-5555"),
    )

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val adapter = ContactsListAdapter(contactsList)
        mRecyclerView.adapter = adapter
    }
}