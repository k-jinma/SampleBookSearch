package jp.co.withone.bookSearch.repository;

import jp.co.withone.bookSearch.beans.LoginFormBean;
import jp.co.withone.bookSearch.entity.UserEntity;

/**
 * ユーザー関連リポジトリインターフェース.
 * 
 * @author education
 *
 */
public interface UserRepository {

    /**
     * ログイン。
     *
     * @param loginFormBean ログインフォーム用Bean
     * @return ユーザ情報テーブルのレコード
     */
    UserEntity getUserForLogin(LoginFormBean loginFormBean);

}
