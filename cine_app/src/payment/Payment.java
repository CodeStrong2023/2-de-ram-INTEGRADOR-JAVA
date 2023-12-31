package payment;

public class Payment {
    //atributos
    private boolean CreditCard;
    private long CreditCardNumber;
    private int SecretCode;
    private String CreditCardName;
    private String Expiration;
    private String ServiceCard;

    //constructor

    public Payment(long CreditCardNumber, int SecretCode, String CreditCardName, String Expiration, String ServiceCard){
        this.CreditCard = true;
        this.CreditCardNumber = CreditCardNumber;
        this.SecretCode = SecretCode;
        this.CreditCardName = CreditCardName;
        this.Expiration = Expiration;
        this.ServiceCard = ServiceCard;
    }

    //getters and setters

    public boolean isCreditCard(){
        return this.CreditCard;
    }

    public void setCreditCard(boolean CreditCard){
        this.CreditCard = CreditCard;
    }

    public long getCreditCardNumber(){
        return this.CreditCardNumber;
    }

    public void setCreditCardNumber(long CreditCardNumber){
        this.CreditCardNumber = CreditCardNumber;
    }

    public int getSecretCode(){
        return this.SecretCode;
    }

    public void setSecretCode(int SecretCode){
        this.SecretCode = SecretCode;
    }

    public String getCreditCardName(){
        return this.CreditCardName;
    }

    public void setCreditCardName(String CreditCardName){
        this.CreditCardName = CreditCardName;
    }

    public String getExpiration(){
        return this.Expiration;
    }

    public void setExpiration(String Expiration){
        this.Expiration = Expiration;
    }

    public String getServiceCard(){
        return this.ServiceCard;
    }

    public void setServiceCard(String ServiceCard){
        this.ServiceCard = ServiceCard;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nTarjeta de crédito: ").append(this.CreditCard);
        sb.append("\nServicio: ").append(this.ServiceCard);
        sb.append("\nNombre: ").append(this.CreditCardName);
        sb.append("\nNúmero: ").append(this.CreditCardNumber);
        sb.append("\nExpiración: ").append(this.Expiration);
        //sb.append("\nCódigo: ").append(this.SecretCode);
        sb.append("\n").append(super.toString());
        return sb.toString();
    }

}
