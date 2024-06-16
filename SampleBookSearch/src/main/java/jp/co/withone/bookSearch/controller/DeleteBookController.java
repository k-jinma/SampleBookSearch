package jp.co.withone.bookSearch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.withone.bookSearch.beans.DeleteBookBean;
import jp.co.withone.bookSearch.service.DeleteBookService;
import jp.co.withone.bookSearch.service.PublisherListService;

/**
 * 図書削除関連処理
 */
@Controller
public class DeleteBookController {
    /** 図書登録関連処理（サービス層）を定義。 */
    private final DeleteBookService deleteBookService;
    private final PublisherListService publisherListService;

    /**
     * コンストラクタ。
     *
     * @param deleteBookService 図書削除関連処理（サービス層）
     * @param publisherListService  
     */
    DeleteBookController(DeleteBookService deleteBookService, PublisherListService publisherListService) {
        // 図書登録関連処理(サービス層)をインジェクション
        this.deleteBookService = deleteBookService;
        this.publisherListService = publisherListService;
    }
    
    /**
     * 削除処理
     * @param id
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "/deleteBook/", method = RequestMethod.GET)
    public String deleteBook(@RequestParam String id, RedirectAttributes redirectAttributes) {
    	
    	// パラメータ設定
    	DeleteBookBean deleteBookBean = new DeleteBookBean();
    	deleteBookBean.setId( Integer.parseInt(id) );
    	
    	// 削除処理
    	deleteBookService.deleteBook(deleteBookBean);
    	
    	redirectAttributes.addFlashAttribute("isSucceed", true);
    	
    	return "redirect:/bookDetail/?id=" + deleteBookBean.getId();   
    }
    
}
