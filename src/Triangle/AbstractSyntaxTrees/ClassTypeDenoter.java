/*
 * @(#)RecordTypeDenoter.java                2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;
import java.util.List;

public class ClassTypeDenoter extends TypeDenoter {

  public ClassTypeDenoter (Identifier className, Identifier superClass ,FieldTypeDenoter fAST, Declaration dAST, SourcePosition thePosition) {
    super (thePosition);
    CN = className;
    SC = superClass;
    fAst = fAST;
    dAst = dAST;
  }

  public Object visit (Visitor v, Object o) {
    return v.visitClassTypeDenoter(this, o);
  }

  public boolean equals (Object obj) {
    if (obj != null && obj instanceof ErrorTypeDenoter)
      return true;
    else if (obj != null && obj instanceof ClassTypeDenoter)
      return this.fAst.equals(((ClassTypeDenoter) obj).fAst);
    else
      return false;
  }

  public Identifier CN;
  public Identifier SC;
  public FieldTypeDenoter fAst;
  public Declaration dAst;
}
