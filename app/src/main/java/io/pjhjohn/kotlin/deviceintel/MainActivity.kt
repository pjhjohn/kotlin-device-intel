package io.pjhjohn.kotlin.deviceintel

import android.app.Activity
import android.os.Build
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        device_release_version.text = "Android ${Build.VERSION.RELEASE}"
        device_sdk_version.text = "API ${Build.VERSION.SDK_INT}"
        device_brand.text = Build.BRAND.capitalize()
        device_model.text = Build.MODEL
    }
}
