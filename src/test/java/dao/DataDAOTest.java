package dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import config.SpringDataConfiguration;
import config.SpringWebConfig;
import entity.Book;
import entity.Subject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class,SpringWebConfig.class})
@WebAppConfiguration
public class DataDAOTest {
	
	@Autowired
	DataDAO dao;
	
	
	@Test
	public void saveBook() throws Exception {
		SimpleDateFormat sf = new SimpleDateFormat("dd/mm/yyyy");
		Book book = new Book();
		book.setBookId(1);
		book.setTitle("First Book");
		book.setPrice(10);
		book.setVolume(10);
		book.setPublishDate(sf.parse("01/01/2001"));

		dao.saveBook(book);
	}
	

	@Test
	public void saveSubject() throws Exception {
		Subject subject = new Subject();
		subject.setSubjectId(1);
		subject.setSubjectTitle("First Subject");
		subject.setDurationInHours(10);
		subject.setBookId(1);
		dao.saveSubject(subject);
	}
	
	@Test
	public void getBooks() throws Exception {
		
		List<Book> books=dao.getBooks();
		
		 Assert.assertNotNull(books);
		 
		 Assert.assertEquals(ArrayList.class, books.getClass());
	}
	
	@Test
	public void getSubject() throws Exception {
		
		List<Subject> subjects=dao.getSubject();
		
		 Assert.assertNotNull(subjects);
		 
		 Assert.assertEquals(ArrayList.class, subjects.getClass());
	}
	
	@Test
	public void deleteBook() throws Exception {		
		dao.deleteBook(1);
	}

	@Test
	public void deleteSubject() throws Exception {		
		dao.deleteSubject(1);
	}
	
}
