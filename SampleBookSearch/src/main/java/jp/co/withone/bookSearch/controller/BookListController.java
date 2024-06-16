package jp.co.withone.bookSearch.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jp.co.withone.bookSearch.entity.BookAndPublisherEntity;
import jp.co.withone.bookSearch.entity.PublisherEntity;
//import jp.co.withone.bookSearch.entity.BookEntity;
import jp.co.withone.bookSearch.service.BookListService;
import jp.co.withone.bookSearch.service.PublisherListService;

/**
 * 図書一覧関連処理（コントローラー層）。
 *
 * @author education
 *
 */
@Controller
public class BookListController {

	/** 図書一覧関連処理（サービス層）を定義。 */
	private final BookListService bookListService;
	
	/** 出版社関連処理（サービス層）を定義。 */
	private final PublisherListService publisherListService;

	/**
	 * コンストラクタ。
	 *
	 * @param bookListService 図書一覧関連処理（サービス層）
	 * @param publisherListService 出版社関連処理（サービス層）
	 */
	BookListController(BookListService bookListService, PublisherListService publisherListService) {
		// 図書一覧関連処理（サービス層）をインジェクション
		this.bookListService = bookListService;
		this.publisherListService = publisherListService;
	}

	/**
	 * 図書一覧画面表示。
	 *
	 * @param model   モデル
	 * @param request リクエスト
	 * @return テンプレート名
	 */
	@RequestMapping(value = "/bookList/", method = RequestMethod.GET)
	public String searchBook(Model model, HttpServletRequest request, HttpSession session) {
		
		String title = (String) session.getAttribute("title");
		String author = (String) session.getAttribute("author");
		String publisherId = (String) session.getAttribute("publisherId");

		List<BookAndPublisherEntity> bookList = new ArrayList<>();

		if (title != null || author != null || publisherId != null) {
			bookList = bookListService.searchBooks(title, author, publisherId);
		}
		
        
        //★出版社一覧を検索する
		List<PublisherEntity> publisherList = publisherListService.searchPublisher();
        model.addAttribute("publishers", publisherList);


		// viewに情報を渡す
		model.addAttribute("bookList", bookList);

		// 画面表示
		return "bookList";
	}

	//検索ボタンを押したときのメソッド

	@RequestMapping(value = "/books/search", method = RequestMethod.POST)
	public String searchBooks(Model model, HttpServletRequest request, HttpSession session) {
		//フォームに入力した値を取り出す
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String publisherId = request.getParameter("publisher_id");

		//セッション変数に記憶させておく
		session.setAttribute("title", title);
		session.setAttribute("author", author);
		session.setAttribute("publisherId", publisherId);
		
        //★出版社一覧を検索する
		List<PublisherEntity> publisherList = publisherListService.searchPublisher();
        model.addAttribute("publishers", publisherList);
		
		//検索条件に基づいて書籍リストを取得
		List<BookAndPublisherEntity> bookList = bookListService.searchBooks(title, author, publisherId);
		model.addAttribute("bookList", bookList);

		return "bookList";
	}

}
