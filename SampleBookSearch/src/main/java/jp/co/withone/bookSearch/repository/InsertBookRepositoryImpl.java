package jp.co.withone.bookSearch.repository;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.withone.bookSearch.beans.InsertBookFormBean;

/**
 * 図書登録関連リポジトリ。
 * 
 * @author education
 *
 */
@Repository
public class InsertBookRepositoryImpl implements InsertBookRepository {

    /**
     * JDBCテンプレート。
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;
   
    /**
     * {@inheritDoc}
     */
    @Override
    public void insertBook(InsertBookFormBean insertBookFormBean) {
        // SQLを作成
        String sql = "INSERT INTO book (isbn, jan_code, title, author, publisher_id, publish_date)" + " VALUES (?, ?, ?, ?, ?, ?)";

        // バインドパラメータを設定
        Object[] args = new Object[] { insertBookFormBean.getIsbn(),insertBookFormBean.getJanCode(),insertBookFormBean.getTitle(), insertBookFormBean.getAuthor(),
                insertBookFormBean.getPublisherId(),Date.valueOf(insertBookFormBean.getPublishDate()) };

        
        // SQLを実行する
        jdbcTemplate.update(sql, args);
    }
}
