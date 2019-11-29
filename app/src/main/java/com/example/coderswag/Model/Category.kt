package com.example.coderswag.Model

class Category (val title: String, val image:String){
    // we overide the to string method that is the default of an object so that it shows the title
    override fun toString(): String {
        return title
    }
}
