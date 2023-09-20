package com.example.kidseducation.presentation.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.kidseducation.R
import com.example.kidseducation.presentation.adapter.listener.LetterListener
import java.util.*

class LetterKeyAdapter(private var position: Int, private val listener : LetterListener) : RecyclerView.Adapter<LetterKeyAdapter.LetterKeyViewHolder>() {

    private val letterList = mutableListOf<String>()
    private var pos : Int = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterKeyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_letter, parent, false)

        return LetterKeyViewHolder(view)
    }

    override fun getItemCount(): Int = letterList.size


    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: LetterKeyViewHolder, position: Int) {
        val letters = letterList[position]


        holder.letter.text = letters

        holder.itemView.setOnClickListener {
            holder.letter.setTextColor(Color.parseColor("#FFFFFFFF"))
            if (pos == 1){
                holder.block_letter.setBackgroundResource(R.drawable.bg_item_letter_color1)

                pos++
            }else if (pos == 2){
                holder.block_letter.setBackgroundResource(R.drawable.bg_item_letter_color2)
                pos++
            }else if (pos == 3){
                holder.block_letter.setBackgroundResource(R.drawable.bg_item_letter_color3)
                pos = 1
            }

            listener.getLetter(letters)
        }
    }

    fun setItem(letterNew: MutableList<String>) {
        letterList.clear()

        letterList.addAll(shuffleArray(letterNew))
        notifyDataSetChanged()
    }

    private fun shuffleArray(letterNew: MutableList<String>): MutableList<String> {

        val rnd = Random()
        for (i in letterNew.size - 1 downTo 1) {
            val index = rnd.nextInt(i + 1)
            val a: String = letterNew.get(index)
            letterNew[index] = letterNew.get(i)
            letterNew[i] = a
        }
        return letterNew
    }

    class LetterKeyViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val letter : TextView = view.findViewById(R.id.tv_letter)
        val block_letter : ConstraintLayout = view.findViewById(R.id.block_letter)
    }
}