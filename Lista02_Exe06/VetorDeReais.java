public class VetorDeReais {
	private double[] vetor;

	public VetorDeReais(int tamanho) {
		this.vetor = new double[tamanho];
	}

	public void setValor(double valor, int pos) {
		this.vetor[pos] = valor;
	}

	public int contarPares() {
		int cont = 0;
		for (int i = 0; i < vetor.length; i++) {
			if ((int) this.vetor[i] % 2 == 0) {
				cont++;
			}
		}
		return cont;
	}

	public VetorDeReais divide(VetorDeReais outro) {
		if (this.getTamanho() != outro.getTamanho()) {
			return null;
		}
		double temp;
		VetorDeReais vetorNovo = new VetorDeReais(this.getTamanho());

		for (int i = 0; i < this.vetor.length; i++) {
			temp = this.vetor[i] / outro.getValor(i);
			vetorNovo.setValor(temp, i); 
		}

		return vetorNovo;
	}

	public int getTamanho() {
		return this.vetor.length;
	}

	public double getValor(int posicao) {
		return this.vetor[posicao];
	}

	public double multiplica(VetorDeReais outro) {
		if (this.getTamanho() != outro.getTamanho()) {
			return Double.NaN;
		}
		double m = 0;
		int tamanhoVetor = outro.getTamanho() - 1;

		for (int i = 0; i < this.vetor.length; i++) {
			m += outro.getValor(tamanhoVetor - i) * this.vetor[i];
		}

		return m;
	}

	public void inverte() {
		double[] vetorInverso = new double[this.vetor.length];
		for (int i = 0; i < this.vetor.length; i++) {
			vetorInverso[vetorInverso.length - i - 1] = this.vetor[i];
		}

		this.vetor = vetorInverso;
	}

	/*public void inverte2() {
		int j = this.vetor.length - 1;
		double temp;
		for (int i = 0; i < this.vetor.length / 2; i++) {
			temp = this.vetor[i];
			this.vetor[i] = this.vetor[j];
			this.vetor[j] = temp;
			j--;
		}
	}*/
	public double maiorDiferenca() {
		double maiorDiferenca = 0;
		double diferenca;

		for (int i = 1; i < this.vetor.length; i++) {
			diferenca = Math.abs(this.vetor[i] - this.vetor[i - 1]);
			if (maiorDiferenca < diferenca) {
				maiorDiferenca = diferenca;
			}
		}

		return maiorDiferenca;
	}

	public String exibir() {
		String exibir = "[";

		for (int i = 0; i < this.vetor.length; i++) {
			exibir += this.vetor[i] + ", ";
		}
		exibir = exibir.substring(0, exibir.length()-2);
		return exibir+"]";
	}
}