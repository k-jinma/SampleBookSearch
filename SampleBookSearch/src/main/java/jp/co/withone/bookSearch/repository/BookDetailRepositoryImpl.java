package jp.co.withone.bookSearch.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import jp.co.withone.bookSearch.beans.BookDetailBean;
import jp.co.withone.bookSearch.entity.BookDetailEntity;

/**
 * 図書詳細関連リポジトリ。
 * 
 * @author education
 *
 */
@Repository
public class BookDetailRepositoryImpl implements BookDetailRepository {

    /**
     * JDBCテンプレート。
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * {@inheritDoc}
     */
    @Override
    public BookDetailEntity getBookDetail(BookDetailBean bookDetailBean) {
        // SQLを作成
        String sql = "SELECT b.id, b.isbn, b.jan_code, b.title, b.author, p.name, b.publish_date "
        			+ "FROM book b, publisher p "
        			+ "WHERE b.publisher_id = p.id "
        			+ "AND b.id = ?;";

        // バインドパラメータを設定
        Object[] args = new Object[] { bookDetailBean.getId()};

        // マッパーの設定
        RowMapper<BookDetailEntity> rowMapper = new BeanPropertyRowMapper<BookDetailEntity>(BookDetailEntity.class);

        try {
            // DBから取得した結果を返す（1レコードのみ取得する場合はqueryForObjectを使う）
            return jdbcTemplate.queryForObject(sql, rowMapper, args);
            
        } catch (EmptyResultDataAccessException e) {
            // データが取得できない場合は EmptyResultDataAccessException が発生する
            return null;
        }
    }

}
