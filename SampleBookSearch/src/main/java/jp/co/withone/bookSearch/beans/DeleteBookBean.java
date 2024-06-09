package jp.co.withone.bookSearch.beans;

import java.io.Serializable;

/**
 * 図書削除処理パラメーター格納用Bean。
 * 
 * @author education
 */
public class DeleteBookBean implements Serializable {

    /**
     * シリアライズ化した際のバージョンID（気にせずこのまま使用して良い）。
     */
    private static final long serialVersionUID = 1L;

    /**
     * 図書ID。
     */
    private int id;

    /**
     * 図書IDを取得。
     * 
     * @return 図書ID
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

}
