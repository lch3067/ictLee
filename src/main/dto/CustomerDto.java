package main.dto;

import java.sql.Timestamp;
import java.time.LocalDate;
import main.common.enums.CustomerGrade;

// 고객 DTO
public class CustomerDto extends OrderDto {

    private String customerId;
    private String userId;
    private String name;
	private CustomerGrade grade;
    private long totalOrder;
    private Timestamp lastOrderDate;
    
	public CustomerDto() {}

	public CustomerDto(String customerId, String userId, String name, CustomerGrade grade, long totalOrder,
			Timestamp lastOrderDate) {
		this.customerId = customerId;
		this.userId = userId;
		this.name = name;
		this.grade = grade;
		this.totalOrder = totalOrder;
		this.lastOrderDate = lastOrderDate;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CustomerGrade getGrade() {
		return grade;
	}

	public void setGrade(CustomerGrade grade) {
		this.grade = grade;
	}

	public long getTotalOrder() {
		return totalOrder;
	}

	public void setTotalOrder(long totalOrder) {
		this.totalOrder = totalOrder;
	}

	public Timestamp getLastOrderDate() {
		return lastOrderDate;
	}

	public void setLastOrderDate(Timestamp lastOrderDate) {
		this.lastOrderDate = lastOrderDate;
	}
	
}
