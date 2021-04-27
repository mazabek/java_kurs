package secondProgram;

public class MySecondProgram {
    public static void main (String[] args){

        Point a = new Point(1,1);
        Point b = new Point(2,1);

        System.out.println("Point A= ("+a.coordinateX +","+ a.coordinateY+")");
        System.out.println("Point B= ("+b.coordinateX +","+ b.coordinateY+")");
        System.out.println(distance(a,b));
    }
    public static double distance (Point a, Point b){
        return Math.sqrt(Math.pow((b.coordinateX-a.coordinateX), 2)+Math.pow((b.coordinateY-a.coordinateY), 2));
    }

}
