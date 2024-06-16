package jp.co.withone.bookSearch.service;

import java.util.List;

import org.springframework.stereotype.Service;

import jp.co.withone.bookSearch.entity.PublisherEntity;
import jp.co.withone.bookSearch.repository.PublisherListRepositoryImpl;

@Service
public class PublisherListService {

	private final PublisherListRepositoryImpl publisherListRepository;
	
	PublisherListService(PublisherListRepositoryImpl publisherListRepository) {
		this.publisherListRepository = publisherListRepository;
	}
	
	public List<PublisherEntity> searchPublisher(){
		
		return publisherListRepository.searchPublisher();
	}
	
	public PublisherEntity searchPublisherNameById(int id) {
		return publisherListRepository.searchPublisherNameById(id);
	}
	
	
}
