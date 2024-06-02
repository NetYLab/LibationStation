
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.*;


public class MenuPanel extends JPanel{ //JPanel을 상속받아 패널형식 클래스 만들기

    JPanel[]panel;//제품 패널 레퍼런스
    JPanel[]label;//제품 라벨 레퍼런스
    JLabel[] productname;//제품 이름 레퍼런스
    JLabel[] productprice;//제품 가격 레퍼런스
    public JButton [] productbutton;//제품 버튼 레퍼런스
    ImageIcon[] productimage;//버튼 이미지 레퍼런스

    FileInputStream file_n;
    FileInputStream file_p;
    public String []name;//제품 이름 저장 배열
    String nametmp;
    int i =0;
    public String []price; //제품 가격 저장 배열
    String pricetmp;
    int j=0;

    //MenuOption[] dialog;


    public MenuPanel(int cnt, String namefile, String pricefile) {
        //제품 패널 생성
        panel = new JPanel[cnt];//제품의 개수만큼 제품 패널 레퍼런스 선언
        label=new JPanel[cnt];//제품의 개수 만큼 제품의 이름과 가격을 표시할 라벨 레퍼런스 선언
        productname = new JLabel[cnt];//제품의 개수만큼 제품 패널의 라벨 레퍼런스 선언
        productprice = new JLabel[cnt];//제품의 개수만큼 제품 패널의 라벨 레퍼런스 선언
        productbutton = new JButton[cnt];//제품의 개수만큼 제품 패널의 버튼 레퍼런스 선언
        productimage = new ImageIcon[cnt];//제품의 개수만큼 버튼의 이미지 레퍼런스 선언
        name = new String[cnt];//파일에서 제품의 개수만큼 제품 이름을 받을 스트링  배열 생성
        price = new String[cnt];//파일에서 제품의 개수만큼 제품 가격을 받을 스트링 배열 생성


        setLayout(null);
        setBackground(Color.WHITE);//패널의 배경색 흰색

        try {
            file_n = new FileInputStream("files/"+namefile+".txt");//제품 이름 파일을 찾아서 file_n객체 생성
            InputStreamReader in = new InputStreamReader(file_n,"UTF-8");//file_n객체를 읽을 수 있는 in객체를 생성
            BufferedReader reader = new BufferedReader(in);//in객체를 버퍼스트림객체로 생성

            //파일 입출력
            while((nametmp = reader.readLine())!=null){
                name[i]=nametmp;
                i++;
            }
            in.close();
        }
        catch(IOException e) {
            System.out.println(e);
        }

        try {
            file_p = new FileInputStream("files/"+pricefile+".txt");//생성자에서 받은 제품 가격 파일을 찾아서 file_p객체 생성
            InputStreamReader in = new InputStreamReader(file_p,"UTF-8");//file_p객체를 읽을 수 있는 in객체를 생성
            BufferedReader reader = new BufferedReader(in);//in객체를 버퍼스트림객체로 생성

            //파일에서 내용이 없을때까지 한줄씩 읽은다음 pricetmp에 입력.
            while((pricetmp=reader.readLine())!=null){
                price[j]=pricetmp;
                j++;
            }
            in.close();
        }
        catch(IOException e) {
            System.out.println(e);
        }

        for(int i=0; i<cnt; i++) {
            panel[i]=new JPanel();//제품 패널 객체 생성
            panel[i].setLayout(new BorderLayout());//BorderLayout 설정

            label[i]=new JPanel();//제품 라벨 패널 생성
            label[i].setLayout(new GridLayout(1,2));//위치 지정
            label[i].setBackground(Color.WHITE);//배경색을 흰색으로
            productname[i]=new JLabel(name[i]);//제품 이름 라벨
            productprice[i]=new JLabel(price[i]+"원");//제품 가격 라벨
            label[i].add(productname[i]);//제품 라벨 패널에 이름 라벨 넣기
            label[i].add(productprice[i]);//제품 라벨 패널에 가격 라벨 넣기
            productimage[i] = new ImageIcon("images/"+name[i]+".png");//images파일에서 제품 이름의 이미지를 찾기

            productbutton[i]=new JButton(productimage[i]);//제품의 이미지를 넣어서 버튼 객체 생성
            productbutton[i].setBackground(Color.WHITE);//버튼색 흰색
            panel[i].add(productbutton[i],BorderLayout.CENTER);//CENTER에 버튼 삽입
            panel[i].add(label[i],BorderLayout.SOUTH);//SOUTH에 제품 라벨 삽입
            panel[i].setBackground(Color.WHITE);//배경색 흰색
            panel[i].setBounds(350*(i%3),350*(i/3),350,350);
            add(panel[i]);
        }
    }
}