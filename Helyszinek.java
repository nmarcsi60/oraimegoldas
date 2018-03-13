package vizsga;

public class Helyszinek {
	
	private String helyszin;
    private int szakasz1;
    private int szakasz2;
    private int szakasz3;
	@Override
	public String toString() {
		return helyszin + ", 1.szakasz= " + szakasz1 +" km, 2.szakasz=" + szakasz2 + "km, 3.szakasz="
				+ szakasz3 + " km";
	}
	public String getHelyszin() {
		return helyszin;
	}
	public void setHelyszin(String helyszin) {
		this.helyszin = helyszin;
	}
	public int getSzakasz1() {
		return szakasz1;
	}
	public void setSzakasz1(int szakasz1) {
		this.szakasz1 = szakasz1;
	}
	public int getSzakasz2() {
		return szakasz2;
	}
	public void setSzakasz2(int szakasz2) {
		this.szakasz2 = szakasz2;
	}
	public int getSzakasz3() {
		return szakasz3;
	}
	public void setSzakasz3(int szakasz3) {
		this.szakasz3 = szakasz3;
	}
}