package hello.arquillian;

import org.junit.Assert;
import org.junit.Test;

import javax.inject.Inject;

public class SampleBusinessTest extends BaseTest {
    @Inject
    private SampleBusiness sampleBusiness;


    @Test
    public void injectionTest(){
        Assert.assertNotNull(sampleBusiness);
    }

    @Test
    public void helloTest(){
        Assert.assertTrue(sampleBusiness.invokeBusiness("wlp").equalsIgnoreCase("hello wlp!"));
    }
}
