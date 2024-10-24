import { requireNativeModule } from "expo-modules-core";

import { AppEnvironment, ExpoAppEnviromentInterface } from "./ExpoAppEnviroment.types";

// Get the native module
const NativeModule = requireNativeModule("ExpoAppEnviroment");

export const ExpoAppEnviroment = {
  getEnvironment: (): AppEnvironment => NativeModule.getEnvironment(),
  environment: NativeModule.environment as AppEnvironment,
};

export default ExpoAppEnviroment;
