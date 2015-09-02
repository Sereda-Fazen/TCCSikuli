package automat;


import org.sikuli.script.Screen;
import util.DataProperties;
import util.Driver;

public class AbstractClass {
	protected final static double WIN_TIMEOUT = Double.parseDouble(DataProperties.get("window.timeout"));
	protected final static double CTL_TIMEOUT = Double.parseDouble(DataProperties.get("control.timeout"));
	
	protected Screen getDriver() {
		return Driver.getInstance();
	}
}
