package payment;

import java.util.Scanner;

import auth.SessionUser;
import utils.Utils;

import menus.Menus;
import menus.UserMenu;
import ticket.TicketServices;

public class PaymentService {
    public static void ToPay(){
        Payment CreditCard1 = new Payment(1234567,000,"nombre","00/00","Mastercard");
        Scanner entrada = new Scanner(System.in);
        System.out.println("Desea realizar el pago?\n[Tarjeta de crédito o débito único medio de pago](1)\nDescartar(2): ");
        int confirmation = Integer.parseInt(entrada.nextLine());
        while(confirmation != 1 && confirmation != 2){
            System.out.println("Ingrese un número entre el '1' y el '2': ");
            confirmation = Integer.parseInt(entrada.nextLine());
        }
        System.out.println("Si su tarjeta es mastercard ingrese '1', si su tarjeta es visa ingrese '2':");
        int service = Integer.parseInt(entrada.nextLine());
        while(service != 1 && service != 2){
            System.out.println("Ingrese un número entre el '1' y el '2': ");
            service = Integer.parseInt(entrada.nextLine());
        }
        if(confirmation == 1){
            if(service == 2){
                CreditCard1.setServiceCard("Visa");
            }
            System.out.println("\nIngrese su nombre completo (Como aparece en su tarjeta): ");
            CreditCard1.setCreditCardName(entrada.nextLine());
            System.out.println("Ingrese su número de tarjeta: ");
            CreditCard1.setCreditCardNumber(Long.parseLong(entrada.nextLine()));
            while(CreditCard1.getCreditCardNumber()< Long.parseLong("1000000000000000")){
                System.out.println("Ingrese un número de tarjeta válido: ");
                CreditCard1.setCreditCardNumber(Long.parseLong(entrada.nextLine()));
            }
            System.out.println("Ingrese la fecha de expiración [mm/yy]: ");
            CreditCard1.setExpiration(entrada.nextLine());
            System.out.println("Ingrese el código de seguridad: ");
            CreditCard1.setSecretCode(Integer.parseInt(entrada.nextLine()));
        }else{
            CreditCard1.setCreditCard(false);
            UserMenu.getMenu(SessionUser.user.getName());
        }
        System.out.println(CreditCard1.toString());
    }
}
