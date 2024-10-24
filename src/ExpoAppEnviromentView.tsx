import { requireNativeViewManager } from 'expo-modules-core';
import * as React from 'react';

import { ExpoAppEnviromentViewProps } from './ExpoAppEnviroment.types';

const NativeView: React.ComponentType<ExpoAppEnviromentViewProps> =
  requireNativeViewManager('ExpoAppEnviroment');

export default function ExpoAppEnviromentView(props: ExpoAppEnviromentViewProps) {
  return <NativeView {...props} />;
}
