/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.upzone.game.sfg.tela.game;

import br.com.upzone.gjme.layer.GjME_TiledLayer;
import br.com.upzone.gjme.tela.GjME_Tela;

import java.io.IOException;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.TiledLayer;

/**
 *
 * @author Gardner
 */
public class SFG_Fase01 extends GjME_Tela {

  /**
   * Matrix de configuração dos tiles que serão utilizados para construir a tiled layer desta fase do games
   */
  private int[][] iarTiles = {{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                              {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
                              {1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                              {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}};

  protected TiledLayer tlayer = null;



  public SFG_Fase01() {
    super();
    try {
      this.tlayer = new GjME_TiledLayer(iarTiles, Image.createImage("/fase01/tileset/tileset.png"), 16, 16);
      this.lm.append(this.tlayer);
      this.tlayer.setPosition(0, 12);
    } catch (IOException ioex) {
      System.out.println("Não foi possível criar a fase solicitada. Motivo: " + ioex.getMessage());
    }
  }

  public void processarInput() {
    int iKeyState = this.getKeyStates();
    if ((iKeyState & GameCanvas.LEFT_PRESSED) != 0) {
      this.tlayer.setPosition((this.tlayer.getX() + 5), this.tlayer.getY());
    } else if ((iKeyState & GameCanvas.RIGHT_PRESSED) != 0) {
      this.tlayer.setPosition((this.tlayer.getX() - 5), this.tlayer.getY());
    }
  }


}
