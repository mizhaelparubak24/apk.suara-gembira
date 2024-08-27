package com.example.suaragembiraapps

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.suaragembiraapps.databinding.ActivityKelompokBinding

class KelompokActivity : AppCompatActivity() {
    private lateinit var binding: ActivityKelompokBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKelompokBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBackKelompok.setOnClickListener {
            val intent = Intent()
            intent.putExtra("key", 1)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}