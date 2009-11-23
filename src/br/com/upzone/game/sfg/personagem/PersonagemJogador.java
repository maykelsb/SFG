/*
 *
 * @author Maykel "Gardner" dos Santos braz <maykelsb@yahoo.com.br>
 */
package br.com.upzone.game.sfg.personagem;

import br.com.upzone.gjme.Direcoes;
import br.com.upzone.gjme.personagem.Personagem;
import br.com.upzone.gjme.personagem.IPersonagemControlavel;
import br.com.upzone.gjme.personagem.estado.Estado;

import java.io.IOException;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;

/*
 *
 * @author Maykel "Gardner" dos Santos braz <maykelsb@yahoo.com.br>
 */
public class PersonagemJogador extends Personagem implements IPersonagemControlavel {

  public final static int EST_PERSON_ANDANDO = 1;
  public final static int EST_PERSON_VIRANDO = 2;
  public final static int EST_PERSON_ABAIXANDO = 3;
  public final static int EST_PERSON_PULANDO = 4;
  public final static int EST_PERSON_CORRENDO = 5;
  public final static int EST_PERSON_LEVANTANDO = 6;
  public final static int EST_PERSON_SOCO_FRACO = 7;

  public PersonagemJogador(int iTelaLargura, int iTelaAltura) throws IOException {
    super(Image.createImage("/SpriteSheets/guile.png"), 51, 50, 10, 100,
            iTelaLargura, iTelaAltura, 10);
    this.bRefletirSprite = true;

    // -- Adição do estado PARADO
    this.addEstado(PersonagemJogador.EST_PERSON_PARADO,
      new Estado(this, PersonagemJogador.EST_PERSON_PARADO, 0, 5) {
        public void executeNoEstado() {}});

    // -- Adição do estado ANDANDO
    this.addEstado(PersonagemJogador.EST_PERSON_ANDANDO,
      new Estado(this, PersonagemJogador.EST_PERSON_ANDANDO, 7, 11) {
        public void executeNoEstado() {
          this.personagem.deslocarNaHorizontal();
        }});

    // -- Adição do estado VIRANDO
    this.addEstado(PersonagemJogador.EST_PERSON_VIRANDO,
      new Estado(this, PersonagemJogador.EST_PERSON_VIRANDO, 6, 6) {
        public void executeNoEstado() {}});

    // -- Adição do estado ABAIXANDO
    this.addEstado(PersonagemJogador.EST_PERSON_ABAIXANDO,
      new Estado(this, PersonagemJogador.EST_PERSON_ABAIXANDO, 12, 13) {
        public void executeNoEstado() { }
      }.defineContinuidade(Estado.TIP_EST_NAO_CONTINUO));

    // -- Adição do estado LEVANTANDO
    this.addEstado(PersonagemJogador.EST_PERSON_LEVANTANDO,
      new Estado(this, PersonagemJogador.EST_PERSON_LEVANTANDO, 12, 12) {
        public void executeNoEstado() { }
      }.defineContinuidade(Estado.TIP_EST_NAO_CONTINUO)
       .setPosEstado(PersonagemJogador.EST_PERSON_PARADO));

    // -- Adição do estado PULANDO
    this.addEstado(PersonagemJogador.EST_PERSON_PULANDO,
      new Estado(this, PersonagemJogador.EST_PERSON_PULANDO, new int[] {12, 21, 21, 22, 22, 22, 22, 21, 21, 12}) {
        public void executeNoEstado() {
          this.personagem.deslocarNaVertical();
        }
    }.defineContinuidade(Estado.TIP_EST_NAO_CONTINUO)
     .setPosEstado(PersonagemJogador.EST_PERSON_PARADO));

    // -- Adição do estado CORRENDO
    this.addEstado(PersonagemJogador.EST_PERSON_CORRENDO,
      new Estado(this, PersonagemJogador.EST_PERSON_CORRENDO, new int[] {14, 15, 16, 17}) {
        public void executeNoEstado() {
          this.personagem.deslocarNaHorizontal(5);
        }
    });

    // -- Adição do estado SOCO_FRACO
    this.addEstado(PersonagemJogador.EST_PERSON_SOCO_FRACO,
      new Estado(this, PersonagemJogador.EST_PERSON_SOCO_FRACO, new int[] {2, 23, 24, 23}) {
        public void executeNoEstado() {}
    }.defineContinuidade(Estado.TIP_EST_NAO_CONTINUO)
     .setPosEstado(PersonagemJogador.EST_PERSON_PARADO));

    // -- Definindo o Estado inicial
    this.setEstado(PersonagemJogador.EST_PERSON_PARADO);
  }

  public void processarInput(int iKeyState) {
    if (this.iEstadoAtual == PersonagemJogador.EST_PERSON_PULANDO) {
      
    } else if (this.iEstadoAtual == PersonagemJogador.EST_PERSON_SOCO_FRACO) {

    } else {
      if ((iKeyState & GameCanvas.LEFT_PRESSED) != 0) {
        this.setEstado(PersonagemJogador.EST_PERSON_ANDANDO);
        this.setDirecaoPersonagem(Direcoes.ESQUERDA);
      } else if ((iKeyState & GameCanvas.DOWN_PRESSED) != 0) {
        this.setEstado(PersonagemJogador.EST_PERSON_ABAIXANDO);
      } else if ((iKeyState & GameCanvas.UP_PRESSED) != 0) {
        this.setEstado(PersonagemJogador.EST_PERSON_PULANDO);
      } else if ((iKeyState & GameCanvas.RIGHT_PRESSED) != 0) {
        this.setEstado(PersonagemJogador.EST_PERSON_CORRENDO);
        this.setDirecaoPersonagem(Direcoes.DIREITA);
      } else if ((iKeyState & GameCanvas.FIRE_PRESSED) != 0) {
        this.setEstado(PersonagemJogador.EST_PERSON_SOCO_FRACO);
      } else {
        this.setEstado(PersonagemJogador.EST_PERSON_PARADO);
      }
    }
    this.estadoAtual.executeNoEstado();
  }

  public void deslocarNaVertical() {
    switch (this.getFrame()) {
      case 1: case 2: case 3: case 4:
        this.setPosition(this.getX(), (this.getY() - 10));
        break;
      case 5: case 6: case 7: case 8:
        this.setPosition(this.getX(), (this.getY() + 10));
        break;
      }
  }
}