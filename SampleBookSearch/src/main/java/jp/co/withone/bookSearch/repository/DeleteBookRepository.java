package jp.co.withone.bookSearch.repository;

import jp.co.withone.bookSearch.beans.DeleteBookBean;

public interface DeleteBookRepository {

	/**
	 * 図書削除
	 * @param deleteBookBean
	 */
	void deleteBook(DeleteBookBean deleteBookBean);
}
