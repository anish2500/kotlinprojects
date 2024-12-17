//package com.example.assignment
//
//import android.os.Bundle
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//
//class NextPage : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_next_page)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
//    }
//}


package com.example.assignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment.adapter.recylerAdapter
import com.example.assignment.databinding.ActivityNextPageBinding

class NextPage : AppCompatActivity() {
    private lateinit var binding: ActivityNextPageBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter : recylerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNextPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Apply edge-to-edge insets if necessary
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Retrieve data from the intent safely, using ?: for fallback if any data is missing
        val fullName = intent.getStringExtra("fullName") ?: "Not Provided"
        val email = intent.getStringExtra("email") ?: "Not Provided"
        val gender = intent.getStringExtra("gender") ?: "Not Specified"
        val country = intent.getStringExtra("country") ?: "Not Specified"
        val city = intent.getStringExtra("city") ?: "Not Specified"

        // Display the retrieved data
        val userInfo = """
            Welcome!
            Name: $fullName
            Email: $email
            Gender: $gender
            Country: $country
            City: $city
        """.trimIndent()

        val cityInfos = arrayOf(
            R.drawable.kathmandu,
            R.drawable.newdelhi,
            R.drawable.newyork
        )

        val cityTitles = arrayOf(
            "Kathmandu,Nepal",
            "New Delhi, India",
            "New York, USA"
        )

        val cityDesc = arrayOf(
            "Baudhanath Stupa, a UNESCO World Heritage Site in Kathmandu, is one of the largest and most important Buddhist stupas in Nepal. " +
                    "Known for its iconic mandala shape and Buddha eyes, it’s a major pilgrimage site for Buddhists.",
            "New Delhi, the capital of India, is a vibrant city blending history and modernity. Known for its grand monuments like the Red Fort and India Gate, " +
                    "it serves as a cultural, political, and commercial hub, attracting visitors from around the world.",
            "New York City, a global metropolis, is renowned for its iconic landmarks like the Statue of Liberty, Times Square, and Central Park. " +
                    "Known for its vibrant culture, diverse neighborhoods, and bustling atmosphere, it is a major center for finance, arts, and entertainment."
        )

        adapter = recylerAdapter(
            this@NextPage,
            cityInfos,cityTitles,cityDesc
        )

        // Set the user info to the TextView
        binding.myrecyvlerview.adapter = adapter
        binding.myrecyvlerview.layoutManager = LinearLayoutManager(this@NextPage)
        binding.display.text = userInfo
    }
}
