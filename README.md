# expo-app-environment

A simple Expo module to detect how your app was installed - TestFlight, App Store, or Simulator.

## Installation

```bash
npx expo install expo-app-environment
```

## Usage

```tsx
import { getEnvironment } from "expo-app-environment";

// Returns: "simulator" | "testflight" | "appstore"
const environment = getEnvironment();
```

## Example
```tsx
import { getEnvironment } from 'expo-app-environment';
import { Text, View } from 'react-native';

export default function App() {
  return (
    <View>
      <Text>App was installed via: {getEnvironment()}</Text>
    </View>
  );
}
```
## Return Values

### `simulator`
- iOS: Running in iOS Simulator
- Android: Running in Android Emulator
- Web: Running on `localhost` or `127.0.0.1`

### `testflight`
- iOS: Installed via TestFlight
- Android: Installed via Internal Testing Track
- Web: N/A

### `appstore`
- iOS: Installed from App Store
- Android: Installed from Google Play Store
- Web: Running on any HTTPS domain

## Platform Support

- ✅ iOS
- ✅ Android 
- ✅ Web

## License

MIT
