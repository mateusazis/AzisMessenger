import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConexaoServidor extends Conexao{
    
    private ServerSocket serverSocket;
    
    public ConexaoServidor(int porta, JanelaDeMsg j){
        super(j);
        try {
            serverSocket = new ServerSocket(porta);
        } catch (IOException ex) {
            Logger.getLogger(ConexaoServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected Socket obterSocket() {
        try {
            Socket resp = serverSocket.accept();
            return resp;
        } catch (IOException ex) {
            Logger.getLogger(ConexaoServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
