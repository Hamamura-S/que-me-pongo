# Qué Me Pongo

Se utilizó la plantilla oficial de proyectos para Java y Maven.
  
Correcciones para la I.2  
- Implementar colores como una clase con atributos RGB, no como enum. Se quiere visualizar colores.  
- Agregar validaciones en constructores porque Constructores admiten NULL.  
- Implementar Categoria como ENUM  
  
Correcciones para la I.3
- El borrador de la ultima prenda no necesita ser tan estricto, puede haber muchas ultimas prendas.
- Usar un builder para la prenda y hacer las verificaciones ahi. 
---

La clase Servidor sería la encargada de procesar las solicitudes de los distintos clientes.  
    -Tendrá una lista de clientes verificados para hacer chequeos.  
    -A futuro podrian agregarse factores climaticos contemplados.   
    -Por lo pronto, no necesita almacenar los atuendos que genera.  

Cada Usuario conoce sus prendas y los atuendos que se le generan.  
    -Por lo pronto, no implementa sensibilidades climaticas ni gustos sobre prendas  
    -Podrian agregarse datos personales que el servidor pueda usar para validar al usuario.  
    -El administrador hereda del usuario para crear uniformes. El uniforme hereda del atuendo.

La prenda es compuesta por TipoPrenda