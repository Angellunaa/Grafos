

package prueba;


public class Prueba {

    public static void main(String[] args) {
        // the problem is written in the form of a matrix
      int[][] dataMatrix = {
      //col0  col1  col2  col3
        {70,  40,   20,   55},  //row0
        {65,  60,   45,   90},  //row1
        {30,  45,   50,   75},  //row2
        {25,  30,   55,   40}   //row3
      };

      //find optimal assignment
      algoritmo_hungaro ha = new algoritmo_hungaro(dataMatrix);
      int[][] assignment = ha.findOptimalAssignment();

      if (assignment.length > 0) {
        // print assignment
        for (int i = 0; i < assignment.length; i++) {
            System.out.println("Fila " + assignment[i][1] + " -> Columna " + assignment[i][0]);
          System.out.println();
        }
      } else {
        System.out.println("no assignment found!");
      }
    }
    
}
