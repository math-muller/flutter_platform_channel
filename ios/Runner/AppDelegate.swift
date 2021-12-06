import UIKit
import Flutter

@UIApplicationMain
@objc class AppDelegate: FlutterAppDelegate {
  override func application(
    _ application: UIApplication,
    didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?
  ) -> Bool {
    GeneratedPluginRegistrant.register(with: self)
      
    let controller: FlutterViewController = window?.rootViewController as! FlutterViewController
    let methodChannel = FlutterMethodChannel(
        name: "app.muller/platform_channel",
        binaryMessenger: controller.binaryMessenger
    )
      
    methodChannel.setMethodCallHandler({(call: FlutterMethodCall, result: FlutterResult) -> Void in
        switch call.method {
        case "version":
            let data: [String: Any] = call.arguments as! [String: Any]
            let name: String = data["name"] as! String
            let lastName: String = data["lastName"] as! String
            let age: Int = data["age"] as! Int
            
            print("Nome: \(name)")
            print("Sobrenome: \(lastName)")
            print("Idade: \(age)")
            
            let version = UIDevice().systemVersion
            result("IOS \(version)")
        default:
            result(FlutterMethodNotImplemented)
        }
    })
      
    return super.application(application, didFinishLaunchingWithOptions: launchOptions)
  }
}
