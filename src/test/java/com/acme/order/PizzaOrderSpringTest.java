package com.acme.order;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.order.notification.MailSender;
import com.acme.order.pizza.PizzaOrderService;
import com.acme.order.pizza.PizzaType;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@Slf4j
public class PizzaOrderSpringTest {

	@Configuration
	//@ComponentScan("com.acme")
	static class MyTest {

		@Bean
		MailSender ms(){
			return new MailSender();
		}
		
	}

	@Autowired
	private MailSender mailSender;

	@Test
	public void testMailSender() {
		Assert.assertNotNull(mailSender);

	}
}
