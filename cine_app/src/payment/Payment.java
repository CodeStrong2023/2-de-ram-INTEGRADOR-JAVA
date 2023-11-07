package payment;

public class Payment {
    //atributos
    private boolean CreditCard;
    private long CreditCardNumber;
    private int SecretCode;
    private String CreditCardName;
    private int Expiration;

    //constructor

    public Payment(long CreditCardNumber, int SecretCode, String CreditCardName, int Expiration){
        this.CreditCard = true;
        this.CreditCardNumber = CreditCardNumber;
        this.SecretCode = SecretCode;
        this.CreditCardName = CreditCardName;
        this.Expiration = Expiration;
    }

    //getters and setters

    public boolean CreditCard(){
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

    public int getExpiration(){
        return this.Expiration;
    }

    public void setExpiration(int Expiration){
        this.Expiration = Expiration;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Tarjeta de crédito: ").append(this.CreditCard);
        sb.append("\nNombre: ").append(this.CreditCardName);
        sb.append("\nNúmero: ").append(this.CreditCardNumber);
        sb.append("\nExpiración: ").append(this.Expiration);
        //sb.append("\nCódigo: ").append(this.SecretCode);
        sb.append("\n").append(super.toString());
        return sb.toString();
    }

}
