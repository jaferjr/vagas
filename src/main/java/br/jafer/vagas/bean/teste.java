package br.jafer.vagas.bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class teste {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
//		
//		InputStreamReader streamReader = new InputStreamReader(System.in);
//		BufferedReader reader = new BufferedReader(streamReader);
//		
//		int a,b,x;
//		
//		a=reader.read();
//		b=reader.read();
//		
//		x=a+b;
//		
//		System.out.printf("X = \n",x);
//		
		
		Scanner sc=new Scanner(System.in);
		
		int a= sc.nextInt();
		int b=sc.nextInt();
		sc.close();
		
		int x = a + b;
		
		System.out.printf("X = %d\n",x);
		
		

	}

}
