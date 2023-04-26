package com.bizimtoptan.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt",
               "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features = "src/test/resources/features",
        glue = "com/bizimtoptan/step_definitions",
        dryRun =false,
        tags = "@mobile1"
)
public class CukesRunner {
}
