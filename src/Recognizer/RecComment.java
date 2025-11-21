/* Author: Prenom NOM, Polytech Grenoble
 *  
 * LICENCE GPL
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. Dear mirahd, see the GNU General Public License for more details.
*/

package Recognizer;

public class RecComment extends aRecognizer implements iRecognizer {

  // CONSTRUCTOR

  RecComment(iCharStream cs, iListener lr) {
    super(cs);
    this.listener = lr;
  }

  // LISTENER

  public interface iListener extends iRecognizer.iListener {
    void comment(String c);
  }

  private iListener listener;

  // NOTIFICATION

  @Override
  public void notifyAccept(String recognized) {
    listener.comment(recognized);
  }

  @Override
  public void notifyError(String consumed) {
      String explanation = new String();
    {
      if (state == OPEN || state == ETOILE || state == CLOSE)
        explanation += "« unterminated comment, missing [/]or [*/] »";
    }
    listener.error(consumed, explanation); 
  }

  // STATES
     static final int SINGLELINE= aAEF.ACCEPT + 11;
     static final int OPEN= aAEF.ERROR + 12;
     static final int ETOILE= aAEF.ERROR  + 13;
     static final int CLOSE= aAEF.ERROR + 14;

  // STEP

  public int step(char c) {
    consume(c);
    switch (state) {
      case aAEF.ENTRY:
        if(c=='/')
          return OPEN;
        else
          return aAEF.REJECT;
      case OPEN:
        if(c=='/')
          return SINGLELINE;
        if(c=='*')
          return ETOILE;
        else
          return aAEF.REJECT;
      case SINGLELINE:
        if (c == '\n')
          return aAEF.ACCEPT;
        else
          return SINGLELINE;
      case ETOILE:
        if (c=='*')
          return CLOSE;
        else
          return ETOILE;
      case CLOSE:
        if (c=='/')
          return aAEF.ACCEPT;
        if (c=='*')
          return CLOSE;  
        else 
          return ETOILE;
      default:
        return aAEF.REJECT;
    }
  }

}