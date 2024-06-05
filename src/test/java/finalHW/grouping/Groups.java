package finalHW.grouping;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Groups {
    @Test(groups = {"odd"})
    public void a_one(){
        Assert.assertTrue(true);
    }
    @Test(groups = {"even"}, priority = 1)
    public void two(){
        Assert.assertTrue(true);
    }
    @Test(groups = {"odd"})
    public void b_three(){
        Assert.assertTrue(true);
    }
    @Test(groups = {"even"}, priority = 2)
    public void four(){
        Assert.assertTrue(true);
    }
    @Test(groups = {"odd"})
    public void c_five(){
        Assert.assertTrue(true);
    }
    @Test(groups = {"even"}, priority = 3)
    public void six(){
        Assert.assertTrue(true);
    }
    @Test(groups = {"odd"})
    public void d_seven(){
        Assert.assertTrue(true);
    }
    @Test(groups = {"even"}, priority = 4)
    public void eight(){
        Assert.assertTrue(true);
    }
}
