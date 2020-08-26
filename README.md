# 画像のピンチイン処理
Kotlinで実行しています

## CustomImageView
```
//Viewを継承してカスタムviewを作成する
class CustomImageView(context: Context,attrs:AttributeSet?):View(context, attrs) {
  ~~省略~~
}

```

## activity_main.xml
```
//layoutに作成したviewクラスを埋め込む
<com.kj_sample.pinchin.CustomImageView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/customView">
</com.kj_sample.pinchin.CustomImageView>

```

## MainActivity
```
//activityで画像をセットする
customView = findViewById(R.id.customView)
try {
       //assetsファイルにある画像ファイルを取得。ここのuseがわからなくてハマった,,,
       resources.assets.open(FILE_NAME).use {
           //ビットマップ作成
           val bitMap = BitmapFactory.decodeStream(it)
           //画像をviewに送る。
           customView.setBitMap(bitMap)
       }
   ~~省略~~

```

画像一つ表示するのに時間がかかってしまうの悔しいのう,,,
