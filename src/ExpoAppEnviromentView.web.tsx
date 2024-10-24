import * as React from 'react';

import { ExpoAppEnviromentViewProps } from './ExpoAppEnviroment.types';

export default function ExpoAppEnviromentView(props: ExpoAppEnviromentViewProps) {
  return (
    <div>
      <span>{props.name}</span>
    </div>
  );
}
