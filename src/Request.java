
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Request extends JPanel{

    String []head = {"제품명", "수량", "가격"}; // 테이블 헤더
    String [][]data= {}; // 테이블 형태로 저장

    public DefaultTableModel table = new DefaultTableModel(data,head); // 테이블 모델 생성
    public JTable cart = new JTable(table); // 장바구니 테이블 객체 생성
    public JButton menuDelete = new JButton("선택한 메뉴 삭제"); // 장바구니에서 메뉴 삭제 버튼

    JLabel payLabel = new JLabel("결제 금액"); // 결제 금액 라벨
    public JLabel paySum = new JLabel(" "); // 금액이 표시될 라벨

    JLabel requestLabel = new JLabel("요청 사항"); // 요청 사항 라벨
    public JTextArea requestWrite = new JTextArea(); // 요청 사항적는 JTestArea

    public JButton order = new JButton("주문"); // 주문 버튼
    public JButton cancel = new JButton("취소"); // 취소 버튼

    public JButton choicePay1 = new JButton("QR 결제"); // QR 결제 버튼
    public JButton choicePay2 = new JButton("현금 결제"); // 현금 결제 버튼

    public int allPrice = 0; // 총 금액의 초기값은 0

    public Request() {
        setLayout(null);
        JScrollPane scrollBusket = new JScrollPane(cart); // 장바구니 스크롤
        scrollBusket.setBounds(0,0,525,135);
        add(scrollBusket);

        requestLabel.setBounds(525,0,525,20); // 요청 사항 라벨
        add(requestLabel);
        requestWrite.setFont(new Font("맑은 고딕",Font.BOLD,22));
        JScrollPane scrollRequest = new JScrollPane(requestWrite);
        scrollRequest.setBounds(525,20,525,110);
        add(scrollRequest);

        choicePay1.setBounds(525,130,262,30); //QR 결제 버튼
        add(choicePay1);
        choicePay2.setBounds(788,130,262,30); // 현금 결제 버튼
        add(choicePay2);

        order.setFont(new Font("맑은 고딕",Font.BOLD,50)); // 주문 글자 크기
        order.setBackground(Color.RED);
        order.setBounds(525,160,262,85);
        add(order);

        cancel.setFont(new Font("맑은 고딕",Font.BOLD,50)); // 취소 글자 크기
        cancel.setBackground(Color.GRAY);
        cancel.setBounds(787,160,262,85);
        add(cancel);

        menuDelete.setBounds(0,130,525,30);
        add(menuDelete);

        payLabel.setBounds(0,150,150,100); // 결제 금액 라벨
        payLabel.setFont(new Font("맑은 고딕",Font.BOLD,33));
        add(payLabel);

        paySum.setBounds(150,160,375,81); // 금액이 표시될 라벨
        paySum.setFont(new Font("맑은 고딕",Font.BOLD,57));
        paySum.setBackground(Color.white);//배경색 설정
        paySum.setOpaque(true);
        add(paySum);
    }
}