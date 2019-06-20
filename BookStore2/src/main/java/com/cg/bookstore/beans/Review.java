package com.cg.bookstore.beans;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

enum Rating { 
	POOR(1),AVERAGE(2),GOOD(3);
	Rating(int ratingNumber){
		this.ratingNumber=ratingNumber;
	}
    private int ratingNumber;
    public int getRatingNumber() {
    	return ratingNumber;
    }
}
@Embeddable
public class Review {
private String headline;
private String comment;
@Id
@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="review_seq")
@SequenceGenerator(name="review_seq",sequenceName="review_seq",initialValue=100000,allocationSize=50000)
private int reviewId;
public Review() {}
public Review(String headline, String comment, int reviewId) {
	super();
	this.headline = headline;
	this.comment = comment;
	this.reviewId = reviewId;
}
public String getHeadline() {
	return headline;
}
public void setHeadline(String headline) {
	this.headline = headline;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public int getReviewId() {
	return reviewId;
}
public void setReviewId(int reviewId) {
	this.reviewId = reviewId;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((comment == null) ? 0 : comment.hashCode());
	result = prime * result + ((headline == null) ? 0 : headline.hashCode());
	result = prime * result + reviewId;
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
	Review other = (Review) obj;
	if (comment == null) {
		if (other.comment != null)
			return false;
	} else if (!comment.equals(other.comment))
		return false;
	if (headline == null) {
		if (other.headline != null)
			return false;
	} else if (!headline.equals(other.headline))
		return false;
	if (reviewId != other.reviewId)
		return false;
	return true;
}
@Override
public String toString() {
	return "Review [headline=" + headline + ", comment=" + comment + ", reviewId=" + reviewId + "]";
}

}
