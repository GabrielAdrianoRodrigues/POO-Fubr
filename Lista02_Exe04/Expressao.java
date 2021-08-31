public class Expressao {
    String exp;

    public Expressao(String exp) {
        this.exp = exp;
    }

    public boolean estaCorretaSintaticamente() {
        int ultimaOcorrencia = 0;
        int qtdParentes = 0;

        if (exp.charAt(exp.length() - 1) == '(' || exp.charAt(0) == ')') {
            return false;
        }
        
        for (int i  = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == ')') {
                qtdParentes++;
            }
            if (exp.charAt(i) == '(') {
                qtdParentes++;
                for (int j = ultimaOcorrencia; j < exp.length(); j++) {
                    if (exp.charAt(j) == ')') {
                        ultimaOcorrencia = j + 1;
                        break;
                    } else if (j == exp.length() -1) {
                        return false;
                    }
                }
            }
        }
        
        if (qtdParentes % 2 != 0) {
            return false;
        }
        return true;
    }


    public int getQtdeDivisores() {
        int cont = 0;
        for (int i = 0; i < this.exp.length(); i++) {
            if (this.exp.charAt(i) == '/') {
                cont++;
            }
        }
        return cont;
    }

    public int getPosicaoOperador() {
        int posicao = -1;

        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '-' || exp.charAt(i) == '*' || exp.charAt(i) == '+' || exp.charAt(i) == '/') {
                posicao = i;
                break;
            }
        }
        return posicao;
    }

    public static void main(String[] args) {
        Expressao exp = new Expressao("(a+10)/(23*(10.5-b)-2.59/(b*a))");
        exp.estaCorretaSintaticamente();
        exp.getQtdeDivisores();
        exp.getPosicaoOperador();
    }
}
