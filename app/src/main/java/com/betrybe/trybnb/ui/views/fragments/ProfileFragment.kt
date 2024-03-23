package com.betrybe.trybnb.ui.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.betrybe.trybnb.R
import com.google.android.material.textfield.TextInputLayout

class ProfileFragment: Fragment() {

    private lateinit var mInputLogin: TextInputLayout
    private lateinit var mInputPassword: TextInputLayout
    private lateinit var mButtonLogin: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        mInputLogin = view.findViewById(R.id.login_input_profile)
        mInputPassword = view.findViewById(R.id.password_input_profile)
        mButtonLogin = view.findViewById(R.id.login_input_profile)

        mButtonLogin.setOnClickListener {
            handleLogin()
        }

        return view
    }

    private fun handleLogin() {
        val user = mInputLogin.editText?.text.toString()
        val pass = mInputPassword.editText?.text.toString()

        isValid(user, pass)
    }

    private fun isValid(user: String, pass: String) {
        if (user.isEmpty()) {
            mInputLogin.error = "O campo Login é obrigatório"
        } else {
            mInputLogin.error = null
        }
        if (pass.isEmpty()) {
            mInputPassword.error = "O campo Password é obrigatório"
        } else {
            mInputPassword.error = null
        }
        //if (user.isNotEmpty() && pass.isNotEmpty()) {
        //}
    }
}