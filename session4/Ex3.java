boolean isUglyNumber(int n) {
	int div = 1;
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
int kthUgly(int k) {
	int counter = 1;
	uglyN = 1;
	while (counter < k) {
		if (isUglyNumber(++uglyN)) {
			counter++;
		}
	}
	return uglyN;
}