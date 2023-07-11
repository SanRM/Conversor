import javax.swing.JOptionPane;

public class ConversorDeTemperatura extends Conversor {

    public ConversorDeTemperatura(String mensaje, String[] opciones, String opcionPredefinida) {
        super(mensaje, opciones, opcionPredefinida);
    }
    
    public double obtenerConversion(String medidaBase, String medidaFinal, double valorAConvertir, String[] opcionesConversorTemperatura) {

        double resultado = 0;
    
        String Celsius = opcionesConversorTemperatura[0];
        String Fahrenheit = opcionesConversorTemperatura[1];
        String Kelvin = opcionesConversorTemperatura[2];
    
        // Verificar si la medida base y la medida final son iguales
        if (medidaBase.equals(medidaFinal)) {
            JOptionPane.showMessageDialog(null, "Ingresaste la misma unidad de medida");
            setProgramaCorriendo(false);
            return 0;
        } 
        // Conversiones de Celsius
        else if (medidaBase.equals(Celsius) && medidaFinal.equals(Fahrenheit)) {
            resultado = (valorAConvertir * 9/5) + 32;
            return resultado;
        } else if (medidaBase.equals(Celsius) && medidaFinal.equals(Kelvin)) {
            resultado = valorAConvertir + 273.15;
            return resultado;
        } 
        // Conversiones de Fahrenheit
        else if (medidaBase.equals(Fahrenheit) && medidaFinal.equals(Celsius)) {
            resultado = (valorAConvertir - 32) * 5/9;
            return resultado;
        } else if (medidaBase.equals(Fahrenheit) && medidaFinal.equals(Kelvin)) {
            resultado = (valorAConvertir + 459.67) * 5/9;
            return resultado;
        } 
        // Conversiones de Kelvin
        else if (medidaBase.equals(Kelvin) && medidaFinal.equals(Celsius)) {
            resultado = valorAConvertir - 273.15;
            return resultado;
        } else {
            resultado = (valorAConvertir * 9/5) - 459.67;
            return resultado;
        }
    }

}
