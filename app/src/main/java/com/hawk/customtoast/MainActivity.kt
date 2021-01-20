package com.hawk.customtoast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //btn_show_toast.setOnClickListener { showToast() }
        btn_show_success_toast.setOnClickListener { showToast(ToastType.TOAST_TYPE_SUCCESS, "Toast success") }
        btn_show_warning_toast.setOnClickListener { showToast(ToastType.TOAST_TYPE_WARNING, "Toast warning") }
        btn_show_error_toast.setOnClickListener { showToast(ToastType.TOAST_TYPE_ERROR, "Toast error") }
    }


    private fun showToast(toastType : ToastType, message : String){
        val toastView = layoutInflater.inflate(
            R.layout.toast_layout,
            findViewById(R.id.toastLayout)
        )

        val toastContainer = toastView.findViewById<LinearLayout>(R.id.toastLayout)
        val imageIcon = toastView.findViewById<ImageView>(R.id.imageIcon)
        val textMessage = toastView.findViewById<TextView>(R.id.toast_text)

        when(toastType){
            ToastType.TOAST_TYPE_SUCCESS -> {
                toastContainer.setBackgroundResource(R.drawable.toast_success_background)
                imageIcon.setImageResource(R.drawable.ic_toast_success)
                textMessage.text = message
            }
            ToastType.TOAST_TYPE_WARNING -> {
                toastContainer.setBackgroundResource(R.drawable.toast_warning_background)
                imageIcon.setImageResource(R.drawable.ic_toast_warning)
                textMessage.text = message
            }
            ToastType.TOAST_TYPE_ERROR -> {
                toastContainer.setBackgroundResource(R.drawable.toast_error_background)
                imageIcon.setImageResource(R.drawable.ic_toast_error)
                textMessage.text = message
            }
        }

        with(Toast(applicationContext)){
            duration = Toast.LENGTH_LONG
            view = toastView
            show()
        }
    }


}