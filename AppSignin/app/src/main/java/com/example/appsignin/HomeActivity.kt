package com.example.appsignin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appsignin.Adapter.HomeAdapter
import com.example.appsignin.Object.Home

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var ac: ActionBar? = supportActionBar
        if (ac != null) {
            ac.hide()
        }

        var spinner: Spinner= findViewById(R.id.spn_category) as Spinner
        var list: ArrayList<String> = ArrayList()
        list.add("All Categories")
        list.add("Sport")
        val adapter: ArrayAdapter<String> = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,list)
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice)
        spinner.setAdapter(adapter)

        var recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager= LinearLayoutManager(this)
        var arrayList: ArrayList<Home> = ArrayList()

        arrayList.add( Home(R.drawable.profile, "Martin Palmer", "Today, 03:24 PM",
            "What is the loop of Creation? How is there something from nothing? In spite of the fact that it is impossible to prove that anythin….",
            R.drawable.rectangle_copy, R.drawable.ic_favorite_border_black_24dp, R.drawable.ic_003_comment_1,"$340.00"))
        arrayList.add( Home(R.drawable.profile, "Pearl Myers", "Yesterday",
            "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
            null, R.drawable.ic_favorite_border_black_24dp, R.drawable.ic_003_comment_1,"$290.00"))
        arrayList.add( Home(R.drawable.profile, "Pearl Myers", "Yesterday",
            "I am looking for a chilled out roommate for a house on 17th floor of a XYZ appartment.",
            null, R.drawable.ic_favorite_border_black_24dp, R.drawable.ic_003_comment_1,"$290.00"))

        var adapterHome: HomeAdapter= HomeAdapter(this,arrayList)
        recyclerView.adapter= adapterHome
    }
}
