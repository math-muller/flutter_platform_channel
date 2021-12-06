import 'package:flutter/material.dart';
import 'package:platform_channels/platform_channels/my_first_platform_channel.dart';

class HomePage extends StatelessWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: TextButton(
          child: const Text('GET VERSION'),
          onPressed: () {
            MyFirstPlatformChannel _platformChannel = MyFirstPlatformChannel();

            _platformChannel.version();
          },
        ),
      ),
    );
  }
}
