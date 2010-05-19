/*
 *
 * @author Maykel "Gardner" dos Santos braz <maykelsb@yahoo.com.br>
 */
package br.com.upzone.game.sfg.tela.game;

import br.com.upzone.game.sfg.personagem.SFG_PersonagemJogador;

import br.com.upzone.gjme.personagem.GjME_IPersonagemControlavel;
import br.com.upzone.gjme.personagem.GjME_Personagem;

import br.com.upzone.gjme.tela.GjME_Tela;

import java.io.IOException;

/*
 *
 * @author Maykel "Gardner" dos Santos braz <maykelsb@yahoo.com.br>
 */
public class SFG_TelaGame extends GjME_Tela {

  GjME_Personagem personagemjogador;

  public SFG_TelaGame() {
    try {
      this.personagemjogador = new SFG_PersonagemJogador(this.getWidth(), this.getHeight());
      this.layermanager.append(this.personagemjogador);
    } catch (IOException ioex) {
      System.out.println(ioex.getMessage());
    }
  }

  public void processarInput() {
    int iKeyState = this.getKeyStates();
    ((GjME_IPersonagemControlavel)this.personagemjogador).processarInput(iKeyState);
    this.personagemjogador.nextFrame();
  }
}
