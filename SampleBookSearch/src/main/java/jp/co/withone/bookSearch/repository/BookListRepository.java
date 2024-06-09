package jp.co.withone.bookSearch.repository;

import java.util.List;

//import jp.co.withone.bookSearch.entity.BookEntity;

import jp.co.withone.bookSearch.entity.BookAndPublisherEntity;

/**
 * 図書一覧関連リポジトリインターフェース。
 * 
 * @author education
 *
 */
public interface BookListRepository {

    /**
     * 図書一覧取得。
     */
    List<BookAndPublisherEntity> searchBooks(String title, String author, String publisherId);

}
