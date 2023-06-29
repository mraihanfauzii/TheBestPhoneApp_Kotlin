package com.bangkit.submissionaplikasiandroidpemula_mraihanfauzi

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.submissionaplikasiandroidpemula_mraihanfauzi.databinding.ItemRowSmarphoneBinding
import com.bumptech.glide.Glide

class ListSmartphoneAdapter(private val listSmartphone: ArrayList<Smartphone>) : RecyclerView.Adapter<ListSmartphoneAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowSmarphoneBinding.inflate(LayoutInflater.from(parent.context), parent, false )
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val(name,specification,photo) = listSmartphone[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.binding.imgItemPhoto)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemSpecification.text = specification

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("key_smartphone", listSmartphone[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    override fun getItemCount(): Int = listSmartphone.size

    class ListViewHolder(var binding: ItemRowSmarphoneBinding) : RecyclerView.ViewHolder(binding.root)

}