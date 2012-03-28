import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class Conexao implements Runnable{
    
    private JanelaDeMsg j;
    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output;
    
    public Conexao(JanelaDeMsg j){
        this.j = j;
    }
    
    protected abstract Socket obterSocket();
    
    public void inciarConexao(){
        try {
            j.informarInicioDeConexao();
            socket = obterSocket();
            j.informarConexaoCompleta();
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ConexaoServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        Thread inputThread = new Thread(this);
        inputThread.start();
    }
    
    //roda o loop de verificacao de recebimento de msgs
    @Override
    public void run(){
        Mensagem nova;
        while(true){
            try {
                if(input == null)
                    input = new DataInputStream(socket.getInputStream());
                nova = Mensagem.fromStream(input);
                j.informarMensagemRecebida(nova);
            } catch (IOException ex) {
                Logger.getLogger(ConexaoServidor.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }
    
    public void enviarMensagem(Mensagem m){
        j.informarMensagemRecebida(m);
        try {
            if(output == null)
                output = new DataOutputStream(socket.getOutputStream());
            m.escrever(output);
        } catch (IOException ex) {
            Logger.getLogger(ConexaoServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
