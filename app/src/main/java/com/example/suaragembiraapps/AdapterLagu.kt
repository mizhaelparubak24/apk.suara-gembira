package com.example.suaragembiraapps

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.suaragembiraapps.databinding.ListLaguBinding

class AdapterLagu(
    private val context: Context?, private val list: List<LaguModel>) : RecyclerView.Adapter<AdapterLagu.ViewHolder>() {
    class ViewHolder(val binding : ListLaguBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListLaguBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(list[position]){
                binding.judulLagu.text = this.nomor + "  " + this.judul

                binding.listLagu.setOnClickListener{
                    val bundle = Bundle()
                    bundle.putString("judul", this.judul)
                    bundle.putString("lirik", this.lirik)
                    bundle.putString("reff", this.reff)

                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtras(bundle)
                    context?.startActivity(intent)
                }
            }
        }

    }
}