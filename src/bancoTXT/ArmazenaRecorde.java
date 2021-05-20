package bancoTXT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ArmazenaRecorde {
	
	public ArmazenaRecorde() {}

	public boolean escreveRecorde ( String pontuacao) {	
		String caminho = "pontos.txt";

		 try {
	            FileWriter arq = new FileWriter(caminho);
	            PrintWriter gravarArq = new PrintWriter(arq);
	            
	            gravarArq.println(pontuacao);
	            gravarArq.close();
	            return true;
	        }catch(IOException e){
	            System.out.println(e.getMessage());
	            return false;
	        }
	}

	   @SuppressWarnings({ "unused", "resource" })
	   
	public  String lerRecorde(){
		   String Caminho = "pontos.txt";
		   
	        	try {
	            FileReader arquivoLeitura = new FileReader(Caminho);
	            BufferedReader lerArq = new BufferedReader(arquivoLeitura);
	            String linha = "";
	            String conteudo = "x";
	            
	                linha = lerArq.readLine();
	           
	                conteudo =linha;
	            
	                if(conteudo== "" || conteudo == null) { 
	        	            FileWriter arquivoEscrita = new FileWriter(Caminho);
	        	            PrintWriter gravarArq = new PrintWriter(arquivoEscrita);
	        	            
	        	            gravarArq.println("0;0;0");
	        	            gravarArq.close();
	        	            
	        	            String zera = lerArq.readLine();                	
		                	arquivoLeitura.close(); 
		                	return zera;
	                } 
	                else {
	                	arquivoLeitura.close();                
		                return linha;
	                }
	
	            } catch (IOException ex) {
	                System.out.println("Erro: Não foi possível ler o arquivo!");
	                return "";
	            }
	   }
	   
}
