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
        Expressao exp1 = new Expressao("(a+10)+(b-15)/(c+7)+(e+8(d-9))");
        exp1.estaCorretaSintaticamente();
        exp1.getQtdeDivisores();
        exp1.getPosicaoOperador();
        Expressao exp2 = new Expressao("(abc)");
        exp2.estaCorretaSintaticamente();
        exp2.getQtdeDivisores();
        exp2.getPosicaoOperador();
        Expressao exp3 = new Expressao("))a+b((");
        exp3.estaCorretaSintaticamente();
        exp3.getQtdeDivisores();
        exp3.getPosicaoOperador();
        Expressao exp4 = new Expressao("(a+10))()");
        exp4.estaCorretaSintaticamente();
        exp4.getQtdeDivisores();
        exp4.getPosicaoOperador();
    }
}
