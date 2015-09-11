package session3;
import java.sql.Timestamp;

public class Query {
	private String words;
	private Timestamp stamp;
	
	public Query(String message) {
		words = message;
	}

	public boolean hasNextWord(int startIndex) {
		for (int c = startIndex; c < words.length(); c++) {
			if (words.charAt(c) != ' ') {
				return true;
			}
		}
			return false;
	}
	public String nextWord(int startIndex) {
		int s; int e;
		for (s = startIndex; s < words.length(); s++) {
			if (words.charAt(s) != ' ') {
				break;
			}
		}
		for (e = s+1; e < words.length(); e++) {
			if (words.charAt(e) == ' ') {
				return words.substring(startIndex,e);
			}
		}
		return words.substring(startIndex,e);
	}
}
