package com.ghanshyam.brainiac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ghanshyam.brainiac.databinding.ActivityQuestionBinding
import com.google.firebase.firestore.FirebaseFirestore

class QuestionActivity : AppCompatActivity() {

    var quizzes: MutableList<Quiz>? = null
    var questions: MutableMap<String, Questions>? = null
    var index = 1
    private lateinit var binding: ActivityQuestionBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setUpFirestore()
    }

    private fun setUpFirestore() {
        val firestore = FirebaseFirestore.getInstance()
        val date = intent.getStringExtra("DATE")
        if (date != null) {
            firestore.collection("brainiac").whereEqualTo("title", date)
                .get()
                .addOnSuccessListener {
                    if (it != null && !it.isEmpty) {
//                        Log.d("DATA", it.toObjects(Quiz::class.java).toString())
                        quizzes = it.toObjects(Quiz::class.java)
                        questions = quizzes!![0].questions
                        bindViews()
                    }
//                    else {
//                        Log.d("QuestionActivity", "No documents found with the specified title")
//                    }
//                }
//                .addOnFailureListener { exception ->
//                    Log.e("QuestionActivity", "Error getting documents: ${exception.message}")
//                }
                }
        }
    }

    private fun bindViews() {
        binding.btnPrevious.visibility = View.GONE
        binding.btnNext.visibility = View.GONE
        binding.btnSubmit.visibility = View.GONE

        if (index == 1) {
            binding.btnNext.visibility = View.VISIBLE
        } else if (index == questions!!.size) {
            binding.btnSubmit.visibility = View.VISIBLE
            binding.btnPrevious.visibility = View.VISIBLE
        } else {
            binding.btnPrevious.visibility = View.VISIBLE
            binding.btnNext.visibility = View.VISIBLE
        }

        val currentQuestions = questions!!["question$index"]

        currentQuestions?.let {
            val description: TextView = binding.description
            val optionList: RecyclerView = binding.optionList

            description.text = it.description
            val optionAdapter = OptionAdapter(this, it)
            optionList.layoutManager = LinearLayoutManager(this)
            optionList.adapter = optionAdapter
            optionList.setHasFixedSize(true)
        }


    }
}