package jp.co.withone.bookSearch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.withone.bookSearch.beans.InsertBookFormBean;
import jp.co.withone.bookSearch.component.BookValidationComponent;
import jp.co.withone.bookSearch.repository.InsertBookRepositoryImpl;

/**
 * 図書登録関連処理（サービス層）。
 *
 * @author education
 *
 */
@Service
public class InsertBookService {

    /** バリデーションを定義。 */
    private final BookValidationComponent bookValidationComponent;

    /** リポジトリを定義。 */
    private final InsertBookRepositoryImpl insertBookRepository;

    /**
     * コンストラクタ。
     * 
     * @param bookValidationComponent 図書データ入力チェック
     * @param insertBookRepository    図書登録関連リポジトリ
     */
    InsertBookService(BookValidationComponent bookValidationComponent, InsertBookRepositoryImpl insertBookRepository) {
        // バリデーションをインジェクション
        this.bookValidationComponent = bookValidationComponent;

        // リポジトリをインジェクション
        this.insertBookRepository = insertBookRepository;
    }

    /**
     * 図書登録。
     *
     * @param insertBookFormBean 図書登録フォーム用Bean
     */
    public List<String> insertBook(InsertBookFormBean insertBookFormBean) {
        // 入力チェック処理
        List<String> errorList = bookValidationComponent.validateForInsert(insertBookFormBean);

        // 入力エラーが発生した場合
        if (errorList.size() != 0) {
            return errorList;
        }

        // 図書を登録
        insertBookRepository.insertBook(insertBookFormBean);

        return errorList;
    }

}
