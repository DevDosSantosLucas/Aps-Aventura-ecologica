package bancoTXT;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import modelo.Pontos;

public class ArmazenaRecorde {
	private int pontuacao;
	
//	public ArmazenaRecorde(int pontuacao) {
//		super();
//		this.pontuacao = pontuacao;
//	}
	public ArmazenaRecorde() {}

	public boolean escreveRecorde ( int pontuacao) {	
		String path = "pontos.txt";

	
		 try {
	            FileWriter arq = new FileWriter(path);
	            PrintWriter gravarArq = new PrintWriter(arq);
	            
	            gravarArq.println(pontuacao);
	            gravarArq.close();
	            return true;
	        }catch(IOException e){
	            System.out.println(e.getMessage());
	            return false;
	        }
	}
	public void escreveRecorde( String pontuacao,int nivel) {	
		String caminho = "pontos.txt";
		String[] conteudo = lerRecorde().split(";");
			
//		  System.out.print('X'+conteudo+"X");
//          String recordeFacil   = conteudo.split(";")[0];
//          String recordeMedio   = conteudo.split(";")[1];
//          String recordeDificil = conteudo.split(";")[2];
		
//		 try {
//	            FileWriter arq = new FileWriter(caminho);
//	            PrintWriter gravarArq = new PrintWriter(arq);
////	            System.out.print('X'+conteudo+"X");
////	            if(conteudo==null) {
//////	            	conteudo = ["0;0;0"];
////	            	gravarArq.println(conteudo);
////	            }
////	                String recordeFacil   = conteudo.split(";")[0];
////	                String recordeMedio   = conteudo.split(";")[1];
////	                String recordeDificil = conteudo.split(";")[2];
//	            if(nivel==1) {
//	            	recordeFacil = pontuacao;
//	            	}
//	            if(nivel==2) {
//	            	recordeMedio = pontuacao;
//	            	}
//	            if(nivel==3) {
//	            	recordeDificil = pontuacao;
//	            	}
//	            gravarArq.println(recordeFacil+";"+recordeMedio+";"+recordeDificil);
//	            
////	            String gravar = recordeFacil+";"+recordeMedio+";"+recordeDificil;
////	            gravar.White(caminho,gravar);
//	            gravarArq.close();
////	            return true;
//	            
//	        }catch(IOException e){
//	            System.out.println(e.getMessage());
////	            return false;
//	        }
	}
	

	
	   public  String lerRecorde(){
		   	String Caminho = "pontos.txt";
	        String conteudo = "";
	        try {
	            FileReader arq = new FileReader(Caminho);
	            BufferedReader lerArq = new BufferedReader(arq);
	            String linha="";
	            try {
	                linha = lerArq.readLine();
	                conteudo = linha;
//	                while(linha!=null){
//	                	System.out.println(conteudo);
//	                    conteudo += linha+"\n";
//	                    linha = lerArq.readLine();
////	                    if(linha)
//	                }
	                arq.close();                
	                	
	                return conteudo;
	            } catch (IOException ex) {
	                System.out.println("Erro: Não foi possível ler o arquivo!");
	                return "";
	            }
	        } catch (FileNotFoundException ex) {
	            System.out.println("Erro: Arquivo não encontrado!");
	            return "";
	        }
	    }
	   
	  
	   
	   
	public void setArmazenaRecorde(int pontuacao) {
		
		System.out.println("Teste ponto"+ pontuacao);
		
		
		
	}
	public int getArmazenaRecorde() {
			
			System.out.println("Teste ponto");
			return pontuacao;
		}

	

}
