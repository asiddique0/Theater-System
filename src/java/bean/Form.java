package bean;

import ejb.theaterEJB;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.validator.ValidatorException;

@Named(value = "form")
@RequestScoped
public class Form {

    @EJB
    private theaterEJB theaterEJB;
    
    private String customerName, customerPhone, 
                   customerEmail, cardNumber, cvv;
    private final int ticketCost = 10;
    private String url;
    
    public Form() { }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.put("customerName", customerName);
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.put("customerPhone", customerPhone);
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        if (cardNumber.length() != 16) return;
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < cardNumber.length()-4 ; i++) {
            sb.append("x");
        }
        sb.append(cardNumber, cardNumber.length()-5, cardNumber.length()-1);
        flash.put("cardNumber", new String(sb));
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public int getTicketCost() {
        Flash flash = FacesContext.getCurrentInstance().getExternalContext().getFlash();
        flash.put("ticketCost", ticketCost);
        return ticketCost;
    }
    
    public void validate (FacesContext fc, UIComponent uic, Object obj) throws ValidatorException
    {
        String cc_number = (String) obj;

        if (cc_number.length() != 16 || cc_number.equals(""))
            url = "ccLengthError.xhtml";
        else if (!containsOnlyDigits(cc_number))
            url = "ccContentError.xhtml";
        else
            url = "receipt.xhtml";

    }
    
    private boolean containsOnlyDigits(String str) {
        if (str.length() != 16) 
            return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }
    
    private boolean checkParametersNull() {
        boolean checkParameters = (customerName == null ||
                customerPhone == null ||
                customerEmail == null ||
                cardNumber == null ||
                cvv == null);
        
        return checkParameters;
    }
    
    public String submitForm() {
        if (!checkParametersNull() && url.equals("receipt.xhtml")) {
            theaterEJB.saveCustomerInformation(customerName, customerPhone, customerEmail, cardNumber, cvv);
        } 
        
        return url;
    }
}
