import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MenuOption extends JDialog {

    // 수량체크 다이얼로그
    public int count=1;// 수량
    public JLabel countLabel = new JLabel(count+""); // 수량 표시될 수량 라벨 버튼
    public JButton okButton = new JButton("확인"); // 확인 버튼
    JButton minusButton = new JButton("-"); // -버튼
    JButton plusButton = new JButton("+"); // +버튼

    /*--- 수량 체크 다이얼로그 ---*/
    public MenuOption(String name, String price) {
        setTitle(name);
        setLayout(null);
        minusButton.setBounds(50,30,60,60); // -버튼 위치,크기
        plusButton.setBounds(200,30,60,60); // +버튼 위치,크기
        countLabel.setBounds(150,30,60,60); // 수랑 라벨 위치,크기
        okButton.setBounds(75,120,160,40);  // 확인 버튼 위치,크기
        setVisible(false);

        /*--- -버튼 ---*/
        minusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(0<count) {
                    count--; // 수량 -1
                    countLabel.setText(count+""); // 수량 라벨에 표시
                }}});

        /*--- +버튼 ---*/
        plusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(0<=count) {
                    count++; // 수량 +1
                    countLabel.setText(count+""); // 수량 라벨에 표시
                }}});

        add(minusButton);
        add(countLabel);
        add(plusButton);
        add(okButton);
        setSize(320, 250);
        setLocation(500,500);
        setResizable(false);
    }

    /*--- 영수증 ---*/
    JLabel detail = new JLabel("주문 내역");
    String [] header = {"제품명", "수량", "가격"}; // 영수증 테이블 헤더
    String [][] data = {}; // 영수증 데이터
    public DefaultTableModel model = new DefaultTableModel(data, header); // 테이블 모델 생성
    public JTable busket = new JTable(model); // 장바구니 테이블

    JLabel pay = new JLabel("결제 금액:"); // 영수증 결제 금액
    public JLabel payText = new JLabel("0원"); // 금액 표시 라벨

    JLabel requestLabel = new JLabel("요청 사항"); // 영수증 요청사항
    public JTextArea requestText = new JTextArea(); // 요청 사항 적은 JTextArea

    /*--- 영수증 다이얼로그 ---*/
    public MenuOption(JFrame frame, String name) {
        super(frame,name);
        setLayout(null);

        detail.setBounds(150,40,200,45);
        detail.setFont(new Font("맑은 고딕",Font.BOLD,40));
        add(detail);

        JScrollPane scroll_busket_re=new JScrollPane(busket);
        scroll_busket_re.setBounds(50,100,400,300);
        add(scroll_busket_re);

        pay.setBounds(50,600,200,50);
        pay.setFont(new Font("맑은 고딕",Font.BOLD,35));
        add(pay);

        payText.setBounds(250,600,200,50);
        payText.setFont(new Font("맑은 고딕",Font.BOLD,35));
        add(payText);

        requestLabel.setBounds(50,415,400,25);
        add(requestLabel);

        requestText.setBounds(50,435,400,150);
        requestText.setFont(new Font("맑은 고딕",Font.BOLD,25));
        add(requestText);

        okButton.setBounds(200,680,100,50);
        add(okButton);

        setSize(500, 800);
        setLocation(500,0);
        setVisible(false);

    }


    JLabel label = new JLabel("제품 선택해주세요."); // 장바구니가 빈 상황에 주문 버튼을 눌렀을 때 나올 라벨
    public JButton button = new JButton("확인"); // 확인 버튼
    public MenuOption(JFrame frame) {
        super(frame,"제품 선택");
        setLayout(null);
        label.setBounds(0,0,500,100);
        label.setFont(new Font("맑은 고딕",Font.BOLD,35));
        button.setBounds(200,100,100,50);
        add(label);
        add(button);

        setSize(500,200);
        setLocation(500,400);
        setVisible(false);
    }

    public JButton button2 = new JButton("확인");

    /*--- QR 결제 ---*/
    public MenuOption(int n) {
        setTitle("QR 결제");
        setLayout(new BorderLayout());
        setSize(300, 300);
        setLocationRelativeTo(null);

        ImageIcon qrIcon = new ImageIcon("image/QR.png");
        JLabel qrLabel = new JLabel(qrIcon);
        add(qrLabel, BorderLayout.CENTER);

        JButton closeBtn = new JButton("Close");
        closeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        add(closeBtn, BorderLayout.SOUTH);
    }


    public JButton button1 = new JButton("확인");

    /*--- 현금 결제 ---*/
    public MenuOption() {
        setTitle("현금 결제");
        setLayout(null);
        JLabel c = new JLabel("현금결제는  카운터에서 가능합니다.");
        c.setBounds(0,0,500,100);
        c.setFont(new Font("맑은 고딕",Font.BOLD,25));
        button1.setBounds(150,100,100,50);
        add(c);
        add(button1);

        setSize(425,250);
        setLocation(500,400);
        setVisible(false);
    }

    public JTextField phoneNumText = new JTextField(20);
    public JButton savingButton = new JButton("확인");// 확인 버튼
        /*--- 포인트 적림 ---*/
        public MenuOption(String name) {
        setTitle("LibationStation 포인트 적립");
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        c.add(new JLabel("전화번호를 입력한 후 확인버튼을 눌러주세요"));
        c.add(new JLabel("적립을 원하시지 않으면 확인버튼을 눌러주세요"));
        c.add(phoneNumText);
        c.add(savingButton);
        savingButton.setBounds(150,180,100,50);

        setSize(300,200);
        setLocation(500,400);
        setVisible(false);
    }

}
