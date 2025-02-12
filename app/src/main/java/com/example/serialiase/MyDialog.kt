package com.example.serialiase

import android.content.Context
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

//class MyDialog { // не работает с переходом??
//    companion object {
//        fun createDialog( context: Context,  adapter: ArrayAdapter<User?>)
//
//        : AdapterView.OnItemClickListener =
//            AdapterView.OnItemClickListener { parent, v, position, id ->
//                val user = adapter!!.getItem(position)
//
//                val builder = AlertDialog.Builder(context)
//                builder
//                    .setTitle("Внимание")
//                    .setMessage("Удалить данные?")
//                    .setIcon(android.R.drawable.ic_dialog_alert)
//                    //.setCancelable(true)
//                    .setPositiveButton("Да") { dialog, which ->
//                        val note = adapter.getItem(position)
//                        adapter.remove(note)
//                        Toast.makeText(context, "Данные удалены:$note", Toast.LENGTH_LONG).show()
//                        dialog.dismiss()
//                    }
//
//                    .setNegativeButton("Нет") { dialog, which ->
//                        dialog.dismiss()
//                    }
//
//                val dialog: AlertDialog = builder.create()
//                dialog.show()
//            }
//            }
//    }

