package recaudador;

public class GrabadorMock implements GrabadorDeTicket {
    private boolean llamoaGrabar = false;
    
    public void grabar(Ticket ticket) {
        llamoaGrabar = true;
    }
    public boolean isLlamoaGrabar() {
        return llamoaGrabar;
    }
}
