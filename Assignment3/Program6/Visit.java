public class Visit {
	private Customer customer;
	private double serviceExpense;
	private double productExpense;

	public Visit(Customer customer){
		this.customer = customer;
		this.serviceExpense = 0.0;
		this.productExpense = 0.0;
	}

	public void setServiceExpense(double serviceExpense) {
	
		this.serviceExpense = serviceExpense;
	}

	public void setProductExpense(double productExpense) {
		this.productExpense = productExpense;
	}

	public double getServiceExpense() {
		return serviceExpense;
	}

	public double getProductExpense() {
		return productExpense;
	}

	public double getTotalExpense() {
		double serviceDiscount = customer.isMember() ?
			serviceExpense * Discount.getServiceDiscountRate(customer.getMemberType()) : 0.0;

		double productDiscount = customer.isMember() ?
			productExpense = Discount.getProductDiscountRate() : 0.0;
		return (serviceExpense - serviceDiscount) + (productExpense - productDiscount);

	}

	@Override
	public String toString() {
		return customer.toString() +
			"\nService Expense: $" + serviceExpense +
			"\nProduct Expense: $" + productExpense +
			"\nTotal Bill: $" + String.format("%.2f", getTotalExpense());
	}
}
