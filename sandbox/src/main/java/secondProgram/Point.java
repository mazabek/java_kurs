package secondProgram;

public class Point {

    public double coordinateX1;
    public double coordinateY1;
    public double coordinateX2;
    public double coordinateY2;


    public Point (double coordinateX1, double coordinateY1, double coordinateX2, double coordinateY2){
        this.coordinateX1 = coordinateX1;
        this.coordinateY1 = coordinateY1;
        this.coordinateX2 = coordinateX2;
        this.coordinateY2 = coordinateY2;
    }

    public double distance (){
        return Math.sqrt(Math.pow((this.coordinateX2-this.coordinateX1), 2)+Math.pow((this.coordinateY2-this.coordinateY1), 2));
    }



}

