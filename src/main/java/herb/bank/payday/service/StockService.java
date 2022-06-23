package herb.bank.payday.service;

import herb.bank.payday.entity.Stock;
import herb.bank.payday.repo.StockRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StockService {

    private final StockRepository stockRepo;

    public StockService(StockRepository stockRepo) {
        this.stockRepo = stockRepo;
    }

    public void addStock(Stock stock) {
        stockRepo.save(stock);
    }

    public void deleteById(int id) {
        stockRepo.deleteById(id);
    }

    public Stock getStock(int id) {
        Optional<Stock> optionalStock = stockRepo.findById(id);
        return optionalStock.orElseGet(Stock::new);
    }

    public ArrayList<Stock> getAll() {
        ArrayList<Stock> stocks = new ArrayList<>();
        stockRepo.findAll().forEach(stocks::add);
        return stocks;
    }
}
