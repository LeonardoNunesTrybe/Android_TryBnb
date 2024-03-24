package com.betrybe.trybnb.ui.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import com.betrybe.trybnb.R
import com.google.android.material.textfield.TextInputLayout

class CreateReservationFragment: Fragment() {

    private lateinit var inputFirstName: TextInputLayout
    private lateinit var inputLastName: TextInputLayout
    private lateinit var inputCheckin: TextInputLayout
    private lateinit var inputCheckout: TextInputLayout
    private lateinit var inputAddInfo: TextInputLayout
    private lateinit var inputTotalPrice: TextInputLayout
    private lateinit var inputDeposit: CheckBox
    private lateinit var inputButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_create_reservation, container, false)

        inputFirstName = view.findViewById(R.id.first_name_create_reservation)
        inputLastName = view.findViewById(R.id.last_name_create_reservation)
        inputCheckin = view.findViewById(R.id.checkin_create_reservation)
        inputCheckout = view.findViewById(R.id.checkout_create_reservation)
        inputAddInfo = view.findViewById(R.id.additional_needs_create_reservation)
        inputTotalPrice = view.findViewById(R.id.total_price_create_reservation)
        inputButton = view.findViewById(R.id.create_reservation_button)

        inputButton.setOnClickListener {
            handleLogin()
        }

        return view
    }

    private fun handleLogin() {
        val firstName = inputFirstName.editText?.text.toString()
        val lastName = inputLastName.editText?.text.toString()
        val checkin = inputCheckin.editText?.text.toString()
        val checkout = inputCheckout.editText?.text.toString()
        val addInfo = inputAddInfo.editText?.text.toString()
        val totalPrice = inputTotalPrice.editText?.text.toString()

        isValid(firstName, lastName, checkin, checkout, addInfo, totalPrice)
    }

    private fun isValid(
        firstName: String,
        lastName: String,
        checkin: String,
        checkout: String,
        addInfo: String,
        totalPrice: String
    ) {
        if (firstName.isEmpty()) {
            inputFirstName.error = "O campo Nome é obrigatório"
        } else {
            inputFirstName.error = null
        }
        if (lastName.isEmpty()) {
            inputLastName.error = "O campo Sobrenome é obrigatório"
        } else {
            inputLastName.error = null
        }
        if (checkin.isEmpty()) {
            inputCheckin.error = "O campo Checkin é obrigatório"
        } else {
            inputCheckin.error = null
        }
        if (checkout.isEmpty()) {
            inputCheckout.error = "O campo Checkout é obrigatório"
        } else {
            inputCheckout.error = null
        }
        if (addInfo.isEmpty()) {
            inputAddInfo.error = "O campo Necessidades Adicionais é obrigatório"
        } else {
            inputAddInfo.error = null
        }
        if (totalPrice.isEmpty()) {
            inputTotalPrice.error = "O campo Preço Total é obrigatório"
        } else {
            inputTotalPrice.error = null
        }
    }
}