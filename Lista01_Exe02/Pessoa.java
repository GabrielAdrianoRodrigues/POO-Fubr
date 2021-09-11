public class Pessoa {

    private String nome;
    private char sexo;
    private String dataNascimento;
    private String estadoCivil = "Solteiro";

    public Pessoa(String nome, char sexo, String data) {
        this.setNome(nome);
        this.setSexo(sexo);
        this.setDataNascimento(data);
        this.setEstadoCivil("Solteiro");
    }

    public String getNome() {
        return this.nome;
    }

    public char getSexo() {
        return this.sexo;
    }

    public String getDataNascimento() {
        return this.dataNascimento;
    }

    public String getEstadoCivil() {
        return this.estadoCivil;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(char sexo) {
        if (sexo == 'F' || sexo == 'M' || sexo == 'X') {
            this.sexo = sexo;
        }
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
}
