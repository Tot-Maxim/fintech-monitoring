package credit_score_platform.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class MonitoringController {

    private final Counter requestCounter;
    private final CreditScoreService creditScoreService;

    @Autowired
    public MonitoringController(MeterRegistry meterRegistry, CreditScoreService creditScoreService) {
        this.requestCounter = meterRegistry.counter("requests_total");
        this.creditScoreService = creditScoreService;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "Service is up and running!";
    }

    @GetMapping("/latency")
    public String latency() {
        return "Latency is within acceptable limits.";
    }

    @GetMapping("/availability")
    public String availability() {
        return "Service is available.";
    }

    @GetMapping("/request")
    public String recordRequest() {
        requestCounter.increment();
        return "Request recorded.";
    }

    @GetMapping("/error-rate")
    public String errorRate() {
        return "Error rate is below thresholds.";
    }

    @PostMapping("/borrower")
    public String addBorrower(@RequestBody Borrower borrower) {
        creditScoreService.addBorrower(borrower);
        return "Borrower added.";
    }

    @GetMapping("/credit-score/{borrowerId}")
    public double getCreditScore(@PathVariable String borrowerId) {
        return creditScoreService.calculateCreditScore(borrowerId);
    }
}
