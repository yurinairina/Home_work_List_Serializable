package com.example.serialiase

import android.content.Context
import android.widget.Toast
import java.io.Serializable

class User(val name: String,
           val surname: String,
           val adress: String,
           val tele: String
    ): Serializable {
        override fun toString(): String {
            return "$name $surname"
        }
    }
class InputUser(private val context: Context, private val person: User) {
    fun isValidate(): Boolean {
        if (person.name.isEmpty() && person.surname.isEmpty() && person.adress.isEmpty() && person.tele.isEmpty()) {
            Toast.makeText(context,  context.getString(R.string.name), Toast.LENGTH_SHORT).show()
            return false
        }
        if (person.name.isEmpty()) {
            Toast.makeText(context, context.getString(R.string.adress), Toast.LENGTH_SHORT).show()
            return false
        }
        if (person.name.length !in 2..32) {
            Toast.makeText(context, context.getString(R.string.name), Toast.LENGTH_SHORT).show()
            return false
        }
        if (person.surname.isEmpty()) {
            Toast.makeText(context,
                context.getString(R.string.surname), Toast.LENGTH_SHORT).show()
            return false
        }
        if (person.surname.length !in 2..32) {
            Toast.makeText(context, context.getString(R.string.surname), Toast.LENGTH_SHORT).show()
            return false
        }
        if (person.adress.isEmpty()) {
            Toast.makeText(context,
                context.getString(R.string.adress), Toast.LENGTH_SHORT).show()
            return false
        }
        if (person.adress.length !in 3..100) {
            Toast.makeText(context,
                context.getString(R.string.adress), Toast.LENGTH_SHORT).show()
            return false
        }
        if (person.tele.isEmpty()) {
            Toast.makeText(context, context.getString(R.string.phone), Toast.LENGTH_SHORT).show()
            return false
        }
        if (person.tele.length !in 10..15) {
            Toast.makeText(context, context.getString(R.string.phone), Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
}


