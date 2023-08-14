package com.example.sendernotification

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.messaging.FirebaseMessaging
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var title=findViewById<EditText>(R.id.title)
        var descreiption=findViewById<EditText>(R.id.description)
        var  button=findViewById<Button>(R.id.sendNotification)



// Add a new document with a generated ID


        val tokenList: List<String> =
            mutableListOf(
                "dXRJFsebQB24g8ThxWPsjo:APA91bEqYoGMHNco6ou8sYrBCHwMqqm6Wgze2c2WhlJO47ONQ6jlRgQAtLu3v8ffEHWj58le38oqZrN9bHhUX9nA0bC17X9gBj0Oh27UPXkucGKxegDOU37G8OvG3s3UvodBuaAU_DOq"
            ,"fhI8YHl_QseW8w7uckDtAp:APA91bEqrJkGlDBQituW16lVjjA7bL9l7ONPcGAKpNAyqi3ZHWsisuOIzlybNFGavVzBJ-bfvcfHy2AmWJRlS2N4Bb1KuR_eewlwdlm3ICTmS-bgyosksBXgVmEynVhCevB5KRtnz8AZ"
            )
        val headerMap =
            hashMapOf<String, String>("Authorization" to "key=AAAAX97dHq8:APA91bGWtjLVcwL5CzcqUSeBIgVWMgLXH_CMwcrTWueStcwzE24Itklbgku5xYCfdFFUzlkRIVtqE0p8ixaKZZQDekcyDjyeMAubHuuSzb3WsAzqU2hFaxeRKYUxLihOwDw0sfFLdtwD")
        button.setOnClickListener{

            val notificationData = NotificationData(
                Notification(
                    "abhimanu12",
                    title.text.toString(),
                    true,
                    descreiption.text.toString()
                ), tokenList
            )
            Apicalling.Create().send(headerMap, notificationData)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    val notification = it
                }

            Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()

        }


    }
}