import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;
import javax.swing.*;

//JFrame works like the main window where components like Jpanel,labels, buttons, textfields are added to create a GUI.
//Jpanel provides space in which an application can attach any other component
public class myPanel extends JPanel implements ActionListener, MouseListener{
    private final static int PANEL_WIDTH = 300;
    private final static int PANEL_HEIGHT = 100;
    private JButton pressed,box;

    //private Scanner sc;

    public myPanel(){
        super();//calling the JPanel constructor
        setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        pressed = new JButton("Person");
        box = new JButton("Customer");
        //this.add(pressed);//
        this.add(pressed);
        this.add(box);
        pressed.addActionListener(this);//passing current instance
        box.addActionListener(this);//passing current instance
        this.addMouseListener(this);//passing current instance
    }


    //he actionPerformed() method is invoked automatically whenever you click on the registered component or button.
    @Override
    public void actionPerformed(ActionEvent e){
        CSV cr = new CSV();
        if(e.getSource() == pressed){// e is an event and e.getsource() tells what event is being triggered
            System.out.println(cr.getData());
        }
        else if(e.getSource() == box){
            System.out.println(cr.getData1());
        }
    }
    //these all were the abstract method inside mouselistener interface and here we are basically implementing them
    @Override
    public void mouseClicked(MouseEvent e){
        System.out.println("position of X axis: "+e.getX()+" and Position of Y axis: "+e.getY());
    }
    @Override
    public void mousePressed(MouseEvent e){
        System.out.println("Mouse pressed"+e.getClickCount());
    }
    @Override
    public void mouseReleased(MouseEvent e){
        System.out.println("Mouse released"+e.getClickCount());
    }
    @Override
    public void mouseEntered(MouseEvent e){
        System.out.println("Mouse entered");
    }
    @Override
    public void mouseExited(MouseEvent e){
        System.out.println("Mouse Exit");
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();//It constructs a new frame that is initially invisible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//The exit application default window close operation.

        myPanel panel = new myPanel();
        frame.add(panel); // adding the Component to main frame
        frame.pack();

        //used to bind various components inside a frame
        Toolkit tk = Toolkit.getDefaultToolkit();//Toolkit.getDefaultToolkit() is a static method
        Dimension d = tk.getScreenSize();
        int screenHeight = d.height;
        int screenWidth  = d.width;

        frame.setLocation(new Point((screenWidth/2)-(frame.getWidth()/2),(screenHeight/2)-(frame.getHeight()/2)));
//        frame.setLocation(new Point(400,400));
        frame.setVisible(true);//It makes the frame component visible or invisible
    }

}