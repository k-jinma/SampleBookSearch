package jp.co.withone.bookSearch.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.withone.bookSearch.beans.DeleteBookBean;

@Repository
public class DeleteBookRepositoryImpl implements DeleteBookRepository {

    /**
     * JDBCテンプレート。
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    
	@Override
	public void deleteBook(DeleteBookBean deleteBookBean) {
        // SQLを作成
        String sql = "DELETE from book WHERE book.id = ?;";

        // バインドパラメータを設定
        Object[] args = new Object[] { deleteBookBean.getId()};

        // SQLを実行する
        jdbcTemplate.update(sql, args);
		
	}

	
}
