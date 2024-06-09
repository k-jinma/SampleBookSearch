package jp.co.withone.bookSearch.repository;

import java.util.List;

import jp.co.withone.bookSearch.entity.PublisherEntity;

public interface PublisherListRepository {

	/**
	 * 出版社一覧取得
	 * @return 出版社一覧
	 */
	List<PublisherEntity> searchPublisher();
}
