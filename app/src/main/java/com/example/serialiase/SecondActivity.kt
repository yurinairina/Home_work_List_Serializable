package com.example.serialiase
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.DialogTitle
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.Serializable

class SecondActivity : AppCompatActivity() {
        private lateinit var titleTV: TextView

        private lateinit var nameTV: TextView
        private lateinit var surnameTV: TextView
        private lateinit var addressTV: TextView
        private lateinit var phoneTV: TextView

        @SuppressLint("MissingInflatedId", "SetTextI18n")
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_second)

            titleTV = findViewById(R.id.titleTV)
            nameTV = findViewById(R.id.nameTV)
            surnameTV = findViewById(R.id.surnameTV)
            addressTV = findViewById(R.id.adressTV)
            phoneTV = findViewById(R.id.phoneTV)

            val person = intent.extras?.getSerializable(User::class.java.name) as? User//передача данных
            nameTV.text = "Имя: ${person?.name}"
            surnameTV.text = "Фамилия: ${person?.surname}"
            addressTV.text = "Адрес: ${person?.adress}"
            phoneTV.text = "Тел: ${person?.tele}"
        }
    }