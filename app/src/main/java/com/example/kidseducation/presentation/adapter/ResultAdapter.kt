package com.example.kidseducation.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kidseducation.R

class ResultAdapter : RecyclerView.Adapter<ResultAdapter.ResultViewHolder>() {

    private val resultList = mutableListOf<com.example.kidseducation.business.datebase.Result>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_result, parent, false)

        return ResultViewHolder(view)
    }

    override fun getItemCount(): Int = resultList.size

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val result = resultList[position]

        holder.text.setText(result.text)
        holder.icon.setImageResource(result.icon)
    }

    fun setItem(resultNew: List<com.example.kidseducation.business.datebase.Result>) {
        resultList.clear()
        resultList.addAll(resultNew)
        notifyDataSetChanged()
    }

    class ResultViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val icon : ImageView = view.findViewById(R.id.ic_animals)
        val text : TextView = view.findViewById(R.id.tv_answer)
    }
}