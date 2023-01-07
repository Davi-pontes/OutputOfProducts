package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.importedProduct;
import entities.product_;
import entities.usedProduct;

public class outputOfProducts {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner leitor = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<product_> list = new ArrayList<>();
		
		System.out.print("Enter the number od products: ");
		int n = leitor.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			char ch = leitor.next().charAt(0);
			System.out.print("Name: ");
			leitor.nextLine();
			String name = leitor.nextLine();
			System.out.print("Price: ");
			double price = leitor.nextDouble();
			
			if(ch == 'c') {
				list.add(new product_(name, price));
			}
			else if (ch == 'u') {
				System.out.print("Manufacture data (DD/MM/YYYY): ");
				Date date = sdf.parse(leitor.next());
				list.add(new usedProduct(name, price, date));
			}
			
			else  {
				System.out.print("Customs fee: ");
				double customsFee = leitor.nextDouble();
				list.add(new importedProduct(name, price, customsFee));
			}
			}
		System.out.println();
		System.out.println("PRICE TAGS: ");
		for (product_ pro : list ) {
			System.out.println(pro.priceTag());
		}
		leitor.close();

	}

}
