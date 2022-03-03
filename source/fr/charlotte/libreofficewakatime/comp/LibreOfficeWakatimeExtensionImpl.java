package fr.charlotte.libreofficewakatime.comp;

import com.sun.star.uno.XComponentContext;
import com.sun.star.lib.uno.helper.Factory;

import fr.charlotte.libreofficewakatime.dialog.Test;
import fr.charlotte.libreofficewakatime.helper.DialogHelper;

import com.sun.star.lang.XSingleComponentFactory;
import com.sun.star.registry.XRegistryKey;
import com.sun.star.lib.uno.helper.WeakBase;


public final class LibreOfficeWakatimeExtensionImpl extends WeakBase
   implements com.sun.star.lang.XServiceInfo,
   			  com.sun.star.task.XJobExecutor,
              fr.charlotte.libreofficewakatime.XLibreOfficeWakatimeExtension
{
    private final XComponentContext m_xContext;
    private static final String m_implementationName = LibreOfficeWakatimeExtensionImpl.class.getName();
    private static final String[] m_serviceNames = {
        "fr.charlotte.libreofficewakatime.LibreOfficeWakatimeExtension" };


    public LibreOfficeWakatimeExtensionImpl( XComponentContext context )
    {
    	System.out.println("extension is loaded " + context.toString());
        m_xContext = context;
    };

    public static XSingleComponentFactory __getComponentFactory( String sImplementationName ) {
        XSingleComponentFactory xFactory = null;

        if ( sImplementationName.equals( m_implementationName ) )
            xFactory = Factory.createComponentFactory(LibreOfficeWakatimeExtensionImpl.class, m_serviceNames);
        return xFactory;
    }

    public static boolean __writeRegistryServiceInfo( XRegistryKey xRegistryKey ) {
        return Factory.writeRegistryServiceInfo(m_implementationName,
                                                m_serviceNames,
                                                xRegistryKey);
    }

    // com.sun.star.lang.XServiceInfo:
    public String getImplementationName() {
         return m_implementationName;
    }

    public boolean supportsService( String sService ) {
        int len = m_serviceNames.length;

        for( int i=0; i < len; i++) {
            if (sService.equals(m_serviceNames[i]))
                return true;
        }
        return false;
    }

    public String[] getSupportedServiceNames() {
        return m_serviceNames;
    }
    
    @Override
    public void trigger(String action)
    {
    	switch (action) {
    	case "showApiKey":
    		//DialogHelper.showInfoMessage(m_xContext, null, "test : " + action);
    		Test testDialog = new Test(m_xContext);
    		testDialog.show();
        	//testDialog.show();
    		break;
    	default:
    		DialogHelper.showErrorMessage(m_xContext, null, "Unknown action: " + action);
    	}
    }


}
