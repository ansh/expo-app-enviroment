package expo.modules.appenviroment

import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import android.content.pm.ApplicationInfo

class ExpoAppEnviromentModule : Module() {
  // Each module class must implement the definition function. The definition consists of components
  // that describes the module's functionality and behavior.
  // See https://docs.expo.dev/modules/module-api for more details about available components.
  override fun definition() = ModuleDefinition {
    // Sets the name of the module that JavaScript code will use to refer to the module. Takes a string as an argument.
    // Can be inferred from module's class name, but it's recommended to set it explicitly for clarity.
    // The module will be accessible from `requireNativeModule('ExpoAppEnviroment')` in JavaScript.
    Name("ExpoAppEnviroment")

    // Define constants for environment types
    Constants(
      "environment" to getCurrentEnvironment()
    )

    // Provide a function to check environment with explicit String return type
    Function("getEnvironment") { -> String in
      getCurrentEnvironment()
    }
  }

  private fun getCurrentEnvironment(): String {
    val context = appContext.reactContext?.applicationContext
    if (context == null) {
      return "unknown"
    }

    // Check if running in an emulator
    if (isEmulator()) {
      return "simulator"
    }

    // Check if app is installed from Play Store
    val installerPackageName = context.packageManager.getInstallerPackageName(context.packageName)
    
    return when {
      // Google Play Store package name
      installerPackageName == "com.android.vending" -> "appstore"
      // Internal testing track or beta testing
      (context.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE) != 0 -> "testflight"
      // Default case
      else -> "appstore"
    }
  }

  private fun isEmulator(): Boolean {
    return (android.os.Build.BRAND?.startsWith("generic") == true && android.os.Build.DEVICE?.startsWith("generic") == true)
            || android.os.Build.FINGERPRINT?.startsWith("generic") == true
            || android.os.Build.FINGERPRINT?.startsWith("unknown") == true
            || android.os.Build.HARDWARE?.contains("goldfish") == true
            || android.os.Build.HARDWARE?.contains("ranchu") == true
            || android.os.Build.MODEL?.contains("google_sdk") == true
            || android.os.Build.MODEL?.contains("Emulator") == true
            || android.os.Build.MODEL?.contains("Android SDK built for x86") == true
            || android.os.Build.MANUFACTURER?.contains("Genymotion") == true
            || android.os.Build.PRODUCT?.contains("sdk_gphone") == true
            || android.os.Build.PRODUCT?.contains("google_sdk") == true
            || android.os.Build.PRODUCT?.contains("sdk") == true
            || android.os.Build.PRODUCT?.contains("sdk_x86") == true
            || android.os.Build.PRODUCT?.contains("vbox86p") == true
            || android.os.Build.PRODUCT?.contains("emulator") == true
            || android.os.Build.PRODUCT?.contains("simulator") == true
  }
}
