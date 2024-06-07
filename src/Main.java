import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {

    Picture picture;// 상단 사진

    JTabbedPane pane; // 메뉴 탭팬 레퍼런스
    MenuPanel rumMenu;// 럼 패널 레퍼런스
    MenuPanel whiskyMenu;// 위스키 패널 레퍼런스
    MenuPanel vodkaMenu;// 보드카 패널 레퍼런스
    MenuPanel tequilaMenu;// 데킬라 패널 레퍼런스
    Request request;

    MenuOption[] rum = new MenuOption[6];// 럼 메뉴 다이얼로그
    MenuOption[] whisky = new MenuOption[5];// 위스키 메뉴 다이얼로그
    MenuOption[] vodka = new MenuOption[3];// 보드카 메뉴 다이얼로그
    MenuOption[] tequila = new MenuOption[5];// 데킬라 메뉴 다이얼로그

    MenuOption receipt;// 영수증 다이얼로그
    MenuOption nocheck;// 제품을 선택하지 않았을 때 다이얼로그
    MenuOption payment; // 현금 결제 다이얼로그
    MenuOption qr;
    MenuOption text; // 포인트 적립 다이얼로그

    public Main() {
        setTitle("LibationStation");// frame 타이틀 제목
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

        rumMenu = new MenuPanel(6, "rumname", "rumprice");
        rumMenu.setPreferredSize(new Dimension(3000, 4000));// 콤보 메뉴 패널 크기
        pane.add("럼", new JScrollPane(rumMenu));// 럼 메뉴 패널을 스크롤패널에 넣고 탭팬에 삽입

        whiskyMenu = new MenuPanel(5, "whiskyname", "whiskyprice");
        whiskyMenu.setPreferredSize(new Dimension(3000, 4000));// 위스키 메뉴 패널 크기
        pane.add("위스키", new JScrollPane(whiskyMenu));// 위스키 메뉴 패널을 스크롤패널에 넣은다음 탭팬에 삽입

        vodkaMenu = new MenuPanel(3, "vodkaname", "vodkaprice");
        vodkaMenu.setPreferredSize(new Dimension(3000, 4000));// 보드카 메뉴 패널 크기
        pane.add("보드카", new JScrollPane(vodkaMenu));// 보드카 메뉴 패널을 스크롤패널에 넣은다음 탭팬에 삽입

        tequilaMenu = new MenuPanel(5, "sidename", "sideprice");
        tequilaMenu.setPreferredSize(new Dimension(3000, 4000));// 데킬라 메뉴 패널 크기
        pane.add("데킬라", new JScrollPane(tequilaMenu));// 데킬라 메뉴 패널을 스크롤패널에 넣은다음 탭팬에 삽입
        c.add(pane);

        // 아래
        request = new Request();// Bottom 객체 생성
        request.setBounds(0, 550, 1050, 250);// bottompanel 위치,크기
        c.add(request);// 삽입

        // 수량 다이얼로그
        for (int i = 0; i < 6; i++) { // 럼
            int j = i;
            rum[j] = new MenuOption(rumMenu.name[j], rumMenu.price[j]);// 럼 수 다이얼로그 객체
            rumMenu.productButton[j].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    rum[j].setVisible(true);
                }
            });
            rum[j].okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (rum[j].count != 0) { // 수량이 0이 아니면
                        String[] info = { rumMenu.name[j], Integer.toString(rum[j].count),
                                Integer.toString(Integer.parseInt(rumMenu.price[j]) * rum[j].count) };
                        request.table.addRow(info);// 테이블에 내용 출력
                        request.allPrice = request.allPrice
                                + Integer.parseInt(rumMenu.price[j]) * rum[j].count;// 제품 금액*수량
                        request.paySum.setText(Integer.toString(request.allPrice) + "원");// 제품 금액*수량
                        rum[j].count = 1;// 수량 초기화
                        rum[j].countLabel.setText(Integer.toString(rum[j].count));// 초기화된 수량 표시
                    }
                    rum[j].setVisible(false);
                }
            });
        }

        for (int i = 0; i < 5; i++) { // 위스키
            int j = i;
            whisky[j] = new MenuOption(whiskyMenu.name[j], whiskyMenu.price[j]);// 위스키 수 다이얼로그 객체 생성
            whiskyMenu.productButton[j].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    whisky[j].setVisible(true);
                }
            });
            whisky[j].okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (whisky[j].count != 0) { // 수량이 0이 아니면
                        String[] info = { whiskyMenu.name[j], Integer.toString(whisky[j].count),
                                Integer.toString(Integer.parseInt(whiskyMenu.price[j]) * whisky[j].count) };
                        request.table.addRow(info);// 테이블에 내용 출력
                        request.allPrice = request.allPrice
                                + Integer.parseInt(whiskyMenu.price[j]) * whisky[j].count;// 금액*수량
                        request.paySum.setText(Integer.toString(request.allPrice) + "원");// 금액*수량 출력
                        whisky[j].count = 1;// 수량 초기화
                        whisky[j].countLabel.setText(Integer.toString(whisky[j].count));// 초기화된 수량 표시
                    }
                    whisky[j].setVisible(false);
                }
            });
        }

        for (int i = 0; i < 3; i++) { // 보드카
            int j = i;
            vodka[j] = new MenuOption(vodkaMenu.name[j], vodkaMenu.price[j]);// 보드카 수 다이얼로그 객체 생성
            vodkaMenu.productButton[j].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    vodka[j].setVisible(true);
                }
            });
            vodka[j].okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (vodka[j].count != 0) { // 수량이 0이 아니면
                        String[] info = { vodkaMenu.name[j], Integer.toString(vodka[j].count),
                                Integer.toString(Integer.parseInt(vodkaMenu.price[j]) * vodka[j].count) };
                        request.table.addRow(info);// 테이블에 내용 출력
                        request.allPrice = request.allPrice
                                + Integer.parseInt(vodkaMenu.price[j]) * vodka[j].count;// 금액*수량
                        request.paySum.setText(Integer.toString(request.allPrice) + "원");// 금액*수량 출력
                        vodka[j].count = 1;// 수량 초기화
                        vodka[j].countLabel.setText(Integer.toString(vodka[j].count));// 초기화된 수량 표시
                    }
                    vodka[j].setVisible(false);
                }
            });
        }
        for (int i = 0; i < 5; i++) { // 데킬라
            int j = i;
            tequila[j] = new MenuOption(tequilaMenu.name[j], tequilaMenu.price[j]);// 데킬라 수 다이얼로그 객체 생성
            tequilaMenu.productButton[j].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    tequila[j].setVisible(true);
                }
            });
            tequila[j].okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // 수량이 0이 아닐 때
                    if (tequila[j].count != 0) {
                        String[] info = { tequilaMenu.name[j], Integer.toString(tequila[j].count),
                                Integer.toString(Integer.parseInt(tequilaMenu.price[j]) * tequila[j].count) };
                        request.table.addRow(info);// 테이블에 내용 출력
                        request.allPrice = request.allPrice
                                + Integer.parseInt(tequilaMenu.price[j]) * tequila[j].count;// 금액*수량
                        request.paySum.setText(Integer.toString(request.allPrice) + "원");// 금액*수량 출력
                        tequila[j].count = 1;// 수량 초기화
                        tequila[j].countLabel.setText(Integer.toString(tequila[j].count));// 초기화된 수량 표시
                    }
                    tequila[j].setVisible(false);// 다이얼로그 보이지않게 설정
                }
            });
        }

        receipt = new MenuOption(new JFrame(), "영수증");// 영수증 다이얼로그 객체
        nocheck = new MenuOption(new JFrame());// 제품을 선택하지 않았을 때 다이얼로그
        qr = new MenuOption(1); // Initialize QR payment dialog
        payment = new MenuOption(); // 현금 결제 다이얼로그
        text = new MenuOption("포인트"); // 포인트 적립 다이얼로그

        request.menuDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 제품을 선택하지 않았을 때
                if (request.cart.getSelectedRow() == -1) {
                    return;
                }
                // 제품을 선택했을 때
                else {
                    Object value = request.cart.getValueAt(request.cart.getSelectedRow(), 2);// 테이블에서 선택된 줄의
                    // 가격 불러오기
                    request.allPrice = request.allPrice - Integer.parseInt(value.toString());// 불러온 가격을 총 금액에 뺌
                    request.paySum.setText(Integer.toString(request.allPrice) + "원");// 총 금액을 라벨에 넣기
                    request.table.removeRow(request.cart.getSelectedRow());// 선택된 줄 메뉴를 삭제
                }
            }
        });

        request.order.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 제품을 선택하지 않았을 때
                if (request.allPrice == 0) {
                    nocheck.setVisible(true);
                } // 선택된 제이 없을 때 nocheck_re 표시
                // 제품을 선택했을 때
                else {
                    receipt.setVisible(true);// receipt 다이얼로그 표시
                    for (int i = 0; i < request.cart.getRowCount(); i++) {
                        receipt.model.addRow(new Object[] { request.cart.getValueAt(i, 0),
                                request.cart.getValueAt(i, 1), request.cart.getValueAt(i, 2) });// 장바구니 테이블
                        // 내용을 영수증
                        // 테이블에 옮김
                        receipt.payText.setText(Integer.toString(request.allPrice) + "원");// 영수증에 총금액 표시
                        receipt.requestText.setText(request.requestWrite.getText());// 요청사항 텍스트의 내용을 영수증에 가져옴
                    }
                }
            }
        });

        request.cancel.addActionListener(new ActionListener() { // 주문 취소버튼
            // 장바구니 테이블, 금액, 요청사항 초기화
            public void actionPerformed(ActionEvent e) {
                request.table.setNumRows(0);
                request.allPrice = 0;
                request.requestWrite.setText(null);
                request.paySum.setText(Integer.toString(request.allPrice) + "원");
            }
        });

        request.choicePay1.addActionListener(new ActionListener() { // 카드 결제 버튼
            public void actionPerformed(ActionEvent e) {
                qr.setVisible(true); // Show QR payment dialog
            }
        });

        request.choicePay2.addActionListener(new ActionListener() { // 현금 결제 버튼
            public void actionPerformed(ActionEvent e) {
                payment.setVisible(true);
            }
        });

        text.savingButton.addActionListener(new ActionListener() { // button2 버튼
            public void actionPerformed(ActionEvent e) {
                // 포인트 적립까지 끝냈으면 다 초기화한다.
                request.table.setNumRows(0);
                receipt.model.setNumRows(0);
                request.allPrice = 0;
                request.requestWrite.setText(null);
                receipt.requestText.setText(null);
                request.paySum.setText(Integer.toString(request.allPrice) + "원");
                receipt.payText.setText(Integer.toString(request.allPrice) + "원");
                text.phoneNumText.setText(null);
                receipt.setVisible(false);
                text.setVisible(false);
            }
        });

        receipt.okButton.addActionListener(new ActionListener() { // 영수증 확인 버튼을 누르면
            public void actionPerformed(ActionEvent e) {
                text.setVisible(true); // 포인트 창 보이도록
            }
        });

        nocheck.button.addActionListener(new ActionListener() { // 제품을 선택하지 않았을 때 주문 버튼을 누르면
            public void actionPerformed(ActionEvent e) {
                // 요청사항 초기화
                request.requestWrite.setText(null);
                receipt.requestText.setText(null);
                nocheck.setVisible(false);
            }
        });
        payment.button2.addActionListener(new ActionListener() { // 현금결제 창이 뜨고 확인 버튼을 누르면
            public void actionPerformed(ActionEvent e) {
                payment.setVisible(false); // 창 닫기(안 보이도록)
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
