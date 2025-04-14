package evaluation;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Transaction {
	private String date;
	private int amount;

	public Transaction(String date, int amount) {
		this.date = date;
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Transaction{date='" + date + "', amount=" + amount + "}";
	}
}

public class FindSumGroupByDate {
	public static void main(String[] args) {

		List<Transaction> transactions = Arrays.asList(new Transaction("2022-01-01", 100),
				new Transaction("2022-01-01", 200), new Transaction("2022-01-02", 300),
				new Transaction("2022-01-02", 400), new Transaction("2022-01-03", 500));

		Map<String, Integer> resultMap = transactions.stream()
				.collect(Collectors.groupingBy(Transaction::getDate, Collectors.summingInt(Transaction::getAmount)));
		System.out.println(resultMap);

		Map<String, Integer> result = transactions.stream()
				.collect(Collectors.groupingBy(Transaction::getDate, Collectors.summingInt(Transaction::getAmount)));
		System.out.println(result);

	}
}
