package com.example.list

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_list.*
import kotlin.random.Random

class ListActivity : Activity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        var count = 0

        val TAG = "ActivityList"

        var db : AppDataBase? = null
        var contactsList = mutableListOf<Contacts>()

        // 초기화
        db = AppDataBase.getInstance(this)

        // 이전에 저장한 내용 모두 불러와서 추가
        val savedContacts = db!!.contactsDao().getAll()
        if(savedContacts.isNotEmpty()){
            contactsList.addAll(savedContacts)
        }

        val adapter = ContactsListAdapter(contactsList)

        adapter.setItemClickListener(object : ContactsListAdapter.OnItemClickListener{

        // delete DB
        override fun onClick(v: View, position: Int) {

            val contacts = contactsList[position]

            db?.contactsDao()?.delete(contacts = contacts) // DB에서 삭제
            contactsList.removeAt(position) // 리스트에서 삭제
            adapter.notifyDataSetChanged() // 리스트 갱신

            Log.d(TAG, "remove item($position).name:${contacts.name}")
        }
    })

        // add DB
        mBtnAdd.setOnClickListener{

            // 랜덤 번호 생성
            val numA = Random.nextInt(1000)
            val numB = Random.nextInt(10000)
            val numC = Random.nextInt(10000)
            val rdNum = String.format("%03d-%04d-%04d", numA, numB, numC)

            val contact = Contacts(0, "New $numA", rdNum) // create contact
            db?.contactsDao()?.insertAll(contact) // add in DB
            contactsList.add(contact) // add list

            adapter.notifyDataSetChanged()
        }

        mRecyclerView.adapter = adapter
    }


}