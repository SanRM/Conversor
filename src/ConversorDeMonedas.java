public class ConversorDeMonedas extends Conversor {

    // Constructor de la clase ConversorDeMonedas
    public ConversorDeMonedas(String mensaje, String[] opciones, String opcionPredefinida) {
        super(mensaje, opciones, opcionPredefinida);
    }
    
    // Método para obtener la conversión de monedas
    public double obtenerConversion(String tipoConversion, String divisa, double valorAConvertir){

        double resultado = 0;

        // Verificar el tipo de conversión seleccionado
        if (tipoConversion.equals("De Cop a moneda extranjera")) {

            // Realizar la conversión para cada divisa
            switch (divisa) {
                case "Dólares":
                    resultado = valorAConvertir * 0.00024;
                    return resultado;
        
                case "Euros":
                    resultado = valorAConvertir * 0.00022;
                    return resultado;

                case "Libras Esterlinas":
                    resultado = valorAConvertir * 18.56;
                    return resultado;

                case "Yen Japonés":
                    resultado = valorAConvertir * 0.034;
                    return resultado;

                case "Wones surcoreanos":
                    resultado = valorAConvertir * 0.31;
                    return resultado;
            }
        }
        // Verificar el tipo de conversión seleccionado
        else if (tipoConversion.equals("De Moneda extranjera a Cop")) {

            // Realizar la conversión para cada divisa
            switch (divisa) {
                case "Dólares":
                    resultado = valorAConvertir * 4226.50;
                    return resultado;
        
                case "Euros":
                    resultado = valorAConvertir * 4610.42;
                    return resultado;

                case "Libras Esterlinas":
                    resultado = valorAConvertir * 5385.00;
                    return resultado;

                case "Yen Japonés":
                    resultado = valorAConvertir * 29.41;
                    return resultado;

                case "Wones surcoreanos":
                    resultado = valorAConvertir * 3.24;
                    return resultado;
            }

        }

        return resultado;
    };
}
