package jp.co.withone.bookSearch.repository;

import jp.co.withone.bookSearch.beans.UpdateBookFormBean;
import jp.co.withone.bookSearch.entity.BookDetailEntity;

/**
 * 図書更新関連リポジトリインターフェース。
 * 
 * @author education
 *
 */
public interface UpdateBookRepository {

    /**
     * 更新前情報取得。
     *
     * @param updateBookFormBean 図書更新画面パラメーター格納用Bean
     * 
     */
    BookDetailEntity getBeforeUpdateBook(UpdateBookFormBean updateBookFormBean);

    /**
     * 図書更新。
     *
     * @param updateBookFormBean 図書更新画面パラメーター格納用Bean
     */
    void updateBook(UpdateBookFormBean updateBookFormBean);

}
