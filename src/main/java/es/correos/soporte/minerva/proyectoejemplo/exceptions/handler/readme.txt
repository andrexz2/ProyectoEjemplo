paquete para la gestión de excepciones global de la aplicación. Se incluye el tratamiento de las excepciones
CORE y de aplicación. Si todas las excpeciones que se crean extienden, como se ha indicado, de 
excepciones CORE ya estarán tratadas aquí. Si se quiere afinar en el control de alguna excepción mas
específica, se puede añadir a la clase RestApiResponseEntityExceptionHandler un nuevo método para 
el tipo de excepción que se necesite.  