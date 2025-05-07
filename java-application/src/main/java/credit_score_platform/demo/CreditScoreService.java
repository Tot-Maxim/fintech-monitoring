package credit_score_platform.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CreditScoreService {
    private final Map<String, Borrower> borrowers = new HashMap<>();

    public void addBorrower(Borrower borrower) {
        borrowers.put(borrower.getId(), borrower);
    }

    public double calculateCreditScore(String borrowerId) {
        Borrower borrower = borrowers.get(borrowerId);
        if (borrower == null) {
            throw new IllegalArgumentException("Borrower not found");
        }
        // Простая логика для расчета скорингового балла
        double income = borrower.getIncome();
        double totalDebt = borrower.getTotalDebt();
        return Math.max(300, 850 - (totalDebt / income) * 100); // Наивная формула
    }
}
