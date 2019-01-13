package com.example.kyros.mediumandroidtutorials

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import com.example.kyros.mediumandroidtutorials.part1.step2.BinaryActivity2
import kotlinx.android.synthetic.main.activity_navigation.*

class NavigationActivity : AppCompatActivity() {

    private val tutorials = mapOf("Creating Custom Listeners" to BinaryActivity2::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tutorials.keys.toTypedArray())
        listview_navigation_selector.adapter = adapter
        listview_navigation_selector.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this@NavigationActivity, tutorials.values.toTypedArray()[position])
            startActivity(intent)
        }
    }
}
