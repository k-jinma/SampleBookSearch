package jp.co.withone.bookSearch.service;

import org.springframework.stereotype.Service;

import jp.co.withone.bookSearch.beans.UpdateBookFormBean;
import jp.co.withone.bookSearch.component.BookValidationComponent;
import jp.co.withone.bookSearch.entity.BookEntity;
import jp.co.withone.bookSearch.repository.UpdateBookRepositoryImpl;

/**
 * 図書更新関連処理（サービス層）。
 *
 * @author education
 *
 */
@Service
public class UpdateBookService {

    /** バリデーションを定義。 */
    private final BookValidationComponent bookValidationComponent;

    /** リポジトリを定義。 */
    private final UpdateBookRepositoryImpl updateBookRepository;

    /**
     * コンストラクタ。
     * 
     * @param bookValidationComponent 図書データ入力チェック
     * @param insertBookRepository    図書登録関連リポジトリ
     */
    UpdateBookService(BookValidationComponent bookValidationComponent, UpdateBookRepositoryImpl updateBookRepository) {
        // バリデーションをインジェクション
        this.bookValidationComponent = bookValidationComponent;

        // リポジトリをインジェクション
        this.updateBookRepository = updateBookRepository;
    }

    /**
     * 更新前情報取得。
     *
     * @param updateBookFormBean 図書更新フォーム用Bean
     */
    public BookEntity getBeforeUpdateBook(UpdateBookFormBean updateBookFormBean) {
        // 更新前図書情報を取得
        BookEntity beforeUpdateBook = updateBookRepository.getBeforeUpdateBook(updateBookFormBean);

        return beforeUpdateBook;
    }

    /**
     * 図書更新。
     *
     * @param updateBookFormBean 図書更新フォーム用Bean
     */
    public void updateBook(UpdateBookFormBean updateBookFormBean) {
        // 図書情報を登録
        updateBookRepository.updateBook(updateBookFormBean);
    }

}
