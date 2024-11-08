package expo.modules.appenviroment

import android.content.pm.ApplicationInfo
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition

class ExpoAppEnviromentModule : Module() {
    override fun definition() = ModuleDefinition {
        Name("ExpoAppEnviroment")

        // Match iOS by providing both constant and function
        Constants(
            "environment" to getCurrentEnvironment()
        )
        
        Function("getEnvironment") {
            return@Function getCurrentEnvironment()
        }
    }

    private fun getCurrentEnvironment(): String {
        val context = appContext.reactContext?.applicationContext ?: return "unknown"

        // Check if running in emulator
        if (isEmulator()) {
            return "simulator"
        }

        // Check if installed from Play Store
        val installerPackageName = context.packageManager.getInstallerPackageName(context.packageName)
        
        return when {
            installerPackageName == "com.android.vending" -> "appstore"
            (context.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE) != 0 -> "testflight"
            else -> "appstore"
        }
    }

    private fun isEmulator(): Boolean {
        return (android.os.Build.BRAND.startsWith("generic") && android.os.Build.DEVICE.startsWith("generic"))
            || android.os.Build.FINGERPRINT.startsWith("generic")
            || android.os.Build.FINGERPRINT.startsWith("unknown")
            || android.os.Build.HARDWARE.contains("goldfish")
            || android.os.Build.HARDWARE.contains("ranchu")
            || android.os.Build.MODEL.contains("google_sdk")
            || android.os.Build.MODEL.contains("Emulator")
            || android.os.Build.MODEL.contains("Android SDK built for x86")
            || android.os.Build.MANUFACTURER.contains("Genymotion")
            || android.os.Build.PRODUCT.contains("sdk_google")
            || android.os.Build.PRODUCT.contains("google_sdk")
            || android.os.Build.PRODUCT.contains("sdk")
            || android.os.Build.PRODUCT.contains("sdk_x86")
            || android.os.Build.PRODUCT.contains("vbox86p")
            || android.os.Build.PRODUCT.contains("emulator")
            || android.os.Build.PRODUCT.contains("simulator")
    }
}
