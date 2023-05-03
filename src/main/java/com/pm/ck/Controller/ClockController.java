package com.pm.ck.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.ck.Service.impl.ClockServiceImpl;

@RestController
public class ClockController {

	@Autowired
	private ClockServiceImpl clockServiceImpl;

	@GetMapping("/time")
	public String getTimeInWords() {
		return clockServiceImpl.timeConvert();
	}
}
