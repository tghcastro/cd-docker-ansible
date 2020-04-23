package com.example.demo.acceptance.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com.example.demo.acceptance.stepsDefinition",
        features = "src/test/resources",
        plugin = { "pretty", "json:target/cucumber.json"},
        strict = true //Fail if undefined/pending steps
)
public class CukesRunnerAll {

}
