package com.manage.book.dal.dataobject;

import java.util.Date;

public class BookInfoDO {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.isbn
     *
     * @mbggenerated
     */
    private String isbn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.owner_id
     *
     * @mbggenerated
     */
    private Integer ownerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.borrower_id
     *
     * @mbggenerated
     */
    private Integer borrowerId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.book_status
     *
     * @mbggenerated
     */
    private Integer bookStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.author
     *
     * @mbggenerated
     */
    private String author;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.book_type
     *
     * @mbggenerated
     */
    private String bookType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.publishers
     *
     * @mbggenerated
     */
    private String publishers;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.pic
     *
     * @mbggenerated
     */
    private String pic;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.brief
     *
     * @mbggenerated
     */
    private String brief;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.book_comment
     *
     * @mbggenerated
     */
    private String bookComment;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.deposit
     *
     * @mbggenerated
     */
    private Integer deposit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.cost
     *
     * @mbggenerated
     */
    private Integer cost;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.gmt_modified
     *
     * @mbggenerated
     */
    private Date gmtModified;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.gmt_create
     *
     * @mbggenerated
     */
    private Date gmtCreate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column book_info.book_titile
     *
     * @mbggenerated
     */
    private String bookTitile;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_info
     *
     * @mbggenerated
     */
    public BookInfoDO(Integer id, String isbn, Integer ownerId, Integer borrowerId, Integer bookStatus, String author, String bookType, String publishers, String pic, String brief, String bookComment, Integer deposit, Integer cost, Date gmtModified, Date gmtCreate, String bookTitile) {
        this.id = id;
        this.isbn = isbn;
        this.ownerId = ownerId;
        this.borrowerId = borrowerId;
        this.bookStatus = bookStatus;
        this.author = author;
        this.bookType = bookType;
        this.publishers = publishers;
        this.pic = pic;
        this.brief = brief;
        this.bookComment = bookComment;
        this.deposit = deposit;
        this.cost = cost;
        this.gmtModified = gmtModified;
        this.gmtCreate = gmtCreate;
        this.bookTitile = bookTitile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table book_info
     *
     * @mbggenerated
     */
    public BookInfoDO() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.id
     *
     * @return the value of book_info.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.id
     *
     * @param id the value for book_info.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.isbn
     *
     * @return the value of book_info.isbn
     *
     * @mbggenerated
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.isbn
     *
     * @param isbn the value for book_info.isbn
     *
     * @mbggenerated
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.owner_id
     *
     * @return the value of book_info.owner_id
     *
     * @mbggenerated
     */
    public Integer getOwnerId() {
        return ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.owner_id
     *
     * @param ownerId the value for book_info.owner_id
     *
     * @mbggenerated
     */
    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.borrower_id
     *
     * @return the value of book_info.borrower_id
     *
     * @mbggenerated
     */
    public Integer getBorrowerId() {
        return borrowerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.borrower_id
     *
     * @param borrowerId the value for book_info.borrower_id
     *
     * @mbggenerated
     */
    public void setBorrowerId(Integer borrowerId) {
        this.borrowerId = borrowerId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.book_status
     *
     * @return the value of book_info.book_status
     *
     * @mbggenerated
     */
    public Integer getBookStatus() {
        return bookStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.book_status
     *
     * @param bookStatus the value for book_info.book_status
     *
     * @mbggenerated
     */
    public void setBookStatus(Integer bookStatus) {
        this.bookStatus = bookStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.author
     *
     * @return the value of book_info.author
     *
     * @mbggenerated
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.author
     *
     * @param author the value for book_info.author
     *
     * @mbggenerated
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.book_type
     *
     * @return the value of book_info.book_type
     *
     * @mbggenerated
     */
    public String getBookType() {
        return bookType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.book_type
     *
     * @param bookType the value for book_info.book_type
     *
     * @mbggenerated
     */
    public void setBookType(String bookType) {
        this.bookType = bookType == null ? null : bookType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.publishers
     *
     * @return the value of book_info.publishers
     *
     * @mbggenerated
     */
    public String getPublishers() {
        return publishers;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.publishers
     *
     * @param publishers the value for book_info.publishers
     *
     * @mbggenerated
     */
    public void setPublishers(String publishers) {
        this.publishers = publishers == null ? null : publishers.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.pic
     *
     * @return the value of book_info.pic
     *
     * @mbggenerated
     */
    public String getPic() {
        return pic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.pic
     *
     * @param pic the value for book_info.pic
     *
     * @mbggenerated
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.brief
     *
     * @return the value of book_info.brief
     *
     * @mbggenerated
     */
    public String getBrief() {
        return brief;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.brief
     *
     * @param brief the value for book_info.brief
     *
     * @mbggenerated
     */
    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.book_comment
     *
     * @return the value of book_info.book_comment
     *
     * @mbggenerated
     */
    public String getBookComment() {
        return bookComment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.book_comment
     *
     * @param bookComment the value for book_info.book_comment
     *
     * @mbggenerated
     */
    public void setBookComment(String bookComment) {
        this.bookComment = bookComment == null ? null : bookComment.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.deposit
     *
     * @return the value of book_info.deposit
     *
     * @mbggenerated
     */
    public Integer getDeposit() {
        return deposit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.deposit
     *
     * @param deposit the value for book_info.deposit
     *
     * @mbggenerated
     */
    public void setDeposit(Integer deposit) {
        this.deposit = deposit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.cost
     *
     * @return the value of book_info.cost
     *
     * @mbggenerated
     */
    public Integer getCost() {
        return cost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.cost
     *
     * @param cost the value for book_info.cost
     *
     * @mbggenerated
     */
    public void setCost(Integer cost) {
        this.cost = cost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.gmt_modified
     *
     * @return the value of book_info.gmt_modified
     *
     * @mbggenerated
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.gmt_modified
     *
     * @param gmtModified the value for book_info.gmt_modified
     *
     * @mbggenerated
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.gmt_create
     *
     * @return the value of book_info.gmt_create
     *
     * @mbggenerated
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.gmt_create
     *
     * @param gmtCreate the value for book_info.gmt_create
     *
     * @mbggenerated
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column book_info.book_titile
     *
     * @return the value of book_info.book_titile
     *
     * @mbggenerated
     */
    public String getBookTitile() {
        return bookTitile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column book_info.book_titile
     *
     * @param bookTitile the value for book_info.book_titile
     *
     * @mbggenerated
     */
    public void setBookTitile(String bookTitile) {
        this.bookTitile = bookTitile == null ? null : bookTitile.trim();
    }
}