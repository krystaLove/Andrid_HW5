package com.krystalove.task5socialfeed.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.krystalove.task5socialfeed.R
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    private val USER_LOGIN = 1
    private val USER_ERROR = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        sign_in_button.setOnClickListener { login() }
    }

    private fun tryLogin(): Int {
        val password = password_field.text.toString()
        val login = login_field.text.toString()
        val message =
            if (login.isEmpty() && password.isEmpty()) R.string.warning_login_and_password
            else if (login.isEmpty()) R.string.warning_login
            else if (password.isEmpty()) R.string.warning_password
            else if (login != TestUser.Login || password != TestUser.Password) R.string.warning_incorrect
            else null
        if (message is Int) {
            Snackbar.make(root_layout, message, Snackbar.LENGTH_SHORT).show()
            return USER_ERROR
        }
        return USER_LOGIN

    }

    private fun login() {
        if (tryLogin() == USER_LOGIN) {
            startActivity(Intent(this, ClientActivity::class.java))
        }
    }

    private object TestUser {
        const val Login = "test"
        const val Password = "test"
    }
}

