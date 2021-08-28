public class Expressao {
    String exp;

    public Expressao(String exp) {
        this.exp = exp;
    }

    public boolean estaCorretaSintaticamente() {
        int cont = 0;
        for (int i = 0; i < exp.length(); i++) {
            if (exp.charAt(i) == '(') {
                for (int j = i; j < exp.length(); j++) {
                    if (exp.charAt(i) == ')') {
                        cont++;
                    }
                }
            }
        }

        if (cont % 2 == 0) {
            return true;
        } 
        return false;
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
