import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mensagem{
    
    public String remetente, conteudo;
    
    public Mensagem(String remetente, String conteudo){
        this.remetente = remetente;
        this.conteudo = conteudo;
    }
    
    public void escrever(DataOutputStream s){
        try {
            s.writeUTF(remetente);
            s.writeUTF(conteudo);
        } catch (IOException ex) {
            Logger.getLogger(Mensagem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Mensagem fromStream(DataInputStream s){
        String r;
        try {
            r = s.readUTF();
            String c = s.readUTF();
            return new Mensagem(r, c);
        } catch (IOException ex) {
            Logger.getLogger(Mensagem.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
