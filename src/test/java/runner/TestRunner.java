package runner;

import org.junit.platform.suite.api.*;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectPackages("steps")
@SelectClasspathResource("features")
@IncludeTags("RegressionTest")

public class TestRunner {}

