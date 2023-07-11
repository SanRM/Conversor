import javax.swing.JOptionPane;

public class App {
    
    public static void main(String[] args) {
    
        // Definición de opciones disponibles en el menú principal
        String[] opciones = {"Moneda", "Temperatura"};
        
        // Descripción del conversor de monedas
        String conversorDeMonedasDescripcion = "Bienvenido. \nSelecciona el tipo de conversor que deseas usar:";
        
        // Título general del conversor
        String conversorTituloGeneral = "Conversor";
        
        // Títulos de los conversores específicos
        String conversorDeMonedasTitulo = "Conversor de monedas";
        String conversorDeTemperaturaTitulo = "Conversor de temperatura";

        // Creación de las instancias de las clases Conversor, ConversorDeMonedas y ConversorDeTemperatura
        Conversor conversor = new Conversor(conversorTituloGeneral, opciones, conversorDeTemperaturaTitulo);
        ConversorDeMonedas conversorDeMonedas = new ConversorDeMonedas(conversorDeMonedasDescripcion, opciones, opciones[0]);
        ConversorDeTemperatura conversorDeTemperatura = new ConversorDeTemperatura(conversorDeMonedasDescripcion, opciones, opciones[0]);

        // Bucle principal del programa
        while (conversor.getProgramaCorriendo()) {

            // Mostrar el menú principal y obtener la opción seleccionada
            String opcionMenuPrincipal = conversor.menuPrincipal();

            // Si la opción seleccionada es "Moneda"
            if (opcionMenuPrincipal.equals(opciones[0])) {

                // Solicitar al usuario ingresar el valor a convertir
                double valorAConvertir = conversorDeMonedas.ingresarValor("Ingresa el valor a convertir");
                
                // Definir las opciones disponibles en el menú secundario para el conversor de monedas
                String[] opcionesConversorMonedas = {"De Cop a moneda extranjera", "De Moneda extranjera a Cop"}; 
                
                // Mostrar el menú secundario y obtener la opción seleccionada
                String menuSecundarioMonedas = conversorDeMonedas.menuSecundario("¿Qué operación deseas realizar?", conversorDeMonedasTitulo, JOptionPane.INFORMATION_MESSAGE, opcionesConversorMonedas, opcionesConversorMonedas[0]);

                // Definir las divisas disponibles
                String[] divisas = {"Dólares", "Euros", "Libras Esterlinas", "Yen Japonés", "Wones surcoreanos"};

                // Si la opción seleccionada en el menú secundario es "De Cop a moneda extranjera"
                if (menuSecundarioMonedas.equals(opcionesConversorMonedas[0])) {

                    // Solicitar al usuario elegir la moneda a la que desea convertir el valor
                    String divisaSeleccionada = conversorDeMonedas.menuSecundario("Elije la moneda a la que deseas convertir tu dinero:", conversorDeMonedasTitulo, divisas, divisas[0]);
                    
                    // Obtener el resultado de la conversión y mostrarlo en una ventana de salida
                    double conversionFinalMonedas = conversorDeMonedas.obtenerConversion(opcionesConversorMonedas[0], divisaSeleccionada, valorAConvertir);
                    conversorDeMonedas.salidaFinal("Resultado: " + conversionFinalMonedas, conversorDeMonedasTitulo);
                    
                } 
                
                // Si la opción seleccionada en el menú secundario es "De Moneda extranjera a Cop"
                else if (menuSecundarioMonedas.equals(opcionesConversorMonedas[1])) {

                    // Solicitar al usuario elegir la moneda desde la que desea convertir el valor
                    String divisaSeleccionada = conversorDeMonedas.menuSecundario("Elije desde qué moneda quieres convertir a pesos colombianos:", conversorDeMonedasTitulo, divisas, divisas[0]);
                    
                    // Obtener el resultado de la conversión y mostrarlo en una ventana de salida
                    double conversionFinalMonedas = conversorDeMonedas.obtenerConversion(opcionesConversorMonedas[1], divisaSeleccionada, valorAConvertir);
                    conversorDeMonedas.salidaFinal("Resultado: " + conversionFinalMonedas, conversorDeMonedasTitulo);
                }
            } 
            // Si la opción seleccionada en el menú principal es "Temperatura"
            else if (opcionMenuPrincipal.equals(opciones[1])) {

                // Solicitar al usuario ingresar el valor a convertir
                double valorAConvertirTemperatura = conversorDeMonedas.ingresarValor("Ingresa el valor que deseas convertir");
                
                // Definir las opciones disponibles en el menú secundario para el conversor de temperatura
                String[] opcionesConversorTemperatura = {"Celsius", "Fahrenheit", "Kelvin"};
                
                // Solicitar al usuario elegir la medida de temperatura base y final
                String medidaBaseTemperatura = conversorDeMonedas.menuSecundario("Selecciona la unidad de medida de temperatura base:", conversorDeMonedasTitulo, JOptionPane.INFORMATION_MESSAGE, opcionesConversorTemperatura, opcionesConversorTemperatura[0]);
                String medidaFinalTemperatura = conversorDeMonedas.menuSecundario("Selecciona la unidad de medida de temperatura final:", conversorDeMonedasTitulo, JOptionPane.INFORMATION_MESSAGE, opcionesConversorTemperatura, opcionesConversorTemperatura[0]);

                // Obtener el resultado de la conversión de temperatura y mostrarlo en una ventana de salida
                double conversionFinalTemperatura = conversorDeTemperatura.obtenerConversion(medidaBaseTemperatura, medidaFinalTemperatura, valorAConvertirTemperatura, opcionesConversorTemperatura);

                // Si el resultado de la conversión es 0, el programa finaliza
                if (conversionFinalTemperatura == 0){
                    conversor.setProgramaCorriendo(false);
                } 
                // Si el resultado de la conversión es diferente de 0, mostrar el resultado y continuar con el programa
                else {
                    conversorDeMonedas.salidaFinal("Resultado: " + conversionFinalTemperatura, conversorDeTemperaturaTitulo);
                    conversor.setProgramaCorriendo(true);
                }
            }

            // Solicitar al usuario si desea realizar otra conversión y actualizar el estado del programa
            boolean continuarConElPrograma = conversor.finalizarPrograma();
            conversor.setProgramaCorriendo(continuarConElPrograma); 
        }
    }
}
