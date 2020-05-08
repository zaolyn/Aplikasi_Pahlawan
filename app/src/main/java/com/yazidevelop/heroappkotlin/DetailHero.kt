package com.yazidevelop.heroappkotlin

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.yazidevelop.heroappkotlin.databinding.DetailHeroBinding
import kotlinx.android.synthetic.main.detail_hero.*

class DetailHero:AppCompatActivity() {
    lateinit var binding: DetailHeroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState )
        binding = DataBindingUtil.setContentView(this,R.layout.detail_hero)

        heroname.text = getIntent().getStringExtra("HERONAME")
        herodetail.text = getIntent().getStringExtra("HERODETAIL")
        imghero.setImageResource(getIntent().getStringExtra("IMGHERO").toInt())
    }
}