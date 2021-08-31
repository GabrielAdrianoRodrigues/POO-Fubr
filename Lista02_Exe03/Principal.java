public class Principal {

	public static void main(String[] args) {
		String[] entrada = new String[3];
		entrada[0] = "João Aparecido da Silva";
		entrada[1] = "Dores";
		entrada[2] = "Blumenau";
		System.out.println(NameGenerator.generateStarWarsName(entrada));
		System.out.println(NameGenerator.generateStarWarsName2(entrada));

		entrada[0] = "Maria das Graças Tenorio Cavalcanti";
		entrada[1] = "Abreu";
		entrada[2] = "Indaial";
		System.out.println(NameGenerator.generateStarWarsName(entrada));
		System.out.println(NameGenerator.generateStarWarsName2(entrada));
	}

}
