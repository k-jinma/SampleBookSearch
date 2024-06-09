package jp.co.withone.bookSearch.service;

import org.springframework.stereotype.Service;

import jp.co.withone.bookSearch.beans.BookDetailBean;
import jp.co.withone.bookSearch.entity.BookEntity;
import jp.co.withone.bookSearch.repository.BookDetailRepositoryImpl;

/**
 * 図書詳細関連処理（サービス層）。
 *
 * @author education
 *
 */
@Service
public class BookDetailService {

    /** リポジトリを定義。 */
    private final BookDetailRepositoryImpl bookDetailRepository;

    /**
     * コンストラクタ。
     *
     * @param bookDetailRepository 図書詳細関連リポジトリ
     */
    BookDetailService(BookDetailRepositoryImpl bookDetailRepository) {
        // リポジトリをインジェクション
        this.bookDetailRepository = bookDetailRepository;
    }

    /**
     * 詳細取得。
     *
     * @param detailFormBean 図書詳細取得用Bean
     */
    public BookEntity bookDetail(BookDetailBean bookDetailBean) {
        // 図書詳細を取得
        BookEntity bookDetail = bookDetailRepository.getBookDetail(bookDetailBean);

        return bookDetail;

    }

}
