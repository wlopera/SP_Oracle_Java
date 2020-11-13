package ccb.stored.procedure.jobscheduler.model;

import java.io.Serializable;

public class Book implements Serializable {

	private static final long serialVersionUID = 4915820931134831393L;

	private Integer id;
	private String title;
	private String author;
	private String editorial;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", editorial=" + editorial + "]";
	}

}
