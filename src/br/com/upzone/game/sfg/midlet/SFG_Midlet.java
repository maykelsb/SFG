/*
 *
 * @author Maykel "Gardner" dos Santos braz <maykelsb@yahoo.com.br>
 */
package br.com.upzone.game.sfg.midlet;

import br.com.upzone.gjme.tela.GjME_Tela;

import br.com.upzone.game.sfg.tela.game.GjME_TelaGame;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

/*
 *
 * @author Maykel "Gardner" dos Santos braz <maykelsb@yahoo.com.br>
 */
public class SFG_Midlet extends MIDlet {

  private GjME_Tela tela;
  private Display display;

  public void startApp() {
    try {
      this.display = Display.getDisplay(this);
      this.tela = new GjME_TelaGame();
      this.tela.start();
      this.display.setCurrent(this.tela);
    } catch (Exception ex) {
      System.out.println(ex.getMessage() + "Eita!!!");
    }
  }

  public void destroyApp(boolean unconditional) { }
  public void pauseApp() { }
}