package cargarregistros;

import monitor.Registro;
import monitor.Sintoma;
import monitor.Sintomas;

import java.io.*;
import java.util.Date;

public class CargarRegistros {

    private Sintomas sintomas;
    private Sintomas sintomasSelecionados;
    private Sintoma perdidaDeOlfato;
    private Sintoma temperaturaAlta;
    private Sintoma tosSeca;

    public CargarRegistros(Sintomas sintomas) {
        cargarRegistros();
        this.sintomas=sintomas;
        sintomasSelecionados = new Sintomas();
        cargarRegistro();
    }
    public void cargarRegistro() {
        /*
        perdidaDeOlfato = new Determinante("Perdida de olfato");
        temperaturaAlta = new Importante("Temperatura alta");
        tosSeca = new TomarEnCuenta("Tos seca");*/
        ConsolaRegistroSintomas cr = new ConsolaRegistroSintomas(sintomas,sintomasSelecionados);
        cr.cargarRegistrosConsola();
        guardar();

    }
    private void cargarRegistros(){
        try{
            File archivoDeSintomas = new File("../MonitorCovidV3/registros.txt");
            if(archivoDeSintomas.exists()){
                FileInputStream archivoLeido = new FileInputStream("../MonitorCovidV3/registros.txt");
                ObjectInputStream leerSintomas = new ObjectInputStream(archivoLeido);
                sintomasSelecionados = (Sintomas) leerSintomas.readObject();
                leerSintomas.close();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void guardar(){
        try{
            FileOutputStream archivoDeSintomas = new FileOutputStream("../MonitorCovidV3/registros.txt");
            ObjectOutputStream archivo = new ObjectOutputStream(archivoDeSintomas);
            archivo.writeObject(sintomasSelecionados);
            archivo.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public Registro getRegistro() {
        cargarRegistro();

        return new Registro(new Date(),sintomas);
    }

}
