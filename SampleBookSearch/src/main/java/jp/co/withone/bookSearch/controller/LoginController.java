package jp.co.withone.bookSearch.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jp.co.withone.bookSearch.beans.LoginFormBean;
import jp.co.withone.bookSearch.service.LoginService;

/**
 * ログイン関連処理（コントローラー層）。
 * 
 * @author education
 *
 */
@Controller
public class LoginController {

    /** ログイン関連処理（サービス層）を定義。 */
    private final LoginService loginService;

    /**
     * コンストラクタ。
     *
     * @param loginService ログイン関連処理（サービス層）。
     */
    LoginController(LoginService loginService) {
        // ログイン関連処理（サービス層）をインジェクション
        this.loginService = loginService;
    }

    /**
     * ログイン画面表示。
     * 
     * @return テンプレート名
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String dispLogin() {

        return "login";
    }
    /**
     * ログイン。
     * 
     * @param model    モデル
     * @param loginId  ログインID
     * @param password パスワード
     * @return テンプレート名
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model, @RequestParam(value = "login_id", defaultValue = "") String loginId,
            @RequestParam(value = "password", defaultValue = "", required = true) String password) {
        // パラメーターをbeanに設定
        LoginFormBean loginFormBean = new LoginFormBean();
        loginFormBean.setLoginId(loginId);
        loginFormBean.setPassword(password);

        // ログイン取得処理を行い、エラーメッセージを取得
        List<String> errorList = loginService.login(loginFormBean, request);

        // エラーが発生した場合
        if (errorList.size() != 0) {
            // Viewにデータを渡し、ログイン画面表示
            model.addAttribute("loginId", loginFormBean.getLoginId());
            // model.addAttribute("password", password); // パスワードは戻す必要がない
            model.addAttribute("errorList", errorList);
            return "login";
        }
        
        // ログイン処理に成功したら一覧画面にリダイレクトする
        // リダイレクト先の画面に渡したいパラメーターがある場合はredirectAttributesを使用
        return "redirect:/bookList/";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
    	
    	// セッションが存在しなければnullを返す
    	HttpSession session = request.getSession(false);
    	if( session != null ) {
    		session.invalidate();
    	}
    	
    	return "redirect:/";
    }

}
