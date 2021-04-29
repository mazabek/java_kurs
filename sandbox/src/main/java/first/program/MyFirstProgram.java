package first.program;

public class MyFirstProgram{

public static void main (String[] args){
System.out.println("Hello, world!");
    Square s = new Square();
    s.l = 5;
    System.out.println(area(s));

    Rectangle r = new Rectangle();
    r.a=4;
    r.b=6;
    System.out.println(area(r));
}
    public static double area (Square s){
        return s.l * s.l;
    }
    public static double area (Rectangle r){
        return r.a * r.b;
    }
}
