package com.innobles.demoappassigment.ui.main

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.databinding.BindingAdapter

/**
 * Created by Musharib Ali on 17/2/21.
 * I.S.T Pvt. Ltd
 * musharib.ali@innobles.com
 */

fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            afterTextChanged.invoke(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
    })
}
fun EditText.validate(message: String, validator: (String) -> Boolean) {
    this.afterTextChanged {
        this.error = if (validator(it)) null else message
    }
    this.error = if (validator(this.text.toString())) null else message
}

fun EditText.isValid(): Boolean {
    return this.text.isNotBlank() && this.text.length > 1 && this.text.isNotEmpty()
}