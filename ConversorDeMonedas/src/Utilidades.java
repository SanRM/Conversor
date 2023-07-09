import javax.swing.JOptionPane;

public class Utilidades {
    
    private String[] opcionesPrincipales = { "Conversor de monedas", "Conversor de temperatura" };
    private boolean salir = false;

    //metodo sobrecargado
    public String getOpcionesPrincipales(int index) {
        return opcionesPrincipales[index];
    }

    public String[] getOpcionesPrincipales() {
        return opcionesPrincipales;
    }

    public boolean getSalir(){
        return this.salir;
    }

    public String menuPrincipal(String[] opciones, Object opcionPredefinida) {
        return (String) JOptionPane.showInputDialog(null, "Selecciona una opción:", "Menú",JOptionPane.INFORMATION_MESSAGE, null, opciones, opcionPredefinida);
    }

    public boolean finalizarPrograma(String mensaje) {

        int opcionSeleccionada = JOptionPane.showConfirmDialog(null, mensaje);

        if (opcionSeleccionada == JOptionPane.NO_OPTION || opcionSeleccionada == JOptionPane.CANCEL_OPTION){
            this.salir = true;
            confirmarFinalizacionPrograma();
            return this.salir;
        } 
        return this.salir;
    }

    public void confirmarFinalizacionPrograma() {
        
        JOptionPane.showMessageDialog(null, "Programa finalizado");

    }

}
