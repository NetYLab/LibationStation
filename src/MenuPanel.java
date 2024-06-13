
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.*;


public class MenuPanel extends JPanel{

    JPanel[] panel; // 제품 패널
    JPanel[] label; // 제품 라벨
    JLabel[] productName; // 제품 이름
    JLabel[] productPrice; // 제품 가격
    ImageIcon[] productImage; // 제품 이미지
    FileInputStream nameFile; // 제품 이름 저장된 파일
    FileInputStream priceFile; // 제품 가격 저장된 파일
    public JButton[] productButton; // 제품 버튼
    public String[] name; // 제품 이름 저장될 배열
    public String[] price; // 제품 가격 저장될 배열
    public String[] imageName; // 제품 이름에 맞는 이미지 파일 이름
    String nameTemp;
    String priceTemp;
    int i = 0;
    int j=0;

    public MenuPanel(int count, String nameFile, String priceFile) {
        //제품 패널 생성
        panel = new JPanel[count]; // 제품의 개수만큼 제품 패널 배열 선언
        label=new JPanel[count]; // 제품의 개수 만큼 제품의 이름과 가격을 표시하는 라벨 배열 선언
        productName = new JLabel[count]; // 제품의 개수만큼 제품 패널의 라벨 배열 선언
        productPrice = new JLabel[count]; // 제품의 개수만큼 제품 패널의 라벨 배열 선언
        productButton = new JButton[count]; // 제품의 개수만큼 제품 패널의 버튼 배열 선언
        productImage = new ImageIcon[count]; // 제품의 개수만큼 버튼의 이미지 배열 선언
        name = new String[count]; // 파일에서 제품의 개수만큼 제품 이름을 받을 스트링 배열 생성
        price = new String[count]; // 파일에서 제품의 개수만큼 제품 가격을 받을 스트링 배열 생성
        imageName = new String[count];



        setLayout(null);
        setBackground(Color.WHITE);

        try {
            this.nameFile = new FileInputStream("files/" + nameFile + ".txt"); // 제품 이름 파일을 찾아서 nameFile객체 생성
            InputStreamReader in = new InputStreamReader(this.nameFile, "UTF-8"); // nameFile 객체를 읽을 InputStreamReader 객체 생성
            BufferedReader reader = new BufferedReader(in); // in객체로 BufferedReader 객체 생성

            //파일명에 따른 형태 변환
            while((nameTemp = reader.readLine())!=null){
                name[i]= nameTemp;
                imageName[i] = nameTemp.replace(' ', '_');
                i++;
            }
            in.close();
            reader.close();
        }
        catch(IOException e) {
            System.out.println(e);
        }

        try {
            this.priceFile = new FileInputStream("files/" + priceFile + ".txt"); // 제품 이름 파일을 찾아서 priceFile객체 생성
            InputStreamReader in = new InputStreamReader(this.priceFile, "UTF-8"); // priceFile 객체를 읽을 InputStreamReader 객체 생성
            BufferedReader reader = new BufferedReader(in); // in객체로 BufferedReader 객체 생성

            while ((priceTemp = reader.readLine()) != null) {
                price[j] = priceTemp;
                j++;
            }
            in.close();
            reader.close();
        }
        catch(IOException e) {
            System.out.println(e);
        }

        for(int i=0; i<count; i++) {
            panel[i]=new JPanel(); // 제품 패널 객체
            panel[i].setLayout(new BorderLayout());

            label[i]=new JPanel(); //제품 라벨 패널
            label[i].setLayout(new GridLayout(1,2));
            label[i].setBackground(Color.WHITE);
            productName[i]=new JLabel(name[i]); // 제품 이름 라벨
            productPrice[i]=new JLabel(price[i]+"원"); // 제품 가격 라벨
            label[i].add(productName[i]); // 제품 라벨 패널에 이름 추가
            label[i].add(productPrice[i]); // 제품 라벨 패널에 가격 추가
            productImage[i] = new ImageIcon("image/"+imageName[i]+".png"); // image파일에서 제품 이름에 맞는 이미지 찾기

            productButton[i]=new JButton(productImage[i]); // 제품의 이미지로 버튼 생성
            productButton[i].setBackground(Color.WHITE);
            panel[i].add(productButton[i],BorderLayout.CENTER);
            panel[i].add(label[i],BorderLayout.SOUTH);
            panel[i].setBackground(Color.WHITE);
            panel[i].setBounds(350*(i%3),350*(i/3),350,350);
            add(panel[i]);
        }
    }
}