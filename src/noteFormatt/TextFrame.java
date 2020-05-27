package noteFormatt;

import java.util.HashMap;
import java.util.Map;

public class TextFrame extends LineMap{
	Map<String, String[]> flavours = new HashMap<String, String[]>();
	
	public TextFrame(char corner, char borderV, char borderH, char line, 
						char frameV, char frameH, char frameC, char frameT) 
	{
		// custom frame builder
		super(corner, borderV, borderH, line, frameV, frameH, frameC, frameT);
	}
	
	public String buildText(String lines) throws LineTooLongException
	{
		String toReturn = frameVerticalBounds(BoundsState.TOP);
		
		String[] linesIn = lines.split( "\n" );
		toReturn += textFrameVerticalBounds(BoundsState.TOP);
		for( String line : linesIn)
		{
			toReturn += textFrameTextLine(line, TextAlignment.LEFT);
		}
		toReturn += textFrameVerticalBounds(BoundsState.BOTTOM);
			
		toReturn += frameVerticalBounds(BoundsState.BOTTOM);
		
		return toReturn;
	}
	
	public String frameVerticalBounds(BoundsState bs )
	{
		String line = "";
		if( bs == BoundsState.BULLET )
		{
			// 
		}
	
		// ADDS PADDING TO TOP OF FRAME 
		if( bs == BoundsState.BOTTOM )
		{
			for(int i = 0; i < this.getVERTICLEPADDING(); i++)
				line += nonTextLine();
		}

// -------------- Prints border line  ->  "+------+\n"
		//								 
		line += this.borderCornerChar; 				// left corner
		for( int i = 1 ; i < this.getLINEWIDTH() - 2; i++) {
			line += this.borderCharH;			// adds the border char | runs along x-axis
		}
		line += this.borderCornerChar + "\n";		// right corner
// --------------

		// ADDS PADDING TO BOTTOM OF FRAME
		if( bs == BoundsState.TOP )
		{
			for(int i = 0; i < this.getVERTICLEPADDING(); i++)
				line += nonTextLine();
		}
			
		return line;
	}
	public String textFrameTextLine( String textLine, TextAlignment ta ) throws LineTooLongException
	{
		/*
		 * Receives a line of text from the user input
		 * line must be less than TEXTFRAMEWIDTH - 3 (!---|'xx'<text>'x'|---! max spacing)
		 */
		if( textLine.length() > this.getTEXTFRAMEWIDTH() - 3 )
		{
			throw new LineTooLongException("One of you lines is too long; shorten it, or break the line up");
		}

		
// --------------
		String line = this.borderCharV + "";
		for( int i = 1; i < this.getHORZIONTALPADDING() - 1; i++)
		{
			// creates the left side of the text frame
			line += this.borderSpaceChar;
		}
		line += this.frameCharV;
		
		//-----
		if( ta == TextAlignment.LEFT )
			textLine = padRight("  " + textLine);
		if( ta == TextAlignment.RIGHT )
			textLine = padLeft("  " + textLine);
		
		if( this.frameSpacerChar != ' ' )	
			textLine = textLine.replaceAll(" ", this.frameSpacerChar + "");
		
		line += textLine;
		//-----
			
		line += this.frameCharV;
		for( int i = this.getLINEWIDTH()-this.getHORZIONTALPADDING() + 1; i < this.getLINEWIDTH() - 1; i++)
		{
			// creates the right side of the text frame
			line += this.borderSpaceChar;
		}
		line += this.borderCharV;
// --------------
		
		return line + "\n";
	}
	public String textFrameVerticalBounds(BoundsState bs)
	{
		/*
		 * Print the vertical border for a text frame
		 * -> |-+==+-|
		 *    |------|
		 *    +------+
		 */
		String line = "";
		// ADDS PADDING TO TOP OF FRAME
		if( bs == BoundsState.BOTTOM )
		{
			for(int i = 0; i < this.getVERTICLEPADDING(); i++)
				try {
					line += textFrameTextLine("", TextAlignment.RIGHT);
				} catch (LineTooLongException e) {}		// ignored
		}
		
// --------------
		line += this.borderCharV;
		for( int i = 1; i < this.getLINEWIDTH() - 2; i++)
		{
			if(i == this.getHORZIONTALPADDING() - 1 || i == this.getLINEWIDTH() - this.getHORZIONTALPADDING() -1)
			{
				// adds the text frame's corner char
				line += this.frameCornerChar;
			} else if (i >= this.getHORZIONTALPADDING() && i < this.getLINEWIDTH() - this.getHORZIONTALPADDING()) {
				// if i is between BORDER and the TEXTFRAME
				line += this.frameCharH;			// adds the border char | runs along x-axis
			} else {
				// i is in the text frame
				line += this.borderSpaceChar;
			}
		}
		line += this.borderCharV +"\n";
// --------------
		
		
		// ADDS PADDING TO BOTTOM OF FRAME
		if( bs == BoundsState.TOP )
		{
			for(int i = 0; i < this.getVERTICLEPADDING(); i++)
				try {
					line += textFrameTextLine("", TextAlignment.RIGHT);
				} catch (LineTooLongException e) {}		// ignored
		}
		
		
		return line;
	}
// --------------
	private String nonTextLine()
	{
		/*
		 * Prints a padded border line 
		 * -> |------|
		 *    +------+
		 */
		String line = this.borderCharV + "";
		for( int i = 1; i < this.getLINEWIDTH() - 2; i++)
		{
			line += this.borderSpaceChar;			// adds the border char | runs along x-axis
		}
		line += this.borderCharV;
		
		
		return line + "\n";
	}
	private String padRight(String s) {
		// right pads the string (left align)
		// returns the String padded with the next char needed as this.frameCharV
	    return String.format("%-" + (this.getTEXTFRAMEWIDTH() - 1) + "s", s);  
	}
	private String padLeft(String s) {
		// left pads the string (right align)
		// returns the String padded with the next char needed as this.frameCharV
	    return String.format("%" + (this.getTEXTFRAMEWIDTH() - 1) + "s", s);  
	}
}


















