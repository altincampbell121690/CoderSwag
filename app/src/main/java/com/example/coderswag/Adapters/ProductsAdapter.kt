package com.example.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.Model.Product
import com.example.coderswag.R
import kotlinx.android.synthetic.main.product_list_item.view.*
import org.w3c.dom.Text
// we put a lambda here : productClick recieves a function from product activity and passes it to binProduct
class ProductsAdapter(val context : Context, val products: List<Product>,val productClick: (Product)->Unit) : RecyclerView.Adapter<ProductsAdapter.ProductHolder>() {

    /**
     * <h1>ProductHolder</h1>
     * ProductHolder is a class that extends/ inherits from ViewHolder class the binds the view
     * A ViewHolder describes an item view and metadata about its place within the RecyclerView.
     * <p>
     * you can access each item directly here as it is bound.
     * @param itemView
     */
    inner class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage = itemView.findViewById<ImageView>(R.id.productImage)
        val productName = itemView.findViewById<TextView>(R.id.productNameTxtVw)
        val productPrice = itemView.findViewById<TextView>(R.id.productPriceTxtVw)

        //DONT FORGET BIND PRODUCT FUNCTION -> helper function to bind ui elements


        fun bindProduct(product: Product, context: Context){
            val resourceId = context.resources.getIdentifier(product.image, "drawable",context.packageName )
            productImage.setImageResource(resourceId)
            productName.text = product.title
            productPrice.text = product.price
            // this is the item on click listener which needs to be bound to each item
                // (hence bind product)
            itemView.setOnClickListener {
                //productClick takes a function (LAMBDA) [ call it mapProduct ] and passes
                    // it a product instance as a parameter
                productClick(product)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.product_list_item, parent, false
        )
        return ProductHolder(view)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bindProduct(products[position], context)
    }


}