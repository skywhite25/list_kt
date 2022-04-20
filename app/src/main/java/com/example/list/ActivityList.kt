package com.example.list

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : Activity(){

    var contactsList = mutableListOf(
        Contacts("김김김", "111-1111-1111"),
        Contacts("이이이", "222-2222-2222"),
        Contacts("박박박", "333-3333-3333"),
        Contacts("최최최", "444-4444-4444"),
        Contacts("정정정", "555-5555-5555"),
        Contacts("강강강", "666-6666-6666"),
        Contacts("성성성", "777-7777-7777"),
        Contacts("금금금", "888-8888-8888")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        var count = 0

        val adapter = ContactsListAdapter(contactsList)
        mBtnAdd.setOnClickListener{
            var contact = Contacts("Add${count++}", "000-0000-0000")
            contactsList.add(contact)

            adapter.notifyDataSetChanged()
        }
        adapter.setItemClickListener(object : ContactsListAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                contactsList.removeAt(position)
                adapter.notifyDataSetChanged()
            }
        })
        mRecyclerView.adapter = adapter
    }
}