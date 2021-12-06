package com.example.platform_channels

import android.os.Build
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
                    val version: String = getAndroidVersion()
                    result.success(version)
                }
                else -> {
                    result.notImplemented()
                }
            }
        }

    }

    fun getAndroidVersion(): String {
        val sdkVersion: Int = Build.VERSION.SDK_INT
        val release: String = Build.VERSION.RELEASE

        return "Android version: $sdkVersion ($release)"
    }
}
