package jp.co.withone.bookSearch.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.withone.bookSearch.beans.UpdateBookFormBean;
import jp.co.withone.bookSearch.component.BookValidationComponent;
import jp.co.withone.bookSearch.entity.BookDetailEntity;
import jp.co.withone.bookSearch.entity.PublisherEntity;
import jp.co.withone.bookSearch.service.PublisherListService;
import jp.co.withone.bookSearch.service.UpdateBookService;


/**
 * 図書更新関連処理（コントローラー層）。
 *
 * @author education
 *
 */
@Controller
public class UpdateBookController {

    /** 図書更新関連処理（サービス層）を定義。 */
    private final UpdateBookService updateBookService;
    private final BookValidationComponent bookValidationComponent;
    
	/** 出版社関連処理（サービス層）を定義。 */
	private final PublisherListService publisherListService;
    

    /**
     * コンストラクタ.
     *
     * @param updateBookService
     */
    UpdateBookController(UpdateBookService updateBookService,
            				BookValidationComponent bookValidationComponent,
            				PublisherListService publisherListService) {
    	
        // 図書更新関連処理(サービス層)をインジェクション
        this.updateBookService = updateBookService;
        this.bookValidationComponent = bookValidationComponent;
        this.publisherListService = publisherListService;
    }

    /**
     * 図書更新画面表示。
     *
     * @param model   モデル
     * @param id      図書ID
     * @return テンプレート名
     */
    @RequestMapping(value = "/updateBook/", method = RequestMethod.GET)
    public String dispBookUpdate(Model model, @RequestParam(value = "id", defaultValue = "") int id) {
        
        // パラメーターをbeanに設定
        UpdateBookFormBean updateBookFormBean = new UpdateBookFormBean();
        updateBookFormBean.setId(id);
        
        // 図書情報更新処理を行い、エラーメッセージを取得
        BookDetailEntity book = updateBookService.getBeforeUpdateBook(updateBookFormBean);
        
        //★出版社一覧を検索する
		List<PublisherEntity> publisherList = publisherListService.searchPublisher();
        model.addAttribute("publishers", publisherList);

        // viewに情報を渡す
        model.addAttribute("book", book);

        // 図書詳細画面表示
        return "updateBook";
    }

    /**
     * 図書更新。
     *
     * @param model   モデル
     * @param request リクエスト
     * @param bindingResult 
     * @return テンプレート名
     * @ModelAttribute
     */
    @RequestMapping(value = "/updateBook/", method = RequestMethod.POST)
    public String updateBook(@RequestParam Map<String, String> allParam, Model model) {
    	
    	
    	// 出版社IDから出版社名を取得する
    	PublisherEntity publisherList = publisherListService.searchPublisherNameById( Integer.parseInt( allParam.get("publisher_id")) );
    	
    	// パラメーターをbeanに設定
        UpdateBookFormBean updateBookFormBean = new UpdateBookFormBean();
        updateBookFormBean.setId( Integer.parseInt( allParam.get("id")) );
        updateBookFormBean.setIsbn( allParam.get("isbn") );
        updateBookFormBean.setJan_code( allParam.get("jan_code") );
        updateBookFormBean.setTitle( allParam.get("title") );
        updateBookFormBean.setAuthor( allParam.get("author") );
        updateBookFormBean.setName( publisherList.getId() );
        updateBookFormBean.setPublish_date( allParam.get("publish_date") );
        

        List<String> errorList = bookValidationComponent.validateForUpdate(updateBookFormBean);
        
//        if(!errors.isEmpty()) {
//            model.addAttribute("errors", errors);
//            model.addAttribute("book", updateBookFormBean);
//        for (String error : errorList) {
//            bindingResult.rejectValue(null,null,error);
//        }
//        if(bindingResult.hasErrors()) {
//            model.addAttribute("book",updateBookFormBean);
//            return "updateBook";
//        }
        if (errorList.size() != 0) {
            // Viewにデータを渡し、更新画面表示
            model.addAttribute("book",updateBookFormBean);
            model.addAttribute("errorList", errorList);
            return "updateBook";
        }
        
  
        // 更新処理を行う
        updateBookService.updateBook(updateBookFormBean);
        // 図書一覧画面にリダイレクト
        return "redirect:/bookList/";   
        
    }
}            
        
        
        
  
