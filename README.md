# Ejemplo Lista de la Compra con Jetpack Compose

Este es un ejemplo de una lista de la compra realizada con Jetpack Compose. 
La lista de la compra es una lista de elementos que se pueden añadir y eliminar. 
Cada elemento tiene un nombre y un checkbos para marcarlo como completado.

## El ejemplo contiene cuatro módulos:

- **app**: Contiene la aplicación de la lista de la compra.
Esta versión maneja el estado de la lista de la compra con un ViewModel. 
En esta versión metemos todo el estado en un mismo modelo de datos de UI.

- **sin_view_model**: Contiene la aplicación de la lista de la compra sin ViewModel.
Esta versión maneja el estado de la lista de la compra con un State en el composable.
En concreto en esta versión tratamos la lista con mutableStateOf.

- **sin_view_model_v2**: Contiene la aplicación de la lista de la compra sin ViewModel.
Esta versión maneja el estado de la lista de la compra con un State en el composable.
En concreto en esta versión tratamos la lista con mutableStateListOf.

- **view_model_hibrido**: Contiene la aplicación de la lista de la compra con ViewModel.
Esta versión maneja el estado de la lista de la compra con un ViewModel.
En esta versión metemos el estado de la lista de la compra en un modelo de datos de UI pero sin la lista.
Tratamos la lista por separado dentro del ViewModel pero no del modelo del estado para poder acceder a ella directamente y no tener que machacar el estado entero.

## Otros detalles de interés 

El datasource inicial de la lista de la compra son datos en crudo en un archivo en el package `data`.

El modelo de datos del producto de la lista de la compra se encuentra en el package `model`.
En esta misma clase definimos una función para recoger los productos de prueba del datasource.

El package `ui` contiene los componibles de la lista de la compra.
Está dividido en varios paquetes:
- `theme`: Contiene los colores y dimensiones de la aplicación.
- `screen`: Contiene los componibles de las pantallas de la aplicación.
- `state`: Contiene las clases que manejan el estado de la lista de la compra (en los casos con ViewModel).

En el state de los casos con ViewModel se está utilizando MVVM con un ViewModel y un data class para representar el estado de la lista de la compra.