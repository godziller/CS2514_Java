
// The visit Class represents a Customers visit to the beauty saloon.
// It 'has-a' Customer instance, and that customer will use an instance
// of this class to determine what type of discount they can avail of
// for a service or product - dependent upon their membership level.
public class Visit {
	// 'has-a' customer reference
	private Customer customer;

	// Variables to record the visit expenses.
	private double serviceExpense;
	private double productExpense;

	// Constructor setting up a visit instance for a customer visit.
	public Visit(Customer customer){
		this.customer = customer;
		this.serviceExpense = 0.0;
		this.productExpense = 0.0;
	}

	// Record Service transactions
	public void setServiceExpense(double serviceExpense) {
	
		this.serviceExpense = serviceExpense;
	}

	// Record Product expenses
	public void setProductExpense(double productExpense) {

		this.productExpense = productExpense;
	}

	// Get the visit's service expense tally
	public double getServiceExpense() {
		return serviceExpense;
	}

	// Get the visit's product expense tally
	public double getProductExpense() {

		return productExpense;
	}


	public double getTotalExpense() {
		double serviceDiscount;
		double productDiscount;

		// Calculate service discount based on whether the customer is a member
		if (customer.isMember()) {
			serviceDiscount = serviceExpense * Discount.getServiceDiscountRate(customer.getMemberType());
		} else {
			serviceDiscount = 0.0;  // No discount if not a member
		}

		// Calculate product discount based on whether the customer is a member
		if (customer.isMember()) {
			productDiscount = productExpense * Discount.getProductDiscountRate(customer.getMemberType());
		} else {
			productDiscount = 0.0;  // No discount if not a member
		}

		// Calculate the total expense after applying the discounts
		return (serviceExpense - serviceDiscount) + (productExpense - productDiscount);

	}

	// Using override java annotation to make code usage more intutitive.
	@Override
	public String toString() {
		return customer.toString() +
			"\nService Expense: $" + serviceExpense +
			"\nProduct Expense: $" + productExpense +
			"\nTotal Bill: $" + String.format("%.2f", getTotalExpense());
	}
}
