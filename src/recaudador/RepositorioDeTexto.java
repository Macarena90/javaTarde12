package recaudador;

import java.io.FileWriter;

public class RepositorioDeTexto {
    private String pathTickets;

    public RepositorioDeTexto(String pathTickets) {
        this.pathTickets = pathTickets;
    }
    public void grabar(Ticket t) {
        // Lo ideal seria, tener una clase transformado
        // que me permite transformar a diferentes formatos
        String json = new com.google.gson.Gson().toJson(t);
        
        String nombreArchivo = pathTickets + "\\" + t.id;
        
        try {
            System.out.println("Voy a grabar el ticket t");
            FileWriter escritor = new FileWriter(nombreArchivo);
            escritor.write(json);
            escritor.flush();
            escritor.close();
        }
        catch (Exception ex) {
            System.out.println("Hubo un error zafo de la multa!!!");
        }
    }
}
