package com.example.widgetttt

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import androidx.fragment.app.viewModels
import com.example.widgetttt.data.local.dao.WeatherDao
import com.example.widgetttt.screen.WeatherViewModel
import com.example.widgetttt.screen.WeatherViewModelImpl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Implementation of App Widget functionality.
 */
class NewAppWidget : AppWidgetProvider() {


    @Inject
    lateinit var dao: WeatherDao
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray,
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId,dao)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int,
    dao: WeatherDao
) {
    var widgetText1 = ""
    GlobalScope.launch {
        val weather = dao.getWeather()
        widgetText1 = weather[0].city
    }
    val widgetText = "aah"

    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.new_app_widget)
    views.setTextViewText(R.id.nameCity, widgetText1)

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}