package modulzaro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;



public class Main {
	
	public static int valami;
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
			beolvas.readLine();
			valami = Integer.parseInt(beolvas.readLine());
			while ((sor = beolvas.readLine()) != null) {
				osszSzoveg += sor + "\n"; 
			}
			beolvas.close();
		} catch (FileNotFoundException e) {
			System.err.println("Nincs meg a fájl!");
		} catch (IOException e) {
			System.err.println("Hiba a fájl beolvasásánál!");
		}

		return osszSzoveg.split("\n");
	}
	public static List<Autok> autok() {
		List<Autok> autok = new ArrayList<Autok>();

		String[] sikeres = fajlbolOlvas("autok.csv");

		for (String sor : sikeres) {
			String[] split = sor.split(";");

			Autok auto = new Autok();
			auto.setMarka(split[0]);
            auto.setGyev(Integer.parseInt(split[1]));
            auto.setUa(split[2].charAt(0));
            auto.setSzin(split[3]);
			autok.add(auto);
		}

		return autok;
	}


	public static void main(String[] args) {
		
		List<Autok> autok = autok();
		String lista="";
		for (int i=0; i<autok.size();i++) {
			lista+=autok.get(i).toString()+ "\n";
		}
		
		System.out.println(lista);
		fajlbaIr("modzar.txt",lista);

	}

}
