package com.betrybe.trybnb.ui.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.betrybe.trybnb.R
import com.betrybe.trybnb.ui.views.fragments.CreateReservationFragment
import com.betrybe.trybnb.ui.views.fragments.ProfileFragment
import com.betrybe.trybnb.ui.views.fragments.ReservationFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val mNavigationMenu: BottomNavigationView by lazy { findViewById(R.id.navigation_bottom_view)}
    private val mCreateReservationFragment = CreateReservationFragment()
    private val mProfileFragment = ProfileFragment()
    private val mReservationFragment = ReservationFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mNavigationMenu.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.reservation_menu_item -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, mReservationFragment)
                        .addToBackStack(null)
                        .commit()
                    true
                }

                R.id.create_reservation_menu_item -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, mCreateReservationFragment)
                        .addToBackStack(null)
                        .commit()
                    true
                    }

                R.id.profile_menu_item -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, mProfileFragment)
                        .addToBackStack(null)
                        .commit()
                    true
                }

                else -> false
            }
        }
    }
}
