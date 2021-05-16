package interfaceUI;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import controle.Controle;

import modelo.Pontos;




@SuppressWarnings("serial")
public class Jogo extends JFrame  {
	
	
	public  static final int FACIL =0;
	public  static final int MEDIO = 1 ;
	public  static final int DIFICIL =2 ;
	
	
	
	public boolean mousePress = false,
					acertou = false,
					fimDoJogo = false,
					nFacil =false,
					nMedio = false,
					nDificil = false;
	Timer timer;
    public int porcentagem;
    public JProgressBar progressBarVida;
	
	public JButton 	btnImgLixo1, btnImgLixo2, btnImgLixo3, btnImgLixo4,
					btnImgLixo5, btnImgLixo6, btnImgLixo7, btnImgLixo8, btnImgLixo9;
	


	public ImageIcon imgObjeto ;
	
	public JButton  lbObjeto = null ;
	public  JLabel 	lbImg, 
					lbVidaCheia1 ,lbVidaVazia1,
					lbVidaCheia2 ,lbVidaVazia2,
					lbVidaCheia3 ,lbVidaVazia3,
					lbVidaCheia4 ,lbVidaVazia4,
					lbVidaCheia5 ,lbVidaVazia5;
	
	public JPanel painelJogo = null, painel = null;

	public JButton mnVoltarMenu,mnInstrucao,mnFechar;
				 
	private static JTextField tfRecorde,tfErrou;

	private Opcao opcao;
	private Jogo  jogo;
	private Controle ctrl= new Controle() ;
	public boolean play = false, function = false;
	@SuppressWarnings("unused")
	private int nivelDoJogo,nivel;
	private ImageIcon img = new ImageIcon(getClass().getResource("../ASSETS/fundoRua2.JPG"));
		//	ImageIcon imgFim = new ImageIcon(getClass().getResource("../ASSETS/fundoFim.JPG"));
//.....imagens do lixo aberto e fechado....\\
			private ImageIcon
		    imgVidaCheia = new ImageIcon(getClass().getResource
					("../assets/coracao-cheio.png")),
			imgVidaVazia= new ImageIcon(getClass().getResource
					("../ASSETS/coracao-vazio.png")),
			lixoOrganicoF= new ImageIcon(getClass().getResource
					("../ASSETS/Imagens-tipos-lixos/lixoFechadoOrganico.png")),
			lixoOrganicoA= new ImageIcon(getClass().getResource
					("../ASSETS/Imagens-tipos-lixos/lixoAbertoOrganico.png")),
			lixoPapelF= new ImageIcon(getClass().getResource
					("../ASSETS/Imagens-tipos-lixos/lixoFechadoPapel.png")),
			lixoPapelA= new ImageIcon(getClass().getResource
					("../ASSETS/Imagens-tipos-lixos/lixoAbertoPapel.png")),
			lixoPlasticoF= new ImageIcon(getClass().getResource
					("../ASSETS/Imagens-tipos-lixos/lixoFechadoPlastico.png")),
			lixoPlasticoA= new ImageIcon(getClass().getResource
					("../ASSETS/Imagens-tipos-lixos/lixoAbertoPlastico.png")),
			lixoVidroF= new ImageIcon(getClass().getResource
					("../ASSETS/Imagens-tipos-lixos/lixoFechadoVidro.png")),
			lixoVidroA= new ImageIcon(getClass().getResource
					("../ASSETS/Imagens-tipos-lixos/lixoAbertoVidro.png")),
			lixoMetalF= new ImageIcon(getClass().getResource
					("../ASSETS/Imagens-tipos-lixos/lixoFechadoMetal.png")),
			lixoMetalA= new ImageIcon(getClass().getResource
					("../ASSETS/Imagens-tipos-lixos/lixoAbertoMetal.png")),
			lixoNaoReciclaF= new ImageIcon(getClass().getResource
					("../ASSETS/Imagens-tipos-lixos/lixoFechadoNaoReciclaveis.png")),
			lixoNaoReciclaA= new ImageIcon(getClass().getResource
					("../ASSETS/Imagens-tipos-lixos/lixoAbertoNaoReciclaveis.png")),
			lixoPerigososF= new ImageIcon(getClass().getResource
					("../ASSETS/Imagens-tipos-lixos/lixoFechadoResiduosPerigosos.png")),
			lixoPerigososA= new ImageIcon(getClass().getResource
					("../ASSETS/Imagens-tipos-lixos/lixoAbertoResiduosPerigosos.png")),
			lixoMadeiraF= new ImageIcon(getClass().getResource
					("../ASSETS/Imagens-tipos-lixos/lixoFechadoMadeira.png")),
			lixoMadeiraA= new ImageIcon(getClass().getResource
					("../ASSETS/Imagens-tipos-lixos/lixoAbertoMadeira.png")),
			lixoSaudeF= new ImageIcon(getClass().getResource
					("../ASSETS/Imagens-tipos-lixos/lixoFechadoServiçosDeSaude.png")),
			lixoSaudeA= new ImageIcon(getClass().getResource
					("../ASSETS/Imagens-tipos-lixos/lixoAbertoServiçosDeSaude.png"));
			
			int resultado;
	
	public Jogo(int nivelDoJogo ) {
		this.nivelDoJogo = nivelDoJogo;
		
		
		
		switch (nivelDoJogo) {
		case FACIL:
			nFacil =true;
			this.setContentPane(getPainelDoJogoFacil());
			getContentPane().setLayout(null);
			this.setContentPane(getJogo(1));
			break;
			
		case MEDIO:
			nMedio = true;
			this.setContentPane(getPainelDoJogoMedio());
			getContentPane().setLayout(null);
			this.setContentPane(getJogo(2));
			break;
			
		case DIFICIL:
			nDificil = true;
			this.setContentPane(getPainelDoJogoDificil());
			getContentPane().setLayout(null);
			this.setContentPane(getJogo(3));
			break;
			
			
		}
		
	}
	
	public void posicaoDeVida() {
		
		
		lbVidaCheia1 = new JLabel();
		lbVidaCheia1.setIcon(imgVidaCheia);
		lbVidaCheia1.setBounds(50,0,50,50);
		painelJogo.add(lbVidaCheia1);
		
		lbVidaCheia2 = new JLabel();
		lbVidaCheia2.setIcon(imgVidaCheia);
		lbVidaCheia2.setBounds(100,0,50,50);
		painelJogo.add(lbVidaCheia2);
	
		lbVidaCheia3 = new JLabel();
		lbVidaCheia3.setIcon(imgVidaCheia);
		lbVidaCheia3.setBounds(150,0,50,50);
		painelJogo.add(lbVidaCheia3);
		
		lbVidaCheia4 = new JLabel();
		lbVidaCheia4.setIcon(imgVidaCheia);
		lbVidaCheia4.setBounds(200,0,50,50);
		painelJogo.add(lbVidaCheia4);
	
		lbVidaCheia5 = new JLabel();
		lbVidaCheia5.setIcon(imgVidaCheia);
		lbVidaCheia5.setBounds(250,0,50,50);
		painelJogo.add(lbVidaCheia5);
		
	}
	
	public int calcularVida(int operacao)  {
		switch (operacao) {

		case 8:
			lbVidaCheia5.setBounds(250,0,50,50);
			lbVidaCheia4.setBounds(200,0,50,50);
			lbVidaCheia3.setBounds(150,0,50,50);
			lbVidaCheia2.setBounds(100,0,50,50);
			lbVidaCheia1.setBounds(50,0,50,50);	
			System.out.println("caso8");
			break;	
		case 7:
			lbVidaCheia5.setBounds(0,0,0,0);
			lbVidaCheia4.setBounds(0,0,0,0);
			lbVidaCheia3.setBounds(150,0,50,50);
			lbVidaCheia2.setBounds(100,0,50,50);
			lbVidaCheia1.setBounds(50,0,50,50);	
			System.out.println("caso7");
			break;
		case 6:
			lbVidaCheia5.setBounds(0,0,0,0);
			lbVidaCheia4.setBounds(0,0,0,0);
			lbVidaCheia3.setBounds(0,0,0,0);
			lbVidaCheia2.setBounds(0,0,0,0);
			lbVidaCheia1.setBounds(50,0,50,50);	
			System.out.println("caso6");
			break;
		case 5:
			lbVidaCheia5.setBounds(250,0,50,50);
			System.out.println("caso5");
			break;	
		case 4:
			lbVidaCheia5.setBounds(0,0,0,0); 	
			System.out.println("caso4");
			break;	
		case 3:
			lbVidaCheia4.setBounds(0,0,0,0); 
			System.out.println("caso3");
			break;
		case 2:
			lbVidaCheia3.setBounds(0,0,0,0); 
			System.out.println("caso2");
			break;
		case 1:
			lbVidaCheia2.setBounds(0,0,0,0); 	
			System.out.println("caso1");
			break;
		case 0:
			System.out.println("caso0");
			lbVidaCheia1.setBounds(0,0,0,0);
			break;

		}
		return operacao;
	}
	
	

		public JPanel  getJogo(int nivel) {
			
			this.nivel = nivel;
			//MENU\\
			ImageIcon imgMenu = new ImageIcon(getClass().getResource("../ASSETS/iconeHome.png"));
			ImageIcon imgRecord = new ImageIcon(getClass().getResource("../ASSETS/iconeRecord.png"));
			ImageIcon imgFechar = new ImageIcon(getClass().getResource("../ASSETS/iconeFechar.png"));
			ImageIcon imgInstrucao = new ImageIcon(getClass().getResource("../ASSETS/iconeAjuda.png"));
			
					
			posicaoDeVida();

			mnVoltarMenu = new JButton();
			mnVoltarMenu.setIcon(imgMenu);
			mnVoltarMenu.setBounds(0,0,50,50);
			mnVoltarMenu.setBorderPainted(false);
			mnVoltarMenu.setContentAreaFilled(false);
			mnVoltarMenu.setActionCommand("mMenuVoltar");
			painelJogo.add(mnVoltarMenu);
				
			JLabel lbRecord = new JLabel(imgRecord);
			lbRecord.setBounds(5, 50,40,40);
			painelJogo.add(lbRecord);
			
			tfRecorde = new JTextField ("0");
			tfRecorde.setBounds(50,50,150,40);
			tfRecorde.setForeground(Color.yellow);
			tfRecorde.setBackground(Color.darkGray);
			tfRecorde.setFont(new Font("Arial", Font.BOLD,30));
			tfRecorde.setEnabled(false);
			painelJogo.add(tfRecorde);


					
			mnInstrucao = new JButton();
			mnInstrucao.setIcon(imgInstrucao);
			mnInstrucao.setActionCommand("mInstrucao");
			mnInstrucao.setBounds(900,5,50,50);
			mnInstrucao.setBorderPainted(false);
			mnInstrucao.setContentAreaFilled(false);
			painelJogo.add(mnInstrucao);
			
			mnFechar = new JButton();
			mnFechar.setIcon(imgFechar);
			mnFechar.setActionCommand("mFechar");
			mnFechar.setBounds(950,0,50,50);
			mnFechar.setBorderPainted(false);
			mnFechar.setContentAreaFilled(false);
			painelJogo.add(mnFechar);
			
			//IMAGEM DE FUNDO\\
	
			lbImg = new JLabel(img);
			lbImg.setBounds(0,0,1000,680);
			img.setImage(img.getImage().getScaledInstance(lbImg.getWidth(), lbImg.getHeight(),1));	// redimenciona a imagem

			painelJogo.add(lbImg);

			return painelJogo;
		}

		

		/*
		 * 	NIVEIS DO JOGO
		 */
		public JPanel getPainelDoJogoFacil() {
				
//			if( painelJogo == null) {
				painelJogo = new JPanel();
				this.setContentPane(labelObjetos());
				painelJogo.setLayout(new BorderLayout());
				painelJogo.add(btnLixo1(), null);
				painelJogo.add(btnLixo2(), null);
				painelJogo.add(btnLixo3(), null);
				painelJogo.add(btnLixo4(), null);
				
				
				
//			}
			return painelJogo;
	
		}
		public JPanel getPainelDoJogoMedio() {
				
			if( painelJogo == null) {
				painelJogo = new JPanel();
				this.setContentPane(labelObjetos());
				painelJogo.setLayout(new BorderLayout());
				painelJogo.add(btnLixo1(), null);
				painelJogo.add(btnLixo2(), null);
				painelJogo.add(btnLixo3(), null);
				painelJogo.add(btnLixo4(), null);
				painelJogo.add(btnLixo5(), null);
				painelJogo.add(btnLixo6(), null);
			
			}
			return painelJogo;
	
		}
		
		public JPanel getPainelDoJogoDificil() {
			
		if( painelJogo == null) {
			painelJogo = new JPanel();
			this.setContentPane(labelObjetos());
			painelJogo.setLayout(new BorderLayout());
			painelJogo.add(btnLixo1(), null);
			painelJogo.add(btnLixo2(), null);
			painelJogo.add(btnLixo3(), null);
			painelJogo.add(btnLixo4(), null);
			painelJogo.add(btnLixo5(), null);
			painelJogo.add(btnLixo6(), null);
			
		}
		return painelJogo;
	}

		/*
		 * 		//JLabels RANDOMICAS
		 */
		public JPanel labelObjetos()  {
			
			lbObjeto = new JButton();	
			lbObjeto.setBorderPainted(false);
			lbObjeto.setContentAreaFilled(false);
			lbObjeto.setBounds(450,500,200,200);
			//imgObjeto.setImage(imgObjeto.getImage()	/*
			//.getScaledInstance(lbObjeto.getWidth(),	*	redimenciona a imagem
			//lbObjeto.getHeight(),10));				/* 	(dando erro).
			painelJogo.add(lbObjeto);
			
			return painelJogo;
	}
		
		/*
		 * 		 TODOS OS LIXOS:
		 */
	
	public JButton btnLixo1() {
//			//ORGANICO- MARROM\\
			btnImgLixo1 = new JButton();
			btnImgLixo1.setIcon(lixoOrganicoF);
			btnImgLixo1.setBorderPainted(false);
			btnImgLixo1.setContentAreaFilled(false);
			btnImgLixo1.setBounds(200,130,150,280);
			btnImgLixo1.setActionCommand("mLixo1");
			lixoOrganicoF.setImage(lixoOrganicoF.getImage()
					.getScaledInstance(btnImgLixo1.getWidth(), btnImgLixo1.getHeight(),1));

			btnImgLixo1.addMouseListener(new MouseListener() {
				// TROCA DE .\\
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnImgLixo1.setIcon(lixoOrganicoA);
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
					btnImgLixo1.setIcon(lixoOrganicoF);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
				}
				@Override
				public void mousePressed(MouseEvent e) {					
				}
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
			return btnImgLixo1;
		
		}
	
	public JButton btnLixo2() {
//			//PAPEL- AZUL\\
			btnImgLixo2 = new JButton();
			btnImgLixo2.setIcon(lixoPapelF);
			btnImgLixo2.setBorderPainted(false);
			btnImgLixo2.setContentAreaFilled(false);
			btnImgLixo2.setBounds(350,130,150,280);
			btnImgLixo2.setActionCommand("mLixo2");
			lixoPapelF.setImage(lixoPapelF.getImage()
					.getScaledInstance(btnImgLixo2.getWidth(), btnImgLixo2.getHeight(),1));
			btnImgLixo2.addMouseListener(new MouseListener() {
				// TROCA DE IMAGENS.\\
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnImgLixo2.setIcon(lixoPapelA);
				}
				public void mouseExited(MouseEvent arg0) {
					btnImgLixo2.setIcon(lixoPapelF);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
				}
				@Override
				public void mousePressed(MouseEvent e) {
				}
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
			return btnImgLixo2;
		}
	
	public JButton btnLixo3() {
//			//PLASTICO - VERMELHO\\
			btnImgLixo3 = new JButton();
			btnImgLixo3.setIcon(lixoPlasticoF);
			btnImgLixo3.setBorderPainted(false);
			btnImgLixo3.setContentAreaFilled(false);
			btnImgLixo3.setBounds(500,130,150,280);
			btnImgLixo3.setActionCommand("mLixo3");
			lixoPlasticoF.setImage(lixoPlasticoF.getImage()
					.getScaledInstance(btnImgLixo3.getWidth(), btnImgLixo3.getHeight(),1));
			btnImgLixo3.addMouseListener(new MouseListener() {
				// TROCA DE IMAGENS.\\
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnImgLixo3.setIcon(lixoPlasticoA);
				}
				public void mouseExited(MouseEvent arg0) {
					btnImgLixo3.setIcon(lixoPlasticoF);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
				}
				@Override
				public void mousePressed(MouseEvent e) {
				}
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
			
			return btnImgLixo3;
		}
	
	public JButton btnLixo4() {
//			//VIDRO-VERDE\\
			btnImgLixo4 = new JButton();
			btnImgLixo4.setIcon(lixoVidroF);
			btnImgLixo4.setBorderPainted(false);
			btnImgLixo4.setContentAreaFilled(false);
			btnImgLixo4.setBounds(650,130,150,280);
			btnImgLixo4.setActionCommand("mLixo4");
			lixoVidroF.setImage(lixoVidroF.getImage()
					.getScaledInstance(btnImgLixo4.getWidth(), btnImgLixo4.getHeight(),1));
			btnImgLixo4.addMouseListener(new MouseListener() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnImgLixo4.setIcon(lixoVidroA);
				}
				public void mouseExited(MouseEvent arg0) {
					btnImgLixo4.setIcon(lixoVidroF);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
				}
				@Override
				public void mousePressed(MouseEvent e) {
				}
				@Override
				public void mouseReleased(MouseEvent e) {	
				}
			});
			return btnImgLixo4;
		}
	
	public JButton btnLixo5() {
//			//METAL - AMARELO\\
			btnImgLixo5 = new JButton();
			btnImgLixo5.setIcon(lixoMetalF);
			btnImgLixo5.setBorderPainted(false);
			btnImgLixo5.setContentAreaFilled(false);
			btnImgLixo5.setBounds(50,130,150,280);
			btnImgLixo5.setActionCommand("mLixo5");
			lixoMetalF.setImage(lixoMetalF.getImage()
					.getScaledInstance(btnImgLixo5.getWidth(), btnImgLixo5.getHeight(),1));
			btnImgLixo5.addMouseListener(new MouseListener() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnImgLixo5.setIcon(lixoMetalA);
				}
				public void mouseExited(MouseEvent arg0) {
					btnImgLixo5.setIcon(lixoMetalF);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
				}
				@Override
				public void mousePressed(MouseEvent e) {
				}
				@Override
				public void mouseReleased(MouseEvent e) {
				}
			});
			return btnImgLixo5;
		}
	public JButton btnLixo6() {
//			//NÃO RECICLAVEL - CINZA\\
			btnImgLixo6 = new JButton();
			btnImgLixo6.setIcon(lixoNaoReciclaF);
			btnImgLixo6.setBorderPainted(false);
			btnImgLixo6.setContentAreaFilled(false);
			btnImgLixo6.setBounds(800,130,150,280);
			btnImgLixo6.setActionCommand("mLixo6");
			lixoNaoReciclaF.setImage(lixoNaoReciclaF.getImage()
					.getScaledInstance(btnImgLixo6.getWidth(), btnImgLixo6.getHeight(),1));
			btnImgLixo6.addMouseListener(new MouseListener() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnImgLixo6.setIcon(lixoNaoReciclaA);
				}
				public void mouseExited(MouseEvent arg0) {
					btnImgLixo6.setIcon(lixoNaoReciclaF);
				}
				@Override
				public void mouseClicked(MouseEvent e) {
				}
				@Override
				public void mousePressed(MouseEvent e) {
				}
				@Override
				public void mouseReleased(MouseEvent e) {	
				}
			});
			return btnImgLixo6;
		}
	public JButton btnLixo7() {
//		//RESIDUOS PERIGOSOS-LARANJA\\
		btnImgLixo7 = new JButton();
		btnImgLixo7.setIcon(lixoPerigososF);
		btnImgLixo7.setBorderPainted(false);
		btnImgLixo7.setContentAreaFilled(false);
		btnImgLixo7.setBounds(650,130,150,280);
		lixoPerigososF.setImage(lixoPerigososF.getImage()
				.getScaledInstance(btnImgLixo7.getWidth(), btnImgLixo7.getHeight(),1));
		btnImgLixo7.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnImgLixo7.setIcon(lixoPerigososA);
			}
			public void mouseExited(MouseEvent arg0) {
				btnImgLixo7.setIcon(lixoPerigososF);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {	
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}		
		});
		return btnImgLixo7;
	}
public JButton btnLixo8() {
//		//PRETO - MADEIRA\\
		btnImgLixo8 = new JButton();
		btnImgLixo8.setIcon(lixoMadeiraF);
		btnImgLixo8.setBorderPainted(false);
		btnImgLixo8.setContentAreaFilled(false);
		btnImgLixo8.setBounds(50,130,150,280);
		lixoMadeiraF.setImage(lixoMadeiraF.getImage()
				.getScaledInstance(btnImgLixo8.getWidth(), btnImgLixo8.getHeight(),1));
		btnImgLixo8.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnImgLixo8.setIcon(lixoMadeiraA);
			}
			public void mouseExited(MouseEvent arg0) {
				btnImgLixo8.setIcon(lixoMadeiraF);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {	
			}
		});
		return btnImgLixo8;
	}
public JButton btnLixo9() {
//		//SERVIÇOS DE SAÚDE - BRANCO\\
		btnImgLixo9 = new JButton(lixoSaudeF);
		btnImgLixo9.setBorderPainted(false);
		btnImgLixo9.setContentAreaFilled(false);
		btnImgLixo9.setBounds(800,130,150,280);
		lixoSaudeF.setImage(lixoSaudeF.getImage()
				.getScaledInstance(btnImgLixo9.getWidth(), btnImgLixo9.getHeight(),1));
		btnImgLixo8.addMouseListener(new MouseListener() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnImgLixo9.setIcon(lixoSaudeA);
			}
			public void mouseExited(MouseEvent arg0) {
				btnImgLixo9.setIcon(lixoSaudeF);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}	
		});
		return btnImgLixo9;
	}
//MANIPULA OS ACERTOS **************************
public int getCalcPontos(){
	System.out.println("getCalcPontos()");
	return Integer.parseInt(tfRecorde.getText());
}
public int getCalcSolution(){
	return Integer.parseInt(tfRecorde.getText());
}
public void setCalcSolution(int solution){
	Jogo.tfRecorde.setText(String.valueOf(solution));
}

public void setListenerJogo(ActionListener listener) {
		//CHAMA OS BOTÕES PARA A CLASSE CONTROLE
	mnVoltarMenu.addActionListener(listener);
	mnFechar.addActionListener(listener);
	mnInstrucao.addActionListener(listener);
}
	public void setListenerJogoF(ActionListener listener) {
		//CHAMA OS BOTÕES (LIXOS) DO NÍVEL FÁCIL PARA A CLASSE CONTROLE
		
		btnImgLixo1.addActionListener(listener);
		btnImgLixo2.addActionListener(listener);
		btnImgLixo3.addActionListener(listener);
		btnImgLixo4.addActionListener(listener);
		
		
		
	
	}
	public void setListenerJogoM(ActionListener listener) {
		//CHAMA OS BOTÕES (LIXOS) DO NÍVEL MÉDIO PARA A CLASSE CONTROLE
		
		btnImgLixo1.addActionListener(listener);
		btnImgLixo2.addActionListener(listener);
		btnImgLixo3.addActionListener(listener);
		btnImgLixo4.addActionListener(listener);
		btnImgLixo5.addActionListener(listener);
		btnImgLixo6.addActionListener(listener);
	}
	
	public void setListenerJogoD(ActionListener listener) {
		//CHAMA OS BOTÕES (LIXOS) DO NÍVEL Dificil PARA A CLASSE CONTROLE
		
		btnImgLixo1.addActionListener(listener);
		btnImgLixo2.addActionListener(listener);
		btnImgLixo3.addActionListener(listener);
		btnImgLixo4.addActionListener(listener);
		btnImgLixo5.addActionListener(listener);
		btnImgLixo6.addActionListener(listener);
	}


}
	


