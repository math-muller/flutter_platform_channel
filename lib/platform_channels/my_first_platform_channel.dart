import 'package:flutter/services.dart';

class MyFirstPlatformChannel {
  final MethodChannel _methodChannel = const MethodChannel(
    "app.muller/platform_channel",
  );

  Future<void> version() async {
    try {
      final result = await _methodChannel.invokeMethod("version");
      print(result);
    } catch (e) {
      print("error $e");
    }
  }
}
