package jp.co.withone.bookSearch.entity;

import java.util.Date;

public class BookAndPublisherEntity {

//    * 図書ID
//  */
    private int id;

    /**
     * ISBN
     */
    private String isbn;

    /**
     * JANコード
     */
    private String janCode;

    /**
     * タイトル
     */
    private String title;

    /**
     * 著者名
     */
    private String author;

    /**
     * 出版社ID
     */
    private String publisherId;

    /**
     * 出版年月日
     */
    private Date publishDate;
//  
//  出版社コード

    private String code;

//  出版社名

    private String name;

//  郵便番号

    private String zipCode;

//  住所

    private String address;


    /*
     * 図書IDを取得。
     */
    
    public int getId() {
        return id;
    }

    /**
     * 図書IDを設定。
     * 
     */
    
    public void setId(int id) {
        this.id = id;
    }
    /**
     * ISBNを取得。
     * 
     */


    public String getIsbn() {
        return isbn;
    }

    /**
     * ISBNを設定。
     * 
     */
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    /**
     * JANコードを取得。
     * 
     */

    public String getJanCode() {
        return janCode;
    }
    
    /**
     * JANコードを設定。
     * 
     */

    public void setJanCode(String janCode) {
        this.janCode = janCode;
    }
    

    /**
     * タイトルを取得。
     * 
     */

    public String getTitle() {
        return title;
    }
    
    /**
     * タイトルを設定。
     * 
     */

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 著者名を取得。
     * 
     */
    
    public String getAuthor() {
        return author;
    }
    
    /**
     * 著者名を設定。
     * 
     */

    public void setAuthor(String author) {
        this.author = author;
    }
    
    /**
     * 出版社IDを取得。
     * 
     */

    public String getPublisherId() {
        return publisherId;
    }
    
    /**
     * 出版社IDを設定。
     * 
     */

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }
    
    /**
     * 出版年月日を取得。
     * 
     */

    public Date getPublishDate() {
        return publishDate;
    }
    
    /**
     * 出版年月日を設定。
     * 
     */

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
    
    /**
     * 出版社コードを取得。
     * 
     */

    public String getCode() {
        return code;
    }
    
    /**
     * 出版社コードを設定。
     * 
     */

    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 出版社名を取得。
     * 
     */
    
    public String getName() {
        return name;
    }
    
    /**
     * 出版社名を設定。
     * 
     */
    
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * 郵便番号を取得。
     * 
     */

    public String getZipCode() {
        return zipCode;
    }
    
    /**
     * 郵便番号を設定。
     * 
     */

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    /**
     * 住所を取得。
     * 
     */

    public String getAddress() {
        return address;
    }
    
    /**
     * 住所を設定。
     * 
     */

    public void setAddress(String address) {
        this.address = address;
    }

}