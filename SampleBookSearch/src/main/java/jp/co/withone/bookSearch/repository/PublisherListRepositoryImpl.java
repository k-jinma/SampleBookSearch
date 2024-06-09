package jp.co.withone.bookSearch.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import jp.co.withone.bookSearch.entity.PublisherEntity;

@Repository
public class PublisherListRepositoryImpl implements PublisherListRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<PublisherEntity> searchPublisher() {
		
		// SQLを作成
		String sql = "SELECT * FROM publisher";
		
		// バインドパラメータを格納するリスト
	    List<Object> args = new ArrayList<>();

	    // 結果セットのマッピング
	    RowMapper<PublisherEntity> rowMapper = new BeanPropertyRowMapper<>(PublisherEntity.class);

	    // クエリの実行 
	    return jdbcTemplate.query(sql, rowMapper, args.toArray());

	}

}
