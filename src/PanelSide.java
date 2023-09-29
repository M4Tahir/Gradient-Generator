import javax.swing.*;
import java.awt.*;

public class PanelSide extends JPanel {
    JButton openFileChooser, generate, openFileChooser2;
    int red, blue, green, red2, blue2, green2;

    PanelSide() {
        this.setLayout(null);
        this.setBackground(new Color(0x0F3F6E));
        this.setBounds(0, 0, 300, 700);

        openFileChooser = new JButton("Choose a color");
        openFileChooser.setFocusable(false);
        openFileChooser.setBounds(20, 500, 130, 30);
        openFileChooser.setBackground(new Color(0x2F2F2F));
        openFileChooser.setForeground(Color.white);
        openFileChooser.addActionListener(e -> {
            Color selectedColor1 = JColorChooser.showDialog(null, "Choose a color", null);
            if (selectedColor1 != null) {
                this.red = selectedColor1.getRed();
                this.blue = selectedColor1.getBlue();
                this.green = selectedColor1.getGreen();
                System.out.printf("%d  %d  %d\n", red2, green2, blue2); // for testing
            }
        });

        openFileChooser2 = new JButton("Choose a color");
        openFileChooser2.setBounds(150, 500, 130, 30);
        openFileChooser2.setFocusable(false);
        openFileChooser2.setBackground(new Color(0x2F2F2F));
        openFileChooser2.setForeground(Color.white);
        openFileChooser2.addActionListener(e -> {
            Color selectedColor2 = JColorChooser.showDialog(null, "Choose a color", null);
            if (selectedColor2 != null) {
                this.red2 = selectedColor2.getRed();
                this.blue2 = selectedColor2.getBlue();
                this.green2 = selectedColor2.getGreen();
                System.out.printf("%d  %d  %d\n", red, green, blue); // test
            }
        });

        generate = new JButton("Generate");
        generate.setBounds(90, 540, 130, 30);
        generate.setFocusable(false);
        generate.setBackground(new Color(0x2F2F2F));
        generate.setForeground(Color.white);
        generate.addActionListener(e -> {
            PanelDisplay p = (PanelDisplay) getParent().getComponent(1); // Get the PanelDisplay which is added after panelside at index 1 , the getparent will call the JFrame and look for the componenet at index 1 and then cast it as penelDisplay and then using that object we can update out panel
            // here getparent() -> will get the frame and get the second componenet out of the frame as first we have added panelSide and then we have added panelDisplay so there we have wrote componenet(1)
//            PanelDisplay p = new PanelDisplay();    // the only line due to which the code don't work becase here we are creating new instance of the class as when we call the main then the paneldisplay is alred added to the frame when the code is reached here then the new instace is created and it's not being added to the fram so the frame reting it's black(setted color) that's is why it's not working
//            PanelDisplay p = (PanelDisplay) getParent().getComponent(0); // Get the PanelDisplay make sure that we have added the panelDisplay as first component before panelside
            p.Display(red, green, blue, red2, green2, blue2);
        });
        /*
        getParent(): This method is used to access the parent container, which is your JFrame in this case. It's like saying, "I want to go up to the bigger container that holds everything."
        .getComponent(1): After you've gone up to the parent (JFrame), you are asking it to give you the component at index 1. In your case, this is the second component added to the JFrame. It's like saying, "Give me the second thing inside the big container."
        (PanelDisplay): Once you've got that second thing (which is a PanelDisplay in your code), you are telling Java to treat it as a PanelDisplay specifically. This allows you to use the methods and properties of the PanelDisplay class on this object.
        So, your code snippet essentially navigates up to the JFrame, gets the second component (which is the PanelDisplay), and then lets you work with it as if it's a PanelDisplay. This way, you can update the PanelDisplay component that was added to your JFrame earlier in your code.
         */

        this.add(openFileChooser);
        this.add(openFileChooser2);
        this.add(generate);
    }
}
/*
In Java Swing and similar GUI frameworks, components like panels, buttons, and labels are added to a container in a specific order, and this order determines their position within the container. The order starts at 0 for the first component added and increments by 1 for each subsequent component.
this.add(new PanelSide());
this.add(new PanelDisplay());
You are adding two components to the Main frame. When you add new PanelSide(), it becomes the first component, so it is at component(0). When you add new PanelDisplay(), it becomes the second component, so it is at component(1).
So, when you use getComponent(0), you would be accessing the first component (PanelSide) in your frame, and when you use getComponent(1), you are accessing the second component (PanelDisplay).
In your case, it makes sense to access getComponent(1) because you want to work with the PanelDisplay that you added as the second component to change its colors and repaint it. If you were interested in the first component (PanelSide), you would use getComponent(0) to access it.
 */