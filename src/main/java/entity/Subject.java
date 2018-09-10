package entity;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subject")
public class Subject implements Serializable{
	
	private static final long serialVersionUID = 7469174760254553567L;
	@Id
	@Column(name = "subjectId")
	private long subjectId;
	
	@Column(name = "subjectTitle")
	private String subjectTitle;
	
	@Column(name = "durationInHours")
	private int durationInHours;
	
	@Column(name="bookid")
    private long bookId;	
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="bookId")
	private Set<Book> references;

	/**
	 * @return the subjectId
	 */
	public long getSubjectId() {
		return subjectId;
	}

	/**
	 * @param subjectId the subjectId to set
	 */
	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	/**
	 * @return the subjectTitle
	 */
	public String getSubjectTitle() {
		return subjectTitle;
	}

	/**
	 * @param subjectTitle the subjectTitle to set
	 */
	public void setSubjectTitle(String subjectTitle) {
		this.subjectTitle = subjectTitle;
	}

	/**
	 * @return the durationInHours
	 */
	public int getDurationInHours() {
		return durationInHours;
	}

	/**
	 * @param durationInHours the durationInHours to set
	 */
	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public Set<Book> getReferences() {
		return references;
	}

	public void setReferences(Set<Book> references) {
		this.references = references;
	}	
}
