package herb.bank.payday.service;

import herb.bank.payday.entity.Order;
import herb.bank.payday.entity.User;
import herb.bank.payday.repo.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepo;

    public OrderService(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    public void placeOrder(Order order) {
        orderRepo.save(order);
    }

    public Order buy(Order order, int id) {
        return orderRepo.findById(id)
                .filter(o -> order.getOrder_price() <= o.getOrder_price())
                .orElseGet(Order::new);
    }

    public Order sell(Order order, int id) {
        return orderRepo.findById(id)
                .filter(o -> order.getOrder_price() >= o.getOrder_price())
                .orElseGet(Order::new);
    }

    public void deleteById(int id) {
        orderRepo.deleteById(id);
    }

    public Order getOrder(int id) {
        Optional<Order> optionalOrder = orderRepo.findById(id);
        return optionalOrder.orElseGet(Order::new);
    }

    public ArrayList<Order> getAll() {
        ArrayList<Order> orders = new ArrayList<>();
        orderRepo.findAll().forEach(orders::add);
        return orders;
    }
}
