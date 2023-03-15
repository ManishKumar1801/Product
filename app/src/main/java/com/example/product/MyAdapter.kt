package com.example.product

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.product.databinding.ItemListBinding

class MyAdapter(val context:Activity,val productArrayList:List<Product>):
RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=LayoutInflater.from(parent.context)
        val binding:ItemListBinding=DataBindingUtil.inflate(view,R.layout.item_list,parent,false)
        return  MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=productArrayList[position]
        with(holder.binding){
            Title.text=currentItem.title
            brand.text=currentItem.brand
            discreption.text=currentItem.description
            Glide.with(context)
                .load(currentItem.thumbnail)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(image)

        }
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    class MyViewHolder(val binding:ItemListBinding):RecyclerView.ViewHolder(binding.root){

    }
}