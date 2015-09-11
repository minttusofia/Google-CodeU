package session3;
import java.util.ArrayList;

public class QueryStream {
	private ArrayList<Query> qstream;
	public QueryStream(ArrayList<Query> list) {
		qstream = list;
	}
	public void add(Query query) {
		qstream.add(query);
	}
	public Query get(int index) {
		return qstream.get(index);
	}
	public int size() {
		return qstream.size();
	}
}
