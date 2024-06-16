package jp.co.withone.bookSearch.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jp.co.withone.bookSearch.beans.InsertBookFormBean;
import jp.co.withone.bookSearch.entity.PublisherEntity;
import jp.co.withone.bookSearch.service.InsertBookService;
import jp.co.withone.bookSearch.service.PublisherListService;

/**
 * 図書登録関連処理（コントローラー層）。
 *
 * @author education
 *
 */
@Controller
public class InsertBookController {

    /** 図書登録関連処理（サービス層）を定義。 */
    private final InsertBookService insertBookService;
    private final PublisherListService publisherListService;

    /**
     * コンストラクタ。
     *
     * @param insertBookService 図書登録関連処理（サービス層）
     */
    InsertBookController(InsertBookService insertBookService, PublisherListService publisherListService) {
        // 図書登録関連処理(サービス層)をインジェクション
        this.insertBookService = insertBookService;
        this.publisherListService = publisherListService;
    }

    /**
     * 図書登録画面表示。
     *
     * @return テンプレート名
     */
    @RequestMapping(value = "/insertBook/", method = RequestMethod.GET)
    public String dispBookInsert(Model model) {
    	
        //出版社一覧を検索する
		List<PublisherEntity> publisherList = publisherListService.searchPublisher();
        model.addAttribute("publishers", publisherList);
    	
        // 図書登録画面表示
        return "insertBook";
    }

    /**
     * 図書登録。
     *
     * @param model   モデル
     * @param request リクエスト
     * @return テンプレート名
     */
    @RequestMapping(value = "/insertBook/", method = RequestMethod.POST)
    public String insertBook(Model model, HttpServletRequest request) {
    	
    	//出版社一覧を検索する
		List<PublisherEntity> publisherList = publisherListService.searchPublisher();
        model.addAttribute("publishers", publisherList);
    	
        // パラメーターをbeanに設定
        InsertBookFormBean insertBookFormBean = new InsertBookFormBean();
        
        insertBookFormBean.setIsbn(request.getParameter("isbn"));
        insertBookFormBean.setJanCode(request.getParameter("jan_code"));
        insertBookFormBean.setTitle(request.getParameter("title"));
        insertBookFormBean.setAuthor(request.getParameter("author"));
        insertBookFormBean.setPublisherId(request.getParameter("publisher_id"));
        insertBookFormBean.setPublishDate(request.getParameter("publish_date"));

        // 図書情報登録処理を行い、エラーメッセージを取得
        List<String> errorList = insertBookService.insertBook(insertBookFormBean);

        // エラーが発生した場合
        if (errorList.size() != 0) {
            // Viewにデータを渡し、図書登録画面表示
            model.addAttribute("isbn", insertBookFormBean.getIsbn());
            model.addAttribute("jan_code", insertBookFormBean.getJanCode());
            model.addAttribute("title", insertBookFormBean.getTitle());
            model.addAttribute("author", insertBookFormBean.getAuthor());
            model.addAttribute("publisher_id", insertBookFormBean.getPublisherId());
            model.addAttribute("publish_date", insertBookFormBean.getPublishDate());

            // model.addAttribute("password", password); // パスワードは戻す必要がない
            model.addAttribute("errorList", errorList);
            return "insertBook";
        }

        // 登録完了ダイアログ
        model.addAttribute("isSucceed", true);

        // 図書一覧画面にリダイレクト
        return "insertBook";
        
    }

}
