package com.azizbek.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var databaseReference:DatabaseReference
    val arraylist=ArrayList<Model>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        databaseReference=FirebaseDatabase.getInstance().reference.child("Text")
        button.setOnClickListener {
            val model=Model(edittext.text.toString())
            databaseReference.push().setValue(model)
        }
        databaseReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                arraylist.clear()
                for (datasnapshot:DataSnapshot in snapshot.children){
                    var model=datasnapshot.getValue(Model::class.java)
                    arraylist.add(model!!)
                }
                val myAdapter=MyAdapter(this@MainActivity,arraylist)
                recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)
                recyclerView.adapter=myAdapter
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

    }
}