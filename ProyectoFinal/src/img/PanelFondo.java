package img;

import javax.swing.*;
import java.awt.*;

public class PanelFondo extends JPanel {

    private Image imagen;

    public PanelFondo(String ruta) {
        ImageIcon icon = new ImageIcon(getClass().getResource(ruta));
        imagen = icon.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (imagen != null) {
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            int imgWidth = imagen.getWidth(this);
            int imgHeight = imagen.getHeight(this);

            // Mantener proporción
            double scale = Math.min(
                    (double) panelWidth / imgWidth,
                    (double) panelHeight / imgHeight
            );

            int width = (int) (imgWidth * scale);
            int height = (int) (imgHeight * scale);

            int x = (panelWidth - width) / 2;
            int y = (panelHeight - height) / 2;

            g.drawImage(imagen, x, y, width, height, this);
        }
    }
}
