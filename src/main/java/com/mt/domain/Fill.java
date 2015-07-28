package com.mt.domain;

/**
 * Enumeration to represent whether the space is filled by wall or space
 * @author kiran
 *
 */
public enum Fill {
	Start('S'), Exit('F'), Wall('X'), Space(' '), Travelled('T');
	
	private char displayChar;
	
	
	private Fill(char displayChar)
	{
		this.displayChar = displayChar;
	}
	
	
	
	public char getDisplayChar() {
		return displayChar;
	}



	public static Fill getFill(char c)
	{
		for (Fill fill : Fill.values()) {
			if(fill.displayChar==c)
			{
				return fill;
			}
		}
		
		return null;
	}
}
