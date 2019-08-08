package bean;

import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.validator.ValidatorException;

@Named(value = "mainPageBean")
@RequestScoped
public class MainPageBean implements Serializable {
    
    
    private String zip;
    private String url;
    public MainPageBean() { }


    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        sessionMap.put("zip", zip);
        this.zip = zip;
    }
    
    public void validate(FacesContext fc, UIComponent uic, Object obj) throws ValidatorException
    {
        String zip = (String) obj;

        if (zip.length() != 5) {
            url = "zipLengthError.xhtml";
        }
        else if (!containsOnlyDigits(zip)) {
            url = "zipContentError.xhtml";
        }
        else
            url = "theaterList.xhtml";
        
    }
    
    private boolean containsOnlyDigits(String str) {
        if (str.length() != 5) 
            return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }
    
    public String nextPage() {
        if (url == null)
            url = "theaterList.xhtml";
        return url;
    }
}
