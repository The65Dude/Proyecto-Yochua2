package Vistas;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import prueba.main;

/**
 * @author Marco Zumbado Solorzano carne C18736
 * @date 2021-08-16
 * @time 10:13:20
 */
public class AnimationFrame extends JFrame implements Runnable {

    private AnimationPanel panel;
    ArrayList<Image> images;

    public AnimationFrame() {
        panel = new AnimationPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        panel.initialize();
        this.images = panel.getImages();
    }

    @Override
    public void run() {
        synchronized (images) {
            while (images.size() != 50) {
                images.add(new ImageIcon("cliente.png").getImage());
                images.notifyAll();
                panel.redraw();
            }
            main.controller.getMm().gettCarpa1().start();
            main.controller.getMm().gettCarpa2().start();
            main.controller.getMm().getThread().stop();
        }
    }

    public AnimationPanel getPanel() {
        return panel;
    }

}
