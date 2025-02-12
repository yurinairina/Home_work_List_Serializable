package com.example.serialiase

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {
    private val notes: MutableList<User> = mutableListOf() //list
    private var adapter: ArrayAdapter<User>? = null// вывод листа

    private lateinit var listView: ListView
    private lateinit var savedBTN: Button
    private lateinit var input_nameET: EditText //вводим Имя
    private lateinit var input_surnameET: EditText //вводим Возраст
    private lateinit var input_adressET: EditText
    private lateinit var input_teleET: EditText
    private lateinit var toolbarMain: Toolbar

    @SuppressLint("ResourceAsColor", "RestrictedApi", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//схема= ID
        toolbarMain = findViewById(R.id.toolbarMain)//Тулбар
        title = "Каталог пользователей"
        toolbarMain.subtitle = "Версия 2.0"
        toolbarMain.setLogo(R.drawable.ic_launcher_foreground)
        setSupportActionBar(toolbarMain)

        savedBTN = findViewById(R.id.savedBTN)
        input_nameET = findViewById(R.id.input_nameET)
        input_surnameET = findViewById(R.id.input_surnameET)
        input_adressET = findViewById(R.id.input_adressET)
        input_teleET = findViewById(R.id.input_teleET)
        listView = findViewById(R.id.listView) //Cписок

        val adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, notes)//адаптер ListView
        listView.adapter = adapter //сoздание выход списка

        savedBTN.setOnClickListener {
            val user = User(
                input_nameET.text.toString(),
                input_surnameET.text.toString(),
                input_adressET.text.toString(),
                input_teleET.text.toString()
            )
            //добавляем данные
            if (InputUser(this, user).isValidate()) return@setOnClickListener
            notes.add(user)
            input_nameET.text.clear() //очищение полей при сохранении
            input_surnameET.text.clear()
            input_adressET.text.clear()
            input_teleET.text.clear()
            adapter.notifyDataSetChanged() //Метод notifyDataSetChanged() в AS уведомляет список // об изменении данных для обновления списка на экране.
            Toast.makeText(this, "Пользователь ${user.surname} добавлен", Toast.LENGTH_SHORT).show()

//            listView.onItemClickListener = //диалоговое окно
//                MyDialog.createDialog(this, adapter)
        }
        listView.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val userPosition = adapter!!.getItem(position)
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra(User::class.java.name, userPosition)
                startActivity(intent)

//
            }


// listView.onItemClickListener = //диалоговое окно
//  MyDialog.createDialog(this, adapter)
// true


//        listView.onItemLongClickListener =
//            AdapterView.OnItemLongClickListener { _, _, position, _ ->
//                showDeleteDialog(position)
//                true
//            }
//    }
//
//    @SuppressLint("StringFormatInvalid")
//    private fun showDeleteDialog(position: Int) {
//        val user = adapter!!.getItem(position)
//        val builder = AlertDialog.Builder(this)
//
//        .setTitle(getString(R.string.delete_person_text))
//            .setIcon(R.drawable.ic_android_black_24dp)
//            .setMessage(getString(R.string.do_you_want_delete_person_text, user))

//            .setPositiveButton(getString(R.string.yes)) { dialog, _ ->
//                notes.removeAt(position)
//                adapter?.notifyDataSetChanged()
//                Toast.makeText(
//                    this,
//                    getString(R.string.person_deleted_text, user), Toast.LENGTH_SHORT
//                ).show()
//                dialog.dismiss()
//            }
//        builder.setNegativeButton(getString(R.string.no)) { dialog, _ ->
//            dialog.dismiss()
//        }
//        val dialog: AlertDialog = builder.create()
//        dialog.show()
//    }
//}

    }
        //МЕНЮ
        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            menuInflater.inflate(R.menu.menu, menu)
            return true
        }

        // МЕНЮ выход
        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            if (item.itemId == R.id.context_menuMain) {
                Toast.makeText(this, getString(R.string.exsit_text), Toast.LENGTH_LONG).show()
                finish() //всплывающее сообщение
            }
            return super.onOptionsItemSelected(item)

        }
    }




// listView.onItemClickListener =
//MyDialog.createDialog(this, adapter)


//        // МЕНЮ
//        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//            menuInflater.inflate(R.menu.context_menu, menu)
//            return true
//        }
//        // МЕНЮ выход
//        override fun onOptionsItemSelected(item: MenuItem): Boolean {
//            if (item.itemId == R.id.context_menuMain) {
//                Toast.makeText(this, getString(R.string.exsit_text), Toast.LENGTH_LONG).show()
//                finish() //всплывающее сообщение
//            }
//            return super.onOptionsItemSelected(item)
//        }



