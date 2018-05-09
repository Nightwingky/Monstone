package com.graduation.nightwingky.book_drifting.monstone.main_program

import android.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

import com.graduation.nightwingky.book_drifting.R
import com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentHome.FragmentHome
import com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentMe.FragmentMe
import com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentPutOut.FragmentPutOut
import com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentShoppingCart.FragmentShoppingCart

class MainFragmentActivity : AppCompatActivity(), View.OnClickListener {

    private var tv_tabHome: TextView? = null
    private var tv_tabPutOut: TextView? = null
    private var tv_tabShoppingCart: TextView? = null
    private var tv_tabSettings: TextView? = null

    private var fragmentHome: FragmentHome? = null
    private var fragmentPutOut: FragmentPutOut? = null
    private var fragmentShoppingCart: FragmentShoppingCart? = null
    private var fragmentMe: FragmentMe? = null

    private var transaction: FragmentTransaction? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment)

        bindView()

        transaction = fragmentManager.beginTransaction()

        initHomeFragment()
        transaction!!.commit()
    }

    private fun bindView() {
        tv_tabHome = findViewById<View>(R.id.txt_home) as TextView
        tv_tabPutOut = findViewById<View>(R.id.txt_put_out) as TextView
        tv_tabShoppingCart = findViewById<View>(R.id.txt_shoppingcart) as TextView
        tv_tabSettings = findViewById<View>(R.id.txt_me) as TextView

        tv_tabHome!!.setOnClickListener(this)
        tv_tabPutOut!!.setOnClickListener(this)
        tv_tabShoppingCart!!.setOnClickListener(this)
        tv_tabSettings!!.setOnClickListener(this)
    }

    private fun initHomeFragment() {
        hideAllFragment(transaction)

        setUnselected()
        tv_tabHome!!.isSelected = true

        fragmentHome = FragmentHome()
        transaction!!.add(R.id.fragment_container, fragmentHome)
    }

    private fun setUnselected() {
        tv_tabHome!!.isSelected = false
        tv_tabPutOut!!.isSelected = false
        tv_tabShoppingCart!!.isSelected = false
        tv_tabSettings!!.isSelected = false
    }

    private fun hideAllFragment(transaction: FragmentTransaction?) {
        if (fragmentHome != null) {
            transaction!!.hide(fragmentHome)
        }
        if (fragmentPutOut != null) {
            transaction!!.hide(fragmentPutOut)
        }
        if (fragmentShoppingCart != null) {
            transaction!!.hide(fragmentShoppingCart)
        }
        if (fragmentMe != null) {
            transaction!!.hide(fragmentMe)
        }
    }

    override fun onClick(v: View) {
        transaction = fragmentManager.beginTransaction()
        hideAllFragment(transaction)

        when (v.id) {
            R.id.txt_home -> {
                setUnselected()
                tv_tabHome!!.isSelected = true

                if (fragmentHome == null) {
                    fragmentHome = FragmentHome()
                    transaction!!.add(R.id.fragment_container, fragmentHome)
                } else {
                    transaction!!.show(fragmentHome)
                }
            }
            R.id.txt_put_out -> {
                setUnselected()
                tv_tabPutOut!!.isSelected = true

                if (fragmentPutOut == null) {
                    fragmentPutOut = FragmentPutOut()
                    transaction!!.add(R.id.fragment_container, fragmentPutOut)
                } else {
                    transaction!!.show(fragmentPutOut)
                }
            }
            R.id.txt_shoppingcart -> {
                setUnselected()
                tv_tabShoppingCart!!.isSelected = true

                if (fragmentShoppingCart == null) {
                    fragmentShoppingCart = FragmentShoppingCart()
                    transaction!!.add(R.id.fragment_container, fragmentShoppingCart)
                } else {
                    transaction!!.show(fragmentShoppingCart)
                }
            }
            R.id.txt_me -> {
                setUnselected()
                tv_tabSettings!!.isSelected = true

                if (fragmentMe == null) {
                    fragmentMe = FragmentMe()
                    transaction!!.add(R.id.fragment_container, fragmentMe)
                } else {
                    transaction!!.show(fragmentMe)
                }
            }
        }

        transaction!!.commit()
    }
}