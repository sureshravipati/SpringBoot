package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DataDAO;
import entity.Book;
import entity.Subject;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	DataDAO dao;

	@Override
	public void saveBook(Book book) throws Exception {
		try {	
			dao.saveBook(book);
		}catch(Exception ex) {
			throw new Exception(ex);
		}
	}

	@Override
	public List<Book> getBooks() throws Exception {
		List<Book> books;
		try {	
			books=dao.getBooks();
		}catch(Exception ex) {
			throw new Exception(ex);
		}
		return books;
	}

	@Override
	public List<Subject> getSubject() throws Exception {
		List<Subject> subjects;
		try {	
			subjects=dao.getSubject();
		}catch(Exception ex) {
			throw new Exception(ex);
		}
		return subjects;
	}

	@Override
	public void saveSubject(Subject subject) throws Exception {
		try {	
			dao.saveSubject(subject);
		}catch(Exception ex) {
			throw new Exception(ex);
		}
	}

	@Override
	public void deleteBook(long id) throws Exception {
		try {	
			dao.deleteBook(id);
		}catch(Exception ex) {
			throw new Exception(ex);
		}
		
	}

	@Override
	public void deleteSubject(long id) throws Exception {
		try {	
			dao.deleteSubject(id);
		}catch(Exception ex) {
			throw new Exception(ex);
		}
		
	}

}
