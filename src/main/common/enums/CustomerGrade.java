package main.common.enums;

public enum CustomerGrade {
	STANDARD(0.0), SILVER(0.05), GOLD(0.10), PLATINUM(0.15);

	private final double rate;

	CustomerGrade(double rate) {
		this.rate = rate;
	}

	public double getRate() {
		return rate;
	}
}
