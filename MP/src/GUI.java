import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI {
    private VendingMachine SpecialVendingMachine;
    private JMenuBar menubar;
    private JMenu menu;
    private JMenuItem display, collectMoney, insertMoney, select, replenishChange, setPrice, summary, displayBills, replenishItem;

    JFrame main = new JFrame("Vending Machine");

    public GUI(VendingMachine SpecialVendingMachine) {
        this.SpecialVendingMachine = SpecialVendingMachine;
        mainFrame();
    }


    public void mainFrame() {
        menubar = new JMenuBar();
        menu = new JMenu("Maintenance");
        display = new JMenuItem("Display available items");
        insertMoney = new JMenuItem("Insert Payment");
        select = new JMenuItem("Select slot and Dispense Item");
        replenishItem = new JMenuItem("Replenish Item Qty");
        setPrice = new JMenuItem("Set Item Price");
        summary = new JMenuItem("Print transaction summary");
        displayBills = new JMenuItem("Display available Bills");
        replenishChange = new JMenuItem("Replenish Change");
        collectMoney = new JMenuItem("Collect Money");

        main.setJMenuBar(menubar);
        menubar.add(menu);
        menu.add(display);
        menu.add(insertMoney);
        menu.add(select);
        menu.add(replenishItem);
        menu.add(setPrice);
        menu.add(summary);
        menu.add(displayBills);
        menu.add(replenishChange);
        menu.add(collectMoney);



        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getContentPane().removeAll();
                JTextArea itemsArea = new JTextArea();
                itemsArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(itemsArea);

                itemsArea.setText("Available items:\n");
                for (int i = 0; i < SpecialVendingMachine.getSlots().size(); i++) {
                    Slots slot = SpecialVendingMachine.getSlots().get(i);
                    Item item = slot.getItem();
                    if (item != null) {
                        itemsArea.append("Slot " + i + ": " + item.getName() + " - Price: " + slot.getPrice() + " - Quantity: " + slot.getQty() + " - Calories: " + item.getCalories() + "\n");
                    } else {
                        itemsArea.append("Slot " + i + ": Empty\n");
                    }
                }

                scrollPane.setBounds(10, 10, 400, 300);
                main.add(scrollPane);
                main.revalidate(); // Call revalidate() to update the layout
                main.repaint();
            }
        });

        insertMoney.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getContentPane().removeAll();
                main.revalidate();
                main.repaint();
                JLabel label1 = new JLabel("Only Accepts P20, P50, P100, P200, P500, P1000");
                JLabel label2 = new JLabel("Insert Denomination:");
                JTextField field1 = new JTextField();
                JLabel label3 = new JLabel("Insert Amount:");
                JTextField field2 = new JTextField();
                JButton button = new JButton("Insert");

                label1.setBounds(10, 20, 1000, 25);
                label2.setBounds(10, 50, 1000, 25);
                label3.setBounds(10, 80, 1000, 25);
                field1.setBounds(150, 50, 50, 25);
                field2.setBounds(150,80,50,25);
                button.setBounds(10, 100, 100, 25);

                main.add(label1);
                main.add(label2);
                main.add(field1);
                main.add(label3);
                main.add(field2);
                main.add(button);

                label1.setVisible(true);
                label2.setVisible(true);
                label3.setVisible(true);
                field1.setVisible(true);
                field2.setVisible(true);
                button.setVisible(true);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String denominationInput = field1.getText();
                        String amountInput = field2.getText();

                        try {
                            int amount = Integer.parseInt(amountInput);
                            SpecialVendingMachine.receivePayment(denominationInput, amount);
                            JLabel label = new JLabel("Money inserted");
                            label.setBounds(10, 130, 200, 25);
                            label.setVisible(true);
                            main.add(label);
                            main.repaint();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(main, "Invalid amount. Please enter a valid number.");
                        }
                    }
                });
            }
        });

        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getContentPane().removeAll();
                main.revalidate();
                main.repaint();

                JLabel label1 = new JLabel("Input Slot Number to Dispense:");
                JTextField field1 = new JTextField();
                JButton button = new JButton("Dispense");

                label1.setBounds(10,10,1000,25);
                field1.setBounds(10, 30, 50,25);
                button.setBounds(10, 60, 100, 25);

                main.add(label1);
                main.add(field1);
                main.add(button);

                label1.setVisible(true);
                field1.setVisible(true);
                button.setVisible(true);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String slotNumberInput = field1.getText();
                        try {
                            int slotNumber = Integer.parseInt(slotNumberInput);
                            String message = String.valueOf(SpecialVendingMachine.dispenseItem(slotNumber));
                            JLabel label = new JLabel(message);
                            label.setBounds(10, 100, 100, 25);
                            label.setVisible(true);
                            main.add(label);
                            main.repaint();

                            if (slotNumber >= 9 && slotNumber <= 12) {
                                SpecialVendingMachine.showSteps(slotNumber); // Call the showSteps() method to display preparation steps
                            }

                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(main, "Invalid slot number. Please enter a valid number.");
                        }
                    }
                });
            }
        });

        replenishItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getContentPane().removeAll();
                main.revalidate();
                main.repaint();

                JLabel label1 = new JLabel("Replenish Item Qty");
                JLabel label2 = new JLabel("Insert Item Slot Number:");
                JTextField field1 = new JTextField();
                JLabel label3 = new JLabel("Insert Amount:");
                JTextField field2 = new JTextField();
                JButton button = new JButton("Replenish");

                label1.setBounds(10, 20, 1000, 25);
                label2.setBounds(10, 50, 1000, 25);
                label3.setBounds(10, 80, 1000, 25);
                field1.setBounds(150, 50, 50, 25);
                field2.setBounds(150, 80, 50, 25);
                button.setBounds(10, 100, 100, 25);

                main.add(label1);
                main.add(label2);
                main.add(field1);
                main.add(label3);
                main.add(field2);
                main.add(button);

                label1.setVisible(true);
                label2.setVisible(true);
                label3.setVisible(true);
                field1.setVisible(true);
                field2.setVisible(true);
                button.setVisible(true);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String slotNumberInput = field1.getText();
                        String quantityInput = field2.getText();
                        try {
                            int slotNumber = Integer.parseInt(slotNumberInput);
                            int quantity = Integer.parseInt(quantityInput);
                            String message = SpecialVendingMachine.replenishItem(slotNumber, quantity);
                            JLabel label = new JLabel(message);
                            label.setBounds(10, 130, 2000, 25);
                            label.setVisible(true);
                            main.add(label);
                            main.repaint();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(main, "Invalid input. Please enter valid numbers.");
                        }
                    }
                });
            }
        });

        setPrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getContentPane().removeAll();
                main.revalidate();
                main.repaint();

                JLabel label1 = new JLabel("Set Pricing of an Item");
                JLabel label2 = new JLabel("Insert Item Slot Number:");
                JTextField field1 = new JTextField();
                JLabel label3 = new JLabel("Insert Price:");
                JTextField field2 = new JTextField();
                JButton button = new JButton("Set Price");

                label1.setBounds(10, 20, 1000, 25);
                label2.setBounds(10, 50, 1000, 25);
                label3.setBounds(10, 80, 1000, 25);
                field1.setBounds(150, 50, 50, 25);
                field2.setBounds(150, 80, 50, 25);
                button.setBounds(10, 100, 100, 25);

                main.add(label1);
                main.add(label2);
                main.add(field1);
                main.add(label3);
                main.add(field2);
                main.add(button);

                label1.setVisible(true);
                label2.setVisible(true);
                label3.setVisible(true);
                field1.setVisible(true);
                field2.setVisible(true);
                button.setVisible(true);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String slotNumberInput = field1.getText();
                        String priceInput = field2.getText();
                        try {
                            int slotNumber = Integer.parseInt(slotNumberInput);
                            int price = Integer.parseInt(priceInput);
                            String message = SpecialVendingMachine.setItemPrice(slotNumber, price);
                            JLabel label = new JLabel(message);
                            label.setBounds(10, 130, 200, 25);
                            label.setVisible(true);
                            main.add(label);
                            main.repaint();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(main, "Invalid input. Please enter valid numbers.");
                        }
                    }
                });
            }
        });

        summary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getContentPane().removeAll();
                main.revalidate();
                main.repaint();

                JTextArea itemsArea = new JTextArea();
                itemsArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(itemsArea);

                itemsArea.setText("Transaction Summary:\n");
                ArrayList<Transaction> transactionLog = SpecialVendingMachine.getTransactionLog();
                for (Transaction transaction : transactionLog) {
                    Item item = transaction.getItem();
                    int payment = transaction.getPayment();
                    itemsArea.append("Item: " + item.getName() + " - Payment: " + payment + "\n");
                }

                scrollPane.setBounds(10, 10, 400, 300);
                main.add(scrollPane);
                main.revalidate();
                main.repaint();
            }
        });

        displayBills.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getContentPane().removeAll();
                main.revalidate();
                main.repaint();

                JTextArea itemsArea = new JTextArea();
                itemsArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(itemsArea);

                String availableBillsInfo = SpecialVendingMachine.getPaymentProcess().displayAvailableBills();
                itemsArea.setText(availableBillsInfo);

                scrollPane.setBounds(10, 10, 400, 300);
                main.add(scrollPane);
                main.revalidate();
                main.repaint();
            }
        });
        replenishChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getContentPane().removeAll();
                main.revalidate();
                main.repaint();
                JLabel label4 = new JLabel("Only Accepts P20, P50, P100, P200, P500, P1000");
                JLabel label1 = new JLabel("Replenish Change");
                JLabel label2 = new JLabel("Insert Denomination:");
                JTextField field1 = new JTextField();
                JLabel label3 = new JLabel("Insert Amount:");
                JTextField field2 = new JTextField();
                JButton button = new JButton("Replenish");

                label4.setBounds(10, 7, 1000, 25);
                label1.setBounds(10, 20, 1000, 25);
                label2.setBounds(10, 50, 1000, 25);
                label3.setBounds(10, 80, 1000, 25);
                field1.setBounds(150, 50, 50, 25);
                field2.setBounds(150,80,50,25);
                button.setBounds(10, 100, 100, 25);

                main.add(label4);
                main.add(label1);
                main.add(label2);
                main.add(field1);
                main.add(label3);
                main.add(field2);
                main.add(button);

                label4.setVisible(true);
                label1.setVisible(true);
                label2.setVisible(true);
                label3.setVisible(true);
                field1.setVisible(true);
                field2.setVisible(true);
                button.setVisible(true);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String denominationInput = field1.getText();
                        String quantityInput = field2.getText();
                        try {
                            int quantity = Integer.parseInt(quantityInput);
                            String message = SpecialVendingMachine.replenishChange(denominationInput, quantity);
                            JLabel label = new JLabel(message);
                            label.setBounds(10, 130, 2000, 25);
                            label.setVisible(true);
                            main.add(label);
                            main.repaint();
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(main, "Invalid input. Please enter a valid number.");
                        }
                    }
                });
            }
        });

        collectMoney.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.getContentPane().removeAll();
                main.revalidate();
                main.repaint();

                JLabel label = new JLabel("Empty Vending Machine Money");
                JButton button = new JButton("Empty");

                button.setBounds(10,30,100,25);
                label.setBounds(10,10,1000,25);

                button.setVisible(true);
                label.setVisible(true);

                main.add(label);
                main.add(button);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        SpecialVendingMachine.emptyMoney();
                        JOptionPane.showMessageDialog(main, "Money Collected") ;
                    }
                });
            }
        });


        main.setSize(500, 600);
        main.setLayout(null);
        main.setLocationRelativeTo(null);
        main.setVisible(true);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        VendingMachineFactory VendingMachineFactory = new VendingMachineFactory();
        VendingMachine specialVendingMachine = VendingMachineFactory.createSpecialVendingMachine();
        GUI g = new GUI(specialVendingMachine);
    }
}
