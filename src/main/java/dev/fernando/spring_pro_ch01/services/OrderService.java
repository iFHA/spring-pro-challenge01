package dev.fernando.spring_pro_ch01.services;

import org.springframework.stereotype.Service;

import dev.fernando.spring_pro_ch01.entities.Order;

@Service
public class OrderService {
    private final ShippingService shippingService;

    public OrderService(final ShippingService shippingService) {
        this.shippingService = shippingService;
    }
    
    public double total(Order order) {
        final double discount = order.getBasic() * order.getDiscount() / 100;
        final double basicWithDiscount = order.getBasic() - discount;
        return basicWithDiscount + shippingService.shipment(order);
    }
}
