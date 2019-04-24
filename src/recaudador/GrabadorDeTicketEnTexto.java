package recaudador;

public class GrabadorDeTicketEnTexto implements GrabadorDeTicket {
    private RepositorioDeTexto repositorioDeTexto;

    public GrabadorDeTicketEnTexto(RepositorioDeTexto repositorioDeTexto) {
        this.repositorioDeTexto = repositorioDeTexto;
    }    
    public void grabar(Ticket ticket) {
        repositorioDeTexto.grabar(ticket);
    }
}
