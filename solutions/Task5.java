package solutions;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.Timer;

public class Task5 extends JFrame {
	private static final long serialVersionUID = -5415745435725509207L;

	private PriorityQueue<Customer> queue = new PriorityQueue<>();
	private int passedMinutes = 0;

	private JTextField nameField = new JTextField();
	private JTextField minutesField = new JTextField();
	private JButton submitButton = new JButton("Submit");

	public Task5() {
		nameField.setBorder(BorderFactory.createTitledBorder("Name"));
		minutesField.setBorder(BorderFactory.createTitledBorder("Minutes"));
		submitButton.addActionListener(new Action());

		setLayout(new GridLayout(3, 1));
		add(nameField);
		add(minutesField);
		add(submitButton);

		Timer t = new Timer(1000, new Action());
		t.start();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 200);
		setLocationRelativeTo(null);
		setTitle("Enter customer");
		setVisible(true);
	}

	public static void main(String[] args) {
		new Task5();
	}

	private class Customer implements Comparable<Customer> {
		String name;
		int time;

		public Customer(String name, int time) {
			this.name = name;
			this.time = time;
		}

		@Override
		public int compareTo(Customer c) {
			return this.time - c.time;
		}
	}

	private class Action implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == submitButton) {
				try {
					queue.add(new Customer(nameField.getText(), passedMinutes
							+ Integer.parseInt(minutesField.getText())));
				} catch (NumberFormatException ex) {
					System.out.println("Wrong time specified!");
					return;
				}
			} else {
				// Timer does this
				passedMinutes++;

				while (!queue.isEmpty() && queue.peek().time == passedMinutes) {
					System.out.println(queue.poll().name + " is out!");
				}
			}
		}

	}

}
