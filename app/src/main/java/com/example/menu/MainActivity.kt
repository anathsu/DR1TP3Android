package com.example.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Add a toolbar como ActionBar no app
        setSupportActionBar(toolbarSuperior)

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){

            // selecionou item com ID "info_item"
            R.id.info_item -> {
                findNavController(R.id.nav_fragment)
                    .navigate(R.id.infoFragment)
            }
            R.id.home_item -> {
                nav_fragment.findNavController()
                    .navigate(R.id.homeFragment)
            }
            R.id.list_item -> {
                findNavController(R.id.nav_fragment)
                    .navigate(R.id.listFragment)
            }
        }
        return true
    }
}
