import { requireNativeModule } from "expo-modules-core";

import { AppEnvironment, ExpoAppEnviromentInterface } from "./ExpoAppEnviroment.types";

// Get the native module
const ExpoAppEnviroment: ExpoAppEnviromentInterface = requireNativeModule("ExpoAppEnviroment");

// Export the module as default and named export
export { ExpoAppEnviroment };
export default ExpoAppEnviroment;
