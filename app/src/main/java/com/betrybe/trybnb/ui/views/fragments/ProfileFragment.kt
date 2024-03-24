package com.betrybe.trybnb.ui.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.betrybe.trybnb.R
import com.betrybe.trybnb.common.ApiIdlingResource
import com.betrybe.trybnb.data.api.ApiService
import com.betrybe.trybnb.data.models.LoginRequest
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class ProfileFragment: Fragment() {

    private lateinit var mInputLogin: TextInputLayout
    private lateinit var mInputPassword: TextInputLayout
    private lateinit var mButtonLogin: Button
    private lateinit var mSuccess: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        mInputLogin = view.findViewById(R.id.login_input_profile)
        mInputPassword = view.findViewById(R.id.password_input_profile)
        mButtonLogin = view.findViewById(R.id.login_button_profile)
        mSuccess = view.findViewById(R.id.success)

        mButtonLogin.setOnClickListener {
            handleLogin()
        }

        return view
    }

    private fun apiCall(username: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                ApiIdlingResource.increment()
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://restful-booker.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                val login = retrofit.create(ApiService::class.java)
                val response = login.loginAuthentication(LoginRequest(username, password))

                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        response.body()
                        mSuccess.visibility = View.VISIBLE
                    }
                    } else {
                        MaterialAlertDialogBuilder(requireContext())
                            .setMessage("Dados incorretos. Tente novamente")
                            .setPositiveButton("Ok") {
                                dialog, _ -> dialog.dismiss()
                            }
                            .setCancelable(false)
                            .create().show()
                    }
                    ApiIdlingResource.decrement()
                } catch (e: HttpException) {
                    ApiIdlingResource.decrement()
                } catch (e: IOException) {
                    ApiIdlingResource.decrement()
                }

        }
    }

    private fun handleLogin() {
        val username = mInputLogin.editText?.text.toString()
        val password = mInputPassword.editText?.text.toString()

        isValid(username, password)
    }

    private fun isValid(username: String, password: String) {
        if (username.isEmpty()) {
            mInputLogin.error = "O campo Login é obrigatório"
        } else {
            mInputLogin.error = null
        }
        if (password.isEmpty()) {
            mInputPassword.error = "O campo Password é obrigatório"
        } else {
            mInputPassword.error = null
        }
        if (username.isNotEmpty() && password.isNotEmpty()) {
            apiCall(username, password)
        }
    }
}