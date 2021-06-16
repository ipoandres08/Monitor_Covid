package cargarsintomas;

import PackageDeClasses.obtenerClases;
import monitor.Sintoma;
import monitor.Sintomas;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class ConsolaCargarSintomas {
    private int eleccion;
    private int eleccion2;
    private Sintomas listaDeSintomas;
    private Scanner sc;
    //private Map<Integer, String> tiposSintomas;
    public ConsolaCargarSintomas(Sintomas listaDeSintomas){
        this.listaDeSintomas = listaDeSintomas;
        //tiposSintomas = new HashMap<>();
    }

    public void cargarSintomasConsola() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        sc = new Scanner(System.in);
        String nombre_Sintoma = "";
        boolean continuar = true;
        System.out.println("-----------------------------");
        System.out.println("Cargar Sintomas");
        System.out.println("Elija de que categoria es el Sintoma");

        obtenerClases pck = new obtenerClases();
        Class [] clases = pck.getClasses("sintomas");
        for(int i=0 ; i<clases.length;++i){
            System.out.println((i+1)+clases[i].getName().substring(clases[i].getName().indexOf("."),clases[i].getName().length()));
        }
        eleccion2 = sc.nextInt();
        while(continuar) {
            System.out.println("Nombre del Sintoma");
            sc.nextLine();
            nombre_Sintoma = sc.nextLine();
            nombre_Sintoma = nombre_Sintoma.toLowerCase();
            Class claseElegida = clases [eleccion2-1];
            Constructor<?>[] constructores = claseElegida.getConstructors();
            Constructor<?> constructor = constructores[0];
            Sintoma s = (Sintoma) constructor.newInstance(nombre_Sintoma);
            listaDeSintomas.add(s);

            System.out.println("Quiere agregar algun otro Sintoma?");
            System.out.println("1.-Si");
            System.out.println("2.-No");
            eleccion = sc.nextInt();
            if (eleccion == 1) {
                continuar = true;
            } else {
                continuar = false;
            }
        }
    }
}
