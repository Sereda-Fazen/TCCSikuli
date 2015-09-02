package automat;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Region;
import util.DataProperties;

import java.util.zip.DataFormatException;

public class AuthAfterSip extends AbstractClass {
	//Enter
	private Pattern logo;
	// Out
	private Pattern out;
	private Pattern outOk;
	private Pattern formOut;
	private Pattern formGet;
	private Pattern close;
	//auth
	private Pattern window;
	private Pattern enter;
	private Pattern form;
	private Pattern login;
	private Pattern pass;
	private Pattern ok;
	//sip
	private Pattern fieldCall;
	private Pattern callBlock;
	private Pattern call;
	private Pattern put;
	private Pattern userNotFind;
	private Pattern okey;
	private Pattern unCall;
	private Pattern fieldTel;


	//Region
	private Region windowEnter;
	private Region quit;
	private Region outGet;
	private Region loginWindow;
	private Region inputField;

	public AuthAfterSip() throws FindFailed {

		logo = new Pattern(DataProperties.path("logo.jpg"));
		//out
		out = new Pattern(DataProperties.path("quit.jpg"));
		outOk = new Pattern(DataProperties.path("attantion.jpg"));
		formOut = new Pattern(DataProperties.path("yes.jpg"));
		formGet = new Pattern(DataProperties.path("formGet.jpg"));
		close = new Pattern(DataProperties.path("close.jpg"));
		//auth
		window = new Pattern(DataProperties.path("loginWindow.jpg"));
		enter = new Pattern(DataProperties.path("enter.jpg"));
		form = new Pattern(DataProperties.path("form.jpg"));
		login = new Pattern(DataProperties.path("login.jpg"));
		pass = new Pattern(DataProperties.path("pass.jpg"));
		ok = new Pattern(DataProperties.path("ok.jpg"));
		//sip call
		callBlock = new Pattern(DataProperties.path("callBlock2.jpg"));
		fieldCall = new Pattern(DataProperties.path("fieldCall.jpg"));
		fieldTel = new Pattern(DataProperties.path("fieldSip.jpg"));
		call = new Pattern(DataProperties.path("call.jpg"));
		put = new Pattern(DataProperties.path("put.jpg"));
		okey = new Pattern(DataProperties.path("okey.jpg"));
		unCall = new Pattern(DataProperties.path("unCall.jpg"));

		//assert
		userNotFind = new Pattern(DataProperties.path("userNotFind.jpg"));


		//region



	}

	public AuthAfterSip enterAuth(String password) throws FindFailed, InterruptedException {

		Thread.sleep(11000);
		windowEnter = getDriver().wait(enter);
		windowEnter.click(enter);
		loginWindow = getDriver().wait(form);
		loginWindow.wait(form);
		loginWindow.type(pass, password);
		loginWindow.click(ok);
		Thread.sleep(2000);
		return this;
	}

	public AuthAfterSip inputSipValid(String tel) throws FindFailed, InterruptedException {
		inputField = getDriver().wait(callBlock);
		inputField.type(fieldCall, tel);
		inputField.doubleClick(call);
		Thread.sleep(11000);
		inputField.click(put);
		return this;
	}
	public AuthAfterSip inputSipInValid(String invalid_tel) throws FindFailed, InterruptedException {
		inputField = getDriver().wait(callBlock);
		inputField.type(fieldTel, invalid_tel);
		inputField.doubleClick(call);
		Thread.sleep(11000);
		return this;
	}
	public AuthAfterSip outTrueConfId () throws FindFailed, InterruptedException {

		outGet = getDriver().wait(formGet);
		outGet.click(out);
		quit = getDriver().wait(outOk);
		quit.click(formOut);
		loginWindow = getDriver().wait(close);
		loginWindow.click(close);


		return this;
	}
	public boolean isErrorExist() {
		try {
			inputField.find(userNotFind);
			inputField.click(okey);
			return true;
		} catch (FindFailed e) {
			return false;
		}
	}
	public boolean isErrorCall() {
		try {
			inputField.find(unCall);
			return false;
		} catch (FindFailed e) {
			return true;
		}

	}

}