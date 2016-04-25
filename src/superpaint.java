import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class superpaint extends Applet implements ActionListener, MouseMotionListener, MouseListener {
    private int last_x, last_y, last_x1, last_y1;
    Button red,white,blue,black,yellow,green,purple,cyan,orange,gray,getrekt,oval,line;
    Color c;
    int act;

    public void init() {
        act = 1;
        setBackground(new Color(20,100,100));
        c=Color.red;
        red = new Button("");
        white = new Button("");
        blue = new Button("");
        black = new Button("");
        yellow = new Button("");
        green = new Button("");
        purple = new Button("");
        cyan = new Button("");
        orange = new Button("");
        gray = new Button("");
        getrekt = new Button("rect");
        oval = new Button("ellips");
        line = new Button("line");

        setLayout(null);
        white.setBounds(10,10,40,40);
        black.setBounds(55,10,40,40);
        gray.setBounds(10,55,40,40);
        red.setBounds(55,55,40,40);
        yellow.setBounds(10,100,40,40);
        orange.setBounds(55,100,40,40);
        blue.setBounds(10,145,40,40);
        cyan.setBounds(55,145,40,40);
        purple.setBounds(10,195,40,40);
        green.setBounds(55,195,40,40);
        getrekt.setBounds(10,240,40,40);
        oval.setBounds(55,240,40,40);
        line.setBounds(10,280,85,20);

        add(red);
        add(white);
        add(blue);
        add(black);
        add(yellow);
        add(green);
        add(purple);
        add(cyan);
        add(orange);
        add(gray);
        add(getrekt);
        add(oval);
        add(line);

        red.addActionListener(this);
        white.addActionListener(this);
        blue.addActionListener(this);
        black.addActionListener(this);
        yellow.addActionListener(this);
        green.addActionListener(this);
        purple.addActionListener(this);
        cyan.addActionListener(this);
        orange.addActionListener(this);
        gray.addActionListener(this);
        getrekt.addActionListener(this);
        oval.addActionListener(this);
        line.addActionListener(this);

        red.setBackground(Color.red);
        white.setBackground(Color.white);
        blue.setBackground(Color.blue);
        black.setBackground(Color.black);
        yellow.setBackground(Color.yellow);
        green.setBackground(Color.green);
        purple.setBackground(Color.magenta);
        cyan.setBackground(Color.cyan);
        orange.setBackground(Color.orange);
        gray.setBackground(Color.gray);

        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void paint(Graphics g) {}

    public void mouseDragged(MouseEvent me) {
        if (act==1)
        {
            int x,y;
            x = me.getX();
            y = me.getY();
                Graphics g = this.getGraphics();
                g.setColor(c);
                g.drawLine(last_x, last_y, x, y);
                last_x = x;
                last_y = y;
            }
    }

    public void mouseMoved(MouseEvent me) {}
    public void mouseExited(MouseEvent me){}
    public void mouseReleased(MouseEvent me){
        last_x1 = me.getX();
        last_y1 = me.getY();
        if (act==2) {
        Graphics g = getGraphics();
        g.setColor(c);
        g.drawRect(last_x, last_y, last_x1 - last_x, last_y1 - last_y);
        }
        else if (act==3) {
            Graphics g = getGraphics();
            g.setColor(c);
            g.drawOval(last_x, last_y, last_x1 - last_x, last_y1 - last_y);
        }
    }
    public void mouseEntered(MouseEvent me){}
    public void mousePressed(MouseEvent me){
        last_x = me.getX();
        last_y = me.getY();
    }

    public void mouseClicked(MouseEvent me) {}

    public void actionPerformed(ActionEvent ae) {
        c = ((Button) ae.getSource()).getBackground();
        if (((Button) ae.getSource()).getLabel().equals("line"))
            act=1;
        else if (((Button) ae.getSource()).getLabel().equals("rect"))
            act=2;
        else if (((Button) ae.getSource()).getLabel().equals("ellips"))
            act=3;
    }
}