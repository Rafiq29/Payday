package herb.bank.payday.controller;

import herb.bank.payday.entity.Order;
import herb.bank.payday.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/buy/{id}")
    public Order buy(@RequestBody Order order, @PathVariable("id") int id) {
        return service.buy(order, id);
    }

    @PostMapping("/sell/{id}")
    public Order sell(@RequestBody Order order, @PathVariable("id") int id) {
        return service.sell(order, id);
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable("id") Order order) {
        return service.getOrder(order.getId());
    }

    @GetMapping
    public Iterable<Order> getAll() {
        return service.getAll();
    }

    @PostMapping
    public String place(@RequestBody Order order) {
        service.placeOrder(order);
        return "Order placed";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        service.deleteById(id);
        return "Deleted";
    }
}
