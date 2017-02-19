package io.pjhjohn.kotlin.deviceintel

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.os.Build
import android.widget.RemoteViews


class DeviceIntelWidget : AppWidgetProvider() {

    override fun onUpdate(context: Context?, appWidgetManager: AppWidgetManager?, appWidgetIds: IntArray?) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)
        for (appWidgetId in appWidgetIds!!) {
            val remoteViews = RemoteViews(context!!.packageName, R.layout.activity_main)
            remoteViews.setTextViewText(R.id.device_release_version, "Android ${Build.VERSION.RELEASE}")
            remoteViews.setTextViewText(R.id.device_sdk_version, "API ${Build.VERSION.SDK_INT}")
            remoteViews.setTextViewText(R.id.device_brand, Build.BRAND.toUpperCase())
            remoteViews.setTextViewText(R.id.device_model, Build.MODEL)
            appWidgetManager!!.updateAppWidget(appWidgetId, remoteViews)
        }
    }
}

