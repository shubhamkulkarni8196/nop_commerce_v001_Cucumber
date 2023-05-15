package runner;

import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions  
            (
            
       features = ".//Features",
       glue = "stepDefinfitions" ,
       dryRun = false ,
       monochrome = true ,
       plugin = {"pretty", "html:test-output"},
       tags = "@sanity"   // {"@sanity","@regression"} --->> represents and {"@sanity,@regression"} ---->> represents or
       
     )

public class TestRunner {

}
