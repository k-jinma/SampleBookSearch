package jp.co.withone.bookSearch.component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import jp.co.withone.bookSearch.beans.InsertBookFormBean;
import jp.co.withone.bookSearch.beans.UpdateBookFormBean;

/**
 * 図書データ入力チェック。
 *
 * @author education
 */
@Component
public class BookValidationComponent {

    /**
     * 書籍登録時の入力チェック。
     *
     * @param insertBookFormBean 図書登録フォームの値
     * @return エラーメッセージ格納リスト
     */
      
    
	// validateCommonFieldsメソッドは登録、更新画面のbeanのエラーをまとめてするメソッド
    
	// 登録時
    public List<String> validateForInsert(InsertBookFormBean insertBookFormBean) {
    	
        return validateCommonFields(insertBookFormBean.getIsbn(),insertBookFormBean.getJanCode(),
                insertBookFormBean.getTitle(),insertBookFormBean.getAuthor(),insertBookFormBean.
                getPublisherId(),insertBookFormBean.getPublishDate());
    }
    
    // 更新時
    public List<String> validateForUpdate(UpdateBookFormBean updateBookFormBean){
    	
        return validateCommonFields(updateBookFormBean.getIsbn(),updateBookFormBean.getJan_code(),
                updateBookFormBean.getTitle(),updateBookFormBean.getAuthor(),
                updateBookFormBean.getName(),updateBookFormBean.getPublish_date());
    }   
    
    //共通のエラー処理メソッド
    private List<String> validateCommonFields(
            String isbn, String janCode, String title, String author, 
            String publisherId, String publishDate){
    	
        List<String> errorList = new ArrayList<>();
        

        // ISBN入力必須チェック（前後の空白文字は削除して判断）
        if (isbn == null || "".equals(isbn.trim())) {
            errorList.add("ISBNは必ず入力してください。");
        }
        
        //ISBN桁数チェック
        if (isbn.length() != 13) {
            errorList.add("ISBNは13桁で入力してください。");
            
        }if (!isbn.matches("\\d+")){
        	errorList.add("ISBNは半角数字で入力してください。");
        }
        
        //JANコード桁数チェック
        if (janCode == null) {
            errorList.add("JANコードは必ず入力してください。");
        
        }else if (janCode.length() != 13) {
            errorList.add("JANコードは13桁で入力してください。");
        
        }else if(!janCode.matches("\\d+")){
            errorList.add("JANコードは半角数字で入力してください。");
        }       

        // タイトル入力チェック（前後の空白文字は削除して判断）
        if (title == null || "".equals(title.trim())) {
            errorList.add("タイトルは必ず入力してください。");
        }
        else if (65 < title.length()) {
            errorList.add("タイトルは65文字以内で入力してください。");
        }

        // 著者入力必須チェック（前後の空白文字は削除して判断）
        if (author == null || "".equals(author.trim())) {
            errorList.add("著者名は必ず入力してください。");
        }
        //著者桁数チェック
        else if (author.length() > 40) {
            errorList.add("著者名は40文字以内で入力してください。");
        }
        
        //出版社IDチェック
        if(publisherId == null || publisherId.isEmpty()) {
            errorList.add("出版社名は必ず選択してください。");
        }
        
        // 出版年月日必須チェック
        if (publishDate == null || "".equals(publishDate.trim())) {
            errorList.add("出版年月日は必ず入力してください。");
        }
           
        //出版年月日日付チェック（date text）
        try {
        	Date date = Date.valueOf(publishDate);

        
        }catch(IllegalArgumentException e) {
            errorList.add("出版年月日の日付が正しくありません。");
        }
        
        // エラーリストを返却
        return errorList;
        
        
      }
        
   
    }
