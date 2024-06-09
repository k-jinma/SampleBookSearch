package jp.co.withone.bookSearch.repository;

import jp.co.withone.bookSearch.beans.InsertBookFormBean;

/**
 * 図書登録関連リポジトリインターフェース。
 * 
 * @author education
 *
 */
public interface InsertBookRepository {

    /**
     * 図書登録。
     *
     * @param insertBookFormBean 図書登録画面パラメーター格納用Bean
     * 
     */
    void insertBook(InsertBookFormBean insertBookFormBean);

}
