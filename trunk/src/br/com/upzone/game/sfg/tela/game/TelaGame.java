/*
 *
 * @author Maykel "Gardner" dos Santos braz <maykelsb@yahoo.com.br>
 */
package br.com.upzone.game.sfg.tela.game;

import br.com.upzone.game.sfg.personagem.PersonagemJogador;
import br.com.upzone.gjme.personagem.Personagem;
import br.com.upzone.gjme.tela.Tela;

import java.io.IOException;

/*
 *
 * @author Maykel "Gardner" dos Santos braz <maykelsb@yahoo.com.br>
 */
public class TelaGame extends Tela {

  Personagem personagemjogador;

  public TelaGame() {
    try {
      this.personagemjogador = new PersonagemJogador();
      this.layermanager.append(this.personagemjogador);
    } catch (IOException ioex) {
      System.out.println(ioex.getMessage());
    }
  }

  public void processarInput() {
    this.personagemjogador.nextFrame();
  }
}
