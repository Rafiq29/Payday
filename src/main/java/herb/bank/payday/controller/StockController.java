package herb.bank.payday.controller;

import herb.bank.payday.entity.Stock;
import herb.bank.payday.service.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/stocks")
public class StockController {

    private final StockService service;

    public StockController(StockService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Stock getById(@PathVariable("id") Stock stock) {
        return service.getStock(stock.getId());
    }

    @GetMapping
    public Iterable<Stock> getAll() {
        return service.getAll();
    }

    @PostMapping
    public String addStock(@RequestBody Stock stock) {
        service.addStock(stock);
        return "Stock added";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "Deleted";
    }
}
