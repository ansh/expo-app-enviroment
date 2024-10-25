import { AppEnvironment } from "./ExpoAppEnviroment.types";
import ExpoAppEnviromentModule from "./ExpoAppEnviromentModule";

// Get the native module

export const getEnvironment = (): AppEnvironment => ExpoAppEnviromentModule.getEnvironment();
export const environment = ExpoAppEnviromentModule.environment as AppEnvironment;

export default { getEnvironment, environment };
