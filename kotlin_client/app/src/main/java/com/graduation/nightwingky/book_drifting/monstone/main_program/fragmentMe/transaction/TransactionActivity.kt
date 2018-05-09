package com.graduation.nightwingky.book_drifting.monstone.main_program.fragmentMe.transaction

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import com.graduation.nightwingky.book_drifting.R
import com.graduation.nightwingky.book_drifting.monstone.myConst.URLConst

class TransactionActivity : AppCompatActivity() {

    private var tv_identity: TextView? = null

    private var btn_finish: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)

        tv_identity = findViewById<View>(R.id.tv_transaction_identity) as TextView
        btn_finish = findViewById<View>(R.id.btn_finish_transaction) as Button

        btn_finish!!.setOnClickListener {
            Toast.makeText(this@TransactionActivity, "交易完成", Toast.LENGTH_SHORT).show()
            finish()
        }

        if (URLConst.queky1024_id == URLConst.user_id) {
            tv_identity!!.text = "买家"
        } else {
            tv_identity!!.text = "卖家"
        }
    }
}
