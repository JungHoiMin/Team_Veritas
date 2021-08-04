package kr.co.veritas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btnSignUp.setOnClickListener {
            Toast.makeText(this,"${etID.text}님 가입이 완료되었습니다.",Toast.LENGTH_SHORT).show()
            finish()
        }
        btnCancel.setOnClickListener {
            finish()
        }
    }
}