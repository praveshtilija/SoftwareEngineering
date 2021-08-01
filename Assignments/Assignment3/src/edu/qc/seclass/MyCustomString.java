package edu.qc.seclass;

public class MyCustomString implements MyCustomStringInterface {
	
	String my_string = null;
	
	public String getString() {
		return my_string;	
	}
	
	public void setString(String string) {
		this.my_string = string;		
	}
	
	public int countNumbers() {
		if(this.my_string.isEmpty()) return 0;
		
		if(this.my_string == null) throw new NullPointerException("The string is null");
		
		int counter = 0;
		boolean previous_digit = false;
		
		for(int i = 0; i < this.my_string.length(); i++) {
			if(Character.isDigit(this.my_string.charAt(i))) {
				if(!previous_digit) {
					counter++;
					previous_digit = true;
				}				
			}
			else previous_digit = false;
		}
		return counter;
	}
	
	public String getEveryNthCharacterFromBeginningOrEnd(int n, boolean startFromEnd) {
		if(this.my_string.isEmpty() || this.my_string.length() < n) return "";
		
		if(n <= 0) throw new IllegalArgumentException();
		
		if( this.my_string == null && n > 0) throw new NullPointerException();
		
		StringBuffer string_result = new StringBuffer();
		
		if(startFromEnd == true) {
			for(int i = this.my_string.length() - n; i >= 0; i -= n)string_result.insert(0,  this.my_string.charAt(i));
			return string_result.toString();
		}
		
		else for(int i = n - 1; i < this.my_string.length(); i += n)string_result.append(this.my_string.charAt(i));
		
		return string_result.toString();		
	}
	
	public void convertDigitsToNamesInSubstring(int startPosition, int endPosition) {
		if(startPosition > endPosition) {
			throw new IllegalArgumentException("startPosition > endPosition");
		}
		
		if((startPosition <= endPosition) && (startPosition < 1 || endPosition < 1 || startPosition > this.my_string.length() || endPosition > this.my_string.length())) {
			throw new MyIndexOutOfBoundsException("Index out of bounds");
		}
		
		if(startPosition <= endPosition && (startPosition > 0 && endPosition > 0) && this.my_string == null) {
			throw new NullPointerException("NullPointerException as the string is empty");
		}
		
		StringBuffer string_result = new StringBuffer();
		for(int i = 0; i < this.my_string.length(); i++) {
			if(Character.isDigit(my_string.charAt(i)) && i >= startPosition-1 && i <= endPosition - 1) {
				switch(my_string.charAt(i)) {
				case '0' :
					string_result.append("Zero");
					break;
				case '1' :
					string_result.append("One");
					break;
				case '2' :
					string_result.append("Two");
					break;
				case '3' : 
					string_result.append("Three");
					break;
				case '4' : 
					string_result.append("Four");
					break;
				case '5' : 
					string_result.append("Five");
					break;
				case '6' :
					string_result.append("Six");
					break;
				case '7' :
					string_result.append("Seven");
					break;
				case '8' : 
					string_result.append("Eight");
					break;
				case '9' :
					string_result.append("Nine");
					break;
				}
			}
			else string_result.append(this.my_string.charAt(i));
		}
		this.my_string = string_result.toString();
	}
}