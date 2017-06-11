package cucumberTest;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by arlene.lehakra on 10/04/2017.
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = ".\\src\\test\\features\\",
        tags= {"@test"},
        glue= "stepdefs"
)
public class TestRunner {

}
