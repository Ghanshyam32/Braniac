package com.ghanshyam.brainiac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.google.firebase.firestore.FirebaseFirestore

class LauncherActivity : AppCompatActivity() {
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var adapter: QuizAdapter
    private var quizList = mutableListOf<Quiz>()
    lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        setUpView()
        populateData()
    }

    private fun populateData() {
        quizList.add(Quiz("12-10-2022", "12-10-2022"))
        quizList.add(Quiz("12-10-2022", "12-10-2022"))
        quizList.add(Quiz("12-10-2022", "12-10-2022"))
        quizList.add(Quiz("12-10-2022", "12-10-2022"))



    }

    fun setUpView() {
        setUpFireStore()
        setUpDrawerLayout()
        setUpRecyclerView()
    }

    private fun setUpFireStore() {
        firestore = FirebaseFirestore.getInstance()
        val collection = firestore.collection("brainiac")
        collection.addSnapshotListener { value, error ->
            if(value == null || error != null){
                Toast.makeText(this, "Error fetching data", Toast.LENGTH_SHORT).show()
                return@addSnapshotListener
            }
            Log.d("DATA", value.toObjects(Quiz::class.java).toString())
        }
    }

    private fun setUpRecyclerView() {
        adapter = QuizAdapter(this, quizList)
        var quizRecyclerView: RecyclerView = findViewById(R.id.quizRecycler)
        quizRecyclerView.layoutManager = GridLayoutManager(this, 2)
        quizRecyclerView.adapter = adapter
    }

    private fun setUpDrawerLayout() {
        var topBar: MaterialToolbar = findViewById(R.id.topAppBar)
        val drawer: DrawerLayout = findViewById(R.id.mainDrawer)
        setSupportActionBar(topBar)
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, drawer, R.string.app_name, R.string.app_name)
        actionBarDrawerToggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}