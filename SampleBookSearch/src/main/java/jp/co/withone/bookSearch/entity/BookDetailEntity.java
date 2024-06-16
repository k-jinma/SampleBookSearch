package jp.co.withone.bookSearch.entity;

public class BookDetailEntity {

	/** 図書ID */
	private int id;
	
	/** ISBN */
	private String isbn;
	
	/** JANコード */
	private String jan_code;
	
	/** タイトル */
	private String title;
	
	/** 著者名 */
	private String author;
	
	/** 出版社名 */
	private String name;
	
	/** 出版年月日 */
	private String publish_date;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getJan_code() {
		return jan_code;
	}

	public void setJan_code(String jan_code) {
		this.jan_code = jan_code;
	}

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}
	
	
}
