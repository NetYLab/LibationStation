import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//JFrame을 상속받아 클래스 만들기
public class Main extends JFrame {

    Picture picture;// 상단 사진

    JTabbedPane pane; // 메뉴 탭팬 레퍼런스
    MenuPanel combomenu;// 콤보 패널 레퍼런스
    MenuPanel drinkmenu;// 음료 패널 레퍼런스
    MenuPanel popcornmenu;// 팝콘 패널 레퍼런스
    MenuPanel sidemenu;// 사이드 패널 레퍼런스
    Request request;

    MenuOption[] combo = new MenuOption[6];// 콤보 메뉴 다이얼로그
    MenuOption[] drink = new MenuOption[5];// 음료 메뉴 다이얼로그
    MenuOption[] popcorn = new MenuOption[3];// 팝콘 메뉴 다이얼로그
    MenuOption[] side = new MenuOption[5];// 사이드 메뉴 다이얼로그

    MenuOption receipt;// 영수증 다이얼로그
    MenuOption nocheck_re;// 제품을 선택하지 않았을 때 다이얼로그
    MenuOption payment; // 현금 결제 다이얼로그
    MenuOption text; // 포인트 적립 다이얼로그

    public Main() {
        setTitle("MegaBOsk");// frame 타이틀 제목
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 프레임 윈도우를 닫으면 프로그램을 종료하도록 설정
        Container c = getContentPane();// 컨텐트 팬
        c.setLayout(null);
        c.setBackground(Color.WHITE);// 컨텐트 팬의 배경색 흰색

        // 위
        picture = new Picture();// Picture 객체를 생성
        picture.setBounds(0, 0, 150, 50);// picture의 위치,크기
        c.add(picture);// picture을 컨텐트 팬에 삽입

        // 중간
        pane = new JTabbedPane();
        pane.setBackground(new Color(178, 178, 178));// 탭팬 배경색
        pane.setBounds(0, 50, 1050, 500);// 탭팬의 위치, 크기

        combomenu = new MenuPanel(6, "comboname", "comboprice");
        combomenu.setPreferredSize(new Dimension(2000, 3000));// 콤보 메뉴 패널 크기
        pane.add("콤보", new JScrollPane(combomenu));// 콤보 메뉴 패널을 스크롤패널에 넣고 탭팬에 삽입

        drinkmenu = new MenuPanel(5, "drinkname", "drinkprice");
        drinkmenu.setPreferredSize(new Dimension(2000, 3000));// 음료 메뉴 패널 크기
        pane.add("음료", new JScrollPane(drinkmenu));// 음료 메뉴 패널을 스크롤패널에 넣은다음 탭팬에 삽입

        popcornmenu = new MenuPanel(3, "popcornname", "popcornprice");
        popcornmenu.setPreferredSize(new Dimension(2000, 3000));// 팝콘 메뉴 패널 크기
        pane.add("팝콘", new JScrollPane(popcornmenu));// 팝콘 메뉴 패널을 스크롤패널에 넣은다음 탭팬에 삽입

        sidemenu = new MenuPanel(5, "sidename", "sideprice");
        sidemenu.setPreferredSize(new Dimension(1050, 700));// 사이드 메뉴 패널 크기
        pane.add("사이드", new JScrollPane(sidemenu));// 사이드 메뉴 패널을 스크롤패널에 넣은다음 탭팬에 삽입
        c.add(pane);

        // 아래
        request = new Request();// Bottom 객체 생성
        request.setBounds(0, 550, 1050, 250);// bottompanel 위치,크기
        c.add(request);// 삽입

        // 수량 다이얼로그
        for (int i = 0; i < 6; i++) { // 콤보
            int j = i;
            combo[j] = new MenuOption(this, combomenu.name[j], combomenu.price[j]);// 콤보 수 다이얼로그 객체
            combomenu.productbutton[j].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    combo[j].setVisible(true);
                }
            });
            combo[j].okbutton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (combo[j].count != 0) { // 수량이 0이 아니면
                        String[] info = { combomenu.name[j], Integer.toString(combo[j].count),
                                Integer.toString(Integer.parseInt(combomenu.price[j]) * combo[j].count) };
                        request.table.addRow(info);// 테이블에 내용 출력
                        request.allprice = request.allprice
                                + Integer.parseInt(combomenu.price[j]) * combo[j].count;// 제품 금액*수량
                        request.paysum.setText(Integer.toString(request.allprice) + "원");// 제품 금액*수량
                        combo[j].count = 1;// 수량 초기화
                        combo[j].cnt.setText(Integer.toString(combo[j].count));// 초기화된 수량 표시
                    }
                    combo[j].setVisible(false);
                }
            });
        }

        for (int i = 0; i < 5; i++) { // 음료
            int j = i;
            drink[j] = new MenuOption(drinkmenu.name[j], drinkmenu.price[j]);// 음료 수 다이얼로그 객체 생성
            drinkmenu.productbutton[j].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    drink[j].setVisible(true);
                }
            });
            drink[j].okbutton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (drink[j].count != 0) { // 수량이 0이 아니면
                        String[] info = { drinkmenu.name[j], Integer.toString(drink[j].count),
                                Integer.toString(Integer.parseInt(drinkmenu.price[j]) * drink[j].count) };
                        request.table.addRow(info);// 테이블에 내용 출력
                        request.allprice = request.allprice
                                + Integer.parseInt(drinkmenu.price[j]) * drink[j].count;// 금액*수량
                        request.paysum.setText(Integer.toString(request.allprice) + "원");// 금액*수량 출력
                        drink[j].count = 1;// 수량 초기화
                        drink[j].cnt.setText(Integer.toString(drink[j].count));// 초기화된 수량 표시
                    }
                    drink[j].setVisible(false);
                }
            });
        }

        for (int i = 0; i < 3; i++) { // 팝콘
            int j = i;
            popcorn[j] = new MenuOption(popcornmenu.name[j], popcornmenu.price[j]);// 팝콘 수 다이얼로그 객체 생성
            popcornmenu.productbutton[j].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    popcorn[j].setVisible(true);
                }
            });
            popcorn[j].okbutton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (popcorn[j].count != 0) { // 수량이 0이 아니면
                        String[] info = { popcornmenu.name[j], Integer.toString(popcorn[j].count),
                                Integer.toString(Integer.parseInt(popcornmenu.price[j]) * popcorn[j].count) };
                        request.table.addRow(info);// 테이블에 내용 출력
                        request.allprice = request.allprice
                                + Integer.parseInt(popcornmenu.price[j]) * popcorn[j].count;// 금액*수량
                        request.paysum.setText(Integer.toString(request.allprice) + "원");// 금액*수량 출력
                        popcorn[j].count = 1;// 수량 초기화
                        popcorn[j].cnt.setText(Integer.toString(popcorn[j].count));// 초기화된 수량 표시
                    }
                    popcorn[j].setVisible(false);
                }
            });
        }
        for (int i = 0; i < 5; i++) { // 사이드
            int j = i;
            side[j] = new MenuOption(sidemenu.name[j], sidemenu.price[j]);// 사이드 수 다이얼로그 객체 생성
            sidemenu.productbutton[j].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    side[j].setVisible(true);
                }
            });
            side[j].okbutton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // 수량이 0이 아닐 때
                    if (side[j].count != 0) {
                        String[] info = { sidemenu.name[j], Integer.toString(side[j].count),
                                Integer.toString(Integer.parseInt(sidemenu.price[j]) * side[j].count) };
                        request.table.addRow(info);// 테이블에 내용 출력
                        request.allprice = request.allprice
                                + Integer.parseInt(sidemenu.price[j]) * side[j].count;// 금액*수량
                        request.paysum.setText(Integer.toString(request.allprice) + "원");// 금액*수량 출력
                        side[j].count = 1;// 수량 초기화
                        side[j].cnt.setText(Integer.toString(side[j].count));// 초기화된 수량 표시
                    }
                    side[j].setVisible(false);// 다이얼로그 보이지않게 설정
                }
            });
        }

        receipt = new MenuOption(new JFrame(), "영수증");// 영수증 다이얼로그 객체
        nocheck_re = new MenuOption(new JFrame());// 제품을 선택하지 않았을 때 다이얼로그
        payment = new MenuOption(); // 현금 결제 다이얼로그
        text = new MenuOption("포인트"); // 포인트 적립 다이얼로그

        request.menudelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 제품을 선택하지 않았을 때
                if (request.cart.getSelectedRow() == -1) {
                    return;
                }
                // 제품을 선택했을 때
                else {
                    Object value = request.cart.getValueAt(request.cart.getSelectedRow(), 2);// 테이블에서 선택된 줄의
                    // 가격 불러오기
                    request.allprice = request.allprice - Integer.parseInt(value.toString());// 불러온 가격을 총 금액에 뺌
                    request.paysum.setText(Integer.toString(request.allprice) + "원");// 총 금액을 라벨에 넣기
                    request.table.removeRow(request.cart.getSelectedRow());// 선택된 줄 메뉴를 삭제
                }
            }
        });

        request.order.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 제품을 선택하지 않았을 때
                if (request.allprice == 0) {
                    nocheck_re.setVisible(true);
                } // 선택된 제이 없을 때 nocheck_re 표시
                // 제품을 선택했을 때
                else {
                    receipt.setVisible(true);// receipt 다이얼로그 표시
                    for (int i = 0; i < request.cart.getRowCount(); i++) {
                        receipt.model_re.addRow(new Object[] { request.cart.getValueAt(i, 0),
                                request.cart.getValueAt(i, 1), request.cart.getValueAt(i, 2) });// 장바구니 테이블
                        // 내용을 영수증
                        // 테이블에 옮김
                        receipt.paytext_re.setText(Integer.toString(request.allprice) + "원");// 영수증에 총금액 표시
                        receipt.requesttext.setText(request.request_write.getText());// 요청사항 텍스트의 내용을 영수증에 가져옴
                    }
                }
            }
        });

        request.cancel.addActionListener(new ActionListener() { // 주문 취소버튼
            // 장바구니 테이블, 금액, 요청사항 초기화
            public void actionPerformed(ActionEvent e) {
                request.table.setNumRows(0);
                request.allprice = 0;
                request.request_write.setText(null);
                request.paysum.setText(Integer.toString(request.allprice) + "원");
            }
        });

        request.choice_pay1.addActionListener(new ActionListener() { // 카드 결제 버튼
            public void actionPerformed(ActionEvent e) {
                request.choice_pay1.setBackground(Color.GRAY); // 선택하면 색을 GRAY로 바꿈
            }
        });

        request.choice_pay2.addActionListener(new ActionListener() { // 현금 결제 버튼
            public void actionPerformed(ActionEvent e) {
                payment.setVisible(true);
            }
        });

        text.savingbutton.addActionListener(new ActionListener() { // button2 버튼
            public void actionPerformed(ActionEvent e) {
                // 포인트 적립까지 끝냈으면 다 초기화한다.
                request.table.setNumRows(0);
                receipt.model_re.setNumRows(0);
                request.allprice = 0;
                request.request_write.setText(null);
                receipt.requesttext.setText(null);
                request.paysum.setText(Integer.toString(request.allprice) + "원");
                receipt.paytext_re.setText(Integer.toString(request.allprice) + "원");
                text.phonetext.setText(null);
                receipt.setVisible(false);
                text.setVisible(false);
            }
        });

        receipt.okbutton_re.addActionListener(new ActionListener() { // 영수증 확인 버튼을 누르면
            public void actionPerformed(ActionEvent e) {
                text.setVisible(true); // 포인트 창 보이도록
            }
        });

        nocheck_re.button.addActionListener(new ActionListener() { // 제품을 선택하지 않았을 때 주문 버튼을 누르면
            public void actionPerformed(ActionEvent e) {
                // 요청사항 초기화
                request.request_write.setText(null);
                receipt.requesttext.setText(null);
                nocheck_re.setVisible(false);
            }
        });

        payment.button1.addActionListener(new ActionListener() { // 현금결제 창이 뜨고 확인 버튼을 누르면
            public void actionPerformed(ActionEvent e) {
                payment.setVisible(false); // 창 닫기(안 보이도록)
            }
        });

        setSize(1070, 900);// 프레임의 크기
        setVisible(true);// 프레임 보이게
        setResizable(false);// 프레임 창을 최대화하지 못하게 설정
    }

    public static void main(String[] args) {
        new Main();
    }
}