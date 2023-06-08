package com.ghanshyam.brainiac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar

class LauncherActivity : AppCompatActivity() {
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        setUpView()
    }

    fun setUpView() {
        setUpDrawerLayout()
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
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}