package modulzaro;

public class Autok {
	
	private String marka;
	private int gyev;
	private char ua;
	private String szin;
	
	public String getMarka() {
		return marka;
	}
	public void setMarka(String marka) {
		this.marka = marka;
	}
	
	public int getGyev() {
		return gyev;
	}
	public void setGyev(int gyev) {
		this.gyev = gyev;
	}
	
	public char getUa() {
		return ua;
	}
	public void setUa(char ua) {
		this.ua = ua;
	}
	
	public String getSzin() {
		return szin;
	}
	public void setSzin(String szin) {
		this.szin = szin;
	}
	
	@Override
	public String toString() {
		return "Autok [Márka= " + marka + ", Gyártáséve= " + gyev + ", Üzemanyag= " + ua + ", Szín= " + szin + "]";
	}
	

}
