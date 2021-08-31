public class PassageirosHora {
    private int[][][] matriz = new int[12][30][24];

    public void adiciona(int mes, int dia, int hora) {
        this.matriz[mes-1][dia-1][hora]++;  
    }

    public int quantosPassageiros(int dia, int mes) {
        int qtde = 0;
        dia--;
        mes--;

        for (int i = 0; i < 24; i++) {
            qtde += this.matriz[dia][mes][i];
        }

        return qtde;
    }

    public int mesMenorFluxo() {
        int mesMenorFluxo = 1;
        int qtdMenor = this.quantosPassageiros(1);
        int qtdMes;

        for (int i = 2; i <= 12; i++) {
            qtdMes = this.quantosPassageiros(i);
            if (qtdMenor > qtdMes) {
                qtdMenor = qtdMes;
                mesMenorFluxo = i;
            }
        }
        
        return mesMenorFluxo;
    }

    public int[] picoTransporte(){
        int maiorValor, maiorMes, maiorDia, maiorHora;
        maiorValor = 0;
        maiorMes = 0;
        maiorDia = 0;

        for (int m = 0; m < matriz.length; m++){
            for (int d = 0; d < matriz[m].length; i++){
                for (int h = 0; h < matriz[m][d].length; i++) {
                    if (matriz[m][d][h] > maiorvalor) {
                        maiorvalor = matriz[m][d][h];
                        maiorMes = m;
                        maiorDia = d;
                        maiorHora = h;
                    }
                }
            }
        }

        int[] retorno = {maiorDia+1 ,maiorMes+1, maiorHora, maiorValor};
        return retorno;
    }

    public int quantosPassageiros(int mes) {
        int total = 0;

        for (int i = 0; i < 30; i++) {
            total += this.quantosPassageiros(i, mes);
        }

        return total;
    }

}
