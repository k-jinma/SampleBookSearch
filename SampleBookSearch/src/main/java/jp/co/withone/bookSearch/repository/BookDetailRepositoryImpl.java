package jp.co.withone.bookSearch.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import jp.co.withone.bookSearch.beans.BookDetailBean;
import jp.co.withone.bookSearch.entity.BookEntity;

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
    public BookEntity getBookDetail(BookDetailBean bookDetailBean) {
        // SQLを作成
        String sql = "SELECT * FROM book WHERE id = ?";

        // バインドパラメータを設定
        Object[] args = new Object[] { bookDetailBean.getId() };

        // マッパーの設定
        RowMapper<BookEntity> rowMapper = new BeanPropertyRowMapper<BookEntity>(BookEntity.class);

        try {
            // DBから取得した結果を返す（1レコードのみ取得する場合はqueryForObjectを使う）
            return jdbcTemplate.queryForObject(sql, rowMapper, args);
            
        } catch (EmptyResultDataAccessException e) {
            // データが取得できない場合は EmptyResultDataAccessException が発生する
            return null;
        }
    }

}
