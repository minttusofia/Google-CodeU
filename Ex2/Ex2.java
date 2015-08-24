package session3;

import java.util.HashMap;
import java.util.ArrayList;

public class Ex2 {
	public Integer hasMajority(ArrayList<Integer> collection) {
		int length = collection.size();
		if (length == 0) return null;
		HashMap<Integer,Integer> quantities = new HashMap<Integer,Integer>(1+length/2);
		for (int i = 0; i <= length/2; i++) {
			Integer value = collection.get(i);
			if (quantities.get(value) != null) {
				quantities.put(value, quantities.get(value)+1);
			}
			else quantities.put(value, 1);
		}
		for (int i = 1+ length/2; i < length; i++) {
			Integer value = collection.get(i);
			if (quantities.get(value) != null) {
				int newQuantity = quantities.get(value)+1;
				if (newQuantity > length/2) return value;
				quantities.put(value, newQuantity);
				
			}
		}
		return null;
	}
	public static void main(String args[]) {
		Ex2 example = new Ex2();
		ArrayList<Integer> collection = new ArrayList<Integer>();
		collection.add(4); collection.add(1); collection.add(4); collection.add(4);
		System.out.println(example.hasMajority(collection));
	}
}
