# KotlinAndroidDemo
使用Kotlin+Anko开发Android的Demo

# 演示


# 依赖
### 项目的build.gradle文件中加入：
```
buildscript {
    ext.kotlin_version = '1.1.2-4'
    ext.anko_version = '0.9.1a'
    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:2.3.3'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
        classpath "org.jetbrains.kotlin:kotlin-android-extensions:$kotlin_version"

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}
```
### app中的build.gradle中加入：
```
apply plugin:'kotlin-android'
apply plugin:'kotlin-android-extensions'
compile "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
compile "org.jetbrains.anko:anko-common:$anko_version"
```

# Kotlin+Anko的优势：
### 布局文件中的控件id直接在Activity中当做控件使用
布局文件如下：
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context="com.example.testkotlinandroid.MainActivity">

    <TextView
        android:id="@+id/userText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/testBtn"
        android:text="test"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

    <EditText
        android:id="@+id/nameEditText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

</LinearLayout>
```
Activity代码如下：
```
package com.example.testkotlinandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userText.text = "Hello Kotlin!!!"

        testBtn.setOnClickListener {
            var name: String = nameEditText.text.toString()
            if (name.isNotBlank()) {
                toast(name)
            } else {
                toast("please input name")
            }
        }
    }
}

```
