package secondProgram;

public class Point {

    public double coordinateX;
    public double coordinateY;


    public Point (double coordinateX, double coordinateY){
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }


    public double distance(Point p2) {
        return Math.sqrt(Math.pow((p2.coordinateX-this.coordinateX), 2)+Math.pow((p2.coordinateY-this.coordinateY), 2));
    }

    {


    }

}