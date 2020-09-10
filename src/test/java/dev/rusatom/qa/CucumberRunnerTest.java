package dev.rusatom.qa;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm",
                "summary",
                "junit:target/cucumber/result.xml",
                "json:target/cucumber/pagefactory.json"
               // "pretty"
        },
        glue = {"dev.rusatom.qa.steps","dev.rusatom.qa.helper"},
        features = {"src/test/resources/features/"},
        tags = "@test",
        monochrome = true

)
public class CucumberRunnerTest {
}
