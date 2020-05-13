public class NumberGenerator {
   public static void main(String[] args) {

      System.out.println(numberGenerator(1));
      System.out.println(numberGenerator(2));
      System.out.println(numberGenerator(3));
      
      System.out.println();
      
      System.out.println(numberGenerator(51));
      System.out.println(numberGenerator(52));
      System.out.println(numberGenerator(53));
   }
   
   public static double numberGenerator(int n) {
      int x0 = 1000;  //starting value (seed)
      int a = 24693;  //multiplier
      int c = 3967;   //increment
      double K = Math.pow(2,17);   //modulus
      
      double x = (a*x0 + c) % K;
      double y = x;
      double u = y / K;
      
      for(int i = 1; i < n; i++) {
         y = (a*x + c) % K;
         u = y / K;
         x = y;
      }
      
      return u;
   }
}