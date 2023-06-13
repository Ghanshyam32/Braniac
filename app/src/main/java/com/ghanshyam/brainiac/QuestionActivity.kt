package com.ghanshyam.brainiac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class QuestionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        bindViews()
    }

    private fun bindViews() {
        val question = Questions(
            "Who is the first prime minister of India?",
            "Pt, Jawaharlal Nehru",
            "Mahatma Gandhi",
            "vallabh Bhai Patel",
            "Subhash chandra bose"
        )
        val description: TextView = findViewById(R.id.description)
        val optionList: RecyclerView = findViewById(R.id.optionList)

        description.text = question.description
        val optionAdapter = OptionAdapter(this, question)
        optionList.layoutManager = LinearLayoutManager(this)
        optionList.adapter = optionAdapter
        optionList.setHasFixedSize(true)

    }
}