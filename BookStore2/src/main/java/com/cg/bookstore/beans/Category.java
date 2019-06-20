package com.cg.bookstore.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Category {
@Id
private String categoryName;

@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="category_seq")
@SequenceGenerator(name="category_seq",sequenceName="category_seq",initialValue=1,allocationSize=500)
private int categoryId;
@ElementCollection
@OneToMany(mappedBy="category",fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
private List <Book> book;

public Category() {}

public Category(String categoryName, int categoryId, List<Book> book) {
	super();
	this.categoryName = categoryName;
	this.categoryId = categoryId;
	this.book = book;
}

public Category(String categoryName, int categoryId) {
	super();
	this.categoryName = categoryName;
	this.categoryId = categoryId;
}

public String getCategoryName() {
	return categoryName;
}

public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}

public int getCategoryId() {
	return categoryId;
}

public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}

public List<Book> getBook() {
	return book;
}

public void setBook(List<Book> book) {
	this.book = book;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((book == null) ? 0 : book.hashCode());
	result = prime * result + categoryId;
	result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
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
	Category other = (Category) obj;
	if (book == null) {
		if (other.book != null)
			return false;
	} else if (!book.equals(other.book))
		return false;
	if (categoryId != other.categoryId)
		return false;
	if (categoryName == null) {
		if (other.categoryName != null)
			return false;
	} else if (!categoryName.equals(other.categoryName))
		return false;
	return true;
}

@Override
public String toString() {
	return "Category [categoryName=" + categoryName + ", categoryId=" + categoryId + ", book=" + book + "]";
}

}
