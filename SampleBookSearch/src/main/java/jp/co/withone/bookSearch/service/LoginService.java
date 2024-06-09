package jp.co.withone.bookSearch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.withone.bookSearch.beans.LoginFormBean;
import jp.co.withone.bookSearch.component.LoginValidationComponent;
import jp.co.withone.bookSearch.entity.UserEntity;
import jp.co.withone.bookSearch.repository.UserRepositoryImpl;

/**
 * ログイン関連処理（サービス層）。
 *
 * @author education
 *
 */
@Service
public class LoginService {

    /** バリデーションを定義。 */
    private final LoginValidationComponent loginValidationComponent;

    /** リポジトリを定義。 */
    private final UserRepositoryImpl userRepository;

    /**
     * コンストラクタ。
     *
     * @param loginValidationComponent ログインフォーム入力チェック
     * @param userRepository           ユーザー関連リポジトリ
     */
    LoginService(LoginValidationComponent loginValidationComponent, UserRepositoryImpl userRepository) {
        // バリデーションをインジェクション
        this.loginValidationComponent = loginValidationComponent;

        // リポジトリをインジェクション
        this.userRepository = userRepository;
    }

    /**
     * ログイン。
     *
     * @param loginFormBean ログインフォーム用Bean
     * @return
     */
    public List<String> login(LoginFormBean loginFormBean) {
        // 入力チェック処理
        List<String> errorList = loginValidationComponent.validateForLogin(loginFormBean);

        // 入力エラーが発生した場合
        if (errorList.size() != 0) {
            return errorList;
        }

        // エラーが発生していない場合はログイン認証処理を行う
        // ユーザー情報を取得
        UserEntity loggedInUser = userRepository.getUserForLogin(loginFormBean);

        // 取得できない場合認証はエラー
        if (loggedInUser == null) {
            errorList.add("認証エラー：入力されたログインID/パスワードは存在しません。");
            return errorList;
        }

        return errorList;
    }

}
