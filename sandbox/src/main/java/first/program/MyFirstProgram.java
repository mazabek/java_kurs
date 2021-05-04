package first.program;

public class MyFirstProgram{

public static void main (String[] args){
System.out.println("Hello, world!");
    Square s = new Square(5);
    System.out.println("Square area= "+s.area());

    Rectangle r = new Rectangle(4,6);
    System.out.println("Rectangle area= "+r.area());
}
}
