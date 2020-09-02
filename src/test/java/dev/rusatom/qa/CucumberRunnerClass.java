package dev.rusatom.qa;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"dev.rusatom.qa.steps","dev.rusatom.qa.helper"},
        features = {"src/test/resources/features/"},
        tags = "@test",
        monochrome = true

)
public class CucumberRunnerClass {}
