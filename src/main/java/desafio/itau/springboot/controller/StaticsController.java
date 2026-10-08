package desafio.itau.springboot.controller;

import desafio.itau.springboot.dto.StatisticResponse;
import desafio.itau.springboot.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController()
@RequestMapping("estatisticas")
public class StaticsController {
    private final TransactionService transactionService;

    public StaticsController(TransactionService transactionService)
    {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<StatisticResponse> getStatics()
    {
        DoubleSummaryStatistics stats =  transactionService.getStatics();
        return (ResponseEntity.ok(new StatisticResponse(stats)));
    }

}
