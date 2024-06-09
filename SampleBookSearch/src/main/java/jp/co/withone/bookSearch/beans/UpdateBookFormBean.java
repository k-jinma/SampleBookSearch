package jp.co.withone.bookSearch.beans;

import java.io.Serializable;

/**
 * 図書更新画面パラメーター格納用Bean。
 *
 * @author education
 */
public class UpdateBookFormBean implements Serializable {

    /**
     * シリアライズ化した際のバージョンID（気にせずこのまま使用して良い）。
     */
    private static final long serialVersionUID = 1L;
    
    
    private String id;

    /**
     * isbn。
     */
    private String isbn;
    
    //janCode
    private String janCode;

    /**
     * タイトル。
     */
    private String title;

    /**
     * 著者名。
     */
    private String author;
    
    //出版社ID
    private String publisherId;
    
    //出版年月日
    private String publishDate;

    
    //getter
    
    public String getId() {
        return id;
    }
    
    
    public String getIsbn() {
        return isbn;
    }
    
    public String getJanCode() {
        return janCode;
    }

    public String getTitle() {
        return this.title;
    }


    public String getAuthor() {
        return this.author;
    }
         //出版社ID
    public String getPublisherId() {
        return publisherId;
    }
    
    public String getPublishDate() {
        return publishDate;
    }

   //setter
    public void setId(String id) {
        this.id = id;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setJanCode(String janCode) {
        this.janCode = janCode;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
        //出版社ID
    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
