package com.example.coderswag.Controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.coderswag.Adapters.CategoryAdapter
import com.example.coderswag.Adapters.CategoryRecycleAdapter
import com.example.coderswag.Model.Category
import com.example.coderswag.R
import com.example.coderswag.Services.DataServices
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

        ///RECYCLE
        myAdapter = CategoryRecycleAdapter(this,DataServices.categories) // for recycler view

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
