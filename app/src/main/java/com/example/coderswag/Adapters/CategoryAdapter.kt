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

/*
* list views do not require view holder pattern
* but recycler views do
* */
class CategoryAdapter(context: Context, categories:  List<Category>): BaseAdapter() {
    val context = context
    val categories = categories
    /*  layout inflater is an object that takes xml layout and turns it into somethin usable?
               inflated a view form xml file category list item
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val categoryView: View
        val holder:ViewHolder
        if (convertView == null){  // then this is the first time the view is being built --> first launch
            categoryView = LayoutInflater.from(context).inflate(R.layout.category_list_item, null)
            holder = ViewHolder()// holds a refrence to the the items
            holder.categoryImage = categoryView.findViewById(R.id.categoryImageImgVw)
            holder.categoryName = categoryView.findViewById(R.id.categoryNameTxtVw)  //println("I exisit for the first time")

            categoryView.tag = holder // setting a unique value to the view holder?
        }else{
            holder = convertView.tag as ViewHolder
            categoryView = convertView //println("I have been recycled!")
        }
   //////////////////////////////////////////////////////////////////////
  /*       list items to be displayed in the view

        println("HEAVY COMPUTING")

        now that refrence are settled we should set them to the values
  */
/////////////////////////////////////////////////////////////////////////////
        val category = categories[position]
       // categoryImage.setImageResource(context.resources.getIdentifier(category.image, "drawable", context.packageName))
                    //convert and find resource id  -> needs name of resource and type and package
        val resourceId = context.resources.getIdentifier(category.image, "drawable", context.packageName)
        holder.categoryImage?.setImageResource(resourceId)
        holder.categoryName?.text = category.title
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

    /* more effecient
    *  every time we are grabbing the category name and image
    * view holder will ensure that only the number of views that fit the screen are displayed
    *       this conserves resources. (we want to make sure that we can reuse the the category view
    *       and not recall it every time
    * */

    private class ViewHolder {
        //hold refrence to image and name
        var categoryImage:ImageView? = null
        var categoryName : TextView? = null
    }

}

