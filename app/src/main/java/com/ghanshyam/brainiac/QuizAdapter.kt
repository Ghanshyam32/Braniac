package com.ghanshyam.brainiac

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class QuizAdapter(
    val context: Context, val quizzes: List<Quiz>
) : RecyclerView.Adapter<QuizAdapter.QuizViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuizViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_quiz, parent, false)
        return QuizViewHolder(view)
    }

    override fun getItemCount(): Int {
        return quizzes.size
    }

    override fun onBindViewHolder(holder: QuizViewHolder, position: Int) {

        holder.textViewTitle.text = quizzes[position].title
        holder.cardContainer.setCardBackgroundColor(Color.parseColor(ColorPicker().getColor()))
        holder.iconView.setImageResource(IconPicker().getIcon())
    }

    inner class QuizViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewTitle: TextView = itemView.findViewById(R.id.quizTitle)
        var cardContainer: CardView = itemView.findViewById(R.id.cardContainer)
        var iconView: ImageView = itemView.findViewById(R.id.quizIcon)
    }
}