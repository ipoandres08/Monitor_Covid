import PackageDeClasses.obtenerClases;
import cargarregistros.CargarRegistros;
import cargarsintomas.CargarSintomas;
import monitor.Monitor;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {

        System.out.println("diagnostico");
        Monitor monitor = new Monitor();
        //monitor.monitorear();
        //System.out.println("resultado: " + monitor.getResultado());

        //CargarSintomas cargarInf = new CargarSintomas();
        //cargarInf.mostrarSintomas();
        //cargarInf.cargarSintoma();
        //cargarInf.mostrarSintomasFaseI();
    }

}
