package com.pm.ck.Service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class ClockServiceImpl implements ClockService {

	@Override
	public String timeConvert() {

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		String t = sdf.format(date);
		//System.out.println(t);

		int hour = Integer.parseInt(t.substring(0, 2));
		int min = Integer.parseInt(t.substring(3));

		if (hour == 0 && min == 0) {
			return "It is Midnight";
		}

		if (hour == 12 && min == 0) {
			return "It is Midday";
		}

		String[] numbers = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
				"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen" };
		String[] tens = { "", "", "twenty", "thirty", "forty", "fifty" };

		String hourWord = "";
		if (hour < 20) {
			hourWord = numbers[hour];
		} else {
			hourWord = tens[hour / 10] + " " + numbers[hour % 10];
		}

		String minuteWord = "";
		if (min < 20) {
			minuteWord = numbers[min];
		} else {
			minuteWord = tens[min / 10] + " " + numbers[min % 10];
		}

		String words = "It is " + hourWord + " " + minuteWord;
		return words;
	}
}
