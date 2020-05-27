package noteFormatt;

import noteFormatt.TextAlignment;
import noteFormatt.BoundsState;


public class LineMap {
	private int HORZIONTALPADDING =  11;	// how far before a textBox starts  | (0 to 11) = 12 places	| When i = this >> Is the border of the text frame
	private int VERTICLEPADDING	  =  1;		// NOT INCLUDING THE BORDER how many lines of padding exist 
	
	private int LINEWIDTH = 83; 			// the amount of INDEXED monospaced chars can fit in a line | 0 to 83 = 84 char (Notepad page width) | 129 (SQL dev width)
	private int TEXTFRAMEWIDTH = getLINEWIDTH() - (2* getHORZIONTALPADDING());	
	
	char borderCharV;		// exterior line along LEFT/ RIGHT of the perimeter
	char borderCharH;		// exterior line along TOP/ BOTTOM side of the perimeter
	char borderSpaceChar;	// char between borders
	char borderCornerChar;	// char at (0,0) (0,width), (length,0), and (width,length)

	
	char frameCharV;		// char that defines the border of a text frame (LEFT/ RIGHT)		| defaults = borderCharV
	char frameCharH;		// char that defines the border of a text frame (TOP/ BOTTOM)		| defaults = borderCharH
	char frameSpacerChar;	// char that is used in the whitespace 				| defaults = ' '
	char frameCornerChar; 	// char that is used for the corner of a text frame | defaults = cornerChar
	
	public LineMap( char borderC, char borderV, char borderH, char borderS, char frameV, char frameH, char frameC, char frameS )
	{
		this.borderCornerChar= borderC;
		this.borderCharV 	 = borderV;
		this.borderCharH 	 = borderH;
		this.borderSpaceChar = borderS;
		
		this.frameCornerChar = frameC;
		this.frameCharV  	 = frameV;
		this.frameCharH  	 = frameH;
		this.frameSpacerChar = frameS;
	}
	
	public void updateLineMap( char borderC, char borderV, char borderH, char borderS, char frameV, char frameH, char frameC, char frameS )
	{
		this.borderCornerChar= borderC;
		this.borderCharV 	 = borderV;
		this.borderCharH 	 = borderH;
		this.borderSpaceChar = borderS;
		
		this.frameCornerChar = frameC;
		this.frameCharV  	 = frameV;
		this.frameCharH  	 = frameH;
		this.frameSpacerChar = frameS;
	}
	public void setLINEWIDTH(int linewidth)
	{
		this.LINEWIDTH = linewidth;
		this.setTEXTFRAMEWIDTH(LINEWIDTH - (2* getHORZIONTALPADDING()));
	}
	
	// ----------------------------------------------------------------------------------------------

	public int getVERTICLEPADDING() {
		return VERTICLEPADDING;
	}

	public void setVERTICLEPADDING(int vERTICLEPADDING) {
		VERTICLEPADDING = vERTICLEPADDING;
	}

	public int getLINEWIDTH() {
		return LINEWIDTH;
	}

	public int getTEXTFRAMEWIDTH() {
		return TEXTFRAMEWIDTH;
	}

	public void setTEXTFRAMEWIDTH(int tEXTFRAMEWIDTH) {
		TEXTFRAMEWIDTH = tEXTFRAMEWIDTH;
	}

	public int getHORZIONTALPADDING() {
		return HORZIONTALPADDING;
	}

	public void setHORZIONTALPADDING(int hORZIONTALPADDING) {
		HORZIONTALPADDING = hORZIONTALPADDING;
	} 
}






















