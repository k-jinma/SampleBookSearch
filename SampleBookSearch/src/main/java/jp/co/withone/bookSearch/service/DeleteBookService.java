package jp.co.withone.bookSearch.service;

import org.springframework.stereotype.Service;

import jp.co.withone.bookSearch.beans.DeleteBookBean;
import jp.co.withone.bookSearch.repository.DeleteBookRepositoryImpl;

@Service
public class DeleteBookService {
	
	/** リポジトリ */
	private final DeleteBookRepositoryImpl deleteBookRepository;

	/**
	 * コンストラクタ
	 * @param deleteBookRepository
	 */
	public DeleteBookService(DeleteBookRepositoryImpl deleteBookRepository) {
		this.deleteBookRepository = deleteBookRepository;
	}

	/**
	 * 図書削除
	 * @param deleteBookBean
	 */
	public void deleteBook(DeleteBookBean deleteBookBean) {
		
		//図書削除
		deleteBookRepository.deleteBook(deleteBookBean);
		
	}
	

}
