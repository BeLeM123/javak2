import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.util.Objects;

public class superpaint extends Applet implements ActionListener, MouseMotionListener, MouseListener {
    private int last_x, last_y, last_x1, last_y1;
    Button red,white,blue,black,yellow,green,purple,cyan,orange,gray,getrekt,oval,line, fgetrekt, foval, clear;
    Color c;
    int act, pen1;
    private List spisok;

    public void init() {

        spisok = new List(4, false);
        spisok.add("1");
        spisok.add("5");
        spisok.add("10");
        spisok.add("20");

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
        fgetrekt = new Button("frect");
        foval = new Button("fellips");
        line = new Button("line");
        clear = new Button("clear");

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
        fgetrekt.setBounds(10,300,40,40);
        foval.setBounds(55,300,40,40);
        clear.setBounds(10,340,85,40);
        spisok.setBounds(100,10,20,65);

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
        add(fgetrekt);
        add(foval);
        add(line);
        add(clear);
        add(spisok);

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
        fgetrekt.addActionListener(this);
        foval.addActionListener(this);
        line.addActionListener(this);
        clear.addActionListener(this);

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
        pen1 = Integer.parseInt(spisok.getItem(spisok.getSelectedIndex()));
        if (act==1)
        {
            if(Objects.equals(spisok.getItem(spisok.getSelectedIndex()), "1"))
            {
                int x,y;
                x = me.getX();
                y = me.getY();
                Graphics2D g = (Graphics2D) this.getGraphics();
                g.setStroke(new BasicStroke(pen1));
                g.setColor(c);
                g.draw(new Line2D.Float(last_x, last_y, x, y));
                last_x = x;
                last_y = y;
            }
            if(Objects.equals(spisok.getItem(spisok.getSelectedIndex()), "5"))
            {
                int x,y;
                x = me.getX();
                y = me.getY();
                Graphics2D g = (Graphics2D) this.getGraphics();
                g.setStroke(new BasicStroke(pen1));
                g.setColor(c);
                g.draw(new Line2D.Float(last_x, last_y, x, y));
                last_x = x;
                last_y = y;
            }
            if(Objects.equals(spisok.getItem(spisok.getSelectedIndex()), "10"))
            {
                int x,y;
                x = me.getX();
                y = me.getY();
                Graphics2D g = (Graphics2D) this.getGraphics();
                g.setStroke(new BasicStroke(pen1));
                g.setColor(c);
                g.draw(new Line2D.Float(last_x, last_y, x, y));
                last_x = x;
                last_y = y;
            }
            if(Objects.equals(spisok.getItem(spisok.getSelectedIndex()), "20"))
            {
                int x,y;
                x = me.getX();
                y = me.getY();
                Graphics2D g = (Graphics2D) this.getGraphics();
                g.setStroke(new BasicStroke(pen1));
                g.setColor(c);
                g.draw(new Line2D.Float(last_x, last_y, x, y));
                last_x = x;
                last_y = y;
            }
        }
    }

    public void mouseMoved(MouseEvent me) {}
    public void mouseExited(MouseEvent me){}
    public void mouseReleased(MouseEvent me){
        last_x1 = me.getX();
        last_y1 = me.getY();
        if (act==2) {
            Graphics2D g = (Graphics2D) this.getGraphics();
            g.setStroke(new BasicStroke(pen1));
            g.setColor(c);
            g.drawRect(last_x, last_y, last_x1 - last_x, last_y1 - last_y);
        }
        else if (act==3) {
            Graphics2D g = (Graphics2D) this.getGraphics();
            g.setStroke(new BasicStroke(pen1));
            g.setColor(c);
            g.drawOval(last_x, last_y, last_x1 - last_x, last_y1 - last_y);
        }
        else if (act==5) {
            Graphics g = getGraphics();
            g.setColor(c);
            g.fillOval(last_x, last_y, last_x1 - last_x, last_y1 - last_y);
        }
        else if (act==4) {
            Graphics g = getGraphics();
            g.setColor(c);
            g.fillRect(last_x, last_y, last_x1 - last_x, last_y1 - last_y);
        }
    }
    public void mouseEntered(MouseEvent me){}
    public void mousePressed(MouseEvent me){
        last_x = me.getX();
        last_y = me.getY();
    }

    public void mouseClicked(MouseEvent me) {}

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();
        c = ((Button) ae.getSource()).getBackground();
        if (((Button) ae.getSource()).getLabel().equals("line"))
            act=1;
        else if (((Button) ae.getSource()).getLabel().equals("rect"))
            act=2;
        else if (((Button) ae.getSource()).getLabel().equals("ellips"))
            act=3;
        else if (((Button) ae.getSource()).getLabel().equals("frect"))
            act=4;
        else if (((Button) ae.getSource()).getLabel().equals("fellips"))
            act=5;
        else if (str.equals("clear"))
        {
            repaint();
        }
    }
}
