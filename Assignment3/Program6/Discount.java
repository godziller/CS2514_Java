public class Discount {
	public static double getServiceDiscountRate(String memberType){
		switch (memberType) {
			case "Premium":
				return 0.20;
			case "Gold":
				return 0.15;
			case "Silver":
				return 0.10;
			default:
				return 0.0;
		}
	}

	public static double getProductDiscountRate() {
		return 0.10;
	}
}
