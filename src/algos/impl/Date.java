package algos.impl;

public class Date implements Comparable<Date>{
	
	private final int day, month, year;
	
	public Date(int month, int day, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}

	@Override
	public int compareTo(Date that) {
		
		if (this.year < that.year) return -1;
		if (this.year > that.year) return 1;
		if (this.month < that.month) return -1;
		if (this.month > that.month) return 1;
		if (this.day < that.day) return -1;
		if (this.day > that.day) return 1;
		return 0;
	}

	@Override
	public boolean equals(Object y) {
		if (y == this) return true;

		if (y == null) return false;

		if(y.getClass() != this.getClass())
			return false;

		Date that = (Date) y;
		if(this.year != that.year) return false;
		if(this.month != that.month) return false;
		if(this.day != that.day) return false;

		return false;
	}

}
