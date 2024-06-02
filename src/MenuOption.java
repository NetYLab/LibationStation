import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MenuOption extends JDialog {

    //수량체크 다이얼로그
    public int count=1;//수량
    public JLabel cnt = new JLabel(count+"");//수량 표시될 수량 라벨 버튼
    public JButton okbutton = new JButton("확인");//확인 버튼
    JButton minusbutton = new JButton("-");//-버튼
    JButton plusbutton = new JButton("+");//+버튼
    JButton garlicpopcorn = new JButton("갈릭");//갈릭 버튼
    JButton caramelpopcorn = new JButton("카라멜");//카라멜 버튼
    JButton coke = new JButton("콜라");//콜라 버튼
    JButton cidar = new JButton("사이다");//사이다 버튼
    JButton tea = new JButton("허브티");//허브티 버튼
    JButton coffee = new JButton("커피");//오늘의 커피 버튼

    //음료,팝콘,사이드 수량 체크 다이얼로그
    public MenuOption(String name, String price) {
        setTitle(name);
        setLayout(null);
        minusbutton.setBounds(50,30,60,60);//-버튼 위치,크기
        plusbutton.setBounds(200,30,60,60);//+버튼 위치,크기
        cnt.setBounds(150,30,60,60);//수랑 라벨 위치,크기
        okbutton.setBounds(75,120,160,40);//확인 버튼  위치,크기
        setVisible(false);

        //-버튼
        minusbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(0<count) {
                    count--;//수량 -
                    cnt.setText(count+"");//수량라벨에 표시
                }}});

        //+버튼
        plusbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(0<=count) {
                    count++;//수량 +
                    cnt.setText(count+"");//수량라벨에 표시
                }}});

        add(minusbutton);
        add(cnt);
        add(plusbutton);
        add(okbutton);
        setSize(320, 250);
        setLocation(500,500);
        setResizable(false);
    }

    //콤보 수량 체크 다이얼로그
    public MenuOption(JFrame frame, String name, String price) {
        setTitle(name);
        setLayout(null);
        minusbutton.setBounds(142,30,60,60);//-버튼 위치,크기
        plusbutton.setBounds(282,30,60,60);//+버튼 위치,크기
        cnt.setBounds(242,30,60,60);//수랑 라벨 위치,크기
        okbutton.setBounds(170,300,160,40);//확인 버튼  위치,크기
        garlicpopcorn.setBounds(42,130,80,60);//갈릭 버튼 위치,크기
        caramelpopcorn.setBounds(152,130,80,60);//카라멜 버튼 위치,크기
        coke.setBounds(42,215,80,60);//콜라 버튼 위치,크기
        cidar.setBounds(152,215,80,60);//사이다 버튼 위치,크기
        tea.setBounds(262,215,80,60);//허브티 버튼 위치,크기
        coffee.setBounds(372,215,80,60);//오늘의 커피 버튼 위치,크기
        setVisible(false);//다이얼로그가 보이지 않게 설정

        //-버튼
        minusbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(0<count) {
                    count--;//수량 -
                    cnt.setText(count+"");//수량라벨에 표시
                }}});

        //+버튼
        plusbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(0<=count) {
                    count++;//수량 +
                    cnt.setText(count+"");//수량라벨에 표시
                }}});
        //갈릭
        garlicpopcorn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                garlicpopcorn.setBackground(Color.GRAY);
            }});
        //카라멜
        caramelpopcorn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                caramelpopcorn.setBackground(Color.GRAY);
            }});
        //콜라
        coke.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                coke.setBackground(Color.GRAY);
            }});
        //사이다
        cidar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cidar.setBackground(Color.GRAY);
            }});
        //허브티
        tea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tea.setBackground(Color.GRAY);
            }});
        //오늘의커피
        coffee.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                coffee.setBackground(Color.GRAY);
            }});

        add(minusbutton);
        add(cnt);
        add(plusbutton);
        add(okbutton);
        add(garlicpopcorn);
        add(caramelpopcorn);
        add(coke);
        add(cidar);
        add(tea);
        add(coffee);
        setSize(500, 400);
        setLocation(500,500);
        setResizable(false);
    }

    //영수증
    JLabel detail = new JLabel("주문 내역");
    String []head_re = {"제품명", "수량", "가격"};//영수증 테이블 헤더
    String [][]data_re= {};//영수증 데이터
    public DefaultTableModel model_re = new DefaultTableModel(data_re,head_re);//테이블 모델 생성
    public JTable busket_re = new JTable(model_re);//장바구니 테이블 객체 생성

    JLabel pay_re= new JLabel("결제 금액:");//영수증 결제 금액
    public JLabel paytext_re = new JLabel("0원");//금액 표시 라벨

    JLabel requestlabel= new JLabel("요청 사항");//영수증 요청사항
    public JTextArea requesttext = new JTextArea();//요청사항 적는 부분

    public JButton okbutton_re=new JButton("확인");//확인 버튼

    //영수증 다이얼로그
    public MenuOption(JFrame frame, String name) {
        super(frame,name);
        setLayout(null);

        detail.setBounds(150,40,200,45);//주문 내역 라벨 위치,크기
        detail.setFont(new Font("맑은 고딕",Font.BOLD,40));//폰트
        add(detail);//영수증 다이얼로그에 주문완료 라벨 삽입

        JScrollPane scroll_busket_re=new JScrollPane(busket_re);//영수증 스크롤
        scroll_busket_re.setBounds(50,100,400,300);//스크롤 위치,크기
        add(scroll_busket_re);

        pay_re.setBounds(50,600,200,50);//결제 금액 라벨 위치,크기
        pay_re.setFont(new Font("맑은 고딕",Font.BOLD,35));// 폰트
        add(pay_re);

        paytext_re.setBounds(250,600,200,50);//결제 금액이 적힐 라벨 위치,크기
        paytext_re.setFont(new Font("맑은 고딕",Font.BOLD,35));// 폰트
        add(paytext_re);

        requestlabel.setBounds(50,415,400,25);//요청 사항 라벨 위치,크기
        add(requestlabel);

        requesttext.setBounds(50,435,400,150);//요청사항  텍스트 위치,크기
        requesttext.setFont(new Font("맑은 고딕",Font.BOLD,25));//폰트
        add(requesttext);

        okbutton_re.setBounds(200,680,100,50);//확인 버튼
        add(okbutton_re);

        setSize(500, 800);
        setLocation(500,0);
        setVisible(false);

    }


    JLabel label = new JLabel("제품 선택해주세요.");//제품 선택 라벨
    public JButton button = new JButton("확인");//확인 버튼
    public MenuOption(JFrame frame) {
        super(frame,"제품 선택");
        setLayout(null);
        label.setBounds(0,0,500,100);  //제품 선택 라벨 위치,크기
        label.setFont(new Font("맑은 고딕",Font.BOLD,35));//폰트       
        button.setBounds(200,100,100,50);
        add(label);
        add(button);

        setSize(500,200);
        setLocation(500,400);
        setVisible(false);
    }


    public JButton button1 = new JButton("확인");//확인 버튼
    public MenuOption() { //현금 결제
        setTitle("현금 결제");
        setLayout(null);
        JLabel c = new JLabel("현금결제는  카운터에서 가능합니다."); //현금 결제 라벨
        c.setBounds(0,0,500,100);//현금 결제 라벨 위치, 크기
        c.setFont(new Font("맑은 고딕",Font.BOLD,25));//폰트
        button1.setBounds(150,100,100,50);
        add(c);
        add(button1);

        setSize(425,250);
        setLocation(500,400);
        setVisible(false);
    }

    public JTextField phonetext = new JTextField(20);
    public JButton savingbutton = new JButton("확인");//확인 버튼
    public MenuOption(String name) {	 //포인트 적립
        setTitle("메가박스 포인트 적립");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(new JLabel("전화번호를 입력한 후 확인버튼을 눌러주세요")); //포인트 적립 라벨
        c.add(new JLabel("적립을 원하시지 않으면 확인버튼을 눌러주세요"));
        c.add(phonetext);
        c.add(savingbutton);
        savingbutton.setBounds(150,180,100,50);

        setSize(300,200);
        setLocation(500,400);
        setVisible(false);
    }

}