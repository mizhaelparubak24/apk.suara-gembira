package com.example.suaragembiraapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.suaragembiraapps.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: AdapterLagu
    private lateinit var filteredList: ArrayList<LaguModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        Thread.sleep(1000)
        installSplashScreen()
        setContentView(binding.root)

        binding.ivKelompok.setOnClickListener {
            val intent = Intent(this, KelompokActivity::class.java)
            startActivity(intent)
        }
        setAdapterView()
    }
    private fun setAdapterView() {
        val listData: MutableList<LaguModel> = mutableListOf()
        binding.rvLagu.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        judulLagu().forEachIndexed { index, nama ->
            listData.add(
                LaguModel(
                    nomorLagu()[index],
                    judulLagu()[index],
                    lirikLagu()[index],
                    reffLagu()[index]
                )
            )
        }

        adapter = AdapterLagu(this, listData)
        binding.rvLagu.adapter = adapter


        // search view
        filteredList = ArrayList(listData)

        binding.searchLagu.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {


                listData.clear()

                val searchText = newText!!.toLowerCase(Locale.getDefault())

                if (searchText.isNotEmpty()) {

                    filteredList.forEach {
                        if (it.judul.toLowerCase(Locale.getDefault()).contains(searchText) ||
                            it.nomor.toLowerCase(Locale.getDefault()).contains(searchText)) {
                            listData.add(it)
                        }
                    }

                    adapter.notifyDataSetChanged()

                } else {
                    listData.clear()
                    listData.addAll(filteredList)
                    adapter.notifyDataSetChanged()
                }
                return false
            }

        })
    }


    private fun judulLagu(): Array<String> = resources.getStringArray(R.array.judulLagu)
    private fun nomorLagu(): Array<String> = resources.getStringArray(R.array.nomorLagu)
    private fun lirikLagu(): Array<String> = resources.getStringArray(R.array.lirikLagu)
    private fun reffLagu(): Array<String> = resources.getStringArray(R.array.reffLagu)
}