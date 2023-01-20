# BackInventario

Se realiza solución Backend para el manejo de inventario y compra de productos.

* La información de este proyecto se almaceno en la base de datos MongoDbB el nombre de la base datos que se le asignó a este proyecto es : inventario 

![image](https://user-images.githubusercontent.com/88283220/213820361-7c0a28fa-b2c6-40a4-b663-9261150a33e3.png)

Se crearon cada uno de los paquetes por capas 

# Domain 
en la cual se crearon los modelos.

# Application 
Se crearon los casos de uso y es esta la capa principal del proyecto es donde se encuentra almacenada la lógica del proyecto, también se almacenaron los mapper los cuales nos permite la comunicación entre capas sin afectar la independencia de las mismas.

Para la transacción de compra se tuvieron en cuenta las siguientes validaciones:
validación de disponibilidad
validación de mínimos y máximos
validación de activo o inactivo  

# Infraestructura 
Se crearon los controladores, dto, services, repository & collections

![image](https://user-images.githubusercontent.com/88283220/213821060-b632d1ab-1403-465f-9559-50427aab0256.png)

Para realizar las pruebas se hizo uso de Postman, la colección del mismo se entra dentro del proyecto en una carpeta que se llama collection Postman

![image](https://user-images.githubusercontent.com/88283220/213821283-0bbc2443-6235-47b2-8742-767ac5413bdf.png)

El proyecto se documenta en Swagger 
http://localhost:8080/swagger-ui/index.html#/

![image](https://user-images.githubusercontent.com/88283220/213822506-904fe240-1a68-468d-a8ad-bbbad162b96e.png)


#faltas

Pruebas Unitarias 

control de excepciones 
