package io.pjhjohn.kotlin.deviceintel

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import com.jaredrummler.android.device.DeviceName
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : Activity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DeviceName.with(this).request { information, error ->
            android_version_release_value.text = Build.VERSION.RELEASE
            android_version_sdk_value.text = Build.VERSION.SDK_INT.toString()
            device_info_brand_value.text = Build.BRAND.capitalize()
            if (BuildConfig.VERSION_CODE >= Build.VERSION_CODES.LOLLIPOP) {
                device_info_supported_abis_value.text = Build.SUPPORTED_ABIS.joinToString("\n")
                device_info_supported_64bit_abis_value.text = Build.SUPPORTED_64_BIT_ABIS.joinToString("\n")
                device_info_supported_32bit_abis_value.text = Build.SUPPORTED_32_BIT_ABIS.joinToString("\n")
            } else {
                device_info_supported_abis_value.text = "#1 : ${Build.CPU_ABI}\n#2 : ${Build.CPU_ABI2}"
            }
            information?.apply {
                device_info_manufacturer_value.text = manufacturer
                device_info_marketname_value.text = marketName
                device_info_model_value.text = model
                device_info_codename_value.text = codename
            }
            error?.apply {
                printStackTrace()
            }
        }

        android_device_names.setOnClickListener { view ->
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(getString(R.string.android_device_names_url))
            startActivity(intent)
        }
    }
}
