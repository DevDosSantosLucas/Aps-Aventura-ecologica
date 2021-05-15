package interfaceUI;


import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import modelo.Pontos;

public class Instrucao extends JFrame {
		
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
		private JScrollPane scroll;
		private JPanel paineldeInstrucao;
		
		@SuppressWarnings("unused")
		private Menu menu;
		@SuppressWarnings("unused")
		private int modoDeTela;
		
		public JRadioButton btnFacil,btnMedio,btnDificil,
							btnMouse,btnTeclado;
		private ButtonGroup btnEscolheNivel,btnEscolheFuncao;
		
		private JButton btnOkNivel,btnVoltar;
		private ImageIcon imgVoltar,
		lixoOrganico= new ImageIcon(getClass().getResource
				("../ASSETS/Imagens-tipos-lixos/lixoFechadoOrganico.png")),
		lixoPapel= new ImageIcon(getClass().getResource
				("../ASSETS/Imagens-tipos-lixos/lixoFechadoPapel.png")),

		lixoPlastico= new ImageIcon(getClass().getResource
				("../ASSETS/Imagens-tipos-lixos/lixoFechadoPlastico.png")),
		lixoVidro= new ImageIcon(getClass().getResource
				("../ASSETS/Imagens-tipos-lixos/lixoFechadoVidro.png")),
		lixoMetal= new ImageIcon(getClass().getResource
				("../ASSETS/Imagens-tipos-lixos/lixoFechadoMetal.png")),
		lixoNaoReciclavel= new ImageIcon(getClass().getResource
				("../ASSETS/Imagens-tipos-lixos/lixoFechadoNaoReciclaveis.png"));
	
		
		JLabel lbTitulo;

		Pontos pontos;Jogo jogo; int resultado;
		
		public Instrucao() {
			
			getContentPane().setLayout(null);
			
			paineldeInstrucao = new JPanel();
			paineldeInstrucao.setLayout(new GridLayout(6, 2));
			scroll = new JScrollPane(paineldeInstrucao,
					JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			
			
			
			scroll.setBounds(260,140,420,400);
		
			
		    imgVoltar = new ImageIcon(getClass().getResource
					("../assets/iconeVoltar.png"));
		    btnVoltar = new JButton("voltar");
		    btnVoltar.setIcon(imgVoltar);
		    btnVoltar.setContentAreaFilled(false);
		    btnVoltar.setBounds(20,10,80,90);
		    btnVoltar.setActionCommand("mVoltar");
		    imgVoltar.setImage(imgVoltar.getImage()
					.getScaledInstance(btnVoltar.getWidth(), 
							btnVoltar.getHeight(),1));
		    

		    lbTitulo = new JLabel("<html>Instrução</html>");
		    lbTitulo.setForeground(Color.DARK_GRAY);
		    lbTitulo.setBounds(200,10,400,90);
		    lbTitulo.setFont(new Font("Algerian", Font.BOLD,50));
		    
		    JLabel lbDescricao = new JLabel(
		    		"<html>"
		    		+ "<p>Este Jogo é focado na<br> "
		    		+ "educação ambiental,<br>"
		    		+ "ensinando aos jogadores<br>"
		    		+ "qual lixo correto para <br>"
		    		+ "poder descartar o produto <br>"
		    		+ "desejado! <br>"
		    		+ "Veja ao lado os lixos e <br>"
		    		+ "entenda as cores de cada <br>"
		    		+ "um, depois divirta-se<br>"
		    		+ "jogando.<br><br>"
		    		+ "DICA: AO APARECE AS <br>"
		    		+ "IMAGENS ALEATÓRIAS,<br>"
		    		+ "BASTA CLICAR NO LIXO <br>"
		    		+ "QUE CORRESPONDE A <br>"
		    		+ "IMAGEM! </p>"
		    		+ "</html>");
//		    lbTitulo.setForeground(Color.);
		    lbDescricao.setBounds(5,100,420,400);
		    lbDescricao.setFont(new Font("Arial", Font.BOLD,20));
		    
		    
		    
		    getContentPane().add(btnVoltar);
			getContentPane().add(lbTitulo);
			getContentPane().add(lbDescricao);
			getContentPane().add(scroll);
			
			

			
//					paineldeInstrucao.setBounds(50,50,1000,1000);
			
//			this.setContentPane(lixos());
//			paineldeInstrucao.add(lbImgOrganico);
			
			
			
			
			JLabel lbImgOrganico = new JLabel(lixoOrganico);
			lbImgOrganico.setBounds(0,0,200,200);
			lixoOrganico.setImage(lixoOrganico.getImage()
					.getScaledInstance(lbImgOrganico.getWidth(), lbImgOrganico.getHeight(),1));	// redimenciona a imagem
			JLabel lbOrganico = new JLabel(
							"<html>"
							+ "<h1>lixo Organico</h1>"
							+ "<p>este lixo é representado pela<br>"
							+ "cor MARROM para descarte de <br>"
							+ "restos de comidas organicas.</p>"
							+ "</html>");
			
			JLabel lbImgPapel = new JLabel(lixoPapel);
			lbImgPapel.setBounds(0,0,200,200);
			lixoPapel.setImage(lixoPapel.getImage()
					.getScaledInstance(lbImgPapel.getWidth(), lbImgPapel.getHeight(),1));	// redimenciona a imagem
			JLabel lbPapel = new JLabel(
							"<html>"
							+ "<h1>lixo Papel</h1>"
							+ "<p>este lixo é representado pela<br>"
							+ "cor AZUL para descarte de <br>"
							+ "qualquer tipo de papel.</p>"
							+ "</html>");
			
			JLabel lbImgPlastico = new JLabel(lixoPlastico);
			lbImgPlastico.setBounds(0,0,200,200);
			lixoPlastico.setImage(lixoPlastico.getImage()
					.getScaledInstance(lbImgPlastico.getWidth(), lbImgPlastico.getHeight(),1));	// redimenciona a imagem
			JLabel lbPlastico = new JLabel(
							"<html>"
							+ "<h1>lixo Plástico</h1>"
							+ "<p>este lixo é representado pela<br>"
							+ "cor VERMELHA para descarte <br>"
							+ "de produtos plásticos.</p>"
							+ "</html>");
			
			JLabel lbImgVidro = new JLabel(lixoVidro);
			lbImgVidro.setBounds(0,0,200,200);
			lixoVidro.setImage(lixoVidro.getImage()
					.getScaledInstance(lbImgVidro.getWidth(), lbImgVidro.getHeight(),1));	// redimenciona a imagem
			JLabel lbVidro = new JLabel(
							"<html>"
							+ "<h1>lixo Vidro</h1>"
							+ "<p>este lixo é representado pela<br>"
							+ "cor VERDE para descarte de <br>"
							+ "produtos que contenha vidro.</p>"
							+ "</html>");
			
			JLabel lbImgMetal = new JLabel(lixoMetal);
			lbImgMetal.setBounds(0,0,200,200);
			lixoMetal.setImage(lixoMetal.getImage()
					.getScaledInstance(lbImgMetal.getWidth(), lbImgMetal.getHeight(),1));	// redimenciona a imagem
			JLabel lbMetal = new JLabel(
							"<html>"
							+ "<h1>lixo Metal</h1>"
							+ "<p>este lixo é representado pela<br>"
							+ "cor AMARELA para descarte de <br>"
							+ "produtos de metal.</p>"
							+ "</html>");
			
			JLabel lbImgNaoReciclavel = new JLabel(lixoNaoReciclavel);
			lbImgNaoReciclavel.setBounds(0,0,200,200);
			lixoNaoReciclavel.setImage(lixoNaoReciclavel.getImage()
					.getScaledInstance(lbImgNaoReciclavel.getWidth(), lbImgNaoReciclavel.getHeight(),1));	// redimenciona a imagem
			JLabel lbNaoReciclavel = new JLabel(
							"<html>"
							+ "<h1>lixo Não <br>Reciclável</h1>"
							+ "<p>este lixo é representado pela<br>"
							+ "cor CINZA para descarte de <br>"
							+ "produtos que não possa ser <br>reciclável.</p>"
							+ "</html>");
			
			
			
			paineldeInstrucao.add(lbImgOrganico);
			paineldeInstrucao.add(lbOrganico);
			paineldeInstrucao.add(lbImgPapel);
			paineldeInstrucao.add(lbPapel);
			paineldeInstrucao.add(lbImgPlastico);
			paineldeInstrucao.add(lbPlastico);
			paineldeInstrucao.add(lbImgVidro);
			paineldeInstrucao.add(lbVidro);
			paineldeInstrucao.add(lbImgMetal);
			paineldeInstrucao.add(lbMetal);
			paineldeInstrucao.add(lbImgNaoReciclavel);
			paineldeInstrucao.add(lbNaoReciclavel);
			
		}



		public void setListenerInstrucao(ActionListener listener) {
			btnVoltar.addActionListener(listener);
		}
		

	}



