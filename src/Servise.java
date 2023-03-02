import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Servise implements  interfase  {
    String fileName="base.txt";
    String line;
    File file=new File(fileName);
Scanner scanner=new Scanner(System.in);
    HashMap<String,String> dic=new HashMap<>();
    @Override
    public void List() {
        System.out.println("elementlar yo`yxati");
        for (String i : dic.keySet()) {
            System.out.println(": " + i + "------- " + dic.get(i));
        }
    }

    @Override
    public void Test() {
        System.out.println("iltimos mevaning inglizchasini kiriting ");
        for (String i : dic.keySet()) {
            System.out.println(" " + i );
            String temp= scanner.next();
            if (temp.equals(dic.get(i))) {
                System.out.print(i+"  ---"+dic.get(i)+"  ----> true\n");
            }
            else {
                System.out.println(i+"  ---" + dic.get(i) + "  ----> fase\n");
            }

        }
    }

    @Override
    public void AddElement() {
        System.out.println("meva nomini kiriting");
        String val,key;
        val=scanner.next();
        System.out.println("inglizcha nomini kiriting");
        key=scanner.next();
        dic.put(val,key);
        AddElmentFile(val,key);
    }
    @Override
    public void Sreach() {
        System.out.println("""
                
                =============================================
                -----tanlang-----
                1.Uzb-eng
                2.Eng-Uzb
                3.chiqish
                """);
        int choise= scanner.nextInt();
        switch (choise){
            case 1:{
                System.out.println("qidirilayotgan element nomini kiriting");
                int j=0;
                String temp= scanner.next();
                for (String i : dic.keySet()) {j++;
                    if (i.equals(temp)) {
                        System.out.println(": " + i + "------- " + dic.get(i)); break;
                    } else if ((j==dic.size())) {
                        System.out.println("element topilmadi qayta urunib kuring");
                        Sreach();
                    }

                }
                break;
            }
            case 2:{
                System.out.println("PLease enter sreaching fruit");
                int j=0;
                String temp= scanner.next();
                for (String i : dic.keySet()) {j++;
                    if (dic.get(i).equals(temp)) {
                        System.out.println(dic.get(i)+ "------- " + i ); break;
                    } else if ((j==dic.size())) {
                        System.out.println("there is none your element");
                        Sreach();
                    }
                    break;
                }
            }
            case 3:break;
        }

    }

    @Override
    public void NewFile() {
        try {
            if (file.createNewFile()) {
                System.out.println("yaratildi");

            }
            else System.out.println("fayl mavjud");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void FileToMap(){
        try {
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            while ((line= bufferedReader.readLine())!=null){
                line.split("=");
                String[] parts = line.split("=");
                dic.put(parts[0], parts[1]);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void AddElmentFile(String Uzb,String Eng) {
        try {
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String str;
            String txt=" ";
            while ((str= bufferedReader.readLine())!=null){
               txt=txt+str +"\n" ;
            }
            txt=txt+"\n"+Uzb+"="+Eng;
            FileWriter fileWriter=new FileWriter(fileName);
            fileWriter.write(txt);
            fileWriter.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("element qoshildi");
    }
}
