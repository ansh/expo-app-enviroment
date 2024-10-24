import { StyleSheet, Text, View } from 'react-native';

import * as ExpoAppEnviroment from 'expo-app-enviroment';

export default function App() {
  return (
    <View style={styles.container}>
      <Text>{ExpoAppEnviroment.hello()}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
