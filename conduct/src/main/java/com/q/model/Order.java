package com.q.model;
// Generated 2017-10-16 11:22:22 by Hibernate Tools 4.3.1.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * TbImport generated by hbm2java
 */
@Entity
@Table(name = "tb_order", catalog = "conduct")
public class Order{

	private Long id;
	private TbUser tbUser;
	//账单描述
	private String orderDescribe;
	//账单类型
	private Integer type;
	//收入&支出("0"为收入，"1"为支出)
	private Integer money;
	//账单状态，是否被删除
	private int statues;
	//时间
	private Date date;

	public Order() {
	}

	/**
	 * @return the type
	 */
	@Column(name = "type")
	public Integer getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	public Order(TbUser tbUser, int statues) {
		this.tbUser = tbUser;
		this.statues = statues;
	}

	public Order(TbUser tbUser, Integer inputNum, int statues) {
		this.tbUser = tbUser;
		this.money = inputNum;
		this.statues = statues;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	public TbUser getTbUser() {
		return this.tbUser;
	}

	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}
	
	/**
	 * @return the orderDescribe
	 */
	@Column(name = "orderDescribe")
	public String getOrderDescribe() {
		return orderDescribe;
	}
	
	/**
	 * @param orderDescribe the orderDescribe to set
	 */
	public void setOrderDescribe(String orderDescribe) {
		this.orderDescribe = orderDescribe;
	}

	/**
	 * @return the money
	 */
	@Column(name = "money")
	public Integer getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(Integer money) {
		this.money = money;
	}

	@Column(name = "statues", nullable = false)
	public int getStatues() {
		return this.statues;
	}

	public void setStatues(int statues) {
		this.statues = statues;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", length = 19)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
