package com.example.list

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : Activity(){

    val contactsList : List<Contacts> = listOf(
        Contacts("김김김", "111-1111-1111"),
        Contacts("이이이", "222-2222-2222"),
        Contacts("박박박", "333-3333-3333"),
        Contacts("최최최", "444-4444-4444"),
        Contacts("정정정", "555-5555-5555"),
        Contacts("강강강", "666-6666-6666"),
        Contacts("성성성", "777-7777-7777"),
        Contacts("금금금", "888-8888-8888"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val adapter = ContactsListAdapter(contactsList)
        adapter.setItemClickListener(object : ContactsListAdapter.OnItemClickListener{
            override fun onClick(v: View, position: Int) {
                val item = contactsList[position]

                Toast.makeText(v.context, "Activity\n${item.name}\n${item.tel}", Toast.LENGTH_SHORT).show()
                item.name = item.name + "1"
                adapter.notifyDataSetChanged()
            }
        })
        mRecyclerView.adapter = adapter

    }
}