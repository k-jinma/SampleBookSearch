package jp.co.withone.bookSearch.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import jp.co.withone.bookSearch.beans.LoginFormBean;
import jp.co.withone.bookSearch.entity.UserEntity;

/**
 * ユーザー関連リポジトリ。
 *
 * @author education
 *
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    /**
     * JDBCテンプレート。
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * {@inheritDoc}
     */
    @Override
    public UserEntity getUserForLogin(LoginFormBean loginFormBean) {
        // SQLを作成
        String sql = "SELECT * FROM user WHERE login_id = ? AND password = ?";

        // バインドパラメータを設定
        Object[] args = new Object[] { loginFormBean.getLoginId(), loginFormBean.getPassword() };

        // マッパーの設定
        RowMapper<UserEntity> rowMapper = new BeanPropertyRowMapper<UserEntity>(UserEntity.class);

        try {
            // DBから取得した結果を返す（1レコードのみ取得する場合はqueryForObjectを使う）
            return jdbcTemplate.queryForObject(sql, rowMapper, args);
        } catch (EmptyResultDataAccessException e) {
            // データが取得できない場合は EmptyResultDataAccessException が発生する
            return null;
        }
    }

}
