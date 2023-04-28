package com.example.appCoresRGB

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appfilmes.databinding.ActivityAddcorBinding
import com.example.appfilmes.model.Cor


class AddCorActivity : AppCompatActivity() {
    private val bindingCor: ActivityAddcorBinding by lazy { ActivityAddcorBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindingCor.root)
    }
}