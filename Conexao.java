import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public abstract class Conexao implements Runnable{
    
    private JanelaDeMsg j;
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    
    public Conexao(JanelaDeMsg j){
        this.j = j;
    }
    
    protected abstract Socket obterSocket();
    
    public void inciarConexao(){
        try {
            j.informarInicioDeConexao();
            socket = obterSocket();
            System.out.println("Socket ok");
            output = new ObjectOutputStream(socket.getOutputStream());
            output.flush();
            System.out.println("Retorno output " + output);
            input = new ObjectInputStream(socket.getInputStream());
            System.out.println("Retorno input: " + input);
            j.informarConexaoCompleta();
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
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
                Object o = input.readObject();
                nova = (Mensagem)o;
                j.informarMensagemRecebida(nova);
            } catch (IOException ex) {
                Logger.getLogger(ConexaoServidor.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch(ClassNotFoundException e){
                e.printStackTrace();
            }
        }
    }
    
    public void enviarMensagem(Mensagem m){
        j.informarMensagemRecebida(m);
        try {
            output.writeObject(m);
            output.flush();
        } catch (IOException ex) {
            Logger.getLogger(ConexaoServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

//versão velha com Object streams
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
//import java.net.Socket;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//
//public abstract class Conexao implements Runnable{
//    
//    private JanelaDeMsg j;
//    private Socket socket;
//    private ObjectInputStream input;
//    private ObjectOutputStream output;
//    
//    public Conexao(JanelaDeMsg j){
//        this.j = j;
//    }
//    
//    protected abstract Socket obterSocket();
//    
//    public void inciarConexao(){
//        try {
//            j.informarInicioDeConexao();
//            socket = obterSocket();
//            j.informarConexaoCompleta();
//            input = new ObjectInputStream(socket.getInputStream());
//            output = new ObjectOutputStream(socket.getOutputStream());
//        } catch (IOException ex) {
//            Logger.getLogger(ConexaoServidor.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Thread inputThread = new Thread(this);
//        inputThread.start();
//    }
//    
//    //roda o loop de verificacao de recebimento de msgs
//    @Override
//    public void run(){
//        Mensagem nova;
//        while(true){
//            try {
//                if(input == null)
//                    input = new ObjectInputStream(socket.getInputStream());
//                nova = Mensagem.fromStream(input);
//                j.informarMensagemRecebida(nova);
//            } catch (IOException ex) {
//                Logger.getLogger(ConexaoServidor.class.getName()).log(Level.SEVERE, null, ex);
//            }            
//        }
//    }
//    
//    public void enviarMensagem(Mensagem m){
//        j.informarMensagemRecebida(m);
//        try {
//            if(output == null)
//                output = new ObjectOutputStream(socket.getOutputStream());
//            m.escrever(output);
//        } catch (IOException ex) {
//            Logger.getLogger(ConexaoServidor.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//}
