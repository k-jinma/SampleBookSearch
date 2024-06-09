package jp.co.withone.bookSearch.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jp.co.withone.bookSearch.beans.UpdateBookFormBean;
import jp.co.withone.bookSearch.component.BookValidationComponent;
import jp.co.withone.bookSearch.entity.BookEntity;
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
    

    /**
     * コンストラクタ.
     *
     * @param updateBookService
     */
    UpdateBookController(UpdateBookService updateBookService,
            BookValidationComponent bookValidationComponent) {
        // 図書更新関連処理(サービス層)をインジェクション
        this.updateBookService = updateBookService;
        this.bookValidationComponent = bookValidationComponent;
    }

    /**
     * 図書更新画面表示。
     *
     * @param model   モデル
     * @param id      図書ID
     * @return テンプレート名
     */
    @RequestMapping(value = "/updateBook/", method = RequestMethod.GET)
    public String dispBookUpdate(Model model, @RequestParam(value = "id", defaultValue = "") String id) {
        
        // パラメーターをbeanに設定
        UpdateBookFormBean updateBookFormBean = new UpdateBookFormBean();
        updateBookFormBean.setId(id);
        
        // 図書情報更新処理を行い、エラーメッセージを取得
        BookEntity book = updateBookService.getBeforeUpdateBook(updateBookFormBean);

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
    public String updateBook(Model model, HttpServletRequest request) {
     // パラメーターをbeanに設定
        UpdateBookFormBean updateBookFormBean = new UpdateBookFormBean();
        
        updateBookFormBean.setIsbn(request.getParameter("isbn"));
        updateBookFormBean.setJanCode(request.getParameter("janCode"));
        updateBookFormBean.setTitle(request.getParameter("title"));
        updateBookFormBean.setAuthor(request.getParameter("author"));
        updateBookFormBean.setPublisherId(request.getParameter("publisher"));
        updateBookFormBean.setPublishDate(request.getParameter("publishDate"));
        updateBookFormBean.setId(request.getParameter("id"));
        
        
        
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
        
        
        
  
