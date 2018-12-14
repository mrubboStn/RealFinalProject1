package pkgEmpty;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;

import pkgCore.Retirement;

public class RetirementTests {
	
	@Test
	public void testTotalAmountSaved() {
		Retirement.setiYearsRetired(20);
		Retirement.setdAnnualReturnRetired(.02);
		Retirement.setdMonthlySSI(2642);
		Retirement.setdRequiredIncome(10000);
		
		assertEquals(Retirement.TotalAmountSaved(), 1454485.55, .01);
		
	}
	
	@Test
	public void testAmountToSave() {
		Retirement.setdAnnualReturnWorking(.07);
		Retirement.setiYearsToWork(40);
		
		assertEquals(Retirement.AmountToSave(), 554.13, .01);
	}
	
	@AfterClass
	public static void clean () {
		Retirement.setiYearsRetired(0);
		Retirement.setdAnnualReturnRetired(0);
		Retirement.setdMonthlySSI(0);
		Retirement.setdRequiredIncome(0);
		Retirement.setdAnnualReturnWorking(0);
		Retirement.setiYearsToWork(0);
		Retirement.setdTotalAmountSaved(0);
		Retirement.setdAmountToSave(0);
	}
	

}
