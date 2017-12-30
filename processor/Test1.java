package processor;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test1 {

	@Test
	public void test1() 
	{
		CreditCard card = new CreditCard("Bill" ,"4111111111111111", "$500");
		card.charge("$100");
		card.charge("$200");
		assertEquals(300, card.getBalance());
	}
	
	@Test
	public void test2() 
	{
		CreditCard card = new CreditCard("Bill" ,"4111111111111111", "$500");
		card.charge("$100");
		card.charge("$200");
		card.charge("$500");
		assertEquals(300, card.getBalance());
	}
	
	@Test
	public void test3() 
	{
		CreditCard card = new CreditCard("Bill" ,"41111111121111111", "$500");
		card.charge("$100");
		card.charge("$200");
		card.charge("$500");
		assertEquals(0, card.getBalance());
	}
	
	@Test
	public void test4() 
	{
		CreditCard card = new CreditCard("Bill" ,"41111111121111111", "$500");
		assertEquals(false, card.getValidity());
	}
	
	@Test
	public void test5() 
	{
		CreditCard card = new CreditCard("Bill" ,"4111111111111111", "$500");
		card.charge("$100");
		card.credit("$200");
		card.credit("$500");
		assertEquals(-600, card.getBalance());
	}
	
	@Test
	public void test6() 
	{
		CreditCard card = new CreditCard("Bill" ,"411111111111111100000", "$500");
		card.charge("$100");
		card.credit("$200");
		card.credit("$500");
		assertEquals(false, card.getValidity());
	}
	
	@Test
	public void test7() 
	{
		CreditCard card = new CreditCard("Bill" ,"411111111111111100000", "$500");
		card.charge("$100");
		card.credit("$200");
		card.credit("$500");
		String val = card.getData();
		assertEquals("Bill: Error",val);
	}

}
