package jp.co.withone.bookSearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.withone.bookSearch.beans.BookDetailBean;
import jp.co.withone.bookSearch.entity.BookEntity;
import jp.co.withone.bookSearch.service.BookDetailService;

/**
 * 図書詳細関連処理（コントローラー層）。
 *
 * @author education
 */
@Controller
public class BookDetailController {

    /** 図書詳細関連処理（サービス層）を定義。 */
    private final BookDetailService bookDetailService;

    /**
     * コンストラクタ。
     *
     * @param bookDetailService 図書詳細関連処理（サービス層）。
     */
    BookDetailController(BookDetailService bookDetailService) {
        // 図書詳細関連処理(サービス層)をインジェクション
        this.bookDetailService = bookDetailService;
    }

    /**
     * 図書詳細画面表示。
     *
     * @param model   モデル
     * @param id      図書ID
     * @return テンプレート名
     */
    @RequestMapping(value = "/bookDetail/", method = RequestMethod.GET)
    public String dispBookDetail(Model model, @RequestParam(value = "id", defaultValue = "") int id) {
        // パラメーターをbeanに設定
        BookDetailBean bookDetailBean = new BookDetailBean();
        bookDetailBean.setId(id);

        // 図書詳細取得処理を行い、エラーメッセージを取得
        BookEntity book = bookDetailService.bookDetail(bookDetailBean);

        // viewに情報を渡す
        model.addAttribute("book", book);

        // 図書詳細画面表示
        return "bookDetail";
    }
    
    

}
