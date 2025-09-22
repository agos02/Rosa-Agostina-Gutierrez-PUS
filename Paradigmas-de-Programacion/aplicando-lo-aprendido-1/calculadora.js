console.log("\nAplicando lo Aprendido 1.");
console.log("Calculadora de las 4 operaciones");
console.log("Ingresa 2 valores:\n");

// Importa la librería prompt-sync para poder cargar datos desde teclado
const prompt = require("prompt-sync")();
// Pide al usuario el primer número y lo convierte a entero
let n1 = parseInt(prompt("Ingresa un número: "));
// Pide al usuario el segundo número y lo convierte a entero
let n2 = parseInt(prompt("Ingresa otro número:"));

//menu de opciones
console.log("¿Que operacion quieres realizar?\n");
console.log("1.Suma.");
console.log("2.Resta.");
console.log("3.Multiplicacion.");
console.log("4.Division.\n");

// El usuario elige una opción (1 a 4) y se convierte a entero
let opcion = parseInt(prompt("Elige una de las 4 opciones: "));
let n3;

if (opcion == 1){
   n3 = n1 + n2;
    console.log("El resultado de la suma es: ");
    console.log(n3);
}
else if(opcion == 2){
   n3 = n1 - n2;
   console.log("El resultado de la resta es: ");
    console.log(n3);
}


else if(opcion == 3){
   n3 = n1 * n2;
   console.log("El resultado de la multiplicacion es: ");
    console.log(n3);
}


else if(opcion == 4){
   n3 = n1 / n2;
   console.log("El resultado de la division es: ");
   console.log(n3);

   console.log("\n¿Quieres hallar el resto de la division?");
   console.log("1.SI.");
   console.log("2.NO");

   let opcion2 = parseInt(prompt("Elige una opcion:"));
   if(opcion2 == 1 ){
    console.log("El resto de la division es: ");
    console.log( n1 % n2 );
   }
   else{
    console.log("¡Gracias por usar la calculadora!");
   }
}