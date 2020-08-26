package com.kj_sample.pinchin

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.lang.Exception


class MainActivity : AppCompatActivity() {
    private lateinit var  customView : CustomImageView
    companion object{
        val FILE_NAME = "test.jpg"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //layoutに埋め込んだCustomViewを取得
        customView = findViewById(R.id.customView)
       try {
           //assetsファイルにある画像ファイルを取得。ここのuseがわからなくてハマった,,,
           resources.assets.open(FILE_NAME).use {
               //ビットマップ作成
               val bitMap = BitmapFactory.decodeStream(it)
               //画像をviewに送る。
               customView.setBitMap(bitMap)
           }
       }catch (e:Exception){
           Log.d("[テスト]","取得失敗")
       }
       //customView.setBitMap()

    }
}