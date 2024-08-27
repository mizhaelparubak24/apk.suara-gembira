package com.example.suaragembiraapps

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.suaragembiraapps.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.extras
        binding.tvDetailJudulLagu.text = data?.getString("judul")
        binding.tvDetailLirikLagu.text = data?.getString("lirik")
        binding.tvDetailReffLagu.text = data?.getString("reff")

        binding.ivBackDetail.setOnClickListener{
            val intent = Intent()
            intent.putExtra("key", 1)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}