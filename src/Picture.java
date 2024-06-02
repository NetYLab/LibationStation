import javax.swing.*;
import java.awt.*;

//JPanel을 상속받아 패널형식으로 클래스 작성
public class Picture extends JPanel {

    private ImageIcon icon = new ImageIcon("images/picture.png");//이미지 파일을 찾아 ImageIcon객체 생성
    private Image img = icon.getImage(); //ImageIcon의 이미지를 불러와 Image객체 생성

    public void paintComponent(Graphics p) { //paintComponent메소드를 오버라이딩
        super.paintComponent(p);
        p.drawImage(img, 0, 0, getWidth(), getHeight(), this);//패널 창에 맞게 이미지 크기 조정
    }
}