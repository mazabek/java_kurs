package secondProgram;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void testPoint1(){ //positive
        Point p1 = new Point(1.0,1.0);
        Point p2 = new Point(1.0,2.0);
        Assert.assertEquals(p1.distance(p2),1.0);
    }
    @Test
    public void testPoint2(){ //positive
        Point p1 = new Point(1.0,1.0);
        Point p2 = new Point(1.0,3.0);
        Assert.assertEquals(p1.distance(p2),2.0);
    }
    @Test
    public void testPoint3(){ //negative
        Point p1 = new Point(1.0,1.0);
        Point p2 = new Point(1.0,1.0);
        Assert.assertEquals(p1.distance(p2),1.0);
    }
}
