import ExpoModulesCore

public class ExpoAppEnviromentModule: Module {
  public func definition() -> ModuleDefinition {
    Name("ExpoAppEnviroment")

    // Define constants for environment types
    Constants([
      "environment": self.getCurrentEnvironment()
    ])

    // Provide a function to check environment
    Function("getEnvironment") { () -> String in
      return self.getCurrentEnvironment()
    }
  }

  private func getCurrentEnvironment() -> String {
    #if targetEnvironment(simulator)
      return "simulator"
    #else
      if Bundle.main.appStoreReceiptURL?.lastPathComponent == "sandboxReceipt" {
        return "testflight"
      } else if Bundle.main.appStoreReceiptURL?.path.contains("CoreSimulator") == true {
        return "simulator"
      } else {
        return "appstore"
      }
    #endif
  }
}
