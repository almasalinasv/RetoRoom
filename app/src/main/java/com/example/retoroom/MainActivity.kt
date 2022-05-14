package com.example.retoroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.retoroom.database.User
import com.example.retoroom.databinding.ActivityMainBinding
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            Toast.makeText(this, "enviado", Toast.LENGTH_SHORT).show()
            mainViewModel.saveUser(
                User(
                    0,
                    user_name = binding.editTextTextPersonName.text.toString(),
                )
            )

           mainViewModel.getUsers()
            mainViewModel.savedUsers.observe(this) { usersList ->
                if (!usersList.isNullOrEmpty()) {
                    for (user in usersList) {
                        Log.d("thesearetheusers", user.user_name)
                        binding.rvData.adapter = MainAdapter(usersList)

                    }
                } else {
                    Log.d("thesearetheusers", "null or empty")
                }
            }
        }
    }
}