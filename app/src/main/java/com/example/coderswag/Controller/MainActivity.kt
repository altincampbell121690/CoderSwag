package com.example.coderswag.Controller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coderswag.Adapters.CategoryRecycleAdapter
import com.example.coderswag.Model.Category
import com.example.coderswag.R
import com.example.coderswag.Services.DataServices
import com.example.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
// middle man between the data and the view

    //lateinit var myAdapter:ArrayAdapter<Category> // default adapter
    //lateinit var myAdapter: CategoryAdapter // custom adapter

    lateinit var  myAdapter : CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        * adapter needs 3 things
                1 needs the context
                2 the type of view
                3 needs to know the type of data
         * */
    /* LIST VIEW

       // myAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, DataServices.categories)  //default view
        // need to pass in the categories

        //myAdapter = CategoryAdapter(this, DataServices.categories) // for listview


        // now tell the list view who it needs to listen too
        // to set the adapter
       // categoryListView.adapter = myAdapter

/*       this is how we set item click functionality */
       /* categoryListView.setOnItemClickListener { parent, view, position, id ->
            val category = DataServices.categories[position]
            Toast.makeText(this, "you clicked ${category.title}", Toast.LENGTH_SHORT).show()
        }*/
*/

        ///RECYCLE without onclck lambda
        //myAdapter = CategoryRecycleAdapter(this,DataServices.categories) // for recycler view
        myAdapter = CategoryRecycleAdapter(this,DataServices.categories) {category: Category ->// println(it.title) // category: Category -> println(category.title)
            val productIntent = Intent(this, ProductsActivity::class.java) // current context and where im going
            productIntent.putExtra(EXTRA_CATEGORY, category.title) // it.title
            startActivity(productIntent) // to go to the new activity

        }

        // now tell the list view who it needs to listen too
        // to set the adapter
        categoryListView.adapter = myAdapter
        //we also need a layout manager to postions item views inside a recycler view
        //determins when to reuse  or recylce a view and determines which type of layout

        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)




    }
}
