package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eTitle;

public class Staff_Test {

	@BeforeClass
	public static void setup() {
	}
	
	@Test
	public void testAverage() throws PersonException {
		ArrayList<Staff> staff = new ArrayList<Staff>();
		staff.add( new Staff ("Addam", "Freddy", "Gudd", new GregorianCalendar(1995, 1, 27).getTime(), "10 E Delaware Ave", "123-456-7890", "gudda@udel.edu", "9am-10am Fridays only", 0, 20, new GregorianCalendar(2016, 3, 20).getTime(), eTitle.MR));
		staff.add( new Staff("Becky", null, null, new GregorianCalendar(1996, 2, 28).getTime(), null, "123-456-7890", null, null, 0, 30, null, null));
		staff.add( new Staff("Cole", null, null, new GregorianCalendar(1997, 3, 29).getTime(), null, "123-456-7890", null, null, 0, 40, null, null));
		staff.add(new Staff("Dale", null, null, new GregorianCalendar(1798, 4, 30).getTime(), null, "123-456-7890", null, null, 0, 50, null, null));
		staff.add(new Staff("Elizabeth", null, null, new GregorianCalendar(1999, 5, 31).getTime(), null, "123-456-7890", null, null, 0, 60, null, null));

		assertEquals((staff.get(0).getSalary() + staff.get(1).getSalary() + staff.get(2).getSalary() + staff.get(3).getSalary() + staff.get(4).getSalary())/5, 40, 0.01);
	}
	@Test  //(expected = PersonException.class)
	public void testExceptions() throws Exception {

		Staff tester = new Staff(null, null, null, new GregorianCalendar(1797, 8, 29).getTime(), null, "123456789", null, null, 0, 60000, null, null);

		final String regex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
		Pattern pattern = Pattern.compile(regex);
		String number = tester.getPhone();
		Matcher matcher = pattern.matcher(number);

		assertEquals(matcher.replaceFirst("($1) $2-$3").equals(number), true);

		Calendar now = Calendar.getInstance();
		now.add(Calendar.YEAR,-100);
		assertEquals(tester.getDOB().before(now.getTime()), true);
	}
	
}
