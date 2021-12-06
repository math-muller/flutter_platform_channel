package com.example.platform_channels

import android.os.Build
import android.util.Log
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        val messenger = flutterEngine.dartExecutor.binaryMessenger
        val methodChannel = MethodChannel(messenger, "app.muller/platform_channel")

        methodChannel.setMethodCallHandler { call, result ->
            when (call.method) {
                 "version" -> {

                     val name = call.argument<String>("name")
                     val age = call.argument<Int>("agea")

                     Log.i("FLUTTER", "Nome: $name")
                     Log.i("FLUTTER", "Idade: $age")



                    val version: String = getAndroidVersion()
                    result.success(version)
                }
                else -> {
                    result.notImplemented()
                }
            }
        }

    }

     private fun getAndroidVersion(): String {
        val sdkVersion: Int = Build.VERSION.SDK_INT
        val release: String = Build.VERSION.RELEASE

        return "Android version: $sdkVersion ($release)"
    }
}
