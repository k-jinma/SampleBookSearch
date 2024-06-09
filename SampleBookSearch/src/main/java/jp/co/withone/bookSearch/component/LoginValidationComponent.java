package jp.co.withone.bookSearch.component;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jp.co.withone.bookSearch.beans.LoginFormBean;

/**
 * ログインフォーム入力チェック。
 *
 * @author education
 */
@Component
public class LoginValidationComponent {

    /**
     * ログイン時の入力チェック。
     *
     * @param loginFormBean ログインフォームの値
     * @return エラーメッセージ格納リスト
     */
    public List<String> validateForLogin(LoginFormBean loginFormBean) {
        // エラーメッセージ格納用リスト
        List<String> errorList = new ArrayList<>();

        // 値を取得
        String loginId = loginFormBean.getLoginId();
        String password = loginFormBean.getPassword();

        // ログインID入力チェック（前後の空白文字は削除して判断）
        if (loginId == null || "".equals(loginId.trim())) {
            errorList.add("入力エラー：ログインIDは必ず入力してください。");
        }

        // パスワード入力チェック
        if (password == null || "".equals(password)) {
            errorList.add("入力エラー：パスワードは必ず入力してください。");
        }

        // エラーリストを返却
        return errorList;

    }

}
