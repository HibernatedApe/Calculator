import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Timer;

import java.util.ArrayList;

public class Calculator {
    
    JFrame mainFrame = new JFrame("Calculator");
    JPanel mainPanel = new JPanel();
    JTextField lowerResult = new JTextField();
    JTextField upperResult = new JTextField();
    
    String arithmeticOperator = "";
    String originalLowerValue = "";
    
    boolean restartAfterType = false;
    
    ArrayList<String> historyRecord = new ArrayList<>();
    
    // History Variables/Objects
    JPanel historyPanel = new JPanel();
    JTextField historyTitle = new JTextField();
    JTextArea historyContent = new JTextArea();
    JScrollPane historyScrollPane = new JScrollPane();
    String historyText = "";
    
    ArrayList<String> historyArray = new ArrayList<>();
    
    boolean showHistory = false;
    boolean scientificCalculatorON = false;
    
    public Calculator() {
        
        startCalculator();
        
    }
    
    // ------------------------------------------------ BASIC CALCULATOR ----------------------------------------------- (START)
    
    public void startCalculator() { 
        
        // Refresher
        new Timer(1, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                if(lowerResult.getText().contains("(sin) ") || lowerResult.getText().contains("(cos) ") ||
                   lowerResult.getText().contains("(tan) ") || lowerResult.getText().contains("(max) ") || 
                   lowerResult.getText().contains("(min) ") || lowerResult.getText().contains("(abs) ") || 
                   lowerResult.getText().contains("(log) ") || lowerResult.getText().contains("(Rad to Deg) ") || 
                   lowerResult.getText().contains("(Deg to Rad) ") || lowerResult.getText().contains("√ ")) 
                {
                    upperResult.setVisible(false);
                } else {
                    upperResult.setVisible(true);
                }
                
            }
        }).start();
        
        mainFrame.setSize(420, 660);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setResizable(false);
        mainFrame.add(mainPanel);
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.BLACK);
        
        upperResult.setBounds(200, 75, 160, 40);
        upperResult.setBackground(Color.WHITE);
        upperResult.setForeground(Color.BLACK);
        upperResult.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        upperResult.setHorizontalAlignment(JTextField.CENTER);
        upperResult.setEditable(false);
        upperResult.setBorder(null);
        mainPanel.add(upperResult);
        
        lowerResult.setBounds(60, 120, 300, 80);
        lowerResult.setBackground(Color.WHITE);
        lowerResult.setForeground(Color.BLACK);
        lowerResult.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        lowerResult.setHorizontalAlignment(JTextField.CENTER);
        lowerResult.setEditable(false);
        lowerResult.setBorder(null);
        mainPanel.add(lowerResult);
        
        // BUTTON - Numbers
        
        button0.setBounds(60, 520, 70, 70); button5.setBounds(135, 370, 70, 70);
        button1.setBounds(60, 445, 70, 70); button6.setBounds(210, 370, 70, 70);
        button2.setBounds(135, 445, 70, 70); button7.setBounds(60, 295, 70, 70);
        button3.setBounds(210, 445, 70, 70); button8.setBounds(135, 295, 70, 70);
        button4.setBounds(60, 370, 70, 70); button9.setBounds(210, 295, 70, 70);
        
        button0.setBackground(new Color(0, 13, 13));  button5.setBackground(new Color(0, 13, 13));
        button1.setBackground(new Color(0, 13, 13));  button6.setBackground(new Color(0, 13, 13));
        button2.setBackground(new Color(0, 13, 13));  button7.setBackground(new Color(0, 13, 13));
        button3.setBackground(new Color(0, 13, 13));  button8.setBackground(new Color(0, 13, 13));
        button4.setBackground(new Color(0, 13, 13));  button9.setBackground(new Color(0, 13, 13));
        
        button0.setForeground(Color.WHITE); button5.setForeground(Color.WHITE);
        button1.setForeground(Color.WHITE); button6.setForeground(Color.WHITE);
        button2.setForeground(Color.WHITE); button7.setForeground(Color.WHITE);
        button3.setForeground(Color.WHITE); button8.setForeground(Color.WHITE);
        button4.setForeground(Color.WHITE); button9.setForeground(Color.WHITE);
        
        button0.setFont(new Font("Consolas", Font.PLAIN, 20)); button5.setFont(new Font("Consolas", Font.PLAIN, 20));
        button1.setFont(new Font("Consolas", Font.PLAIN, 20)); button6.setFont(new Font("Consolas", Font.PLAIN, 20));
        button2.setFont(new Font("Consolas", Font.PLAIN, 20)); button7.setFont(new Font("Consolas", Font.PLAIN, 20));
        button3.setFont(new Font("Consolas", Font.PLAIN, 20)); button8.setFont(new Font("Consolas", Font.PLAIN, 20));
        button4.setFont(new Font("Consolas", Font.PLAIN, 20)); button9.setFont(new Font("Consolas", Font.PLAIN, 20));
        
        button0.setBorder(null); button5.setBorder(null);
        button1.setBorder(null); button6.setBorder(null);
        button2.setBorder(null); button7.setBorder(null);
        button3.setBorder(null); button8.setBorder(null);
        button4.setBorder(null); button9.setBorder(null);
        
        button0.setFocusable(false); button5.setFocusable(false);
        button1.setFocusable(false); button6.setFocusable(false);
        button2.setFocusable(false); button7.setFocusable(false);
        button3.setFocusable(false); button8.setFocusable(false);
        button4.setFocusable(false); button9.setFocusable(false);
        
        mainPanel.add(button0); mainPanel.add(button5);
        mainPanel.add(button1); mainPanel.add(button6);
        mainPanel.add(button2); mainPanel.add(button7);
        mainPanel.add(button3); mainPanel.add(button8);
        mainPanel.add(button4); mainPanel.add(button9);
        
        mainFrame.setVisible(true);
        
        // Button - Non Operators
        
        dotButton.setBounds(135, 520, 70, 70);
        dotButton.setBackground(new Color(0, 13, 13));
        dotButton.setForeground(Color.WHITE);
        dotButton.setFont(new Font("Consolas", Font.PLAIN, 20));
        dotButton.setBorder(null);
        dotButton.setFocusable(false);
        mainPanel.add(dotButton);
           
        acButton.setBounds(60, 220, 70, 70);
        acButton.setBackground(new Color(0, 13, 13));
        acButton.setForeground(Color.WHITE);
        acButton.setFont(new Font("Consolas", Font.PLAIN, 20));
        acButton.setBorder(null);
        acButton.setFocusable(false);
        mainPanel.add(acButton);
        
        positiveOrNegativeButton.setBounds(135, 220, 70, 70);
        positiveOrNegativeButton.setBackground(new Color(0, 13, 13));
        positiveOrNegativeButton.setForeground(Color.WHITE);
        positiveOrNegativeButton.setFont(new Font("Consolas", Font.PLAIN, 20));
        positiveOrNegativeButton.setBorder(null);
        positiveOrNegativeButton.setFocusable(false);
        mainPanel.add(positiveOrNegativeButton);
        
        backSpaceButton.setBounds(210, 220, 70, 70);
        backSpaceButton.setBackground(new Color(0, 13, 13));
        backSpaceButton.setForeground(Color.WHITE);
        backSpaceButton.setFont(new Font("Consolas", Font.PLAIN, 20));
        backSpaceButton.setBorder(null);
        backSpaceButton.setFocusable(false);
        mainPanel.add(backSpaceButton);
        
        equalButton.setBounds(210, 520, 145, 70);
        equalButton.setBackground(new Color(11, 10, 2));
        equalButton.setForeground(Color.WHITE);
        equalButton.setFont(new Font("Consolas", Font.PLAIN, 20));
        equalButton.setBorder(null);
        equalButton.setFocusable(false);
        mainPanel.add(equalButton);
        
        // BUTTON - Operators
        
        additionButton.setBounds(285, 445, 70, 70);
        additionButton.setBackground(new Color(0, 13, 13));
        additionButton.setForeground(Color.WHITE);
        additionButton.setFont(new Font("Consolas", Font.PLAIN, 20));
        additionButton.setBorder(null);
        additionButton.setFocusable(false);
        mainPanel.add(additionButton);
        
        substractionButton.setBounds(285, 370, 70, 70);
        substractionButton.setBackground(new Color(0, 13, 13));
        substractionButton.setForeground(Color.WHITE);
        substractionButton.setFont(new Font("Consolas", Font.PLAIN, 20));
        substractionButton.setBorder(null);
        substractionButton.setFocusable(false);
        mainPanel.add(substractionButton);
        
        multiplicationButton.setBounds(285, 295, 70, 70);
        multiplicationButton.setBackground(new Color(0, 13, 13));
        multiplicationButton.setForeground(Color.WHITE);
        multiplicationButton.setFont(new Font("Consolas", Font.PLAIN, 20));
        multiplicationButton.setBorder(null);
        multiplicationButton.setFocusable(false);
        mainPanel.add(multiplicationButton);
        
        divisionButton.setBounds(285, 220, 70, 70);
        divisionButton.setBackground(new Color(0, 13, 13));
        divisionButton.setForeground(Color.WHITE);
        divisionButton.setFont(new Font("Consolas", Font.PLAIN, 20));
        divisionButton.setBorder(null);
        divisionButton.setFocusable(false);
        mainPanel.add(divisionButton);
        
        // ------------- SCIENTIFIC CALCULATOR -------------
        
        goScientificButton.setBounds(20, 20, 60, 60);
        goScientificButton.setBackground(new Color(0, 13, 13));
        goScientificButton.setForeground(Color.WHITE);
        goScientificButton.setFont(new Font("Consolas", Font.PLAIN, 20));
        goScientificButton.setBorder(null);
        goScientificButton.setFocusable(false);
        goScientificButton.setToolTipText("Open Scientific Part");
        mainPanel.add(goScientificButton);
        
        sinButton.setBounds(420, 220, 70, 70);
        cosButton.setBounds(495, 220, 70, 70);
        tanButton.setBounds(570, 220, 70, 70);
        
        maxButton.setBounds(420, 295, 70, 70);
        minButton.setBounds(495, 295, 70, 70);
        sqrtButton.setBounds(570, 295, 70, 70);
        
        absButton.setBounds(420, 370, 70, 70);
        logButton.setBounds(495, 370, 70, 70);
        seperatorButton.setBounds(570, 370, 70, 70);
        
        degreesToRadianButton.setBounds(420, 445, 70, 70);
        radianToDegreesButton.setBounds(495, 445, 70, 70);
        
        sinButton.setBackground(new Color(0, 13, 13)); sqrtButton.setBackground(new Color(0, 13, 13));
        cosButton.setBackground(new Color(0, 13, 13)); absButton.setBackground(new Color(0, 13, 13));
        tanButton.setBackground(new Color(0, 13, 13)); logButton.setBackground(new Color(0, 13, 13));
        maxButton.setBackground(new Color(0, 13, 13)); degreesToRadianButton.setBackground(new Color(0, 13, 13));
        minButton.setBackground(new Color(0, 13, 13)); radianToDegreesButton.setBackground(new Color(0, 13, 13));
        seperatorButton.setBackground(new Color(0, 13, 13));
        
        sinButton.setForeground(Color.WHITE); sqrtButton.setForeground(Color.WHITE);
        cosButton.setForeground(Color.WHITE); absButton.setForeground(Color.WHITE);
        tanButton.setForeground(Color.WHITE); logButton.setForeground(Color.WHITE);
        maxButton.setForeground(Color.WHITE); degreesToRadianButton.setForeground(Color.WHITE);
        minButton.setForeground(Color.WHITE); radianToDegreesButton.setForeground(Color.WHITE);
        seperatorButton.setForeground(Color.WHITE);
        
        sinButton.setFont(new Font("Consolas", Font.PLAIN, 20)); sqrtButton.setFont(new Font("Consolas", Font.PLAIN, 20));
        cosButton.setFont(new Font("Consolas", Font.PLAIN, 20)); absButton.setFont(new Font("Consolas", Font.PLAIN, 20));
        tanButton.setFont(new Font("Consolas", Font.PLAIN, 20)); logButton.setFont(new Font("Consolas", Font.PLAIN, 20));
        maxButton.setFont(new Font("Consolas", Font.PLAIN, 20)); degreesToRadianButton.setFont(new Font("Consolas", Font.PLAIN, 20));
        minButton.setFont(new Font("Consolas", Font.PLAIN, 20)); radianToDegreesButton.setFont(new Font("Consolas", Font.PLAIN, 20));
        seperatorButton.setFont(new Font("Consolas", Font.PLAIN, 20));
        
        sinButton.setBorder(null); sqrtButton.setBorder(null);
        cosButton.setBorder(null); absButton.setBorder(null);
        tanButton.setBorder(null); logButton.setBorder(null);
        maxButton.setBorder(null); degreesToRadianButton.setBorder(null);
        minButton.setBorder(null); radianToDegreesButton.setBorder(null);
        seperatorButton.setBorder(null);
        
        sinButton.setFocusable(false); sqrtButton.setFocusable(false);
        cosButton.setFocusable(false); absButton.setFocusable(false);
        tanButton.setFocusable(false); logButton.setFocusable(false);
        maxButton.setFocusable(false); degreesToRadianButton.setFocusable(false);
        minButton.setFocusable(false); radianToDegreesButton.setFocusable(false);
        seperatorButton.setFocusable(false);
        
        sinButton.setToolTipText("<html>sin<p><p>Parameter: (number)<p>Enter one (1) value to process.</html>");
        cosButton.setToolTipText("<html>cos<p><p>Parameter: (number)<p>Enter one (1) value to process.</html>");
        tanButton.setToolTipText("<html>tan<p><p>Parameter: (number)<p>Enter one (1) value to process.</html>");
        maxButton.setToolTipText("<html>Getting Maximum of Two Values<p><p>Parameter: (number, number)<p><p>Enter two (2) values<p>seperated by \"~\" to process.</html>");
        minButton.setToolTipText("<html>Getting Minimum of Two Values<p><p>Parameter: (number, number)<p><p>Enter two (2) values<p>seperated by \"~\" to process.</html>");
        sqrtButton.setToolTipText("<html>Square Root<p><p>Parameter: (number)<p>Enter one (1) value to process.</html>");
        absButton.setToolTipText("<html>Absolute Value<p><p>Parameter: (number)<p>Enter one (1) value to process.</html>");
        logButton.setToolTipText("<html>Logarithm (Base 10)<p><p>Parameter: (number)<p>Note: This is log base 10.<p>Enter one (1) value to process.</html>");
        degreesToRadianButton.setToolTipText("<html>Degree to Radian<p><p>Parameter: (number)<p>Enter one (1) value to process.</html>");
        radianToDegreesButton.setToolTipText("<html>Radian to Degree<p><p>Parameter: (number)<p>Enter one (1) value to process.</html>");
        seperatorButton.setToolTipText("<html>Seperator<p><p>Used for seperating numbers.<p>Used for MAX and MIN.</html>");
        
        mainPanel.add(sinButton); mainPanel.add(sqrtButton);
        mainPanel.add(cosButton); mainPanel.add(absButton);
        mainPanel.add(tanButton); mainPanel.add(logButton);
        mainPanel.add(maxButton); mainPanel.add(degreesToRadianButton);
        mainPanel.add(minButton); mainPanel.add(radianToDegreesButton);
        mainPanel.add(seperatorButton);
        
        logButton.setBackground(new Color(0, 13, 13));
        logButton.setForeground(Color.WHITE);
        logButton.setFont(new Font("Consolas", Font.PLAIN, 20));
        logButton.setBorder(null);
        logButton.setFocusable(false);
        mainPanel.add(logButton);
        
        // ----------------------------------- HISTORY -----------------------------------
        showHistoryButton.setBounds(85, 20, 60, 60);
        showHistoryButton.setBackground(new Color(0, 13, 13));
        showHistoryButton.setForeground(Color.WHITE);
        showHistoryButton.setFont(new Font("Consolas", Font.PLAIN, 20));
        showHistoryButton.setBorder(null);
        showHistoryButton.setFocusable(false);
        showHistoryButton.setToolTipText("Open History");
        mainPanel.add(showHistoryButton);
        
        historyPanel.setBounds(60, 120, 180, 470);
        historyPanel.setBackground(new Color(11, 10, 2));
        mainPanel.add(historyPanel);
        historyPanel.setLayout(null);
        
        historyTitle.setHorizontalAlignment(JTextField.CENTER);
        historyTitle.setEditable(false);
        historyTitle.setFocusable(false);
        historyTitle.setBorder(null);
        historyTitle.setText("History");
        historyTitle.setBounds(0, 0, 180, 40);
        historyTitle.setForeground(Color.WHITE);
        historyTitle.setBackground(new Color(0, 15, 15));
        historyTitle.setFont(new Font("Consolas", Font.PLAIN, 20));
        historyPanel.add(historyTitle);
        
        historyContent.setEditable(false);
        historyContent.setFocusable(false);
        historyContent.setBorder(null);
        historyContent.setBounds(0, 50, 180, 420);
        historyContent.setForeground(Color.WHITE);
        historyContent.setBackground(new Color(11, 10, 2));
        historyContent.setFont(new Font("Consolas", Font.PLAIN, 20));
        
        historyScrollPane = new JScrollPane(historyContent);
        historyScrollPane.setBounds(0, 50, 180, 420);
        historyScrollPane.setBorder(null);
        historyScrollPane.setBackground(null);
        
        historyPanel.add(historyScrollPane);
        
        historyPanel.setVisible(false);
        // ----------------------------------- HISTORY -----------------------------------
        
    }
    
    // Button Implementation - Numbers
    
    JButton button0 = new JButton(new AbstractAction("0") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            restartTypeAgain();
            lowerResult.setText(lowerResult.getText() + "0");
        }
    });
    JButton button1 = new JButton(new AbstractAction("1") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            restartTypeAgain();
            lowerResult.setText(lowerResult.getText() + "1");
        }
    });
    JButton button2 = new JButton(new AbstractAction("2") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            restartTypeAgain();
            lowerResult.setText(lowerResult.getText() + "2");
        }
    });
    JButton button3 = new JButton(new AbstractAction("3") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            restartTypeAgain();
            lowerResult.setText(lowerResult.getText() + "3");
        }
    });
    JButton button4 = new JButton(new AbstractAction("4") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            restartTypeAgain();
            lowerResult.setText(lowerResult.getText() + "4");
        }
    });
    JButton button5 = new JButton(new AbstractAction("5") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            restartTypeAgain();
            lowerResult.setText(lowerResult.getText() + "5");
        }
    });
    JButton button6 = new JButton(new AbstractAction("6") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            restartTypeAgain();
            lowerResult.setText(lowerResult.getText() + "6");
        }
    });
    JButton button7 = new JButton(new AbstractAction("7") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            restartTypeAgain();
            lowerResult.setText(lowerResult.getText() + "7");
        }
    });
    JButton button8 = new JButton(new AbstractAction("8") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            restartTypeAgain();
            lowerResult.setText(lowerResult.getText() + "8");
        }
    });
    JButton button9 = new JButton(new AbstractAction("9") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            restartTypeAgain();
            lowerResult.setText(lowerResult.getText() + "9");
        }
    });
    
    // Button Implementation - Non Operators
    JButton dotButton = new JButton(new AbstractAction(".") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            if(!lowerResult.getText().contains(".")) {
                lowerResult.setText(lowerResult.getText() + ".");
            }
            
            if(lowerResult.getText().contains("max") || lowerResult.getText().contains("min"))
            {
                
                String valueAfterWiggly = lowerResult.getText().substring(lowerResult.getText().indexOf("~") + 1);
                if(lowerResult.getText().contains("~") && !valueAfterWiggly.contains(".")) {
                    
                    lowerResult.setText(lowerResult.getText() + ".");
                    
                }
                
            } else {
                
                if(!lowerResult.getText().contains(".")) {
                    lowerResult.setText(lowerResult.getText() + ".");
                }
                
            }
            
        }
    });
    JButton acButton = new JButton(new AbstractAction("AC") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            lowerResult.setText("");
            upperResult.setText("");
        }
    });
    JButton positiveOrNegativeButton = new JButton(new AbstractAction("+/-") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if(lowerResult.getText().contains("(sin) ") || lowerResult.getText().contains("(cos) ") ||
               lowerResult.getText().contains("(tan) ") || lowerResult.getText().contains("(max) ") ||
               lowerResult.getText().contains("(min) ") || lowerResult.getText().contains("√ ")     ||
               lowerResult.getText().contains("(abs) ") || lowerResult.getText().contains("(log) ") ||
               lowerResult.getText().contains("(Deg to Rad) ") || lowerResult.getText().contains("(Rad to Deg) "))
            {
                
                String operatorWithSpace = lowerResult.getText().substring(0, lowerResult.getText().lastIndexOf(" ") + 1);
                String contentAfterScientific = lowerResult.getText().substring(lowerResult.getText().lastIndexOf(" ") + 1);
                
                if(!contentAfterScientific.contains("~"))
                {
                    String leftNumber = contentAfterScientific;

                    if(!leftNumber.contains("-")) {
                        leftNumber = "-" + leftNumber;
                    } else {
                        leftNumber = leftNumber.substring(1);
                    }

                    String leftResult = operatorWithSpace + leftNumber;

                    lowerResult.setText(leftResult);
                    
                } 
                if (contentAfterScientific.contains("~") &&
                    contentAfterScientific.substring(contentAfterScientific.indexOf("~") + 1).length() != 0 &&
                    !contentAfterScientific.substring(contentAfterScientific.indexOf("~") + 1).equals(".")) 
                {
                    
                    String contentBeforeRightNumber = lowerResult.getText().substring(0, lowerResult.getText().indexOf("~") + 1);
                    String rightNumber = contentAfterScientific.substring(contentAfterScientific.indexOf("~") + 1);
                    
                    if(!rightNumber.contains("-")) {
                        rightNumber = "-" + rightNumber;
                    } else {
                        rightNumber = rightNumber.substring(1);
                    }
                    
                    String rightResult = contentBeforeRightNumber + rightNumber;
                    
                    lowerResult.setText(rightResult);
                    
                }
                
            } else {
                
                if((lowerResult.getText().trim().length() != 0) && (!lowerResult.getText().equals("-"))) {
                    if(lowerResult.getText().contains("-")) {
                        lowerResult.setText(lowerResult.getText().substring(1));
                    } else {
                        lowerResult.setText("-" + lowerResult.getText());
                    }
                }
                
            }
            
        }
    });
    JButton backSpaceButton = new JButton(new AbstractAction("<--") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if(lowerResult.getText().equals("(sin) ") || lowerResult.getText().equals("(cos) ") ||
               lowerResult.getText().equals("(tan) ") || lowerResult.getText().equals("(max) ") ||
               lowerResult.getText().equals("(min) ") || lowerResult.getText().equals("√ ")   ||
               lowerResult.getText().equals("(abs) ") || lowerResult.getText().equals("(log) ") ||
               lowerResult.getText().equals("(Deg to Rad) ") || lowerResult.getText().equals("(Rad To Deg) "))
            {
                lowerResult.setText("");
            }
            
            if(lowerResult.getText().trim().length() != 0) {
                lowerResult.setText(lowerResult.getText().substring(0, lowerResult.getText().length() - 1));
                
                if(lowerResult.getText().trim().length() == 1) {
                    if(lowerResult.getText().equals("-")) {
                        lowerResult.setText("");
                    }
                }
                
            }
        }
    });
    JButton equalButton = new JButton(new AbstractAction("=") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            if(lowerResult.getText().contains("sin") || lowerResult.getText().contains("cos") ||
               lowerResult.getText().contains("tan") || lowerResult.getText().contains("max") ||
               lowerResult.getText().contains("min") || lowerResult.getText().contains("√")   ||
               lowerResult.getText().contains("abs") || lowerResult.getText().contains("log") ||
               lowerResult.getText().contains("Deg to Rad") || lowerResult.getText().contains("Rad to Deg"))
            {
                String getAfterSpace = lowerResult.getText().substring(lowerResult.getText().lastIndexOf(" ") + 1);
                String operator = "";
                
                if(lowerResult.getText().contains("√")) {
                    operator = lowerResult.getText().substring(0, lowerResult.getText().indexOf(" "));
                } else {
                    operator = lowerResult.getText().substring(1, lowerResult.getText().indexOf(")"));
                }
                
                switch(operator) {
                    case ("sin"):
                        
                        String valueAfterSIN = lowerResult.getText().substring(lowerResult.getText().lastIndexOf(" ") + 1);
                        lowerResult.setText("" + Math.sin(Double.parseDouble(valueAfterSIN)));
                        
                        break;
                    case ("cos"):
                        
                        String valueAfterCOS = lowerResult.getText().substring(lowerResult.getText().lastIndexOf(" ") + 1);
                        lowerResult.setText("" + Math.cos(Double.parseDouble(valueAfterCOS)));
                        
                        break;
                    case ("tan"):
                        
                        String valueAfterTAN = lowerResult.getText().substring(lowerResult.getText().lastIndexOf(" ") + 1);
                        lowerResult.setText("" + Math.tan(Double.parseDouble(valueAfterTAN)));
                        
                        break;
                    case ("max"):
                        
                        if(lowerResult.getText().contains("~") && 
                           lowerResult.getText().substring(lowerResult.getText().indexOf("~") + 1).length() != 0) 
                        {
                            
                            double firstNumber = Double.parseDouble(getAfterSpace.substring(0, getAfterSpace.indexOf("~")));
                            double secondNumber = Double.parseDouble(getAfterSpace.substring(getAfterSpace.indexOf("~") + 1));

                            String totalMax = Double.toString(Math.max(firstNumber, secondNumber));
                            String displayMax = "";

                            if(totalMax.substring(totalMax.indexOf(".") + 1).equals("0")) {

                                displayMax = totalMax.substring(0, totalMax.indexOf("."));

                            } else if(totalMax.substring(totalMax.indexOf(".")).length() > 8) {

                                String getDecimal = totalMax.substring(totalMax.indexOf(".") + 1, 8);
                                displayMax = totalMax.substring(0, totalMax.indexOf(".") + 1) + "" + getDecimal;

                            } else {
                                displayMax = totalMax;
                            }

                            lowerResult.setText("= " + displayMax);
                            restartAfterType = true;

                        }
                        
                        break;
                    case ("min"):
                        
                        if(lowerResult.getText().contains("~") && 
                           lowerResult.getText().substring(lowerResult.getText().indexOf("~") + 1).length() != 0) 
                        {
                            
                            double firstNumber = Double.parseDouble(getAfterSpace.substring(0, getAfterSpace.indexOf("~")));
                            double secondNumber = Double.parseDouble(getAfterSpace.substring(getAfterSpace.indexOf("~") + 1));

                            String totalMin = Double.toString(Math.min(firstNumber, secondNumber));
                            String displayMin = "";

                            if(totalMin.substring(totalMin.indexOf(".") + 1).equals("0")) {

                                displayMin = totalMin.substring(0, totalMin.indexOf("."));

                            } else if(totalMin.substring(totalMin.indexOf(".")).length() > 8) {

                                String getDecimal = totalMin.substring(totalMin.indexOf(".") + 1, 8);
                                displayMin = totalMin.substring(0, totalMin.indexOf(".") + 1) + "" + getDecimal;

                            } else {
                                displayMin = totalMin;
                            }

                            lowerResult.setText("= " + totalMin);
                            restartAfterType = true;

                        }
                        
                        break;
                    case ("√"):
                        
                        String valueAfterSQRT = lowerResult.getText().substring(lowerResult.getText().lastIndexOf(" ") + 1);
                        lowerResult.setText("" + Math.sqrt(Double.parseDouble(valueAfterSQRT)));
                        
                        break;
                    case ("log"):
                        
                        String valueAfterLOG = lowerResult.getText().substring(lowerResult.getText().lastIndexOf(" ") + 1);
                        lowerResult.setText("" + Math.log10(Double.parseDouble(valueAfterLOG)));
                        
                        break;
                    case ("Deg to Rad"):
                        
                        String valueAfterDegToRad = lowerResult.getText().substring(lowerResult.getText().lastIndexOf(" ") + 1);
                        lowerResult.setText("" + Math.toRadians(Double.parseDouble(valueAfterDegToRad)));
                        
                        break;
                    case ("Rad to Deg"):
                        
                        String valueAfterRadToDeg = lowerResult.getText().substring(lowerResult.getText().lastIndexOf(" ") + 1);
                        lowerResult.setText("" + Math.toDegrees(Double.parseDouble(valueAfterRadToDeg)));
                        
                        break;
                    case ("abs"):
                        
                        String valueAfterABS = lowerResult.getText().substring(lowerResult.getText().lastIndexOf(" ") + 1);
                        lowerResult.setText("" + Math.abs(Double.parseDouble(valueAfterABS)));
                        
                        break;
                }
                
                restartAfterType = true;
                
            } else {
                
                if((originalLowerValue.trim().length() != 0) && (lowerResult.getText().trim().length() != 0)) {
                
                    double lowerResultValue = Double.parseDouble(lowerResult.getText());
                    upperResult.setText("");
                    String totalResult = "";

                    switch(arithmeticOperator) {

                        case ("+"):
                            totalResult = "" + (Double.parseDouble(originalLowerValue) + lowerResultValue);
                            break;
                        case ("-"):
                            totalResult = "" + (Double.parseDouble(originalLowerValue) - lowerResultValue);
                            break;
                        case ("x"):
                            totalResult = "" + (Double.parseDouble(originalLowerValue) * lowerResultValue);
                            break;
                        case ("/"):
                            totalResult = "" + (Double.parseDouble(originalLowerValue) / lowerResultValue);
                            break;


                    }

                    String printDecimal = "";
                    boolean withDecimal = false;

                    printDecimal = totalResult.substring(totalResult.indexOf(".") + 1);

                    if(printDecimal.equals("0")) {
                        withDecimal = false;
                    } else {
                        withDecimal = true; 
                    }

                    if(printDecimal.length() > 8) {
                        printDecimal = printDecimal.substring(0, 8);
                    }

                    if(withDecimal) {

                        lowerResult.setText(totalResult.substring(0, totalResult.indexOf(".") + 1) + "" + printDecimal);

                    } else {

                        lowerResult.setText(totalResult.substring(0, totalResult.indexOf(".")));

                    }

                    restartAfterType = true;

                }
                
            }
            
            // Code Here - Insert To History ArrayList
            String totalComputation = lowerResult.getText();
            if(totalComputation.trim().length() != 0) {
                
                historyArray.add(totalComputation);
                
            }
            
            historyContent.removeAll();
            historyText = "";
            
            for(int a = 0; a < historyArray.size(); a++) {
                historyText += (" " + historyArray.get(a) + "\n");
            }
            
            historyContent.setText(historyText);
            
        }
    });
    
    // BUTTONS - Operators
    JButton additionButton = new JButton(new AbstractAction("+") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            arithmeticOperator = "+";
            arithmeticOperatorsButtonsFunctions();
        }
    });
    JButton substractionButton = new JButton(new AbstractAction("-") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            arithmeticOperator = "-";
            arithmeticOperatorsButtonsFunctions();
        }
    });
    JButton multiplicationButton = new JButton(new AbstractAction("x") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            arithmeticOperator = "x";
            arithmeticOperatorsButtonsFunctions();
        }
    });
    JButton divisionButton = new JButton(new AbstractAction("/") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            arithmeticOperator = "/";
            arithmeticOperatorsButtonsFunctions();
        }
    });
    public void arithmeticOperatorsButtonsFunctions() {
        
        if((lowerResult.getText().trim().length() != 0) && (!lowerResult.getText().equals("."))) {
            
            originalLowerValue = lowerResult.getText();
            
            switch(arithmeticOperator) {
            
                case ("+"):
                    upperResult.setText(lowerResult.getText() + " + ");
                    break;
                case ("-"):
                    upperResult.setText(lowerResult.getText() + " - ");
                    break;
                case ("x"):
                    upperResult.setText(lowerResult.getText() + " x ");
                    break;
                case ("/"):
                    upperResult.setText(lowerResult.getText() + " / ");
                    break;

            }
            lowerResult.setText("");
            
        }
        
    }
    
    public void restartTypeAgain() {
        
        if(restartAfterType) {
            
            lowerResult.setText("");
            restartAfterType = false;
            
        }
        
    }
    
    // ------------------------------------------------ BASIC CALCULATOR ----------------------------------------------- (END)
    
    // --------------------------------------------- SCIENTIFIC CALCULATOR --------------------------------------------- (START)
    
    public void scientificCalculatorFunction() {
        
        switch(goScientificButton.getText()) {
            case (">"):
                
                mainFrame.setSize(710, 660);
                
                upperResult.setBounds(480, 75, 160, 40);
                lowerResult.setBounds(60, 120, 580, 80);
                
                mainFrame.setLocationRelativeTo(null);
                goScientificButton.setToolTipText("Hide Scientific Part");
                goScientificButton.setText("<");
                
                scientificCalculatorON = true;
                break;
            case ("<"):
                
                mainFrame.setSize(420, 660);
                
                upperResult.setBounds(200, 75, 160, 40);
                lowerResult.setBounds(60, 120, 300, 80);
                
                mainFrame.setLocationRelativeTo(null);
                goScientificButton.setToolTipText("Open Scientific Part");
                goScientificButton.setText(">");
                
                scientificCalculatorON = false;
                break;
        }
        
        if(showHistory == true && scientificCalculatorON == true) {
                
            mainFrame.setSize(960, 660);
            upperResult.setBounds(480 + 250, 75, 160, 40);
            lowerResult.setBounds(60 + 250, 120, 580, 80);
                
        }
        if(showHistory == true && scientificCalculatorON == false) {
            
            mainFrame.setSize(670, 660);
            upperResult.setBounds(200 + 250, 75, 160, 40);
            lowerResult.setBounds(60 + 250, 120, 300, 80);
            
        }
        
    }
    
    JButton goScientificButton = new JButton(new AbstractAction(">") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            scientificCalculatorFunction();
            
        }
    });
    
    // BUTTON - Scientific Operators
    JButton sinButton = new JButton(new AbstractAction("sin") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            restartTypeAgain();
            restartTypeForScientific();
            lowerResult.setText("(sin) ");
            
        }
    });
    JButton cosButton = new JButton(new AbstractAction("cos") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            restartTypeAgain();
            restartTypeForScientific();
            lowerResult.setText("(cos) ");
            
        }
    });
    JButton tanButton = new JButton(new AbstractAction("tan") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            restartTypeAgain();
            restartTypeForScientific();
            lowerResult.setText("(tan) ");
            
        }
    });
    JButton maxButton = new JButton(new AbstractAction("max") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            restartTypeAgain();
            restartTypeForScientific();
            lowerResult.setText("(max) ");
            
        }
    });
    JButton minButton = new JButton(new AbstractAction("min") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            restartTypeAgain();
            restartTypeForScientific();
            lowerResult.setText("(min) ");
            
        }
    });
    JButton sqrtButton = new JButton(new AbstractAction("√") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            restartTypeAgain();
            restartTypeForScientific();
            lowerResult.setText("√ ");
            
        }
    });
    JButton absButton = new JButton(new AbstractAction("abs") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            restartTypeAgain();
            restartTypeForScientific();
            lowerResult.setText("(abs) ");
            
        }
    });
    JButton logButton = new JButton(new AbstractAction("log") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            restartTypeAgain();
            restartTypeForScientific();
            lowerResult.setText("(log) ");
            
        }
    });
    JButton degreesToRadianButton = new JButton(new AbstractAction("°-π") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            restartTypeAgain();
            restartTypeForScientific();
            lowerResult.setText("(Deg to Rad) ");
            
        }
    });
    JButton radianToDegreesButton = new JButton(new AbstractAction("π-°") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            restartTypeAgain();
            restartTypeForScientific();
            lowerResult.setText("(Rad to Deg) ");
            
        }
    });
    JButton seperatorButton = new JButton(new AbstractAction("~") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            restartTypeAgain();
            String number = "1234567890";
            boolean go = false;
            
            if(lowerResult.getText().contains("(max) ") || lowerResult.getText().contains("(min) "))
            {
                if(lowerResult.getText().trim().length() != 0 &&
                  (number.contains("" + lowerResult.getText().charAt(lowerResult.getText().length() - 1)))) 
                {
                    go = true;
                }

                if(lowerResult.getText().trim().length() != 0 && !lowerResult.getText().contains("~") && go) {
                    lowerResult.setText(lowerResult.getText() + "~");
                }
            }
            
        }
    });
    
    public void restartTypeForScientific() {
        
        lowerResult.setText("");
        
    }
    
    // --------------------------------------------- SCIENTIFIC CALCULATOR --------------------------------------------- (END)
    
    // ---------------------------------------------------- HISTORY ---------------------------------------------------- (START)
    
    JButton showHistoryButton = new JButton(new AbstractAction("H") {
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            /*
            BUG - Habang normal calcu then history, tapos biglang scientific, may bug.
            [1] 
            */
            
            if(showHistory) {   // Return Back To Normal
                giveWayToTheHistoryPanel();
                
                if(scientificCalculatorON) {
                    mainFrame.setSize(710, 660);
                    upperResult.setBounds(480, 75, 160, 40);
                    lowerResult.setBounds(60, 120, 580, 80);
                } else {
                    mainFrame.setSize(420, 660);
                    upperResult.setBounds(200, 75, 160, 40);
                    lowerResult.setBounds(60, 120, 300, 80);
                }
                
                historyPanel.setVisible(false);
                showHistory = false;
            } else {
                giveWayToTheHistoryPanel();
                
                if(scientificCalculatorON) {
                    mainFrame.setSize(960, 660);
                    upperResult.setBounds(480 + 250, 75, 160, 40);
                    lowerResult.setBounds(60 + 250, 120, 580, 80);
                } else {
                    mainFrame.setSize(670, 660);
                    upperResult.setBounds(200 + 250, 75, 160, 40);
                    lowerResult.setBounds(60 + 250, 120, 300, 80);
                }
                
                historyPanel.setVisible(true);
                showHistory = true;
            }
            
        }
    });
    
    public void giveWayToTheHistoryPanel() {
        
        if(showHistory) { // Return Back To Normal
            
            int addToXBound = 0;

            button0.setBounds(60 + addToXBound, 520, 70, 70); button5.setBounds(135 + addToXBound, 370, 70, 70);
            button1.setBounds(60 + addToXBound, 445, 70, 70); button6.setBounds(210 + addToXBound, 370, 70, 70);
            button2.setBounds(135 + addToXBound, 445, 70, 70); button7.setBounds(60 + addToXBound, 295, 70, 70);
            button3.setBounds(210 + addToXBound, 445, 70, 70); button8.setBounds(135 + addToXBound, 295, 70, 70);
            button4.setBounds(60 + addToXBound, 370, 70, 70); button9.setBounds(210 + addToXBound, 295, 70, 70);

            dotButton.setBounds(135 + addToXBound, 520, 70, 70);
            acButton.setBounds(60 + addToXBound, 220, 70, 70);
            positiveOrNegativeButton.setBounds(135 + addToXBound, 220, 70, 70);
            backSpaceButton.setBounds(210 + addToXBound, 220, 70, 70);
            equalButton.setBounds(210 + addToXBound, 520, 145, 70);
            additionButton.setBounds(285 + addToXBound, 445, 70, 70);
            substractionButton.setBounds(285 + addToXBound, 370, 70, 70);
            multiplicationButton.setBounds(285 + addToXBound, 295, 70, 70);
            divisionButton.setBounds(285 + addToXBound, 220, 70, 70);

            sinButton.setBounds(420 + addToXBound, 220, 70, 70);
            cosButton.setBounds(495 + addToXBound, 220, 70, 70);
            tanButton.setBounds(570 + addToXBound, 220, 70, 70);

            maxButton.setBounds(420 + addToXBound, 295, 70, 70);
            minButton.setBounds(495 + addToXBound, 295, 70, 70);
            sqrtButton.setBounds(570 + addToXBound, 295, 70, 70);

            absButton.setBounds(420 + addToXBound, 370, 70, 70);
            logButton.setBounds(495 + addToXBound, 370, 70, 70);
            seperatorButton.setBounds(570 + addToXBound, 370, 70, 70);

            degreesToRadianButton.setBounds(420 + addToXBound, 445, 70, 70);
            radianToDegreesButton.setBounds(495 + addToXBound, 445, 70, 70);
            
        } else {
            
            int addToXBound = 250;

            button0.setBounds(60 + addToXBound, 520, 70, 70); button5.setBounds(135 + addToXBound, 370, 70, 70);
            button1.setBounds(60 + addToXBound, 445, 70, 70); button6.setBounds(210 + addToXBound, 370, 70, 70);
            button2.setBounds(135 + addToXBound, 445, 70, 70); button7.setBounds(60 + addToXBound, 295, 70, 70);
            button3.setBounds(210 + addToXBound, 445, 70, 70); button8.setBounds(135 + addToXBound, 295, 70, 70);
            button4.setBounds(60 + addToXBound, 370, 70, 70); button9.setBounds(210 + addToXBound, 295, 70, 70);

            dotButton.setBounds(135 + addToXBound, 520, 70, 70);
            acButton.setBounds(60 + addToXBound, 220, 70, 70);
            positiveOrNegativeButton.setBounds(135 + addToXBound, 220, 70, 70);
            backSpaceButton.setBounds(210 + addToXBound, 220, 70, 70);
            equalButton.setBounds(210 + addToXBound, 520, 145, 70);
            additionButton.setBounds(285 + addToXBound, 445, 70, 70);
            substractionButton.setBounds(285 + addToXBound, 370, 70, 70);
            multiplicationButton.setBounds(285 + addToXBound, 295, 70, 70);
            divisionButton.setBounds(285 + addToXBound, 220, 70, 70);

            sinButton.setBounds(420 + addToXBound, 220, 70, 70);
            cosButton.setBounds(495 + addToXBound, 220, 70, 70);
            tanButton.setBounds(570 + addToXBound, 220, 70, 70);

            maxButton.setBounds(420 + addToXBound, 295, 70, 70);
            minButton.setBounds(495 + addToXBound, 295, 70, 70);
            sqrtButton.setBounds(570 + addToXBound, 295, 70, 70);

            absButton.setBounds(420 + addToXBound, 370, 70, 70);
            logButton.setBounds(495 + addToXBound, 370, 70, 70);
            seperatorButton.setBounds(570 + addToXBound, 370, 70, 70);

            degreesToRadianButton.setBounds(420 + addToXBound, 445, 70, 70);
            radianToDegreesButton.setBounds(495 + addToXBound, 445, 70, 70);
            
        }
        
    }
    
    // ---------------------------------------------------- HISTORY ---------------------------------------------------- (END)
    
    public static void main(String[] args) {
        
        new Calculator();
        
    }
}