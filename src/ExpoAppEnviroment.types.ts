export type AppEnvironment = "simulator" | "testflight" | "appstore";

export interface ExpoAppEnviromentInterface {
  readonly environment: AppEnvironment;
  getEnvironment(): AppEnvironment;
}
