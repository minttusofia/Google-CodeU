package session3;

public class TrivialDictionary {
	private String[] words = {"hey","look","some","test","words"};
	
	public String wordAt(int index) {
		if (index >= words.length) {
			return null;
		}
		return words[index];
	}
}
