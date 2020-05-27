package noteFormatt;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;

public final class textTransfer implements ClipboardOwner 
{
		
		  /**
		  * Place a String on the clipboard, and make this class the
		  * owner of the Clipboard's contents.
		  */
	  public void setClipboardContents(String string)
	  {
		    StringSelection stringSelection = new StringSelection(string);
		    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		    
		    clipboard.setContents(stringSelection, this);
	  }
	  
	  

		  
		private void log(String msg)  {
			System.out.println(msg);
	    }
	
	
		@Override
		public void lostOwnership(Clipboard arg0, Transferable arg1) {
			// TODO Auto-generated method stub
			
		}
} 


