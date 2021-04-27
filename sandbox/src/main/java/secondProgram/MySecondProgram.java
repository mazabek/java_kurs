package secondProgram;

public class MySecondProgram {
    public static void main (String[] args){
        Point result = new Point(1,1,1,2);
        System.out.println("Point X: ("+result.coordinateX1 + ","+result.coordinateY1+")");
        System.out.println("Point Y: ("+result.coordinateX2 + ","+result.coordinateY2+")");
        System.out.println("Distance between point X and Y equals: "+result.distance());
    }


}
