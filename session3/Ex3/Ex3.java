package session3;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Ex3v3 {
	private List<Integer> numbers;
		public Ex3v3(List<Integer> numbers) {
			this.numbers = numbers;
	}
	public Integer nthLargest(Integer n) throws IllegalArgumentException {
		if (n == 0 || n > numbers.size()) {
			throw new IllegalArgumentException("Invalid value for n");
		}
		List<Integer> copy = new ArrayList<Integer>(numbers);
		copy.add(n);
		while (copy.size() > 2) {
			copy = partialQuickSort(copy); // is there a way to change two parameters in a Java method? Integer n and copy without having to combine them?
		}
		return copy.get(0);
	}
	private ArrayList<Integer> partialQuickSort(List<Integer> array) {
		ArrayList<Integer> smaller = new ArrayList<Integer>();
		ArrayList<Integer> larger = new ArrayList<Integer>();
		Integer n = array.get(array.size()-1);
		array.remove(array.size()-1);
		
		Random rand = new Random();
		Integer pivot = array.get(rand.nextInt(array.size()));
		for (Integer number : array) {
			if (number <= pivot) {
				smaller.add(number);
			}
			else {
				larger.add(number);
			}
		}
		if (larger.size() >= n) {
			larger.add(n);
			return larger;
		}
		else {
			n -= larger.size();
			smaller.add(n);
			return smaller;
		}
	}
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(3);
		numbers.add(-16);
		numbers.add(0);
		numbers.add(1);
		numbers.add(4);
		numbers.add(33);
		Ex3v3 example = new Ex3v3(numbers);		
		try {
			System.out.println(example.nthLargest(1));
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}

