package session3;

public class Ex1 {
	// assuming the dictionary may not be in alpabetical order
	public boolean isInUnsortedDictionary(String word) {
	TrivialDictionary dict = new TrivialDictionary();
	for (int i = 0; dict.wordAt(i) != null; i++) {
			if (dict.wordAt(i).equals(word)) {
				return true;
			}
	}
		return false;
	}
	// assuming the dictionary is in alphabetical order
	public boolean isInDictionary(String word) {
	TrivialDictionary dict = new TrivialDictionary();
		int i = 100;
		int low = 0;
		while (dict.wordAt(i) != null) {
		// approximating actual length of dict to improve binary search
			i *= 2;
		}
		int high = i;
		i /= 2;
		while (dict.wordAt(i) == null || !dict.wordAt(i).equals(word)) {
			String currentWord = dict.wordAt(i);
			if (low == high || low + 1 == high) {
				return false;
			}
			if (currentWord == null || currentWord.compareTo(word) > 0) {
				high = i;
				i = (i + low)/2;
			}
			else if (currentWord.compareTo(word) < 0) {
				low = i;
				i = (i + high)/2;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Ex1 example = new Ex1();
		System.out.println(example.isInDictionary("test"));
		System.out.println(example.isInDictionary("hey"));
		System.out.println(example.isInDictionary("not"));
	}
}
