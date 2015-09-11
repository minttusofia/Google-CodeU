
boolean isPalindrome(String input) {
	for (int i = 0; i < input.size()/2 + 1; i++) {
		if (input.charAt(i) != input.charAt(input.size()-1-i)) {
			return false;
		}
	}
	return true;
}

String intToBin(int i) {
	String bin = new String();
	while (i > 0) {
		bin = (char(i%2) + bin;
		i /= 2;
	}
	return bin;
}

int kthPalindromeInt(int k) {
	int counter = 1;
	int posInt = 1;
	while (counter < k) {
		if (isPalindrome(intToBin(++posInt))) {
			counter++;
		}
	}
	return posInt;
}

int kthPalindromeIntWithLeadingZeros(int k) {
	int counter = 1;
	int posInt = 1;
	while (counter < k) {
		posBin = intToBin(++posInt)
		for (int j = posBin.size()-1; j > 0; j--) {
			if (posBin[j] == '0') {
				posBin = '0' + posBin;
			}
			else {
				break;
			}
		}
		if (isPalindrome(posBin) {
			counter++;
		}
	}
	return posInt;
}