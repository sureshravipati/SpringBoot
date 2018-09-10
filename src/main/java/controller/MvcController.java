package controller;

import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entity.Book;
import entity.Subject;
import service.LibraryService;
import to.BookTo;
import to.SubjectTo;

@Controller
public class MvcController {	

	
	@Autowired
	LibraryService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Map<String, Object> model) {		
		return "index";
	}
	@RequestMapping(value = "/page/{name}", method = RequestMethod.GET)
	public ModelAndView getPage(@PathVariable("name") String name) throws Exception {
		ModelAndView model = new ModelAndView();

		if("addbook".contentEquals(name)
			||"searchbook".contentEquals(name)	)	{		
			model.addObject("book", new BookTo());	
		}
		
		if("addsubject".contentEquals(name)
			||"searchsubject".contentEquals(name))	{	
			model.addObject("subject", new SubjectTo());	
		}
		
		if("deletebook".contentEquals(name)) {
			model.addObject("books", service.getBooks());	
		}
		
		if("deletesubject".contentEquals(name)) {
			model.addObject("subjects", service.getSubject());	
		}
		
		model.setViewName(name);		
		return model;
	}
	
	@RequestMapping(value = "/addbook", method = RequestMethod.POST)
	public ModelAndView saveBook(@ModelAttribute("book") @Validated BookTo bookTo,BindingResult result) {
		ModelAndView view=new ModelAndView();
		SimpleDateFormat sf = new SimpleDateFormat("dd/mm/yyyy");
		Book book=new Book();
		try {			
			book.setBookId(bookTo.getBookId());
			book.setTitle(bookTo.getTitle());
			book.setPrice(bookTo.getPrice());
			book.setVolume(bookTo.getVolume());
			book.setPublishDate(sf.parse(bookTo.getPublishDate()));			
			service.saveBook(book);
		}catch(Exception ex) {
			 view.setViewName("addbook");	
			 return view;
		}		
		view.setViewName("success");		
		view.addObject("success", "Book is saved successfully.");	
		
		return view;
	}
	
	@RequestMapping(value = "/addsubject", method = RequestMethod.POST)
	public ModelAndView saveSubject(@ModelAttribute("subject") @Validated SubjectTo subjectTo,BindingResult result) {
		ModelAndView view=new ModelAndView();
		Subject subject=new Subject();
		try {			
			subject.setSubjectId(subjectTo.getSubjectId());
			subject.setSubjectTitle(subjectTo.getSubjectTitle());
			subject.setDurationInHours(subjectTo.getDurationInHours());
			subject.setBookId(subjectTo.getBookId());
			service.saveSubject(subject);
		}catch(Exception ex) {
			 view.setViewName("addsubject");	
			 return view;
		}		
		view.setViewName("success");		
		view.addObject("success", "Subject is saved successfully.");	
		
		return view;
	}
	
	@RequestMapping(value = "/deletebookId/{id}", method = RequestMethod.GET)
	public ModelAndView deleteBookId(@PathVariable("id") long id) {
		ModelAndView view=new ModelAndView();
		try {			
			service.deleteBook(id);
		}catch(Exception ex) {
			 view.setViewName("deletebook");	
			 return view;
		}		
		view.setViewName("success");		
		view.addObject("success", "Book has been deleted successfully.");	
		
		return view;
	}
	
	@RequestMapping(value = "/deletesubjectId/{id}", method = RequestMethod.GET)
	public ModelAndView deleteSubjectId(@PathVariable("id") long id) {
		ModelAndView view=new ModelAndView();
		try {			
			service.deleteSubject(id);
		}catch(Exception ex) {
			 view.setViewName("deletesubject");	
			 return view;
		}		
		view.setViewName("success");		
		view.addObject("success", "Subject has been deleted successfully.");	
		
		return view;
	}
	
	@RequestMapping(value = "/searchbookid", method = RequestMethod.POST)
	public ModelAndView searchbookBook(@ModelAttribute("book") @Validated BookTo bookTo,BindingResult result) {
		ModelAndView view=new ModelAndView();
		Book book=new Book();
		try {				
			for(Book bookObj:service.getBooks()) {
				if(bookObj.getBookId()==bookTo.getBookId())
					book=bookObj;
			}
		}catch(Exception ex) {
			 view.setViewName("searchbook");	
			 return view;
		}		
		view.setViewName("searchbook");		
		view.addObject("book",book);		
		return view;
	}
	
	@RequestMapping(value = "/searchsubjectid", method = RequestMethod.POST)
	public ModelAndView searchSubjectId(@ModelAttribute("subject") @Validated SubjectTo subjectTo,BindingResult result) {
		ModelAndView view=new ModelAndView();
		Subject subject=new Subject();
		try {				
			for(Subject subObj:service.getSubject()) {
				if(subObj.getSubjectId()==subjectTo.getSubjectId())
					subject=subObj;
			}
		}catch(Exception ex) {
			 view.setViewName("searchsubject");	
			 return view;
		}		
		view.setViewName("searchsubject");		
		view.addObject("subject",subject);		
		return view;
	}
}