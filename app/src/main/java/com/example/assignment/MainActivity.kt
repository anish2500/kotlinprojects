package com.example.assignment

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.assignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val countries = listOf("Select Country", "Nepal", "India", "United States", "Canada")
        val countryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        countryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.countrySpinner.adapter = countryAdapter

        val cities = listOf("Kathmandu", "New Delhi", "New York", "Toronto")
        val cityAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cities)
        binding.autocomplete.setAdapter(cityAdapter)


        binding.submitbtn.setOnClickListener {
            val fullName = binding.FullNameId.text.toString()
            val email = binding.emailText.text.toString()
            val gender = when (binding.radioGroup.checkedRadioButtonId) {
                binding.maleButton.id -> "Male"
                binding.femaleButton.id -> "Female"
                else -> "Not Specified"
            }
            val country = binding.countrySpinner.selectedItem.toString()
            val city = binding.autocomplete.text.toString()

            val isChecked = binding.checkbox.isChecked


            if (!isChecked) {

                Toast.makeText(this, "Please, Click on I agree", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }



            if (fullName.isBlank() || email.isBlank() || country == "Select Country" || city.isBlank()) {
                Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val intent = Intent(this, NextPage::class.java).apply {
                putExtra("fullName", fullName)
                putExtra("email", email)
                putExtra("gender", gender)
                putExtra("country", country)
                putExtra("city", city)
            }
            startActivity(intent)


        }
    }
}


