public class Ex1ab {
	private boolean isPalindrome(String input) {
		for (int i = 0; i < input.length()/2 + 1; i++) {
			if (input.charAt(i) != input.charAt(input.length()-1-i)) {
				return false;
			}
		}
		return true;
	}

	public String intToBin(int i) {
		String bin = new String();
		while (i > 0) {
			bin = String.valueOf(i%2) + bin;
			i /= 2;
		}
		return bin;
	}

	public int kthPalindromeInt(int k) {
		int counter = 1;
		int posInt = 1;
		while (counter < k) {
			if (isPalindrome(intToBin(++posInt))) {
				counter++;
			}
		}
		return posInt;
	}

	public int kthPalindromeIntWithLeadingZeros(int k) {
		int counter = 1;
		int posInt = 1;
		while (counter < k) {
			String posBin = intToBin(++posInt);
			for (int j = posBin.length()-1; j > 0; j--) {
				if (posBin.charAt(j) == '0') {
					posBin = Character.toString('0') + posBin;
					j += 1;
				}
				else {
					break;
				}
			}
			if (isPalindrome(posBin)) {
				counter++;
			}
		}
		return posInt;
	}
}

public class Tuple() {
	int x;
	int y;
	public Tuple(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Ex2{
	public boolean isPalindrome(String input) {
		for (int i = 0; i < input.length()/2+1; i++) {
			if (input.charAt(i) != input.charAt(input.length()-1-i)) {
				return false;
			}
		}
		return true;
	}

	public Tuple<Integer,Integer> longestSubPalindrome(String input) {
		int maxLen = 1;
		int startIndex = 0;
		for (int i = 0; i < input.length()-1; i++) {
			for (int j = i+maxLen; j < input.length(); j++) {
				System.out.println(input.substring(i,j+1));
				if (isPalindrome(input.substring(i,j+1))) {
					startIndex = i;
					maxLen = input.substring(i,j+1).length();
				}
			}
		}
		return new Tuple<Integer,Integer>(startIndex, maxLen);
	}
}

public class Ex3 {
	public boolean isUglyNumber(int n) {
		int div = 2;
		while (n > 1) {
			if (div > 5) {
				return false;
			}
			while (n % div == 0) {
				n /= div;
			}
			div++;
		}
		return true;
	}
	public int kthUgly(int k) {
		int counter = 1;
		int uglyN = 1;
		while (counter < k) {
			if (isUglyNumber(++uglyN)) {
				counter++;
			}
		}
		return uglyN;
	}
}

public class Ex4 {
	public int makeChange(Integer total, ArrayList<Integer> coins) {
		int denoms = 0;
		ArrayList<Integer> remainingCoins = (ArrayList<Integer>) coins.clone();
		for (Integer coin : coins) {
			if (coin == total) {
				denoms++;
			}
			else if (coin < total) {
				denoms += makeSubChange(total-coin, remainingCoins);
			}
			remainingCoins.remove(0);
		}
		return denoms;
	}
	private int makeSubChange(int amount, ArrayList<Integer> coins) {
		int subDenoms = 0;
		ArrayList<Integer> remainingCoins = (ArrayList<Integer>) coins.clone();
		for (Integer coin : coins) {
			if (coin == amount) {
				subDenoms++;
			}
			else if (coin < amount) {
				subDenoms += makeSubChange(amount-coin, remainingCoins);
			}
			remainingCoins.remove(0);
		}
		return subDenoms;
	}
}

public class Ex5 {
	private boolean isInDict(String word, List<String> dict, int lower, int upper) {
		if (lower >= upper && dict.get(lower).compareTo(word) != 0) {
			return false;
		}
		int index = (upper+lower)/2;
		if (dict.get(index).compareTo(word) < 0) {
			return isInDict(word, dict, index+1, upper);
		}
		else if (dict.get(index).compareTo(word) > 0) {
			return isInDict(word, dict, lower, index-1);
		}
		else {
			return true;
		}
	}

	public String splitWords(String query, List<String> dict) {
		for (int j = 0; j < query.length(); j++) {
			if (isInDict(query.substring(0,j+1),dict, 0, dict.size()-1) && isInDict(query.substring(j+1,query.length()),dict, 0, dict.size()-1)) {
				return (query.substring(0,j+1) + " ") + query.substring(j+1, query.length());
			}
		}
		return null;
	}

	public ArrayList<String> allSplitWords(String query, String acc, List<String> dict) {
		ArrayList<String> allSplits = new ArrayList<String>();
		for (int j = 0; j < query.length(); j++) {
			if (isInDict(query.substring(0,j+1),dict,0,dict.size()-1)) {
				ArrayList<String> newSplits = allSplitWords(query.substring(j+1,query.length()), (acc + " " + query.substring(0,j+1)), dict);
				for (String split : newSplits) {
					allSplits.add(split);		
				}
			}
		}
		if (query.length() == 0) {
			allSplits.add(acc);
		}
		return allSplits;
	}
}