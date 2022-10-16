package example;

import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;


class Numbers {
	@Requires({ "a > 0", "b > 0" })
	@Ensures({ "result > a", "result > b" })
	int add(int a, int b) {
		return a - b;
	}
}