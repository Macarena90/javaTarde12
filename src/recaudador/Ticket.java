package recaudador;

import sensorvelocidad.DatosVehiculo;

public class Ticket {
    public String id;
    public int multa;
    public DatosVehiculo datosvehiculo;

    public Ticket(String id, int multa, DatosVehiculo datosvehiculo) {
        this.id = id;
        this.multa = multa;
        this.datosvehiculo = datosvehiculo;
    }
}
