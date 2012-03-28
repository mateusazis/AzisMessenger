import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.text.DefaultCaret;
public class Janela extends JFrame implements Runnable, JanelaDeMsg{

    private Conexao c;
    
    public Janela() {
        initComponents();
        buttonGroup1.add(radioButtonServidor);
        buttonGroup1.add(radioButtonCliente);
        DefaultCaret caret = (DefaultCaret)areaConversa.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoEndServidor = new javax.swing.JTextField();
        campoPorta = new javax.swing.JTextField();
        radioButtonServidor = new javax.swing.JRadioButton();
        radioButtonCliente = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        scrollPaneConversa = new javax.swing.JScrollPane();
        areaConversa = new javax.swing.JTextArea();
        scrollPaneNovaMsg = new javax.swing.JScrollPane();
        areaNovaMsg = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoNick = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Azis Messenger");

        jLabel1.setText("Endereço Servidor");

        jLabel2.setText("Porta");

        campoEndServidor.setEnabled(false);

        radioButtonServidor.setSelected(true);
        radioButtonServidor.setText("Servidor");
        radioButtonServidor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonServidorActionPerformed(evt);
            }
        });

        radioButtonCliente.setText("Cliente");
        radioButtonCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonClienteActionPerformed(evt);
            }
        });

        jButton1.setText("Conectar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        areaConversa.setColumns(20);
        areaConversa.setEditable(false);
        areaConversa.setRows(5);
        scrollPaneConversa.setViewportView(areaConversa);

        areaNovaMsg.setColumns(20);
        areaNovaMsg.setRows(5);
        scrollPaneNovaMsg.setViewportView(areaNovaMsg);

        jButton2.setText("ENVIAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Conversa");

        jLabel4.setText("Nick");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPaneConversa)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioButtonServidor)
                                    .addComponent(radioButtonCliente))
                                .addGap(134, 134, 134)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(scrollPaneNovaMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)))
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(campoNick, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoEndServidor, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoPorta, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(campoEndServidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(radioButtonServidor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioButtonCliente))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(campoNick, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(11, 11, 11)
                .addComponent(scrollPaneConversa, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPaneNovaMsg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void radioButtonClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonClienteActionPerformed
        campoEndServidor.setEnabled(true);
    }//GEN-LAST:event_radioButtonClienteActionPerformed

    private void radioButtonServidorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonServidorActionPerformed
        campoEndServidor.setEnabled(false);
    }//GEN-LAST:event_radioButtonServidorActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Mensagem msg = new Mensagem(campoNick.getText(), areaNovaMsg.getText());
        areaNovaMsg.setText("");
        c.enviarMensagem(msg);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Thread threadObtencaoConexao = new Thread(this);
        threadObtencaoConexao.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    //thread paralela de obtenção de socket
    @Override
    public void run(){
        int porta = Integer.parseInt(campoPorta.getText());
        if(radioButtonServidor.isSelected())
            c = new ConexaoServidor(porta, this);
        else
            c = new ConexaoCliente(campoEndServidor.getText(), porta, this);
        c.inciarConexao();
    }
    
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            
        }
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Janela().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaConversa;
    private javax.swing.JTextArea areaNovaMsg;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField campoEndServidor;
    private javax.swing.JTextField campoNick;
    private javax.swing.JTextField campoPorta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton radioButtonCliente;
    private javax.swing.JRadioButton radioButtonServidor;
    private javax.swing.JScrollPane scrollPaneConversa;
    private javax.swing.JScrollPane scrollPaneNovaMsg;
    // End of variables declaration//GEN-END:variables

    @Override
    public void informarMensagemRecebida(Mensagem m) {
        areaConversa.append(m.remetente + " diz:\n");
        areaConversa.append(m.conteudo + "\n");
    }

    @Override
    public void informarInicioDeConexao() {
        areaConversa.append("Conectando...\n");
    }

    @Override
    public void informarConexaoCompleta() {
        areaConversa.append("Conectado!\n");
    }
}
