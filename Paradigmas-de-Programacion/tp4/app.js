const prompt = require('prompt-sync')(); //Importa la librería prompt-sync para leer entradas del usuario desde consola

// ---------- ayudas funcionales ----------
//Congela un objeto para que no pueda ser modificado (inmutable)
const freezeDeep = function (obj) { //Define una función que congela un objeto para hacerlo inmutable
  Object.freeze(obj); //Aplica Object.freeze para evitar modificaciones
  return obj; //Devuelve el objeto congelado
};

const compose = function () { //Define una función para componer funciones de derecha a izquierda
  const funciones = arguments; //Guarda todas las funciones pasadas como argumentos
  return function (x) { //Devuelve una nueva función que toma un valor inicial x
    let resultado = x; //Inicializa el resultado con x
    for (let i = funciones.length - 1; i >= 0; i--) { //Itera sobre las funciones de derecha a izquierda
      resultado = funciones[i](resultado); //Aplica cada función al resultado actual
    }
    return resultado; //Devuelve el resultado final después de aplicar todas las funciones
  };
};

const pipe = function () { //Define una función para encadenar funciones de izquierda a derecha
  const funciones = arguments; //Guarda todas las funciones pasadas como argumentos
  return function (x) { //Devuelve una nueva función que toma un valor inicial x
    let resultado = x; //Inicializa el resultado con x
    for (let i = 0; i < funciones.length; i++) { //Itera sobre las funciones de izquierda a derecha
      resultado = funciones[i](resultado); //Aplica cada función al resultado actual
    }
    return resultado; //Devuelve el resultado final después de aplicar todas las funciones
  };

//---------- Funciones puras----------

// crearTarea pura: recibe toda la info (incluyendo fechaCreacion)
function crearTarea(titulo, descripcion, estado, fechaCreacion, fechaVencimiento, dificultad) { //Crea una tarea inmutable con la información proporcionada
  const tarea = { //Crea un objeto tarea con las propiedades dadas
    titulo: titulo, //Asigna el título
    descripcion: descripcion,
    estado: estado,
    fechaCreacion: fechaCreacion,
    fechaVencimiento: fechaVencimiento,
    dificultad: dificultad
  };
  return freezeDeep(tarea); //Devuelve la tarea congelada para hacerla inmutable
}

// agregarTarea pura: devuelve nueva lista
function agregarTarea(tareas, nuevaTarea) { //Agrega una nueva tarea a la lista de tareas de forma inmutable
  return Object.freeze(tareas.concat([nuevaTarea])); //Devuelve una nueva lista de tareas con la nueva tarea añadida y congelada
}

// filtrarPorEstado pura
function filtrarPorEstado(tareas, estadoBuscado) { //Filtra las tareas por el estado especificado de forma inmutable
  if (!estadoBuscado) { //Si no se especifica un estado, devuelve todas las tareas
    return tareas.slice(); //Crea una copia superficial de la lista de tareas
  }
  const estadoN = estadoBuscado.toLowerCase(); //Convierte el estado buscado a minúsculas para comparación insensible a mayúsculas
  return tareas.filter(function (t) { //Filtra las tareas que coinciden con el estado buscado
    return t.estado && t.estado.toLowerCase() === estadoN; //Compara el estado de cada tarea con el estado buscado
  });
}

// buscarTareas pura
function buscarTareas(tareas, termino) { //Busca tareas que contengan el término especificado en título, descripción o estado de forma inmutable
  if (!termino) { //Si no se especifica un término, devuelve una lista vacía
    return []; //Devuelve una lista vacía
  }
  const t = termino.toLowerCase(); //Convierte el término de búsqueda a minúsculas para comparación insensible a mayúsculas
  return tareas.filter(function (tarea) { //Filtra las tareas que contienen el término en alguna de sus propiedades
    return (tarea.titulo && tarea.titulo.toLowerCase().includes(t)) ||
           (tarea.descripcion && tarea.descripcion.toLowerCase().includes(t)) ||
           (tarea.estado && tarea.estado.toLowerCase().includes(t)); //Comprueba si el término está en título, descripción o estado
  });
}

// actualizarTarea pura
function actualizarTarea(tareas, predicadoIdentificador, patch) { //Actualiza las tareas que cumplen con el predicado dado aplicando los cambios especificados en patch de forma inmutable
  const nuevas = tareas.map(function (tarea) { //Mapea cada tarea para aplicar los cambios si cumple con el predicado
    if (predicadoIdentificador(tarea)) { //Si la tarea cumple con el predicado, crea una nueva tarea con los cambios aplicados
      const nueva = Object.assign({}, tarea, patch); //Crea una nueva tarea combinando la tarea original con los cambios del patch
      return Object.freeze(nueva); //Devuelve la nueva tarea congelada para hacerla inmutable
    }
    return tarea; //Si no cumple con el predicado, devuelve la tarea original sin cambios
  });
  return Object.freeze(nuevas); //Devuelve la nueva lista de tareas congelada para hacerla inmutable
}

// ordenarTareas pura
function ordenarTareas(tareas, comparador) { //Ordena las tareas según el comparador proporcionado de forma inmutable
  const copia = tareas.slice(); //Crea una copia superficial de la lista de tareas
  copia.sort(comparador); //Ordena la copia utilizando el comparador dado
  return Object.freeze(copia); //Devuelve la lista ordenada congelada para hacerla inmutable
}

// formatearTarea pura
function formatearTarea(tarea, indice) { //Formatea una tarea en una cadena legible para mostrarla en consola
  return "\n--- Tarea " + (indice + 1) + " ---" +
         "\nTítulo: " + tarea.titulo +
         "\nDescripción: " + tarea.descripcion +
         "\nEstado: " + tarea.estado +
         "\nDificultad: " + tarea.dificultad +
         "\nFecha de Creación: " + tarea.fechaCreacion +
         "\nFecha de Vencimiento: " + (tarea.fechaVencimiento || "N/A"); //Devuelve la cadena formateada con los detalles de la tarea
}

//---------- Funciones impuras (I/O) ----------

function crearTareaIO(titulo, descripcion, estado, fechaVencimiento, dificultad, generadorFecha) { //Crea una tarea solicitando la fecha de creación mediante una función generadora de fecha (impura)
  const generar = generadorFecha || function () { return new Date().toLocaleString(); }; //Usa la función generadora de fecha proporcionada o la fecha actual por defecto
  const fechaCreacion = generar(); //Genera la fecha de creación usando la función generadora
  return crearTarea(titulo, descripcion, estado, fechaCreacion, fechaVencimiento, dificultad); //Llama a la función pura crearTarea para crear la tarea con la fecha generada
}

function mostrarTareasIO(tareas, tituloSeccion) { //Muestra las tareas en consola con un título de sección (impura)
  console.clear(); //Limpia la consola para una mejor visualización
  console.log("--- " + tituloSeccion + " ---"); //Muestra el título de la sección
  if (!tareas || tareas.length === 0) { //Si no hay tareas para mostrar, indica que no hay tareas
    console.log("No tienes tareas para mostrar."); //Indica que no hay tareas
    return; //Termina la función
  }
  const listado = tareas.map(formatearTarea).join("\n\n"); //Formatea cada tarea y las une en una sola cadena con saltos de línea
  console.log(listado); //Muestra el listado de tareas formateadas
}

function comparadorDificultad(a, b) { //Comparador para ordenar tareas por dificultad (fácil < medio < difícil)
  const rank = { "fácil": 1, "medio": 2, "difícil": 3 }; //Define un ranking numérico para las dificultades
  return (rank[a.dificultad] || 0) - (rank[b.dificultad] || 0); //Compara las dificultades usando el ranking definido
}

//---------- Capa impura principal ----------

function run() { //Función principal para ejecutar el programa (impura)
  let tareas = Object.freeze([]); //Inicializa la lista de tareas como una lista vacía congelada

  const t1 = crearTareaIO("Comprar leche", "Ir al supermercado", "Pendiente", "2025-12-01", "fácil"); //Crea una tarea usando la función impura crearTareaIO
  tareas = agregarTarea(tareas, t1); //Agrega la tarea a la lista usando la función pura agregarTarea

  tareas = actualizarTarea(tareas, function (tarea) { return tarea.titulo === "Comprar leche"; }, { estado: "Terminada" }); //Actualiza el estado de la tarea "Comprar leche" a "Terminada" usando la función pura actualizarTarea

  tareas = ordenarTareas(tareas, comparadorDificultad); //Ordena las tareas por dificultad usando la función pura ordenarTareas y el comparador definido

  mostrarTareasIO(tareas, "Tareas actuales"); //Muestra las tareas en consola usando la función impura mostrarTareasIO
}

if (require.main === module) { //Si este archivo es el módulo principal, ejecuta la función run
  run(); //Llama a la función
}

//Exportaciones opcionales
module.exports = { //Exporta las funciones para su uso en otros módulos
  crearTarea: crearTarea, 
  agregarTarea: agregarTarea,
  filtrarPorEstado: filtrarPorEstado,
  buscarTareas: buscarTareas,
  actualizarTarea: actualizarTarea,
  ordenarTareas: ordenarTareas,
  formatearTarea: formatearTarea,
  crearTareaIO: crearTareaIO,
  mostrarTareasIO: mostrarTareasIO,
  compose: compose,
  pipe: pipe
};
};