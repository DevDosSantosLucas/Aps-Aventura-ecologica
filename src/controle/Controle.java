package controle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import interfaceUI.Instrucao;
import interfaceUI.Jogo;
import interfaceUI.Opcao;
import interfaceUI.Menu;
import modelo.Pontos;
import bancoTXT.ArmazenaRecorde;

public class Controle  implements ActionListener,MouseListener{
	private boolean 
			facil = false,
			medio = false,
			dificil = false;
	private int resultado;
	private String recordeFacil, recordeMedio, recordeDificil ;
	
	
	private int controlaVida = 5;
	private String resultadoGravado ;
	
	private Pontos pontos;
	
	private Menu menu;
	private Opcao opcao;
	private Jogo jogo;
	private Instrucao instrucao;
	public ArmazenaRecorde armazenaRecorde;
	
	public int imgRandom = 0;
	
	public void setInterface(Menu menu){
		
		this.menu = menu;
		abrirMenu() ;
	}
	
	public void setModelo(Pontos modelo) {
		pontos = modelo;
	}
	

	public void abrirMenu() {
		
		menu = new Menu();
		menu.addMenuListener(this);
		menu.setUndecorated(true);
		menu.setSize(600,510);//600,510
		menu.setDefaultCloseOperation(Menu.DISPOSE_ON_CLOSE);
		menu.setLocationRelativeTo(null);
		menu.setVisible(true);
	}
	public void abrirJogo() {	//dimencionando a JFrame queabre o jogo. 
		
		jogo.setListenerJogo(this);
		jogo.setUndecorated(true);		//esconde ( - [] X)
		opcao.setVisible(false);
		jogo.setSize(1000,680);		
		jogo.setLocationRelativeTo(null);
		jogo.setVisible(true);
		this.imagemRandom();
	}
	public void abrirOpcao() { //dimencionando a JFrame que do nivel do jogo ou fim do jogo. 
		opcao.setListenerOpcao(this);	
		opcao.setDefaultCloseOperation(Opcao.DISPOSE_ON_CLOSE);
		opcao.setLocationRelativeTo(null);
		opcao.setVisible(true);
		
	}
	public void abrirInstrucao() { //dimencionando a JFrame das instrução do jogo.
		instrucao = new Instrucao();
		instrucao.setUndecorated(true);	
		instrucao.setListenerInstrucao(this);	
		instrucao.setDefaultCloseOperation(Instrucao.DISPOSE_ON_CLOSE);
		instrucao.setSize(700,600);
		instrucao.setLocationRelativeTo(null);
		
		instrucao.setVisible(true);
		
	}
	
	//deixa os objetos aleátorios.
	public void imagemRandom() {
	//instância um objeto da classe Random usando o construtor padrão
	  Random gerador = new Random();
	//imprime sequência de números inteiros aleatórios
	  	imgRandom = gerador.nextInt(30);

	  jogo.lbObjeto.setIcon(jogo.imgObjeto = new ImageIcon(getClass().getResource("../ASSETS/ImagensRandom/"+imgRandom+".png")));
	}
	
	//AÇÕES PARA ESCOLHER O NÍVEL DO JOGO
		public void setNivelDoJogo() {

			if(opcao.btnFacil.isSelected()) {
					medio = false; dificil = false;
					jogo = new Jogo(Jogo.FACIL);
					jogo.setListenerJogoF(this);
					jogo.calcularVida(8);
					controlaVida = 5;
					facil =true;
	
				}
			 if(opcao.btnMedio.isSelected()) {
				    controlaVida = 3;
					facil = false; dificil = false;
					jogo = new Jogo(Jogo.MEDIO);
					jogo.setListenerJogoM(this);
					jogo.calcularVida(7);
					medio = true;						
				}
			 if(opcao.btnDificil.isSelected()) {
				 	controlaVida = 0;
					facil = false; medio = false;	
					jogo = new Jogo(Jogo.DIFICIL);
					jogo.setListenerJogoD(this);
					jogo.calcularVida(6);
					dificil = true;
				}
				
			}
		
//*******  AQUI FAZ A PONTUAÇÃO MODELO VS INTERFACE  ***********/
//*******   E CONTROLE DO CORAÇÃO PARA MOSTRAR VIDA  ***********/
		
	public void pontuacaoDeAcertos() {	
		
		pontos.calcular(Pontos.ACERTOU);
		pontos.setOperando(jogo.getCalcSolution());
		 resultado = pontos.calcular(Pontos.ACERTOU);
		jogo.setCalcSolution(resultado);
		

	}
	
	public void pontuacaoDeErros() {
		
		pontos.calcular(Pontos.ERROU);
		resultado = pontos.calcular(Pontos.ERROU);
		controlaVida-=1;
		jogo.calcularVida(controlaVida);
		if(controlaVida<=(-1)) {
		jogo.calcularVida(controlaVida);
		fimJogo();
		}
	}

//*************************************************************/

//***************  CONTROLE DE PONTOS  ************************/
	
	public void armazenamentoDePontos() {

		armazenaRecorde = new ArmazenaRecorde();

		String recordArmazenado =armazenaRecorde.lerRecorde();
		 recordeFacil = recordArmazenado.split(";")[0];
		 recordeMedio = recordArmazenado.split(";")[1];
		 recordeDificil = recordArmazenado.split(";")[2];
	}
	public void fimJogo() { //PRECISA ARRUMAR AQUI
		int recorde = 0;
		String nivel = "";
		
		JFrame frame = new JFrame();
		pontos.calcular(Pontos.ACERTOU);
		pontos.setOperando(jogo.getCalcSolution());
		resultado = pontos.calcular(Pontos.ACERTOU);
		resultado --;
//		jogo.setCalcSolution(resultado);
		armazenamentoDePontos();
		
		if(facil == true) {
			String ponto = resultado+";"+recordeMedio+";"+recordeDificil;
			resultadoGravado =  recordeFacil;
			recorde = Integer.parseInt(recordeFacil);
			nivel = "FÁCIL";
				if(resultado > recorde) {
				armazenaRecorde.escreveRecorde(ponto);
				}
			
		}
		if(medio == true) {
			String ponto = recordeFacil+";"+resultado+";"+recordeDificil;
			resultadoGravado =  recordeMedio;
			recorde = Integer.parseInt(recordeMedio);
			nivel = "MÉDIO";
				if(resultado > recorde) {
				armazenaRecorde.escreveRecorde(ponto);
				}
		}
		if(dificil == true) {
			String ponto = recordeFacil+";"+recordeMedio+";"+resultado;
			resultadoGravado =  recordeDificil;
			recorde = Integer.parseInt(recordeDificil);
			nivel = "DIFÍCIL";
				if(resultado > recorde) {
				armazenaRecorde.escreveRecorde(ponto);
				}
		}
		
		if(resultado >recorde) {
			
		 JOptionPane.showMessageDialog(frame,
			        ">>PARABÉNS:  \n "
			       +"SEU NOVO RECORDE É:  "+resultado+"",
			        "RECORDE NÍVEL "+nivel, // titulo da janela 
			        JOptionPane.INFORMATION_MESSAGE);
		}
		 
		 else if(resultado <= recorde) {
		 JOptionPane.showMessageDialog(frame,
			        ">>NÍVEL "+nivel+" \n "
			       +"Seu Resultado foi:  "+resultado+"\n "
			       +"O Recorde é:  "+resultadoGravado, 
			        "PONTUAÇÃO", // titulo da janela 
			        JOptionPane.INFORMATION_MESSAGE);
		 }
			jogo.dispose()	;	
			this.abrirMenu();
	}
	
	
//*************************************************************/
//-------------------------------------------------------------/	
// --------------------AÇÕES DOS BOTÕES: ----------------------/
//-------------------------------------------------------------/
	@Override
	public void actionPerformed(ActionEvent e) {
		
//-----------------------\\		
//		BOTÕES DO MENU	 \\
//-----------------------\\	

		if(e.getActionCommand().equals("btnIniciar")) {				
			opcao= new Opcao(Opcao.JOGO);
			this.abrirOpcao();
			menu.dispose();
		}

		else if(e.getActionCommand().equals("btnRecorde")) {
			 JFrame frame = new JFrame();
			 armazenamentoDePontos() ;
			 
			 JOptionPane.showMessageDialog(frame,
				        ">>NIVEIS: \n "
				       +"FÁCIL:  "+recordeFacil+" \n "
				       +"MÉDIO:  "+recordeMedio+" \n "
				       +"DIFÍCIL: "+recordeDificil, //mensagem
				        "RECORDES", // titulo da janela 
				        JOptionPane.INFORMATION_MESSAGE);
			
		}
		else if(e.getActionCommand().equals("mInstrucao")) {
			abrirInstrucao();
		}
		
		else if(e.getActionCommand().equals("btnSair")) {
			System.exit(0);
		}
		
//-----------------------\\	
//	BOTÕES DE OPÇÕES 	\\
//-----------------------\\	
		else if(e.getActionCommand().equals("btnComecar")) {
				this.setNivelDoJogo();
				this.abrirJogo();
				opcao.dispose();
					
			}
//-----------------------\\	
//		BOTÕES DA JANELA JOGO
//-----------------------\\	
		
		else if(e.getActionCommand().equals("mMenuVoltar")) {
				jogo.dispose()	;
				this.abrirMenu();
		}
		
		else if(e.getActionCommand().equals("mVoltar")) {
			instrucao.dispose() ;		
		}
				
		else if(e.getActionCommand().equals("mFechar")) {
				System.exit(0);
		}

		

//-----------------------\\		
//		MANIPULANDO BOTOES DE LIXO:
//-----------------------\\	
		else if(e.getActionCommand().equals("mLixo1")){
			
			if((imgRandom>=0)&&(imgRandom<=10)){	
				pontuacaoDeAcertos();
				}
				else {
				pontuacaoDeErros();
				}
				this.imagemRandom();
		}
		else if(e.getActionCommand().equals("mLixo2")){
			
			if((imgRandom>10)&&(imgRandom<=20)){
				pontuacaoDeAcertos();
				}
				else {
				pontuacaoDeErros();
				}
				this.imagemRandom();
				}
		
		else if(e.getActionCommand().equals("mLixo3")){
						 
			if((imgRandom>20)&&(imgRandom<=30)){
				pontuacaoDeAcertos();
				}
				else {
				pontuacaoDeErros();
				}
				this.imagemRandom();
				}
		
		else if(e.getActionCommand().equals("mLixo4")){
			
			if((imgRandom>30)&&(imgRandom<=40)){
				pontuacaoDeAcertos();
				}
				else {
				pontuacaoDeErros();
				}
				this.imagemRandom();
				}
		
		else if(e.getActionCommand().equals("mLixo5")){
			
			if((imgRandom>40)&&(imgRandom<=50)){
				pontuacaoDeAcertos();
				}
				else {
				pontuacaoDeErros();
				}
				this.imagemRandom();
				}
		
		else if(e.getActionCommand().equals("mLixo6")){
			
			if((imgRandom>50)&&(imgRandom<=60)){
				pontuacaoDeAcertos();
				}
				else {
				pontuacaoDeErros();
				}
				this.imagemRandom();
				}	
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override	
	public void mouseReleased(MouseEvent e) {

	}

}
