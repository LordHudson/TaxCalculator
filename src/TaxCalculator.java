import java.text.NumberFormat;

public class TaxCalculator {

    private final double salary;

    public TaxCalculator(double salary) {
        this.salary = salary;
    }

    public void calculateTax() {
        //These are the minimum taxable income amounts for each tax bracket
        double minIncome0 = 1;
        double minIncome1 = 216201;
        double minIncome2 = 337801;
        double minIncome3 = 467501;
        double minIncome4 = 613601;
        double minIncome5 = 782201;
        double minIncome6 = 1656601;
        //These are the maximum taxable income amounts for each tax bracket
        double maxIncome0 = 216200;
        double maxIncome1 = 337800;
        double maxIncome2 = 467500;
        double maxIncome3 = 613600;
        double maxIncome4 = 782200;
        double maxIncome5 = 1656600;
        //These are the rates of tax for each tax bracket
        double rateOfTax0 = 18;
        double rateOfTax1 = 26;
        double rateOfTax2 = 31;
        double rateOfTax3 = 36;
        double rateOfTax4 = 39;
        double rateOfTax5 = 41;
        double rateOfTax6 = 45;
        //These are the basic amount of tax for each tax bracket after the first one (which has no basic tax amount)
        double basicTaxAmount1 = 38916;
        double basicTaxAmount2 = 70532;
        double basicTaxAmount3 = 110739;
        double basicTaxAmount4 = 163335;
        double basicTaxAmount5 = 229089;
        double basicTaxAmount6 = 587593;
        //calculates the amount of tax charged on salary/taxable income
        double taxAmount0 = rateOfTax0 / 100 * this.salary;
        double taxAmount1 = basicTaxAmount1 + (rateOfTax1 / 100) * (this.salary - maxIncome0);
        double taxAmount2 = basicTaxAmount2 + (rateOfTax2 / 100) * (this.salary - maxIncome1);
        double taxAmount3 = basicTaxAmount3 + (rateOfTax3 / 100) * (this.salary - maxIncome2);
        double taxAmount4 = basicTaxAmount4 + (rateOfTax4 / 100) * (this.salary - maxIncome3);
        double taxAmount5 = basicTaxAmount5 + (rateOfTax5 / 100) * (this.salary - maxIncome4);
        double taxAmount6 = basicTaxAmount6 + (rateOfTax6 / 100) * (this.salary - maxIncome5);

        if (this.salary < minIncome0) {
            System.out.println("Salary cannot be less than: " + currencyFormatter(minIncome0));
        } else if (this.salary > 0 && this.salary <= maxIncome0) {
            System.out.println("The amount of tax charged on your income is: " + currencyFormatter(taxAmount0) + "\n" +
                    "Your salary after tax is: " + currencyFormatter(this.salary-taxAmount0));
        } else if (this.salary >= minIncome1 && this.salary <= maxIncome1) {
            System.out.println("The amount of tax charged on your income is: " + currencyFormatter(taxAmount1) + "\n" +
                    "Your salary after tax is: " + currencyFormatter(this.salary-taxAmount1));
        } else if (this.salary >= minIncome2 && this.salary <= maxIncome2) {
            System.out.println("The amount of tax charged on your income is: " + currencyFormatter(taxAmount2) + "\n" +
                    "Your salary after tax is: " + currencyFormatter(this.salary-taxAmount2));
        } else if (this.salary >= minIncome3 && this.salary <= maxIncome3) {
            System.out.println("The amount of tax charged on your income is: " + currencyFormatter(taxAmount3) + "\n" +
                    "Your salary after tax is: " + currencyFormatter(this.salary-taxAmount3));
        } else if (this.salary >= minIncome4 && this.salary <= maxIncome4) {
            System.out.println("The amount of tax charged on your income is: " + currencyFormatter(taxAmount4) + "\n" +
                    "Your salary after tax is: " + currencyFormatter(this.salary-taxAmount4));
        } else if (this.salary >= minIncome5 && this.salary <= maxIncome5) {
            System.out.println("The amount of tax charged on your income is: " + currencyFormatter(taxAmount5) + "\n" +
                    "Your salary after tax is: " + currencyFormatter(this.salary-taxAmount5));
        } else if (this.salary > minIncome6) {
            System.out.println("The amount of tax charged on your income is: " + currencyFormatter(taxAmount6) + "\n" +
                    "Your salary after tax is: " + currencyFormatter(this.salary-taxAmount6));
        }
    }

    private String  currencyFormatter(double money) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(money);
    }
}
