package cargarregistros;

import cargarsintomas.CargarSintomas;
import monitor.Registros;
import monitor.Sintoma;
import monitor.Sintomas;

import java.util.*;

public class ConsolaRegistroSintomas {
    Sintomas sintomas;
    private TreeSet<Sintoma> ts;
    private int eleccion;
    private Sintomas listSintomasSeleccionados;
    public ConsolaRegistroSintomas(Sintomas sintomas,Sintomas listSintomasSeleccionados){
            this.sintomas=sintomas;
            ts = new TreeSet<>();
            this.listSintomasSeleccionados = listSintomasSeleccionados;
    }
    public void cargarRegistrosConsola(){
        System.out.println("-------Diagnostico--------");
        Scanner sc = new Scanner(System.in);
            getNombresOrdenados_();
            for (Sintoma s : ts) {
                    System.out.println("Tiene este Sintoma? -- (1.-Si  2.-No  3.-Salir)");
                    System.out.println(s);
                    eleccion = sc.nextInt();
                    if (eleccion == 1) {
                        listSintomasSeleccionados.add(s);
                       }else{if (eleccion==3){
                                    break;
                                }
                            }
                    }
    }
    private void getNombresOrdenados_(){
        for( Sintoma s: sintomas){
            ts.add(s);
        }
    }
}
