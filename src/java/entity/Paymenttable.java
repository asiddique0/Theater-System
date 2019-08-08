/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author user
 */
@Entity
@Table(name = "PAYMENTTABLE")
@NamedQueries({
    @NamedQuery(name = "Paymenttable.findAll", query = "SELECT p FROM Paymenttable p"),
    @NamedQuery(name = "Paymenttable.findByTransactionId", query = "SELECT p FROM Paymenttable p WHERE p.transactionId = :transactionId"),
    @NamedQuery(name = "Paymenttable.findByCustomerName", query = "SELECT p FROM Paymenttable p WHERE p.customerName = :customerName"),
    @NamedQuery(name = "Paymenttable.findByCustomerPhone", query = "SELECT p FROM Paymenttable p WHERE p.customerPhone = :customerPhone"),
    @NamedQuery(name = "Paymenttable.findByCardNumber", query = "SELECT p FROM Paymenttable p WHERE p.cardNumber = :cardNumber"),
    @NamedQuery(name = "Paymenttable.findByCvv", query = "SELECT p FROM Paymenttable p WHERE p.cvv = :cvv"),
    @NamedQuery(name = "Paymenttable.findByTransactionDate", query = "SELECT p FROM Paymenttable p WHERE p.transactionDate = :transactionDate")})
public class Paymenttable implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "TRANSACTION_ID")
    private String transactionId;
    @Size(max = 100)
    @Column(name = "CUSTOMER_NAME")
    private String customerName;
    @Size(max = 20)
    @Column(name = "CUSTOMER_PHONE")
    private String customerPhone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "CARD_NUMBER")
    private String cardNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CVV")
    private String cvv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TRANSACTION_DATE")
    @Temporal(TemporalType.DATE)
    private Date transactionDate;

    public Paymenttable() {
    }

    public Paymenttable(String transactionId) {
        this.transactionId = transactionId;
    }

    public Paymenttable(String transactionId, String cardNumber, String cvv, Date transactionDate) {
        this.transactionId = transactionId;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.transactionDate = transactionDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paymenttable)) {
            return false;
        }
        Paymenttable other = (Paymenttable) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Paymenttable[ transactionId=" + transactionId + " ]";
    }
    
}
