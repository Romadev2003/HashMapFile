import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Servise servise=new Servise();
        servise.NewFile();
        servise.FileToMap();
        Label:
        while (true){
            System.out.println("""
                ============Tanlang==========
                ==1.Ro`yxat=================
                ==2.Test====================
                ==3.Element qo`shish=========
                ==4.Qidirish=================""");
            int choise= scanner.nextInt();
            switch (choise) {
                case 1 -> servise.List();
                case 2 -> servise.Test();
                case 3 ->servise. AddElement();
                case 4 -> servise.Sreach();
                case 5 -> { break Label;}
                default -> System.out.println("qaytadan urunib ko`ring");
            }
        }

    }
}