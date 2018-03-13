package vizsga;



	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileNotFoundException;
	import java.io.FileOutputStream;
	import java.io.FileReader;
	import java.io.IOException;
	import java.io.OutputStreamWriter;
    import java.text.NumberFormat;
    import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;

	public class Main {

		public static int osszesresztvevo;

		/**
		 * fajlbaIr("statisztika.txt", "Ez meg ures!");
		 * 
		 * String fajlnev = "statisztika.txt"; String adat = "Ez meg ures!";
		 * fajlbaIr(fajlnev, adat);
		 * 
		 */
		public static void fajlbaIr(String hova, String mit) {
			BufferedWriter kiir;
			try {
				kiir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(hova)));
				kiir.write(mit);
				kiir.flush();
				kiir.close();
			} catch (IOException e) {
				System.err.println("Hiba az írásnál!");
			}
		}

		public static String[] fajlbolOlvas(String file) {
			BufferedReader beolvas;
			String sor;
			String osszSzoveg = "";

			try {
				beolvas = new BufferedReader(new FileReader(new File(file)));
				osszesresztvevo = Integer.parseInt(beolvas.readLine());
				while ((sor = beolvas.readLine()) != null) {
					osszSzoveg += sor + "\n"; // osszSzoveg = osszSzoveg + sor + "\n";
				}
				beolvas.close();
			} catch (FileNotFoundException e) {
				System.err.println("Nincs meg a fájl!");
			} catch (IOException e) {
				System.err.println("Hiba a fájl beolvasásánál!");
			}

			return osszSzoveg.split("\n");
		}

		
		public static String helyszinBeolvas(List<Helyszinek> a) {
			Scanner beolvas = new Scanner(System.in);
			String kiir = null;
			String hely = null;
			
			System.out.println("Adjon meg egy  (balatoni)  városnevet: ");
			hely = beolvas.next();
			//System.out.println(hely);
			
			for (Helyszinek helyszinek : a) {
				if(helyszinek.getHelyszin().equals(hely)) {
					kiir = "Az adott város versenyszakaszai: " + helyszinek.getSzakasz1() + " km " 
										 + helyszinek.getSzakasz2() + " km "
										+ helyszinek.getSzakasz3() + " km.";
					break;
				} else {
					kiir = "Ez a város nem szerepel a verseny állomásai között!";
				}
			}
			beolvas.close();
			return kiir;
		}
		
		public static int teljeshossz(List<Helyszinek> a) {
			int osszhossz = 0;

			for (int i = 0; i < a.size(); i++) {
				osszhossz += a.get(i).getSzakasz1() + a.get(i).getSzakasz2() + a.get(i).getSzakasz3();
			}
			return osszhossz;
		}
		
		
		public static int maxhossz(List<Helyszinek> a) {
			int ossztav=0;
			for (Helyszinek helyszinek : a) {
				
				ossztav=helyszinek.getSzakasz1()+helyszinek.getSzakasz2()+helyszinek.getSzakasz3();
			}
			return ossztav;
		}
		
		public static String leghossz (List<Helyszinek> lista) {
	        int hossz;
	        int maxhossz=0;
	        String kiir = null;
	        for (Helyszinek helyszinek : lista) {
	            hossz=helyszinek.getSzakasz1()+helyszinek.getSzakasz2()+helyszinek.getSzakasz3();
	            if (hossz>maxhossz) {
	                maxhossz=hossz;
	                kiir=helyszinek.getHelyszin() + " " + maxhossz;
	            }
	        }    
	    return kiir;    
	    }
	    
	    public static float atlelsoszakhossz  (List<Helyszinek> lista) {
	        int tav= 0;
	        float atlhossz= (float) 0.00;
	        for (int i = 0; i < lista.size(); i++) {
	        tav+=lista.get(i).getSzakasz1();
	        }
	        atlhossz=(float)tav/(float)lista.size();
	        return atlhossz;
	        
	    }
	    
	    public static float atlletszam  (List<Helyszinek> lista) {
	        
	        float atlversszam=(float)osszesresztvevo/(float)lista.size();
	        
	        return atlversszam;
	    }
	    
	    
	    public static void statisztika (List<Helyszinek> lista) {
	        String adat="";
	        String cel = "statisztika.txt";
	        Double percent=0.00;
	        for (Helyszinek helyszinek : lista) {
	            percent = new Double(percent);
	            percent= ( helyszinek.getSzakasz1()+helyszinek.getSzakasz2()+helyszinek.getSzakasz3()) / (double)teljeshossz(lista);
	            NumberFormat percentFormatter;
	            String percentOut;
	            percentFormatter = NumberFormat.getPercentInstance();
	            percentOut = percentFormatter.format(percent);
	            adat+=helyszinek.getHelyszin() + ";" + percentOut  +"\n";   
	        }
	        
	        fajlbaIr(cel,adat);
	    }


		
		
		
		
		
		

		public static List<Helyszinek> helyszinek() {
			List<Helyszinek> helyszinek = new ArrayList<Helyszinek>();

			String[] sikeres = fajlbolOlvas("kerekpar.csv");

			for (String sor : sikeres) {
				String[] split = sor.split(";");

				Helyszinek hely = new Helyszinek();
				hely.setHelyszin(split[0]);
				hely.setSzakasz1(Integer.parseInt(split[1]));
				hely.setSzakasz2(Integer.parseInt(split[2]));
				hely.setSzakasz3(Integer.parseInt(split[3]));

				helyszinek.add(hely);
			}

			return helyszinek;
		}

		public static void main(String[] args) {

			List<Helyszinek> helyszin = helyszinek();

			if (!helyszin.isEmpty() && osszesresztvevo > 0) {
				System.out.println("2/1 részfeladat: Teljesítve, a fájl beolvasva.");
				System.out.println("2/2 részfeladat: A helyszínek száma: " + helyszin.size() + " db.");
				System.out.println("2/3 részfeladat: A versenysorozat teljes hossza: " + teljeshossz(helyszin) + " km.");
				System.out.println( "2/4 részfeladat: " + helyszinBeolvas(helyszin));
				//System.out.println(maxhossz(helyszin));
				System.out.println("2/5 részfeladat : A leghosszabb versenytávot adó település: " + leghossz(helyszin) + " km");
	            System.out.println("2/6 részfeladat: Az első szakaszok átlagos hossza: "+ atlelsoszakhossz(helyszin)    + " km");        
	            statisztika(helyszin);
	            System.out.println("2/7 részfeledat: A fájl létrehozva" );
	            System.out.println("2/8 részfeladat: Az átlagos versenyzőszám: " +atlletszam(helyszin) + " fő");

			}

		}

	}