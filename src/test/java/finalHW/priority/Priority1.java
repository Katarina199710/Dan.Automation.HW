package finalHW.priority;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Priority1 {
    @Test(priority = 6)
    public void a(){
        Assert.assertTrue(true);
    }
    @Test(priority = 5)
    public void b(){
        Assert.assertTrue(true);
    }
    @Test(priority = 4)
    public void c(){
        Assert.assertTrue(true);
    }
    @Test(priority = 3)
    public void d(){
        Assert.assertTrue(true);
    }
    @Test(priority = 2)
    public void e(){
        Assert.assertTrue(true);
    }
    @Test(priority = 1)
    public void f(){
        Assert.assertTrue(true);
    }
}
