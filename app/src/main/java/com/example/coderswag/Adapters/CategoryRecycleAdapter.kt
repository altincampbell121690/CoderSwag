package com.example.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coderswag.Model.Category
import com.example.coderswag.R
import kotlinx.android.synthetic.main.category_list_item.view.*

// recyclerviews need a <view holder?>
                                                // we need the categories to show <- needs list type
                                                                                // item click receives a category and returns nothing
class CategoryRecycleAdapter(val context:Context, val categories:List<Category>, val itemClick: (Category)->Unit) : RecyclerView.Adapter<CategoryRecycleAdapter.RvHolder>() {

    //holder view class needed to hold the view and enable reuse of views (holds a refrence to the views)
    // also resposible for binding the views
    inner class RvHolder(itemView: View, val itemClick: (Category) -> Unit) : RecyclerView.ViewHolder(itemView) { // so we create one <- view holder

        // in charge of binding? so lets bind these values (we need image and name here)
        val categoryImage = itemView.findViewById<ImageView>(R.id.categoryImageImgVw) //grab imgVw ref
        val categoryName = itemView.findViewById<TextView>(R.id.categoryNameTxtVw)//grab textVw ref


        // function to pass in the category to bind it to to the ui elements
        /**
         * <h1>bindCategory</h1>
         * bind Category sets each items image and name
         * based on the category passed into it.
         * <b>
         *     Sets the onclick listener to a lambda
         * @param category
         * @param context
         */
        fun bindCategory(category:Category, context: Context){ // need context to find resource based on the name
            val resourceId = context.resources.getIdentifier(category.image, "drawable",context.packageName) //?
            categoryImage.setImageResource(resourceId)
            categoryName.text = category.title

            itemView.setOnClickListener { itemClick(category) } // set onclick for each item?
        }
    }


    // this function is called by the recycler to display the data at a specefied location
    // sp ot takes the viewholder and position and calls inner function bindCategory
//    and passes in the categories list
    override fun onBindViewHolder(myViewHolder: RvHolder, position: Int) {
        myViewHolder.bindCategory(categories[position], context)

    }

    // method called when new view holders are needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.category_list_item, parent, false
        )
        return RvHolder(view, itemClick)

    }


    override fun getItemCount(): Int {
        return categories.count() // number of items in the list
    }



}