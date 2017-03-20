package repactoring.dto;

public class TestMain {

	public static void main(String[] args) {
           Movie mc1 = new Movie("니모를 찾아서", Movie.CHILDREN);
           Movie mc2 = new Movie ("말레피신트", Movie.CHILDREN);
           Movie mr1 = new Movie("명량", Movie.REGULAR);
           Movie mr2 = new Movie("변호사",Movie.REGULAR);
           Movie mn1 = new Movie("미녀와야수", Movie.NEW_RELEASE);
           Movie mn2 = new Movie("공조", Movie.NEW_RELEASE);
		
           Rental r1 = new Rental(mc1, 3);
           Rental r2 = new Rental(mc2, 4);
           Rental r3 = new Rental(mr1, 2);
           Rental r4 = new Rental(mr2, 3);
           Rental r5 = new Rental(mn1, 2);
           Rental r6 = new Rental(mn2, 3);
           
           Customer c1 = new Customer("전지현", null);
           	c1.addRental(r1);
           	c1.addRental(r3);
           	c1.addRental(r5);
           	
           	Customer c2 = new Customer("현빈", null);
           c2.addRental(r2);
           c2.addRental(r4);
           c2.addRental(r6);
           
           System.out.println(c1.htmlstatement());
           System.out.println("-----------------");
           System.out.println(c2.htmlstatement()); 
	}

}
