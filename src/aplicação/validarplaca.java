package aplicação;

public class validarplaca {
	public static boolean validaPlaca(String placa){
		   boolean valido = true;
		   placa = placa.replaceAll("[^a-zA-Z0-9]", "");
		   if(placa.length() != 7){
		      valido = false;
		   }
		   if(!placa.substring(0, 3).matches("[A-Z]*")){
		      valido = false;
		   }
		   if(!placa.substring(3).matches("[0-9]*")){
		      valido = false;
		   }
		   return valido;
		}
}
