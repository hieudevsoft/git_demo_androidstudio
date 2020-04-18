package com.example.demonhe

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.net.HttpURLConnection
import java.net.URI
import java.net.URL
import javax.net.ssl.HttpsURLConnection


class MainActivity : AppCompatActivity()
{

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        bt_Increase.setOnClickListener {
            SetCountNotifications().increaseNotifications(layout_bell)
        }
        button.setOnClickListener {
            DownLoadImage()
                .execute("https://nnimgt-a.akamaihd.net/transform/v1/crop/frm/silverstone-feed-data/dfc46751-bc35-4c59-ac94-e4861e4b7eae.jpg/r0_0_800_600_w1200_h678_fmax.jpg")
        }
    }
    inner class DownLoadImage: AsyncTask<String, Void, Bitmap>() {
        override fun doInBackground(vararg params: String?): Bitmap {
            var bitmap:Bitmap? = null
            val url:URL = URL(params[0]!!)
            val http = url.openConnection() as HttpsURLConnection
            http.connectTimeout = 5000
            http.readTimeout = 10000
            http.requestMethod = "GET"
            http.connect()

            val inputStream = http.inputStream
            bitmap = BitmapFactory.decodeStream(inputStream)
            return bitmap!!
        }

        override fun onPostExecute(result: Bitmap?) {
            Toast.makeText(applicationContext,"Done",Toast.LENGTH_SHORT).show()
            imageView.setImageBitmap(result)
        }

    }
}
