# Actividad 08-03-2022
## Ejercicio 1

Sobre una aplicación con entidades y asociaciones crearemos una capa de controladores REST:

* Crear al menos 2 controladores, cada uno para entidades diferentes (se puede reutilizar las entidades de proyectos anteriores)
* Cada controlador tratará de hacer las operaciones CRUD y a mayores se intentará realizar una operación de filtro o búsqueda: por ejemplo buscar manufacturers por año o empleados por rango de salario.
* Pruebas con Postman y guardar las peticiones: Exportar las peticiones de Postman y copiarlas al directorio raíz del proyecto.

### Postman:
```
{
   "info":{
      "_postman_id":"ab01c0bd-e025-48e6-beab-1f2d4fe09847",
      "name":"moviebook-imagina",
      "schema":"https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
   },
   "item":[
      {
         "name":"users",
         "request":{
            "method":"GET",
            "header":[
               
            ],
            "url":{
               "raw":"localhost:8080/user",
               "host":[
                  "localhost"
               ],
               "port":"8080",
               "path":[
                  "user"
               ]
            }
         },
         "response":[
            
         ]
      },
      {
         "name":"localhost:8080/user",
         "request":{
            "method":"POST",
            "header":[
               
            ],
            "body":{
               "mode":"raw",
               "raw":"{\r\n    \"nickname\": \"Jotxee\",\r\n    \"email\":  \"jotxee@mail.com\",\r\n    \"firstName\": \"Jose Alberto\",\r\n    \"lasName\": \"Lorenzo\",\r\n    \"registrationInformation\": {\r\n         \"ipInfo\": \"fake until add Security dependency\",\r\n         \"isReferred\": false\r\n    }\r\n}",
               "options":{
                  "raw":{
                     "language":"json"
                  }
               }
            },
            "url":{
               "raw":"localhost:8080/user",
               "host":[
                  "localhost"
               ],
               "port":"8080",
               "path":[
                  "user"
               ]
            }
         },
         "response":[
            
         ]
      },
      {
         "name":"localhost:8080/user/jotxee@mail.com",
         "request":{
            "method":"DELETE",
            "header":[
               
            ],
            "url":{
               "raw":"localhost:8080/user/jotxee@mail.com",
               "host":[
                  "localhost"
               ],
               "port":"8080",
               "path":[
                  "user",
                  "jotxee@mail.com"
               ]
            }
         },
         "response":[
            
         ]
      },
      {
         "name":"localhost:8080/user",
         "request":{
            "method":"PUT",
            "header":[
               
            ],
            "body":{
               "mode":"raw",
               "raw":"{\r\n    \"rol\": \"ADMIN\"\r\n}",
               "options":{
                  "raw":{
                     "language":"json"
                  }
               }
            },
            "url":{
               "raw":"localhost:8080/user/jotxee@mail.com",
               "host":[
                  "localhost"
               ],
               "port":"8080",
               "path":[
                  "user",
                  "jotxee@mail.com"
               ]
            }
         },
         "response":[
            
         ]
      },
      {
         "name":"films",
         "request":{
            "method":"GET",
            "header":[
               
            ],
            "url":{
               "raw":"localhost:8080/film",
               "host":[
                  "localhost"
               ],
               "port":"8080",
               "path":[
                  "film"
               ]
            }
         },
         "response":[
            
         ]
      },
      {
         "name":"localhost:8080/film",
         "request":{
            "method":"POST",
            "header":[
               
            ],
            "body":{
               "mode":"raw",
               "raw":"{\r\n    \"nameFilm\" : \"DeadPool\",\r\n    \"synopsis\" :\"Basado en el anti-héroe menos convencional de la Marvel, Deadpool narra el origen de un ex-operativo de la fuerzas especiales llamado Wade Wilson, reconvertido a mercenario, y que tras ser sometido a un cruel experimento adquiere poderes de curación rápida, adoptando Wade entonces el alter ego de Deadpool. Armado con sus nuevas habilidades y un oscuro y retorcido sentido del humor, Deadpool intentará dar caza al hombre que casi destruye su vida.\",\r\n    \"format\": \"PHYSICAL\",\r\n    \"country\" : \"Estados Unidos\",\r\n    \"duration\":\"105\",\r\n    \"rating\": 5,\r\n    \"purchasePrice\":10.2,\r\n    \"yearOfFilm\" :2016,\r\n    \"placeOfPurchase\" : \"unknown\",\r\n    \"producers\" : \"Marvel Entertainment, Marvel Studios, 20th Century Fox, Ryan Reynolds\",\r\n    \"roleDistribution\":\"Ryan Reynolds, Morena Baccarin, Ed Skrein, Gina Carano, T.J. Miller, Rachel Sheen, Brianna Hildebrand, Paul Lazenby, Sean Quan, Ben Wilkinson, Karan Soni, Naika Toussaint, Olesia Shewchuk, Kyle Cassie, Style Dayne, Fabiola Colmenero, Stan Lee\",\r\n    \"movieGroups\": \"X-Men | Deadpool\",\r\n    \"genders\": [\"Acción\", \"Fantástico\", \"Comedia\", \"Superhéroes\", \"Marvel Comics\", \"Cómic\", \"Venganza\"],\r\n    \"owner\": {\r\n         \"email\" :\"jotxee@mail.com\"\r\n    },\r\n    \"director\" : {\r\n        \"firstName\": \"Tim\",\r\n        \"lastName\" : \"Miller\"\r\n    }\r\n} ",
               "options":{
                  "raw":{
                     "language":"json"
                  }
               }
            },
            "url":{
               "raw":"localhost:8080/film",
               "host":[
                  "localhost"
               ],
               "port":"8080",
               "path":[
                  "film"
               ]
            }
         },
         "response":[
            
         ]
      },
      {
         "name":"localhost:8080/film/1",
         "request":{
            "method":"PUT",
            "header":[
               
            ],
            "body":{
               "mode":"raw",
               "raw":"{\r\n    \"nameFilm\" : \"DeadPool\",\r\n    \"synopsis\" :\"Basado en el anti-héroe menos convencional de la Marvel, Deadpool narra el origen de un ex-operativo de la fuerzas especiales llamado Wade Wilson, reconvertido a mercenario, y que tras ser sometido a un cruel experimento adquiere poderes de curación rápida, adoptando Wade entonces el alter ego de Deadpool. Armado con sus nuevas habilidades y un oscuro y retorcido sentido del humor, Deadpool intentará dar caza al hombre que casi destruye su vida.\",\r\n    \"format\": \"PHYSICAL\",\r\n    \"country\" : \"Francia\",\r\n    \"duration\":\"105\",\r\n    \"rating\": 5,\r\n    \"purchasePrice\":10.2,\r\n    \"yearOfFilm\" :2016,\r\n    \"placeOfPurchase\" : \"unknown\",\r\n    \"producers\" : \"Marvel Entertainment, Marvel Studios, 20th Century Fox, Ryan Reynolds\",\r\n    \"roleDistribution\":\"Ryan Reynolds, Morena Baccarin, Ed Skrein, Gina Carano, T.J. Miller, Rachel Sheen, Brianna Hildebrand, Paul Lazenby, Sean Quan, Ben Wilkinson, Karan Soni, Naika Toussaint, Olesia Shewchuk, Kyle Cassie, Style Dayne, Fabiola Colmenero, Stan Lee\",\r\n    \"movieGroups\": \"X-Men | Deadpool\",\r\n    \"genders\": [\"Acción\", \"Fantástico\", \"Comedia\", \"Superhéroes\", \"Marvel Comics\", \"Cómic\", \"Venganza\"],\r\n    \"owner\": {\r\n         \"email\" :\"jotxee@mail.com\"\r\n    },\r\n    \"director\" : {\r\n        \"firstName\": \"Tim\",\r\n        \"lastName\" : \"Miller\"\r\n    }\r\n} ",
               "options":{
                  "raw":{
                     "language":"json"
                  }
               }
            },
            "url":{
               "raw":"localhost:8080/film/1",
               "host":[
                  "localhost"
               ],
               "port":"8080",
               "path":[
                  "film",
                  "1"
               ]
            }
         },
         "response":[
            
         ]
      },
      {
         "name":"localhost:8080/film/1",
         "request":{
            "method":"DELETE",
            "header":[
               
            ],
            "url":{
               "raw":"localhost:8080/film/1",
               "host":[
                  "localhost"
               ],
               "port":"8080",
               "path":[
                  "film",
                  "1"
               ]
            }
         },
         "response":[
            
         ]
      }
   ]
}
```