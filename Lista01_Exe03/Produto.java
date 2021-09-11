public class Produto {
    private String nome;
    private String descricao;
    private double precoUnitario;
    private int desconto;

    public Produto(String nome, String descricao, double precoUnitario, int desconto) {
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setPrecoUnitario(precoUnitario);
        this.setDesconto(desconto);
    }

    public Produto() {
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public double getPrecoUnitario() {
        return this.precoUnitario;
    }

    public int getDesconto() {
        return this.desconto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }
}