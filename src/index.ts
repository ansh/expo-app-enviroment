import { requireNativeModule } from "expo-modules-core";

import { AppEnvironment } from "./ExpoAppEnviroment.types";

// Get the native module
const NativeModule = requireNativeModule("ExpoAppEnviroment");

export const getEnvironment = (): AppEnvironment => NativeModule.getEnvironment();
export const environment = NativeModule.environment as AppEnvironment;

export default { getEnvironment, environment };
