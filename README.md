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

- `simulator` - App is running in iOS Simulator or Android Emulator
- `testflight` - App was installed via TestFlight (iOS) or Internal Testing Track (Android)
- `appstore` - App was installed from App Store or Google Play Store

## Platform Support

- ✅ iOS
- ✅ Android 
- ❌ Web



## License

MIT