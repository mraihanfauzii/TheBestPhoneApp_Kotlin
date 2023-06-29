package com.bangkit.submissionaplikasiandroidpemula_mraihanfauzi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.submissionaplikasiandroidpemula_mraihanfauzi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<Smartphone>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvSmartphones.setHasFixedSize(true)

        list.addAll(getListSmartphones())
        showRecyclerList()

        supportActionBar?.title = "TheBestPhoneApp"
    }

    private fun getListSmartphones(): ArrayList<Smartphone> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataSpecification = resources.getStringArray(R.array.data_specification)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listSmartphone = ArrayList<Smartphone>()
        for (i in dataName.indices) {
            val Smartphone = Smartphone(dataName[i], dataSpecification[i], dataPhoto[i])
            listSmartphone.add(Smartphone)
        }
        return listSmartphone
    }

    private fun showRecyclerList() {
        binding.rvSmartphones.layoutManager = LinearLayoutManager(this)
        val listSmartphoneAdapter = ListSmartphoneAdapter(list)
        binding.rvSmartphones.adapter = listSmartphoneAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                binding.rvSmartphones.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                binding.rvSmartphones.layoutManager = GridLayoutManager(this,2)
            }
            R.id.about -> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}