package dev.fernando.spring_pro_ch01;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import dev.fernando.spring_pro_ch01.entities.Order;
import dev.fernando.spring_pro_ch01.services.OrderService;

@Component
public class Program {
    private final OrderService orderService;

    public Program(OrderService orderService) {
        this.orderService = orderService;
    }

    public void run() {
        Locale.setDefault(Locale.ENGLISH);
        try (final Scanner scan = new Scanner(System.in)) {
            boolean usuarioDesejaContinuar = true;
            while (usuarioDesejaContinuar) {
                usuarioDesejaContinuar = false;
                System.out.println("Informe os dados do pedido(código, valor básico, porcentagem de desconto): ");
                int code = scan.nextInt();
                double basic = scan.nextDouble();
                double discount = scan.nextDouble();
                Order order = new Order(code, basic, discount);
                double total = this.orderService.total(order);
                scan.nextLine();
                System.out.println("Pedido código %d \nValor total R$ %.2f".formatted(order.getCode(), total));
                System.out.println(
                        "Deseja continuar? Digite \"S\" para \"sim\" ou qualquer outra tecla para recusar, seguido de ENTER.");
                String resposta = scan.nextLine();
                if (!resposta.isEmpty() && resposta.toLowerCase().charAt(0) == 's') {
                    usuarioDesejaContinuar = true;
                }
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }
}
