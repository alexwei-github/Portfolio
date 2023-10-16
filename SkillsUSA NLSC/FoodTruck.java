import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @desc A program that allows the customer to choose the items and quantity they would like to purchase from a food truck
 */
public class FoodTruck implements ActionListener{

    double cost = 0;
    JLabel totalCost = new JLabel("Total Cost: 0");
    JPanel panel;
    JFrame frame;
    JCheckBox hotdog;
    JCheckBox pizza;
    JCheckBox hamburger;
    JCheckBox fries;
    JCheckBox soda;
    JCheckBox water;
    JButton order;
    JButton clear;
    JButton exit;
    JTextField hotdogNum;
    JTextField pizzaNum;
    JTextField hamburgerNum;
    JTextField friesNum;
    JTextField sodaNum;
    JTextField waterNum;

    public static void main(String[] args) {
        FoodTruck foodTruck = new FoodTruck();
    }
    
    public FoodTruck(){
        frame = new JFrame();

        //creating buttons
        order = new JButton("Order");
        order.addActionListener(this);
        clear = new JButton("Clear");
        clear.addActionListener(this);
        exit = new JButton("Exit");
        exit.addActionListener(this);

        //creating food related interactables
        totalCost = new JLabel("Total Cost: $0.0");
        hotdog = new JCheckBox("Hot Dog $2.50");
        hotdogNum = new JTextField(1);
        pizza = new JCheckBox("Pizza Slice $3.50");
        pizzaNum = new JTextField(3);
        hamburger = new JCheckBox("Hamburger $5.00");
        hamburgerNum = new JTextField(3);
        fries = new JCheckBox("Fries $2.00");
        friesNum = new JTextField(3);
        soda = new JCheckBox("Soda $2.00");
        sodaNum = new JTextField(3);
        water = new JCheckBox("Water $1.00");
        waterNum = new JTextField(3);

        //panel set up (adding all interactable elements to gui)
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100,100,10,100));
        panel.setLayout(new GridLayout(0,1));
        panel.add(order);
        panel.add(clear);
        panel.add(hotdog);
        panel.add(hotdogNum);
        panel.add(pizza);
        panel.add(pizzaNum);
        panel.add(hamburger);
        panel.add(hamburgerNum);
        panel.add(fries);
        panel.add(friesNum);
        panel.add(soda);
        panel.add(sodaNum);
        panel.add(water);
        panel.add(waterNum);
        panel.add(totalCost);
        panel.add(exit);
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Food Truck");
        frame.pack();
        frame.setVisible(true);

    }

    //decides effects of each action
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //order button
        if (e.getSource() == order)
        {
            //adds cost by checking which foods were selected and muliplies the cost by the quantity requested
            cost = 0;
            if (hotdog.isSelected()){
                cost += 2.5 * Integer.parseInt(hotdogNum.getText());
            }
            if (pizza.isSelected()){
                cost += 3.5 * Integer.parseInt(pizzaNum.getText());
            }
            if (hamburger.isSelected()){
                cost += 5 * Integer.parseInt(hamburgerNum.getText());
            }
            if (fries.isSelected()){
                cost += 2 * Integer.parseInt(friesNum.getText());
            }
            if (soda.isSelected()){
                cost += 2 * Integer.parseInt(sodaNum.getText());
            }
            if (water.isSelected()){
                cost += 1 * Integer.parseInt(waterNum.getText());
            }

            totalCost.setText("Total Cost: $" + cost);
        }

        //clear button clears cost
        if (e.getSource() == clear){
            cost = 0;
            hotdog.setSelected(false);
            pizza.setSelected(false);
            hamburger.setSelected(false);
            fries.setSelected(false);
            soda.setSelected(false);
            water.setSelected(false);
            hotdogNum.setText(null);
            pizzaNum.setText(null);
            hamburgerNum.setText(null);
            friesNum.setText(null);
            sodaNum.setText(null);
            waterNum.setText(null);
            totalCost.setText("Total Cost: $" + cost);
        }
        //exit button closes gui
        if (e.getSource() == exit){
            frame.dispose();
        }
        
    }
}
