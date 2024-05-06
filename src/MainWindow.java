import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class MainWindow extends JFrame {

    int posX = 0;
    int posY = 0;
    JLabel sasha = null;
    public MainWindow(){
        super("probaTest");
        super.setDefaultCloseOperation(MainWindow.EXIT_ON_CLOSE);
        super.setBounds(posX, posY, 650, 510);
        super.setLayout(null);
        super.setResizable(false);
        super.setLocationRelativeTo(null);
        this.sasha = sasha;
//        int posX = 0;
//        int posY = 0;
        try {
            sasha = new JLabel(new ImageIcon(ImageIO.read(new File("sasha.jpg"))));
            sasha.setBounds(0, 0, 100, 75);
            sasha.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.add(sasha);


        Thread threadX = new Thread(new Runnable() {
            @Override
            public void run() {


        while (true){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            int randomX = (int) ((Math.random() * 10) + 2);

            System.out.println(randomX);
//            posX = - 50;
//            posY = -75;
            while (posX <= 550){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                posX = posX + randomX;
                setPositions(posX, posY);
//                sasha.setBounds(posX, posY, 200, 200);
            }
            while (posX >= 0){
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                posX = posX - randomX;
                setPositions(posX, posY);
//                sasha.setBounds(posX, posY, 200, 200);
            }

        }
        }
            });
        threadX.start();

        Thread threadY = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    int randomY = (int) ((Math.random() * 10) + 2);

                    System.out.println(randomY);
//                    int posX = - 50;
//                    int posY = -75;
                    while (posY <= 410){
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        posY = posY + randomY;
                        setPositions(posX, posY);
//                        finalSasha.setBounds(posX, posY, 200, 200);
                    }
                    while (posY >= 0){
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        posY = posY - randomY;
                        setPositions(posX, posY);
//                        finalSasha.setBounds(posX, posY, 200, 200);
                    }

                }
            }
        });
            threadY.start();
    }
    public synchronized void setPositions(int x, int y){
        sasha.setBounds(x, y, 100, 75);
    }
}
