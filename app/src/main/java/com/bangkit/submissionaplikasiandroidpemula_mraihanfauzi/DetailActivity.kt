package com.bangkit.submissionaplikasiandroidpemula_mraihanfauzi

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import com.bangkit.submissionaplikasiandroidpemula_mraihanfauzi.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide
import java.io.File
import java.io.FileOutputStream

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    @SuppressLint("WrongThread")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataSmartphone = intent.getParcelableExtra<Smartphone>("key_smartphone") as Smartphone
        binding.tvName.text = dataSmartphone.name
        binding.textDescription.text = dataSmartphone.specification
        Glide.with(this@DetailActivity)
            .load(dataSmartphone.photo)
            .into(binding.imagePhone)

        val image = dataSmartphone.photo.toString()

        //Fungsi Share dummy
        binding.buttonShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "${dataSmartphone.name}, ${dataSmartphone.specification}")
            startActivity(Intent.createChooser(shareIntent, "Share deskripsi hp ${dataSmartphone.name} ke :"))
        }
        supportActionBar?.title = dataSmartphone.name

    }
}