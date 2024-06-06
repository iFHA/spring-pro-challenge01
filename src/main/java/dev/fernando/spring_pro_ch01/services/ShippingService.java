package dev.fernando.spring_pro_ch01.services;

import org.springframework.stereotype.Service;

import dev.fernando.spring_pro_ch01.entities.Order;

@Service
public class ShippingService {
    public double shipment(final Order order) {
        double basic = order.getBasic();
        if(basic < 100) {
            return 20;
        }
        if (basic < 200) {
            return 12;
        }
        return 0;
    }
}
