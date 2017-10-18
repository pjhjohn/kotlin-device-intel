package io.pjhjohn.kotlin.deviceintel

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.os.Build
import android.widget.RemoteViews
import com.jaredrummler.android.device.DeviceName


class DeviceIntelWidget : AppWidgetProvider() {

    override fun onUpdate(context: Context?, appWidgetManager: AppWidgetManager?, appWidgetIds: IntArray?) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)

        appWidgetIds?.forEach { id ->
            DeviceName.with(context).request { information, error ->
                val widget = RemoteViews(context?.packageName, R.layout.widget_deviceintel)

                widget.setTextViewText(R.id.android_version_release_value, Build.VERSION.RELEASE)
                widget.setTextViewText(R.id.android_version_sdk_value, Build.VERSION.SDK_INT.toString())
                widget.setTextViewText(R.id.device_info_brand_value, Build.BRAND.capitalize())
                if (BuildConfig.VERSION_CODE >= Build.VERSION_CODES.LOLLIPOP) {
                    widget.setTextViewText(R.id.device_info_supported_abis_value, Build.SUPPORTED_ABIS.joinToString("\n"))
                } else {
                    widget.setTextViewText(R.id.device_info_supported_abis_value, "#1 : ${Build.CPU_ABI}\n#2 : ${Build.CPU_ABI2}")
                }
                information?.apply {
                    widget.setTextViewText(R.id.device_info_manufacturer_value, manufacturer)
                    widget.setTextViewText(R.id.device_info_marketname_value, marketName)
                    widget.setTextViewText(R.id.device_info_model_value, model)
                    widget.setTextViewText(R.id.device_info_codename_value, codename)
                    appWidgetManager?.updateAppWidget(id, widget)
                }
                error?.apply {
                    printStackTrace()
                }
            }
        }
    }
}

