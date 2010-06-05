/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.upzone.game.sfg.tela.game;

import br.com.upzone.game.sfg.personagem.SFG_Guile;
import br.com.upzone.gjme.personagem.GjME_Personagem;
import br.com.upzone.gjme.layer.GjME_TiledLayer;
import br.com.upzone.gjme.tela.GjME_Tela;

import java.io.IOException;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.TiledLayer;

/**
 *
 * @author Maykel "Gardner" dos Santos Braz <maykelsb@yahoo.com.br>
 */
public class SFG_Fase01 extends GjME_Tela {

  /**
   * Matrix de configuração dos tiles que serão utilizados para construir a tiled layer desta fase do games
   */
  private int[][] iarTiles = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                              {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                              {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                              {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                              {1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                              {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                              {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1},
                              {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0},
                              {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                              {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                              {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                              {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
                              {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}};

  private SFG_Guile prgm;

  protected TiledLayer tlayer = null;

  public SFG_Fase01() {
    super();
    // -- Carregando as tiledlayers
    try {
      this.tlayer = new GjME_TiledLayer(iarTiles, Image.createImage("/fase01/tileset/tileset.png"), 16, 16);
      this.lm.append(this.tlayer);
      this.tlayer.setPosition(0, 12);
    } catch (IOException ioex) {
      System.out.println("Não foi possível criar a fase solicitada. Motivo: " + ioex.getMessage());
    }
    // -- Carregando o persoangem
    try {
      this.prgm = new SFG_Guile();
      this.lm.append(this.prgm);
    } catch (Exception ioex) {
      System.out.println("Não foi possível criar o personagem solicitado. Motivo: " + ioex.getMessage());
    }
  }

  /**
   * Processando os comandos da tela atual.
   */
  public void processarInput() {
    this.prgm.processarInput(this.getKeyStates(), this.lm);
  }
}
