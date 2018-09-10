package dao;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entity.Book;
import entity.Subject;
import repo.BookRepository;
import repo.SubjectRepository;

@Repository
public class DataDAOImpl implements DataDAO{	
	Session session=null;
	Transaction Txn=null;
	
	 @Autowired
	 private BookRepository bookRepo;
	 
	 @Autowired
	 private SubjectRepository subjectRepo;

		
	
	@Override
	public void saveBook(Book book) {
		try {
			bookRepo.save(book);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void saveSubject(Subject sub) {
		try {
			subjectRepo.save(sub);	
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public void deleteBook(long bookId) {
		try {
			bookRepo.deleteById(bookId);	
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public void deleteSubject(long id) {
		try {
			subjectRepo.deleteById(id);			
		}catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Override
	public List<Subject> getSubject(String id) {
		List<Subject> subject=new ArrayList<Subject>();
		Optional<Subject> sub;
		try {
			
			sub=subjectRepo.findById(Long.parseLong(id));
			subject.add(sub.get());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return subject;
	}
	
	@Override
	public List<Book> getBooks(String id) {
		List<Book> books=new ArrayList<Book>();
		Optional<Book> book;
		try {
			book=bookRepo.findById(Long.parseLong(id));
			books.add(book.get());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public List<Book> getBooks() {
		List<Book> books=new ArrayList<Book>();		
		try {
			books = (List<Book>) bookRepo.findAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return books;
	}

	@Override
	public List<Subject> getSubject() {
		List<Subject> subject=new ArrayList<Subject>();
		try {
			subject = (List<Subject>) subjectRepo.findAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return subject;
	}
}
