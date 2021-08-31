public class Frase {
	private String texto;

	public Frase(String umTexto) {
		this.setTexto(umTexto);
	}
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public String[] separar(){
		String[] retorno;
		retorno = this.texto.split(" ");
		return retorno;
	}
	
}