import java.util.*;
public class Customer extends Account {
    public static void main(String[] args) {
        HashMap<Integer, Account> map = new HashMap<Integer, Account>();
        int i = 0;
        int ide = 1001;
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s1 = sc.nextLine();
            String arr[] = s1.split(" ", 2);
            String keyword = arr[0];
            String rest = arr[1];
            switch (keyword) {
                case "Create":
                    map.put(ide, new Account(rest));
                    Account ac = map.get(ide);
                    ac.setId(ide);
                    System.out.println(ide);
                    ide++;
                    break;
                case "Deposit":
                    try {
                        String line[] = arr[1].split(" ");
                        int id = Integer.parseInt(line[0]);
                        map.get(id).depositMoney(Double.parseDouble(line[1]));
                    }

                    catch (Exception e){
                        System.out.println("Error bro, please write correct syntax");
                    }
                    break;
                case "Balance":
                    System.out.println(map.get(Integer.parseInt(rest)).getBalance());
                    break;
                case "Withdraw":
                    String line2[] = arr[1].split(" ");
                    int id2 = Integer.parseInt(line2[0]);
                    map.get(id2).withdrawal(Double.parseDouble(line2[1]));
                    break;
                case "Transfer":
                    String line3[] = arr[1].split(" ");
                    int from_id = Integer.parseInt(line3[0]);
                    int to_id = Integer.parseInt(line3[1]);
                    Double transfer_amount = Double.parseDouble(line3[2]);
                    moneyTransfer(map.get(from_id),map.get(to_id),transfer_amount);
                    break;
                default:
                    System.out.println("Enter valid operations('Create','Deposit','Balance','Withdraw','Transfer')");
            }
        }
    }
}