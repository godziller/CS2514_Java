public class Discount {

	// Using private static variables to hold the discount rates.
	// This means there is one shared copy, ergo no instance will hold
	// duplicate info.
	private static double serviceDiscountPremium = 0.2;
	private static double serviceDiscountGold = 0.15;
	private static double serviceDiscountSilver = 0.1;
	private static double productDiscountPremium = 0.1;
	private static double productDiscountGold = 0.1;
	private static double productDiscountSilver = 0.1;


	// Public static method to get service discount rate based on the type
	public static double getServiceDiscountRate(String memberType) {
		// In case users of our API miss-type member string, force string to UPPER
        String upperType = memberType.toUpperCase();

		// switch statement will control the correct rate returned for the
		// membership level.
		switch (upperType) {
			case "PREMIUM":
				// Note here and below - I don't have to do a 'this.'
				// as my rates are private static :-)
				return serviceDiscountPremium;
			case "GOLD":
				return serviceDiscountGold;
			case "SILVER":
				return serviceDiscountSilver;
			default:
				return 0.0; // Default return value of 0% discount
		}
	}

	// Public static method to get product discount rate based on membership type
	public static double getProductDiscountRate(String memberType) 	{
		// In case users of our API miss-type member string, force string to UPPER
        String upperType = memberType.toUpperCase();

		// switch statement will control the correct rate returned for the
		// membership level.
		switch (upperType) {
			case "PREMIUM":
				return productDiscountPremium;
			case "GOLD":
				return productDiscountGold;
			case "SILVER":
				return productDiscountSilver;
			default:
				return 0.0; // Default return value of 0% discount
		}
	}
}
