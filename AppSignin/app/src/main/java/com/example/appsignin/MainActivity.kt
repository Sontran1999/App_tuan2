package com.example.appsignin

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
//    View.OnClickListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txt_signup= findViewById(R.id.txt_signup) as TextView
        val validateEmail: String= "[a-zA-Z0-9]+@[a-z]+.[a-z]+"
        val validatePass: String= "[a-zA-Z0-9]{0,18}"

        val ac: ActionBar? = supportActionBar
        if (ac != null) {
            ac.hide()
        }



        txt_signup.setOnClickListener{
            val intent: Intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }



            edt_pass.addTextChangedListener(object: TextWatcher {
                override fun afterTextChanged(p0: Editable?) {
                    val content = edt_pass?.text.toString()
                    edt_pass?.error = if (content.length <18 ) null else "Không được vượt quá 18 ký tự"
                }

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

            })


          btn_signin.setOnClickListener {
              val edt_email = findViewById(R.id.edt_email) as EditText
              val edt_pass = findViewById(R.id.edt_pass) as EditText
              val pass: String = edt_pass.text.toString()
              val email: String = edt_email.text.toString()

              if (email.isEmpty()) {
                  edt_email.error = "Email không được để trông"
              }
              else if(!email.matches(validateEmail.toRegex())){
                  edt_email.error = "Email sai"
              }
              else if(pass.isEmpty()){
                  edt_pass.error ="Password không được để trống"
              }
              else if(!pass.matches(validatePass.toRegex()))
              {
                  edt_pass.error="Password không được vượt quá 18 ký tự"
              }
              else{
                  val intent: Intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
              }
          }
    }

//    fun checkEmail(): Boolean {
//        var btn_signin = findViewById(R.id.btn_signin) as Button
//        var edt_email = findViewById(R.id.edt_email) as EditText
//        var edt_pass = findViewById(R.id.edt_pass) as EditText
//        var email: String = edt_email.text.toString()
//        var pass: String = edt_pass.text.toString()
//
//            if (email.isEmpty()) {
//                edt_email.error = "Email không được để trông"
//                return false
//            }
//            else{
//                edt_email.error= null
//                return true
//            }
//
//    }
//    override fun onClick(view: View?) {
//    // sử dụng cho nhiều button
//        if(!checkEmail()){
//            return
//        }
//        else{
//            val intent: Intent = Intent(this, HomeActivity::class.java)
//            startActivity(intent)
//        }

//         if(view?.id == R.id.btn_signin){
//            val intent: Intent = Intent(this, HomeActivity::class.java)
//            startActivity(intent)
//        }
//    }
}
