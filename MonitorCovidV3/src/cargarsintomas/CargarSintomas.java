package cargarsintomas;

import monitor.Sintoma;
import monitor.Sintomas;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.TreeSet;

public class CargarSintomas {

    private Sintomas sintomas;
    private TreeSet<Sintoma> ts;
    private Sintoma perdidaDeOlfato;
    private Sintoma temperaturaAlta;
    private Sintoma tosSeca;

    public CargarSintomas() {
        ts = new TreeSet<>();
        sintomas = new Sintomas();
        cargarSintomas();
        try {
            cargarSintoma();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void cargarSintoma() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
       /* perdidaDeOlfato = new Determinante("Perdida de olfato");
        temperaturaAlta = new Importante("Temperatura alta");
        tosSeca = new TomarEnCuenta("Tos seca");*/
        ConsolaCargarSintomas c = new ConsolaCargarSintomas(sintomas);
        c.cargarSintomasConsola();
        guardar();
    }

    public void cargarSintomas() {
        /*perdidaDeOlfato = new Determinante("Perdida de olfato");
        temperaturaAlta = new Importante("Temperatura alta");
        tosSeca = new TomarEnCuenta("Tos seca");*/
        try{
            File archivoDeSintomas = new File("../MonitorCovidV3/sintomas.txt");
            if(archivoDeSintomas.exists()){
                FileInputStream archivoLeido = new FileInputStream("../MonitorCovidV3/sintomas.txt");
                ObjectInputStream leerSintomas = new ObjectInputStream(archivoLeido);
                sintomas = (Sintomas) leerSintomas.readObject();
                leerSintomas.close();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void guardar(){
        try{
            FileOutputStream archivoDeSintomas = new FileOutputStream("../MonitorCovidV3/sintomas.txt");
            ObjectOutputStream archivo = new ObjectOutputStream(archivoDeSintomas);
            archivo.writeObject(sintomas);
            archivo.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Sintomas getSintomas() {
        return sintomas;
    }

    private void getNombresOrdenados(){
        Sintomas sinto = getSintomas();
        for( Sintoma s: sinto){
            ts.add(s);
        }
    }
    public void mostrarSintomasFaseI(){
        cargarSintomas();
        getNombresOrdenados();
        System.out.println("------------------------------");
        System.out.println("      Sintomas Cargados       ");
        System.out.println("------------------------------");
        for(Sintoma s : ts) {
            if(s.getClass().getName()== "sintomas.Primera_Fase"){
            System.out.println(s + "---> " + "Categoria: " + s.getClass().getName());
            }
        }
    }
    public void mostrarSintomasFaseII(){
        cargarSintomas();
        getNombresOrdenados();
        System.out.println("------------------------------");
        System.out.println("      Sintomas Cargados       ");
        System.out.println("------------------------------");
        for(Sintoma s : ts) {
            if(s.getClass().getName()== "sintomas.Segunda_Fase"){
                System.out.println(s + "---> " + "Categoria: " + s.getClass().getName());
            }
        }
    }

}
