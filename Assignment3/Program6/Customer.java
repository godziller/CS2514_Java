public class Customer {
	private String name;
	private String memberType;
	private boolean member;

	public Customer(String name) {
		this.name = name;
		this.member = false;
		this.memberType = "None";
	}

	public String getName() {
		return name;
	}

	public boolean isMember() {
		return member;
	}

	public void setMember(boolean member){
		this.member = member;
	}

	public String getMemberType() {
		return this.memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
		this.member = !memberType.equals("None");
	}

	@Override
	public String toString() {
		return "Customer: " + name +
			"\nMember: " + (member ? "Yes" : "No") +
			"\n Member Type: " + memberType;
	}
}
