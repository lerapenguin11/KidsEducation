package com.example.kidseducation.presentation.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.kidseducation.R
import com.example.kidseducation.business.model.DefaultTextModel
import com.example.kidseducation.business.model.KeysReadingModel
import com.example.kidseducation.presentation.adapter.listener.LetterListener

class LetterAnswerAdapter(private val position: Int, private val listener : LetterListener) : RecyclerView.Adapter<LetterAnswerAdapter.LetterAnswerViewHolder>() {

    private var letterList = mutableListOf<String>()
    private val keysList = mutableListOf<String>()
    private var result : String = ""
    private var pos : Int = 1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterAnswerAdapter.LetterAnswerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_answer_reading, parent, false)

        return LetterAnswerViewHolder(view)
    }

    override fun getItemCount(): Int = letterList.size


    override fun onBindViewHolder(holder: LetterAnswerViewHolder, position: Int) {
        val letters = letterList[position]
        holder.letter.setText(letters)
    }

    fun setItem(letterNew: List<String>, keysNew : List<String>) {
        letterList.clear()
        letterList.addAll(letterNew)
        keysList.clear()
        keysList.addAll(keysNew)
        notifyDataSetChanged()
    }

    fun addLetter(letter: String, holder: LetterAnswerViewHolder, position: Int) {
        if (letterList[position].isEmpty()){
            holder.letter.setText(letter)
            letterList[position] = letter
            notifyDataSetChanged()
        }
    }

    fun resultText(position: Int) : String{
        if (position == keysList.size){
            result = letterList.joinToString("")
        }

        return result
    }

    class LetterAnswerViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var letter : EditText = view.findViewById(R.id.input_letter)
    }
}