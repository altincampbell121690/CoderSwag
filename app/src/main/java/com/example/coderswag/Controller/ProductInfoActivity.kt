package com.example.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coderswag.Model.Product
import com.example.coderswag.R
import com.example.coderswag.Utilities.EXTRA_PRODUCT
import kotlinx.android.synthetic.main.activity_product_info.*

class ProductInfoActivity : AppCompatActivity() {
    lateinit var product : Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_info)

        product = intent.getParcelableExtra(EXTRA_PRODUCT)
        println(product.title)

        val resourceId = this.resources.getIdentifier(product.image, "drawable",this.packageName) //?
        productInfoImage.setImageResource(resourceId)
        productPriceTxtVw.text = product.price
        productInfoTitleTxtVw.text = product.title
        //categoryName.text = category.title

    }



}
