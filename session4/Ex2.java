boolean isPalindrome(String input) {
	for (int i = 0; i < input.size()/2+1; i++) {
		if (input.charAt(i) != input.charAt(input.size()-1-i)) {
			return false;
		}
	}
	return true;
}

int longestSubPalindrome(String input) {
	int maxLen = 1;
	int startIndex = -1;
	for (int i = 0; i < input.size()-1; i++) {
		for (int j = i+maxLen; j < input.size(); j++) {
			if (isPalindrome(input.substring(i,j+1)) && input.substring(i,j+1).size() > maxLen) {
				startIndex = i;
				maxLen = input.substring(i,j+1).size();
			}
			else {
				break;
			}
		}
	}
	return startIndex, maxLen;
}