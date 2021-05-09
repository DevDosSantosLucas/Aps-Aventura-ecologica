
import controle.Controle;
import interfaceUI.Menu;
import modelo.Pontos;

public class ProgMain {

	public static void main(String[] args) {
		
		Splash splash = new Splash();
		try{
			Pontos modelo = new Pontos();
			Menu menu = new Menu();
			Controle sistema = new Controle() ;
						
			sistema.setInterface(menu);
			sistema.setModelo(modelo);
			
			splash.janelaSplash.dispose();
				
			}catch(Exception e) {System.err.println(e.getMessage());
			 e.printStackTrace();}
		
		
		
		}

	}


