package desafio.itau.springboot.controller;

import desafio.itau.springboot.dto.TransactionRequest;
import desafio.itau.springboot.model.Transaction;
import desafio.itau.springboot.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/transacao")
public class TransactionController {
    private final TransactionService transactionService;


    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid  @RequestBody TransactionRequest request)
    {
        if(request.getDataHora().isAfter(OffsetDateTime.now()) || request.getValor() <= 0)
        {
            return ResponseEntity.unprocessableContent().build();
        }
        transactionService.addTransaction(new Transaction(request.getDataHora(), request.getValor()));
        return (ResponseEntity.status(HttpStatus.CREATED).build());
    }

    @DeleteMapping
    public ResponseEntity<Void> clearTransaction() {
        transactionService.clearTransaction();
        return ResponseEntity.ok().build();
    }
}
