package com.example.foodorderingapp.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.foodorderingapp.Model.CategoryModel
import com.example.foodorderingapp.Model.FoodModel
import com.example.foodorderingapp.repository.MainRepository

class MainViewModel:ViewModel() {
    private val repository=MainRepository()
    fun loadCategory():LiveData<MutableList<CategoryModel>>{
        return repository.loadCategory()
    }
fun loadPoular():LiveData<MutableList<FoodModel>>{
    return repository.loadpopular()
}
}