package SistPizzaria;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Acesso extends JFrame { // Inicio da classe subClasse Acesso

    private JLabel lbLogin; // Atributo para icone
    private JLabel lbNome;// Atributo para mostra no frame nome
    private JLabel lbSenha; // Atributo para mostra no frame senha;
    private JTextField tfNome;//Atributo para criar uma caixa de Texto;
    private JPasswordField pfSenha; //Atributo para criar um caixa de senha;
    private JButton btEntrar;// Atributo para criar um botão
    private JButton btCancelar;//Atributo para criar um botão

    public Acesso() { // Construtor passando uma String para a super Classe e todos os metodos
        super("Pizzaria BomSabor");// Invocando a super classe passando uma string.
        setLayout(null);
        getContentPane().setBackground(Color.DARK_GRAY);
        Icon img = new ImageIcon(getClass().getResource("Pizzaria_Login.jpg")); //Criação do icone de imagem
        //Icon img2 = new ImageIcon(getClass().getResource("login.jpg"));
        lbLogin = new JLabel(); // Criação de um label para icone;
        lbLogin.setIcon(img);//Passando o icone para o label;
        lbLogin.setBounds(107, 5, 90, 90);//Configura o icone no frame
        add(lbLogin); // Adicionar o label ao frame;

        lbNome = new JLabel("Nome: ");//Cria o label nome
        lbNome.setToolTipText("nome do usuario do sistema.");// Mostra uma dica
        lbNome.setFont(new Font("Verdana", 1, 11));
        lbNome.setForeground(Color.WHITE);
        lbNome.setBounds(52, 78, 100, 100);//Configura a posição x,y do label no frame
        add(lbNome);// adiciona o label ao frame
        tfNome = new JTextField("dantas", 10);//Cria uma caixa de texto
        tfNome.setToolTipText("Digite seu nome do usuario");//Mostra uma dica
        tfNome.setFont(new Font("Arial Black", 1, 11));
        tfNome.setBounds(99, 117, 100, 20);// configura a posição da caixa de texto no frame
        add(tfNome); //adiciona ao frame

        lbSenha = new JLabel("Senha: ");// Criação do label senha
        lbSenha.setToolTipText("Digite a sua senha.");// Mostra um dica
        lbSenha.setFont(new Font("Verdana", 1, 11));
        lbSenha.setForeground(Color.WHITE);
        lbSenha.setBounds(51, 111, 100, 100);//Configura a posição do label no frame
        add(lbSenha); //Adiciona ao frame  o label senha
        pfSenha = new JPasswordField("1234", 8); // Cria um caixa de senha
        pfSenha.setToolTipText("Digite sua senha.");//Mostra um dica ao usuario
        pfSenha.setBounds(100, 150, 100, 20);// configura a posição do da caixa de senha
        add(pfSenha);//adicciona uma caixa ao frame

        btEntrar = new JButton("Entrar");// Cria um botão entrar
        btEntrar.setToolTipText("Confirmar login");// Mostra um dica do que o botão faz
        btEntrar.setFont(new Font("Tahoma", 1, 11));
        btEntrar.setBounds(50, 200, 88, 30);//Configura a posição do botão entrar
        add(btEntrar);// adiciona o botão ao frame

        btCancelar = new JButton("Cancelar");//Cria um botão cancelar
        btCancelar.setToolTipText("Cancelar login");//Mostra um dica do que o botão cancelar faz
        btCancelar.setFont(new Font("Tahoma", 1, 11));
        btCancelar.setBounds(148, 200, 88, 30);//Configura a posição do botão cancelar
        add(btCancelar);//adiciona o botão cancelar ao frame;

        EscutadorHandler handler = new EscutadorHandler();
        tfNome.addActionListener(handler);
        pfSenha.addActionListener(handler);
        btEntrar.addActionListener(handler);
        btCancelar.addActionListener(handler);
        mouseHandler mouse = new mouseHandler();
        lbLogin.addMouseListener(mouse);
        lbLogin.addMouseMotionListener(mouse);

    } // fim do construtor

    private class EscutadorHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {// Inicio do metodo actionPerformed
            Icon img = new ImageIcon(getClass().getResource("Pizzaria_Login.jpg")); //Criação do icone de imagem
            Icon img1 = new ImageIcon(getClass().getResource("DantasFoto.jpg"));//Cria um icone de login para foto de perfil.
            Icon img2 = new ImageIcon(getClass().getResource("YasminFoto.jpg"));// Cria um icone de login para foto de perfil.
            Icon img3 = new ImageIcon(getClass().getResource("VictorFoto.jpg"));// Cria um icone de login para foro de perfil.
            PizzariaFrame objeto = new PizzariaFrame(); // Cria um objeto do classe Pizzaria Frame

            if (event.getSource() == btEntrar) {// Verifica se o botão entrar foi pressionado.
                if (tfNome.getText().isEmpty() && pfSenha.getText().isEmpty()) {/*Verifica se o campo nome e senha está vazio*/

                    JOptionPane.showMessageDialog(null, "Campos nome e senha, obrigatório.");/*Mostra uma mesagem.*/

                } else if (tfNome.getText().isEmpty()) {// Verifica se  o campo nome está vazio
                    JOptionPane.showMessageDialog(null, "Campo nome, obrigatório.");// Mostra uma messagem.
                } else if (pfSenha.getText().isEmpty()) {// Verifica se  o campo senha está vazio.
                    JOptionPane.showMessageDialog(null, "Campo senha, obrigatório.");// Mostra uma messagem.
                } else if (tfNome.getText().equalsIgnoreCase("dantas") && pfSenha.getText().equals("1234")) { // Verifica informações de login 
                    lbLogin.setIcon(img1);
                    add(lbLogin);
                    JOptionPane.showMessageDialog(null, "Acesso liberado.");// Mostra uma mesagem
                    objeto.setSize(800, 600);// Configura a largura e a altura do frame
                    objeto.setLocationRelativeTo(null);// Configura a posição do frame.Mstrando o no centro
                    objeto.setVisible(true);//Mostra o frame frame
                    objeto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Cria a opção de minimar maximizar e fechar o frame;
                    dispose();
                } else if (tfNome.getText().equalsIgnoreCase("yasmin") && pfSenha.getText().equals("4321")) { // Verifica informações de login 
                    lbLogin.setIcon(img2);// Adiciona a image ao label
                    add(lbLogin);// Adiciona o icone login
                    JOptionPane.showMessageDialog(null, "Acesso liberado.");//Mostra uma messagem

                    objeto.setSize(800, 600);// Configura a largura e a altura do frame
                    objeto.setLocationRelativeTo(null);// Configura a posição do frame.Mstrando o no centro
                    objeto.setVisible(true);//Mostra o frame frame
                    objeto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Cria a opção de minimar maximizar e fechar o frame;
                    dispose();
                } else if (tfNome.getText().equalsIgnoreCase("victor") && pfSenha.getText().equals("2468")) {// Verifica informações de login
                    lbLogin.setIcon(img3);
                    add(lbLogin);
                    JOptionPane.showMessageDialog(null, "Acesso liberado.");// Mostra uma messagem

                    objeto.setSize(800, 600);// Configura a largura e a altura do frame
                    objeto.setLocationRelativeTo(null);// Configura a posição do frame.Mstrando o no centro
                    objeto.setVisible(true);//Mostra o frame frame
                    objeto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Cria a opção de minimar maximizar e fechar o frame;
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "usuario ou senha incorretos.");// Mostra uma messagem caso informações estiver errada.
                }// fim do else

            }// fim do teste do botão entrar

            if (event.getSource() == btCancelar) {
                tfNome.setText("");// Limpar campo nome.
                pfSenha.setText("");//Limpar campo senha.
                lbLogin.setIcon(img);
                add(lbLogin);
            }

        }// fim do metodo
    }// fim da classe escutador

    private class mouseHandler implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            JOptionPane.showMessageDialog(null, "Bem vindo. Informe, seu nome de usuário e senha para entrar no sistema.");

        }

        @Override
        public void mouseExited(MouseEvent e) {
            JOptionPane.showMessageDialog(null, "Pizzaria BomSabor a melhor pizza de Brasilia.");
        }

        @Override
        public void mouseDragged(MouseEvent e) {
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            JOptionPane.showMessageDialog(null, "Movimento do mouse");
        }

    }

}// Fim da classe acesso
