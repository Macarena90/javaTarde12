package recaudador;

public class GrabadorDeTicketTextoMasSQL implements GrabadorDeTicket {
    private GrabadorDeTicketEnTexto grabadorDeTicketEnTexto;
    private GrabadorDeTicketEnSQL grabadorDeTicketEnSQL;

    public GrabadorDeTicketTextoMasSQL(GrabadorDeTicketEnTexto grabadorDeTicketEnTexto, GrabadorDeTicketEnSQL grabadorDeTicketEnSQL) {
        this.grabadorDeTicketEnTexto = grabadorDeTicketEnTexto;
        this.grabadorDeTicketEnSQL = grabadorDeTicketEnSQL;
    }

    public void grabar(Ticket ticket) {
        grabadorDeTicketEnTexto.grabar(ticket);
        grabadorDeTicketEnSQL.grabar(ticket);        
    }
    
}
