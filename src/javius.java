//import javax.swing.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.util.Objects;

public class javius extends Applet
implements ActionListener, AdjustmentListener, MouseMotionListener, MouseWheelListener, ItemListener, KeyListener, MouseListener {
    private String msg = "";
    private int x,y,w,h,x1,y1,w1,h1,mx,my,mx1,my1,last_x, last_y;
    Button Home, UP, DOWN, Left, Right, ChangeSize, Zoomp, Zoomm;
    private TextField name_TF, pass_TF, textx, texty, textw, texth;
    private Scrollbar vertSB, horzSB;
    private Checkbox razmer, tust;
    private List spisok;
    Color s,k,o;
    private boolean Accepted = false;
    public void init(){
        setBackground(new Color(20,100,100));
        s= Color.red;
        k= Color.red;
        o= Color.yellow;
        x=140;
        y=50;
        w=h=200;
        mx=w/10;
        my=h/10;

        x1=500;
        y1=50;
        w1=h1=100;
        mx1=w1/10;
        my1=h1/10;

        Label name_L = new Label("Name: ");
        Label pass_L = new Label("Password: ");
        Label textxl = new Label("x = ");
        Label textyl = new Label("y = ");
        Label textwl = new Label("w = ");
        Label texthl = new Label("h = ");

        textxl.setForeground(Color.yellow);
        textyl.setForeground(Color.yellow);
        textwl.setForeground(Color.yellow);
        texthl.setForeground(Color.yellow);

        spisok = new List(4, false);
        spisok.add("leftup");
        spisok.add("rightup");
        spisok.add("leftdown");
        spisok.add("rightdown");

        name_TF = new TextField(12);
        pass_TF = new TextField(8);
        pass_TF.setEchoChar('*');
        textx = new TextField(4);
        texty = new TextField(4);
        textw = new TextField(4);
        texth = new TextField(4);

        vertSB = new Scrollbar(Scrollbar.VERTICAL,0, 1, 0, this.getHeight()-h);
        horzSB = new Scrollbar(Scrollbar.HORIZONTAL,0, 1, 0, this.getWidth()-w);

        razmer = new Checkbox(null, true);
        tust = new Checkbox(null, true);

        Home = new Button("Home");
        UP = new Button("UP");
        DOWN = new Button("DOWN");
        Left = new Button("L");
        Right = new Button("R");
        Zoomp = new Button("Zoom+");
        Zoomm = new Button("Zoom-");
        ChangeSize = new Button("ChangeSize");
        setLayout(null);
        Home.setBounds(50,30,40,20);
        UP.setBounds(50,10,40,20);
        DOWN.setBounds(50,50,40,20);
        Left.setBounds(30,30,20,20);
        Right.setBounds(90,30,20,20);
        Zoomp.setBounds(30,80,80,20);
        Zoomm.setBounds(30,100,80,20);
        ChangeSize.setBounds(20,295,100,20);

        name_TF.setBounds(20, 135, 100, 20);
        pass_TF.setBounds(20, 170, 100, 20);
        textx.setBounds(20, 195, 100, 20);
        texty.setBounds(20, 220, 100, 20);
        textw.setBounds(20, 245, 100, 20);
        texth.setBounds(20, 270, 100, 20);
        textxl.setBounds(0, 195, 20, 20);
        textyl.setBounds(0, 220, 20, 20);
        textwl.setBounds(0, 245, 20, 20);
        texthl.setBounds(0, 270, 20, 20);

        vertSB.setBounds(this.getHeight()-20,0,20,this.getWidth());
        horzSB.setBounds(0,this.getWidth()-20,this.getHeight()-20,20);
        razmer.setBounds(100,5,14,13);
        tust.setBounds(120,5,14,13);

        spisok.setBounds(20,320,75,65);

        add(Home);
        add(UP);
        add(DOWN);
        add(Left);
        add(Right);
        add(Zoomp);
        add(Zoomm);
        add(ChangeSize);
        add(name_L);
        add(pass_L);
        add(textxl);
        add(textyl);
        add(textwl);
        add(texthl);
        add(name_TF);
        add(pass_TF);
        add(textx);
        add(texty);
        add(textw);
        add(texth);
        add(vertSB);
        add(horzSB);
        add(razmer);
        add(tust);
        add(spisok);

        Home.addActionListener(this);
        UP.addActionListener(this);
        DOWN.addActionListener(this);
        Left.addActionListener(this);
        Right.addActionListener(this);
        Zoomp.addActionListener(this);
        Zoomm.addActionListener(this);
        ChangeSize.addActionListener(this);

        vertSB.addAdjustmentListener(this);
        horzSB.addAdjustmentListener(this);
        razmer.addItemListener(this);
        tust.addItemListener(this);

        name_TF.addActionListener(this);
        pass_TF.addActionListener(this);
        textx.addActionListener(this);
        texty.addActionListener(this);
        textw.addActionListener(this);
        texth.addActionListener(this);

        addMouseWheelListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);

        Home.addKeyListener(this);
        UP.addKeyListener(this);
        DOWN.addKeyListener(this);
        Left.addKeyListener(this);
        Right.addKeyListener(this);
        Zoomp.addKeyListener(this);
        Zoomm.addKeyListener(this);
        ChangeSize.addKeyListener(this);
        vertSB.addKeyListener(this);
        horzSB.addKeyListener(this);
        razmer.addKeyListener(this);
        tust.addKeyListener(this);
        name_TF.addKeyListener(this);
        pass_TF.addKeyListener(this);
        textx.addKeyListener(this);
        texty.addKeyListener(this);
        textw.addKeyListener(this);
        texth.addKeyListener(this);

        addKeyListener(this);
        requestFocus();
    }

    public void paint(Graphics g) {
        g.drawString(msg, 120, 30);
       /* x=110;
        y=50;
        w=h=200;
        mx=w/10;
        my=h/10;*/
        //g.drawRect(x, y, w, h);
        //g.drawRect(x1, y1, w1, h1);
        g.setColor(Color.red);
		/*g.setFont(new Font("dialog", Font.BOLD, 34));
		g.drawString("Hello Java", 100, 100);*/
        g.fillOval(x, y+4*my, w, 4*my);
        if (Accepted)/*(Accepted == true)*/ {
            g.setColor(Color.green);
            g.fillArc(x+3*mx, y, 4*mx, h-5, 0, 180);
        }
        else {
            g.setColor(Color.red);
            g.fillArc(x+3*mx, y, 4*mx, h-5, 0, 180);
        }
        g.setColor(Color.yellow);
        g.fillOval(x+mx, y+5*my, mx, my);
        g.fillOval(x+2*mx, y+6*my, mx, my);
        g.fillOval(x+4*mx, y+6*my, 2*mx, my);
        g.fillOval(x+7*mx, y+6*my, mx, my);
        g.fillOval(x+8*mx, y+5*my, mx, my);
       /* g.setColor(Color.green);
        g.drawLine(x+2*mx, y+5*my, mx, h-my);
        g.drawLine(x+8*mx, y+5*my, 9*mx, h-my);*/
        g.setColor(s);
        g.fillOval(x1, y1+4*my1, w1, 4*my1);
        g.setColor(k);
        g.fillArc(x1+3*mx1, y1, 4*mx1, h1-5, 0, 180);
        g.setColor(o);
        g.fillOval(x1+mx1, y1+5*my1, mx1, my1);
        g.fillOval(x1+2*mx1, y1+6*my1, mx1, my1);
        g.fillOval(x1+4*mx1, y1+6*my1, 2*mx1, my1);
        g.fillOval(x1+7*mx1, y1+6*my1, mx1, my1);
        g.fillOval(x1+8*mx1, y1+5*my1, mx1, my1);
        g.setColor(Color.yellow);
        g.drawString("Text in name:   " + name_TF.getText(), 20, 133);
        g.drawString("Password:   " + pass_TF.getText(), 20, 167);

        msg = "Vertical: " + vertSB.getValue();
        msg += ",  Horizontal: " + horzSB.getValue();

        // show current mouse drag position
        vertSB.setBounds(this.getWidth()-20,0,20,this.getHeight());
        horzSB.setBounds(0,this.getHeight()-20,this.getWidth()-20,20);

        if(Objects.equals(spisok.getItem(spisok.getSelectedIndex()), "leftup"))
        {
            g.setColor((new Color(20,100,100)));
            g.fillRect(x+w/2, y, w, h);
            g.fillRect(x, y+h/2, w, h);
        }
        if(Objects.equals(spisok.getItem(spisok.getSelectedIndex()), "rightup"))
        {
            g.setColor((new Color(20,100,100)));
            g.fillRect(x-w/2, y, w, h);
            g.fillRect(x, y+h/2, w, h);
        }
        if(Objects.equals(spisok.getItem(spisok.getSelectedIndex()), "leftdown"))
        {
            g.setColor((new Color(20,100,100)));
            g.fillRect(x+w/2, y, w, h);
            g.fillRect(x, y-h/2, w, h);
        }
        if(Objects.equals(spisok.getItem(spisok.getSelectedIndex()), "rightdown"))
        {
            g.setColor((new Color(20,100,100)));
            g.fillRect(x-w/2, y, w, h);
            g.fillRect(x, y-h/2, w, h);
        }
        
    }

    private void move(String m)
    {
        if (m.equals("UP"))
        {
            if((y >= 10 && x>=140) || (y >= 200 && x <=130))
                y -= 10;
        }
        else if (m.equals("DOWN"))
        {
            if(y <= this.getHeight() - h){
                y += 10;
            }
        }
        else if (m.equals("L"))
        {
            //if((x >= 140 || y>=250) || (x >= 10 || y>=250))
            if (x >= 10 && y >= 200)
                x -= 10;
            else if (x >= 140)
                x -= 10;
        }
        else if (m.equals("R"))
        {
            if(x <= this.getWidth() - w)
                x += 10;
        }
        else if (m.equals("Home"))
        {
            x=140;
            y=50;
        }
        else if (m.equals("Zoom+"))
        {
            w=h += 10;
            mx = w/10;
            my = h/10;
        }
        else if (m.equals("Zoom-"))
        {
            if (w >= 40) {
                w = h -= 10;
                mx = w / 10;
                my = h / 10;
            }
        }
    }

    public void adjustmentValueChanged(AdjustmentEvent ae) {
        if (razmer.getState())
        {
            x = horzSB.getValue();
            y = vertSB.getValue();
        }
        else{
            w = vertSB.getValue();
            if(w < 20) w = 20;
            h = horzSB.getValue();
            if(h < 20) h = 20;
            mx = w / 10;
            my = h / 10;
        }
        repaint();
    }

    public void mouseDragged(MouseEvent me) {
        if (tust.getState())
        {
            if (me.getX()>130 && me.getY()>0 && me.getX() < this.getWidth()-w && me.getY() < this.getHeight()-h)
            {
            x = me.getX();
            y = me.getY();
            vertSB.setValue(y);
            horzSB.setValue(x);
            }
            repaint();
        }
        else
        {
            x = me.getX();
            y = me.getY();
            Graphics g = this.getGraphics();
            g.setColor(Color.red);
            g.drawLine(last_x, last_y, x, y);
            last_x = x; last_y = y;
        }
    }

    public void mouseMoved(MouseEvent me) {}
    public void mouseExited(MouseEvent me){}
    public void mouseReleased(MouseEvent me){}
    public void mouseEntered(MouseEvent me){}
    public void mousePressed(MouseEvent me){
        last_x = me.getX();
        last_y = me.getY();

    }

    public void mouseClicked(MouseEvent me) {
        if (me.getButton() == MouseEvent.BUTTON2)
        {
            x=140;
            y=50;
            w=h=200;
            mx=w/10;
            my=h/10;
        }
        repaint();
    }

    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getWheelRotation()<0)
        {
            w=h += 10;
            mx = w/10;
            my = h/10;
        }
        else
        if(w >= 50)
        {
            w = h -= 10;
            mx = w / 10;
            my = h / 10;
        }
        repaint();
    }

    public void itemStateChanged(ItemEvent ie) {
        //repaint();
    }


    public void keyPressed(KeyEvent ke) {

        if (ke.getKeyCode() == KeyEvent.VK_NUMPAD8)
        {
            if((y >= 10 && x>=140) || (y >= 400 && x <=130))
                y -= 10;
        }
        if (ke.getKeyCode() == KeyEvent.VK_NUMPAD2)
        {
            if(y <= this.getHeight() - h)
                y += 10;
        }
        if (ke.getKeyCode() == KeyEvent.VK_NUMPAD4)
        {
            if (x >= 10 && y >= 350)
                x -= 10;
            else if (x >= 130)
                x -= 10;
        }
        if (ke.getKeyCode() == KeyEvent.VK_NUMPAD6)
        {
            if(x <= this.getWidth() - w)
                x += 10;
        }
        if (ke.getKeyCode() == KeyEvent.VK_ADD)
        {
            w=h += 10;
            mx = w/10;
            my = h/10;
        }
        if (ke.getKeyCode() == KeyEvent.VK_SUBTRACT)
        {
            if(w >= 50)
            {
                w = h -= 10;
                mx = w / 10;
                my = h / 10;
            }
        }
        if (ke.getKeyCode() == KeyEvent.VK_NUMPAD5)
        {
            x=140;
            y=50;
            w=h=200;
            mx=w/10;
            my=h/10;
        }
        if (ke.getKeyCode() == KeyEvent.VK_UP)
        {
            if((y1 >= 10 && x1>=140) || (y1 >= 400 && x1 <=130))
                y1 -= 10;
        }
        if (ke.getKeyCode() == KeyEvent.VK_DOWN)
        {
            if(y1 <= this.getHeight() - h1)
                y1 += 10;
        }
        if (ke.getKeyCode() == KeyEvent.VK_LEFT)
        {
            if (x1 >= 10 && y1 >= 350)
                x1 -= 10;
            else if (x1 >= 130)
                x1 -= 10;
        }
        if (ke.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            if(x1 <= this.getWidth() - w1)
                x1 += 10;
        }
        if( ((x1 >= x && x1 <= x + w - 1) && (y1 >= y && y1 <= y + 8 * my - 1)) ||
            ((x1 + w / 2 >= x + 1 && x1 + w / 2 <= x + w - 1) && (y1 >= y && y1 <= y + 8 * my - 1)) ||
            ((x1 >= x + 1 && x1 <= x + w - 1) && (y1 + h / 2 >= y + 1 && y1 + h / 2 <= y + 8 * my - 1)) ||
            ((x1 + w / 2 >= x + 1 && x1 + w / 2 <= x + w - 1) && (y1 + h / 2 >= y + 1 && y1 + h / 2 <= y + 8 * my - 1))) {
            s = Color.red;
            k = Color.red;
            o = Color.yellow;
        }
        else
        {
            s = Color.red;
            k = Color.red;
            o = Color.blue;
        }
        repaint();







    }

    public void keyReleased(KeyEvent ke) {
        //showStatus("Key Up");
    }

    public void keyTyped(KeyEvent ke) {
        //msg += ke.getKeyChar();
        //repaint();
    }

    public void actionPerformed(ActionEvent ae) {
        String str = ae.getActionCommand();
        /*if(str.equals("Home")) {
            msg = "You pressed Home.";
        }
        else if(str.equals("UP")) {
            msg = "You pressed UP.";
        }
        else if(str.equals("DOWN")) {
            msg = "You pressed DOWN.";
        }
        else if(str.equals("L")) {
            msg = "You pressed Left.";
        }
        else if(str.equals("R")) {
            msg = "You pressed Right.";
        }
        else if(str.equals("Zoom+")) {
            msg = "You pressed Zoom+.";
        }
        else{
            msg = "You pressed Zoom-.";
        }*/
        if (name_TF.getText().equals("test") && pass_TF.getText().equals("admin"))
        {
            Accepted = true;
        }
        else
        {
            Accepted = false;
            x=140;
            y=50;
            w=h=200;
        }
        if(str.equals("ChangeSize"))
        {
            String xx = textx.getText();
            String yy = texty.getText();
            String ww = textw.getText();
            String hh = texth.getText();
            x = Integer.parseInt(xx);
            if (x < 0) x=0;
            if (x > this.getWidth()-w) x = this.getWidth()-w;
            y = Integer.parseInt(yy);
            if (y < 0) y=0;
            if (y > this.getHeight()-h) y = this.getHeight()-h;
            w = Integer.parseInt(ww);
            if (w < 40) w=40;
            h = Integer.parseInt(hh);
            if (h < 40) h=40;
            mx = w / 10;
            my = h / 10;
        }
        move(str);
        repaint();
    }
}
