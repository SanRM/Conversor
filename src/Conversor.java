import javax.swing.JOptionPane;

public class Conversor {
    
    private String mensaje;
    private String opcionPredefinida;
    private String[] opciones;
    private boolean salir = true;

    // Constructor de la clase Conversor
    public Conversor(String mensaje, String[] opciones, String opcionPredefinida){
        this.mensaje = mensaje;
        this.opcionPredefinida = opcionPredefinida;
        this.opciones = opciones;
    };

    // Método para establecer el estado del programa
    public boolean setProgramaCorriendo(boolean valor){
        return this.salir = valor;
    }

    // Método para obtener el estado del programa
    public boolean getProgramaCorriendo(){
        return this.salir;
    }

    // Método para mostrar el menú principal y obtener la opción seleccionada
    public String menuPrincipal() {
        return (String) JOptionPane.showInputDialog(null, mensaje, "Menú principal",JOptionPane.INFORMATION_MESSAGE, null, opciones, opcionPredefinida);
    }

    // Método para mostrar un menú secundario y obtener la opción seleccionada
    public String menuSecundario(String mensaje, String nombreMenu, String[] opciones, String opcionPredefinida) {
        return (String) JOptionPane.showInputDialog(null, mensaje, nombreMenu, JOptionPane.INFORMATION_MESSAGE, null, opciones, opcionPredefinida);
    }

    // Método para mostrar un menú secundario con un tipo de mensaje específico y obtener la opción seleccionada
    public String menuSecundario(String mensaje, String nombreMenu, int tipoDeMensaje, String[] opciones, String opcionPredefinida) {
        return (String) JOptionPane.showInputDialog(null, mensaje, nombreMenu, tipoDeMensaje, null, opciones, opcionPredefinida);
    }

    // Método para solicitar al usuario ingresar un valor y obtenerlo como double
    public double ingresarValor(String mensaje) {
        try {
            Object dineroAConvertir = JOptionPane.showInputDialog(null, mensaje, null, JOptionPane.QUESTION_MESSAGE, null, null, null);
            return Double.parseDouble(dineroAConvertir.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor no válido");
        }
        return 0.0;
    }

    // Método para solicitar al usuario ingresar un valor con un tipo de mensaje específico y obtenerlo como double
    public double ingresarValor(String mensaje, int tipoDeMensaje) {
        try {
            Object dineroAConvertir = JOptionPane.showInputDialog(null, mensaje, null, tipoDeMensaje, null, null, null);
            return Double.parseDouble(dineroAConvertir.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valor no válido");
        }
        return 0.0;
    }

    // Método para mostrar un mensaje final y obtener la opción seleccionada
    public double salidaFinal(String mensaje, String titulo){
        return JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.DEFAULT_OPTION);
    };

    // Método para finalizar el programa o continuar con otra conversión
    public boolean finalizarPrograma() {

        int opcionSeleccionada = JOptionPane.showConfirmDialog(null, "¿Deseas realizar otra conversión?");

        if (opcionSeleccionada == JOptionPane.NO_OPTION || opcionSeleccionada == JOptionPane.CANCEL_OPTION){
            JOptionPane.showMessageDialog(null, "Programa finalizado");
            return this.setProgramaCorriendo(false);
        } else {
            return this.setProgramaCorriendo(true);
        }
    }

}
