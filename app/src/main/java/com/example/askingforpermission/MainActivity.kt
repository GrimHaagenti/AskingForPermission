package com.example.askingforpermission

import android.content.Context
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.result.contract.ActivityResultContracts
import com.example.askingforpermission.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val launcher = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { image: Bitmap? ->

        if (image != null) {
            binding.imageView.setImageBitmap(image)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.fotico.setOnClickListener {
                launcher.launch(null)
        }
        super.onCreate(savedInstanceState)



        setContentView(binding.root)
    }
}