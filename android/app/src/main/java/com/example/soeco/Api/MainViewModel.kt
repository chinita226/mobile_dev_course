package com.example.soeco.Api

import android.app.Application
import androidx.lifecycle.*
import com.example.soeco.Models.DB_Models.Material_DB
import com.example.soeco.Models.DB_Models.Order_DB
import com.example.soeco.Models.DB_Models.Product_DB
import com.example.soeco.realmAppServices

class MainViewModel (application: Application) : AndroidViewModel(application) {
    private val user = realmAppServices.currentUser()

    private val repository: Repository = Repository(application)
    val orders: LiveData<List<Order_DB>> = repository.orders
    val materials: LiveData<List<Material_DB>> = repository.materials
    val products: LiveData<List<Product_DB>> = repository.products



    fun update() {
        //if (user!= null)
        //repository.updateOrders(user.customData["role"].toString())
             //repository.updateOrders("blacksmith")
            // repository.updateOrders("carpenter")
             repository.updateOrders("delivery")

        //repository.updateMaterials()
        //repository.updateProducts()

    }

}