Suponer una aplicación a la cual se ingresa con usuario y contraseña.

A los usuarios se les asigna un rol cuando se crean, con diferentes permisos para acceder a las varias partes de la aplicación (por ahora y para facilitar las cosas, asumir que hay un solo rol para todos los usuarios).

También, para cada usuario que ingresa, habría que cargar algún tipo de “configuración” (cantidad de resultados por página al momento de mostrar listados en pantalla, información de localización como formatos de fecha, formatos de dinero, etc.).

La configuración se carga desde un archivo, y el perfil del usuario desde la base de datos. 
Estas dos operaciones son claramente costosas en procesamiento y tiempo, y no sería ideal que se realicen cada vez que un usuario ingresa al sistema.

Entonces, en vez de ir a buscar configuración y perfil, es posible “clonarlos” desde un modelo, y así tener los datos de forma más eficiente. Es obvio que la primera vez, cuando se cargue la información a los prototipos, se tendrá que afrontar el costo de tiempo y procesamiento, pero después éste debería resultar despreciable (se podría hacer al momento que la aplicación levanta, y no cuando ingresa el primer usuario…).

A continuación hay un ejemplo de código funcionando que muestra cuánto tarda una inicialización de recursos contra lo que tarda la clonación. También se incluye un ejemplo simple de Bloch Builder