package credit_score_platform.demo;

public class Borrower {
    private final String id;
    private final double income;
    private final double totalDebt;

    public Borrower(String id, double income, double totalDebt) {
        this.id = id;
        this.income = income;
        this.totalDebt = totalDebt;
    }

    public String getId() {
        return id;
    }

    public double getIncome() {
        return income;
    }

    public double getTotalDebt() {
        return totalDebt;
    }
}
