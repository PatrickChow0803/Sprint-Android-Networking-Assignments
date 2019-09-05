package com.patrickchow.httpoperations

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_get_picker.*

class GetPickerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_picker)

        btn_get_call.setOnClickListener {
            val intent = Intent(this@GetPickerActivity, GetActivity::class.java)
            intent.putExtra("get", "simple")
            startActivity(intent)
        }

        btn_get_call_path.setOnClickListener {
            val intent = Intent(this@GetPickerActivity, GetActivity::class.java)
            intent.putExtra("get", "path")
            startActivity(intent)
        }

        btn_get_call_query.setOnClickListener {
            val intent = Intent(this@GetPickerActivity, GetActivity::class.java)
            intent.putExtra("get", "query")
            startActivity(intent)
        }
    }
}