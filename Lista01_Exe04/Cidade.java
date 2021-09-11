public class Cidade {

    private String nome;
    private String UF;
    private int populacaoMasculina;
    private int populacaoFeminina;
    private boolean calculado;

    public Cidade() {
    }

    public Cidade(String nome, int populacaoMasculina, int populacaoFeminina) {
        this.setNome(nome);
        this.setPopulacaoMasculina(populacaoMasculina);
        this.setPopulacaoFeminina(populacaoFeminina);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public void setPopulacaoMasculina(int populacaoMasculina) {
        this.populacaoMasculina = populacaoMasculina;
    }

    public void setPopulacaoFeminina(int populacaoFeminina) {
        this.populacaoFeminina = populacaoFeminina;
    }

    public void setCalculado(boolean calculado) {
        this.calculado = calculado;
    }

    public String getNome() {
        return this.nome;
    }

    public String getUF() {
        return this.UF;
    }

    public int getPopulacaoMasculina() {
        return this.populacaoMasculina;
    }

    public int getPopulacaoFeminina() {
        return this.populacaoFeminina;
    }

    public boolean getCalculado() {
        return this.calculado;
    }

}