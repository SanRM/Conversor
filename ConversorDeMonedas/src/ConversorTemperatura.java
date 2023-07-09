import javax.swing.JOptionPane;

public class ConversorTemperatura {
    
    private String[] opcionesConversorTemperatura = {"Celsius", "Fahrenheit", "Kelvin"}; 

    public String getOpcionesConversorTemperatura(int index) {
        return opcionesConversorTemperatura[index];
    }

    public String SeleccionarUnidadDeMedidaBase(){
        return (String) JOptionPane.showInputDialog(null, "Selecciona la unidad de medida de temperatura base:", "Conversor de temperatura", JOptionPane.PLAIN_MESSAGE, null, this.opcionesConversorTemperatura, this.opcionesConversorTemperatura[0]);
    };
    
    public double Input() {
        try {
            Object valorAConvertir = JOptionPane.showInputDialog(null, "Ingresa el valor que deseas convertir", null, JOptionPane.QUESTION_MESSAGE, null, null, null);
            return Double.parseDouble(valorAConvertir.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor no válido");
        }
        return 0.0;
    }

    public String SeleccionarUnidadDeMedidaFinal(){
        return (String) JOptionPane.showInputDialog(null, "Selecciona la unidad de medida de temperatura final:", "Conversor de temperatura", JOptionPane.PLAIN_MESSAGE, null, this.opcionesConversorTemperatura, this.opcionesConversorTemperatura[0]);
    }; 

    public double Conversor(String medidaBase, String medidaFinal, double valorAConvertir) {
        
        double resultado = 0;

        String Celsius = opcionesConversorTemperatura[0];
        String Fahrenheit = opcionesConversorTemperatura[1];
        String Kelvin = opcionesConversorTemperatura[2];

        if (medidaBase == Celsius && medidaFinal == Celsius){
            JOptionPane.showMessageDialog(null, "Ingresaste la misma unidad de medida ");
        } else if (medidaBase == Celsius && medidaFinal == Fahrenheit){
            resultado = (valorAConvertir * 9/5) + 32;
            return resultado;
        } else if (medidaBase == Celsius && medidaFinal == Kelvin){
            resultado = valorAConvertir + 273.15;
            return resultado;
        }

         if (medidaBase == Fahrenheit && medidaFinal == Fahrenheit){
            JOptionPane.showMessageDialog(null, "Ingresaste la misma unidad de medida ");
        } else if (medidaBase == Fahrenheit && medidaFinal == Celsius){
            resultado = (valorAConvertir - 32) * 5/9;
            return resultado;
        } else {
            resultado = (valorAConvertir + 459.67) * 5/9;
            return resultado;
        }

        if (medidaBase == Kelvin && medidaFinal == Kelvin){
            JOptionPane.showMessageDialog(null, "Ingresaste la misma unidad de medida ");
        } else if (medidaBase == Kelvin && medidaFinal == Celsius){
            resultado = valorAConvertir - 273.15;
            return resultado;
        } else {
            resultado = (valorAConvertir * 9/5) - 459.67;
            return resultado;
        }

        return resultado;

    }

    public double Output(double cantidadAConvertir, String medidaBase, String medidaFinal, double resultadoConversion){
        return JOptionPane.showConfirmDialog(null, cantidadAConvertir + " Grados " + medidaBase + " son " + resultadoConversion + " Grados " + medidaFinal, "Conversor de temperatura", JOptionPane.DEFAULT_OPTION);
    };

}
