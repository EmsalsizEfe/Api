
    package get_request;

    import base_url.AutomationexerciseBaseUrl;
    import io.restassured.path.json.JsonPath;
    import io.restassured.response.Response;
    import org.junit.Test;

    import java.util.List;

    import static io.restassured.RestAssured.*;
    import static org.junit.Assert.*;

    public class Odev_30_10_2022 extends AutomationexerciseBaseUrl {
    /*
Given
    https://automationexercise.com/api/productsList
When
    User sends a GET Request to the url
Then
    HTTP Status Code should be 200
And
    Content Type should be "text/html; charset=utf-8"
And
    Status Line should be HTTP/1.1 200 OK
And
     There must be 12 Women, 9 Men, 13 Kids usertype in products
  */

        // Set The Url
        // Set The Expected Data
        // Send The Request and Get The Response
        // Do Assertion

        @Test
        public void get01() {
            // Set The Url
            spec.pathParams("first","api","second","productsList");
            // Set The Expected Data

            // Send The Request and Get The Response
            Response response = given().spec(spec).when().get("/{first}/{second}");
            //response.prettyPrint()  // bu satırı yoruma almazsak html formatında oldugundan asagida JSON formatinda
            // yapacagimiz islemlerde FAIL veriyor !!!

            // Do Assertion

            // HTTP Status Code should be 200
            assertEquals(200,response.statusCode());

            // Content Type should be "text/html; charset=utf-8"
            assertEquals("text/html; charset=utf-8",response.contentType());

            // Status Line should be HTTP/1.1 200 OK
            assertEquals("HTTP/1.1 200 OK",response.statusLine());

            // There must be 12 Women, 9 Men, 13 Kids usertype in products
            JsonPath jsonPath = response.jsonPath();
            jsonPath.prettyPrint();

            List<String> womens = jsonPath.getList("products.category.usertype.findAll{it.usertype=='Women'}.usertype");
            List<String> Men = jsonPath.getList("products.category.usertype.findAll{it.usertype=='Men'}.usertype");
            List<String> Kids = jsonPath.getList("products.category.usertype.findAll{it.usertype=='Kids'}.usertype");
            // System.out.println("usertype = " + usertype);

            assertEquals(12,womens.size());
            assertEquals(9,Men.size());
            assertEquals(13,Kids.size());

        }
    }