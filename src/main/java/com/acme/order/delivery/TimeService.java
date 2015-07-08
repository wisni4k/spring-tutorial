package com.acme.order.delivery;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class TimeService {

	public Date now() {
		return new Date();
	}

}
