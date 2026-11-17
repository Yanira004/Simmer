import { useEffect, useState } from 'react';
import { StyleSheet, Text, View, FlatList } from 'react-native';

export default function App() {
  const [ingredients, setIngredients] = useState([]);

  useEffect(() => {
    // Aici facem fetch către backend-ul tău de Spring Boot
    fetch('http://192.168.1.130:8080/api/ingredients')
      .then(response => response.json())
      .then(data => setIngredients(data))
      .catch(error => console.error("Eroare la fetch:", error));
  }, []);

  return (
    <View style={styles.container}>
      <Text style={styles.title}>Ingrediente din Baza de Date:</Text>
      
      <FlatList
        data={ingredients}
        keyExtractor={(item) => item.id.toString()}
        renderItem={({ item }) => (
          <View style={styles.itemBox}>
            <Text style={styles.itemName}>{item.name}</Text>
            <Text style={styles.itemCalories}>Calorii: {item.calories} kcal</Text>
          </View>
        )}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    padding: 20,
    paddingTop: 60, // Protejează conținutul să nu intre sub status bar-ul telefonului
  },
  title: {
    fontSize: 24,
    fontWeight: 'bold',
    marginBottom: 20,
    color: '#333',
  },
  itemBox: {
    padding: 15,
    backgroundColor: '#f8f9fa',
    marginBottom: 12,
    borderRadius: 10,
    borderWidth: 1,
    borderColor: '#e9ecef',
  },
  itemName: {
    fontSize: 18,
    fontWeight: '600',
    color: '#212529',
  },
  itemCalories: {
    fontSize: 14,
    color: '#6c757d',
    marginTop: 4,
  }
});