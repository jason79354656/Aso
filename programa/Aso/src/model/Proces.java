package model;

public class Proces {
	public String name;
	public int timearriaval;
	public int timecpu;
	public int priority;
	
	public Proces(String name, int timearriaval, int timecpu, int priority) {
		
		this.name = name;
		this.timearriaval = timearriaval;
		this.timecpu = timecpu;
		this.priority = priority;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTimearriaval() {
		return timearriaval;
	}
	public void setTimearriaval(int timearriaval) {
		this.timearriaval = timearriaval;
	}
	public int getTimecpu() {
		return timecpu;
	}
	public void setTimecpu(int timecpu) {
		this.timecpu = timecpu;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	







}
