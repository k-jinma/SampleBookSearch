package jp.co.withone.bookSearch.repository;

import jp.co.withone.bookSearch.beans.BookDetailBean;
import jp.co.withone.bookSearch.entity.BookDetailEntity;

/**
 * 図書詳細関連リポジトリインターフェース。
 * 
 * @author education
 *
 */
public interface BookDetailRepository {

    /**
     * 図書詳細取得。
     *
     * @param bookDetailBean 図書詳細画面パラメーター格納用Bean
     * 
     */
    BookDetailEntity getBookDetail(BookDetailBean bookDetailBean);

}
