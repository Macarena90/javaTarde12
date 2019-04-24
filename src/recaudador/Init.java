package recaudador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Date;
import sensorclima.TipoClima;
import sensorvelocidad.DatosVehiculo;

public class Init {
    public static EvaluadorEmisionActa generarTodosLosServicios() {
        RepositorioDeTexto repoTexto = new RepositorioDeTexto("c:\\tickets");
        GrabadorDeTicketEnTexto grabadorTicketTexto = new GrabadorDeTicketEnTexto(repoTexto);
        GrabadorDeTicketEnSQL grabadorTicketSql = new GrabadorDeTicketEnSQL();
        GrabadorDeTicketTextoMasSQL grabadorDeTicketTextoMasSQL = new GrabadorDeTicketTextoMasSQL(grabadorTicketTexto, grabadorTicketSql);
        
        EvaluadorEmisionActa evaluador = new EvaluadorEmisionActa(grabadorDeTicketTextoMasSQL);
        
        return evaluador;
    }
    public static void main(String[] args) throws Exception {
        /*
        sensorclima.Sensor sensorClima = new sensorclima.Sensor();
        sensorvelocidad.Sensor sensorVelocidad = 
                new sensorvelocidad.Sensor();
        
        DatosVehiculo datosvehiculo = null;
        EvaluadorEmisionActa evaluador = generarTodosLosServicios();
        for (;;) {
            datosvehiculo = sensorVelocidad.sensarVehiculo();
            System.out.println(datosvehiculo);
        
            evaluador.evaluar(TipoClima.NORMAL, new Date(2019,04,17), datosvehiculo);
        }
        */
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection conn = DriverManager.getConnection(
            "jdbc:mysql://localhost/actas?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                "root","");
        
        conn.close();
        
    }
}
