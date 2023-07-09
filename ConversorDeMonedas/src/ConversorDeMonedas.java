import javax.swing.JOptionPane;

public class ConversorDeMonedas {
    
    private String[] opcionesConversorMonedas = {"De Cop a moneda extranjera", "De Moneda extranjera a Cop"}; 
    private String[] divisas = {"Dólares", "Euros", "Libras Esterlinas", "Yen Japonés", "Wones surcoreanos"};
    
    public String getOpcionesConversorMonedas(int index) {
        return opcionesConversorMonedas[index];
    }

    public double Input() {
        try {
            Object dineroAConvertir = JOptionPane.showInputDialog(null, "Ingresa la cantidad de dinero que deseas convertir:", null, JOptionPane.QUESTION_MESSAGE, null, null, null);
            return Double.parseDouble(dineroAConvertir.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor no válido");
        }
        return 0.0;
    }
    

    public String SeleccionarOperacion(){
        return (String) JOptionPane.showInputDialog(null, "¿Qué operación deseas realizar?", "Conversor de monedas", JOptionPane.QUESTION_MESSAGE, null, opcionesConversorMonedas, opcionesConversorMonedas[0]);
    };

    public String SeleccionarDivisaCopAOtra(){
        return (String) JOptionPane.showInputDialog(null, "Elije la moneda a la que deseas convertir tu dinero:", "Conversor de monedas", JOptionPane.PLAIN_MESSAGE, null, this.divisas, this.divisas[0]);
    };

    public String SeleccionarDivisaOtraACop(){
        return (String) JOptionPane.showInputDialog(null, "Elije desde que moneda quieres convertir a pesos Colombianos:", "Conversor de monedas", JOptionPane.PLAIN_MESSAGE, null, this.divisas, this.divisas[0]);
    };

    public double Conversor(String divisa, String tipoDeConversion, double cantidadAConvertir){

        double resultado = 0;

        switch (tipoDeConversion) {
            case "De Cop a moneda extranjera":
                
                switch (divisa) {
                    case "Dólares":
                        resultado = cantidadAConvertir * 0.00024;
                        return resultado;
            
                    case "Euros":
                        resultado = cantidadAConvertir * 0.00022;
                        return resultado;

                    case "Libras Esterlinas":
                        resultado = cantidadAConvertir * 18.56;
                        return resultado;

                    case "Yen Japonés":
                        resultado = cantidadAConvertir * 0.034;
                        return resultado;

                    case "Wones surcoreanos":
                        resultado = cantidadAConvertir * 0.31;
                        return resultado;
                }
        
            case "De Moneda extranjera a Cop":
                
                switch (divisa) {
                    case "Dólares":
                        resultado = cantidadAConvertir * 4226.50;
                        return resultado;
            
                    case "Euros":
                        resultado = cantidadAConvertir * 4610.42;
                        return resultado;

                    case "Libras Esterlinas":
                        resultado = cantidadAConvertir * 5385.00;
                        return resultado;

                    case "Yen Japonés":
                        resultado = cantidadAConvertir * 29.41;
                        return resultado;

                    case "Wones surcoreanos":
                        resultado = cantidadAConvertir * 3.24;
                        return resultado;
                }
        }

        return resultado;

    };

    public double Output(double conversion, String mensaje){
        return JOptionPane.showConfirmDialog(null, "Tienes $" + conversion + " " + mensaje, "Titulo", JOptionPane.DEFAULT_OPTION);
    };

}
