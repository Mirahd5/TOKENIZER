/* Author: Prenom NOM, Polytech Grenoble
 *  
 * LICENCE GPL
 * 
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. Dear mirahd, see the GNU General Public License for more details.
*/

package Recognizer;

public class RecIdent extends aRecognizer implements iRecognizer {

  // CONSTRUCTOR

  RecIdent(iCharStream cs, iListener lr) {
    super(cs);
    this.listener = lr;
  }

  // LISTENER

  public interface iListener extends iRecognizer.iListener {
    void ident(String c);
    void keyword(String c);
    void type(String c);
  }

  private iListener listener;
/*
  // NOTIFICATION
  @Override
  public void notifyAccept(String recognized) {
    switch (recognized) {
      case "if":
      case "then":
      case "else":
      case "return":
      case "break":
      case "case":
      case "default":
        listener.keyword(recognized);
        break;
      case "Recognizer":
      case "RecABC":
      case "RecIdent":
      case "RecComment":
      case "RecCommand":
      case "RecString":
      case "Tokenizer":
      case "String":
      case "Object":
      case "Float":
      case "Boolean":
      case "Double":
      case "Class":
      case "Exception":
          listener.type(recognized);
        break;
      default:
        listener.ident(recognized);
    }
  }*/
  @Override
  public void notifyAccept(String recognized) {
    if ('A'<=recognized.charAt(0) && recognized.charAt(0)<='Z'){
      listener.type(recognized);
      return;
    }
    switch (recognized) {
      case "if":
      case "then":
      case "else":
      case "return":
      case "break":
      case "case":
      case "default":
      case "for":
      case "while":
        listener.keyword(recognized);
        break;
      default:
        listener.ident(recognized);
    }
  }

  @Override
  public void notifyError(String consumed) {
  }

  // STATES
  static final int A = aAEF.ACCEPT + 10;
  // STEP

  public int step(char c) {
    switch (state) {
      case aAEF.ENTRY:
        if ('0'<=c && c<='9')
          return aAEF.REJECT;
        if (('a'<=c && c<='z')||('A'<=c && c<='Z')||(c=='_')){
          consume(c);
          return A;
        }
        else
          return aAEF.REJECT;
      case A:
        if  (('a'<=c && c<='z')||('A'<=c && c<='Z')||(c=='_')||('0'<=c && c<='9')){
          consume(c);
          return A;
        }
        else {
          return aAEF.ACCEPT;
        }
      default:
        return aAEF.REJECT;
    }
  }

}

