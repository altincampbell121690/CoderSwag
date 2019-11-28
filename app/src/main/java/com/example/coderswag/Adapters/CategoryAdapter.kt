package com.example.coderswag.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.coderswag.Model.Category
import com.example.coderswag.R

// base adapter class.. we are inheriting from
// we are making a list view so it shoul dbe a list
class catagoryAdapter(context: Context, categories:  List<Category>): BaseAdapter() {
    val context = context
    val categories = categories
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // layout inflater is an object that takes xml layout and turns it into somethin usable?
        //        inflated a view form xml file category list item
        val categoryView: View = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
// list items to be displayed in the view
        val categoryImage: ImageView = categoryView.findViewById(R.id.categoryImageImgVw)
        val categoryName : TextView = categoryView.findViewById(R.id.categoryNameTxtVw)

        //now that refrence are settled we should set them to the values

        val category = categories[position]
       // categoryImage.setImageResource(context.resources.getIdentifier(category.image, "drawable", context.packageName))
                    //convert and find resource id  -> needs name of resource and type and package
        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        categoryImage.setImageResource(resourceId)
        categoryName.text = category.title
        println(resourceId)

    //val resourceId = context.resources.getIdentifier("")
        return categoryView
    }

    override fun getItem(position: Int): Any {
        // call to retrieve the item at  a given  position
        return categories[position]
    }

    override fun getItemId(position: Int): Long {
        //defines a unique id for each row
        return 0;
    }

    override fun getCount(): Int {
       return categories.count()
    }

}