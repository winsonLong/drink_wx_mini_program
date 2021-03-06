package com.example.pojo;

import java.util.Date;

public class OrderDetail {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_detail.orderId
     *
     * @mbggenerated
     */
    private String orderid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_detail.userId
     *
     * @mbggenerated
     */
    private String userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_detail.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_detail.total
     *
     * @mbggenerated
     */
    private Double total;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_detail.date
     *
     * @mbggenerated
     */
    private Date date;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_detail.state
     *
     * @mbggenerated
     */
    private Integer state;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_detail.orderId
     *
     * @return the value of order_detail.orderId
     *
     * @mbggenerated
     */
    public String getOrderid() {
        return orderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_detail.orderId
     *
     * @param orderid the value for order_detail.orderId
     *
     * @mbggenerated
     */
    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_detail.userId
     *
     * @return the value of order_detail.userId
     *
     * @mbggenerated
     */
    public String getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_detail.userId
     *
     * @param userid the value for order_detail.userId
     *
     * @mbggenerated
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_detail.content
     *
     * @return the value of order_detail.content
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_detail.content
     *
     * @param content the value for order_detail.content
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_detail.total
     *
     * @return the value of order_detail.total
     *
     * @mbggenerated
     */
    public Double getTotal() {
        return total;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_detail.total
     *
     * @param total the value for order_detail.total
     *
     * @mbggenerated
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_detail.date
     *
     * @return the value of order_detail.date
     *
     * @mbggenerated
     */
    public Date getDate() {
        return date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_detail.date
     *
     * @param date the value for order_detail.date
     *
     * @mbggenerated
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_detail.state
     *
     * @return the value of order_detail.state
     *
     * @mbggenerated
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_detail.state
     *
     * @param state the value for order_detail.state
     *
     * @mbggenerated
     */
    public void setState(Integer state) {
        this.state = state;
    }
}