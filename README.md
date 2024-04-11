# Qué Me Pongo

Se utilizó la plantilla oficial de proyectos para Java y Maven.

---

La clase Servidor sería la encargada de procesar las solicitudes de los distintos clientes.  
    -Tendrá una lista de clientes verificados para hacer chequeos.  
    -A futuro podrian agregarse factores climaticos contemplados.  
    -Los requisitos funcionales se resolverán principalmente a partir de esta clase.  
    -Por lo pronto, no necesita almacenar los atuendos que genera.  

Cada Usuario conoce sus prendas y los atuendos que se le generan.  
    -Por lo pronto, no implementa sensibilidades climaticas ni gustos sobre prendas  
    -Podrian agregarse datos personales que el servidor pueda usar para validar al usuario.  

La clase Prenda es ABSTRACTA y cada implementación está en la carpeta **categorias**.  
    -Si se quiere agregar un reloj, se deberá instanciar la clase Accesorio. Además,
    se seleccionará el ENUM RELOJ como atributo de la instancia de accesorio.  
    -Si se requiere mayor complejidad de parte de los tipos de accesorio, se les puede 
    agregar un comportamiento y atributos.  
    -Hay un tipo de ENUM por cada categoría. Asi se obliga a que el tipo se corresponda
    con la categoría. Se consideraron otras formas como un solo tipo de ENUM unificado  
    pero requiere de otra clase que se encargue de verificar activamente que el tipo
    corresponda con la categoría.