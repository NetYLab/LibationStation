
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Request extends JPanel{

    String []head = {"제품명", "수량", "가격"};//테이블 헤더
    String [][]data= {};//테이블 형식

    public DefaultTableModel table = new DefaultTableModel(data,head);//테이블 모델 생성
    public JTable cart = new JTable(table);//장바구니 테이블 객체 생성
    public JButton menudelete = new JButton("선택한 메뉴 삭제");//장바구니 삭제 버튼

    JLabel paylabel = new JLabel("결제 금액");//결제 금액 라벨 객체 생성
    public JLabel paysum = new JLabel(" ");//금액이 표시될 라벨 객체 생성

    JLabel request_lab = new JLabel("요청 사항");//"요청 사항 라벨 
    public JTextArea request_write = new JTextArea(); //요청 사항 텍스트

    public JButton order = new JButton("주문");//주문 버튼
    public JButton cancel = new JButton("취소");//취소 버튼

    public JButton choice_pay1 = new JButton("카드 결제");//카드 결제 버튼
    public JButton choice_pay2 = new JButton("현금 결제");//현금 결제 버튼

    public int allprice=0;//전체 금액 0으로 초기화

    public Request() {
        setLayout(null);
        JScrollPane scrollbusket = new JScrollPane(cart);//장바구니 스크롤
        scrollbusket.setBounds(0,0,525,135);//스크롤 위치,크기
        add(scrollbusket);//스크롤 넣기

        request_lab.setBounds(525,0,525,20);//요청사항라벨
        add(request_lab);
        request_write.setFont(new Font("맑은 고딕",Font.BOLD,22));
        JScrollPane scrollrequest = new JScrollPane(request_write);//요청 사항 스크롤 생성
        scrollrequest.setBounds(525,20,525,110);//스크롤 텍스트 위치,크기
        add(scrollrequest);

        choice_pay1.setBounds(525,130,262,30);//카드 결제 버튼
        add(choice_pay1);
        choice_pay2.setBounds(788,130,262,30);//현금 결제 버튼
        add(choice_pay2);

        order.setFont(new Font("맑은 고딕",Font.BOLD,50));//주문 글자 크기
        order.setBackground(Color.RED);//주문 색깔
        order.setBounds(525,160,262,85);
        add(order);

        cancel.setFont(new Font("맑은 고딕",Font.BOLD,50));//취소 글자 크기
        cancel.setBackground(Color.GRAY);//취소 색깔
        cancel.setBounds(787,160,262,85);
        add(cancel);

        menudelete.setBounds(0,130,525,30);
        add(menudelete);//삭제 버튼 삽입

        paylabel.setBounds(0,150,150,100);//결제 금액 라벨
        paylabel.setFont(new Font("맑은 고딕",Font.BOLD,33));//글자 폰트
        add(paylabel);

        paysum.setBounds(150,160,375,81);//금액이 표시될 라벨
        paysum.setFont(new Font("맑은 고딕",Font.BOLD,57));//금액 글자 폰트
        paysum.setBackground(Color.white);//배경색 설정
        paysum.setOpaque(true);
        add(paysum);
    }
}