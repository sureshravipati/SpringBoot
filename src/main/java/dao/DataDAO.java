package dao;

import java.util.List;

import entity.Book;
import entity.Subject;

public interface DataDAO {		
	
	public void saveBook(Book book);	

	public void saveSubject(Subject sub);	
	
	public void deleteBook(long bookId);	
	
	public void deleteSubject(long id);	
	
	public List<Book> getBooks();
	
	public List<Subject> getSubject();

	List<Book> getBooks(String id);

	List<Subject> getSubject(String id);

}
