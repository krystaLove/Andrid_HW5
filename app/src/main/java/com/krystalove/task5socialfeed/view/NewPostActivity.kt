package com.krystalove.task5socialfeed.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.krystalove.task5socialfeed.R
import kotlinx.android.synthetic.main.activity_new_post.*
import java.io.IOException

class NewPostActivity : AppCompatActivity() {

    private val PICK_FROM_FILE = 1
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_post)

        chooseButton.setOnClickListener {
            galleryImageIntent()
        }
        postButton.setOnClickListener {
            post()
        }
    }

    private fun galleryImageIntent() {
        intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_FROM_FILE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_FROM_FILE && resultCode == RESULT_OK && data != null && data.data != null) {
            imageUri = data.data!!
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, imageUri)
                Glide.with(this)
                    .load(bitmap)
                    .into(imageView)
                card.visibility = View.VISIBLE
                chooseButton.visibility = View.INVISIBLE

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun post() {
        if (newsPost_title.text!!.isEmpty() || newsPost_description.text!!.isEmpty()) {
            Snackbar.make(root_layout, "Enter empty fields", Snackbar.LENGTH_SHORT).show()
        } else {
            val intent = this.intent
            intent.putExtra("Title", newsPost_title.text.toString())
            intent.putExtra("Description", newsPost_description.text.toString())
            if (imageUri != null)
                intent.putExtra("ImageURI", imageUri.toString())

            this.setResult(RESULT_OK, intent)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
