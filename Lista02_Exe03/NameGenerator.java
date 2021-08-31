public class NameGenerator {
	public static String generateStarWarsName(String[] entrada) {
		String[] nome = entrada[0].split(" ");
		String nomeFinal = nome[nome.length - 1].substring(0, 3);
		nomeFinal += nome[0].substring(0, 2).toLowerCase();

		nomeFinal += " "+entrada[1].substring(0, 2);

		nomeFinal += entrada[2].substring(0, 3).toLowerCase();

		return nomeFinal;
	}
	
	/*public static String generateStarWarsName2(String[] entrada) {
        String sobrenome = entrada[0].substring(entrada[0].lastIndexOf(" ") + 1);
        String nome = entrada[0].substring(0, entrada[0].lastIndexOf(' ')).toLowerCase();
        String nomeSobrenome = sobrenome.substring(0, 3).concat(nome.substring(0, 2));
        String sobrenomeMaeCidade = entrada[1].substring(0, 2).concat(entrada[2].substring(0, 3).toLowerCase());
        return nomeSobrenome.concat(" ").concat(sobrenomeMaeCidade);
    }*/
}
