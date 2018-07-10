package arrays;

//public class Book implements Comparable{
public class book{
	//저장하고자 하는 항목
	private String title;
	private String author;
	private String pubdate;
	private int price;
	
	//접근자 메소드
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	//디버깅을 위한 메소드
	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", pubdate=" + pubdate + ", price=" + price + "]";
	}
	/*
	//크기비교를 하는 메소드
	@Override
	public int compareTo(Object o) {
		Book other = (Book)o;
		return this.title.compareTo(other.title);
	}
	*/
}



