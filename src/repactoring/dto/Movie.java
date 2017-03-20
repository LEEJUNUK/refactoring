package repactoring.dto;

public class Movie {
      private String title;
      private int priceCode;

      
      
      public Movie(String title, int priceCode) {
		super();
		this.title = title;
		this.priceCode = priceCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPriceCode() {
		return priceCode;
	}
	public void setPriceCode(int priceCode) {
		this.priceCode = priceCode;
	}
      
      
}
