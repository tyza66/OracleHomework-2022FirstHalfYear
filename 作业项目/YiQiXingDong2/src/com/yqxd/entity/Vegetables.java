package com.yqxd.entity;

public class Vegetables {
	int vegetable_id;
	String vegetable_kinds;
	int vegetable_number;
	String vegetable_place;

	public int getVegetable_id() {
		return vegetable_id;
	}

	public void setVegetable_id(int vegetable_id) {
		this.vegetable_id = vegetable_id;
	}

	public String getVegetable_kinds() {
		return vegetable_kinds;
	}

	public void setVegetable_kinds(String vegetable_kinds) {
		this.vegetable_kinds = vegetable_kinds;
	}

	public int getVegetable_number() {
		return vegetable_number;
	}

	public void setVegetable_number(int vegetable_number) {
		this.vegetable_number = vegetable_number;
	}

	public String getVegetable_place() {
		return vegetable_place;
	}

	public void setVegetable_place(String vegetable_place) {
		this.vegetable_place = vegetable_place;
	}

	public Vegetables(int vegetable_id, String vegetable_kinds, int vegetable_number, String vegetable_place) {
		super();
		this.vegetable_id = vegetable_id;
		this.vegetable_kinds = vegetable_kinds;
		this.vegetable_number = vegetable_number;
		this.vegetable_place = vegetable_place;
	}

	public Vegetables() {
		super();
	}

	@Override
	public String toString() {
		return "Vegetables [vegetable_id=" + vegetable_id + ", vegetable_kinds=" + vegetable_kinds
				+ ", vegetable_number=" + vegetable_number + ", vegetable_place=" + vegetable_place + "]";
	}

}
