package jp.co.withone.bookSearch.beans;

import java.io.Serializable;

/**
 * 図書登録画面パラメーター格納用Bean。
 *
 * @author education
 */
public class InsertBookFormBean implements Serializable {

    /**
     * シリアライズ化した際のバージョンID（気にせずこのまま使用して良い）。
     */
    private static final long serialVersionUID = 1L;

    
    
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
     * 著者名。
     */
    private String author;

    /**
     * 出版社ID
     */
    private String publisherId;

    
    //出版年月日
   private String publishDate;
   
   
   
   
   
   /**
    * ISBNを取得。
    * 
    */
    
   public String getIsbn() {
       return this.isbn;
   }

   /**
    * ISBNを設定。
    * 
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
       return this.janCode;
   }

   /**
    * JANコードを設定。
    * 
    * @param title タイトル
    */
   public void setJanCode(String janCode) {
       this.janCode = janCode;
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
     * 出版社IDを取得。
     * 
     * @return出版社ID
     */
    public String getPublisherId() {
        return this.publisherId;
    }

    /**
     * 出版社IDを設定。
     * 
     * @param title 出版社ID
     */
    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }
    
    /**
     * 出版年月日を取得。
     * 
     * @return 出版年月日
     */
    public String getPublishDate() {
        return this.publishDate;
    }

    /**
     * 出版年月日を設定。
     * 
     * @param 出版年月日
     */
    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }
}
