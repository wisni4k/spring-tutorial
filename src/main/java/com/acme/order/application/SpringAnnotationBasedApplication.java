package com.acme.order.application;

import java.lang.annotation.Annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.acme.order.Customer;
import com.acme.order.pizza.PizzaOrderService;
import com.acme.order.pizza.PizzaType;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpringAnnotationBasedApplication {

	public static void main(String[] args) {
		log.info("Spring XML based application");
		
		AnnotationConfigApplicationContext ctx  = new AnnotationConfigApplicationContext();
		ctx.scan("com.acme");
		ctx.refresh();
		PizzaOrderService myService = ctx.getBean(PizzaOrderService.class);
		
		Customer customer1 = new Customer("John Smith", "john@smith.com", "Lodz, Jaracza 74");
		Customer customer2 = new Customer("Jan Kowalski", "jan@kowalski.pl", "Lodz, Piotrkowska 100");
		
		String orderId1 = myService.createOrder(customer1, PizzaType.LARGE);
		String orderId2 = myService.createOrder(customer2, PizzaType.SMALL);

		log.info("Unprocessed orders:{}", myService.fetchUnprocessed());
		log.info("Delivered orders:{}", myService.fetchDelivered());

		myService.deliverOrder(orderId1);
		log.info("Delivered orders:{}", myService.fetchDelivered());
		myService.cancelOrder(orderId2);
		log.info("Delivered orders:{}", myService.fetchDelivered());
		log.info("Cancelled orders:{}", myService.fetchCancelled());
		log.info("Unprocessed orders:{}", myService.fetchUnprocessed());
	}
}
