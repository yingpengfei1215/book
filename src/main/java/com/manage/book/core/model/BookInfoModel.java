package com.manage.book.core.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.manage.book.dal.dataobject.BookInfoDO;

import java.io.Serializable;
import java.util.Date;

public class BookInfoModel implements Serializable {

    @JSONField(name = "isbn13")
    private String isbn;

    @JSONField(name = "author")
    private String author;

    @JSONField(name = "publisher")
    private String publishers;

    @JSONField(name = "image")
    private String pic;

    @JSONField(name = "summary")
    private String bookComment;

    @JSONField(name = "title")
    private String bookTitile;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BookInfoModel{");
        sb.append("isbn='").append(isbn).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", publishers='").append(publishers).append('\'');
        sb.append(", pic='").append(pic).append('\'');
        sb.append(", bookComment='").append(bookComment).append('\'');
        sb.append(", bookTitile='").append(bookTitile).append('\'');
        sb.append('}');
        return sb.toString();
    }

    /**
     * Getter method for property <tt>bookTitile</tt>.
     *
     * @return property value of bookTitile
     */
    public String getBookTitile() {
        return bookTitile;
    }

    /**
     * Setter method for property <tt>bookTitile</tt>.
     *
     * @param bookTitile value to be assigned to property bookTitile
     */
    public void setBookTitile(String bookTitile) {
        this.bookTitile = bookTitile;
    }

    /**
     * Getter method for property <tt>isbn</tt>.
     *
     * @return property value of isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Setter method for property <tt>isbn</tt>.
     *
     * @param isbn value to be assigned to property isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Getter method for property <tt>author</tt>.
     *
     * @return property value of author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Setter method for property <tt>author</tt>.
     *
     * @param author value to be assigned to property author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Getter method for property <tt>publishers</tt>.
     *
     * @return property value of publishers
     */
    public String getPublishers() {
        return publishers;
    }

    /**
     * Setter method for property <tt>publishers</tt>.
     *
     * @param publishers value to be assigned to property publishers
     */
    public void setPublishers(String publishers) {
        this.publishers = publishers;
    }

    /**
     * Getter method for property <tt>pic</tt>.
     *
     * @return property value of pic
     */
    public String getPic() {
        return pic;
    }

    /**
     * Setter method for property <tt>pic</tt>.
     *
     * @param pic value to be assigned to property pic
     */
    public void setPic(String pic) {
        this.pic = pic;
    }

    /**
     * Getter method for property <tt>bookComment</tt>.
     *
     * @return property value of bookComment
     */
    public String getBookComment() {
        return bookComment;
    }

    /**
     * Setter method for property <tt>bookComment</tt>.
     *
     * @param bookComment value to be assigned to property bookComment
     */
    public void setBookComment(String bookComment) {
        this.bookComment = bookComment;
    }
}