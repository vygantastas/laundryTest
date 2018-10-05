package lt.bit.laundry.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders", schema = "test", catalog = "")
public class Order {
	@Id
	@Column
	private int id;

	@Column
	private LocalDateTime time;

	@Column
	private double price;

	@Column
	private boolean done;

	public int getId() {
		return id;
	}

	public Order() {
		this.time = LocalDateTime.now();
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

}
