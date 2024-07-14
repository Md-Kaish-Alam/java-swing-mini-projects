import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPFinderApplication extends JFrame implements ActionListener {

    JLabel promptLabel;
    JTextField urlTextField;
    JButton findIPButton;

    IPFinderApplication() {
        super("IP Address Finder Application");

        promptLabel = new JLabel("Enter URL:");
        urlTextField = new JTextField(20);
        findIPButton = new JButton("Find IP Address");
        findIPButton.addActionListener(this);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around components

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(promptLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(urlTextField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        add(findIPButton, gbc);

        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame on the screen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String url = urlTextField.getText();

        try {
            InetAddress inetAddress = InetAddress.getByName(url);
            String ipAddress = inetAddress.getHostAddress();
            JOptionPane.showMessageDialog(this, ipAddress);
        } catch (UnknownHostException exception) {
            JOptionPane.showMessageDialog(this, exception.toString());
        }
    }

    public static void main(String[] args) {
        new IPFinderApplication();
    }
}
