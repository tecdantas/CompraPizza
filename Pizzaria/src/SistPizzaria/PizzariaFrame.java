package SistPizzaria;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicTabbedPaneUI.MouseHandler;
import sun.security.util.SecurityConstants.AWT;

public class PizzariaFrame extends JFrame { // Inicio da classe pizzaria frame.

    private JLabel pedidoTitulo;
    private JLabel nomeCliente, sobreCliente;
    private JLabel endCliente;
    private JLabel telCliente;
    private JLabel obs1, obs2, obs3;
    private JTextField nome_Cliente, sobre_Cliente;
    private JTextField end_Cliente;
    private JTextField tel_Cliente;
    private JLabel lbLogo;
    private JLabel lbPedido; //Atributo para pedido
    private JLabel lbTamanho;//Atributo par o tamanho da pizza;
    private JLabel lbBorda;//Atributo para borda da pizza
    private JLabel lbBebida;
    private JComboBox cbPedido; //Atributo para criar um combo box com a lista de pizzas
    private JComboBox cbBebida; //Atributo para lista de bebidas;
    private JLabel lbFatura; //Atributo para label fatura
//Atributo para tamanho da pizza;
    private JCheckBox cbPequeno;
    private JCheckBox cbMediom;
    private JCheckBox cbGrande;
    private JCheckBox cbGigante;//Gigante.
    private JRadioButton rbCartao;//Atributo pagamento no cartão.
    private JRadioButton rbDinheiro;// Atributo para pagamento no dinheiro.
    //Atributo para bordas da pizza
    private JRadioButton rbChedda;// chedda
    private JRadioButton rbPratto;// pratto
    private JRadioButton rbSuico;// suiço
    private JRadioButton rbCatupiry;// Catupiry
    private JRadioButton rbNenhuma;// Sem bordas
    private ButtonGroup bgTamanho; // Atributo para criar um gerente nos radio button
    private JButton btConfirmar; //Criar botão Confirmar
    private JButton btLimpar;// Criar botão Limpar
    private double valorportamanho;
    private ButtonGroup btborda;
    private ButtonGroup fPagamento;
    String relatoriopizza;
    private ButtonGroup btpagamento;
    private final String[] nomes_Pizza = {"Mussarela", "Calebresa", "Portuguesa", "Margherita",
        "Toscana", "Lombo", "Napolitana", "Frango Catupity"}; //Vetor com o nome das pizzas cadastradas no sistemas
    private final String bebida[] = {"Cocacola 350mL - R$ 4,50", "Guaraná 350mL -  R$ 3,50", "Fanta Laranja/Uva 350mL - R$ 3,50",
        "Cerveja Heineken 500mL - R$ 7,50", "Cerveja Budweiser 500mL - R$ 7,50", "Cerveja Skol - 800mL - R$ 1,99", "Nenhuma bebida"};
    private JLabel lbresultado;

    String sabordapizza = "", tamanhopizza = "", formapagamento = "", bebidaVendida = "", nomeBorda = "";

    double valorPizza = 0;
    double valorBebida = 0;
    double valorBorda = 0;
// atributos para tipos de bebida existente

    public PizzariaFrame() { //Inicio do construtor
        super("Sistema para pedido de pizza"); // Ivocando a super classe
        setLayout(null);//Configuração do Layout
        //setLayout(new FlowLayout());
        //Entrada ent = new Entrada();

        Icon img = new ImageIcon(getClass().getResource("pizza_desenho.jpeg")); // Cria um icone
        lbLogo = new JLabel();// Cria um label para imagem
        lbLogo.setIcon(img);// Adiciona a imagem ao label
        lbLogo.setToolTipText("Pizzaria BomSabor, a melhor pizza de Brasilia.");// Mostra uma dica
        lbLogo.setBounds(50, 10, 300, 200);// Configura  o label ao frame
        add(lbLogo);// Adiciona o lagel ao frame.

        pedidoTitulo = new JLabel(" ***  PEDIDO  *** "); // Cria o label para escolha o seu pedido
        pedidoTitulo.setFont(new Font("Verdana", 1, 16));//Formata a fonte do label para Verdana
        pedidoTitulo.setBounds(350, 30, 200, 20);// Configura o label no frame
        add(pedidoTitulo);// Adiciona o label ao frame

        obs1 = new JLabel("(Exemp.: Jao)"); // Cria o label para escolha o seu pedido
        obs1.setFont(new Font("Verdana", 1, 10));//Formata a fonte do label para Verdana
        obs1.setBounds(590, 90, 200, 20);// Configura o label no frame
        add(obs1);// Adiciona o label ao frame

        nomeCliente = new JLabel("Nome: "); // Cria o label para escolha o seu pedido
        nomeCliente.setFont(new Font("Verdana", 1, 11));//Formata a fonte do label para Verdana
        nomeCliente.setBounds(280, 90, 200, 20);// Configura o label no frame
        add(nomeCliente);// Adiciona o label ao frame

        nome_Cliente = new JTextField("Webert", 20); // Cria o label para escolha o seu pedido
        nome_Cliente.setFont(new Font("Verdana", 1, 11));//Formata a fonte do label para Verdana
        nome_Cliente.setBounds(380, 90, 200, 20);// Configura o label no frame
        add(nome_Cliente);// Adiciona o label ao frame

        sobreCliente = new JLabel("Sobrenome: "); // Cria o label para escolha o seu pedido
        sobreCliente.setFont(new Font("Verdana", 1, 11));//Formata a fonte do label para Verdana
        sobreCliente.setBounds(280, 125, 200, 20);// Configura o label no frame
        add(sobreCliente);// Adiciona o label ao frame

        sobre_Cliente = new JTextField("testedddddd", 50); // Cria o label para escolha o seu pedido
        sobre_Cliente.setFont(new Font("Verdana", 1, 11));//Formata a fonte do label para Verdana
        sobre_Cliente.setBounds(380, 125, 230, 20);// Configura o label no frame
        add(sobre_Cliente);// Adiciona o label ao frame

        endCliente = new JLabel("End: "); // Cria o label para escolha o seu pedido
        endCliente.setFont(new Font("Verdana", 1, 11));//Formata a fonte do label para Verdana
        endCliente.setBounds(280, 160, 200, 20);// Configura o label no frame
        add(endCliente);// Adiciona o label ao frame

        end_Cliente = new JTextField("Qr 500 conjunto 00 casa 00 ", 20); // Cria o label para escolha o seu pedido
        end_Cliente.setFont(new Font("Verdana", 1, 11));//Formata a fonte do label para Verdana
        end_Cliente.setBounds(380, 160, 230, 20);// Configura o label no frame
        end_Cliente.setVisible(true);
        add(end_Cliente);// Adiciona o label ao frame

        telCliente = new JLabel("Tel: "); // Cria o label para escolha o seu pedido
        telCliente.setFont(new Font("Verdana", 1, 11));//Formata a fonte do label para Verdana
        telCliente.setBounds(280, 190, 200, 20);// Configura o label no frame
        add(telCliente);// Adiciona o label ao frame

        tel_Cliente = new JTextField("61 33333333 ", 12); // Cria o label para escolha o seu pedido
        tel_Cliente.setFont(new Font("Verdana", 1, 11));//Formata a fonte do label para Verdana
        tel_Cliente.setBounds(380, 190, 120, 20);// Configura o label no frame
        tel_Cliente.setVisible(true);
        add(tel_Cliente);// Adiciona o label ao frame

        lbPedido = new JLabel("Escolha sua Pizza: "); // Cria o label para escolha o seu pedido
        lbPedido.setFont(new Font("Verdana", 1, 11));//Formata a fonte do label para Verdana
        lbPedido.setBounds(10, 220, 200, 20);// Configura o label no frame
        add(lbPedido);// Adiciona o label ao frame

        cbPedido = new JComboBox(nomes_Pizza);// Cria um combo box passando o vetor
        cbPedido.setMaximumRowCount(4);// Quantidade de icones a ser exibido
        //cbPedido.setSelectedItem(" ");//Informa com qual dos itens da lista quer comecar
        cbPedido.setToolTipText("Escolha aqui sua pizza");//Mostra uma dica da pizza a ser escolhida.
        cbPedido.setFont(new Font("Tahoma", 1, 11));// Formata o tipo de fonte do comboBox para Tahoma.
        cbPedido.setBounds(10, 244, 120, 20);//Configura a posição, altura largura do combo box
        add(cbPedido); // Adiciona um Combo box para mostra opções de Pizza;

        lbTamanho = new JLabel("Tamanho: ");// Cria o label tamanho;
        lbTamanho.setFont(new Font("Verdana", 1, 11));// Formata a fonte do label para TAHOMA
        lbTamanho.setBounds(280, 205, 100, 100);// Configura a posição do label tamanho ao frame.
        add(lbTamanho); // Adiciona o label tamanho ao frame

        cbPequeno = new JCheckBox("Pequena - 4 fatias R$ 25,00");//Cria o creck box
        cbPequeno.setBounds(280, 270, 200, 20); // Configura o check box no frame
        cbPequeno.setFont(new Font("Tahoma", 1, 11));
        add(cbPequeno);// Adiciona o check box pequeno ao frame

        cbMediom = new JCheckBox("Media -  8 fatias R$ 37,00");// Cria um check box
        cbMediom.setBounds(500, 270, 200, 20);// configura o check box ao frame
        cbMediom.setFont(new Font("Tahoma", 1, 11));
        add(cbMediom);// Adiciona o check box ao frame

        cbGrande = new JCheckBox("Grande - 12 fatias R$ 42,00");// Cria um check box
        cbGrande.setBounds(280, 295, 200, 20);//Configura o check box no frame
        cbGrande.setFont(new Font("Tahoma", 1, 11));
        add(cbGrande);// Adiciona um CheckBox para tamanho da Pizza grande

        cbGigante = new JCheckBox("Gigante - 16 fatias R$ 49,00"); // Cria um check box
        cbGigante.setBounds(500, 295, 200, 20);// Configura  o check box ao frame
        cbGigante.setFont(new Font("Tahoma", 1, 11));
        add(cbGigante);//Adiciona check box ao frame

        bgTamanho = new ButtonGroup();// Cria um gerente para o radio button
        bgTamanho.add(cbPequeno);// adiciona o tamanho pequeno ao gerente
        bgTamanho.add(cbMediom);// adiciona o tamanho medio ao gerente
        bgTamanho.add(cbGrande);// adiciona o tamanho grande ao gerente
        bgTamanho.add(cbGigante);// adiciona o tamanho gigante ao gerente

        lbBorda = new JLabel("Escolha a Borda: "); //Cria um label para borda.
        lbBorda.setBounds(280, 325, 149, 20); //Configura  o label ao frame.
        lbBorda.setFont(new Font("Verdana", 1, 11));
        add(lbBorda);//Adiciona ao Frame.

        rbChedda = new JRadioButton("Queijo Cheddar - R$ 2,00", false); // Cria um RadioButton
        rbChedda.setBounds(400, 325, 165, 20);// Configura o Radio button no frame
        rbChedda.setFont(new Font("Tahoma", 1, 11));
        add(rbChedda);// Adiciona o radio no frame;

        rbPratto = new JRadioButton("Queijo Pratto - R$ 2,00", false);// Cria um RadioButton
        rbPratto.setBounds(400, 350, 164, 20);// Configura o RadioButton no frame
        rbPratto.setFont(new Font("Tahoma", 1, 11));
        add(rbPratto);// Adiciona o radio no frame;

        rbSuico = new JRadioButton("Queijo Suiço - R$ 2,00", false); // Cria um RadioButton
        rbSuico.setBounds(400, 375, 164, 20);// Configura o RadioButton no frame
        rbSuico.setFont(new Font("Tahoma", 1, 11));
        add(rbSuico);//Adiciona o Radiobutton 

        rbCatupiry = new JRadioButton("Catupiry - R$ 2,00", false);// Cria um radio button.
        rbCatupiry.setBounds(400, 400, 164, 20);// Configura o radio button no frame.
        rbCatupiry.setFont(new Font("Tahoma", 1, 11));
        add(rbCatupiry); //Adiciona o radio Button no frame

        rbNenhuma = new JRadioButton("Sem Bordas", false); // Cria um radio Botton
        rbNenhuma.setBounds(400, 425, 164, 20);// Configura o radio Button no frame
        rbNenhuma.setFont(new Font("Tahoma", 1, 11));
        add(rbNenhuma);// Adicionao  radio Button ao frame.

        btborda = new ButtonGroup();//responsável por deixar os eventos mutualmente exclusivos
        btborda.add(rbChedda);
        btborda.add(rbPratto);
        btborda.add(rbSuico);
        btborda.add(rbNenhuma);
        btborda.add(rbCatupiry);

        lbBebida = new JLabel("Escolha a sua bebida: "); // Cria um label 
        lbBebida.setBounds(10, 280, 140, 20);//Configura o label bebidas no frame
        lbBebida.setFont(new Font("Verdana", 1, 11));
        add(lbBebida);// Adiciona o label ao frame
        lbFatura = new JLabel("Pagamento: ");// Cria um label para Fatura
        lbFatura.setFont(new Font("Verdana", 1, 11));
        lbFatura.setBounds(280, 220, 140, 20);//Configura o label no frame.
        add(lbFatura);//Adiciona o label no frame.
//
        rbDinheiro = new JRadioButton("Dinheiro"); //Cria um Check box.
        rbDinheiro.setFont(new Font("Tahoma", 1, 11));
        rbDinheiro.setBounds(400, 220, 100, 20);//Configura o label no frame
        add(rbDinheiro);// Adiciona o check Box no fram

        rbCartao = new JRadioButton("Cartão");//Cria o radio button no frame
        rbCartao.setFont(new Font("Tahoma", 1, 11));
        rbCartao.setBounds(500, 220, 100, 20);//Configura o radio button no frame
        add(rbCartao);//Adiciona radio button no frame
        btpagamento = new ButtonGroup();
        btpagamento.add(rbDinheiro);
        btpagamento.add(rbCartao);

        btConfirmar = new JButton("Confirmar");//Criar Botão Confirmar
        btConfirmar.setToolTipText("Botão com a função de confirmar o pedido.");//Mostra uma dica da função do botão
        btConfirmar.setFont(new Font("Verdana", 1, 11));

        btConfirmar.setBounds(220, 500, 100, 30);
        add(btConfirmar);//Adiciona o botão no frame

        btLimpar = new JButton("Limpar");// Criar botão Limpar
        btLimpar.setToolTipText("Botão com a função de limpar campos prenchimento.");//Mostra um dica da função do botão
        btLimpar.setFont(new Font("Verdana", 1, 11));
        btLimpar.setBounds(400, 500, 100, 30);
        add(btLimpar);//Adiciona o botão ao frame

        cbBebida = new JComboBox(bebida); //Adiciona um Lista para opções de bebida
        cbBebida.setMaximumRowCount(3); // Quantidade de icones a ser exibido
        //ltBebida.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        cbBebida.setToolTipText("Escolha aqui sua bebida");
        cbBebida.setFont(new Font("Tahoma", 1, 11));
        cbBebida.setBounds(10, 300, 200, 30);
        add(cbBebida);

        CheckHandler handler1 = new CheckHandler();//Escutador explicito dos checkBox
        cbPedido.addItemListener(handler1);//passa os elementos para escutador para execução de tratamento
        cbPequeno.addItemListener(handler1);
        cbMediom.addItemListener(handler1);
        cbGrande.addItemListener(handler1);
        cbGigante.addItemListener(handler1);
        rbChedda.addItemListener(handler1);
        rbPratto.addItemListener(handler1);
        rbSuico.addItemListener(handler1);
        rbNenhuma.addItemListener(handler1);
        rbCatupiry.addItemListener(handler1);
        cbBebida.addItemListener(handler1);
        rbDinheiro.addItemListener(handler1);
        rbCartao.addItemListener(handler1);
        //  ListFrameHandler handler2=new ListFrameHandler();
        // ltBebida.addListSelectionListener(handler2);
        Escutador handler = new Escutador();
        btConfirmar.addActionListener(handler);//encaminha para tratamento
        btLimpar.addActionListener(handler);
        //add(new JScrollPane(ltBebida));// Cria um Scroll de Rolagem
        rbDinheiro.setSelected(true);
    }// Fim do construtor

    private class CheckHandler implements ItemListener {//classe interna para tratamento

        @Override
        public void itemStateChanged(ItemEvent event) {//Método que trata os eventos

            if (cbPequeno.isSelected()) {
                valorPizza = 25.00;
                tamanhopizza = "Pizza: Pequena";
            } else if (cbMediom.isSelected()) {
                valorPizza = 37.00;
                tamanhopizza = "Pizza: Média";
            } else if (cbGrande.isSelected()) {
                valorPizza = 42.00;
                tamanhopizza = "Pizza: Grande";
            } else if (cbGigante.isSelected()) {
                valorPizza = 49.00;
                tamanhopizza = "Pizza: Gigante";
            }

            valorBorda = 0.00;
            nomeBorda = "";
            if (event.getSource() == rbChedda || event.getSource() == rbPratto || event.getSource() == rbSuico || event.getSource() == rbCatupiry) {
                if (event.getSource() == rbChedda) {
                    nomeBorda = "Queijo Cheddar";
                } else if (event.getSource() == rbPratto) {
                    nomeBorda = "Queijo Pratto";
                } else if (event.getSource() == rbSuico) {
                    nomeBorda = "Queijo Suiço";
                } else if (event.getSource() == rbCatupiry) {
                    nomeBorda = "Catupiry";
                } else if (event.getSource() == rbNenhuma) {
                    nomeBorda = "Sem Bordas";
                }

                valorBorda = 2.00;

            } else {
                valorBorda = 0.00;
            }

            if (event.getStateChange() == ItemEvent.SELECTED) {//verifica se algum item foi selecionado
                if (cbPedido.getSelectedIndex() == 0) {
                    sabordapizza = "Sabor: Mussarela";
                }
                if (cbPedido.getSelectedIndex() == 1) {
                    sabordapizza = "Sabor: Calabresa";
                }
                if (cbPedido.getSelectedIndex() == 2) {
                    sabordapizza = "Sabor: Portuguesa";
                }
                if (cbPedido.getSelectedIndex() == 3) {
                    sabordapizza = "Sabor: Margherita";
                }
                if (cbPedido.getSelectedIndex() == 4) {
                    sabordapizza = "Sabor: Toscana";
                }
                if (cbPedido.getSelectedIndex() == 5) {
                    sabordapizza = "Sabor: Lombo";//configura sabor de acordo com o item selecionado
                }
                if (cbPedido.getSelectedIndex() == 6) {
                    sabordapizza = "Sabor: Napolitana";
                }
                if (cbPedido.getSelectedIndex() == 7) {
                    sabordapizza = ("Sabor: Frango com Catupiry");//Configura sabor da pizza
                }
            }
            valorBebida = 0.00;

            if (cbBebida.getSelectedIndex() == 0) {
                valorBebida = 4.50;
                bebidaVendida = "Bebida: Coca-cola";//concatena a string com elemento escolhido
            }
            if (cbBebida.getSelectedIndex() == 1 || cbBebida.getSelectedIndex() == 2) {
                valorBebida = 3.50;//preço bebida
                if (cbBebida.getSelectedIndex() == 1) {
                    bebidaVendida = "Bebida: Guaraná";
                } else if (cbBebida.getSelectedIndex() == 2) {
                    bebidaVendida = " Bebida: Fanta";
                }
                //concatena a string com elemento escolhido
            }
            if (cbBebida.getSelectedIndex() == 3 || cbBebida.getSelectedIndex() == 4) {
                valorBebida = 7.50;//ambas as bebidas possuem o mesmo preço
                if (cbBebida.getSelectedIndex() == 3) {
                    bebidaVendida = "Bebida: Heineken";//concatena a string com elemento escolhido
                } else if (cbBebida.getSelectedIndex() == 4) {
                    bebidaVendida = "Bebida: Budweiser";//concatena a string com elemento escolhido
                }
            }
            if (cbBebida.getSelectedIndex() == 5) {//verifica o indice
                bebidaVendida = "Bebida: Cerveja Skol";//concatena a string com elemento escolhido
                valorBebida = 1.99;//grava o preço da bebida escohida
            }
            if (cbBebida.getSelectedIndex() == 6) {//verifica indice selecionado
                valorBebida = 0.00;
                bebidaVendida = "Nenhuma bebida";//concatena a string com elemento escolhido
            }
            valorportamanho = valorPizza + valorBorda + valorBebida;//soma para valorPizza da conta
//            String formapagamento = "";
            if (rbDinheiro.isSelected() == true) {//verifica se o evento está selecionado
                valorportamanho = valorportamanho;
                formapagamento = "Forma de pagamento: Dinheiro";//mensagem da forma de pagamento
            } else if (rbCartao.isSelected() == true) {
                valorportamanho = valorportamanho + 1.00;//acrescimo de um real
                formapagamento = "Forma de pagamento: Cartão";//mensagem da forma de pagamento
            } else if (rbDinheiro.isSelected() == false && rbCartao.isSelected() == false) {
                //JOptionPane.showMessageDialog(null, "Escolha uma forma de pagamento por gentileza.", "Campo vazio", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

//Escutador dos botoes
    private class Escutador implements ActionListener {// Inicio da classe Ecutador

        @Override
        public void actionPerformed(ActionEvent event) {// Inicio do metodo
            if (event.getSource() == btConfirmar) {//Confirma pedido mostrando relatório

                String nomeA = nome_Cliente.getText().toUpperCase().concat(" ");//.concat("Sobre nome aqui");
                String nomeB = sobre_Cliente.getText().toUpperCase();//.concat("Sobre nome aqui");
                String nomeC = nomeA.concat(nomeB);

                String endC = end_Cliente.getText();
                String telC = tel_Cliente.getText().trim(); //mostra o telefone sem espaços no começo ou no fim
                lbresultado = new JLabel();//label para resultado da operação
                lbresultado.setText("<html>"
                        + "Cliente: "
                        + nomeC
                        + "<br>" + "End.: "
                        + endC
                        + "<br>" + "Tel.: "
                        + telC
                        + "<br>" + "___________  Cupon Fiscal  _____________"
                        + "<br>" + tamanhopizza
                        + "<br>" + sabordapizza + " = R$" + valorPizza
                        + "<br>" + "Borda: " + nomeBorda + " = R$" + valorBorda
                        + "<br>" + bebidaVendida + " = R$" + valorBebida
                        + "<br>" + formapagamento
                        + "<br>" + "Total a pagar R$ : " + valorportamanho + "<html/>");
                add(lbresultado);

                JOptionPane.showMessageDialog(PizzariaFrame.this, lbresultado.getText(), "Resultado",
                        JOptionPane.PLAIN_MESSAGE);
            }
            if (event.getSource() == btLimpar) {
                btborda.clearSelection();//Limpa as seleções
                bgTamanho.clearSelection();
                btborda.clearSelection();
                cbBebida.setSelectedItem(null);
                
                //btpagamento.clearSelection();
                nome_Cliente.setText("");
                sobre_Cliente.setText("");
                end_Cliente.setText("");
                tel_Cliente.setText("");
            }
        }// Fim do metodo
    }// Fim da classe Escutador

}// Fim da calsse PizzariaFrame
