package jp.co.withone.bookSearch.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import jp.co.withone.bookSearch.entity.BookAndPublisherEntity;

/**
 * 図書一覧関連リポジトリ。
 * 
 * @author education
 *
 */
@Repository
public class BookListRepositoryImpl implements BookListRepository {

	/**
	 * JDBCテンプレート。
	 */
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
     * {@inheritDoc}
     */
    public List<BookAndPublisherEntity> getBookList() {
        // SQLを作成
        String sql = "SELECT * FROM book JOIN publisher ON book.publisher_id = publisher.id";

        // オブジェクト型リストの初期化
        List<Object> object = new ArrayList<Object>();

        // バインドパラメータを設定
        Object[] args = object.toArray(new Object[object.size()]);

        // マッパーの設定
        RowMapper<BookAndPublisherEntity> rowMapper = new BeanPropertyRowMapper<BookAndPublisherEntity>(BookAndPublisherEntity.class);

        try {
            // DBから取得した結果を返す（複数レコードを取得する場合はqueryを使う）
            return jdbcTemplate.query(sql, rowMapper, args);
        } catch (EmptyResultDataAccessException e) {
            // データが取得できない場合は EmptyResultDataAccessException が発生する
            return null;
        
        }

        
    }

//    public List<BookAndPublisherEntity> searchBooks(String title, String author, String publisherId){
//
//
//      String sql = "SELECT * FROM book_and_publisher WHERE title LIKE ? AND author LIKE ?";
//      Object[] params = new Object[]{"%" + title + "%", "%" + author + "%"};
//
//      if(publisherId != null){
//         sql += " AND publisher_id = ?";
//         params = new Object[]{"%" + title + "%", "%" + author + "%", publisherId};
//      }
//      
//      RowMapper<BookAndPublisherEntity> rowMapper = new BeanPropertyRowMapper<BookAndPublisherEntity>(BookAndPublisherEntity.class);
//      
//              try {
//                  // DBから取得した結果を返す（複数レコードを取得する場合はqueryを使う）
//                  return jdbcTemplate.query(sql, rowMapper, args);
//              } catch (EmptyResultDataAccessException e) {
//                  // データが取得できない場合は EmptyResultDataAccessException が発生する
//                  return null;
//              
//              }
//      
//
//      return jdbcTemplate.query(sql, params, new Boo9kAndPublisherRowMapper());
//        }
//
//	return null;

	@Override
	public List<BookAndPublisherEntity> searchBooks(String title, String author, String publisherId) {
		
		// デバッグ用
		// publisherId = "1";
	    
		// SQLのベース文
	    String sql = "SELECT book.id, book.title, book.author, publisher.name, book.publish_date, book.isbn, book.jan_code "
	               + "FROM book LEFT JOIN publisher "
	               + "ON book.publisher_id = publisher.id ";

	    // 検索条件を追加するためのStringBuilder
	    StringBuilder sqlBuilder = new StringBuilder(sql);

	    // バインドパラメータを格納するリスト
	    List<Object> args = new ArrayList<>();

	    // falseならばWHEREを付ける、WHEREを付与するとtrueにし、追加する条件はANDが付くようにする
	    boolean hasWhereClause = false;

	    if (!title.isEmpty()) {
	        sqlBuilder.append(hasWhereClause ? " AND " : " WHERE ");
	        sqlBuilder.append("book.title LIKE ?");
	        args.add("%" + title + "%");
	        hasWhereClause = true;
	    }

	    if (!author.isEmpty()) {
	        sqlBuilder.append(hasWhereClause ? " AND " : " WHERE ");
	        sqlBuilder.append("book.author LIKE ?");
	        args.add("%" + author + "%");
	        hasWhereClause = true;
	    }

	    // publisherIdのフィルタリング条件を追加
	    if (publisherId != null && !publisherId.isEmpty()) {
	        sqlBuilder.append(hasWhereClause ? " AND " : " WHERE ");
	        sqlBuilder.append("book.publisher_id = ?");
	        args.add(publisherId);
	        hasWhereClause = true;
	    }

	    // 結果セットのマッピング
	    RowMapper<BookAndPublisherEntity> rowMapper = new BeanPropertyRowMapper<>(BookAndPublisherEntity.class);

	    // クエリの実行 
	    return jdbcTemplate.query(sqlBuilder.toString(), rowMapper, args.toArray());
	}

}