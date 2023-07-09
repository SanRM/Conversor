
public class Principal {
    public static void main(String[] args) {

        Utilidades utilidades = new Utilidades();

        while (utilidades.getSalir() == false) {

            String menuPrincipal = utilidades.menuPrincipal(utilidades.getOpcionesPrincipales(), utilidades.getOpcionesPrincipales(0));

            if (menuPrincipal == utilidades.getOpcionesPrincipales(0)) {

                ConversorDeMonedas conversorDeMonedas = new ConversorDeMonedas();
                String operacionSeleccionada = conversorDeMonedas.SeleccionarOperacion();
                double cantidadAConvertir = conversorDeMonedas.Input();

                if (operacionSeleccionada == conversorDeMonedas.getOpcionesConversorMonedas(0)) {

                    String divisaSeleccionada = conversorDeMonedas.SeleccionarDivisaCopAOtra();
                    double cantidadFinal = conversorDeMonedas.Conversor(divisaSeleccionada, conversorDeMonedas.getOpcionesConversorMonedas(0), cantidadAConvertir);

                    conversorDeMonedas.Output(cantidadFinal, divisaSeleccionada);

                } else {

                    String divisaSeleccionada = conversorDeMonedas.SeleccionarDivisaOtraACop();
                    double cantidadFinal = conversorDeMonedas.Conversor(divisaSeleccionada, conversorDeMonedas.getOpcionesConversorMonedas(1), cantidadAConvertir);

                    conversorDeMonedas.Output(cantidadFinal, "Pesos Colombianos");
                };

            } else if (menuPrincipal == utilidades.getOpcionesPrincipales(1)){
                
                ConversorTemperatura conversorTemperatura = new ConversorTemperatura();
                String medidaBase = conversorTemperatura.SeleccionarUnidadDeMedidaBase();
                double valorAConvertir = conversorTemperatura.Input();
                String medidaFinal = conversorTemperatura.SeleccionarUnidadDeMedidaFinal();

                double resultado = conversorTemperatura.Conversor(medidaBase, medidaFinal, valorAConvertir);

                System.out.println(resultado);

                conversorTemperatura.Output(valorAConvertir, medidaBase, medidaFinal, resultado);

            };

            utilidades.finalizarPrograma("¿Deseas realizar otra conversión?");
            
        }

    }
}