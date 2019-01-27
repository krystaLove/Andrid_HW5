package com.krystalove.task5socialfeed.view

import android.content.Intent
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.krystalove.task5socialfeed.R
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        sign_in_button.setOnClickListener { tryLogin() }
    }
    private fun tryLogin() {
        val mPassword = password_field.text.toString()
        val mLogin = login_field.text.toString()

        if (mPassword == TestUser.Password && mLogin == TestUser.Login)
            login()
        else
            showWarning()
    }
    private fun showWarning() {
        val mPassword = password_field.text.toString()
        val mLogin = login_field.text.toString()
        @StringRes
        val message =
            if (mLogin.isEmpty() && mPassword.isEmpty()) R.string.warning_login_and_password
            else if (mLogin.isEmpty()) R.string.warning_login
            else if (mPassword.isEmpty()) R.string.warning_password
            else if (mLogin != TestUser.Login || mPassword != TestUser.Password) R.string.warning_incorrect
            else null
        Snackbar.make(root_layout, message!!, Snackbar.LENGTH_LONG).show()
    }
    private fun login() {
        startActivity(Intent(this, ClientActivity::class.java))
        finish()
    }
    private object TestUser {
        const val Login = "test"
        const val Password = "test"
    }
}