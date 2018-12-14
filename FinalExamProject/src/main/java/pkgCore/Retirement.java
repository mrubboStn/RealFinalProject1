package pkgCore;

import org.apache.poi.ss.formula.functions.FinanceLib;

public class Retirement {

	private static int iYearsToWork;
	private static double dAnnualReturnWorking;
	private static int iYearsRetired;
	private static double dAnnualReturnRetired;
	private static double dRequiredIncome;
	private static double dMonthlySSI;
	private static double dAmountToSave;
	private static double dTotalAmountSaved;
	
	//TODO: Build the contructor, getters and setters for the attributes above.
	
	
	
	
	public Retirement(int iYearsToWork, double dAnnualReturnWorking, int iYearsRetired, double dAnnualReturnRetired,
			double dRequiredIncome, double dMonthlySSI, double dTotalAmountSaved) {
		super();
		this.iYearsToWork = iYearsToWork;
		this.dAnnualReturnWorking = dAnnualReturnWorking;
		this.iYearsRetired = iYearsRetired;
		this.dAnnualReturnRetired = dAnnualReturnRetired;
		this.dRequiredIncome = dRequiredIncome;
		this.dMonthlySSI = dMonthlySSI;
		this.dTotalAmountSaved = dTotalAmountSaved;
	}

	public static int getiYearsToWork() {
		return iYearsToWork;
	}

	public static void setiYearsToWork(int ivalue) {
		Retirement.iYearsToWork = ivalue;
	}

	public static double getdAnnualReturnWorking() {
		return dAnnualReturnWorking;
	}

	public static void setdAnnualReturnWorking(double ivalue) {
		Retirement.dAnnualReturnWorking = ivalue;
	}

	public static int getiYearsRetired() {
		return iYearsRetired;
	}

	public static void setiYearsRetired(int ivalue) {
		Retirement.iYearsRetired = ivalue;
	}

	public static double getdAnnualReturnRetired() {
		return dAnnualReturnRetired;
	}

	public static void setdAnnualReturnRetired(double ivalue) {
		Retirement.dAnnualReturnRetired = ivalue;
	}

	public static double getdRequiredIncome() {
		return dRequiredIncome;
	}

	public static void setdRequiredIncome(double ivalue) {
		Retirement.dRequiredIncome = ivalue;
	}

	public static double getdMonthlySSI() {
		return dMonthlySSI;
	}

	public static void setdMonthlySSI(double ivalue) {
		Retirement.dMonthlySSI = ivalue;
	}

	public static double getdTotalAmountSaved() {
		return dTotalAmountSaved;
	}

	public static void setdTotalAmountSaved(double ivalue) {
		Retirement.dTotalAmountSaved = ivalue;
	}	

	public static double getdAmountToSave() {
		return dAmountToSave;
	}

	public static void setdAmountToSave(double ivalue) {
		Retirement.dAmountToSave = ivalue;
	}

	
	public static double AmountToSave()
	{
		//TODO: Determine the amount to save each month based on TotalAmountSaved, YearsToWork
		//		and Annual return while working
		setdAmountToSave(Math.abs(FinanceLib.pmt(dAnnualReturnWorking / 12, iYearsToWork * 12, 0, dTotalAmountSaved, false)));
		
		
		return dAmountToSave;
	}
	
	public static double TotalAmountSaved()
	{
		//	TODO: Determine amount to be saved based on Monthly SSI, Required Income, Annual return during retirement
		//		and number of years retired.
		//
		
		setdTotalAmountSaved(Math.abs(FinanceLib.pv(dAnnualReturnRetired / 12, iYearsRetired * 12, (dRequiredIncome - dMonthlySSI), 0, false)));
		
		return dTotalAmountSaved;
	}
}
