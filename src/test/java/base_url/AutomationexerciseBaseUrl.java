package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class AutomationexerciseBaseUrl {
    protected RequestSpecification spec;

    @Before
    public void setup(){
        spec = new RequestSpecBuilder().setBaseUri("https://automationexercise.com").build(); // spec'i islemleri devam ettirebilmek icin https://automationexercise.com ' a esitledik
    }
}