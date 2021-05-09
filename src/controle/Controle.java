package controle;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


import interfaceUI.Jogo;
import interfaceUI.Opcao;
import interfaceUI.Menu;
import modelo.Pontos;
import bancoTXT.ArmazenaRecorde;

public class Controle  implements ActionListener,MouseListener{
	private boolean jogando = false ,
			facil = false,
			medio = false,
			dificil = false;
	int resultadoF, resultadoM,resultadoD, maiorRecorde;
	
//	public static final int    = 0;
//	public static final int ERROU     = 1;
	
	private int controlaVida = 5;
	
	
	private Pontos pontos;
	
	private Menu menu;
	private Opcao opcao;
	private Jogo jogo;
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
		menu.setSize(600,510);
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
//		jogando = true;
		this.imagemRandom();
	}
	public void abrirOpcao() { //dimencionando a JFrame que do nivel do jogo ou fim do jogo. 
		opcao.setListenerOpcao(this);	
		opcao.setDefaultCloseOperation(Opcao.DISPOSE_ON_CLOSE);
		opcao.setLocationRelativeTo(null);
		opcao.setVisible(true);
		
	}
	
	//deixa os objetos aleátorios.
	public void imagemRandom() {
			
	
	//instância um objeto da classe Random usando o construtor padrão
	  Random gerador = new Random();
	   
	//imprime sequência de números inteiros aleatórios
	  for (int i = 0; i <= 20; i++) {
	  	imgRandom = gerador.nextInt(20);
	  }
	  jogo.lbObjeto.setIcon(jogo.imgObjeto = new ImageIcon(getClass().getResource("../ASSETS/ImagensRandom/"+imgRandom+".png")));
	}
	
	//AÇÕES PARA ESCOLHER O NÍVEL DO JOGO
		public void setNivelDoJogo() {

			if(opcao.btnFacil.isSelected()) {
					medio = false; dificil = false;
					jogo = new Jogo(Jogo.FACIL);
					jogo.setListenerJogoF(this);
					jogo.calcularVida(8);
					facil =true;
	
				}
			 if(opcao.btnMedio.isSelected()) {
						facil = false; dificil = false;
						jogo = new Jogo(Jogo.MEDIO);
						jogo.setListenerJogoM(this);
						jogo.calcularVida(7);
						medio = true;
										
				}
			 if(opcao.btnDificil.isSelected()) {
					facil = false; medio = false;	
					jogo = new Jogo(Jogo.DIFICIL);
					jogo.setListenerJogoD(this);
					jogo.calcularVida(6);
					dificil = true;
				}
				
			}
		
//*******  AQUI FAZ A PONTUAÇÃO MODELO VS INTERFACE  ***********/
//*******   E CONTROLE DO CORAÇÃO PARA MOSTRAR VIDA  ***********/
		int resultado;
	public void pontuacaoDeAcertos() {	
		
		pontos.calcular(Pontos.ACERTOU);
		pontos.setOperando(jogo.getCalcSolution());
		 resultado = pontos.calcular(Pontos.ACERTOU);
		jogo.setCalcSolution(resultado);
		

	}
	
	public void pontuacaoDeErros() {
		
		pontos.calcular(Pontos.ERROU);
//		pontos.setOperando(jogo.getCalcSolutionErros());
		resultado = pontos.calcular(Pontos.ERROU);
//		jogo.setCalcSolutionErros(resultado);
		
		controlaVida-=1;
		System.out.println(">>ERROU");
		System.out.println("controlaVida"+controlaVida);
		jogo.calcularVida(controlaVida);
		System.out.println("-=======================-");
//		int contando = controlaVida % 2;
//		if((contando != 0))controlaVida-=1;
//		System.out.println("DIVIDIU DEU "+contando);
//		System.out.println("controlaVida"+controlaVida);
		if(controlaVida<=(-1)) {
//		
		jogo.calcularVida(controlaVida);
		fimJogo();
		System.out.println("-=======================-");
		}
	}
//	public int pontuacaoFinal() {
//		pontuacaoDeAcertos();
//		return resultado ;
//	}
//*************************************************************/


//***************  CONTROLE DE VIDAS  ************************/
	

	public void fimJogo() {
		int resultadoGravado = 0;
		
		JFrame frame = new JFrame();
		pontos.calcular(Pontos.ACERTOU);
		pontos.setOperando(jogo.getCalcSolution());
		 resultado = pontos.calcular(Pontos.ACERTOU);
		jogo.setCalcSolution(resultado);
  
//		System.out.println(resultado);
//		if(facil == true)
//		{	resultadoF = resultado;
////			{maiorRecorde = resultadoF;}
//		System.out.println(resultado +""+ resultadoF);}
//		if(medio == true)
//		System.out.println(resultado);
//		{	resultadoM = resultado;}
//		if(dificil == true)
//		{	 resultadoD = resultado;}
////		
//		Armazenar no TXT 
		armazenaRecorde = new ArmazenaRecorde();
		armazenaRecorde.escreveRecorde(resultado);
		String recordArmazenado =armazenaRecorde.lerRecorde();
		String recorde = resultado+"";
		if(facil == true) {
			armazenaRecorde.escreveRecorde(recorde ,1);
		System.out.println("RESULTADO:"+resultado);
		String recordeFacil = recordArmazenado.split(";")[0];
		System.out.println("recordeFacil:"+recordeFacil);
		
		resultadoGravado = Integer.parseInt(recordeFacil);
		System.out.println("resultadoGravado:"+resultadoGravado);
		}
		if(medio == true) {
		armazenaRecorde.escreveRecorde(resultado);
		String recordeMedio = recordArmazenado.split(";")[1];
		resultadoGravado = Integer.parseInt(recordeMedio);
		}
		if(dificil == true) {
		String recordeDificil = recordArmazenado.split(";")[2];
		resultadoGravado = Integer.parseInt(recordeDificil);
		}
		if(resultado<=resultadoGravado) {
		 JOptionPane.showMessageDialog(frame,
			        ">>NIVEIS: \n "
			       +"Seu Resultado foi: "+recorde+"\n"
			       +"O Recorde é:   "+resultadoGravado+ "\n ", //mensagem
			        "RECORDES", // titulo da janela 
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
		else if (e.getActionCommand().equals("btnD")) {
				
				
			
//			teste do botão 
//			 JFrame frame = new JFrame();
//			 JOptionPane.showMessageDialog(frame,
//				        "SUBTRAÇÃO! o botão funciona", //mensagem
//				        "Erro 200", // titulo da janela 
//				        JOptionPane.INFORMATION_MESSAGE);

			
		}
		

		else if(e.getActionCommand().equals("btnRecorde")) {
			
			 JFrame frame = new JFrame();
//			 
//			 if(facil == true)
//				{	resultadoF = resultado;}
//				System.out.println("Resultado teste DEU "+resultadoF);
//
//				if(medio == true)
//				{	resultadoM = resultado;}
//				if(dificil == true)
//				{	 resultadoD = resultado;}
			 JOptionPane.showMessageDialog(frame,
				        ">>NIVEIS: \n "
				       +"FACIL:  "+resultadoF+" \n "
				       +"MÉDIO:  "+resultadoM+" \n "
				       +"DIFÍCIL:"+resultadoD, //mensagem
				        "RECORDES", // titulo da janela 
				        JOptionPane.INFORMATION_MESSAGE);
			
		}
		else if(e.getActionCommand().equals("mInstrucao")) {
			
			 JFrame frame = new JFrame();
			 JOptionPane.showMessageDialog(frame,
				        "Lorem Ipsum is simply dummy text of the printing \n"
				      + "and typesetting industry. Lorem Ipsum has been the \n"
				      + "industry's standard dummy text ever since the 1500s, \n"
				      + " when an unknown printer took a galley of type and scrambled \n"
				      + "it to make a type specimen book. It has survived not only five \n "
				      + "centuries, but also the leap into electronic typesetting, remaining \n "
				      + "essentially unchanged. It was popularised in the 1960s with the release \n"
				      + " of Letraset sheets containing Lorem Ipsum passages, and more recently \n"
				      + "with desktop publishing software like Aldus PageMaker including \n"
				      + " versions of Lorem Ipsum.", //mensagem
				        "INSTRUÇÃO", // titulo da janela 
				        JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getActionCommand().equals("btnSair")) {
			System.exit(0);
		}
		
//-----------------------\\	
//	BOTÕES DE OPÇÕES 	\\
//-----------------------\\	
		else if(e.getActionCommand().equals("btnComecar")) {
				//jogo = new JogoUI(0);
				this.setNivelDoJogo();
				this.abrirJogo();
				opcao.dispose();
					
			}
//-----------------------\\	
//		BOTÕES DA JANELA JOGO
//-----------------------\\	
		
		else if(e.getActionCommand().equals("mMenuVoltar")) {
				jogo.dispose()	;
				
				//jogo.setVisible(false);
						
				this.abrirMenu();
		}
				
		else if(e.getActionCommand().equals("mFechar")) {
				System.exit(0);
		}
		else if(e.getActionCommand().equals("mReiniciar")) {
			
			if(	facil = true) {
				jogo.dispose();
				jogo = new Jogo(Jogo.FACIL);
				this.abrirJogo();
	
				jogo.setListenerJogoF(this);
				facil = false;
				
			}
			else if(medio = true){
				jogo.dispose();
				jogo = new Jogo(Jogo.MEDIO);
				this.abrirJogo();
				
				jogo.setListenerJogoM(this);
				medio = false;
		}
			
				
		}
		
//		MANIPULANDO BOTOES DE LIXO:
		else if(e.getActionCommand().equals("mLixo1")){
			//MANIPULANDO OS PONTOS E PORCENTAGEM DE VIDA SE ACERTAR 
			//OU ERRAR OS LIXOS:
//			if((imgRandom>=0)&&(imgRandom<=10)){	
//			System.out.println("VIDA Acertou : "+controlaVida);
//			pontuacaoDeAcertos();
//			}
//			else {
//			System.out.println("VIDA errou : "+controlaVida);
//			pontuacaoDeErros();
//			}
//			this.imagemRandom();
			
			
			if((imgRandom>=0)&&(imgRandom<=10)){	
				System.out.println("VIDA Acertou : "+controlaVida);
				pontuacaoDeAcertos();
				}
				else {
				System.out.println("VIDA errou : "+controlaVida);
				pontuacaoDeErros();
				}
				this.imagemRandom();
		}
		else if(e.getActionCommand().equals("mLixo2")){
			
			if((imgRandom>10)&&(imgRandom<=20)){
				System.out.println("VIDA Acertou : "+controlaVida);
				pontuacaoDeAcertos();
				}
				else {
				System.out.println("VIDA errou : "+controlaVida);
				pontuacaoDeErros();
				}
				this.imagemRandom();
				}
		else if(e.getActionCommand().equals("mLixo3")){
						 
			if((imgRandom>20)&&(imgRandom<=30)){
				System.out.println("VIDA Acertou : "+controlaVida);
				pontuacaoDeAcertos();
				}
				else {
				System.out.println("VIDA errou : "+controlaVida);
				pontuacaoDeErros();
				}
				this.imagemRandom();
			
				}
		else if(e.getActionCommand().equals("mLixo4")){
			if((imgRandom>30)&&(imgRandom<=40)){
				System.out.println("VIDA Acertou : "+controlaVida);
				pontuacaoDeAcertos();
				}
				else {
				System.out.println("VIDA errou : "+controlaVida);
				pontuacaoDeErros();
				}
				this.imagemRandom();
				}
		else if(e.getActionCommand().equals("mLixo5")){
			if((imgRandom>40)&&(imgRandom<=50)){
				System.out.println("VIDA Acertou : "+controlaVida);
				pontuacaoDeAcertos();
				}
				else {
				System.out.println("VIDA errou : "+controlaVida);
				pontuacaoDeErros();
				}
				this.imagemRandom();
				}
		else if(e.getActionCommand().equals("mLixo6")){
			if((imgRandom>50)&&(imgRandom<=60)){
				System.out.println("VIDA Acertou : "+controlaVida);
				pontuacaoDeAcertos();
				}
				else {
				System.out.println("VIDA errou : "+controlaVida);
				pontuacaoDeErros();
				}
				this.imagemRandom();
				}
//		else if(e.getActionCommand().equals("mLixo7")){
//			if((imgRandom>60)&&(imgRandom<=70)){
//				System.out.println("VIDA Acertou : "+controlaVida);
//			pontuacaoDeAcertos();
//			}
//			else {
//			System.out.println("VIDA errou : "+controlaVida);
//			pontuacaoDeErros();
//			}
//			this.imagemRandom();
//			}
//		else if(e.getActionCommand().equals("mLixo8")){
//			if((imgRandom>70)&&(imgRandom<=80)){
//				System.out.println("VIDA Acertou : "+controlaVida);
//			pontuacaoDeAcertos();
//			}
//			else {
//			System.out.println("VIDA errou : "+controlaVida);
//			pontuacaoDeErros();
//			}
//			this.imagemRandom();
//			}
//		else if(e.getActionCommand().equals("mLixo9")){
//			if((imgRandom>80)&&(imgRandom<=90)){
//				System.out.println("VIDA Acertou : "+controlaVida);
//			pontuacaoDeAcertos();
//			}
//			else {
//			System.out.println("VIDA errou : "+controlaVida);
//			pontuacaoDeErros();
//			}
//			this.imagemRandom();
//			}


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
		movendoImagem();
		
	}
	@Override	
	public void mouseReleased(MouseEvent e) {
	movendoImagem();
	}
	public void movendoImagem() {
			new Thread() {
				public void run() {
				while(true) {
					
					try {sleep(10);}catch(Exception Erro){}
					
						Point ponto =  jogo.getMousePosition();
						jogo.lbObjeto.setBounds(ponto.x-100,ponto.y-100,200,200);
					
				}
			}
		}.start();
		
	}
}
