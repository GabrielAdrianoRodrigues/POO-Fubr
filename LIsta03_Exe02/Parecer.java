import java.time.LocalDate;

public class Parecer {
	private String nomeParecerista;
	private LocalDate data;
	private String conteudo;
	
	public String getNomeParecerista() {
		return nomeParecerista;
	}
	public void setNomeParecerista(String nomeParecerista) {
		if (nomeParecerista == null
			|| nomeParecerista.isBlank()) {
		}
		else {
			this.nomeParecerista = nomeParecerista;
		}
	}
	
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	
	

}
