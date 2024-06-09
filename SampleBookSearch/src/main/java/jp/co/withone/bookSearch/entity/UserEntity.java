package jp.co.withone.bookSearch.entity;

import java.io.Serializable;

/**
 * ユーザ情報テーブル用エンティティ。
 * 
 * @author education
 *
 */
public class UserEntity implements Serializable {

    /**
     * シリアライズ化した際のバージョンID（気にせずこのまま使用して良い）。
     */
    private static final long serialVersionUID = 1L;

    /**
     * ユーザーID。
     */
    private int id;

    /**
     * ログインID。
     */
    private String loginId;

    /**
     * パスワード。
     */
    private String password;

    

    /**
     * 氏名。
     */
    private String name;

    
    
    /**
     * ユーザーIDを取得。
     * 
     * @return ユーザーID
     */
    public int getId() {
        return this.id;
    }

    /**
     * ユーザーIDを設定。
     * 
     * @param id ユーザーID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * ログインIDを取得。
     * 
     * @return ログインID
     */
    public String getLoginId() {
        return this.loginId;
    }

    /**
     * ログインIDを設定。
     * 
     * @param loginId ログインID
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * パスワードを取得。
     * 
     * @return パスワード
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * パスワードを設定。
     * 
     * @param password パスワード
     */
    public void setPassword(String password) {
        this.password = password;
    }
    

    /**
     * 氏名を取得。
     * 
     * @return name 氏名
     */
    public String getName() {
        return this.name;
    }

    /**
     * 氏名を設定。
     * 
     * @param name 氏名
     */
    public void setName(String name) {
        this.name = name;
    }

}
