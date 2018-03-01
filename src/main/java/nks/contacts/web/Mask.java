package nks.contacts.web;

public class Mask {

	private static final char DIGIT_MASK_ELEMENT = '9';
	private final String mask;

	public Mask(String mask) {
		this.mask = mask;
	}
	
	public String  getMaskValue(){
		return mask;
	}
	
	/**
	 * Casts input string to mask. If input is longer than mask rest of the characters will be added to the end
	 * 
	 * @param input
	 * @return casted input string
	 */
	public String cast(String input){
		StringBuilder stringBuilder = new StringBuilder();
		int inputIndex = 0;
		for(int maskIndex = 0; maskIndex < mask.length() && inputIndex < input.length(); ++maskIndex){
			char maskChar = mask.charAt(maskIndex);
			if(maskChar == DIGIT_MASK_ELEMENT){
				stringBuilder.append(getDigitByIndex(input, inputIndex));
				++inputIndex;
			}
			else{
				stringBuilder.append(maskChar);
			}
		}
		for(; inputIndex < input.length(); ++inputIndex){
			stringBuilder.append(getDigitByIndex(input, inputIndex));
		}
		return stringBuilder.toString();
	}

	private char getDigitByIndex(String input, int inputIndex) {
		char inputSymbol = input.charAt(inputIndex);
		assertDigit(inputSymbol);
		return inputSymbol;
	}
	
	private void assertDigit(char symbol){
		if (symbol < '0' && symbol > '9'){
			throw new WebException("Non didital elemet is supported for mask");
		}
	}
	
	
}
