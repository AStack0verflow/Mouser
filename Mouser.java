import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JFrame;
import java.lang.Process;
//imports for the LeapMotion and Synthesizer
import java.io.IOException;
import java.lang.Math;
import com.leapmotion.leap.*;
//Other various Java Libraries

import java.util.*;
import java.io.IOException;
import java.lang.Object;
import java.awt.Rectangle;  //To create the rectangle kays
import java.awt.Dimension;  //To get the screen dimensions

/**This applet is for a user to interface with the LeapMotion sensor
 * the user clicks 'Start' and can play the piano if they so choose
 *
 * author: Everett Williams & Michael Malocha
 * date created: 2-4-13
 * date modified: 2-11-13
 */

public class Mouser extends JApplet
{
    public static void main(String[] args) {
        EventQueue.invokeLater(
                               new Runnable()
                               {
            public void run()
            {
                CalibrateFrame mainFrame = new CalibrateFrame();
                mainFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
                mainFrame.setVisible(true);
            }
        });
        // Create a sample listener and controller
        CalibrateFrame.LeapListener listener = new CalibrateFrame.LeapListener();
        Controller controller = new Controller();
        //controller.enableGesture(Gesture.ScreenTapGesture);
        
        // Have the sample listener receive events from the controller
        controller.addListener(listener);
        
        // Keep this process running until Enter is pressed
        System.out.println("Press Enter to quit...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Remove the sample listener when done
        controller.removeListener(listener);
    }
}



/**
 *
 * @author Everett Williams
 * This is the Frame for helping calibrate the Leap
 */
class CalibrateFrame extends javax.swing.JFrame {

    /**
     * Creates new form Calibrate
     */
    public CalibrateFrame() {
        javax.swing.Timer cursorTimer = new javax.swing.Timer(10, new CursorMover());
        cursorTimer.start();
        javax.swing.Timer pointTimer = new javax.swing.Timer(10, new TextAction());
        pointTimer.start();
        System.out.println("The timer has started");
        
        this.setTitle("Mouser");
        this.setSize(600, 150);

        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        
        jText1 = new JTextField(10);
        jText2 = new JTextField(10);
        jText3 = new JTextField(10);
        jText4 = new JTextField(10);
        jText5 = new JTextField(10);
        jText6 = new JTextField(10);
        jText7 = new JTextField(10);
        jText8 = new JTextField(10);
        
        jText1.setPreferredSize(new Dimension(50,20));
        jText2.setPreferredSize(new Dimension(50,20));
        jText3.setPreferredSize(new Dimension(50,20));
        jText4.setPreferredSize(new Dimension(50,20));
        jText5.setPreferredSize(new Dimension(50,20));
        jText6.setPreferredSize(new Dimension(50,20));
        jText7.setPreferredSize(new Dimension(50,20));
        jText8.setPreferredSize(new Dimension(50,20));

        
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelWaste1 = new javax.swing.JLabel();
        jLabelWaste2 = new javax.swing.JLabel();
        jLabelWaste2.setPreferredSize(new Dimension(35,20));
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        jLabel1.setText("Center:      ");
        jLabel3.setText(" Number of Fingers:        ");
        jLabel2.setText("Bottem Left: ");
        jLabel4.setText("Bottem Right:   ");
        jLabel5.setText("Your Coordanates  ");
        jLabel6.setText("X:  ");
        jLabel7.setText("Y:  ");
        jLabel8.setText("Z:  ");
        jButton1.setText(" Done ");
        jButton2.setText("Cancel");
        
        jLabelWaste1.setText("        ");
        jLabelWaste2.setText("        ");
        
        jScrollPane6.setViewportView(jText5);
        jText5.setEditable(false);
        
        jScrollPane7.setViewportView(jText6);
        jText6.setEditable(false);
        
        jScrollPane8.setViewportView(jText7);
        jText7.setEditable(false);
        
        jScrollPane4.setViewportView(jText3);
        jText3.setEditable(false);
        
        jScrollPane2.setViewportView(jText1);
        jText1.setEditable(false);
        
        jScrollPane3.setViewportView(jText2);
        jText2.setEditable(false);
        
        jScrollPane5.setViewportView(jText4);
        jText4.setEditable(false);
        
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        
        // End of the Button/Label/Text Fields
        
        this.setLayout(new BorderLayout());
        //JPanel topRowPanel = new JPanel();
        // Create the Panels that All GUI items will go on
        
        JPanel CaliPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel CaliTopPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel CaliBottemPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel CoorPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel ButtonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // The First/ Top Row of the Frame. Top Left and Right
        
        Box topRowBox = Box.createHorizontalBox();
        topRowBox.add(Box.createHorizontalGlue());
        topRowBox.add(jLabel1);
        topRowBox.add(Box.createHorizontalGlue());
        topRowBox.add(jText1);
        topRowBox.add(Box.createHorizontalGlue());
        topRowBox.add(jLabelWaste1);
        topRowBox.add(Box.createHorizontalGlue());
        topRowBox.add(jLabel3);
        topRowBox.add(Box.createHorizontalGlue());
        topRowBox.add(jText3);
        topRowBox.add(Box.createHorizontalGlue());
        topRowBox.add(jButton1);
        // now add the box to the North of the panel
        CaliTopPanel.add(topRowBox);
        
        // The Second/Middle Row of the Frame Bottem Left and Right
        Box middleRowBox = Box.createHorizontalBox();
        middleRowBox.add(Box.createHorizontalGlue());
        middleRowBox.add(jLabel2);
        middleRowBox.add(jText2);
        middleRowBox.add(jLabelWaste2);
        middleRowBox.add(jLabel4);
        middleRowBox.add(jText4);
        middleRowBox.add(jButton2);
        // now add the box to the South of the panel
        CaliBottemPanel.add(middleRowBox);
        
        //Displays the users X, Y, and Z Coordanates from their finger
        Box bottemRowBox = Box.createHorizontalBox();
        bottemRowBox.add(Box.createHorizontalGlue());
        bottemRowBox.add(jLabel5);
        bottemRowBox.add(jLabel6);
        bottemRowBox.add(jText5);
        //bottemRowBox.add(jLabelWaste2);
        bottemRowBox.add(jLabel7);
        bottemRowBox.add(jText6);
        bottemRowBox.add(Box.createHorizontalGlue());
        bottemRowBox.add(jLabel8);
        bottemRowBox.add(jText7);
        bottemRowBox.add(Box.createHorizontalGlue());
        // now add the box to the South of the panel
        CoorPanel.add(bottemRowBox);
        
        //Button Box
        Box eastColBox = Box.createVerticalBox();
        eastColBox.add(jButton1);
        eastColBox.add(jButton2);
        ButtonPanel.add(eastColBox);
        
        CaliPanel.add(CaliTopPanel, BorderLayout.NORTH);
        CaliPanel.add(CaliBottemPanel, BorderLayout.SOUTH);
        
        TextAction aTextAction = new TextAction();
        jText5.addActionListener(aTextAction);
        jText6.addActionListener(aTextAction);
        jText7.addActionListener(aTextAction);
        
        this.add(CaliPanel, BorderLayout.CENTER);
        this.add(CoorPanel, BorderLayout.SOUTH);
        this.add(eastColBox, BorderLayout.EAST);

    }
    
    private class TextAction implements ActionListener
    {        
        public void actionPerformed(ActionEvent event)
        {
            jText5.setText(Float.toString(globalVarX));
            jText6.setText(Float.toString(globalVarY));
            jText7.setText(Float.toString(globalVarZ));
            jText1.setText((Float.toString(width/2) + " , " + Float.toString(height/2))); //Center
            jText3.setText(Float.toString(numFingers)); //Number of fingers
            jText2.setText(Float.toString(height)); //Bottem left Corner
            jText4.setText(Float.toString(height));
            if (numFingers == 2){
                //javax.swing.Timer fingerTimer = new javax.swing.Timer(10, new TwoFingerAction());
                //fingerTimer.start();
            }
        }
    }

  /*
    private class SwipeLeft implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            try{
                //throw new InterruptedException();
                try{
                    Thread.sleep(1000);
                    //SwipeGesture swipe = new SwipeGesture(gesture);
                    // Switch to the next desktop depending on the direction of swipe
                    //com.leapmotion.leap.Vector swipeDirection = com.leapmotion.leap.Vector.zero();
                    //swipeDirection = swipe.direction();
                    Runtime rt = Runtime.getRuntime();
                    Process proc = rt.exec("open /Users/me/Developer/p/Swipe_Left.app");
                    int exitVal = proc.exitValue();
                    System.out.println("Process exitValue: " + exitVal);
                    Thread.currentThread().interrupt();
                    //return;
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    */
    //-----------------


    static class LeapListener extends Listener {
        
        public void onInit(Controller controller) {
            System.out.println("Initialized");

        
        //------------------
            SwipeGesture scrollGesture = new SwipeGesture();
            
            try{
                doneCalibrating = false;
                Robot s = new Robot();
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                width = (int)screenSize.getWidth();
                height = (int)screenSize.getHeight();
                s.mouseMove((width/2), (height/2));
            }catch (AWTException e) {
                e.printStackTrace();
            }
        }

        public void onConnect(Controller controller) {
            System.out.println("Connected");
            controller.enableGesture(Gesture.Type.TYPE_SWIPE);
            controller.enableGesture(Gesture.Type.TYPE_CIRCLE);
            controller.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
            controller.enableGesture(Gesture.Type.TYPE_KEY_TAP);
        }
        
        
        public void onDisconnect(Controller controller) {
            System.out.println("Disconnected");
        }
        
        public void onExit(Controller controller) {
            System.out.println("Exited");
        }
        
        public void onFrame(Controller controller) {
            // Get the most recent frame and report some basic information
            com.leapmotion.leap.Frame frame = controller.frame();
            //Parameters for the intersect method
          
            Screen screen = controller.calibratedScreens().get(0);
            
            if (!frame.hands().empty()) {
                // Get the first hand
                Hand hand = frame.hands().get(0);
                
                // Check if the hand has any fingers
                FingerList fingers = hand.fingers();
                if (!fingers.empty()) {
                    
                    numFingers = fingers.count();
                    com.leapmotion.leap.Vector point = hand.pointables().get(0).tipPosition().minus(screen.bottomLeftCorner());
                    
                    com.leapmotion.leap.Vector xAxis = screen.horizontalAxis();
                    com.leapmotion.leap.Vector yAxis = screen.verticalAxis();
                    
                    com.leapmotion.leap.Vector xProj = xAxis.times(xAxis.dot(point)/xAxis.magnitudeSquared());
                    com.leapmotion.leap.Vector yProj = yAxis.times(yAxis.dot(point)/yAxis.magnitudeSquared());
                    
                    
                    com.leapmotion.leap.Vector avgPos = com.leapmotion.leap.Vector.zero();
                    com.leapmotion.leap.Vector pos = com.leapmotion.leap.Vector.zero();
                    com.leapmotion.leap.Vector direction = com.leapmotion.leap.Vector.zero();
                    com.leapmotion.leap.Vector interSection = com.leapmotion.leap.Vector.zero();
                    
                    
                    for (Finger finger : fingers) {
                        avgPos = avgPos.plus(finger.tipPosition());
                        direction = direction.plus(finger.direction());
                    }
                    float xLeap = xProj.magnitude();
                    float yLeap = yProj.magnitude();
                    globalVarX = screen.widthPixels() * xLeap/xAxis.magnitude();
                    globalVarY = screen.heightPixels() - screen.heightPixels() * yLeap/yAxis.magnitude();
                    
                    pos = avgPos.divide(numFingers);
                    globalVarZ = (float)pos.getZ();
                    //System.out.println("The Total for the x is: " +(int)globalVarX);

                }
            }
            
                GestureList gestures = frame.gestures();
                for (int i = 0; i < gestures.count(); i++) {
                    Gesture gesture = gestures.get(i);
                
                    switch (gesture.type()) {
                    
                        case TYPE_SWIPE:
                            if (numFingers == 2){
                                try{
                                    Robot robot = new Robot();
                                    SwipeGesture swipe = new SwipeGesture(gesture);
                                  //  System.out.println("Swipe id: " + swipe.id()
                                  //             + ", " + swipe.state()
                                  //             + ", position: " + swipe.position()
                                  //             + ", direction: " + swipe.direction()
                                  //             + ", speed: " + swipe.speed());
                                    com.leapmotion.leap.Vector swipeDirection = com.leapmotion.leap.Vector.zero();
                                    swipeDirection = swipe.direction();
                                    
                                    float directionSpeed = ((float)swipeDirection.getY());
                                    
                                    // This is to coalculate the scrolling amount
                                    
                                    
                                    robot.mouseWheel((int)directionSpeed);
                                    System.out.println((int)directionSpeed);
                                }catch (AWTException e) {
                                    e.printStackTrace();
                                }
                            }
                            if (numFingers == 4){
                                try{
                                    //throw new InterruptedException();
                                    try{
                                        Thread.sleep(1000);
                                        System.out.println("Lets try and go to the next Screen");
                                        SwipeGesture swipe = new SwipeGesture(gesture);
                                        //Switch to the next desktop depending on the direction of swipe
                                        com.leapmotion.leap.Vector swipeDirection = com.leapmotion.leap.Vector.zero();
                                        swipeDirection = swipe.direction();
                                        Runtime rt = Runtime.getRuntime();
                                        Process proc = rt.exec("open /Users/me/Developer/p/Swipe_Left.app");
                                        int exitVal = proc.exitValue();
                                        System.out.println("Process exitValue: " + exitVal);
                                       // Thread.currentThread().interrupt();
                                        //return;
                                    }catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            break;
                        case TYPE_SCREEN_TAP:
                            try{
                                Robot robot = new Robot();
                                
                                ScreenTapGesture screenTap = new ScreenTapGesture(gesture);
                               // System.out.println("Screen Tap id: " + screenTap.id()
                               //                + ", " + screenTap.state()
                               //                + ", position: " + screenTap.position()
                               //                + ", direction: " + screenTap.direction());
                                    
                                //if(screenTap.state() == Leap.Gesture.STATE_START){
                                
                                    robot.mousePress( InputEvent.BUTTON1_MASK );
                                
                               // else{
                                    robot.mouseRelease( InputEvent.BUTTON1_MASK );//}
                                
                            }catch (AWTException e) {
                                e.printStackTrace();
                            }
                            break;
                       /* case TYPE_KEY_TAP:
                            KeyTapGesture keyTap = new KeyTapGesture(gesture);
                            System.out.println("Key Tap id: " + keyTap.id()
                                               + ", " + keyTap.state()
                                               + ", position: " + keyTap.position()
                                               + ", direction: " + keyTap.direction());
                            break;*/
                        default:
                           // System.out.println("Unknown gesture type.");
                            break;
                    }
                
                if (!frame.hands().empty() || !gestures.empty()) {
                    System.out.println();
                }
            }
        }
    }
    
    


    class CursorMover implements ActionListener
    {
        public void actionPerformed(ActionEvent event){
            try{

                Robot r = new Robot();
               // System.out.println(globalVarX);/
                int tempDistFromX = (int)globalVarX - ((int)displayWidth/2);
                int tempDistFromY = (int)globalVarY - ((int)displayHeight/2);
                r.mouseMove((int)globalVarX, ((int)globalVarY));
                
            }catch (AWTException e) {
                e.printStackTrace();
            }
        }
    }
        
    




// data fields for BlockHead1Panel
    public static int globalVarCheckX;
    public static int globalVarCheckY;
    public static int width;
    public static int height;
    public static final int DELAY = 1000;
    
    public static boolean doneCalibrating;
    
    private static float globalVarX;
    private static float globalVarY;
    private static float globalVarZ;
    private static float globalVarFX;
    private static float globalVarFY;
    private static int numFingers;
    
    private int displayWidth;
    private int displayHeight;
    
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabelWaste1;
    private javax.swing.JLabel jLabelWaste2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextField jText1;
    private javax.swing.JTextField jText2;
    private javax.swing.JTextField jText3;
    private javax.swing.JTextField jText4;
    private javax.swing.JTextField jText5;
    private javax.swing.JTextField jText6;
    private javax.swing.JTextField jText7;
    private javax.swing.JTextField jText8;
    // End of variables declaration
    
    

}









