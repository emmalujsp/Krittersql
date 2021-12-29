import org.testng.annotations.*;
public class testngsample {


    @BeforeTest
    public void launchBrowser() {
        System.out.println("launching firefox browser");

    }
    @Test
    public void verifyHomepageTitle() {
        System.out.println("firefox browser");

    }
    @AfterTest
    public void terminateBrowser(){
        System.out.println("terminate firefox browser");
    }
}
