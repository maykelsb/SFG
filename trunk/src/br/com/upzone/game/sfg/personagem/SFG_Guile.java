/*
 *
 * @author Maykel "Gardner" dos Santos braz <maykelsb@yahoo.com.br>
 */
package br.com.upzone.game.sfg.personagem;

import br.com.upzone.gjme.GjME_Fisica;
import br.com.upzone.gjme.personagem.GjME_Personagem;
import br.com.upzone.gjme.personagem.GjME_IPersonagemControlavel;
import br.com.upzone.gjme.personagem.acao.GjME_Acao;

import java.io.IOException;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;

/*
 *
 * @author Maykel "Gardner" dos Santos braz <maykelsb@yahoo.com.br>
 */
public class SFG_Guile extends GjME_Personagem
                       implements GjME_IPersonagemControlavel {

  public final static int ACAO_ANDAR = 1;
  public final static int ACAO_VIRAR = 2;
  public final static int EST_PERSON_ABAIXANDO = 3;
  public final static int EST_PERSON_PULANDO = 4;
  public final static int EST_PERSON_CORRENDO = 5;
  public final static int EST_PERSON_LEVANTANDO = 6;
  public final static int EST_PERSON_SOCO_FRACO = 7;

  public SFG_Guile() throws IOException {
    super(Image.createImage("/SpriteSheets/guile.png"), 51, 50, 10, 100, 170, 120);
    this.bRefletirSprite = true;

    // -- Ações do personagem --------------------------------------------------
    this.adicionarAcao(SFG_Guile.ACAO_AGUARDAR,
      new GjME_Acao(0, 5) {
        public void executar(GjME_Personagem prg) { }
    });
    this.adicionarAcao(SFG_Guile.ACAO_ANDAR,
      new GjME_Acao(7, 11) {
        public void executar(GjME_Personagem prg) { }
      });
    this.adicionarAcao(SFG_Guile.ACAO_VIRAR,
      new GjME_Acao(6, 6) {
        public void executar(GjME_Personagem prg) { }
      }.defineTipoAnimacao(GjME_Acao.ANIMACAO_NAO_CONTINUA));

/*

    // -- Adição do estado ABAIXANDO
    this.addEstado(SFG_PersonagemJogador.EST_PERSON_ABAIXANDO,
      new GjME_Estado(this, SFG_PersonagemJogador.EST_PERSON_ABAIXANDO, 12, 13) {
        public void executeNoEstado() { }
      }.defineContinuidade(GjME_Estado.TIP_EST_NAO_CONTINUO));

    // -- Adição do estado LEVANTANDO
    this.addEstado(SFG_PersonagemJogador.EST_PERSON_LEVANTANDO,
      new GjME_Estado(this, SFG_PersonagemJogador.EST_PERSON_LEVANTANDO, 12, 12) {
        public void executeNoEstado() { }
      }.defineContinuidade(GjME_Estado.TIP_EST_NAO_CONTINUO)
       .setPosEstado(SFG_PersonagemJogador.EST_PERSON_PARADO));

    // -- Adição do estado PULANDO
/*    this.addEstado(SFG_PersonagemJogador.EST_PERSON_PULANDO,
      new GjME_Estado(this, SFG_PersonagemJogador.EST_PERSON_PULANDO, new int[] {12, 21, 21, 22, 22, 22, 22, 21, 21, 12}) {
        public void executeNoEstado() {
          this.personagem.deslocarNaVertical();
        }
    }.defineContinuidade(GjME_Estado.TIP_EST_NAO_CONTINUO)
     .setPosEstado(SFG_PersonagemJogador.EST_PERSON_PARADO));

    // -- Adição do estado CORRENDO
/*    this.addEstado(SFG_PersonagemJogador.EST_PERSON_CORRENDO,
      new GjME_Estado(this, SFG_PersonagemJogador.EST_PERSON_CORRENDO, new int[] {14, 15, 16, 17}) {
        public void executeNoEstado() {
          this.personagem.deslocarNaHorizontal(5);
        }
    });*/

  /*
            // -- Adição do estado SOCO_FRACO
    this.addEstado(SFG_PersonagemJogador.EST_PERSON_SOCO_FRACO,
      new GjME_Estado(this, SFG_PersonagemJogador.EST_PERSON_SOCO_FRACO, new int[] {2, 23, 24, 23}) {
        public void executeNoEstado() {}
    }.defineContinuidade(GjME_Estado.TIP_EST_NAO_CONTINUO)
     .setPosEstado(SFG_PersonagemJogador.EST_PERSON_PARADO));/*/

    // -- Definindo o Estado inicial
    this.empilharAcao(SFG_Guile.ACAO_AGUARDAR);
  }

  public void processarInput(int iKeyState, LayerManager lm) {
    switch (((GjME_Acao)this.stkAcoes.peek()).retornaIDAcao()) {
      case SFG_Guile.ACAO_AGUARDAR:
      case SFG_Guile.ACAO_ANDAR:
        if ((iKeyState & GameCanvas.RIGHT_PRESSED) != 0) {
          this.empilharAcao(SFG_Guile.ACAO_ANDAR);
          this.andar(GjME_Fisica.DIREITA);
        } else if ((iKeyState & GameCanvas.LEFT_PRESSED) != 0) {
          this.empilharAcao(SFG_Guile.ACAO_ANDAR);
          this.andar(GjME_Fisica.ESQUERDA);
        } else { this.desempilharAcoes(); }
        break;
      default: this.desempilharAcoes();
    }
    ((GjME_Acao)this.stkAcoes.peek()).executar(this);
/*
    if (this.iEstadoAtual == SFG_PersonagemJogador.EST_PERSON_PULANDO) {
      
    } else if (this.iEstadoAtual == SFG_PersonagemJogador.EST_PERSON_SOCO_FRACO) {

    } else {
      if ((iKeyState & GameCanvas.LEFT_PRESSED) != 0) {
        this.setEstado(SFG_PersonagemJogador.EST_PERSON_ANDANDO);
        this.setDirecaoPersonagem(GjME_Fisica.ESQUERDA);
      } else if ((iKeyState & GameCanvas.DOWN_PRESSED) != 0) {
        this.setEstado(SFG_PersonagemJogador.EST_PERSON_ABAIXANDO);
      } else if ((iKeyState & GameCanvas.UP_PRESSED) != 0) {
        this.setEstado(SFG_PersonagemJogador.EST_PERSON_PULANDO);
      } else if ((iKeyState & GameCanvas.RIGHT_PRESSED) != 0) {
        this.setEstado(SFG_PersonagemJogador.EST_PERSON_CORRENDO);
        this.setDirecaoPersonagem(GjME_Fisica.DIREITA);
      } else if ((iKeyState & GameCanvas.FIRE_PRESSED) != 0) {
        this.setEstado(SFG_PersonagemJogador.EST_PERSON_SOCO_FRACO);
      } else {
        this.setEstado(SFG_PersonagemJogador.EST_PERSON_PARADO);
      }
    }
    this.estadoAtual.executeNoEstado();*/
  }

  private void andar(int direcao) {
    if (GjME_Fisica.DIREITA == direcao) {
      if (GjME_Fisica.ESQUERDA == this.direcaoPersonagem) {
        this.direcaoPersonagem(GjME_Fisica.DIREITA);
      }
      this.iVelX = GjME_Fisica.VELOCIDADE_MEDIA;
    } else if (GjME_Fisica.ESQUERDA == direcao) {
      if (GjME_Fisica.DIREITA == this.direcaoPersonagem) {
        this.direcaoPersonagem(GjME_Fisica.ESQUERDA);
      }
      this.iVelX = -GjME_Fisica.VELOCIDADE_MEDIA;
    }
    if (SFG_Guile.ACAO_ANDAR != ((GjME_Acao)this.stkAcoes.peek()).retornaIDAcao()){
      this.desempilharAcoes();
    }
  }
}