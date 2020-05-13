public class AntialiasFilter {
   public static void main(String[] args) {
      //-72 dB at 500 Hz, 4th order Butterworth
      //Q=sqrt(mn)/(m+1)
      //fc=1/(2*pi*R*C*sqrt(mn))
      //Lowest Q filter must be first in the sequence
      //Minimum Resistance Values >47k
      
      double[] resistorValues = new double[] {56e3, 68e3, 82e3, 100e3, 120e3, 150e3, 180e3, 220e3, 270e3, 330e3, 390e3, 470e3, 560e3, 680e3, 820e3, 1e6};
      double[] capacitorValues = new double[] {4.70e-12, 1.00e-11, 4.70e-11, 1.00e-10, 2.20e-10, 3.30e-10, 4.70e-10, 1.00e-09, 2.00e-09, 4.70e-09, 1.00e-08, 2.00e-08, 4.70e-08, 1.00e-07};

      double m = 0;
      double n = 0;
      double Q = 0;
      double f_c = 0;
      
      System.out.println("Q = 0.5412");
      
      for(int i = 0; i < resistorValues.length; i++) {            //R1
         for(int j = 0; j < resistorValues.length; j++) {         //R2
            for(int k = 0; k < capacitorValues.length; k++) {     //C1
               for(int l = 0; l < capacitorValues.length; l++) {  //C2
                  
                  m = resistorValues[i]/resistorValues[j];        //m equals ratio of R1 to R2
                  n = capacitorValues[l]/capacitorValues[k];      //n equals ratio of C2 to C1
                  
                  Q = Math.sqrt(m*n)/(m+1);                       //Q from simplification 3.2
                  
                  f_c = 1/(2*Math.PI*resistorValues[j]*capacitorValues[k]*Math.sqrt(m*n));     //corner frequency from 3.2           
                  if(Math.abs(0.5412 - Q) <= 0.01) {
                     if(Math.abs(68.6 - f_c) <= 1) {
                        System.out.println(Q);
                        System.out.println(f_c);
                        System.out.println(resistorValues[i]);
                        System.out.println(resistorValues[j]);
                        System.out.println(capacitorValues[k]);
                        System.out.println(capacitorValues[l]);
                        System.out.println();
                     }
                  }
                  
               }
            }
         }
      }
      
      System.out.println();
      System.out.println("Q = 1.3064");
      
      for(int i = 0; i < resistorValues.length; i++) {            //R1
         for(int j = 0; j < resistorValues.length; j++) {         //R2
            for(int k = 0; k < capacitorValues.length; k++) {     //C1
               for(int l = 0; l < capacitorValues.length; l++) {  //C2
                  
                  m = resistorValues[i]/resistorValues[j];        //m equals ratio of R1 to R2
                  n = capacitorValues[l]/capacitorValues[k];      //n equals ratio of C2 to C1
                  
                  Q = Math.sqrt(m*n)/(m+1);                       //Q from simplification 3.2
                  
                  f_c = 1/(2*Math.PI*resistorValues[j]*capacitorValues[k]*Math.sqrt(m*n));   //corner frequency from 3.2
                  
                  if(Math.abs(1.3064 - Q) <= 0.025) {
                     if(Math.abs(68.6 - f_c) <= 1) {
                        System.out.println(Q);
                        System.out.println(f_c);
                        System.out.println(resistorValues[i]);
                        System.out.println(resistorValues[j]);
                        System.out.println(capacitorValues[k]);
                        System.out.println(capacitorValues[l]);
                        System.out.println();
                     }
                  }
                  
               }
            }
         }
      }
   }
}