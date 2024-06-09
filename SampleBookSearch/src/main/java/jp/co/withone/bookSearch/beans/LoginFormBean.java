package jp.co.withone.bookSearch.beans;

import java.io.Serializable;

/**
 * ログイン画面パラメーター格納用Bean。
 *
 * @author education
 */
public class LoginFormBean implements Serializable {

    /**
     * シリアライズ化した際のバージョンID（気にせずこのまま使用して良い）。
     */
    private static final long serialVersionUID = 1L;

    /**
     * ログインID。
     */
    private String loginId;

    /**
     * パスワード。
     */
    private String password;

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

}
