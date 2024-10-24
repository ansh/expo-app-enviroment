import { NativeModulesProxy, EventEmitter, Subscription } from 'expo-modules-core';

// Import the native module. On web, it will be resolved to ExpoAppEnviroment.web.ts
// and on native platforms to ExpoAppEnviroment.ts
import ExpoAppEnviromentModule from './ExpoAppEnviromentModule';
import ExpoAppEnviromentView from './ExpoAppEnviromentView';
import { ChangeEventPayload, ExpoAppEnviromentViewProps } from './ExpoAppEnviroment.types';

// Get the native constant value.
export const PI = ExpoAppEnviromentModule.PI;

export function hello(): string {
  return ExpoAppEnviromentModule.hello();
}

export async function setValueAsync(value: string) {
  return await ExpoAppEnviromentModule.setValueAsync(value);
}

const emitter = new EventEmitter(ExpoAppEnviromentModule ?? NativeModulesProxy.ExpoAppEnviroment);

export function addChangeListener(listener: (event: ChangeEventPayload) => void): Subscription {
  return emitter.addListener<ChangeEventPayload>('onChange', listener);
}

export { ExpoAppEnviromentView, ExpoAppEnviromentViewProps, ChangeEventPayload };
