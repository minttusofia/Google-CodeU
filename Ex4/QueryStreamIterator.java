package session3;
import java.util.ArrayList;

public class QueryStreamIterator {
	private QueryStream qstream;
	private int currentQuery = 0;
	private int currentIndex = 0;
	public QueryStreamIterator(QueryStream qstream) {
		this.qstream = qstream;
	}
	private boolean hasNextQuery() {
		if (currentQuery < qstream.size()-1) {
			return true;
		}
		else return false;
	}
	private Query nextQuery() {
		currentIndex = 0;
		System.out.println("<NEWQUERY>");
		return qstream.get(++currentQuery);
	}
	private String removeSpaces(String input) {
		int s = 0; int e = 0;
		for (s = 0; s < input.length(); s++) {
			if (input.charAt(s) != ' ') {
				break;
			}
		}
		for (e = input.length()-1; e >= 0; e--) {
			if (input.charAt(e) != ' ') {
				break;
			}
		}
		if (e<s) return "";
		return input.substring(s,e+1);
	}
	
	public boolean hasNext() {
		Query current = qstream.get(currentQuery);
		if (current.hasNextWord(currentIndex)) {
			return true;
		}
		else while (hasNextQuery()) {
			current = nextQuery();
			if (current.hasNextWord(currentIndex)) {
				return true;
			}
		}
		return false;
	}
	public String next() {
		Query current = qstream.get(currentQuery);
		if (current.hasNextWord(currentIndex)) {
			int returnIndex = currentIndex;
			currentIndex += current.nextWord(currentIndex).length();
			return removeSpaces(current.nextWord(returnIndex));
			
		}
		else while (hasNextQuery()) {
			current = nextQuery();
			if (current.hasNextWord(currentIndex)) {
				int returnIndex = currentIndex;
				currentIndex += current.nextWord(currentIndex).length();
				return removeSpaces(current.nextWord(returnIndex));
			}
		}
		return "";
	}
	public static void main(String[] args) {
		Query first = new Query("first query! ");
		Query second = new Query("second  words  here");
		Query third = new Query("this is the     third    MeSSage   ");
		QueryStream qs = new QueryStream(new ArrayList<Query>());
		qs.add(first);
		qs.add(second);
		qs.add(third);
		QueryStreamIterator qsi = new QueryStreamIterator(qs);
		while (qsi.hasNext()) {
			System.out.println(qsi.next());
		}
	}
}
