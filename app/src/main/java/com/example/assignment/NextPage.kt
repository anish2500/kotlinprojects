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
import com.example.assignment.databinding.ActivityNextPageBinding

class NextPage : AppCompatActivity() {
    private lateinit var binding: ActivityNextPageBinding

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

        // Set the user info to the TextView
        binding.display.text = userInfo
    }
}
