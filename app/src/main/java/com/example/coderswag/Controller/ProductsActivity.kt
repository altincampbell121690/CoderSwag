package com.example.coderswag.Controller

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.get
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coderswag.Adapters.ProductsAdapter
import com.example.coderswag.Model.Product
import com.example.coderswag.R
import com.example.coderswag.Services.DataServices
import com.example.coderswag.Utilities.EXTRA_CATEGORY
import com.example.coderswag.Utilities.EXTRA_PRODUCT
import android.os.PersistableBundle
import kotlinx.android.synthetic.main.activity_products.*

class ProductsActivity : AppCompatActivity() {

    lateinit var  myAdapter: ProductsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        val categoryType =  intent.getStringExtra(EXTRA_CATEGORY)
                                                            // returns a list
        myAdapter = ProductsAdapter(this, DataServices.getProducts(categoryType)) { product: Product ->
            Toast.makeText(this, "you clicked ${product.title}", Toast.LENGTH_SHORT).show()
            val productInfoIntent = Intent(this, ProductInfoActivity::class.java)
            // if passing an instance of a class btwn activities -> class must be made into a parcelable!!
            productInfoIntent.putExtra(EXTRA_PRODUCT,product)
            startActivity(productInfoIntent)
        }
        val orientation = resources.configuration.orientation // this returns an int 1 is port 2 is landscape
        var spanCount = 2

        if(orientation == Configuration.ORIENTATION_LANDSCAPE){
            spanCount = 3
        }

        //Sets different grid size based on screen size/ tablet
        val screenSize = resources.configuration.screenWidthDp
        if(screenSize > 720){
            spanCount = 3
        }

        // must have a layout manager
        val layoutManager = GridLayoutManager(this,spanCount)
        //product list view is xml component for the recycleView
        productListView.layoutManager = layoutManager
        productListView.adapter = myAdapter



    }


}
