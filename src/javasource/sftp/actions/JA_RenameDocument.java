// This file was generated by Mendix Business Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package sftp.actions;

import sftp.helpers.Action;
import sftp.helpers.FTPConnection;
import sftp.helpers.SFTPConnection;
import sftp.proxies.FTPType;
import com.mendix.core.Core;
import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import com.mendix.systemwideinterfaces.core.IMendixObject;

/**
 * 
 */
public class JA_RenameDocument extends CustomJavaAction<Boolean>
{
	private IMendixObject __ConnectionParameter1;
	private sftp.proxies.Connection ConnectionParameter1;
	private IMendixObject __ConfigurationParameter1;
	private sftp.proxies.Configuration ConfigurationParameter1;

	public JA_RenameDocument(IContext context, IMendixObject ConnectionParameter1, IMendixObject ConfigurationParameter1)
	{
		super(context);
		this.__ConnectionParameter1 = ConnectionParameter1;
		this.__ConfigurationParameter1 = ConfigurationParameter1;
	}

	@Override
	public Boolean executeAction() throws Exception
	{
		this.ConnectionParameter1 = __ConnectionParameter1 == null ? null : sftp.proxies.Connection.initialize(getContext(), __ConnectionParameter1);

		this.ConfigurationParameter1 = __ConfigurationParameter1 == null ? null : sftp.proxies.Configuration.initialize(getContext(), __ConfigurationParameter1);

		// BEGIN USER CODE
		try {
			IContext context = this.getContext();
			boolean SFTPused = false;
			FTPType type = ConfigurationParameter1.getFTPType(context) ; 
			if( type == FTPType.SFTP) {
				SFTPused = true;
			}
			if(SFTPused) {
				SFTPConnection.handleFile(null, ConfigurationParameter1, ConnectionParameter1, null, context, Action.RNM);
			} else {
				FTPConnection.execute(null, ConfigurationParameter1, ConnectionParameter1, null, context, Action.RNM);
			}
				
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			Core.getLogger("(S)FTP").error(e);
			return false;
		}	
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public String toString()
	{
		return "JA_RenameDocument";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}