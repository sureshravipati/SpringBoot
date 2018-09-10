package service;

import java.util.List;

import entity.Book;
import entity.Subject;

public interface LibraryService {

	public void saveBook(Book book) throws Exception;

	public  List<Book> getBooks() throws Exception;

	public List<Subject> getSubject() throws Exception;

	public void saveSubject(Subject subject) throws Exception;

	public void deleteBook(long id) throws Exception;

	public void deleteSubject(long id) throws Exception;

}
