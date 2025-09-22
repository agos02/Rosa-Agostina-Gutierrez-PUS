const prompt = require('prompt-sync')(); //Importa la librería 'prompt-sync' para poder recibir entrada de datos del usuario desde la consola.

let titulos = new Array(10); // Declara un array llamado 'titulos' con un tamaño fijo de 10, para almacenar los títulos de las tareas.
let descripciones = new Array(10); 
let estados = new Array(10);
let fechasCreacion = new Array(10);
let fechasVencimiento = new Array(10);
let dificultades = new Array(10);

let numTareas = 0; //Inicializa un contador que lleva la cuenta de cuántas tareas se han agregado al sistema.
let opcion; //Declara una variable para almacenar la opción que el usuario elija en el menú principal.

/*El bucle 'do-while' se ejecuta al menos una vez y se repite mientras.
la opción elegida no sea "5", que es la opción para salir.*/
do {
    console.clear();
    console.log("Bienvenido");
    console.log("Qué deseas hacer?");
    console.log("Menu Principal");
    console.log("1.Ver mis tareas");
    console.log("2.Buscar tarea");
    console.log("3.Agregar tarea");
    console.log("4.Ver Detalles de Tareas");
    console.log("5.Salir\n");

    opcion = prompt("Elige una opción: "); //Pide al usuario que ingrese una opción y la guarda en la variable 'opcion'.
    
    switch (opcion) { // Inicia un bloque 'switch' para ejecutar código basado en el valor de la variable 'opcion'.
            case "1":
            verTareas(); //Se llama a la Función verTareas.
            break;

        case "2":
            buscarTarea(); //Se llama a la Función buscarTareas.
            break;

        case "3":
            //Comprueba si hay espacio en los arrays
            if (numTareas < titulos.length) { //Compara el número de tareas actuales (numTareas) con el tamaño máximo del array (titulos.length, que es 10).
                // Si la condición es verdadera, significa que hay espacio para una nueva tarea.
                // Pide los datos de la tarea
                 let titulo = prompt("Ingresa el título: "); //Pide al usuario el título y lo guarda en la variable 'titulo'.
                 let descripcion = prompt("Ingresa la descripción: ");
                 let estado = prompt("Ingresa el estado de la tarea (En curso, Pendiente, Terminada): ");
                 let vencimiento = prompt("Ingresa la fecha de vencimiento (opcional): ");
                 let dificultad = prompt("Ingresa la dificultad (fácil, medio, difícil): ");

                 //Asigna los datos a la posición actual del contador.
                titulos[numTareas] = titulo; // Asigna el valor de la variable 'titulo' a la posición 'numTareas' en el array 'titulos'.
                descripciones[numTareas] = descripcion;
                estados[numTareas] = estado; // Asigna el estado por defecto ("pendiente") a la misma posición en el array 'estados'.
                fechasCreacion[numTareas] = new Date().toLocaleString(); 
                fechasVencimiento[numTareas] = vencimiento; 
                dificultades[numTareas] = dificultad;

                // Incrementa el contador para la siguiente tarea
                numTareas++; // Aumenta el valor de 'numTareas' en 1. Esto asegura que la próxima tarea se guarde en la siguiente posición libre del array.

                console.log("\n¡Tarea agregada con éxito!"); 
            } else {
                // Si la condición del 'if' es falsa, significa que el array está lleno.
                console.log("\n¡No se pueden agregar más tareas! El espacio está lleno.");
            }
            prompt("Presiona Enter para continuar...");
            break;

        case "4":
            mostrarDetalles() //Se llama a la Función mostrarTareas.
            break;
        case "5":
            console.log("Salir");
            break;

        default:
            console.log("Opción no válida. Intenta de nuevo.");
            prompt("Presiona Enter para continuar...");
            break;
    }
}while (opcion !== "5"); //El bucle se repite mientras la opción elegida no sea "5" (Salir).


// --- FUNCION VER TAREAS ---
//Muestra una lista de tareas filtrada por estado.
function verTareas() {
    console.clear();
    let subOpcion;
    console.log("¿Qué tarea deseas ver?");
    console.log("1.Todas");
    console.log("2.Pendientes");
    console.log("3.Terminadas");
    console.log("4.En Curso");
    console.log("5.Volver");
    subOpcion = prompt("Elige una opción: ");

    switch (subOpcion) {
        case "1":
            console.clear();
            console.log("Todas tus tareas:");
            if (numTareas === 0) { //Si el contador de tareas es cero, no hay nada que mostrar.
                console.log("No tienes tareas agregadas.");
            } else {
                //Itera sobre cada tarea existente y muestra todos sus detalles.
                for (let i = 0; i < numTareas; i++) {
                    console.log(`\n--- Tarea ${i + 1} ---`);
                    console.log(`Título: ${titulos[i]}`);
                    console.log(`Descripción: ${descripciones[i]}`);
                    console.log(`Estado: ${estados[i]}`);
                    console.log(`Dificultad: ${dificultades[i]}`);
                    console.log(`Fecha de Creación: ${fechasCreacion[i]}`);
                    console.log(`Fecha de Vencimiento: ${fechasVencimiento[i]}`);
                }
            }
            break;
        case "2":
            console.clear();
            console.log("Tus tareas pendientes:");
            let contadorPendientes = 0; // Usamos un contador en lugar de una variable booleana
            //Filtra las tareas, convirtiendo el estado a minúsculas para una comparación flexible.
            for (let i = 0; i < numTareas; i++) {
                if (estados[i] && estados[i].toLowerCase() === "pendiente") {
                    console.log(`\n--- Tarea ${i + 1} ---`);
                    console.log(`Título: ${titulos[i]}`);
                    console.log(`Estado: ${estados[i]}`);
                    contadorPendientes++;
                }
            }
            if (contadorPendientes === 0) {
                console.log("No tienes tareas pendientes.");
            }
            break;
        case "3":
            console.clear();
            console.log("Tareas terminadas:");
            let contadorTerminadas = 0; // Usamos un contador
            for (let i = 0; i < numTareas; i++) {
                if (estados[i] && estados[i].toLowerCase() === "terminada") {
                    console.log(`\n--- Tarea ${i + 1} ---`);
                    console.log(`Título: ${titulos[i]}`);
                    console.log(`Estado: ${estados[i]}`);
                    contadorTerminadas++;
                }
            }
            if (contadorTerminadas === 0) {
                console.log("No hay tareas terminadas.");
            }
            break;
        case "4":
            console.clear();
            console.log("Tus tareas en curso:");
            let contadorEnCurso = 0; // Usamos un contador
            for (let i = 0; i < numTareas; i++) {
                if (estados[i] && estados[i].toLowerCase() === "en curso") {
                    console.log(`\n--- Tarea ${i + 1} ---`);
                    console.log(`Título: ${titulos[i]}`);
                    console.log(`Estado: ${estados[i]}`);
                    contadorEnCurso++;
                }
            }
            if (contadorEnCurso === 0) {
                console.log("No tienes tareas en curso.");
            }
            break;
        case "5":
            console.log("Volviendo..."); //La opción "volver" regresa al menú principal.
            break;
        default:
            console.log("Opción no válida.");
            break;
    }
    prompt("\nPresiona Enter para continuar...");
}

//--- FUNCIÓN MOSTRAR DETALLES ---
// Muestra todos los detalles de las tareas que tienen un estado específico.
function mostrarDetalles() {
    console.clear();
    let estadoBuscado = prompt("Ingresa el estado de la tarea que quieres ver (Pendiente, Terminada, En Curso): ");
    let contador = 0; //Inicializamos un contador para saber cuántas tareas se encontraron.

    console.log(`\nMostrando detalles de tareas: ${estadoBuscado}`);//Se muestra un mensaje con el estado que se está buscando.

    // Bucle para recorrer todas las tareas
    for (let i = 0; i < numTareas; i++) {
        // Verifica si el estado de la tarea actual coincide con el buscado
        if (estados[i] && estados[i].toLowerCase() === estadoBuscado.toLowerCase()) {
            console.log(`\n--- Tarea ${i + 1} ---`); //Muestra un separador para cada tarea encontrada.
            console.log(`Título: ${titulos[i]}`);
            console.log(`Descripción: ${descripciones[i]}`);
            console.log(`Estado: ${estados[i]}`);
            console.log(`Dificultad: ${dificultades[i]}`);
            console.log(`Fecha de Creación: ${fechasCreacion[i]}`);
            console.log(`Fecha de Vencimiento: ${fechasVencimiento[i]}`);
            contador++; // Incrementa el contador cada vez que se encuentra una tarea
        }
    }

    if (contador === 0) {
        console.log("No hay tareas con ese estado.");
    }
}

//Función de Buscar Tareas
//Esta función permite al usuario buscar tareas por una palabra clave en su título, descripción o estado.
function buscarTarea() {
    console.clear();
    console.log("--- Búsqueda de Tarea ---");

    //Pregunta al usuario qué desea buscar
    let terminoBusqueda = prompt("Ingresa el título, descripción o estado de la tarea a buscar: ");
    
    //Se convierte el término de búsqueda a minúsculas para una comparación sin distinción de mayúsculas y minúsculas
    let terminoMinusc = terminoBusqueda.toLowerCase();
    
    //Contador para saber si se encontraron resultados
    let contadorResultados = 0;

    //Recorre todas las tareas existentes
    for (let i = 0; i < numTareas; i++) {
        // Verifica si el término de búsqueda está incluido en el título, descripción o estado de la tarea actual.
        // Convertimos los datos de la tarea a minúsculas para que la búsqueda sea "case-insensitive".
        /*La condición principal de búsqueda: usa el método `.includes()` para verificar si el término de búsqueda
        está contenido en el título, la descripción o el estado.*/
        if (titulos[i].toLowerCase().includes(terminoMinusc) ||
            descripciones[i].toLowerCase().includes(terminoMinusc) ||
            estados[i].toLowerCase().includes(terminoMinusc)) {
            
            // Si hay una coincidencia, muestra los detalles de la tarea
            console.log(`\n--- Coincidencia Encontrada (Tarea ${i + 1}) ---`);
            console.log(`Título: ${titulos[i]}`);
            console.log(`Descripción: ${descripciones[i]}`);
            console.log(`Estado: ${estados[i]}`);
            console.log(`Dificultad: ${dificultades[i]}`);
            console.log(`Fecha de Creación: ${fechasCreacion[i]}`);
            console.log(`Fecha de Vencimiento: ${fechasVencimiento[i]}`);
            
            //Incrementa el contador para indicar que se encontró al menos un resultado
            contadorResultados++;
        }
    }

    // Si el contador es 0, significa que no se encontraron coincidencias
    if (contadorResultados === 0) {
        console.log(`\nNo se encontraron tareas que coincidan con "${terminoBusqueda}".`);
    }

    prompt("\nPresiona Enter para continuar...");
}


 