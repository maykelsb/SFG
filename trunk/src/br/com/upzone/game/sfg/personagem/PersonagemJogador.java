/*
 *
 * @author Maykel "Gardner" dos Santos braz <maykelsb@yahoo.com.br>
 */
package br.com.upzone.game.sfg.personagem;

import br.com.upzone.gjme.personagem.IPersonagemControlavel;
import br.com.upzone.gjme.personagem.Personagem;

import java.io.IOException;
import javax.microedition.lcdui.Image;

/*
 *
 * @author Maykel "Gardner" dos Santos braz <maykelsb@yahoo.com.br>
 */
public class PersonagemJogador extends Personagem implements IPersonagemControlavel {

  public PersonagemJogador() throws IOException {
    super(Image.createImage("/SpriteSheets/guile.png"), 48, 50, 10, 100);
  }

  public void processarInput(int iKeyState) {
    
  }
}
