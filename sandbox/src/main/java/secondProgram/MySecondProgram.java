package secondProgram;

public class MySecondProgram {
    public static void main (String[] args){
        Point p1 = new Point(1,1);
        Point p2 = new Point(1, 2);
        System.out.println("Point p1=("+p1.coordinateX+","+p1.coordinateY+")");
        System.out.println("Point p2=("+p2.coordinateX+","+p2.coordinateY+")");
        System.out.println("Distance between point p1 and point p2 equals: "+p1.distance(p2));

    }
}