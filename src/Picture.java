import javax.swing.*;
import java.awt.*;

public class Picture extends JPanel {

    private ImageIcon icon = new ImageIcon("image/Logo.png"); //로고 이미지 파일을 찾아 ImageIcon객체 생성
    private Image image = icon.getImage(); // ImageIcon의 이미지를 불러와 Image객체 생성

    public void paintComponent(Graphics p) { //paintComponent메소드를 오버라이딩
        super.paintComponent(p);
        p.drawImage(image, 0, 0, getWidth(), getHeight(), this); // 패널 창에 맞게 이미지 크기 조정
    }
}