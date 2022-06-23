package herb.bank.payday.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String stock_name;
    private int quantity;
    private int order_num;
    private int order_price;
}
