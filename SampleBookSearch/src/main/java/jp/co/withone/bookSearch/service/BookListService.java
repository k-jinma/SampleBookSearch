package jp.co.withone.bookSearch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.withone.bookSearch.entity.BookAndPublisherEntity;
//import jp.co.withone.bookSearch.entity.BookEntity;
import jp.co.withone.bookSearch.repository.BookListRepositoryImpl;

/**
 * 図書一覧関連処理（サービス層）。
 *
 * @author education
 *
 */
@Service
public class BookListService {

    /** リポジトリを定義。 */
    private final BookListRepositoryImpl bookListRepository;

    /**
     * コンストラクタ.
     *
     * @param bookListRepository 図書一覧関連リポジトリ
     */
    BookListService(BookListRepositoryImpl bookListRepository) {
        // リポジトリをインジェクション
        this.bookListRepository = bookListRepository;
    }

    /**
     * 図書一覧取得。
     */
//    public List<BookAndPublisherEntity> bookList() {
//        // 図書一覧を取得
//        List<BookAndPublisherEntity> bookList = bookListRepository.getBookList();
//
//        return bookList;
//    }
    public List<BookAndPublisherEntity> searchBooks(String title, String author, String publisherId){
        return bookListRepository.searchBooks(title,author,publisherId);
        
    }
     

}
