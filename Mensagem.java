import java.io.Serializable;

public class Mensagem implements Serializable{
    
    public String remetente, conteudo;
    
    public Mensagem(String remetente, String conteudo){
        this.remetente = remetente;
        this.conteudo = conteudo;
    }
}
