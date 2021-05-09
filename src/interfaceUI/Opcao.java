package interfaceUI;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import modelo.Pontos;

public class Opcao extends JFrame {
	
	public static final int JOGO= 0;
	public static final int FIM_DE_JOGO = 1;
	public static final int RECORD = 2;
	public static final int INSTRUCAO = 3;
	public static final int SAIR = 4;
	
//	public static final boolean FACIL = false;
//	public static final int MEDIO = 6;
//	public static final int DIFICIL =7;
	
	private	ItemListener handler;
	private JPanel nivelDoJogo,painel;
	
	@SuppressWarnings("unused")
	private Menu menu;
	@SuppressWarnings("unused")
	private int modoDeTela;
	
	public JRadioButton btnFacil,btnMedio,btnDificil,
						btnMouse,btnTeclado;
	private ButtonGroup btnEscolheNivel,btnEscolheFuncao;
	
	private JButton btnOkNivel;
	
	private JLabel lbRecordeTotal, lbRecordeAtual;
	private JTextField tfRecordeTotal, tfRecordeAtual;
	Pontos pontos;Jogo jogo; int resultado;
	
	public Opcao(int modoDeTela) {
		this.modoDeTela = modoDeTela;
		
		
			switch(modoDeTela) {
			case JOGO:
				setSize(700,300);
				getContentPane().setBackground(Color.BLACK);
				this.getContentPane().setLayout(null);
				//this.setContentPane(nivelJogo());
				nivelJogo();				
				break;
				
			case FIM_DE_JOGO:
				setSize(800,500);
				getContentPane().setBackground(Color.BLACK);
				this.getContentPane().setLayout(null);
				//this.setContentPane(fimDoJogo());
				fimDoJogo();
				break;
			}
			
			
		}
	public void nivelJogo() {
//		nivelDoJogo = new JPanel();
		btnFacil = new JRadioButton("<html>#FÁCIL#<br> 4 LIXOS</html>",true);
	    btnMedio = new JRadioButton("<html>#MÉDIO#<br> 6 LIXOS</html>",false);
	    btnDificil = new JRadioButton("<html>#DIFÍCIL#<br> 9 LIXOS</html>",false);
	    btnMouse = new JRadioButton("<html>MOUSE</html>",true);
	    btnTeclado = new JRadioButton("<html>TECLADO</html>",false);
	    btnEscolheNivel = new ButtonGroup();
	    btnEscolheFuncao = new ButtonGroup();
	    btnOkNivel = new JButton("COMEÇAR");
	    
	    btnFacil.setBackground(Color.BLACK);
	    btnFacil.setForeground(Color.white);
	    btnFacil.setFont(new Font("Arial", Font.BOLD,28));
	    btnMedio.setBackground(Color.BLACK);
	    btnMedio.setForeground(Color.white);
	    btnMedio.setFont(new Font("Arial", Font.BOLD,28));
	    btnDificil.setBackground(Color.BLACK);
	    btnDificil.setForeground(Color.white);
	    btnDificil.setFont(new Font("Arial", Font.BOLD,28));
	    btnMouse.setForeground(Color.white);
	    btnMouse.setFont(new Font("Arial", Font.BOLD,28));
	    btnTeclado.setForeground(Color.white);
	    btnTeclado.setFont(new Font("Arial", Font.BOLD,28));
	 
	    
		btnFacil.setBounds(10,0,200,150);
		btnMedio.setBounds(250,0,200,150);
		btnDificil.setBounds(500,0,200,150);
		btnOkNivel.setBounds(500,200,100,50);
		btnOkNivel.setActionCommand("btnComecar");
		
		btnMouse.setBounds(10,100,200,100);
		btnTeclado.setBounds(250,100,200,100);
		
		
	    btnEscolheNivel.add(btnFacil);
	    btnEscolheNivel.add(btnMedio);
	    btnEscolheNivel.add(btnDificil);
	    btnEscolheNivel.add(btnOkNivel);
	    
	    add(btnFacil);
	    add(btnMedio);
	    add(btnDificil);
	    add(btnMouse);
	    add(btnTeclado);
	    add(btnOkNivel);
	   
	    
		btnFacil.addItemListener(handler);
		btnMedio.addItemListener(handler);
		btnDificil.addItemListener(handler);
		btnMouse.addItemListener(handler);
		btnTeclado.addItemListener(handler);
		
//		return painel;
	}

	public void fimDoJogo() {
		lbRecordeTotal= new JLabel("RECORDE:");
		lbRecordeTotal.setBounds(50,200,200,50);
		
		lbRecordeAtual= new JLabel("SEU RECORDE:");
		lbRecordeAtual.setBounds(50,400,200,50);
		
		tfRecordeTotal= new JTextField("0");
		tfRecordeTotal.setBounds(350,200,200,50);
		
		tfRecordeAtual= new JTextField("0");
		tfRecordeAtual.setBounds(350,400,200,50);
		
		add(lbRecordeTotal);
		add(lbRecordeAtual);
		add(tfRecordeTotal);
		add(tfRecordeAtual);
		
//		return painel;
//		pontuacaoDeAcertos();
//		JFrame frame = new JFrame();
//		 JOptionPane.showMessageDialog(frame,
//			        ">>NIVEIS: \n "
//			       +"FACIL:   VALOR \n "+resultado
//			       +"MÉDIO:   VALOR \n "
//			       +"DIFÍCIL: VALOR ", //mensagem
//			        "RECORDES", // titulo da janela 
//			        JOptionPane.INFORMATION_MESSAGE);
	}
	public void pontuacaoDeAcertos() {		
		
		
		pontos.calcular(Pontos.ACERTOU);
		pontos.setOperando(jogo.getCalcSolution());
		resultado = pontos.calcular(Pontos.ACERTOU);
		resultado =-1;
		jogo.setCalcSolution(resultado);
	}
	public void setListenerOpcao(ActionListener listener) {
		btnOkNivel.addActionListener(listener);
	}
	

}
