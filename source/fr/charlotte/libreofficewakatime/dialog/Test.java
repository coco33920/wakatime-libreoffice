package fr.charlotte.libreofficewakatime.dialog;

import com.sun.star.awt.XDialog;
import com.sun.star.awt.XDialogEventHandler;
import com.sun.star.lang.WrappedTargetException;
import com.sun.star.uno.XComponentContext;

import fr.charlotte.libreofficewakatime.helper.DialogHelper;


public class Test implements XDialogEventHandler{
	
	
	private XDialog dialog;
	private static final String actionOk = "actionOk";
	private String[] supportedActions = new String[] { actionOk };
	
	public Test(XComponentContext xContext) {
		System.out.println("Test dialog has been created");
		this.dialog = DialogHelper.createDialog("Test.xdl", xContext, this);
	}

	public void show() {
		dialog.execute();
	}
	
	private void onOkButtonPressed() {
		dialog.endExecute();
	}
	
	@Override
	public boolean callHandlerMethod(XDialog dialog, Object eventObject, String methodName) throws WrappedTargetException {
		System.out.println(methodName);
		if (methodName.equals(actionOk)) {
			onOkButtonPressed();
			return true; // Event was handled
		}
		return false; // Event was not handled
	}

	@Override
	public String[] getSupportedMethodNames() {
		return supportedActions;
	}
	

}
