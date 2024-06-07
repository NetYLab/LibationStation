
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.*;


public class MenuPanel extends JPanel{ //JPanel을 상속받아 패널형식 클래스 만들기

    JPanel[] panel;//제품 패널 레퍼런스
    JPanel[] label;//제품 라벨 레퍼런스
    JLabel[] productName;//제품 이름 레퍼런스
    JLabel[] productPrice;//제품 가격 레퍼런스
    ImageIcon[] productImage;//버튼 이미지 레퍼런스
    FileInputStream nameFile;
    FileInputStream priceFile;
    public JButton[] productButton;//제품 버튼 레퍼런스
    public String[] name;//제품 이름 저장 배열
    public String[] price; //제품 가격 저장 배열
    public String[] imageName; //제품 이름에 따른 이미지파일 이름
    String nameTemp;
    String priceTemp;
    int i = 0;
    int j=0;

    //MenuOption[] dialog;


    public MenuPanel(int count, String nameFile, String priceFile) {
        //제품 패널 생성
        panel = new JPanel[count];//제품의 개수만큼 제품 패널 레퍼런스 선언
        label=new JPanel[count];//제품의 개수 만큼 제품의 이름과 가격을 표시할 라벨 레퍼런스 선언
        productName = new JLabel[count];//제품의 개수만큼 제품 패널의 라벨 레퍼런스 선언
        productPrice = new JLabel[count];//제품의 개수만큼 제품 패널의 라벨 레퍼런스 선언
        productButton = new JButton[count];//제품의 개수만큼 제품 패널의 버튼 레퍼런스 선언
        productImage = new ImageIcon[count];//제품의 개수만큼 버튼의 이미지 레퍼런스 선언
        name = new String[count];//파일에서 제품의 개수만큼 제품 이름을 받을 스트링  배열 생성
        imageName = new String[count];
        price = new String[count];//파일에서 제품의 개수만큼 제품 가격을 받을 스트링 배열 생성


        setLayout(null);
        setBackground(Color.WHITE);//패널의 배경색 흰색

        try {
            this.nameFile = new FileInputStream("files/" + nameFile + ".txt");//제품 이름 파일을 찾아서 file_n객체 생성
            InputStreamReader in = new InputStreamReader(this.nameFile, "UTF-8");//file_n객체를 읽을 수 있는 in객체를 생성
            BufferedReader reader = new BufferedReader(in);//in객체를 버퍼스트림객체로 생성

            //파일 입출력
            while((nameTemp = reader.readLine())!=null){
                name[i]= nameTemp;
                imageName[i] = nameTemp.replace(' ', '_');
                i++;
            }
            in.close();
        }
        catch(IOException e) {
            System.out.println(e);
        }

        try {
            this.priceFile = new FileInputStream("files/" + priceFile + ".txt");//생성자에서 받은 제품 가격 파일을 찾아서 file_p객체 생성
            InputStreamReader in = new InputStreamReader(this.priceFile, "UTF-8");//file_p객체를 읽을 수 있는 in객체를 생성
            BufferedReader reader = new BufferedReader(in);//in객체를 버퍼스트림객체로 생성

            //파일에서 내용이 없을때까지 한줄씩 읽은다음 pricetmp에 입력.
            while ((priceTemp = reader.readLine()) != null) {
                price[j] = priceTemp;
                j++;
            }
            in.close();
        }
        catch(IOException e) {
            System.out.println(e);
        }

        for(int i=0; i<count; i++) {
            panel[i]=new JPanel();//제품 패널 객체 생성
            panel[i].setLayout(new BorderLayout());//BorderLayout 설정

            label[i]=new JPanel();//제품 라벨 패널 생성
            label[i].setLayout(new GridLayout(1,2));//위치 지정
            label[i].setBackground(Color.WHITE);//배경색을 흰색으로
            productName[i]=new JLabel(name[i]);//제품 이름 라벨
            productPrice[i]=new JLabel(price[i]+"원");//제품 가격 라벨
            label[i].add(productName[i]);//제품 라벨 패널에 이름 라벨 넣기
            label[i].add(productPrice[i]);//제품 라벨 패널에 가격 라벨 넣기
            productImage[i] = new ImageIcon("image/"+imageName[i]+".png");//images파일에서 제품 이름의 이미지를 찾기

            productButton[i]=new JButton(productImage[i]);//제품의 이미지를 넣어서 버튼 객체 생성
            productButton[i].setBackground(Color.WHITE);//버튼색 흰색
            panel[i].add(productButton[i],BorderLayout.CENTER);//CENTER에 버튼 삽입
            panel[i].add(label[i],BorderLayout.SOUTH);//SOUTH에 제품 라벨 삽입
            panel[i].setBackground(Color.WHITE);//배경색 흰색
            panel[i].setBounds(350*(i%3),350*(i/3),350,350);
            add(panel[i]);
        }
    }
}