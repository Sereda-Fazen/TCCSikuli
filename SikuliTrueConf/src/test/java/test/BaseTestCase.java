package test;


import org.sikuli.script.FindFailed;
import org.sikuli.script.SikuliScript;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.DataProperties;

import java.awt.*;
import java.io.IOException;

import static org.testng.Assert.fail;

public class BaseTestCase {

	private SikuliScript script;
	private Process app;
	
	@BeforeMethod
	public void setUp() throws InterruptedException, FindFailed {
		openTrueConf();
		app = run();
	}
	@AfterMethod
	public void tearDown() {
		closeTrueConf();

	}
	private Process run() {
		try {
			return Runtime.getRuntime().exec(DataProperties.get("trueConf.path"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	private void stop() {
		app.destroy();
	}	
	
	private void openTrueConf() throws InterruptedException, FindFailed {
		try {
			script = new SikuliScript();
			script.openApp(DataProperties.get("trueConf.path"));
		} catch (AWTException e) {
			fail("Can't open TrueConf by path "+DataProperties.get("trueConf.path"));
		}
	}
	private void closeTrueConf() {

		script.closeApp("TrueConf");
	}	
}
