# Qué Me Pongo

Se utilizó la plantilla oficial de proyectos para Java y Maven.
  
Correcciones para la I.2  
- Implementar colores como una clase con atributos RGB, no como enum. Se quiere visualizar colores.  
- Agregar validaciones en constructores porque Constructores admiten NULL.  
- Implementar Categoria como ENUM  
  
Correcciones para la I.3
- El borradorPrenda de la ultima prenda no necesita ser tan estricto, puede haber muchas ultimas prendas.  
- Usar un builder para la prenda y hacer las verificaciones ahi. 
- No hay clase administrador. Estos serian usuarios con acceso a los metodos del servidor.  
---

La clase Servidor sería la encargada de procesar las solicitudes de los distintos clientes.  
    -Tendrá una lista de clientes verificados para hacer chequeos.  
    -A futuro podrian agregarse factores climaticos contemplados.   
    -Almacena los uniformes que se generan, haciendo de rol de **administrador**. Estos serian usuarios con acceso al servidor.  

Cada Usuario conoce sus prendas y los atuendos que se le generan.  
    -Por lo pronto, no implementa sensibilidades climaticas ni gustos sobre prendas  
    -Podrian agregarse datos personales que el servidor pueda usar para validar al usuario.

Los uniformes heredan de el Atuendo. "Son un tipo de atuendo".  

Por lo pronto, el atuendo solo tiene un atributo por clase de prenda, pues **no hay superposicion**.

![image](./class-diagrams/diagram-V2.1.png)