package com.dzakyhdr.mycustomviews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val button: MyButton by lazy { findViewById(R.id.my_button) }
    private val editText: MyEditText by lazy { findViewById(R.id.my_edit_text) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setMyButtonEnable()

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                setMyButtonEnable()
            }
            override fun afterTextChanged(s: Editable) {
            }
        })
        button.setOnClickListener { Toast.makeText(this@MainActivity, editText.text, Toast.LENGTH_SHORT).show() }
    }

    private fun setMyButtonEnable() {
        val result = editText.text.toString()
        button.isEnabled = true && result.isNotEmpty()
    }
}