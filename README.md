# Ejemplo Lista de la Compra con Jetpack Compose

Este es un ejemplo de una lista de la compra realizada con Jetpack Compose. 
La lista de la compra es una lista de elementos que se pueden añadir y eliminar. 
Cada elemento tiene un nombre y un checkbos para marcarlo como completado.

## El ejemplo contiene dos módulos:

- **app**: Contiene la aplicación de la lista de la compra.
Esta versión maneja el estado de la lista de la compra con un ViewModel.

- **sin_view_model**: Contiene la aplicación de la lista de la compra sin ViewModel.
Esta versión maneja el estado de la lista de la compra con un State en el composable.

## Otros detalles de interés 

El datasource inicial de la lista de la compra son datos en crudo en un archivo en el package `data`.

El modelo de datos del producto de la lista de la compra se encuentra en el package `model`.
En esta misma clase definimos una función para recoger los productos de prueba del datasource.

El package `ui` contiene los componibles de la lista de la compra.
Está dividido en varios paquetes:
- `theme`: Contiene los colores y dimensiones de la aplicación.
- `screen`: Contiene los componibles de las pantallas de la aplicación.
- `state`: Contiene los componibles que manejan el estado de la lista de la compra (en el caso con ViewModel).

En el state del caso con ViewModel se está utilizando MVVM con un ViewModel y un data class para representar el estado de la lista de la compra.