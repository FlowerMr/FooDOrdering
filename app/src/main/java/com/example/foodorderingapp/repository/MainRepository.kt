package com.example.foodorderingapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.foodorderingapp.Model.CategoryModel
import com.example.foodorderingapp.Model.FoodModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainRepository {
    private val firebaseDatabase=FirebaseDatabase.getInstance()
fun loadCategory():LiveData<MutableList<CategoryModel>>{
    val listData=MutableLiveData<MutableList<CategoryModel>>()
    val ref=firebaseDatabase.getReference("Category")
    ref.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            val   lists= mutableListOf<CategoryModel>()
                for(childSnapShot in snapshot.children){
                    val item=childSnapShot.getValue(CategoryModel::class.java)
                    item?.let { lists.add(it) }
                }
            listData.value=lists
        }

        override fun onCancelled(error: DatabaseError) {
            TODO("Not yet implemented")
        }


    })
    return listData
}

    fun loadpopular():LiveData<MutableList<FoodModel>>{
        val listData=MutableLiveData<MutableList<FoodModel>>()
        val ref=firebaseDatabase.getReference("Items")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val   lists= mutableListOf<FoodModel>()
                for(childSnapShot in snapshot.children){
                    val item=childSnapShot.getValue(FoodModel::class.java)
                    item?.let { lists.add(it) }
                }
                listData.value=lists
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
        return listData
    }
}