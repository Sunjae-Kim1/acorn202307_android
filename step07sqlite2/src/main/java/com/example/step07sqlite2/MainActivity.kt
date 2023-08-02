package com.example.step07sqlite2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import com.example.step07sqlite2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , OnClickListener { // extends AppCompatActivity

    // View Binding 객체를 저장할 필드
    lateinit var binding: ActivityMainBinding
    // var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // getLayoutInflater() 대신에 LayoutInflater 라고 작성하면 된다.
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Layout 구성
        setContentView(binding.root)

        // Button 에 Listener 등록
        binding.sendBtn.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        // 입력한 문자열을 읽어와서 .getText() 대신에 .text
        val msg = binding.inputMsg.text.toString()

        // Toast 에 띄우기
        Toast.makeText(this , msg , Toast.LENGTH_SHORT).show()
    }
}