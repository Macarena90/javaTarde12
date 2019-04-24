package recaudador;

import java.util.Date;
import sensorclima.TipoClima;
import sensorvelocidad.DatosVehiculo;
import sensorvelocidad.TipoVehiculo;

public class EvaluadorEmisionActa {
    private GrabadorDeTicket grabadorDeTicket;

    public EvaluadorEmisionActa(GrabadorDeTicket grabadorDeTicket) {
        this.grabadorDeTicket = grabadorDeTicket;
    }
            
    public void evaluar(TipoClima clima, Date fecha, DatosVehiculo datosVehiculo) {
        Ticket ticket = new Ticket(
                java.util.UUID.randomUUID().toString(),
                0,
                datosVehiculo
        );
        
        // Aca es donde iria la logica para ver si corresponde
        // acta de transito.
        
        Boolean correspondeMulta = false;
        
	switch (datosVehiculo.tipoVehiculo) {
            case Auto:
                if ((datosVehiculo.velocidadMedida >= 130) && clima == TipoClima.NORMAL) {
                    correspondeMulta = true;
                    ticket.multa = 1000;
                }
                break;
            case Moto:
                break;
            case Tractor:
                break;
            case Camion:
                break;
        }
                    /*
			if (evauto >= 130 && evauto <=156 && clima == "normal") {
				System.out.println("El execeso de velocidad es mayor al 10% y menor al 20% -> Multa = $1000")}
			if (evauto > 156 && clima == "normal") {
				System.out.println("El exceso de velocidad suopera el 20% -> Multa = $2000") };
	 		if (evauto < 156 && clima == "normal") {System.outprintln("No corresponde ticket")};
		
		case "moto"
			if (evauto >= 130 && evauto <=156 && clima == "normal") {
				System.out.println("El execeso de velocidad es mayor al 10% y menor al 20% -> Multa = $1000")}
			if (evauto > 156 && clima == "normal") {
				System.out.println("El exceso de velocidad suopera el 20% -> Multa = $2000") };
	 		if (evauto < 156 && clima == "normal") {System.outprintln("No corresponde ticket")};

		case "camion"
			if (evauto >= 90 && evauto <=99 && clima == "normal") {
				System.out.println("El execeso de velocidad es mayor al 10% y menor al 20% -> Multa = $1000")}
			if (evauto > 99 && clima == "normal") {
				System.out.println("El exceso de velocidad suopera el 20% -> Multa = $2000") };
	 		if (evauto < 90 && clima == "normal") {System.outprintln("No corresponde ticket")};
		*/
        
                    
        if (correspondeMulta) {
            grabadorDeTicket.grabar(ticket);
        }
    }
}
