package jp.co.withone.bookSearch.entity;

import java.io.Serializable;
import java.sql.Date;

/**
 * 図書情報テーブル用エンティティ。
 * 
 * @author education
 *
 */
public class BookEntity implements Serializable {

    /**
     * シリアライズ化した際のバージョンID（気にせずこのまま使用して良い）。
     */
    private static final long serialVersionUID = 1L;

    /**
     * 図書ID。
     */
    private int id;
    
    /**
     * ISBN
     */
    private  String isbn;

    /**
     * JANコード。
     */
    private String janCode;
    
    /**
     * タイトル。
     */
    private String title;

    /**
     * 著者名。
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
   
    
 
     /** 
    *@return 図書ID
     */
    public int getId() {
        return this.id;
    }

    /**
     * 図書IDを設定。
     * 
     * @param id 図書ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * タイトルを取得。
     * 
     * @return タイトル
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * タイトルを設定。
     * 
     * @param title タイトル
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 著者名を取得。
     * 
     * @return 著者名
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * 著者名を設定。
     * 
     * @param author 著者名
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * JANコードを取得。
     * 
     * @param jancode JANコード
     */
    public String getJanCode() {
        return this.janCode;
    }

    /**
     * JANコードを設定。
     * 
     * @param janCode JANコード
     */
    public void setJanCode(String janCode) {
        this.janCode = janCode;
    }


    

    /**
     * ISBNを取得。
     * 
     * @param ISBN
     */
    public String getIsbn() {
        return this.isbn;
    }

    /**
     * ISBNを設定。
     * 
     * @param ISBN
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    
    

    /*
     * 出版社IDを取得
     */
    public String getpublisherId() {
        return this. publisherId;
    }
   
    /*
     * 出版社IDを設定。
     */
    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }
     
    
    /*
     * 出版年月日を取得
     */
    public Date getPublishDate() {
       
        return this.publishDate;
    }
   
    /*
     * 出版年月日を設定。
     */
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }
     
    
}
