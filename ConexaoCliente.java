
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexaoCliente extends Conexao {

    private String nomeServ;
    private int porta;
    
    public ConexaoCliente(String nomeServidor, int porta, JanelaDeMsg j){
        super(j);
        this.nomeServ = nomeServidor;
        this.porta = porta;
    }

    @Override
    protected Socket obterSocket() {
        Socket resp = null;
        try {
            resp = new Socket(nomeServ, porta);
        } catch (UnknownHostException ex) {
            Logger.getLogger(ConexaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConexaoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resp;
    }

}
