import java.lang.Math;

public class TimeConstant {
   public static void main(String[] args) {
    double[] resistorValues = new double[] {1.0, 1.2, 1.5, 1.8, 2.2, 2.7, 3.3, 3.9, 4.7, 5.6, 6.8, 8.2, 10, 12, 15, 18, 22, 27, 33, 39, 47, 56, 68, 82, 100, 120, 150, 180, 220, 270, 330, 390, 470, 560, 680, 820, 1e3, 1.2e3, 1.5e3, 1.8e3, 2.2e3, 2.7e3, 3.3e3, 3.9e3, 4.7e3, 5.6e3, 6.8e3, 8.2e3, 10e3, 12e3, 15e3, 18e3, 22e3, 27e3, 33e3, 39e3, 47e3, 56e3, 68e3, 82e3, 100e3, 120e3, 150e3, 180e3, 220e3, 270e3, 330e3, 390e3, 470e3, 560e3, 680e3, 820e3, 1e6};
    double[] capacitorValues = new double[] {1e-6, 4.7e-6, 10e-6, 22e-6, 47e-6, 100e-6, 220e-6, 1000e-6};
    
    double R = 0;
    double C = 0;
    
    double tau = 0;
    
    //Low Pass
    System.out.println("Low Pass: ");
    for(int i = 0; i < resistorValues.length; i++) {
      for(int j = 0; j < capacitorValues.length; j++) {
         R = resistorValues[i];
         C = capacitorValues[j];
         
         tau = R * C;
         
         if(tau > (4) && tau < (5)) {
            System.out.println("R: " + R + " C: " + C + " Tau: " + tau);
         }
      }
    }
    System.out.println();
    
    //High Pass
    System.out.println("High Pass: ");
    for(int k = 0; k < resistorValues.length; k++) {
      for(int h = 0; h < capacitorValues.length; h++) {
         R = resistorValues[k];
         C = capacitorValues[h];
         
         tau = R * C;
         
         if(tau < (.001) && R > 100) {
            System.out.println("R: " + R + " C: " + C + " Tau: " + tau);
         }
      }
    }
   }
}