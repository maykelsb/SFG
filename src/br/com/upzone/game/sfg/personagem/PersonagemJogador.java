/*
 *
 * @author Maykel "Gardner" dos Santos braz <maykelsb@yahoo.com.br>
 */
package br.com.upzone.game.sfg.personagem;

import br.com.upzone.gjme.personagem.IPersonagemControlavel;
import br.com.upzone.gjme.personagem.Personagem;

import br.com.upzone.gjme.personagem.estado.Estado;

import java.io.IOException;
import javax.microedition.lcdui.Image;

/*
 *
 * @author Maykel "Gardner" dos Santos braz <maykelsb@yahoo.com.br>
 */
public class PersonagemJogador extends Personagem implements IPersonagemControlavel {

  public final static int ANDANDO = 1;
  public final static int VIRANDO = 2;

  public PersonagemJogador() throws IOException {
    super(Image.createImage("/SpriteSheets/guile.png"), 48, 50, 10, 100);
    this.addEstado(Personagem.PARADO,
            new Estado(this, Personagem.PARADO, 0, 5) {
      public void finalizaEstado() { }
      public void iniciaEstado() { }
      public void processarInput(int iKeyState) { }
    });
    this.setEstadoDefault(PARADO);

    this.addEstado(PersonagemJogador.ANDANDO,
            new Estado(this, PersonagemJogador.ANDANDO, 7, 11) {
      public void finalizaEstado() { }
      public void iniciaEstado() {
        if (this.personagem.getUltimaDirecao() != this.personagem.getDirecaoAtual()) {
          this.personagem.getEstado(PersonagemJogador.VIRANDO).setPosEstado(
                  PersonagemJogador.VIRANDO);
          this.personagem.setEstado(PersonagemJogador.VIRANDO);
        } else {
          this.setStatus(Estado.EM_EXECUCAO);
        }
      }
      public void processarInput(int iKeyState) { }
    });
  }

  public void processarInput(int iKeyState) {
    ((Estado)this.hstEstados.get(
            new Integer(this.iEstadoAtual))).processarInput(iKeyState);
  }
}