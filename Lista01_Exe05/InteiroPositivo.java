 //Gabriel Adriano Rodrigues
 import java.lang.Math;

 public class InteiroPositivo
 {
     private int x;
 
  
 
     public void setValor(int valor){
         if (valor >= 0){
             this.x = valor;
         }
     }
 
  
 
     public int getValorMultiplicado(InteiroPositivo inteiroPositivo) {
         return this.x * inteiroPositivo.getValor();
     }
     
     public int getValor(){
         return this.x;
     }
     
     public long fatorialX() {
         long fatorial = 1;
         
         for (int i = 1; i <= this.x; i++) {
             fatorial *= i;
         }    
         return fatorial;
     }    
     
     public String divisoresInteiros() {
         String divisores = "Valores divisiveis:"; 
         int count = 0;
         if (this.x != 0) {
             for (int i = 1; i <= this.x; i++) {
                 if (this.x % i == 0) {
                     count++;
                     if (i == this.x) {
                         divisores += " " + i + ".";
                     } else {
                         divisores += " " + i + ",";
                     }
                 
                 }    
             }
         } else {
             divisores += " 0.";    
         }    
         divisores += " Quantidade de valores divisiveis "+count+".";
         return divisores;
     } 
     
     public int[] fibonacci() {
         int[] resultado = new int[this.x];
         if (this.x != 0) {
             int anterior = 0;
             int atual = 1;
             resultado[0] = 1;
             for (int i = 1; i < this.x; i++){
                 resultado[i] = anterior + atual;
                 anterior = atual;
                 atual = resultado[i];
             }
         }    
         return resultado;
     }    
     
     public double valorH() {
         if (this.x != 0) {
             double valorH = 1.0;
             for (int i = 2; i <= this.x; i++) {
                 valorH += 1/(double)i;
             }
             return valorH;
         }   
         return 0;
     }
     
     public double valorI() {
         if (this.x != 0) {
             double valorI = 0;
             for (int i = 0; i < this.x; i++) {
                 valorI += (1+(double)i)/(this.x-(double)i);
             }  
             return valorI;
         }
         return 0;
     } 
     
     public double fatorial(double divisor) {
         double fatorial = 1;
      
         for (int i = 1 ; i <= divisor; i++) {
              fatorial *= i;
         }  
         return fatorial;
     }
     
     /*public double valorS() {
         if (this.x != 0) {
             double valorS = 0;
             for (int i = 1; i <= 21; i++) {
                 valorS += (Math.pow(this.x, 21-i)) / fatorial(i);
             }
             return valorS;
         }
         return 0;
     }*/
         
     public double valorP() {
         if (this.x != 0) {
             double divisor = 2;
             double valorP = 0;
             for (int i = 1; i <= this.x;i++) {
                 if (i % 2 != 0) {
                    valorP += (double)i / fatorial(divisor);
                 } else {
                    valorP -=  (double)i / fatorial(divisor);
                 }
                 divisor += 2;
             }
             return valorP;
         }
         return 0;
     }
 }
