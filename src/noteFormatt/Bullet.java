package noteFormatt;

public class Bullet extends LineMap{
	char b1, b2, b3;
	
	public Bullet (char corner, char borderV, char borderH, char line, 
			char frameV, char frameH, char frameC, char frameT,
			char b1, char b2, char b3) 
	{
		// custom frame builder
		super(corner, borderV, borderH, line, frameV, frameH, frameC, frameT);
		
		this.b1 = b1;
		this.b2 = b2;
		this.b3 = b3;
	}
	/*
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
	*/
}
