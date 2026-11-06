package com.grocery.runner;
import org.junit.platform.suite.api.*;
import static io.cucumber.junit.platform.engine.Constants.*;
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key=GLUE_PROPERTY_NAME, value="com.grocery.steps")
@ConfigurationParameter(key=PLUGIN_PROPERTY_NAME, value="pretty, html:target/cucumber.html, json:target/cucumber.json")
public class RunCucumberTest {}
