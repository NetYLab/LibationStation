import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame {

    Picture picture; // 상단 사진

    JTabbedPane pane; // 메뉴 탭팬
    MenuPanel rumMenu; // 럼 패널
    MenuPanel whiskyMenu; // 위스키 패널
    MenuPanel vodkaMenu; // 보드카 패널
    MenuPanel tequilaMenu; // 데킬라 패널
    Request request;

    MenuOption[] rum = new MenuOption[6]; // 럼 메뉴 6가지
    MenuOption[] whisky = new MenuOption[5]; // 위스키 메뉴 5가지
    MenuOption[] vodka = new MenuOption[3]; // 보드카 메뉴 3가지
    MenuOption[] tequila = new MenuOption[5]; // 데킬라 메뉴 5가지

    MenuOption receipt; // 영수증
    MenuOption noCheck; //장바구니가 빈 상황 다이얼로그
    MenuOption payment; // 현금 결제
    MenuOption qr; // QR결제
    MenuOption pointSave; // 포인트 적립

    public Main() {
        setTitle("LibationStation"); // main frame 제목
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 화면 닫으면 프로그램 종료하도록 설정
        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);

        /*--- 상단에 로고 생성 ---*/
        picture = new Picture();
        picture.setBounds(0, 0, 150, 50);
        c.add(picture);

        /*--- 주류 선택 탭 ---*/
        pane = new JTabbedPane();
        pane.setBackground(new Color(178, 178, 178));
        pane.setBounds(0, 50, 1050, 500);

        /*--- 럼 메뉴 창을 만든다 ---*/
        rumMenu = new MenuPanel(6, "rumname", "rumprice");
        rumMenu.setPreferredSize(new Dimension(3000, 4000));
        pane.add("럼", new JScrollPane(rumMenu));

        /*--- 위스키 메뉴 창을 만든다 ---*/
        whiskyMenu = new MenuPanel(5, "whiskyname", "whiskyprice");
        whiskyMenu.setPreferredSize(new Dimension(3000, 4000));
        pane.add("위스키", new JScrollPane(whiskyMenu));

        /*--- 보드카 메뉴 창을 만든다 ---*/
        vodkaMenu = new MenuPanel(3, "vodkaname", "vodkaprice");
        vodkaMenu.setPreferredSize(new Dimension(3000, 4000));
        pane.add("보드카", new JScrollPane(vodkaMenu));

        /*--- 데킬라 메뉴 창을 만든다 ---*/
        tequilaMenu = new MenuPanel(5, "tequilaname", "tequilaprice");
        tequilaMenu.setPreferredSize(new Dimension(3000, 4000));
        pane.add("데킬라", new JScrollPane(tequilaMenu));
        c.add(pane);

        // 아래
        request = new Request();// Bottom 객체 생성
        request.setBounds(0, 550, 1050, 250);// bottompanel 위치,크기
        c.add(request);// 삽입

        /*--- 럼 메뉴 ---*/
        for (int i = 0; i < 6; i++) {
            int j = i;
            rum[j] = new MenuOption(rumMenu.name[j], rumMenu.price[j]);
            rumMenu.productButton[j].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    rum[j].setVisible(true);
                }
            });
            rum[j].okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (rum[j].count != 0) {
                        String[] info = { rumMenu.name[j], Integer.toString(rum[j].count),
                                Integer.toString(Integer.parseInt(rumMenu.price[j]) * rum[j].count) };
                        request.table.addRow(info); // 테이블에 내용 출력
                        request.allPrice = request.allPrice
                                + Integer.parseInt(rumMenu.price[j]) * rum[j].count; // 제품 금액 * 수량
                        request.paySum.setText(Integer.toString(request.allPrice) + "원"); // 제품 금액 * 수량 출력
                        rum[j].count = 1; // 수량 초기화
                        rum[j].countLabel.setText(Integer.toString(rum[j].count)); // 초기화된 수량 표시
                    }
                    rum[j].setVisible(false);
                }
            });
        }

        /*--- 위스키 메뉴 ---*/
        for (int i = 0; i < 5; i++) {
            int j = i;
            whisky[j] = new MenuOption(whiskyMenu.name[j], whiskyMenu.price[j]);
            whiskyMenu.productButton[j].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    whisky[j].setVisible(true);
                }
            });
            whisky[j].okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (whisky[j].count != 0) {
                        String[] info = { whiskyMenu.name[j], Integer.toString(whisky[j].count),
                                Integer.toString(Integer.parseInt(whiskyMenu.price[j]) * whisky[j].count) };
                        request.table.addRow(info); // 테이블에 내용 출력
                        request.allPrice = request.allPrice
                                + Integer.parseInt(whiskyMenu.price[j]) * whisky[j].count; // 제품 금액 * 수량
                        request.paySum.setText(Integer.toString(request.allPrice) + "원"); // 제품 금액 * 수량 출력
                        whisky[j].count = 1; // 수량 초기화
                        whisky[j].countLabel.setText(Integer.toString(whisky[j].count)); // 초기화된 수량 표시
                    }
                    whisky[j].setVisible(false);
                }
            });
        }

        /*--- 보드카 메뉴 ---*/
        for (int i = 0; i < 3; i++) {
            int j = i;
            vodka[j] = new MenuOption(vodkaMenu.name[j], vodkaMenu.price[j]);
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
                        request.table.addRow(info); // 테이블에 내용 출력
                        request.allPrice = request.allPrice
                                + Integer.parseInt(vodkaMenu.price[j]) * vodka[j].count; // 제품 금액 * 수량
                        request.paySum.setText(Integer.toString(request.allPrice) + "원");// 제품 금액 * 수량 출력
                        vodka[j].count = 1; // 수량 초기화
                        vodka[j].countLabel.setText(Integer.toString(vodka[j].count)); // 초기화된 수량 표시
                    }
                    vodka[j].setVisible(false);
                }
            });
        }

        /*--- 데킬라 메뉴 ---*/
        for (int i = 0; i < 5; i++) {
            int j = i;
            tequila[j] = new MenuOption(tequilaMenu.name[j], tequilaMenu.price[j]);
            tequilaMenu.productButton[j].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    tequila[j].setVisible(true);
                }
            });
            tequila[j].okButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    if (tequila[j].count != 0) {
                        String[] info = { tequilaMenu.name[j], Integer.toString(tequila[j].count),
                                Integer.toString(Integer.parseInt(tequilaMenu.price[j]) * tequila[j].count) };
                        request.table.addRow(info); // 테이블에 내용 출력
                        request.allPrice = request.allPrice
                                + Integer.parseInt(tequilaMenu.price[j]) * tequila[j].count; // 제품 금액 * 수량
                        request.paySum.setText(Integer.toString(request.allPrice) + "원"); // 제품 금액 * 수량 출력
                        tequila[j].count = 1; // 수량 초기화
                        tequila[j].countLabel.setText(Integer.toString(tequila[j].count)); // 초기화된 수량 표시
                    }
                    tequila[j].setVisible(false);
                }
            });
        }

        receipt = new MenuOption(new JFrame(), "영수증"); // 영수증 다이얼로그 객체
        noCheck = new MenuOption(new JFrame()); //장바구니가 빈 상황 다이얼로그
        qr = new MenuOption(1); // QR 결제 다이얼로그
        payment = new MenuOption(); // 현금 결제 다이얼로그
        pointSave = new MenuOption("포인트"); // 포인트 적립 다이얼로그

        request.menuDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (request.cart.getSelectedRow() == -1) { // 제품을 선택하지 않았을 때
                    return;
                }
                else { // 제품을 선택했을 때
                    Object value = request.cart.getValueAt(request.cart.getSelectedRow(), 2); // 테이블에서 선택된 줄의 가격 불러오기
                    request.allPrice = request.allPrice - Integer.parseInt(value.toString()); // 불러온 가격을 총 금액에 뺌
                    request.paySum.setText(Integer.toString(request.allPrice) + "원"); // 총 금액을 라벨에 넣기
                    request.table.removeRow(request.cart.getSelectedRow()); // 선택된 줄 메뉴를 삭제
                }
            }
        });

        request.order.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                if (request.allPrice == 0) { // 제품을 선택하지 않았을 때
                    noCheck.setVisible(true); // 선택된 제품이 없을 때 noCheck 표시
                }
                else { // 제품을 선택했을 때
                    receipt.setVisible(true); // receipt 다이얼로그 표시
                    for (int i = 0; i < request.cart.getRowCount(); i++) {
                        receipt.model.addRow(new Object[] { request.cart.getValueAt(i, 0),
                                request.cart.getValueAt(i, 1), request.cart.getValueAt(i, 2) });
                        receipt.payText.setText(Integer.toString(request.allPrice) + "원"); // 영수증에 총금액 표시
                        receipt.requestText.setText(request.requestWrite.getText()); // 요청사항 텍스트의 내용을 영수증에 가져옴
                    }
                }
            }
        });

        /*--- 주문 취소버튼 ---*/
        request.cancel.addActionListener(new ActionListener() { // 장바구니 테이블, 금액, 요청사항 초기화
            public void actionPerformed(ActionEvent e) {
                request.table.setNumRows(0);
                request.allPrice = 0;
                request.requestWrite.setText(null);
                request.paySum.setText(Integer.toString(request.allPrice) + "원");
            }
        });

        request.choicePay1.addActionListener(new ActionListener() { // QR 결제 버튼
            public void actionPerformed(ActionEvent e) {
                qr.setVisible(true); // QR 결제 다이얼로그 보임
            }
        });

        request.choicePay2.addActionListener(new ActionListener() { // 현금 결제 버튼
            public void actionPerformed(ActionEvent e) {
                payment.setVisible(true);
            }
        });

        pointSave.savingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                request.table.setNumRows(0);
                receipt.model.setNumRows(0);
                request.allPrice = 0;
                request.requestWrite.setText(null);
                receipt.requestText.setText(null);
                request.paySum.setText(Integer.toString(request.allPrice) + "원");
                receipt.payText.setText(Integer.toString(request.allPrice) + "원");
                pointSave.phoneNumText.setText(null);
                receipt.setVisible(false);
                pointSave.setVisible(false);
            }
        });

        receipt.okButton.addActionListener(new ActionListener() { // 영수증 확인 버튼을 누르면
            public void actionPerformed(ActionEvent e) {
                pointSave.setVisible(true); // 포인트 적립 창 보이도록
            }
        });

        noCheck.button.addActionListener(new ActionListener() { // 제품을 선택하지 않았을 때 주문 버튼을 누르면
            public void actionPerformed(ActionEvent e) {
                // 요청사항 초기화
                request.requestWrite.setText(null);
                receipt.requestText.setText(null);
                noCheck.setVisible(false);
            }
        });
        payment.button2.addActionListener(new ActionListener() { // 현금 결제 창이 뜨고 확인 버튼을 누르면
            public void actionPerformed(ActionEvent e) {
                payment.setVisible(false); // 창 닫기
            }
        });
        payment.button1.addActionListener(new ActionListener() { // 현금 결제 창이 뜨고 확인 버튼을 누르면
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
