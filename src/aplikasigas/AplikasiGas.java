/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasigas;

import com.adam.view.FormAplikasi;
import javax.swing.SwingUtilities;

/**
 *
 * @author saddam
 */
public class AplikasiGas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final FormAplikasi form = new FormAplikasi();
        form.setLocationRelativeTo(null);
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                form.setVisible(true);
            }
        });
    }

}
