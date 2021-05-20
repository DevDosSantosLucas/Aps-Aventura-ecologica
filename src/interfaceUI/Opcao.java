package interfaceUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;


import modelo.Pontos;

public class Opcao extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final int JOGO= 0;
	public static final int FIM_DE_JOGO = 1;
	public static final int RECORD = 2;
	public static final int INSTRUCAO = 3;
	public static final int SAIR = 4;
	

	
	private	ItemListener handler;
	
	@SuppressWarnings("unused")
	private Menu menu;
	@SuppressWarnings("unused")
	private int modoDeTela;
	
	public JRadioButton btnFacil,btnMedio,btnDificil,
						btnMouse,btnTeclado;
	private ButtonGroup btnEscolheNivel;
	
	private JButton btnOkNivel;
	
	Pontos pontos;Jogo jogo; int resultado;
	
	public Opcao(int modoDeTela) {
		this.modoDeTela = modoDeTela;
		
		
			switch(modoDeTela) {
			case JOGO:
				setSize(700,300);
				getContentPane().setBackground(Color.BLACK);
				this.getContentPane().setLayout(null);
				nivelJogo();				
				break;
				
			case FIM_DE_JOGO:
				setSize(800,500);
				getContentPane().setBackground(Color.BLACK);
				this.getContentPane().setLayout(null);
				break;
			}
			
			
		}
	public void nivelJogo() {
		btnFacil = new JRadioButton("<html>#FÁCIL#<br> 4 LIXOS <br> 5 VIDAS </html>",true);
	    btnMedio = new JRadioButton("<html>#MÉDIO#<br> 6 LIXOS <br> 3 VIDAS</html>",false);
	    btnDificil = new JRadioButton("<html>#DIFÍCIL#<br> 6 LIXOS <br> 1 VIDA</html>",false);
	
	    btnEscolheNivel = new ButtonGroup();
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

		btnFacil.setBounds(10,0,200,150);
		btnMedio.setBounds(250,0,200,150);
		btnDificil.setBounds(500,0,200,150);
		btnOkNivel.setBounds(500,200,100,50);
		btnOkNivel.setActionCommand("btnComecar");
		
	    btnEscolheNivel.add(btnFacil);
	    btnEscolheNivel.add(btnMedio);
	    btnEscolheNivel.add(btnDificil);
	    btnEscolheNivel.add(btnOkNivel);
	    
	    add(btnFacil);
	    add(btnMedio);
	    add(btnDificil);

	    add(btnOkNivel);
	   
		btnFacil.addItemListener(handler);
		btnMedio.addItemListener(handler);
		btnDificil.addItemListener(handler);
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
