package br.jafer.vagas.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.sound.midi.Soundbank;

public class testeGeral {

	public static void main(String[] args) {
		
		Calendar date = Calendar.getInstance();
	    date.setTime(new Date());
	    SimpleDateFormat f = new SimpleDateFormat("dd-MMMM-yyyy");
	    System.out.println(f.format(date.getTime()));
	    date.add(Calendar.YEAR,5);
	    System.out.println(f.format(date.getTime()));

//		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
//		Calendar instance = Calendar.getInstance();
//		instance.setTime(new Date());
//		instance.add(Calendar.YEAR, 5);
//
//		System.out.println("print instance" + sd.format(instance.getTime()));
//
//		// c.add(Calendar.YEAR,1);
//		// System.out.println(sd.format(c.getTime()));
	}

}
