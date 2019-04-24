package recaudador;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sensorclima.TipoClima;
import sensorvelocidad.DatosVehiculo;
import sensorvelocidad.TipoVehiculo;

public class PruebaLogicaEvaluador {
    
    EvaluadorEmisionActa evaluadorEmisionActa;
    GrabadorMock grabadorMock;
    
    public PruebaLogicaEvaluador() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        grabadorMock = new GrabadorMock();
        evaluadorEmisionActa = new EvaluadorEmisionActa(grabadorMock);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void evaluarAutoConExcesoVelocidadDiaNormal() {        
        DatosVehiculo datosVehiculo = new DatosVehiculo();
        datosVehiculo.patente = "NO INTERESA";
        datosVehiculo.tipoVehiculo = TipoVehiculo.Auto;
        datosVehiculo.velocidadMedida = 130;
        
        evaluadorEmisionActa.evaluar(TipoClima.NORMAL, new Date(2019,04, 24), datosVehiculo);
        
        Assert.assertEquals(true, grabadorMock.isLlamoaGrabar());
    }
}
