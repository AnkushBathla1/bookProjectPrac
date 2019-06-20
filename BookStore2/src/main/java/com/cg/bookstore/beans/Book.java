package com.cg.bookstore.beans;

import java.time.LocalDate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
@Entity
public class Book {
	private String title,author,description;
	@Id
	@SequenceGenerator(name="book_seq",sequenceName="book_seq",initialValue=5000,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="book_seq")
	private int ISBN_Number;
	private float price;
	private LocalDate publishDate;
	@ManyToOne
	private Category category;
	@Embedded
	private Review review;
	public Book() {}
	
	public Book(String title, String author, String description, int iSBN_Number, float price, LocalDate publishDate,
			Category category, Review review) {
		super();
		this.title = title;
		this.author = author;
		this.description = description;
		ISBN_Number = iSBN_Number;
		this.price = price;
		this.publishDate = publishDate;
		this.category = category;
		this.review = review;
	}

	public Book(String title, String author, String description, int iSBN_Number, float price, LocalDate publishDate,
			Category category) {
		super();
		this.title = title;
		this.author = author;
		this.description = description;
		ISBN_Number = iSBN_Number;
		this.price = price;
		this.publishDate = publishDate;
		this.category = category;
	}
	
	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getISBN_Number() {
		return ISBN_Number;
	}
	public void setISBN_Number(int iSBN_Number) {
		ISBN_Number = iSBN_Number;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ISBN_Number;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((publishDate == null) ? 0 : publishDate.hashCode());
		result = prime * result + ((review == null) ? 0 : review.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (ISBN_Number != other.ISBN_Number)
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (publishDate == null) {
			if (other.publishDate != null)
				return false;
		} else if (!publishDate.equals(other.publishDate))
			return false;
		if (review == null) {
			if (other.review != null)
				return false;
		} else if (!review.equals(other.review))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", description=" + description + ", ISBN_Number="
				+ ISBN_Number + ", price=" + price + ", publishDate=" + publishDate + ", category=" + category
				+ ", review=" + review + "]";
	}
}